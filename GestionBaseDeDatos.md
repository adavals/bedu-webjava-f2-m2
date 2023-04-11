``@ElementCollection``

Anotacion utilizada para especificar que un atributo de entidad es una coleccion de elementos basicos, como
primitivos o su equivalente a objetos, o una coleccion de tipos de entidad incrustada.

Este se utiliza junto con la anotacion @CollectionTable, la cual especifica la tabla de base de
datos a utilizar para guardar los elementos de la coleccion.

Un ejemplo de esto puede ser:

```@Entity
public class Usuario {

    @Id 
    @GeneratedValue
    private long id;

    private String nombre; 

    @ElementCollection
    @CollectionTable(name = "Direcciones")
    private List<Direcciones> direcciones = new ArrayList<>();

    // getters and setters
}

```

La entidad Usuario tiene una coleccion de direcciones que esta representada por una lista de objetos "Direccion".
@ElementCollection sera utilizada para para especificar que es una coleccion de tipos de entidad incrustados, 
mientras que @CollectionTable especifica el nombre de la tabla de la base de datos en donde se almanezaran las
direcciones. 


```@CollectionTable```

Especifica los detalles de la tabla de base de datos que se utilizara para almacenar los elementos de una coleccion
incrustada.

Un ejemplo de esto es:

```@Entity
public class Usuario {
 
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
 
    private String nombre;
 
    @ElementCollection
    @CollectionTable(
      name = "usuario_direcciones",
      joinColumns = @JoinColumn(name = "usuario_id"))
    private List<Direccion> direcciones = new ArrayList<>();
 
    // Getters y setters
}
```

Esta anotacion nos permite especificar la columna de clave externa a utilizar para unir la coleccion de la tabla
con la coleccion principal. Para esto se utiliza ``@JoinColumn`` para especificar que la columna de la clave externa
se llamara "usuario_id".


`@MapKeyJoinColumn`

Anotacion utilizada para especificar la columna de clave externa en una tabla de relacion cuando se usa una asociacion
de clave-valor con Map y cuando las claves son tipos de entidades. En una asociacion de clave-valor, el mapa es una coleccion de pares clave-valor, donde a cada clave se le asigna un valor.

Un ejemplo de su uso es:

```@Entity
public class Pedido {
    @Id
    @GeneratedValue
    private Long id;

    private String nombre;

    @ElementCollection
    @CollectionTable(name = "LineasPedido")
    @MapKeyJoinColumn(name = "producto_id")
    private Map<Producto, LineaPedido> lineasPedido = new HashMap<>();

    // getters and setters
}
```

`@MapKeyJoinColumn` es utilizado para especificar la columna de clave externa que se utilizara en la tabla de relacion 
que se creara entre los elementos del mapa y sus valores. Este ejemplo especifica que la columna de clave externa sera
"producto_id". 
