# new feature
# language: pt

Funcionalidade:
  Eu, enquanto pretendente de uma vaga para automação
  Preciso valiar o acesso e pesquisa no portal GetNet
  Para garantir meu conhecimento.

  Esquema do Cenário: Validar
    Dado              configurei ambiente para acessar URL Chrome
    E                 abri tela da <url>
    Quando            pesquisar por <consulta>
    E                 clico no link
    Entao             valido a <mensagem> da tela
    Exemplos:
      | consulta       | url                         | mensagem                             |
      | Superget       | https://site.getnet.com.br/ |  Como acesso a minha conta SuperGet? |