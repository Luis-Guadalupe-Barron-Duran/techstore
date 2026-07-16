
# TechStore
Para poder clonar el proyecto, primero debes tener instalado Git en tu computadora y un cliente para mandar peticiones, como Postman. 

Abre la terminal y ejecuta el siguiente comando:

```
git clone <https://github.com/Luis-Guadalupe-Barron-Duran/techstore.git>
```
despues de clonar el proyecto, debes abrir tu IDE y abrir el proyecto.

En tu IDE, abre la terminal y ejecuta el siguiente comando para instalar las dependencias del archivo pom.xml:

```
mvn clean install

```
En tu IDE, abre la terminal y ejecuta el siguiente comando para ejecutar el proyecto:

```
mvn spring-boot:run
```
o si tu editor tiene un plugin para ejecutar el proyecto,  puedes usarlo para ejecutar el proyecto.

Una vez que el proyecto esté corriendo, abre tu cliente de peticiones y agrega la siguiente ruta para acceder a la API:
``
http://localhost:8080/api.
``
Si quieres usar la API de productos, agrega esto a tu ruta:
``
/products.
``
Y si quieres usar la API de categorias, agrega esto a tu ruta:
``
/categories.
``


Para usar la API de productos, puedes hacer peticiones GET, POST, PUT y DELETE con las rutas que mencionamos antes. 

En algunos casos como POST que sirve para agregar un producto, deberas agregar los campos en un JSON. La estructura es la siguiente:

Para Productos:
```
{
    "nombre": "Nombre del producto",
    "precio": "Precio del producto",
    "stock": "Cantidad de productos",
    "sku": "FORMATO DEL SKU (Ej. AAA1234)
}
```
Para categorias:
```
{
    "nombre": "Nombre de la categoria"
}
```
En los dos casos de arriba, para los metodos POST y PUT debes agregar la estrcutura que mencionamos del JSON.

Para los otros metodos, solo se agrega la URL. Si vas a buscar o eliminar un solo producto o categoria, solo agrega el id en la url: Ej: "/1".

Se agregan ejemplos de las peticiones:



```
METODO: GET
URL:http://localhost:8080/api/products

```
```
METODO: POST
URL:http://localhost:8080/api/products
BODY:
{
    "nombre": "Thinkpad,
    "precio": 8540.00,
    "stock": 4,
    "sku": AAA1234
}   

```
```
METODO: PUT
URL: http://localhost:8080/api/products/1
BODY:
{
    "nombre": "Lenovo Thinkpad",
    "precio": 8540.00,
    "stock": 3,
    "sku": AAA1234
}
```
```
METODO: DELETE
URL: http://localhost:8080/api/products/1

```