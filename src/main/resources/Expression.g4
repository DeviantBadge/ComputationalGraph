grammar Expression;

@header {
    import java.util.HashMap;
}

// todo function system
equation: expression relops expression;
expression: term (lowest_priority term)*;
term: factor (low_priority factor)*;
factor: composed_atom (middle_priority composed_atom | atom)*;

composed_atom:
    unary_left composed_atom
    | math_functions composed_atom
    | atom;

atom:
    atom unary_right
    | number
    | special_constants
    | variable
    | expr_in_brackets;

// todo add comma?
expr_in_brackets:
    L_ROUND_BR  expression R_ROUND_BR
    | L_SQUARE_BR expression R_SQUARE_BR
    | L_FIGURE_BR expression R_FIGURE_BR
    | ABS_BR expression ABS_BR;

number:
    SCIENTIFIC_NUMBER | FLOAT_NUMBER | INT_NUMBER;
special_constants:
    E_CONST | PI_CONST;
variable:
    VAR_NAME;

// todo mb remove?
relops: EQ | GT | LT | GE | LE;
GT: '>';
LT: '<';
GE: '>=';
LE: '<=';
EQ: '=';

lowest_priority: PLUS | MINUS;
low_priority: TIMES | DIV;
middle_priority: POW;

unary_left: PLUS | MINUS;
unary_right: FACTORIAL;

math_functions: MATH_RESERVED;

MATH_RESERVED: CHARACTER_OR_DIGIT+ {getText().equals("sin")}?;
VAR_NAME: CHARACTER+ CHARACTER_OR_DIGIT* {!getText().startsWith("sin")}?;

INT_NUMBER: INT_NUMBER_F;
FLOAT_NUMBER: FLOAT_NUMBER_F;
SCIENTIFIC_NUMBER: FLOAT_NUMBER_F (E SIGN? INT_NUMBER_F)?;


// Brackets
L_ROUND_BR: '(';
R_ROUND_BR: ')';
L_SQUARE_BR: '[';
R_SQUARE_BR: ']';
L_FIGURE_BR: '{';
R_FIGURE_BR: '}';
ABS_BR: '|';


// Operators
PLUS: '+';
MINUS: '-';
TIMES: '*';
DIV: '/';
POW: '^';
// special operators
DOT_OP: 'dot';
DOT_CHAR: '.';
FACTORIAL: '!';

// todo move everything to some array with names
// Special constants
E_CONST: 'e' | 'E';
PI_CONST: 'pi' | 'Pi'| 'PI';

// math special functions
ABS: 'abs';
SQRT: 'sqrt';
CBRT: 'cbrt';
EXP: 'exp';
LOG: 'log';
LN:  'ln';
ERR:  'err';
GAMMA:  'gamma';
SIGMOID: 'sigmoid';
SIGNUM: 'signum';

//todo
MAX: 'max';
MIN: 'min';
RANDOM: 'random';
MEAN: 'mean';
NORM: 'norm';
SUM: 'sum';
STD: 'std';


COS:  'cos';
COSH: 'cosh';
SIN:  'sin';
SINH: 'sinh';
TAN:  'tan';
TANH: 'tanh';
CTAN: 'ctan';
CTANH:'ctanh';

ACOS: 'acos';
ARCCOS: 'arccos';
ASIN: 'asin';
ARCSIN: 'arcsin';

ACOSH: 'acosh';
ARCCOSH: 'arccosh';
ASINH: 'asinh';
ARCSINH: 'arcsinh';

ATAN: 'atan';
ARCTAN: 'arctan';
ATG:  'atg';
ARCTG:  'arctg';
ARCCTAN: 'arcctan';
ARCCTG:  'arcctg';

ATANH: 'atanh';
ARCTANH: 'arctanh';
ATGH:  'atgh';
ARCTGH:  'arctgh';
ARCCTANH: 'arcctanh';
ARCCTGH:  'arcctgh';


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

