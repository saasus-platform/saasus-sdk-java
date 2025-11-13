

# RespondToSignInChallengeResult

Result returned after responding to a sign-in challenge 

## Properties

| Name | Type | Description | Notes |
|------------ | ------------- | ------------- | -------------|
|**credentials** | [**Credentials**](Credentials.md) |  |  [optional] |
|**challengeName** | **ChallengeName** |  |  [optional] |
|**challengeParameters** | **Map&lt;String, String&gt;** | Parameters required for the next challenge.  |  [optional] |
|**session** | **String** | Session identifier for the challenge. This session should be passed to the next call to RespondToSignInChallenge if another challenge is required.  |  [optional] |



