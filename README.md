# Algoritmos y Programación II : TP 2

Integrantes: 
- Di Dio Gonzalo
- Lottero Bruno
- Lovera Alexander
- Posta Daniel

## Decisiones de diseño

- Se decidió representar el tablero mediante un diccionario cuya llave representa la posición del tablero en forma vectorial (de igual manera que se lee en el archivo de configuración), el valor es el objeto que contiene el casillero en dicha posición (mina, provision, etc). Para validar los movimientos que puede hacer el personaje según los limites del tablero, se utilizó aritmetica modular.

- Una vez que explota una mina o se agrega una provisión, se elimina del tablero (se borra del diccionario)

- Para poder representar provisiones compuestas se utilzó el patrón Composite.

- Para permitir que solo haya una instancia del tablero y del personaje, se utilizó el patrón singleton.

## UML

![alt text](UML_TP2.png "Diagrama UML")

[Link a la imágen](UML_TP2.png)

## Descripción de cada archivo fuente

##### App.java

Es la clase que contiene el punto de entrada (main). De aquí se obtiene el ejecutable de la aplicación.

##### Provisiones.java

Es la interfaz que impementan todas las provisiones, tiene los metodos:

- aplicarProvision(Pac pac)
- ejecutarComportamiento(Pac pac)

Para tratar todas las acciones que suceden en el juego cuando el personaje entra a una posición con Mina o Provision.

##### CajaDeVitaminas.java

Extiende la clase Provisiones, contiene el comportamiento que suma una vida al personaje (Pac)

##### ComboDeProvisiones.java

Extiende la clase Provisiones, es la clase que representa una provisión compuesta (patrón composite)

##### EscudoDeFuerza.java

Extiende la clase Provisiones, contiene el comportamiento que suma dos puntos de escudo al personaje (Pac)

##### GestorDeArchivos.java

Esta clase contiene los métodos para leer el archivo de configuración.
Va seccion por sección interpretando cada una de las asignaciones.

##### ObjetosEscondidos.java

Esta clase se utiliza para designar los objetos que no son visibles por el jugador.

##### Mina.java

Tiene el comportamiento para quitarle un punto de vida al personaje cuando este ingresa a una posición que contiene Mina.

##### MovimientoDePac.java

Es una clase que utiliza el patrón singleton para gestionar el movimiento del personaje.
Posee métodos para interpretar la entrada por consola y posicionar al personaje acorde a esta. Utiliza el VerificadorDePosicion para validar los movimientos.

##### Pac.java

Es la clase que representa al personaje, utiliza el patrón singleton, almacena la posición actual del personaje en el tablero, sus vidas y sus puntos de escudo.

##### Pared.java

Representa una pared en el juego, su método toString() devuelve "X" para imprimir en el tablero.

##### ProvisionYMina.java

Esta clase se utiliza en las posiciones que contienen mina y provisiones (primero se agregan las provisiones, luego explota la mina)

##### Tablero.java

Es la clase del tablero (utiliza singleton), guarda un HashMap con las posiciones=>objetos del tablero.
Almacena el numero de columnas, filas, numero de casilleros y posicion de salida. También contiene el método para imprimir el tablero.

##### VerificadorDePosicion.java

Esta clase tiene métodos que utilizan aritmética modular para validar los movimientos del personaje:

- No se puede avanzar a la derecha si : (posicion_actual + 1) % cantidad_de_columnas == 0
- No se puede avanzar a la izquierda si : posicion_actual % cantidad_de_columnas  == 0
- No se puede avanzar hacia arria si : posicion_actual - cantidad_de_columnas < 0
- No se puede anvanzar hacia abajo si : posicion_actual >= inicioUltimaFila
- Donde inicioUltimaFila = numero_de_casilleros - numero_de_columnas
