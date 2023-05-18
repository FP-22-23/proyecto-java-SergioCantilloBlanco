# Proyecto del Segundo Cuatrimestre Fundamentos de Programación (Curso  2022-2023)
Autor/a: Sergio Cantillo   uvus:KRC2226

Aquí debes añadir la descripción del dataset y un enunciado del dominio del proyecto.


## Estructura de las carpetas del proyecto

* **/src**: Contiene los diferentes archivos que forman parte del proyecto. Debe estar estructurado en los siguentes paquetes
  * **fp.Estudiante**: Paquete que contiene los tipos del proyecto.
  * **fp.test**: Paquete que contiene las clases de test del proyecto.
  * **fp.common**: Paquete que contiene los tipos auxiliares del proyecto
  * **fp.utiles**:  Paquete que contiene las clases de utilidad. 
* **/data**: Contiene el dataset o datasets del proyecto
    * **\<Studentsperformance.csv\>**:Dataset que contiene los datos academicos ademas de las condiciones academicas de estudiantes.
  **/Doc**:Contiene el Readme.

    
## Estructura del *dataset*

El Dataset Original se puede obtener del URL https://www.kaggle.com/datasets/spscientist/students-performance-in-exams
Originalmente el Dataset tiene 8 columnas y cada fila contiene los datos academicos generales del estudiante.
El datadset usado en este proyecto tendra 10 columnas, tomando las 8 originales del dataset y dos, la fecha 
y la duracion del examen se han generado de forma aleatoria. A continuación se describen las 10 columnas del dataset:


* Genero: de tipo String, representa el genero del estudiante en cuestion.
* Grupo: de tipo Enum, representa el grupo al que pertenece el estudiante.
* Educacion parental: de tipo conjunto, representa el nivel educativo de los padres.
* Almuerzo: de tipo enum, representa si el almuerzo les viene incluido o no.
* Preparacion del examen: de boolean , representa si los alumnos se prepararon para el examen o no.
* Nota mates: de tipo Double, representa la nota de mates
* Nota lectura: de tipo Double, representa la nota de lectura
* Nota escritura: de tipo Double, representa la nota de escritura
* Fecha: de tipo Fecha y Hora, representa la fecha de la realizacion del examen.
* Duracion: de tipo duracion, representa los minutos empleados por el alumno en completar el examen.


## Tipos implementados


### Tipo Base
Tipo Estudiante

Representa las condiciones academicas de un estudiante.

genero de tipo string, consultable y modificable. Indica el genero del estudiante.
grupo de tipo enum, consultable. Indica al grupo al que pertenece el estudiante.
EducacionParental de tipo string consultable y modificable. Indica la educacion de los padres.
almuerzo de tipo boolean, consultable y modificable. Indica si le viene al estudiante el almuerzo incluido.
preparacion de tipo boolean,consultable y modificable. Indica si se preparo para el examen.
mates de tipo double,consultable y modificable. La nota de mates.
lectura de tipo double,consultable y modificable. La nota de lectura.
escrito de tipo double,consultable y modificable. La nota de escrito.
fecha de tipo date, consultable y modificable. la fecha de realizacion del examen.
lista de tipo list,consultable y modificable.una lista de las notas de los examenes.
duracion de tipo integer,consultable y modificable. Indica el tiempo que tardo el alumno en realizar el examen.
tipo de tipo tipoauxiliar,consultable.es un record donde toma los valores del genero y la educacion parental.

**Propiedades**:

- lista de tipo list,consultable y modificable.una lista de las notas de los examenes.
- ...
- 
**Constructores**: 

- C1: Tiene un parámetro por cada propiedad básica del tipo.
- C2: toma como parametros las tres notas.
- ...

**Restricciones**:
 
- R1: El genero no debe estar vacio
- R2: las notas no deben ser superiores a 100 ni inferiores a 0.
- R3:la duracion no puede ser superior a 90.
- ...
- 
**Criterio de igualdad**:son iguales si coinciden los parametros.

**Criterio de ordenación**:Ordena por notas.

**Otras operaciones**:
 
-	_método 1_: Descripción del método 1.
- ...

#### Tipos auxiliares
Descripción de los tipos auxiliares que sean necesarios añadir al proyecto.

tipo : el auxiliar introduce otro genero y la otra  educacion parental.

### Factoría
Clase de factoría para construir objetos de tipo Estudiante.

-  ContenedorEstudiantes leeEstudiante(String rutaFichero) :Crea un objeto de tipo Estudiante a partir de la información recogida en el archivo csv, cuya ruta se da como parámetro.

-	 EstudianteImpl parsearEstudiante(String linea): realiza el parseo de cada propiedad basica del fichero csv.

### Tipo Contenedor

Clase contenedora de los objetos de tipo Estudiante.

**Propiedades**:

- estudiante, de tipo List<EstudianteImpl>, consultable. Lista de estudiantes.
- ...
- 
**Constructores**: 

- C1: Constructor por defecto. Crea un objeto de tipo Estudiante sin ningun Estudiante almacenado.
- C2: Constructor con un parámetro de tipo Stream<EstudianteImpl>. Crea un objeto de tipo Estudiante con los estudiantes incluidos en el Stream dado
- ...

**Restricciones**:
 
- R1: Descripción de la restricción 1.
- R2: Descripción de la restricción 2.
- ...
- 
**Criterio de igualdad**: Describir el criterio de igualdad

**Criterio de ordenación**: Describir el criterio de ordenación (si lo hay).

**Otras operaciones**:
 
-	Metodo MenorMedia : Dado un parametro con la media minima se muestran las medias superiores a esta media minima.
- Metodo NumeroDeEstudiantesPorMes : cuenta cuantos estudiantes hay por el mes que se introduce por parametro.
 - Metodo estudiantesTardones : Muestra True si hay estudiantes que han tardado mas de 80 min en terminar el examen.
 - Metodo ObtenerEstudiantesPorDebajoDeMediaMinima : Introduzco como parametro una media minima y el metodo devuelve un map con clave la media y valor una lista del objeto EstudianteImpl
 -Metodo ObtenerNumeroEstudiantesPorGeneroQueEstudio: Map que tiene como clave genero y como valor el numero de estudiantes que tienen ese genero que estudiaron.
 -Metodo estudianteMaximaMedia: calcula el estudiante con la maxima media
 - Metodo notasMujeresMatesordenadasMayorAMenor : devuelve una lista de estudiantes mujeres de mayor a menor dependiendo de su media.
 - Metodo getlistaDeNotasLectura : devuelve una lista con las notas de lectura
 -Metodo mujerHombreConMayorMedia: Devuelve un mapa con los generos como las claves y las maximas medias como valores.
 -Metodo tresPeoresNotasPorGenero: devuelve un map con los generos como claves y una lista de tres peores notas de mates por genero.
 -Metodo MayorMediaEntreHombreMujer: toma mujerHombreConMayorMedia y calcula cual de ellos tiene la mayor media de todas.
