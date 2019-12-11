import * as firebase from "firebase/app";
import "firebase/auth";

const app = firebase.initializeApp({
    apiKey: "AIzaSyA_eO1-dBFT9RMx7Vl5Zy__-i8TsRjbWtg",
    authDomain: "sightseesy.firebaseapp.com",
    databaseURL: "https://sightseesy.firebaseio.com",
    projectId: "sightseesy",
    storageBucket: "sightseesy.appspot.com",
    messagingSenderId: "599351595555",
    appId: "1:599351595555:web:db0fd01b042055ef4c9796",
    measurementId: "G-VS0PYZZRZH"
});

export default app;
