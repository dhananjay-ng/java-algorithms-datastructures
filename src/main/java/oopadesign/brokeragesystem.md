public class Game {
  private Player[] players;
  private Board board;
  private Player currentTurn;
  private GameStatus status;
  private List<Move> movesPlayed;

  private void initialize(Player p1, Player p2) {
    players[0] = p1;
    players[1] = p2;

    board.resetBoard();

    if(p1.isWhiteSide()) {
      this.currentTurn = p1;
    } else {
      this.currentTurn = p2;
    }

    movesPlayed.clear();
  }

  public boolean isEnd() {
    return this.getStatus() != GameStatus.ACTIVE;
  }

  public boolean getStatus() {
    return this.status;
  }

  public void setStatus(GameStatus status) {
    this.status = status;
  }

  public boolean playerMove(Player player, int startX, int startY, int endX, int endY) {
      Box startBox = board.getBox(startX, startY);
      Box endBox = board.getBox(startY, endY);
      Move move = new Move(player, startBox, endBox);
      return this.makeMove(move, player);
  }

  private boolean makeMove(Move move, Player player) {
    Piece sourcePiece = move.getStart().getPiece();
    if (sourcePiece == null) {
      return false;
    }

    // valid player
    if (player != currentTurn) {
      return false;
    }

    if (sourcePiece.isWhite() != player.isWhiteSide()) {
      return false;
    }

    // valid move?
    if (!sourcePiece.canMove(board, move.getStart(), move.getEnd())){
      return false;
    }

    // kill?
    Piece destPiece = move.getStart().getPiece();
    if (destPiece != null) {
      destPiece.setKilled(true);
      move.setPieceKilled(destPiece);
    }

    // castling?
    if (sourcePiece != null && sourcePiece instanceof King
        && sourcePiece.isCastlingMove()) {
      move.setCastlingMove(true);
    }

    // store the move
    movesPlayed.add(move);

    // move piece from the stat box to end box
    move.getEnd().setPiece(move.getStart().getPiece());
    move.getStart.setPiece(null);

    if (destPiece != null && destPiece instanceof King) {
      if(player.isWhiteSide()) {
        this.setStatus(GameStatus.WHITE_WIN);
      } else {
        this.setStatus(GameStatus.BLACK_WIN);
      }
    }

    // set the current turn to the other player
    if(this.currentTurn == players[0]) {
      this.currentTurn = players[1];
    } else {
      this.currentTurn = players[0];
    }

    return true;
  }
}


public class StockExchange {

  private static StockExchange stockExchangeInstance = null;

  // private constructor to restrict for singleton
  private StockExchange() { }

  // static method to get the singleton instance of StockExchange
  public static StockExchange getInstance()
  {
    if(stockExchangeInstance == null) {
      stockExchangeInstance = new StockExchange();
    }
    return stockExchangeInstance;
  }

  public static boolean placeOrder(Order order) {
    boolean returnStatus = getInstance().submitOrder(Order);
    return returnStatus;
  }
}

public class StockExchange {

  private static StockExchange stockExchangeInstance = null;

  // private constructor to restrict for singleton
  private StockExchange() { }

  // static method to get the singleton instance of StockExchange
  public static StockExchange getInstance()
  {
    if(stockExchangeInstance == null) {
      stockExchangeInstance = new StockExchange();
    }
    return stockExchangeInstance;
  }

  public static boolean placeOrder(Order order) {
    boolean returnStatus = getInstance().submitOrder(Order);
    return returnStatus;
  }
}

// For simplicity, we are not defining getter and setter functions. The reader can
// assume that all class attributes are private and accessed through their respective
// public getter methods and modified only through their public methods function.

public abstract class Account {
  private String id;
  private String password;
  private String name;
  private AccountStatus status;
  private Location address;
  private String email;
  private String phone;

  public boolean resetPassword();
}

public class Member extends Account {
  private double availableFundsForTrading;
  private Date dateOfMembership;

  private HashMap<string, StockPosition> stockPositions;

  private HashMap<Integer, Order> activeOrders;

  public ErrorCode placeSellLimitOrder(
    string stockId,
    float quantity,
    int limitPrice,
    TimeEnforcementType enforcementType )
  {
    // check if member has this stock position
    if(!stockPositions.containsKey(stockId)){
      return NO_STOCK_POSITION;
    }

    StockPosition stockPosition = stockPosition.get(stockId);
    // check if the member has enough quantity available to sell
    if(stockPosition.getQuantity() < quantity){
      return INSUFFICIENT_QUANTITY;
    }

    LimitOrder order =
      new LimitOrder(stockId, quantity, limitPrice, enforcementType);
    order.isBuyOrder = false;
    order.saveInDB();
    boolean success = StockExchange::placeOrder(order);
    if(!success){
      order.setStatus(OrderStatus::FAILED);
      order.saveInDB();
    } else {
      activeOrders.add(orderId, order);
    }
    return success;
  }

  public ErrorCode placeBuyLimitOrder(
    string stockId,
    float quantity,
    int limitPrice,
    TimeEnforcementType enforcementType)
  {
    // check if the member has enough funds to buy this stock
    if(availableFundsForTrading < quantity * limitPrice ){
      return INSUFFICIENT_FUNDS;
    }

    LimitOrder order =
      new LimitOrder(stockId, quantity, limitPrice, enforcementType);
    order.isBuyOrder = true;
    order.saveInDB();
    boolean success = StockExchange::placeOrder(order);
    if(!success){
      order.setStatus(OrderStatus::FAILED);
      order.saveInDB();
    } else {
      activeOrders.add(orderId, order);
    }
    return success;
  }

  // this function will be invoked whenever there is an update from
  // stock exchange against an order
  public void callbackStockExchange(int orderId, List<OrderPart> orderParts, OrderStatus status) {
    Order order = activeOrders.get(orderId);
    order.addOrderParts(orderParts);
    order.setStatus(status);
    order.updateInDB();

    if (status == OrderStatus::FILLED || status == OrderStatus::CANCELLEd) {
      activeOrders.remove(orderId);
    }
  }
}