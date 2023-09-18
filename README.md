<h4 align="center"> 
API com Kafka, Docker e JPA
</h4>

<p align="center">
 <a href="#-sobre">Sobre</a> •
 <a href="#-projeto">Projeto</a> •
 <a href="#%EF%B8%8F-autor">Autor</a>
</p>

## 💻 Sobre

Esta é uma aplicação de exemplo que consiste em um producer e um consumer que se comunicam usando o Apache Kafka, além de uma API de músicas que utiliza o banco de dados em memória H2. Ela demonstra a troca de mensagens entre os dois componentes e fornece funcionalidade para gerenciar músicas.

Para rodar o Kafka e Zookeeper, pode-se baixar a imagem do spotify/kafka no site do Docker Hub:
```
docker pull spotify/kafka
```
<br>

| HTTP Verbs | Endpoints    | Ação                                          |
| ---------- | ------------ | --------------------------------------------- |
| GET        | /musicas     | Busca todas as músicas disponíveis no sistema |
| GET        | /musicas/:id | Busca uma música por ID                       |
| POST       | /musicas     | Adiciona uma nova música no sistema           |
| PUT        | /musicas/:id | Atualiza uma música do sistema                |
| DELETE     | /musicas/:id | Remove uma música do sistema                  |

<h3 align="center">
⚙️ Tecnologias utilizadas

<p>&nbsp;</p>
<img src="https://img.shields.io/badge/java-%23ED8B00.svg?style=for-the-badge&logo=openjdk&logoColor=white"/>
<img src="https://img.shields.io/badge/spring-%236DB33F.svg?style=for-the-badge&logo=spring&logoColor=white"/>
<img src="https://img.shields.io/badge/-Swagger-%23Clojure?style=for-the-badge&logo=swagger&logoColor=white"/>
<img src="https://img.shields.io/badge/Apache%20Kafka-000?style=for-the-badge&logo=apachekafka"/>
<img src="https://img.shields.io/badge/docker-%230db7ed.svg?style=for-the-badge&logo=docker&logoColor=white"/>
</h3>

---

## 🚧 Projeto

<h3 align="center">API de músicas 🎵
  <p></p>
  <img src="https://i.imgur.com/oGwVTUe.png"/>
</h3>

---

## ✒️ Autor

| [<img src="https://avatars.githubusercontent.com/u/75590326?v=4" width=115 > <br> <sub> Bruno Machado </sub>](https://github.com/brunomdrrosa) |
| :--------------------------------------------------------------------------------------------------------------------------------------------: |

<h2 >Entre em contato 🤙🏽</h2>

<div align="center">
<a href="https://linkedin.com/in/bruno-machado-da-rosa/" target="_blank"><img src="https://img.shields.io/badge/Bruno Machado da Rosa-0077B5?style=for-the-badge&logo=linkedin&logoColor=white" alt=""></a>
<a href="mailto:brunomdr46@gmail.com" target="_blank"><img src="https://img.shields.io/badge/brunomdr46@gmail.com-D14836?style=for-the-badge&logo=gmail&logoColor=white" alt=""></a>
</div>
