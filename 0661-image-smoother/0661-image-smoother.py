class Solution:
    def imageSmoother(self, img: List[List[int]]) -> List[List[int]]:
        ans=[]
        n=len(img)
        m=len(img[0])
        for r,row in enumerate(img):
            ans.append([])
            for c,col in enumerate(row):
                s=0
                count=0
                for dx in range(-1,2):
                    for dy in range(-1,2):
                        if 0<=r+dx<n and 0<=c+dy<m:
                            s+=img[r+dx][c+dy]
                            count+=1
                ans[-1].append(s//count)
        return ans     