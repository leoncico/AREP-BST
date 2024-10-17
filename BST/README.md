# AREP-BST

Las pruebas implementadas son:

* testAddAndInOrderTraversal: Verifica que al agregar elementos al árbol, el recorrido en orden devuelva los elementos en orden ascendente. Se asegura de que la propiedad de un árbol de búsqueda binario se mantenga.

* testContains: Comprueba que el método contains identifique correctamente si un valor existe en el árbol. Se prueban valores que están presentes y otros que no.

* testRemoveLeafNode: Prueba la eliminación de un nodo hoja (sin hijos) y verifica si la estructura del árbol sigue siendo correcta después de la eliminación.

* testRemoveNodeWithOneChild: Testea la eliminación de un nodo que tiene solo un hijo. Se asegura de que el árbol mantenga su estructura adecuada tras la eliminación.

* testRemoveNodeWithTwoChildren: Verifica la correcta eliminación de un nodo que tiene dos hijos. Se comprueba que el sucesor en orden (el más pequeño del subárbol derecho) se maneje adecuadamente.

* testSize: Verifica que el método size retorne la cantidad correcta de nodos después de agregar y eliminar elementos. Se asegura de que el tamaño del árbol se mantenga actualizado.

* testClear: Prueba el método clear para asegurarse de que vacíe el árbol correctamente, y verifica que el tamaño sea cero y que el árbol esté vacío.

* testContainsAll: Verifica si el método containsAll funciona como se espera, comprobando si todos los elementos de una colección están presentes en el árbol.

* testAddAll: Prueba que el método addAll funcione correctamente al agregar múltiples elementos al árbol a la vez, y verifica que el recorrido en orden devuelva los elementos en el orden correcto.

* testAddAllWithIndex: Verifica que el método addAll(int index, Collection<? extends E> c) funcione correctamente, asegurándose de que los elementos se agreguen adecuadamente en la posición especificada.