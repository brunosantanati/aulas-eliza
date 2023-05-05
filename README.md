# Projetos das aulas

## Projeto microservicos (alurafood) comandos:

```
Para o serviço do MySQL no Linux:
sudo service mysql stop

Lista as imagens do Docker:
docker images

Lista as imagens e filtra por mysql:
docker images | grep mysql

Lista os containers rodando:
docker ps

Baixa a imagem com MySQL:
docker pull mysql

Sobe um container baseado na imagem do MySQL (pode-se usar -e MYSQL_ROOT_HOST:"%" para liberar o acesso de qualquer ip):
docker run -d \
  --name my-mysql-container \
  -e MYSQL_ROOT_PASSWORD=root \
  -p 3306:3306 \
  -v /home/bruno/mysql/mysqlData:/var/lib/mysql \
  mysql
  
Provê um bash no container:
docker exec -it my-mysql-container bash
  
Para pegar o IP do container:
docker inspect my-mysql-container | grep IPAddress
OU
docker inspect -f '{{range.NetworkSettings.Networks}}{{.IPAddress}}{{end}}' my-mysql-container

Acessar o MySQL do container a partir da máquina host:
mysql -h 172.17.0.2 -u root -p
OU
mysql -h 172.17.0.2 -P 3306 --protocol=tcp -u root -p

Pegar o IP de uma virtual machine onde o Docker está instalado (diferente da máquina host):
docker-machine ip
```
