let numeroAtual: string = "";
let operador: string | null = null;
let num1: number | null = null;

const display = document.getElementById("display") as HTMLInputElement; 


// fazer funçoes de adicionarNumero(num: string), definirOperador(op: string) e limparDisplay() 
//funçao calcular () com switch(operador)

// if (numeroAnterior === null || operador === null || numeroAtual === "") return;
//const segundoNumero = parseFloat(numeroAtual);
//let resultado: number;

function adicionarNumero(num: string) {
    numeroAtual += num;
    display.value = numeroAtual;

}

function definirOperador(op: string) {

    if (numeroAtual == "") return;
    num1 = parseFloat(numeroAtual);
    operador = op;

}

function limparDisplay() {
    numeroAtual = "";
    operador = null;
    num1 = null;
    display.value = "";

}

function calcular() {
    if (num1 === null || operador === null || numeroAtual === "") return;

    const num2 = parseFloat(numeroAtual);
    let resultado: number;

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