

# SignInResult

Result returned after a sign-in attempt 

## Properties

| Name | Type | Description | Notes |
|------------ | ------------- | ------------- | -------------|
|**challengeName** | **ChallengeName** |  |  [optional] |
|**challengeParameters** | **Map&lt;String, String&gt;** | Parameters required to complete the challenge  |  [optional] |
|**session** | **String** | Session identifier for the challenge. This session should be passed to the next call to RespondToSignInChallenge if another challenge is required.  |  [optional] |



