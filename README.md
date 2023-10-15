# Testes de Alocação de Recursos para uma Pod

## Objetivo do Teste

Temos uma pod que aloca 2GB de memória em RAM. Nosso objetivo é definir as melhores práticas para alocação de recursos.

## Teste 1: Sem limitação no arquivo de deployment

- **Resultado**: A pod roda com sucesso.
- **Observações**:
    - Não existe limitação para a JVM.
    - Não consegui medir a alocação efetiva de memória. (TODO)

## Teste 2: Sem flags para a JVM, mas com limitação no deployment

- **Resultado**: A JVM aloca 25% da memória disponível no `Limit` para si.

## Teste 3: Usando a flag `-XX:+UseContainerSupport` para a JVM

- **Resultado**: A pod morre com 1.2GB de memória alocada.
- **Observações**:
    - A JVM aloca 50% da memória definida em `resources.limits` para a heap.

## Teste 4: Usando a flag `-XX:MaxRAMPercentage=90.0`

- **Resultado**: A execução chega ao fim com sucesso.
- **Observações**:
    - A JVM aloca para si 90% da memória definida em `resources.limits`.
