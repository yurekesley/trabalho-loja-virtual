# trabalho-loja-virtual


### Instalação Docker

```sh
docker build -t loja-virtual .
```
```sh
docker run -p 9990:9990 -p 8080:8080 loja-virtual
```

### URLS


#### Produtos disponíveis

```sh
http://localhost:8080/loja/produtos
```

#### Disponibiliza uma tela para adicionar/remover produtos no carrinho e finalizar compra

```sh
http://localhost:8080/loja/compras
```
