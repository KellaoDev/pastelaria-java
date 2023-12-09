function atualizarPreco(checkbox) {
    // Obtém o estado atual do valor adicionado
    let valorAdicionado = checkbox.getAttribute('data-valor-adicionado') === 'true'

    // Verifica se o checkbox está marcado
    if (checkbox.checked && !valorAdicionado) {
        let precoAtual = parseFloat($('#preco').val())
        $('#preco').val(precoAtual + 2.00)

        // Atualiza o estado do valor adicionado
        checkbox.setAttribute('data-valor-adicionado', 'true')
    } else if (!checkbox.checked && valorAdicionado) {
        // Se o checkbox foi desmarcado, mas o valor foi adicionado anteriormente, remova o valor
        let precoAtual = parseFloat($('#preco').val())
        $('#preco').val(precoAtual - 2.00)

        // Atualiza o estado do valor adicionado
        checkbox.setAttribute('data-valor-adicionado', 'false')
    }
}

function atualizarPrecoCarnes(checkbox) {
    // Obtém o estado atual do valor adicionado
    let valorAdicionado = checkbox.getAttribute('data-valor-adicionado') === 'true'

    // Verifica se o checkbox está marcado
    if (checkbox.checked && !valorAdicionado) {
        let precoAtual = parseFloat($('#preco').val())
        $('#preco').val(precoAtual + 3.00)

        // Atualiza o estado do valor adicionado
        checkbox.setAttribute('data-valor-adicionado', 'true')
    } else if (!checkbox.checked && valorAdicionado) {
        // Se o checkbox foi desmarcado, mas o valor foi adicionado anteriormente, remova o valor
        let precoAtual = parseFloat($('#preco').val())
        $('#preco').val(precoAtual - 3.00)

        // Atualiza o estado do valor adicionado
        checkbox.setAttribute('data-valor-adicionado', 'false')
    }
}

let massaAnterior = null; // Variável para armazenar a checkbox anteriormente marcada

// Função para ser chamada quando o estado do checkbox mudar
function atualizarPrecoMassas(checkbox) {
    if (massaAnterior && massaAnterior !== checkbox && massaAnterior.checked) {
        // Se a checkbox anterior foi marcada e é diferente da atual, remover o valor
        removerValor(massaAnterior)
    }

    if (checkbox.id === "picanteCheckbox" && checkbox.checked) {
        // Se a checkbox picante está marcada, desmarcar a checkbox normal
        $('#normalCheckbox').prop('checked', false)
        // Adicionar o valor
        adicionarValor(checkbox)
    } else if (checkbox.id === "normalCheckbox" && checkbox.checked) {
        // Se a checkbox normal está marcada, desmarcar a checkbox picante
        $('#picanteCheckbox').prop('checked', false)
        // Adicionar o valor
        adicionarValor(checkbox)
    } else {
        // Se nenhuma checkbox está marcada, remover o valor
        removerValor(checkbox)
    }

    // Armazenar a checkbox atual como a anterior
    massaAnterior = checkbox
}

// Função para adicionar o valor no input de preço
function adicionarValor(checkbox) {
    let precoAtual = parseFloat($('#preco').val())
    $('#preco').val(precoAtual + 5.00)
    // Atualizar o estado do valor adicionado
    checkbox.setAttribute('data-valor-adicionado', 'true')
}

// Função para remover o valor no input de preço
function removerValor(checkbox) {
    let precoAtual = parseFloat($('#preco').val())
    $('#preco').val(precoAtual - 5.00)
    // Atualizar o estado do valor adicionado
    checkbox.setAttribute('data-valor-adicionado', 'false')
}

function validarFormulario() {
    // Verifica se pelo menos um tipo de massa está selecionado
    if (!$('#normalCheckbox').prop('checked') && !$('#picanteCheckbox').prop('checked')) {
        $('#mensagemErro').html('Selecione pelo menos um tipo de massa')
        console.log('...')
        return false
    }

    // Verifica se pelo menos dois recheios estão selecionados
    let recheiosSelecionados = $('input[name^="recheios"]:checked').length
    if (recheiosSelecionados < 1) {
        $('#mensagemErro').html('Selecione pelo menos um recheio')
        return false
    }

    return true  // Envie o formulário se todas as validações passarem
}

// Adiciona manipuladores de eventos para os campos de checkbox
$('#normalCheckbox, #picanteCheckbox').on('change', function () {
    // Ao selecionar um dos campos, esconde a mensagem de erro
    $('#mensagemErro').html('')
});

