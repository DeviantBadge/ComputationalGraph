grammar Expression;
// when changing this grammar file be shure, that nothing happens in StringExpressionGraphBuilder

@header {
    import java.util.HashMap;
}

@member {
    private HashMap<String, String> hahaha;
}

// todo function system
equation:
    expression relops expression;
expression:
    term (lowest_priority term)*;
term:
    factor (low_priority factor | composed_atom)*;
factor:
    signed_composed_atom (middle_priority signed_composed_atom)*;

signed_composed_atom:
    unary_left signed_composed_atom
    | composed_atom;

composed_atom:
    lexem expr_in_brackets
    | atom;

atom:
    atom unary_right
    | number
    | lexem
    | expr_in_brackets;

// todo add comma?
expr_in_brackets:
    L_ROUND_BR  expression R_ROUND_BR
    | L_SQUARE_BR expression R_SQUARE_BR
    | L_FIGURE_BR expression R_FIGURE_BR
    | ABS_BR expression ABS_BR;

number:
    SCIENTIFIC_NUMBER | FLOAT_NUMBER | INT_NUMBER;
lexem:
    LEXEM;

relops:
    EQ | GT | LT | GE | LE;
lowest_priority:
    PLUS | MINUS;
low_priority:
    TIMES | DIV | DOT_OP;
middle_priority:
    POW;

unary_left:
    PLUS | MINUS;
unary_right:
    FACTORIAL;


INT_NUMBER: INT_NUMBER_F;
FLOAT_NUMBER: FLOAT_NUMBER_F;
SCIENTIFIC_NUMBER: FLOAT_NUMBER_F (E SIGN? INT_NUMBER_F)?;
LEXEM: CHARACTER+ CHARACTER_OR_DIGIT*;


// Brackets
L_ROUND_BR: '(';
R_ROUND_BR: ')';
L_SQUARE_BR: '[';
R_SQUARE_BR: ']';
L_FIGURE_BR: '{';
R_FIGURE_BR: '}';
ABS_BR: '|';

// relation operations
GT: '>';
LT: '<';
GE: '>=';
LE: '<=';
EQ: '=';

// Operators
PLUS: '+';
MINUS: '-';
TIMES: '*';
DIV: '/';
POW: '^';
// special operators
DOT_OP: '.*';
FACTORIAL: '!';


//The integer part gets its potential sign from the signedAtom rule
fragment E: 'E' | 'e';
fragment DIGIT: [0-9];
fragment SIGN: ('+' | '-');
fragment CHARACTER: [a-zA-Z_];
fragment CHARACTER_OR_DIGIT: [a-zA-Z0-9_];
fragment DOT_CHAR_F: '.';

// Technical fragments
fragment INT_NUMBER_F: DIGIT+ ;
fragment FLOAT_NUMBER_F: DIGIT+ DOT_CHAR_F DIGIT;


WS:
    [ \r\n\t] + -> skip;

