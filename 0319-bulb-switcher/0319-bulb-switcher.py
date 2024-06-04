class Solution:
    def bulbSwitch(self, n: int) -> int:
        #nrounds nbulbs, the state of the bulb is toggled when its factor's round comes
        # say number 9, toggles at 1,3,9th rounds
        # so numbers with odd no of factors = stays on
        count=0
        for i in range(1,n+1):
            if (i**2 <=n):
                count+=1
            else:
                break
        return count