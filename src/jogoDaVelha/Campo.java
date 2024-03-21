package jogoDaVelha;

public class Campo {
	private char simbolo; // Armazena o símbolo do campo

	// Construtor: define o símbolo como espaço em branco
	public Campo() {
		this.simbolo = ' ';
	}

	// Método para obter o símbolo do campo
	public char getSimbolo() {
		return simbolo;
	}

	// Método para definir o símbolo do campo
	public void setSimbolo(char simbolo) {
		// Verifica se o campo já foi usado
		if (this.simbolo == ' ') {
			this.simbolo = simbolo;
		} else {
			System.out.println("Campo já usado");
		}
	}
}
