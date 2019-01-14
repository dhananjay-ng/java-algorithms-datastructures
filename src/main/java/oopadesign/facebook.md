public enum ConnectionInvitationStatus{
  PENDING,
  ACCEPTED,
  REJECTED,
  CANCELED
}

public enum AccountStatus{
  ACTIVE,
  CLOSED,
  CANCELED,
  BLACKLISTED,
  DISABLED
}

public class Address {
  private String streetAddress;
  private String city;
  private String state;
  private String zipCode;
  private String country;
}



public enum ConnectionInvitationStatus{
  PENDING,
  ACCEPTED,
  REJECTED,
  CANCELED
}

public enum AccountStatus{
  ACTIVE,
  CLOSED,
  CANCELED,
  BLACKLISTED,
  DISABLED
}

public class Address {
  private String streetAddress;
  private String city;
  private String state;
  private String zipCode;
  private String country;
}


public enum ConnectionInvitationStatus{
  PENDING,
  ACCEPTED,
  REJECTED,
  CANCELED
}

public enum AccountStatus{
  ACTIVE,
  CLOSED,
  CANCELED,
  BLACKLISTED,
  DISABLED
}

public class Address {
  private String streetAddress;
  private String city;
  private String state;
  private String zipCode;
  private String country;
}


public class Page {
  private Integer pageId;
  private String name;
  private String description;
  private String type;
  private int totalMembers;
  private List<Recommendation> recommendation;

  private List<Recommendation> getRecommendation();
}

public class Recommendation {
  private Integer recommendationId;
  private int rating;
  private String description;
  private Date createdAt;
}


public class Group {
  private Integer groupId;
  private String name;
  private String description;
  private int totalMembers;
  private List<Member> members;

  public boolean addMember(Member member);
  public boolean updateDescription(String description);
}

public class Post {
  private Integer postId;
  private String text;
  private int totalLikes;
  private int totalShares;
  private Member owner;
}

public class Message {
  private Integer messageId;
  private Member[] sentTo;
  private String messageBody;
  private byte[] media;

  public boolean addMember(Member member);
}

public class Comment {
  private Integer commentId;
  private String text;
  private int totalLikes;
  private Member owner;
}

public class Group {
  private Integer groupId;
  private String name;
  private String description;
  private int totalMembers;
  private List<Member> members;

  public boolean addMember(Member member);
  public boolean updateDescription(String description);
}

public class Post {
  private Integer postId;
  private String text;
  private int totalLikes;
  private int totalShares;
  private Member owner;
}

public class Message {
  private Integer messageId;
  private Member[] sentTo;
  private String messageBody;
  private byte[] media;

  public boolean addMember(Member member);
}

public class Comment {
  private Integer commentId;
  private String text;
  private int totalLikes;
  private Member owner;
}


import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.stream.Collectors;
import static java.util.Collections.reverseOrder;

public class Member extends Person {
  private Integer memberId;
  private Date dateOfMembership;
  private String name;

  private Profile profile;
  private HashSet<Integer> memberFollows;
  private HashSet<Integer> memberConnections;
  private HashSet<Integer> pageFollows;
  private HashSet<Integer> memberSuggestions;
  private HashSet<ConnectionInvitation> connectionInvitations;
  private HashSet<Integer> groupFollows;

  public boolean sendMessage(Message message);
  public boolean createPost(Post post);
  public boolean sendConnectionInvitation(ConnectionInvitation invitation);

  private Map<Integer, Integer> searchMemberSuggestions() {
    Map<Integer, Integer> suggestions = new HashMap<>();
    for(Integer memberId : this.memberConnections) {
      HashSet<Integer> firstLevelConnections = new Member(memberId).getMemberConnections());
      for(Integer firstLevelConnectionId : firstLevelConnections) {
        this.findMemberSuggestion(suggestions, firstLevelConnectionId);
        HashSet<Integer> secondLevelConnections = new Member(firstLevelConnectionId).getMemberConnections());
        for(Integer secondLevelConnectionId : secondLevelConnections) {
          this.findMemberSuggestion(suggestions, secondLevelConnectionId);
        }
      }
	  }

    // sort by value (increasing count), i.e., by highest number of mutual connection count
    Map<Integer, Integer> result = new LinkedHashMap<>();
    suggestions.entrySet().stream()
        .sorted(reverseOrder(Map.Entry.comparingByValue()))
        .forEachOrdered(x -> result.put(x.getKey(), x.getValue()));

    return result;
  }

  private void findMemberSuggestion(Map<Integer, Integer> suggestions, Integer connectionId) {
    // return if the proposed suggestion is already a connection or if there is a
    // pending connection invitation
    if(this.memberConnections.contains(connectionId) ||
        this.connectionInvitations.contains(connectionId)) {
      return;
    }

    int count = suggestions.containsKey(connectionId) ? suggestions.get(connectionId) : 0;
    suggestions.put(connectionId, count + 1);
  }
}