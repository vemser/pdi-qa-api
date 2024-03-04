---
modified: 2024-03-03T15:31:45.208Z
title: Como executar o relatório com o newman
---

# Como executar o relatório com o newman

## Dependências

- `newman`: É uma ferramenta de linha de comando que permite executar coleções do Postman.
- `newman-reporter-htmlextra`: É um relatório HTML personalizado para o Newman.
- `postman`: É necessário exportar o environment e a coleção do Postman antes.

## Comandos

1. Instale o Newman globalmente:

```bash
npm install -g newman
```

2. Instale o relatório HTML personalizado:

```bash
npm install -g newman-reporter-htmlextra
```

3. Execute a coleção do Postman:

```bash
newman run .\api.json -e .\environment.json -r htmlextra
```