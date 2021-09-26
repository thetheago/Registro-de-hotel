# Validação Hotel

Um programa que fiz na faculdade onde o usuário digita seu nome, o dia de entrada e saída do hotel, e a cidade do hotel que se hospedou, cobrindo os seguinte erros :
- O dia de entrada deve ser menor que o dia de saída;
- A cidade deve ser uma cidade válida (comparando com as cidades criadas em um vetor global no programa)
- O programa deve fazer no máximo 100 consultas, e para acabar digite SAIR quando for colocar o nome

<h1>Contém também dois métodos :</h1>
<h2>calcularConta</h2>
Esse método calcula os dias que o hospede ficou hospedado e retorna o valor da sua conta de acordo com o tipo de quarto que ele escolheu (standard, luxo e super-luxo);

<h2>cidadeEhValida</h2>
Esse método percorre o array "vetCidades" em que estão declaradas as cidades validas e compara com a cidade digitada, retornando true ou false.

No final o programa exibe o nome e o valor da conta de todos os hospedes em que o valor da conta passou da média!
