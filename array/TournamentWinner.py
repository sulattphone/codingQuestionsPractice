# From AlgoExpert

def tournamentWinner(competitions, results):
    # Write your code here.
    dict = {}
    max_score = 0
    winning_team = None

    for i in range(len(competitions)):
        home_team = competitions[i][0]
        away_team = competitions[i][1]

        result = results[i]
        if result == 1:
            dict[home_team] = dict.get(home_team, 0) + 3
            if dict.get(home_team) > max_score:
                max_score = dict.get(home_team)
                winning_team = home_team
        elif result == 0:
            dict[away_team] = dict.get(away_team, 0) + 3
            if dict.get(away_team) > max_score:
                max_score = dict.get(away_team)
                winning_team = away_team

    return winning_team
    
        
