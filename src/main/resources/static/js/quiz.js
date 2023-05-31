function moveRegisterPage(){
    window.location.href = "/register"
}

function moveEditPage(id){
    window.location.href = "/editor/" + id
}


function validateQuizForm() {

}


function moveListPage() {
    location.replace("/list")
}


function serialize (rawData) {
    let rtnData = {};
    for (let [key, value] of rawData) {
        let sel = document.querySelectorAll("[name=" + key + "]");
        // Array Values
        if (sel.length > 1) {
            if (rtnData[key] === undefined) {
                rtnData[key] = [];
            }
            rtnData[key].push(value);
        }
        // Other
        else {
            rtnData[key] = value;
        }
    }
    return rtnData;
}