<a name="readme-top"></a>

# PDI - Grupo 06 - Automações API
![Intellij](https://img.shields.io/badge/Intellij-logo?style=flat-square&color=%23000000)
![Java](https://img.shields.io/badge/JAVA_17-logo?style=flat-square&color=%23FF7800)
![RestAssured](https://img.shields.io/badge/RestAssured-logo?style=flat-square&color=%234EA94B)
![Postman](https://img.shields.io/badge/Postman-logo?style=flat-square&color=%23FF6C37)
![Junit](https://img.shields.io/badge/Junit-logo?style=flat-square&color=%2314692E)
![Allure-Report](https://img.shields.io/badge/Allure_Report-logo?style=flat-square&color=%23E5de00)
![Jenkins](https://img.shields.io/badge/Jenkins-Logo?style=flat-square&color=%23c61a09)
![Lombok](https://img.shields.io/badge/Lombok-logo?style=flat-square&color=grey)


No seguinte repositório, você encontrará a implementação de testes de integração API do projeto PDI.

Este projeto visa centralizar informações e histórico de evolução para serem compartilhados com os clientes da DBC, proporcionando assim um modelo mais preciso e descritivo do estagiário e sua trajetória de evolução.
## Como rodar o projeto
1 - Clone o repositorio
```ssh
git clone https://github.com/vemser/pdi-qa-api.git
```
2 - Entre na pasta criada
```ssh
cd pdi-qa-api
``` 
3 - Rode o comando para gerar testes com maven
```ssh
mvn clean test
``` 
4 - rode o comando para gerar o relatorio do allure
```ssh
allure generate allure-results -o allure-report
``` 
## Links de documentação

- [Documentação do Projeto](https://docs.google.com/document/d/1JbD9QE9wydjz9Um56CRPOwvF_eynXlK5pjudNpPTfe0/edit?usp=sharing)
- [Plano de Testes](https://docs.google.com/document/d/1Egbc41QN5k-EP1opllAnJ8QMLGkxEileNWfX0vs50-o/edit?usp=sharing)
- [Cenario de Testes](https://docs.google.com/document/d/1DUtSViUbR1GF9dwR3aufcfRg7i1MkpqXnzVUOy5yHrQ/edit?usp=sharing)
- [Estórias de usuários](https://docs.google.com/document/d/1VYv1Bo8UmuYAN4OSunE8Pl5dQIh4Ih-E1crcTPsBw48/edit?usp=sharing)
- [Teste Manuais com postman](https://app.getpostman.com/join-team?invite_code=2fc8839858ec78310ad402f924de4157&target_code=307bd2f22a0849d0b6c55679a3f0fcc7)
## Integrantes

<table>
    <tr>
      <td align="center">
        <a href="https://github.com/bscarpari">
          <img src="https://avatars.githubusercontent.com/u/53575457?v=4" width="100px;" /><br>
          <sub>
            <b>Bruno Scarpari</b>
          </sub>
        </a>
      </td>
      <td align="center">
        <a href="https://github.com/AlessandraMariana">
          <img src="https://avatars.githubusercontent.com/u/86929017?v=4" width="100px;" /><br>
          <sub>
            <b>Alessandra Mariana</b>
          </sub>
        </a>
      </td>
      <td align="center">
        <a href="https://github.com/PedroBersch">
          <img src="https://avatars.githubusercontent.com/u/113629864?v=4" width="100px;" /><br>
          <sub>
            <b>Pedro Bersch</b>
          </sub>
        </a>
      </td>
      <td align="center">
        <a href="https://github.com/Helcius">
          <img src="https://avatars.githubusercontent.com/u/114032954?v=4" width="100px;" /><br>
          <sub>
            <b>Helcius Cabral</b>
          </sub>
        </a>
      </td>
    </tr>
</table>

## Cobertura de testes

- Acompanhamento
    - Listar todos os Acompanhamentos
- Estagiário
    - Buscar relatório do cliente por ID
    - Buscar todos os estagiários
    - Agrupar estagiários por trilha
- Feedback por módulos
    - Deletar um feedback por ID
    - Adicionar um feedback
    - Editar um feedback por ID
- Relatório
    - Gerar um relatório em formato de PDF por ID de estagiário

## Licença

[MIT](https://choosealicense.com/licenses/mit/)

<p align="right">(<a href="#readme-top">voltar para o topo</a>)</p>