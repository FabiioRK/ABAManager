var paciente = {
    id : 0,
    nome : "",
    dataNacimento : null,
    email : "",
    telefone : "",
    endereco : "",
    atividade : "",
    observacao : "",
}

document.querySelectorAll(".remove").forEach(element => {
    element.addEventListener("click", function remove(event){
        event.target.parentElement.parentElement.remove();
    });
});

document.querySelectorAll(".edit").forEach(element => {
    element.addEventListener("click", function(){
        editar();
    });
});

function imprime(){
    console.log(paciente.dataNacimento);
}

function openModal(){
    var modalElement = document.querySelector(".modal");
    console.log(modalElement);
    if (modalElement.classList.contains("hidden")) {
        modalElement.classList.remove("hidden");
    } else {
        modalElement.classList.add("hidden");
        resetPaciente();
    }
}

function resetPaciente(){
    paciente = {
        id : 0,
        nome : "",
        dataNacimento : null,
        email : "",
        telefone : "",
        endereco : "",
        atividade : "",
        observacao : "",
    };
    console.log(paciente);
}

function editar() {
    paciente = {
        id : 1,
        nome : "Paulo",
        dataNacimento : "2017-06-01",
        email  : "paulo@mail.com",
        telefone : "99987654321",
        endereco : "string serio",
        atividade : "era pra ser um array",
        observacao : "array tbm",
    }

    var form = document.querySelector(".formulario");
    form.nome.value = paciente.nome;
    form.nacimento.value = paciente.dataNacimento;
    form.email.value = paciente.email;
    form.telefone.value = paciente.telefone;
    form.endereco.value = paciente.endereco;
    form.atividade.value = paciente.atividade;
    form.observacao.value = paciente.observacao;
    openModal();
}

