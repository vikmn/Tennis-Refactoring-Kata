import { TennisGame } from './TennisGame';

class Player {
  name: string;
  score: number;

  constructor(name: string) {
    this.name = name;
    this.score = 0;
  }
}

export class TennisGame1 implements TennisGame {
  private player1: Player;
  private player2: Player;

  constructor(player1Name: string, player2Name: string) {
    this.player1 = new Player(player1Name);
    this.player2 = new Player(player2Name);
  }

  wonPoint(playerName: string): void {
    if (playerName === this.player1.name)
      this.player1.score += 1;
    else
      this.player2.score += 1;
  }

  getScore(): string {
    let score: string = '';
    let tempScore: number = 0;

    if (this.player1.score === this.player2.score) {
      return this.getEqualScore(this.player1.score);
    }

    if (this.player1.score >= 4 || this.player2.score >= 4) {
      return this.getAdvantageScore();
    }

    for (let i = 1; i < 3; i++) {
      if (i === 1) tempScore = this.player1.score;
      else {
        score += '-';
        tempScore = this.player2.score;
      }
      switch (tempScore) {
        case 0:
          score += 'Love';
          break;
        case 1:
          score += 'Fifteen';
          break;
        case 2:
          score += 'Thirty';
          break;
        case 3:
          score += 'Forty';
          break;
      }
    }
    return score;
  }

  private getAdvantageScore() {
    const minusResult: number = this.player1.score - this.player2.score;
    if (minusResult === 1) return 'Advantage player1';
    else if (minusResult === -1) return 'Advantage player2';
    else if (minusResult >= 2) return 'Win for player1';
    else return 'Win for player2';
  }

  private getEqualScore(score: number) {
    switch (score) {
      case 0:
        return 'Love-All';
      case 1:
        return 'Fifteen-All';
      case 2:
        return 'Thirty-All';
      default:
        return 'Deuce';
    }
  }
}
