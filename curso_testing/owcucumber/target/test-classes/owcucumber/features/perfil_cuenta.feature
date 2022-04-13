Feature: Editar Perfil del Usuario
  Es posible consultar y modifica la información de la cuenta de un usuario.
  Además es posible ver la información de su perfil público

  Scenario: Consulta1 Perfil Público
    Given la interfaz web de la aplicación iniciada
    And un usuario ya logado con perfil de formador
    When voy a la sección del perfil público
    Then puedo consultar la información referente al usuario
