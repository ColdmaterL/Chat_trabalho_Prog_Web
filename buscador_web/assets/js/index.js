(async function(){

    let email = sessionStorage.getItem("email");
    let senha = sessionStorage.getItem("senha");
    obterConsultasDeUsuario(email, senha)

    const botaoConsultar = document.querySelector("#buscar")

    botaoConsultar.addEventListener("click", (event) => {
        event.preventDefault();
        
        let rand = Math.random();
        let resultado = rand * 1000;
        const numeroInteiroEntre = Math.floor(resultado)
        const resultadoFinal = numeroInteiroEntre + 1
      
        let texto = document.querySelector("#textoConsulta").value
        document.querySelector("#textoConsulta").value += "\nResposta: " + resultadoFinal 
        texto += " - Resposta: " + resultadoFinal

        let chat = {
          texto
        }
        document.querySelector("#textoConsulta").value = ""
        salvarConsulta(email, senha, chat)
      })
    
    
    const botaoLimpar = document.querySelector("#limpar")

    botaoLimpar.addEventListener("click", (event) => {
        event.preventDefault()
        document.querySelector("#textoConsulta").value = ""
    })

})()

async function obterConsultasDeUsuario(email, senha){

    const url = `http://localhost:8080/usuario/${email}/${senha}`

    try {
        const response = await fetch(url)
        const usuario = await response.json()

        if(usuario != null){
           renderizarChats(usuario)
           return await usuario
        }

    } catch (error) {
        console.error("Erro na requisição:", error)
    }
}

function renderizarChats(usuario){
    divHistorico = document.querySelector(".historico-container")

    while(divHistorico.firstChild) {
        divHistorico.removeChild(divHistorico.firstChild);
    }
    
    const divElemento = document.createElement("div")
    divElemento.classList.add("chat")
    divElemento.innerHTML = ""

    for(let i = 0; i < usuario.chats.length; i++){
        const divElemento = document.createElement("div")
        divElemento.classList.add("chat")
        divElemento.innerHTML = usuario.chats[i].texto
        divHistorico.appendChild(divElemento)
    }

}

async function salvarConsulta(email, senha, chat){
    let url, response, usuario, chatAtualizado = false
    usuario = await obterConsultasDeUsuario(email, senha)

    for(let i = 0; i < usuario.chats.length; i++){
        if(usuario.chats[i].id == chat.id){
            usuario.chats[i].texto += "\n " + chat.texto
            chatAtualizado = true
        }
    }

    if(!chatAtualizado){
        try{
            url = `http://localhost:8080/chat`
            response = await fetch(url, {
                method: "POST",
                headers: {
                    "Content-Type": "application/json"
                },
                body: JSON.stringify(chat)
            })
            chat = await response.json()
            usuario.chats.push(chat)
        }
        catch(error){
            console.error("Erro na requisição:", error)
        }
    }

    try{
        url = `http://localhost:8080/usuario`
        response = await fetch(url, {
            method: "POST",
            headers: {
                "Content-Type": "application/json"
            },
            body: JSON.stringify(usuario)
        })
        usuario = await response.json()
    }

    catch(error){
        console.error("Erro na requisição:", error)
    }

    renderizarChats(usuario)

}

