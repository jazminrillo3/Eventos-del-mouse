# Eventos del mouse
Este proyecto forma parte del global de Arquitectura y Sistemas Operativos de la carrera de Tecnicatura Universitaria en Programación. 
Consiste en una aplicación de escritorio desarrollada con Java Swing que permite realizar y visualizar diferentes eventos del mouse, así como dibujar en la interfaz, contar los clicks y un juego que nos permiten visualizar los diferentes eventos del mouse.

## Características
• La aplicación posee una interfaz gráfica intuitiva.

• Permite realizar acciones como clics, desplazamientos y entradas de mouse.

• Los eventos del mouse son capturados y mostrados en tiempo real en la interfaz.

• Se puede dibujar en la interfaz utilizando el mouse.

• Incluye un panel con un contador de clics.

• Tiene un juego interactivo que utiliza los eventos del mouse.

## Instrucciones de uso

1. Clona el repositorio:
```
git clone https://github.com/jazminrillo3/Eventos-del-mouse.git
```

2. Abre el proyecto en tu IDE.

3. Compila el proyecto y asegúrate de que no haya errores.

4. Ejecuta la aplicación y explora los diferentes eventos del mouse, prueba el dibujo y los juegos interactivos.

5. Aparecerá una ventana con tres opciones (iconos): "Dibujar", "Contador de clicks" y "Minijuego".

6. Haz clic en la opción "Dibujar" para habilitar la función de dibujo. Mueve el mouse para dibujar en el área de dibujo.

7. Haz clic en la opción "Click" para contar la cantidad de clics realizados.

8. Haz clic en la opción "Minijuego" para iniciar un minijuego, podrá ver las instrucciones antes de empezar a jugar.

---

## Uso

Al ejecutar la aplicación, aparecerá una ventana con un menú que contiene tres opciones: "Lapiz" (lápiz), "Click" y "Minijuego" (minijuego). Al seleccionar cada opción, se mostrará un panel correspondiente con la funcionalidad asociada.

**Dibujo**: Permite a los usuarios dibujar en un panel usando diferentes colores y un borrador.

**Contador de clicks**: Realiza un seguimiento de la cantidad de clicks del mouse realizados por el usuario.

**Minijuego**: Proporciona un minijuego en el que los usuarios interactúan con objetos que aparecen en diferentes posiciones de la pantall: mosquito, araña, banana y manzana. Dependiendo del tipo de objeto que aparezca, deberá realizar determinada acción con el mouse.

---

## Clases

El proyecto consta de las siguientes clases:

**ArquitecturaGlobal**: La clase principal que inicializa la ventana de la aplicación y configura los detectores de eventos del menú.

**OyenteMenu**: Una clase de escucha de eventos que maneja los eventos del mouse para las opciones del menú. Muestra y oculta los paneles apropiados según la opción seleccionada.

**Dibujo**: Representa el panel de dibujo donde los usuarios pueden dibujar. Proporciona funcionalidad para establecer el color o usar el borrador.

**PuntoColor**: Una clase que representa un punto coloreado en el lienzo. Almacena las coordenadas del punto, el color, el ancho y la altura.

**OyenteDibujo**: Una clase de escucha de eventos para el menú de dibujo. Maneja los eventos del mouse para cambiar el color del pincel o usar borrador.

**OyenteClick**: Una clase de detector de eventos para el panel de clicks. Realiza un seguimiento de la cantidad de clics del mouse realizados por el usuario.

**OyenteMinijuego**: Una clase de escucha de eventos para el panel de minijuegos. Maneja los eventos del mouse: dependiendo del tipo de objeto que aparezca la pantalla se debe clickear o arrastrar el objeto hacia el tacho de basura.

---

## interfaces usadas

### Interfaz MouseListener
Se usa para recibir eventos de mouse "interesantes" (presionar, soltar, hacer clic, ingresar y salir) en un componente. 
El objeto detector creado a partir de esa clase se registra luego con un componente utilizando el método addMouseListener del componente. 
Cuando ocurre un evento de mouse, se invoca el método relevante en el objeto detector y se le pasa MouseEvent.

#### Métodos
**mouseClicked**

Se invoca cuando se hace click en el botón del mouse (presionado y soltado) en un componente.

**mousePressed**

Se invoca cuando se presiona un botón del mouse sobre un componente.

**mouseReleased**

Se invoca cuando se suelta un botón del mouse en un componente.

**mouseEntered**

Se invoca cuando el mouse entra en un componente.

**mouseExited**

Se invoca cuando el mouse sale de un componente.

### Interfaz MouseListener
Se usa para recibir eventos de movimiento del mouse en un componente.

La clase que está interesada en procesar un evento de movimiento del mouse implementa esta interfaz (y todos los métodos que contiene).
Se genera un evento de movimiento del mouse cuando se mueve o arrastra el mouse. (Se generarán muchos de estos eventos). 
Cuando ocurre un evento de movimiento del mouse, se invoca el método relevante en el objeto de escucha y se le pasa MouseEvent.

#### Métodos
**mouseDragged**

Se invoca cuando se presiona un botón del mouse sobre un componente y luego se arrastra. Los eventos MOUSE_DRAGGED seguirán entregándose al componente donde se originó el arrastre hasta que se suelte el botón del mouse (independientemente de si la posición del mouse está dentro de los límites del componente).

**mouseMoved**

Se invoca cuando el cursor del mouse se ha movido a un componente pero no se ha presionado ningún botón.

---

## Capturas de pantalla
A continuación se muestran algunas capturas de pantalla de la aplicación:

**Menú principal**

![image](https://github.com/jazminrillo3/Eventos-del-mouse/assets/129994394/539371ad-63cc-4f73-a61d-aa4301b6a58a)

**Panel de dibujo**

![image](https://github.com/jazminrillo3/Eventos-del-mouse/assets/129994394/c33fe975-84b8-4fe7-bf53-b41139a58087)

**Contador de clicks**

![image](https://github.com/jazminrillo3/Eventos-del-mouse/assets/129994394/25343d05-1f6d-48d9-a76f-6b08ec3a0095)

**Minijuego**

![image](https://github.com/jazminrillo3/Eventos-del-mouse/assets/129994394/09190487-3dfb-44cf-8d6d-f58fd9ad4c1f)
![image](https://github.com/jazminrillo3/Eventos-del-mouse/assets/129994394/cde2400f-1040-4eea-b857-d3b50769786f)
