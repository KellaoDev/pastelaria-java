function formatarTelefone(input) {
    // Remove caracteres não numéricos
    let numero = input.value.replace(/\D/g, '');

    // Adiciona os parênteses e traço
    if (numero.length > 2) {
        numero = `(${numero.substring(0, 2)}) ${numero.substring(2)}`;
    }
    if (numero.length > 10) {
        numero = `${numero.substring(0, 10)}-${numero.substring(10)}`;
    }

    // Atualiza o valor no campo de entrada
    input.value = numero;
}

// Adiciona um listener para permitir apenas números
document.getElementById('telefoneInput').addEventListener('keypress', function (e) {
    const key = String.fromCharCode(e.keyCode);
    if (!/^\d+$/.test(key)) {
        e.preventDefault();
    }
});