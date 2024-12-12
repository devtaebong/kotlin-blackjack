# 🚀 2단계 - 블랙잭

## 기능 요구사항

블랙잭 게임은 딜러와 플레이어 중 카드의 합이 21 또는 21에 가장 가까운 숫자를 가지는 쪽이 이기는 게임이다.

- 카드의 숫자 계산은 카드 숫자를 기본으로 하며, 예외로 Ace는 1 또는 11로 계산할 수 있으며, King, Queen, Jack은 각각 10으로 계산한다.
- 게임을 시작하면 플레이어는 두 장의 카드를 지급 받으며, 두 장의 카드 숫자를 합쳐 21을 초과하지 않으면서 21에 가깝게 만들면 이긴다. 21을 넘지 않을 경우 원한다면 얼마든지 카드를 계속 뽑을 수 있다.

### 기능 리스트

- [x] 게임에 참여할 플레이어를 쉼표를 기준으로 입력받는다.
- [x] 카드의 종류는 `클로버, 스페이스, 하트, 다이아`이고 `ACE, 2 ~ 10, K, Q, J` 이다.
- [x] 덱에 존재하는 카드를 뽑는다.
- [x] 게임을 시작하면 각 플레이어에게 카드를 2장씩 나누어준다.
- [x] 나누어준 카드는 다시 나누어 줄 수 없다 -> 뽑힌 카드인지 상태를 관리
- [x] 플레이어가 y를 입력하면 카드를 한장 받는다.
- [x] n을 입력한 경우 카드를 더 받을 수 없다.
- [x] 카드의 합이 21을 넘으면 카드를 더 많을 수 없다.
- [x] `10, K, Q, J` 는 10으로 계산
- [ ] `ACE`는 1 또는 11로 계산
- [ ] 모든 플레이어가 카드를 더 받지 않는 경우 게임 종료 -> 승자를 찾는다.

### 블랙잭 용어 정리

- Hit: 플레이어가 카드를 한 장 더 요청하는 행동.
- Stand: 플레이어가 더 이상 카드를 뽑지 않고 현재 점수로 승부를 보는 행동.
- Double Down: 배팅 금액을 두 배로 올리고 카드를 딱 한 장만 더 받는 행동.
- Split: 처음 받은 두 카드가 같은 숫자일 경우 두 개의 독립적인 핸드로 나누어 플레이하는 행동.
- Bust: 플레이어 또는 딜러의 카드 합이 21을 초과하면 게임에서 패배하는 상태.
- Blackjack: 처음 받은 두 장의 카드 합이 정확히 21인 경우. 예: Ace(11) + 10(10).
- Push: 플레이어와 딜러의 점수가 같을 때, 배팅 금액이 반환되는 상태.
- Insurance: 딜러의 첫 카드가 Ace일 때, 딜러가 블랙잭일 가능성을 방지하기 위해 배팅 금액의 절반을 걸 수 있는 옵션.