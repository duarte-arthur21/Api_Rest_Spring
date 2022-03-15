const desc = document.querySelector("#descricao");

console.log(desc);

desc.addEventListener("keypress", function(e){
    const inputLength = desc.value.length;
    const maxChars = 0;

    if(inputLength >= maxChars){
        e.preventDefault();
    }
});

