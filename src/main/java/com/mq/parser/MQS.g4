// Define a grammar called MQS
grammar MQS;

ID : LETTER (LETTER|DIGIT)*;
fragment LETTER : [A-Za-z\u0080-\u00FF_\u002E\u2010\u2011\u002D] ; //

NUMBER : '-'? ('.' DIGIT+ | DIGIT+ ('.' DIGIT*)? ) ;
fragment DIGIT : [0-9] ;

PUNCTUATION : [\u0028\u0029\u005B\u005D\u007B\u007D=,:;_@/#&\u002E\u2010\u2011\u002D]+ ;

WORD_VERSION : 'V' DIGIT+ ('.' DIGIT*)+ ;
SERVER_IP : NUMBER'.'NUMBER'.'NUMBER'.'NUMBER ;
VAL_TIME_1 : NUMBER '.' NUMBER '.' NUMBER ;
VAL_TIME_2 : NUMBER ':' NUMBER ':' NUMBER ;
VAL_DATE : NUMBER '-' NUMBER '-' NUMBER ;
STRING : '\'' ('\\"'|.)*? '\'' ;
TOPICSTRING: ([A-Z]/[A-Z])*?;
	
WS : [ \t]+ -> skip;        // whitespace
NEWLINE: '\r'? '\n'  ;


objectCommand : (objectDefinition NEWLINE)*;

objectDefinition : objectDefinitionHeader  (property | emptyProperty)* ;

objectDefinitionHeader : ('DEFINE'|'ALTER'|'DELETE') ID '('value')'  ;
						
property :  ID  '('value')';

emptyProperty : ID;

value : STRING #STRING
	|NUMBER    #NUMBER
	|ID        #ID
	|VAL_TIME_1  #TIME1
	|VAL_TIME_2  #TIME2
	|VAL_DATE  #DATE
	;