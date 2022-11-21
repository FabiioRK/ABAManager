var dropdown = false;

function dropdownFunction() {
    dropdown = !dropdown;
    var dropdownElement = document.querySelector(".dropdown-menu");
    console.log(dropdownElement)
    if (dropdown)
        dropdownElement.style.display = "block";
    else    
        dropdownElement.style.display = "none";
}