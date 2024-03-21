package jogoDaVelha;

import java.util.Scanner;

public class JogoDaVelha {

	public static void main(String[] args) {
		// Criando o tabuleiro do jogo
		Campo[][] jogo = new Campo[3][3];
		// Símbolo do jogador atual
		char simboloAtual = 'X';
		// Variável para controlar o jogo
		boolean game = true;
		// Armazena o vencedor
		String win = "";
		// Scanner para entrada do jogador
		Scanner sc = new Scanner(System.in);

		// Inicializando o tabuleiro
		iniciarJogo(jogo);

		// Loop principal do jogo
		while (game) {
			// Desenha o tabuleiro
			desenhaJogo(jogo);
			// Verifica se alguém ganhou
			win = verificarWin(jogo);
			// Se houve vencedor, mostra e termina o jogo
			if (!win.equals("")) {
				System.out.printf("Jogador %s Venceu %n", win);
				break;
			}
			try {
				// Pede ao jogador atual para fazer uma jogada
				if (verificarJogada(jogo, jogar(sc, simboloAtual), simboloAtual)) {
					// Se a jogada foi válida, muda de jogador
					if (simboloAtual == 'X') {
						simboloAtual = 'O';
					} else {
						simboloAtual = 'X';
					}
				}
			} catch (Exception e) {
				System.out.println("Erro");
			}
		}
		// Mensagem de fim de jogo
		System.out.println("Fim de Jogo");
	}

	// Desenha o tabuleiro
	public static void desenhaJogo(Campo[][] jogo) {
		limparTela();
		System.out.println("   0    1    2");
		for (int i = 0; i < 3; i++) {
			System.out.printf("%d   %c | %c | %c %n", i, jogo[i][0].getSimbolo(), jogo[i][1].getSimbolo(),
					jogo[i][2].getSimbolo());
			if (i < 2) {
				System.out.println("-----------------");
			}
		}
	}

	// Limpa a tela
	public static void limparTela() {
		for (int cont = 0; cont < 30; cont++) {
			System.out.println("");
		}
	}

	// Pede a jogada do jogador atual
	public static int[] jogar(Scanner sc, char simboloAtual) {
		int p[] = new int[2];
		System.out.printf("%s %c%n", "Sua vez: ", simboloAtual);
		System.out.print("Digite a linha: ");
		p[0] = sc.nextInt();
		System.out.print("Digite a coluna: ");
		p[1] = sc.nextInt();
		return p;
	}

	// Inicializa o tabuleiro
	public static void iniciarJogo(Campo[][] jogo) {
		for (int l = 0; l < 3; l++) {
			for (int c = 0; c < 3; c++) {
				jogo[l][c] = new Campo();
			}
		}
	}

	// Verifica se a jogada é válida e atualiza o tabuleiro
	public static boolean verificarJogada(Campo[][] jogo, int p[], char simboloAtual) {
		if (jogo[p[0]][p[1]].getSimbolo() == ' ') {
			jogo[p[0]][p[1]].setSimbolo(simboloAtual);
			return true;
		} else {
			return false;
		}
	}

	// Verifica se alguém ganhou
	public static String verificarWin(Campo[][] jogo) {
		// Verifica linhas
		for (int i = 0; i < 3; i++) {
			if (jogo[i][0].getSimbolo() != ' ' && jogo[i][0].getSimbolo() == jogo[i][1].getSimbolo()
					&& jogo[i][0].getSimbolo() == jogo[i][2].getSimbolo()) {
				return String.valueOf(jogo[i][0].getSimbolo());
			}
		}

		// Verifica colunas
		for (int i = 0; i < 3; i++) {
			if (jogo[0][i].getSimbolo() != ' ' && jogo[0][i].getSimbolo() == jogo[1][i].getSimbolo()
					&& jogo[0][i].getSimbolo() == jogo[2][i].getSimbolo()) {
				return String.valueOf(jogo[0][i].getSimbolo());
			}
		}

		// Verifica diagonal principal
		if (jogo[0][0].getSimbolo() != ' ' && jogo[0][0].getSimbolo() == jogo[1][1].getSimbolo()
				&& jogo[0][0].getSimbolo() == jogo[2][2].getSimbolo()) {
			return String.valueOf(jogo[0][0].getSimbolo());
		}

		// Verifica diagonal secundária
		if (jogo[0][2].getSimbolo() != ' ' && jogo[0][2].getSimbolo() == jogo[1][1].getSimbolo()
				&& jogo[0][2].getSimbolo() == jogo[2][0].getSimbolo()) {
			return String.valueOf(jogo[0][2].getSimbolo());
		}

		// Se não houver vencedor, retorna uma string vazia
		return "";
	}
}
