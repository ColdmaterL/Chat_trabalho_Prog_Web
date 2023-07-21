(function(){

    const botaoDeLogin = document.querySelector("#login")

    botaoDeLogin.addEventListener("click", (event) => {
        event.preventDefault()
        buscarUsuario()
    })   

})()

async function buscarUsuario(){
    const email = document.querySelector("#email").value
    const senha = document.querySelector("#senha").value

    const url = `http://localhost:8080/usuario/${email}/${senha}`

    try {
        const response = await fetch(url)
        const data = await response.json()
        console.log(data);

        if(data != null){
            sessionStorage.setItem("email", email)
            sessionStorage.setItem("senha", senha)
            window.location.href = "./index.html"
        }

    } catch (error) {
        console.error("Erro na requisição:", error);
    }
}