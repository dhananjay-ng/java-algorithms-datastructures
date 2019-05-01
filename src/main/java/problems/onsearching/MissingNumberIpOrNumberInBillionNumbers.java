package problems.onsearching;

import java.util.BitSet;
import java.util.Iterator;

public class MissingNumberIpOrNumberInBillionNumbers {
    /**
     * The storage capacity of hard drives dwarfs that of RAM. This can lead to interesting
     * space-time trade-offs.
     * Suppose you were given a file containing roughly one billion IP addresses, each of
     * which is a 32-bit quantity. How would you programmatically find an IP address that
     * is not in the file? Assume you have unlimited drive space but only a few megabytes
     * of RAM at your disposal.
     *
     * Space ~2^16 * 4bytes(quarter MB), time O(n)
     */
    public static int findMissingElement(Iterable<Integer> stream) {
        Iterator<Integer> s = stream.iterator();
        final int ipIndexSize = 1 << 16;
        int[] ipIndex = new int[ipIndexSize];
        //create index as 16bit prefix from IP Address
        while (s.hasNext()) {
            int ipValue = s.next() >>> 16;
            ++ipIndex[ipValue];
        }

        for (int i = 0; i < ipIndex.length; i++) {
            if (ipIndex[i] < ipIndexSize) {
                //if for that prefix entries are less than 2^16 then some entries with that
                //prefix are missing filw.
                BitSet bitSet = new BitSet(ipIndexSize);
                s = stream.iterator();
                while (s.hasNext()) {
                    int x = s.next();
                    if (i == (x >>> 16)) {
                        //put all the lower 16 bit's(right 16 bits) of entries from IP's with prefix as (i)(left 16bits)
                        bitSet.set((ipIndexSize - 1) & x);
                    }
                }
                //find missing entry from 2^16 ip in bitSet
                for (int j = 0; j < (1 << 16); j++) {
                    //check which lower 16bit's are missing in bitSet
                    if (!bitSet.get(j)) {
                        //generate ip using (left 16 bit (i<<16) + right 16 bit (j))
                        return (i << 16) | j;
                    }
                }

            }
        }
        return -1;
    }


}
