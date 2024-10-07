# Aplicativo Multi-Atividades

Este projeto Android foi desenvolvido para criar uma experiência interativa com diversas funcionalidades, incluindo jogos e ferramentas úteis. Abaixo você encontrará uma explicação clara sobre cada parte do código e como ele se integra para formar a aplicação.

## 📱 MainActivity - Atividade Principal

A **MainActivity** é a tela inicial do aplicativo, que exibe uma lista de opções através de um RecyclerView. Cada item da lista corresponde a uma funcionalidade diferente, e o usuário pode clicar para navegar até essa funcionalidade.

### Funcionalidades principais:
- **RecyclerView**: Exibe uma lista de botões que representam diferentes atividades.
- **AdapterOpcoes**: Gera e gerencia os dados exibidos na lista de opções.
- **Clique nos itens**: O app reconhece quando o usuário clica em um dos itens e abre a respectiva atividade (ex: Frases do Dia, Jogo Jokenpô, etc.).

### Opções Disponíveis:
- **Frases do Dia**: Exibe uma mensagem inspiradora aleatória.
- **Jokenpô**: Jogue pedra, papel ou tesoura contra o aplicativo.
- **Álcool ou Gasolina**: Ferramenta para calcular qual combustível é mais vantajoso.
- **Calculadora de Gorjeta**: Calcula a gorjeta com base no valor da conta.
- **CardView**: Exemplo de uso de CardViews.
- **Cara ou Coroa**: Um simples jogo de cara ou coroa.

---

## 💬 Frases do Dia Activity

A **FrasesDoDiaActivity** exibe uma frase inspiradora aleatória ao usuário. Ao clicar no botão "Gerar Nova Frase", uma nova frase é exibida de forma aleatória, motivando o usuário com mensagens positivas.

### Principais funcionalidades:
- **Geração Aleatória de Frases**: O app escolhe uma frase da lista pré-definida e a exibe na tela.
- **Botão Voltar**: Fecha a atividade e retorna à tela anterior.
- **Botão Gerar**: Gera e exibe uma nova frase de motivação.

---

## ✋ Jokenpô Activity

A **JokenpoActivity** simula o clássico jogo de pedra, papel e tesoura, onde o usuário joga contra o aplicativo.

### Principais funcionalidades:
- **Escolha do Jogador**: O usuário pode escolher pedra, papel ou tesoura.
- **Escolha do App**: O aplicativo seleciona aleatoriamente uma jogada (pedra, papel ou tesoura).
- **Animação de Escolha**: Ao escolher, o aplicativo exibe uma animação do item selecionado (pedra, papel ou tesoura).
- **Resultado**: Exibe quem venceu a rodada (usuário ou app).

---

## ⛽ Álcool ou Gasolina Activity

A **AlcoolOuGasolinaActivity** é uma ferramenta que ajuda o usuário a calcular qual combustível é mais vantajoso para abastecer, com base nos preços inseridos.

### Principais funcionalidades:
- **Entrada de Dados**: O usuário insere o preço do álcool e da gasolina.
- **Cálculo**: O aplicativo calcula automaticamente qual combustível é mais vantajoso.
- **Resultado**: Exibe uma mensagem indicando se é melhor abastecer com álcool ou gasolina.

---

## 💵 Calculadora de Gorjeta Activity

A **CalculadoraGorjetaActivity** ajuda o usuário a calcular o valor da gorjeta com base no valor da conta e na porcentagem de gorjeta desejada.

### Principais funcionalidades:
- **Entrada de Dados**: O usuário insere o valor total da conta e a porcentagem da gorjeta.
- **Cálculo**: O app calcula automaticamente o valor da gorjeta e o valor total da conta com a gorjeta incluída.
- **Resultado**: Exibe o valor total a ser pago e a quantia referente à gorjeta.

---

## 📦 CardView Activity

A **CardViewActivity** demonstra o uso de CardViews no Android. Os CardViews são elementos visuais que permitem a criação de layouts ricos e envolventes, com sombra e elevação.

### Principais funcionalidades:
- **Exemplo de Interface**: Demonstra o uso de CardView para exibir conteúdo de forma visualmente agradável e organizada.
- **Layout Estruturado**: Layouts de cartões utilizados para exibir informações.

---

## 🎲 Cara ou Coroa Activity

A **CaraCoroaActivity** permite ao usuário jogar cara ou coroa de forma simples.

### Principais funcionalidades:
- **Jogar Cara ou Coroa**: O app simula um lançamento de moeda aleatório e exibe o resultado (cara ou coroa).
- **Animação**: Animação visual ao mostrar o resultado do lançamento.

---

## 🚀 Como Rodar o Projeto

Para rodar este projeto em sua máquina local, siga os passos abaixo:

1. Clone o repositório:
   ```bash
   git clone https://github.com/seu-usuario/seu-repositorio.git
   ## 🚀 Como Rodar o Projeto

2. Abra o projeto no Android Studio.
3. Conecte um dispositivo físico ou emulador.
4. Rode o projeto clicando no botão "Run" (Ícone de Play) no Android Studio.

## 🛠️ Tecnologias Utilizadas

- **Java**: Linguagem principal do projeto.
- **XML**: Para construção dos layouts.
- **Android Studio**: Ambiente de desenvolvimento integrado (IDE).
- **RecyclerView**: Para exibição de listas de opções.
- **CardView**: Para criar elementos visuais mais atraentes e dinâmicos.
- **Adapter**: Para vincular dados ao RecyclerView e gerenciar a exibição dos itens.
- **Model**: Para representar os dados e suas estruturas.
- **Listener**: Para gerenciar interações do usuário, como cliques em itens da lista.
