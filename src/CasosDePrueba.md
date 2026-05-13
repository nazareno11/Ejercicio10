# Casos de prueba (Gherkin)

Feature: Gestión de productos

  Como usuario del sistema
  Quiero poder administrar productos
  Para mantener un catálogo actualizado

  Scenario: Crear un producto correctamente
    Given que el sistema está en funcionamiento
    When envío una solicitud POST a /productos con nombre "Teclado" y precio 15000
    Then el sistema responde con código 200
    And el producto queda guardado en la base de datos

  Scenario: Listar todos los productos
    Given que existen productos cargados en el sistema
    When envío una solicitud GET a /productos
    Then el sistema responde con código 200
    And devuelve una lista de productos

  Scenario: Obtener un producto por ID existente
    Given que existe un producto con ID 1
    When envío una solicitud GET a /productos/1
    Then el sistema responde con código 200
    And devuelve los datos del producto

  Scenario: Obtener un producto por ID inexistente
    Given que no existe un producto con ID 999
    When envío una solicitud GET a /productos/999
    Then el sistema responde con código 404

  Scenario: Eliminar un producto existente
    Given que existe un producto con ID 1
    When envío una solicitud DELETE a /productos/1
    Then el sistema responde con código 200
    And el producto ya no existe en el sistema