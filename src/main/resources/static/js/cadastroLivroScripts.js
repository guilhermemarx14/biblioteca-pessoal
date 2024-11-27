$(document).ready(function () {
    $('.select2').select2({
        width: '100%',
        tags: true,
        tokenSeparators: [','],
        placeholder: "Selecione ou adicione",
        allowClear: true
    });
});

document.addEventListener("DOMContentLoaded", function () {
    const btnSalvar = document.getElementById('btnSalvar');

    btnSalvar.addEventListener('click', confirmarSalvar);
});

function confirmarSalvar(event) {
    event.preventDefault();

    const foiLido = document.getElementById("lido").checked;

    if (foiLido) {
        Swal.fire({
            title: 'Informações adicionais',
            html: `
                <label for="classificacao">Classificação (1-5 estrelas):</label>
                <input class="form-control" type="number" id="classificacao" min="1" max="5"><br>
                <label for="dataLeitura">Data da Leitura:</label>
                <input class="form-control" type="date" id="dataLeitura"><br>
                <label for="comentario">Comentário:</label>
                <textarea class="form-control" id="comentario"></textarea><br>
            `
        });
    } else {
        document.querySelector('form').submit();
    }
}

document.getElementById("genero").addEventListener("change", function (event) {
    const selectedOptions = Array.from(event.target.selectedOptions);
    const newGenreOption = selectedOptions.find(option => option.value === "novo-genero");

    if (newGenreOption) {
        // Exibir um modal ou redirecionar o usuário para criar um novo gênero
        alert("Adicionar novo gênero!");
        // Remover a seleção do "Adicionar novo" para evitar confusão
        newGenreOption.selected = false;
    }
});