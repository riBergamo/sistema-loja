(function () {
    const estadoSelect = document.querySelector('[data-localidade="estado"]');
    const cidadeSelect = document.querySelector('[data-localidade="cidade"]');

    if (!estadoSelect || !cidadeSelect) {
        return;
    }

    const estadoAtual = estadoSelect.dataset.current || "";
    const cidadeAtual = cidadeSelect.dataset.current || "";
    const apiBase = "https://servicodados.ibge.gov.br/api/v1/localidades";

    function criarOpcao(valor, texto) {
        const option = document.createElement("option");
        option.value = valor;
        option.textContent = texto;
        return option;
    }

    function limparSelect(select, textoInicial) {
        select.innerHTML = "";
        select.appendChild(criarOpcao("", textoInicial));
    }

    function preencherCidades(uf, cidadeSelecionada) {
        limparSelect(cidadeSelect, "Carregando cidades...");
        cidadeSelect.disabled = true;

        if (!uf) {
            limparSelect(cidadeSelect, "Selecione um estado primeiro");
            return;
        }

        fetch(`${apiBase}/estados/${uf}/municipios?orderBy=nome`)
            .then((response) => response.json())
            .then((cidades) => {
                limparSelect(cidadeSelect, "Selecione a cidade");
                cidades.forEach((cidade) => {
                    cidadeSelect.appendChild(criarOpcao(cidade.nome, cidade.nome));
                });
                cidadeSelect.value = cidadeSelecionada || "";
                cidadeSelect.disabled = false;
            })
            .catch(() => {
                limparSelect(cidadeSelect, "Nao foi possivel carregar as cidades");
            });
    }

    fetch(`${apiBase}/estados?orderBy=nome`)
        .then((response) => response.json())
        .then((estados) => {
            limparSelect(estadoSelect, "Selecione o estado");
            estados.forEach((estado) => {
                estadoSelect.appendChild(criarOpcao(estado.sigla, `${estado.nome} (${estado.sigla})`));
            });
            estadoSelect.value = estadoAtual;
            preencherCidades(estadoAtual, cidadeAtual);
        })
        .catch(() => {
            limparSelect(estadoSelect, "Nao foi possivel carregar os estados");
            limparSelect(cidadeSelect, "Nao foi possivel carregar as cidades");
        });

    estadoSelect.addEventListener("change", function () {
        preencherCidades(this.value, "");
    });
})();
