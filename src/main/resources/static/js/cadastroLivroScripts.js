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

    const foiLido = false;//todo: marcar como lido

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