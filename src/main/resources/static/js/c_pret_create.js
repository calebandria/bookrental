class urlInfo {
    constructor(idAdherent, idExemplaire){
        this.idAdherent = idAdherent;
        this.idExemplaire = idExemplaire;
    }

    getIdAdherent(){
        return this.idAdherent;
    }

    setIdAdherent(idAdherent){
        this.idAdherent = idAdherent;
    }

    getIdExemplaire(){
        return this.idExemplaire;
    }

    setIdExemplaire(idExemplaire){
        this.idExemplaire = idExemplaire;
    }

    getUrl(){
        if(!isNaN(parseInt(idAdherent) ) && !isNaN(parseInt(idExemplaire)))
            return `/prets/${parseInt(idAdherent)}/${parseInt(idExemplaire)}/new`

        else 
            return "error"
    }
}

let adherentInfo = document.querySelector(".adherent-info");
let exemplaireInfo = document.querySelector(".exemplaire-info");

let datePret = document.getElementById("datePret")
let dateRemise = document.getElementById("dateRemise")

let pretAdding = document.getElementById("pretAdding")

let idAdherentIn = document.getElementById("idAdherent")
let idExemplaireIn = document.getElementById("idExemplaire")

var idAdherent 
var idExemplaire

let url = new urlInfo(idAdherent, idExemplaire)


let idSelectedAdherent= (event) => {
    if (isNaN(parseInt(event.target.innerText))) {
        if (isNaN(parseInt(event.target.previousElementSibling.innerText))) {
            /* console.log(event.target.previousElementSibling.previousElementSibling.innerText) */
            return event.target.previousElementSibling.previousElementSibling.innerText
        }
        else {
            /* console.log(event.target.previousElementSibling.innerText) */
            return event.target.previousElementSibling.innerText
        }
    }
    else {
        /* console.log(event.target.innerText) */
        return event.target.innerText
    }
}

let idSelectedExemplaire = (event) => {
    if(isNaN(parseInt(event.target.innerText))){
        return event.target.previousElementSibling.innerText
    }

    else {
        return event.target.innerText
    }
}

adherentInfo.addEventListener("click", (event) => {

    idAdherent = idSelectedAdherent(event);
    url.setIdAdherent(idAdherent)
/*     window.location.href = `/prets/${parseInt(idAdherent)}/` */
/*     idAdherentIn.value = parseInt(idAdherent) */
    console.log(url.getUrl())

    if(url.getUrl() !="error") pretAdding.action = url.getUrl()
    // transforming the background color into another color
    Array.from(adherentInfo.children).forEach(element => {
        if (element.classList.contains("selected")) {
            element.classList.remove("selected")
        }
    })

    Array.from(adherentInfo.children).filter(element =>{
        return element.firstChild.innerText === idAdherent
    }).forEach(element => {
        element.classList.add("selected")
    })
})

exemplaireInfo.addEventListener("click", (event) => {

    idExemplaire = idSelectedExemplaire(event);
    url.setIdExemplaire(idExemplaire)

/*     idExemplaireIn.value = parseInt(idExemplaire) */
    console.log(url.getUrl())
    if(url.getUrl() !="error") 
        pretAdding.action = url.getUrl()
    else{
        
    }
    // transforming the background color into another color
    Array.from(exemplaireInfo.children).forEach(element => {
        if (element.classList.contains("selected")) {
            element.classList.remove("selected")
        }
    })

    Array.from(exemplaireInfo.children).filter(element =>{
        return element.firstChild.innerText === idExemplaire
    }).forEach(element => {
        element.classList.add("selected")
    })
})


datePret.addEventListener("input", ()=>{
    const dateOfReturn = datePret.value;

    if (dateOfReturn) {
        // Set the min attribute of the endDateTimeInput
        dateRemise.min = dateOfReturn;
        // Enable the endDateTimeInput
        dateRemise.disabled = false;
    } else {
        // If no valid value is set, keep the endDateTimeInput disabled
        dateRemise.disabled = true;
    }

})


/* setTimeout(3000, ()=>console.log(url)) */