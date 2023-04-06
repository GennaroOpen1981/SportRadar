# SportRadar
I realized the task implementing two classes Game and Scoreboard.
As in-memory structure I used an HashSet that is a collection basic from the java.util and in which every element is unique. Work on element of hash set is very simple (add//remove ...)
and every element of this is a Game. The operation have in Java a O(1) computational cost - constant.
The HashSet is not Thread safe like Hash Table, but I decided to let the final programmer handle outside (this library) the thread safety with a mutex for example
