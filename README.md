# GuessNumberFragment
María Molina Lorenzo

En esta versión hemos implementado Navigation, con el cual podremos interactuar entre los distintos fragments.

![image](https://user-images.githubusercontent.com/102946803/199311260-6d605954-b6f1-46fd-9f5e-bd6cfaa808fd.png)

A los fragments playFragment y endPlayFragment le hemos implementado un argument del tipo Custome Parcelable para que sea obligatorio pasarle un objeto Information a la
hora de pasarle la acción.

Si estamos en el último fragment, es dedir, en el EndPlayFragment y le damos al botón back volveremos al fragment anterior, PlayFragment, por lo que podremos jugar de 
nuevo con todos los intentos.

![image](https://user-images.githubusercontent.com/102946803/199314463-f3637309-aadd-4967-93b8-7ed777695bf4.png)![image](https://user-images.githubusercontent.com/102946803/199315967-e9e53492-bdd2-4089-ba10-ec43bb0a947f.png)

Para que esto no ocurra vamos a añadirle un PopUp a la acción que va del playFragment al endPlayFragment. Con el popUpTo hacemos que se destruya los fragments y se sitúe 
en el fragment que nosotros eligamos en el popUpTo, en esta caso elegimos el playFragment para que vuelva a este fragment.
El popUpToInclusive significa que también destruirá el fragment seleccionado en el popUpTo, por lo que volverá al fragment del inicio, configFragment.

![image](https://user-images.githubusercontent.com/102946803/199316244-4956f097-3419-4390-911f-26ad151f20f7.png)

![image](https://user-images.githubusercontent.com/102946803/199318544-95526a6a-f65a-4da2-bbff-095c0c20916e.png)

Este es el primer fragment, ConfigFragment, donde hay que introducir dos valores, el usuario y el número de intentos para adivinar el número.
Si le intentas dar al botón faltando algún dato sale el mensaje que muestra en la imagen y no te deja jugar hasta que introduzcas ambos valores.

![image](https://user-images.githubusercontent.com/102946803/199318656-51d46a77-6e6c-46b2-87aa-4f9cc8832138.png)

El segundo fragment es para comenzar a jugar, PlayFragment,  en donde debe introducir un número del 1 al 100 y para probarlo debe darle al botón "PROBAR", luego le pondrá un mensaje en donde
el número de intentos restantes y si el número a adivinar es mayor o menor que el que ha introducido.
Para volver a probar debe darle al botón "VOLVER A PROBAR", ya que cuando clicas el boton "PROBAR" se desactiva, y para volver a activarlo hay que darle al botón "VOLVER
A PROBAR", que también vacía el número introducido y el mensaje.

El último fragmentse muestra cuando el número de intentos se agota o el jugador ha adivinado el número:

![image](https://user-images.githubusercontent.com/102946803/199318772-6a43225c-48d1-43da-b510-672b1b709d4d.png)

Si el jugador ha acertado el número sale lo que muestra la imagen: el usuario, cuál era el número a adivinar y la cantidad de intentos que ha utilizado.

![image](https://user-images.githubusercontent.com/102946803/199318857-10419f59-f4b6-4d12-beea-dd2b335230a4.png)

Si el jugador ha gastado todos los intentos y no ha acertado el número saldrá lo que muestra la imagen: el usuario y el número a adivinar.



