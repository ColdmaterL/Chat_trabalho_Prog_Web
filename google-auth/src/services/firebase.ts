import { initializeApp } from "firebase/app";
import { getAuth } from "firebase/auth"; 

const firebaseConfig = {
  apiKey: "AIzaSyCUbzoSKQ-Bpoc9M9xPWCCgvXMlO8kmU2k",
  authDomain: "auth-yt-8abef.firebaseapp.com",
  projectId: "auth-yt-8abef",
  storageBucket: "auth-yt-8abef.appspot.com",
  messagingSenderId: "215667199528",
  appId: "1:215667199528:web:50f38a79c59d11d733af1d"
};

const app = initializeApp(firebaseConfig);
export const auth = getAuth(app);