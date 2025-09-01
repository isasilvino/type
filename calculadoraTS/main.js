var numeroAtual = "";
var operador = null;
var num1 = null;
var display = document.getElementById("display");
function adicionarNumero(num) {
    numeroAtual += num;
    display.value = numeroAtual;
}
function definirOperador(op) {
    if (numeroAtual == "")
        return;
    num1 = parseFloat(numeroAtual);
    operador = op;
    display.value = operador;
    numeroAtual = "";
}
function limparDisplay() {
    numeroAtual = "";
    operador = null;
    num1 = null;
    display.value = "";
}
function calcular() {
    if (num1 === null || operador === null || numeroAtual === "")
        return;
    var num2 = parseFloat(numeroAtual);
    var resultado;
    switch (operador) {
        case "+":
            resultado = num1 + num2;
            break;
        case "-":
            resultado = num1 - num2;
            break;
        case "*":
            resultado = num1 * num2;
            break;
        case "/":
            resultado = num1 / num2;
            break;
        default:
            resultado = NaN;
            break;
    }
    display.value = resultado.toString();
    numeroAtual = resultado.toString();
    operador = null;
    num1 = null;
}
