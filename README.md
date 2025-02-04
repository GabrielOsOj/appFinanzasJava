# Gestor de Finanzas
Pequeño gestor de finanzas creado con Java y SQLite.

### Funciones
- Permite guardar transacciones y clasificarlas según su categoría y tipo de gasto.
- Visualización del total de ingresos, gastos y el balance entre ambos.
- Representación gráfica de los gastos distribuidos por categorías mediante un gráfico de torta.


### Funcionamiento Interno
#### Estructura
En este proyecto apliqué la arquitectura Modelo-Vista-Controlador (MVC) para organizar mejor el código y separar responsabilidades.

El proyecto está dividido en tres paquetes principales:

- Vista: Contiene todo lo relacionado con la interfaz gráfica, incluyendo la pantalla principal y los dos modales.
- Modelo: Incluye las interfaces, sus implementaciones y la conexión con la base de datos.
- Controlador: Contiene la clase bddController, encargada de conectar la vista con los datos obtenidos de la base de datos.

#### Interfaz
La interfaz fue creada utilizando la biblioteca Swing y está diseñada para ser clara y sencilla.

En la pantalla principal, a la izquierda, se muestra un gráfico de torta con la distribución de los gastos por categorías.

A la derecha, hay una lista con todas las transacciones, ordenadas por fecha, junto con dos botones para agregar o eliminar transacciones.

Al presionar el botón "Agregar transacción", se despliega un modal para ingresar los datos de una nueva transacción. 

Para seleccionar la fecha, hay dos opciones:
- Si se desea la fecha actual, basta con presionar "Añadir", ya que por defecto se utiliza la fecha del día.
- Para elegir una fecha específica, se puede presionar el botón "Seleccionar fecha", que despliega un calendario con opciones tanto para fechas pasadas como futuras.


#### Persistencia de Datos
Dado el alcance de este proyecto, decidí utilizar una base de datos SQLite. Sin embargo, gracias a la implementación con interfaces, en el futuro no descarto la posibilidad de migrar a MySQL o PostgreSQL.

La base de datos está compuesta por tres tablas:

- Transacciones: Es la tabla principal, donde se almacenan los datos de las transacciones (montos, descripciones, fechas, etc.).
- Categorías: Guarda las categorías de las transacciones para evitar la repetición de información en la tabla principal.
- Tipo de gasto: Similar a la tabla de categorías, pero diferenciando los tipos de gasto.

Gran parte de las funciones utilizadas en la vista principal ya están predefinidas en la base de datos (por ejemplo, la suma de los totales, la selección por tipo de gasto y la agrupación por categorías). Esto permite que la capa del controlador se enfoque únicamente en transformar algunos tipos de datos mejorando un poco la eficiencia.

### Conclusión
Esta es una pequeña aplicación desarrollada como proyecto de estudio, donde apliqué gran parte de mis conocimientos y aprendí nuevas prácticas, como la arquitectura MVC y el uso de interfaces en la programación.

Dado que se trata de un proyecto de aprendizaje, es posible que haya algunos bugs que se me hayan pasado por alto. Aun así, considero que fue una experiencia valiosa y me permitió mejorar mis habilidades en Java, bases de datos y diseño de interfaces.

