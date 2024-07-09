let createbtn = document.getElementById("createBT");
let inputbtn = document.getElementById("inputBT");

createbtn.addEventListener("click", function() {

const response = fetch("http://localhost:8080/blowtorch", {
  method: "POST",
  body: JSON.stringify({ length: inputbtn.value }),
  headers: {
      "Content-Type": "application/json",
    },
    });
});

document.addEventListener('DOMContentLoaded', async (event) => {
    const response = await fetch("http://localhost:8080/allweldings", {
      method: "GET",
        });
    const json = await response.json();
    let div = document.getElementById("allweldings");
    json.forEach((weld) => {
        let weld_div = document.createElement("div");
        weld_div.innerHTML = weld.name;
        div.appendChild(weld_div);
    });
});


