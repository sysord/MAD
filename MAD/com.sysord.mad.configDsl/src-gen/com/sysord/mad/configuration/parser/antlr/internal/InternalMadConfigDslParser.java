package com.sysord.mad.configuration.parser.antlr.internal; 

import org.eclipse.xtext.*;
import org.eclipse.xtext.parser.*;
import org.eclipse.xtext.parser.impl.*;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.common.util.Enumerator;
import org.eclipse.xtext.parser.antlr.AbstractInternalAntlrParser;
import org.eclipse.xtext.parser.antlr.XtextTokenStream;
import org.eclipse.xtext.parser.antlr.XtextTokenStream.HiddenTokens;
import org.eclipse.xtext.parser.antlr.AntlrDatatypeRuleToken;
import com.sysord.mad.configuration.services.MadConfigDslGrammarAccess;



import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

@SuppressWarnings("all")
public class InternalMadConfigDslParser extends AbstractInternalAntlrParser {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "RULE_STRING", "RULE_ID", "RULE_INT", "RULE_ML_COMMENT", "RULE_SL_COMMENT", "RULE_WS", "RULE_ANY_OTHER", "'import'", "'from plugin'", "'label:'", "'='", "'+'", "'Use icon'", "'description:'", "'location:'", "'URI:'", "'Use I18N Bundle'", "'Foreign Model'", "'{'", "'model type:'", "'synchronizer factory'", "':'", "'extension manager'", "'model locator:'", "'}'", "'Uri Extension:'", "'Model Uri:'", "'Provider Class:'", "'parameters:'", "','", "'Xtext DSL:'", "'language Id:'", "'from bundle:'", "'with activator:'", "'DSL:'", "'Query Evaluator'", "'language id:'", "'Evaluator'", "'Class:'", "'query Properties type:'", "'external query provider:'", "'Widget type'", "'name:'", "'category:'", "'custom widget:'", "'UI'", "'Tab'", "'id:'", "'I18N'", "'Layer'", "'Sub'", "'layers'", "'DEFAULT'", "'Configuration'", "'for'", "'label provider:'", "'extends:'", "'template:'", "'layout:'", "'include widget:'", "'source template:'", "'value:'", "'Query'", "'widget:'", "'tab:'", "'layers:'", "'type:'", "'flexible template:'", "'target template:'", "'visible when:'", "'editable when:'", "'valueConverter:'", "'validators:'", "'format:'", "'candidates:'", "'item label:'", "'commands:'", "'validation rule:'", "'Error message:'", "'Common Command'", "'icon:'", "'action:'", "'on success:'", "'on error:'", "'('", "')'", "'Display view'", "'Reload'", "'view'", "'widgets:'", "'Common Query'", "'language:'", "'foreign model:'", "'context locator:'", "'properties:'", "'Optimisation:'", "'call'", "'()'", "'Query Chain'", "'Macro:'", "'#'", "'DATE'", "'DATETIME'", "'INTEGER'", "'FLOAT'", "'DOUBLE'", "'XTEXT'", "'OUTPUTTEXT_WIDGET'", "'NAVIGATION_WIDGET'", "'TEXT_WIDGET'", "'BOOL_WIDGET'", "'DATE_WIDGET'", "'NUMBER_WIDGET'", "'SINGLE_SELECT_WIDGET'", "'MULTI_SELECT_WIDGET'", "'XTEXT_EDITOR'", "'XTEXT_TEXT_EDITOR'", "'FLEXIBLE_WIDGET'", "'UPDATE_COMMAND'", "'GLOBAL_COMMAND'", "'ITEM_COMMAND'", "'NONE'", "'VIEW'", "'CONTEXT'"
    };
    public static final int RULE_ID=5;
    public static final int T__29=29;
    public static final int T__28=28;
    public static final int T__27=27;
    public static final int T__26=26;
    public static final int T__25=25;
    public static final int T__24=24;
    public static final int T__23=23;
    public static final int T__22=22;
    public static final int RULE_ANY_OTHER=10;
    public static final int T__21=21;
    public static final int T__20=20;
    public static final int EOF=-1;
    public static final int T__93=93;
    public static final int T__19=19;
    public static final int T__94=94;
    public static final int T__91=91;
    public static final int T__92=92;
    public static final int T__16=16;
    public static final int T__15=15;
    public static final int T__90=90;
    public static final int T__18=18;
    public static final int T__17=17;
    public static final int T__12=12;
    public static final int T__11=11;
    public static final int T__14=14;
    public static final int T__13=13;
    public static final int T__99=99;
    public static final int T__98=98;
    public static final int T__97=97;
    public static final int T__96=96;
    public static final int T__95=95;
    public static final int T__80=80;
    public static final int T__81=81;
    public static final int T__82=82;
    public static final int T__83=83;
    public static final int T__85=85;
    public static final int T__84=84;
    public static final int T__87=87;
    public static final int T__86=86;
    public static final int T__89=89;
    public static final int T__88=88;
    public static final int RULE_ML_COMMENT=7;
    public static final int T__126=126;
    public static final int T__125=125;
    public static final int RULE_STRING=4;
    public static final int T__127=127;
    public static final int T__71=71;
    public static final int T__72=72;
    public static final int T__70=70;
    public static final int T__76=76;
    public static final int T__75=75;
    public static final int T__74=74;
    public static final int T__73=73;
    public static final int T__79=79;
    public static final int T__78=78;
    public static final int T__77=77;
    public static final int T__68=68;
    public static final int T__69=69;
    public static final int T__66=66;
    public static final int T__67=67;
    public static final int T__64=64;
    public static final int T__65=65;
    public static final int T__62=62;
    public static final int T__63=63;
    public static final int T__118=118;
    public static final int T__119=119;
    public static final int T__116=116;
    public static final int T__117=117;
    public static final int T__114=114;
    public static final int T__115=115;
    public static final int T__124=124;
    public static final int T__123=123;
    public static final int T__122=122;
    public static final int T__121=121;
    public static final int T__120=120;
    public static final int T__61=61;
    public static final int T__60=60;
    public static final int T__55=55;
    public static final int T__56=56;
    public static final int T__57=57;
    public static final int T__58=58;
    public static final int T__51=51;
    public static final int T__52=52;
    public static final int T__53=53;
    public static final int T__54=54;
    public static final int T__107=107;
    public static final int T__108=108;
    public static final int T__109=109;
    public static final int T__103=103;
    public static final int T__59=59;
    public static final int T__104=104;
    public static final int T__105=105;
    public static final int T__106=106;
    public static final int T__111=111;
    public static final int T__110=110;
    public static final int RULE_INT=6;
    public static final int T__113=113;
    public static final int T__112=112;
    public static final int T__50=50;
    public static final int T__42=42;
    public static final int T__43=43;
    public static final int T__40=40;
    public static final int T__41=41;
    public static final int T__46=46;
    public static final int T__47=47;
    public static final int T__44=44;
    public static final int T__45=45;
    public static final int T__48=48;
    public static final int T__49=49;
    public static final int T__102=102;
    public static final int T__101=101;
    public static final int T__100=100;
    public static final int RULE_SL_COMMENT=8;
    public static final int T__30=30;
    public static final int T__31=31;
    public static final int T__32=32;
    public static final int T__33=33;
    public static final int T__34=34;
    public static final int T__35=35;
    public static final int T__36=36;
    public static final int T__37=37;
    public static final int T__38=38;
    public static final int T__39=39;
    public static final int RULE_WS=9;

    // delegates
    // delegators


        public InternalMadConfigDslParser(TokenStream input) {
            this(input, new RecognizerSharedState());
        }
        public InternalMadConfigDslParser(TokenStream input, RecognizerSharedState state) {
            super(input, state);
             
        }
        

    public String[] getTokenNames() { return InternalMadConfigDslParser.tokenNames; }
    public String getGrammarFileName() { return "../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g"; }



     	private MadConfigDslGrammarAccess grammarAccess;
     	
        public InternalMadConfigDslParser(TokenStream input, MadConfigDslGrammarAccess grammarAccess) {
            this(input);
            this.grammarAccess = grammarAccess;
            registerRules(grammarAccess.getGrammar());
        }
        
        @Override
        protected String getFirstRuleName() {
        	return "MADConfiguration";	
       	}
       	
       	@Override
       	protected MadConfigDslGrammarAccess getGrammarAccess() {
       		return grammarAccess;
       	}



    // $ANTLR start "entryRuleMADConfiguration"
    // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:68:1: entryRuleMADConfiguration returns [EObject current=null] : iv_ruleMADConfiguration= ruleMADConfiguration EOF ;
    public final EObject entryRuleMADConfiguration() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleMADConfiguration = null;


        try {
            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:69:2: (iv_ruleMADConfiguration= ruleMADConfiguration EOF )
            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:70:2: iv_ruleMADConfiguration= ruleMADConfiguration EOF
            {
             newCompositeNode(grammarAccess.getMADConfigurationRule()); 
            pushFollow(FOLLOW_ruleMADConfiguration_in_entryRuleMADConfiguration75);
            iv_ruleMADConfiguration=ruleMADConfiguration();

            state._fsp--;

             current =iv_ruleMADConfiguration; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleMADConfiguration85); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleMADConfiguration"


    // $ANTLR start "ruleMADConfiguration"
    // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:77:1: ruleMADConfiguration returns [EObject current=null] : ( ( (lv_imports_0_0= ruleImport ) )* ( (lv_configElements_1_0= ruleMADConfigElement ) )* ) ;
    public final EObject ruleMADConfiguration() throws RecognitionException {
        EObject current = null;

        EObject lv_imports_0_0 = null;

        EObject lv_configElements_1_0 = null;


         enterRule(); 
            
        try {
            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:80:28: ( ( ( (lv_imports_0_0= ruleImport ) )* ( (lv_configElements_1_0= ruleMADConfigElement ) )* ) )
            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:81:1: ( ( (lv_imports_0_0= ruleImport ) )* ( (lv_configElements_1_0= ruleMADConfigElement ) )* )
            {
            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:81:1: ( ( (lv_imports_0_0= ruleImport ) )* ( (lv_configElements_1_0= ruleMADConfigElement ) )* )
            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:81:2: ( (lv_imports_0_0= ruleImport ) )* ( (lv_configElements_1_0= ruleMADConfigElement ) )*
            {
            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:81:2: ( (lv_imports_0_0= ruleImport ) )*
            loop1:
            do {
                int alt1=2;
                int LA1_0 = input.LA(1);

                if ( (LA1_0==11) ) {
                    alt1=1;
                }


                switch (alt1) {
            	case 1 :
            	    // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:82:1: (lv_imports_0_0= ruleImport )
            	    {
            	    // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:82:1: (lv_imports_0_0= ruleImport )
            	    // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:83:3: lv_imports_0_0= ruleImport
            	    {
            	     
            	    	        newCompositeNode(grammarAccess.getMADConfigurationAccess().getImportsImportParserRuleCall_0_0()); 
            	    	    
            	    pushFollow(FOLLOW_ruleImport_in_ruleMADConfiguration131);
            	    lv_imports_0_0=ruleImport();

            	    state._fsp--;


            	    	        if (current==null) {
            	    	            current = createModelElementForParent(grammarAccess.getMADConfigurationRule());
            	    	        }
            	           		add(
            	           			current, 
            	           			"imports",
            	            		lv_imports_0_0, 
            	            		"Import");
            	    	        afterParserOrEnumRuleCall();
            	    	    

            	    }


            	    }
            	    break;

            	default :
            	    break loop1;
                }
            } while (true);

            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:99:3: ( (lv_configElements_1_0= ruleMADConfigElement ) )*
            loop2:
            do {
                int alt2=2;
                int LA2_0 = input.LA(1);

                if ( (LA2_0==16||(LA2_0>=20 && LA2_0<=21)||LA2_0==34||LA2_0==39||LA2_0==45||LA2_0==49||LA2_0==53||(LA2_0>=56 && LA2_0<=57)||LA2_0==83||LA2_0==94||LA2_0==103) ) {
                    alt2=1;
                }


                switch (alt2) {
            	case 1 :
            	    // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:100:1: (lv_configElements_1_0= ruleMADConfigElement )
            	    {
            	    // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:100:1: (lv_configElements_1_0= ruleMADConfigElement )
            	    // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:101:3: lv_configElements_1_0= ruleMADConfigElement
            	    {
            	     
            	    	        newCompositeNode(grammarAccess.getMADConfigurationAccess().getConfigElementsMADConfigElementParserRuleCall_1_0()); 
            	    	    
            	    pushFollow(FOLLOW_ruleMADConfigElement_in_ruleMADConfiguration153);
            	    lv_configElements_1_0=ruleMADConfigElement();

            	    state._fsp--;


            	    	        if (current==null) {
            	    	            current = createModelElementForParent(grammarAccess.getMADConfigurationRule());
            	    	        }
            	           		add(
            	           			current, 
            	           			"configElements",
            	            		lv_configElements_1_0, 
            	            		"MADConfigElement");
            	    	        afterParserOrEnumRuleCall();
            	    	    

            	    }


            	    }
            	    break;

            	default :
            	    break loop2;
                }
            } while (true);


            }


            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleMADConfiguration"


    // $ANTLR start "entryRuleMADConfigElement"
    // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:125:1: entryRuleMADConfigElement returns [EObject current=null] : iv_ruleMADConfigElement= ruleMADConfigElement EOF ;
    public final EObject entryRuleMADConfigElement() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleMADConfigElement = null;


        try {
            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:126:2: (iv_ruleMADConfigElement= ruleMADConfigElement EOF )
            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:127:2: iv_ruleMADConfigElement= ruleMADConfigElement EOF
            {
             newCompositeNode(grammarAccess.getMADConfigElementRule()); 
            pushFollow(FOLLOW_ruleMADConfigElement_in_entryRuleMADConfigElement190);
            iv_ruleMADConfigElement=ruleMADConfigElement();

            state._fsp--;

             current =iv_ruleMADConfigElement; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleMADConfigElement200); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleMADConfigElement"


    // $ANTLR start "ruleMADConfigElement"
    // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:134:1: ruleMADConfigElement returns [EObject current=null] : (this_LayerMdsl_0= ruleLayerMdsl | this_ForeignModelMdsl_1= ruleForeignModelMdsl | this_XtextLanguageDescriptorMdsl_2= ruleXtextLanguageDescriptorMdsl | this_QueryEvaluatorMdsl_3= ruleQueryEvaluatorMdsl | this_QueryDeclaration_4= ruleQueryDeclaration | this_WidgetType_5= ruleWidgetType | this_UITabMdsl_6= ruleUITabMdsl | this_CommandDeclaration_7= ruleCommandDeclaration | this_TypeConfigurationMdsl_8= ruleTypeConfigurationMdsl | this_TextMacro_9= ruleTextMacro | this_I18NBundleMdsl_10= ruleI18NBundleMdsl | this_IconDescriptorMdsl_11= ruleIconDescriptorMdsl ) ;
    public final EObject ruleMADConfigElement() throws RecognitionException {
        EObject current = null;

        EObject this_LayerMdsl_0 = null;

        EObject this_ForeignModelMdsl_1 = null;

        EObject this_XtextLanguageDescriptorMdsl_2 = null;

        EObject this_QueryEvaluatorMdsl_3 = null;

        EObject this_QueryDeclaration_4 = null;

        EObject this_WidgetType_5 = null;

        EObject this_UITabMdsl_6 = null;

        EObject this_CommandDeclaration_7 = null;

        EObject this_TypeConfigurationMdsl_8 = null;

        EObject this_TextMacro_9 = null;

        EObject this_I18NBundleMdsl_10 = null;

        EObject this_IconDescriptorMdsl_11 = null;


         enterRule(); 
            
        try {
            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:137:28: ( (this_LayerMdsl_0= ruleLayerMdsl | this_ForeignModelMdsl_1= ruleForeignModelMdsl | this_XtextLanguageDescriptorMdsl_2= ruleXtextLanguageDescriptorMdsl | this_QueryEvaluatorMdsl_3= ruleQueryEvaluatorMdsl | this_QueryDeclaration_4= ruleQueryDeclaration | this_WidgetType_5= ruleWidgetType | this_UITabMdsl_6= ruleUITabMdsl | this_CommandDeclaration_7= ruleCommandDeclaration | this_TypeConfigurationMdsl_8= ruleTypeConfigurationMdsl | this_TextMacro_9= ruleTextMacro | this_I18NBundleMdsl_10= ruleI18NBundleMdsl | this_IconDescriptorMdsl_11= ruleIconDescriptorMdsl ) )
            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:138:1: (this_LayerMdsl_0= ruleLayerMdsl | this_ForeignModelMdsl_1= ruleForeignModelMdsl | this_XtextLanguageDescriptorMdsl_2= ruleXtextLanguageDescriptorMdsl | this_QueryEvaluatorMdsl_3= ruleQueryEvaluatorMdsl | this_QueryDeclaration_4= ruleQueryDeclaration | this_WidgetType_5= ruleWidgetType | this_UITabMdsl_6= ruleUITabMdsl | this_CommandDeclaration_7= ruleCommandDeclaration | this_TypeConfigurationMdsl_8= ruleTypeConfigurationMdsl | this_TextMacro_9= ruleTextMacro | this_I18NBundleMdsl_10= ruleI18NBundleMdsl | this_IconDescriptorMdsl_11= ruleIconDescriptorMdsl )
            {
            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:138:1: (this_LayerMdsl_0= ruleLayerMdsl | this_ForeignModelMdsl_1= ruleForeignModelMdsl | this_XtextLanguageDescriptorMdsl_2= ruleXtextLanguageDescriptorMdsl | this_QueryEvaluatorMdsl_3= ruleQueryEvaluatorMdsl | this_QueryDeclaration_4= ruleQueryDeclaration | this_WidgetType_5= ruleWidgetType | this_UITabMdsl_6= ruleUITabMdsl | this_CommandDeclaration_7= ruleCommandDeclaration | this_TypeConfigurationMdsl_8= ruleTypeConfigurationMdsl | this_TextMacro_9= ruleTextMacro | this_I18NBundleMdsl_10= ruleI18NBundleMdsl | this_IconDescriptorMdsl_11= ruleIconDescriptorMdsl )
            int alt3=12;
            switch ( input.LA(1) ) {
            case 53:
                {
                alt3=1;
                }
                break;
            case 21:
                {
                alt3=2;
                }
                break;
            case 34:
                {
                alt3=3;
                }
                break;
            case 39:
                {
                alt3=4;
                }
                break;
            case 94:
                {
                alt3=5;
                }
                break;
            case 45:
                {
                alt3=6;
                }
                break;
            case 49:
                {
                alt3=7;
                }
                break;
            case 83:
                {
                alt3=8;
                }
                break;
            case 56:
            case 57:
                {
                alt3=9;
                }
                break;
            case 103:
                {
                alt3=10;
                }
                break;
            case 20:
                {
                alt3=11;
                }
                break;
            case 16:
                {
                alt3=12;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 3, 0, input);

                throw nvae;
            }

            switch (alt3) {
                case 1 :
                    // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:139:5: this_LayerMdsl_0= ruleLayerMdsl
                    {
                     
                            newCompositeNode(grammarAccess.getMADConfigElementAccess().getLayerMdslParserRuleCall_0()); 
                        
                    pushFollow(FOLLOW_ruleLayerMdsl_in_ruleMADConfigElement247);
                    this_LayerMdsl_0=ruleLayerMdsl();

                    state._fsp--;

                     
                            current = this_LayerMdsl_0; 
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;
                case 2 :
                    // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:149:5: this_ForeignModelMdsl_1= ruleForeignModelMdsl
                    {
                     
                            newCompositeNode(grammarAccess.getMADConfigElementAccess().getForeignModelMdslParserRuleCall_1()); 
                        
                    pushFollow(FOLLOW_ruleForeignModelMdsl_in_ruleMADConfigElement274);
                    this_ForeignModelMdsl_1=ruleForeignModelMdsl();

                    state._fsp--;

                     
                            current = this_ForeignModelMdsl_1; 
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;
                case 3 :
                    // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:159:5: this_XtextLanguageDescriptorMdsl_2= ruleXtextLanguageDescriptorMdsl
                    {
                     
                            newCompositeNode(grammarAccess.getMADConfigElementAccess().getXtextLanguageDescriptorMdslParserRuleCall_2()); 
                        
                    pushFollow(FOLLOW_ruleXtextLanguageDescriptorMdsl_in_ruleMADConfigElement301);
                    this_XtextLanguageDescriptorMdsl_2=ruleXtextLanguageDescriptorMdsl();

                    state._fsp--;

                     
                            current = this_XtextLanguageDescriptorMdsl_2; 
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;
                case 4 :
                    // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:169:5: this_QueryEvaluatorMdsl_3= ruleQueryEvaluatorMdsl
                    {
                     
                            newCompositeNode(grammarAccess.getMADConfigElementAccess().getQueryEvaluatorMdslParserRuleCall_3()); 
                        
                    pushFollow(FOLLOW_ruleQueryEvaluatorMdsl_in_ruleMADConfigElement328);
                    this_QueryEvaluatorMdsl_3=ruleQueryEvaluatorMdsl();

                    state._fsp--;

                     
                            current = this_QueryEvaluatorMdsl_3; 
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;
                case 5 :
                    // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:179:5: this_QueryDeclaration_4= ruleQueryDeclaration
                    {
                     
                            newCompositeNode(grammarAccess.getMADConfigElementAccess().getQueryDeclarationParserRuleCall_4()); 
                        
                    pushFollow(FOLLOW_ruleQueryDeclaration_in_ruleMADConfigElement355);
                    this_QueryDeclaration_4=ruleQueryDeclaration();

                    state._fsp--;

                     
                            current = this_QueryDeclaration_4; 
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;
                case 6 :
                    // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:189:5: this_WidgetType_5= ruleWidgetType
                    {
                     
                            newCompositeNode(grammarAccess.getMADConfigElementAccess().getWidgetTypeParserRuleCall_5()); 
                        
                    pushFollow(FOLLOW_ruleWidgetType_in_ruleMADConfigElement382);
                    this_WidgetType_5=ruleWidgetType();

                    state._fsp--;

                     
                            current = this_WidgetType_5; 
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;
                case 7 :
                    // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:199:5: this_UITabMdsl_6= ruleUITabMdsl
                    {
                     
                            newCompositeNode(grammarAccess.getMADConfigElementAccess().getUITabMdslParserRuleCall_6()); 
                        
                    pushFollow(FOLLOW_ruleUITabMdsl_in_ruleMADConfigElement409);
                    this_UITabMdsl_6=ruleUITabMdsl();

                    state._fsp--;

                     
                            current = this_UITabMdsl_6; 
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;
                case 8 :
                    // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:209:5: this_CommandDeclaration_7= ruleCommandDeclaration
                    {
                     
                            newCompositeNode(grammarAccess.getMADConfigElementAccess().getCommandDeclarationParserRuleCall_7()); 
                        
                    pushFollow(FOLLOW_ruleCommandDeclaration_in_ruleMADConfigElement436);
                    this_CommandDeclaration_7=ruleCommandDeclaration();

                    state._fsp--;

                     
                            current = this_CommandDeclaration_7; 
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;
                case 9 :
                    // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:219:5: this_TypeConfigurationMdsl_8= ruleTypeConfigurationMdsl
                    {
                     
                            newCompositeNode(grammarAccess.getMADConfigElementAccess().getTypeConfigurationMdslParserRuleCall_8()); 
                        
                    pushFollow(FOLLOW_ruleTypeConfigurationMdsl_in_ruleMADConfigElement463);
                    this_TypeConfigurationMdsl_8=ruleTypeConfigurationMdsl();

                    state._fsp--;

                     
                            current = this_TypeConfigurationMdsl_8; 
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;
                case 10 :
                    // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:229:5: this_TextMacro_9= ruleTextMacro
                    {
                     
                            newCompositeNode(grammarAccess.getMADConfigElementAccess().getTextMacroParserRuleCall_9()); 
                        
                    pushFollow(FOLLOW_ruleTextMacro_in_ruleMADConfigElement490);
                    this_TextMacro_9=ruleTextMacro();

                    state._fsp--;

                     
                            current = this_TextMacro_9; 
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;
                case 11 :
                    // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:239:5: this_I18NBundleMdsl_10= ruleI18NBundleMdsl
                    {
                     
                            newCompositeNode(grammarAccess.getMADConfigElementAccess().getI18NBundleMdslParserRuleCall_10()); 
                        
                    pushFollow(FOLLOW_ruleI18NBundleMdsl_in_ruleMADConfigElement517);
                    this_I18NBundleMdsl_10=ruleI18NBundleMdsl();

                    state._fsp--;

                     
                            current = this_I18NBundleMdsl_10; 
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;
                case 12 :
                    // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:249:5: this_IconDescriptorMdsl_11= ruleIconDescriptorMdsl
                    {
                     
                            newCompositeNode(grammarAccess.getMADConfigElementAccess().getIconDescriptorMdslParserRuleCall_11()); 
                        
                    pushFollow(FOLLOW_ruleIconDescriptorMdsl_in_ruleMADConfigElement544);
                    this_IconDescriptorMdsl_11=ruleIconDescriptorMdsl();

                    state._fsp--;

                     
                            current = this_IconDescriptorMdsl_11; 
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;

            }


            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleMADConfigElement"


    // $ANTLR start "entryRuleImport"
    // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:265:1: entryRuleImport returns [EObject current=null] : iv_ruleImport= ruleImport EOF ;
    public final EObject entryRuleImport() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleImport = null;


        try {
            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:266:2: (iv_ruleImport= ruleImport EOF )
            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:267:2: iv_ruleImport= ruleImport EOF
            {
             newCompositeNode(grammarAccess.getImportRule()); 
            pushFollow(FOLLOW_ruleImport_in_entryRuleImport579);
            iv_ruleImport=ruleImport();

            state._fsp--;

             current =iv_ruleImport; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleImport589); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleImport"


    // $ANTLR start "ruleImport"
    // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:274:1: ruleImport returns [EObject current=null] : (otherlv_0= 'import' ( (lv_importURI_1_0= RULE_STRING ) ) ) ;
    public final EObject ruleImport() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token lv_importURI_1_0=null;

         enterRule(); 
            
        try {
            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:277:28: ( (otherlv_0= 'import' ( (lv_importURI_1_0= RULE_STRING ) ) ) )
            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:278:1: (otherlv_0= 'import' ( (lv_importURI_1_0= RULE_STRING ) ) )
            {
            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:278:1: (otherlv_0= 'import' ( (lv_importURI_1_0= RULE_STRING ) ) )
            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:278:3: otherlv_0= 'import' ( (lv_importURI_1_0= RULE_STRING ) )
            {
            otherlv_0=(Token)match(input,11,FOLLOW_11_in_ruleImport626); 

                	newLeafNode(otherlv_0, grammarAccess.getImportAccess().getImportKeyword_0());
                
            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:282:1: ( (lv_importURI_1_0= RULE_STRING ) )
            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:283:1: (lv_importURI_1_0= RULE_STRING )
            {
            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:283:1: (lv_importURI_1_0= RULE_STRING )
            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:284:3: lv_importURI_1_0= RULE_STRING
            {
            lv_importURI_1_0=(Token)match(input,RULE_STRING,FOLLOW_RULE_STRING_in_ruleImport643); 

            			newLeafNode(lv_importURI_1_0, grammarAccess.getImportAccess().getImportURISTRINGTerminalRuleCall_1_0()); 
            		

            	        if (current==null) {
            	            current = createModelElement(grammarAccess.getImportRule());
            	        }
                   		setWithLastConsumed(
                   			current, 
                   			"importURI",
                    		lv_importURI_1_0, 
                    		"STRING");
            	    

            }


            }


            }


            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleImport"


    // $ANTLR start "entryRuleClassDescriptorMdsl"
    // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:308:1: entryRuleClassDescriptorMdsl returns [EObject current=null] : iv_ruleClassDescriptorMdsl= ruleClassDescriptorMdsl EOF ;
    public final EObject entryRuleClassDescriptorMdsl() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleClassDescriptorMdsl = null;


        try {
            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:309:2: (iv_ruleClassDescriptorMdsl= ruleClassDescriptorMdsl EOF )
            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:310:2: iv_ruleClassDescriptorMdsl= ruleClassDescriptorMdsl EOF
            {
             newCompositeNode(grammarAccess.getClassDescriptorMdslRule()); 
            pushFollow(FOLLOW_ruleClassDescriptorMdsl_in_entryRuleClassDescriptorMdsl684);
            iv_ruleClassDescriptorMdsl=ruleClassDescriptorMdsl();

            state._fsp--;

             current =iv_ruleClassDescriptorMdsl; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleClassDescriptorMdsl694); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleClassDescriptorMdsl"


    // $ANTLR start "ruleClassDescriptorMdsl"
    // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:317:1: ruleClassDescriptorMdsl returns [EObject current=null] : ( ( (lv_ClassName_0_0= RULE_ID ) ) (otherlv_1= 'from plugin' ( (lv_pluginId_2_0= RULE_ID ) ) )? ) ;
    public final EObject ruleClassDescriptorMdsl() throws RecognitionException {
        EObject current = null;

        Token lv_ClassName_0_0=null;
        Token otherlv_1=null;
        Token lv_pluginId_2_0=null;

         enterRule(); 
            
        try {
            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:320:28: ( ( ( (lv_ClassName_0_0= RULE_ID ) ) (otherlv_1= 'from plugin' ( (lv_pluginId_2_0= RULE_ID ) ) )? ) )
            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:321:1: ( ( (lv_ClassName_0_0= RULE_ID ) ) (otherlv_1= 'from plugin' ( (lv_pluginId_2_0= RULE_ID ) ) )? )
            {
            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:321:1: ( ( (lv_ClassName_0_0= RULE_ID ) ) (otherlv_1= 'from plugin' ( (lv_pluginId_2_0= RULE_ID ) ) )? )
            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:321:2: ( (lv_ClassName_0_0= RULE_ID ) ) (otherlv_1= 'from plugin' ( (lv_pluginId_2_0= RULE_ID ) ) )?
            {
            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:321:2: ( (lv_ClassName_0_0= RULE_ID ) )
            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:322:1: (lv_ClassName_0_0= RULE_ID )
            {
            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:322:1: (lv_ClassName_0_0= RULE_ID )
            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:323:3: lv_ClassName_0_0= RULE_ID
            {
            lv_ClassName_0_0=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleClassDescriptorMdsl736); 

            			newLeafNode(lv_ClassName_0_0, grammarAccess.getClassDescriptorMdslAccess().getClassNameIDTerminalRuleCall_0_0()); 
            		

            	        if (current==null) {
            	            current = createModelElement(grammarAccess.getClassDescriptorMdslRule());
            	        }
                   		setWithLastConsumed(
                   			current, 
                   			"ClassName",
                    		lv_ClassName_0_0, 
                    		"ID");
            	    

            }


            }

            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:339:2: (otherlv_1= 'from plugin' ( (lv_pluginId_2_0= RULE_ID ) ) )?
            int alt4=2;
            int LA4_0 = input.LA(1);

            if ( (LA4_0==12) ) {
                alt4=1;
            }
            switch (alt4) {
                case 1 :
                    // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:339:4: otherlv_1= 'from plugin' ( (lv_pluginId_2_0= RULE_ID ) )
                    {
                    otherlv_1=(Token)match(input,12,FOLLOW_12_in_ruleClassDescriptorMdsl754); 

                        	newLeafNode(otherlv_1, grammarAccess.getClassDescriptorMdslAccess().getFromPluginKeyword_1_0());
                        
                    // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:343:1: ( (lv_pluginId_2_0= RULE_ID ) )
                    // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:344:1: (lv_pluginId_2_0= RULE_ID )
                    {
                    // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:344:1: (lv_pluginId_2_0= RULE_ID )
                    // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:345:3: lv_pluginId_2_0= RULE_ID
                    {
                    lv_pluginId_2_0=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleClassDescriptorMdsl771); 

                    			newLeafNode(lv_pluginId_2_0, grammarAccess.getClassDescriptorMdslAccess().getPluginIdIDTerminalRuleCall_1_1_0()); 
                    		

                    	        if (current==null) {
                    	            current = createModelElement(grammarAccess.getClassDescriptorMdslRule());
                    	        }
                           		setWithLastConsumed(
                           			current, 
                           			"pluginId",
                            		lv_pluginId_2_0, 
                            		"ID");
                    	    

                    }


                    }


                    }
                    break;

            }


            }


            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleClassDescriptorMdsl"


    // $ANTLR start "entryRulePropertyTypeMdsl"
    // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:369:1: entryRulePropertyTypeMdsl returns [EObject current=null] : iv_rulePropertyTypeMdsl= rulePropertyTypeMdsl EOF ;
    public final EObject entryRulePropertyTypeMdsl() throws RecognitionException {
        EObject current = null;

        EObject iv_rulePropertyTypeMdsl = null;


        try {
            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:370:2: (iv_rulePropertyTypeMdsl= rulePropertyTypeMdsl EOF )
            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:371:2: iv_rulePropertyTypeMdsl= rulePropertyTypeMdsl EOF
            {
             newCompositeNode(grammarAccess.getPropertyTypeMdslRule()); 
            pushFollow(FOLLOW_rulePropertyTypeMdsl_in_entryRulePropertyTypeMdsl814);
            iv_rulePropertyTypeMdsl=rulePropertyTypeMdsl();

            state._fsp--;

             current =iv_rulePropertyTypeMdsl; 
            match(input,EOF,FOLLOW_EOF_in_entryRulePropertyTypeMdsl824); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRulePropertyTypeMdsl"


    // $ANTLR start "rulePropertyTypeMdsl"
    // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:378:1: rulePropertyTypeMdsl returns [EObject current=null] : ( ( (lv_name_0_0= RULE_ID ) ) otherlv_1= 'label:' ( (lv_label_2_0= RULE_STRING ) ) ) ;
    public final EObject rulePropertyTypeMdsl() throws RecognitionException {
        EObject current = null;

        Token lv_name_0_0=null;
        Token otherlv_1=null;
        Token lv_label_2_0=null;

         enterRule(); 
            
        try {
            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:381:28: ( ( ( (lv_name_0_0= RULE_ID ) ) otherlv_1= 'label:' ( (lv_label_2_0= RULE_STRING ) ) ) )
            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:382:1: ( ( (lv_name_0_0= RULE_ID ) ) otherlv_1= 'label:' ( (lv_label_2_0= RULE_STRING ) ) )
            {
            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:382:1: ( ( (lv_name_0_0= RULE_ID ) ) otherlv_1= 'label:' ( (lv_label_2_0= RULE_STRING ) ) )
            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:382:2: ( (lv_name_0_0= RULE_ID ) ) otherlv_1= 'label:' ( (lv_label_2_0= RULE_STRING ) )
            {
            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:382:2: ( (lv_name_0_0= RULE_ID ) )
            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:383:1: (lv_name_0_0= RULE_ID )
            {
            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:383:1: (lv_name_0_0= RULE_ID )
            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:384:3: lv_name_0_0= RULE_ID
            {
            lv_name_0_0=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_rulePropertyTypeMdsl866); 

            			newLeafNode(lv_name_0_0, grammarAccess.getPropertyTypeMdslAccess().getNameIDTerminalRuleCall_0_0()); 
            		

            	        if (current==null) {
            	            current = createModelElement(grammarAccess.getPropertyTypeMdslRule());
            	        }
                   		setWithLastConsumed(
                   			current, 
                   			"name",
                    		lv_name_0_0, 
                    		"ID");
            	    

            }


            }

            otherlv_1=(Token)match(input,13,FOLLOW_13_in_rulePropertyTypeMdsl883); 

                	newLeafNode(otherlv_1, grammarAccess.getPropertyTypeMdslAccess().getLabelKeyword_1());
                
            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:404:1: ( (lv_label_2_0= RULE_STRING ) )
            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:405:1: (lv_label_2_0= RULE_STRING )
            {
            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:405:1: (lv_label_2_0= RULE_STRING )
            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:406:3: lv_label_2_0= RULE_STRING
            {
            lv_label_2_0=(Token)match(input,RULE_STRING,FOLLOW_RULE_STRING_in_rulePropertyTypeMdsl900); 

            			newLeafNode(lv_label_2_0, grammarAccess.getPropertyTypeMdslAccess().getLabelSTRINGTerminalRuleCall_2_0()); 
            		

            	        if (current==null) {
            	            current = createModelElement(grammarAccess.getPropertyTypeMdslRule());
            	        }
                   		setWithLastConsumed(
                   			current, 
                   			"label",
                    		lv_label_2_0, 
                    		"STRING");
            	    

            }


            }


            }


            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "rulePropertyTypeMdsl"


    // $ANTLR start "entryRulePropertyMdsl"
    // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:430:1: entryRulePropertyMdsl returns [EObject current=null] : iv_rulePropertyMdsl= rulePropertyMdsl EOF ;
    public final EObject entryRulePropertyMdsl() throws RecognitionException {
        EObject current = null;

        EObject iv_rulePropertyMdsl = null;


        try {
            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:431:2: (iv_rulePropertyMdsl= rulePropertyMdsl EOF )
            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:432:2: iv_rulePropertyMdsl= rulePropertyMdsl EOF
            {
             newCompositeNode(grammarAccess.getPropertyMdslRule()); 
            pushFollow(FOLLOW_rulePropertyMdsl_in_entryRulePropertyMdsl941);
            iv_rulePropertyMdsl=rulePropertyMdsl();

            state._fsp--;

             current =iv_rulePropertyMdsl; 
            match(input,EOF,FOLLOW_EOF_in_entryRulePropertyMdsl951); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRulePropertyMdsl"


    // $ANTLR start "rulePropertyMdsl"
    // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:439:1: rulePropertyMdsl returns [EObject current=null] : ( ( (otherlv_0= RULE_ID ) ) otherlv_1= '=' ( (lv_propertyValue_2_0= rulePropertyValueMdsl ) ) ) ;
    public final EObject rulePropertyMdsl() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;
        EObject lv_propertyValue_2_0 = null;


         enterRule(); 
            
        try {
            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:442:28: ( ( ( (otherlv_0= RULE_ID ) ) otherlv_1= '=' ( (lv_propertyValue_2_0= rulePropertyValueMdsl ) ) ) )
            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:443:1: ( ( (otherlv_0= RULE_ID ) ) otherlv_1= '=' ( (lv_propertyValue_2_0= rulePropertyValueMdsl ) ) )
            {
            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:443:1: ( ( (otherlv_0= RULE_ID ) ) otherlv_1= '=' ( (lv_propertyValue_2_0= rulePropertyValueMdsl ) ) )
            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:443:2: ( (otherlv_0= RULE_ID ) ) otherlv_1= '=' ( (lv_propertyValue_2_0= rulePropertyValueMdsl ) )
            {
            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:443:2: ( (otherlv_0= RULE_ID ) )
            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:444:1: (otherlv_0= RULE_ID )
            {
            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:444:1: (otherlv_0= RULE_ID )
            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:445:3: otherlv_0= RULE_ID
            {

            			if (current==null) {
            	            current = createModelElement(grammarAccess.getPropertyMdslRule());
            	        }
                    
            otherlv_0=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_rulePropertyMdsl996); 

            		newLeafNode(otherlv_0, grammarAccess.getPropertyMdslAccess().getPropertyNamePropertyTypeMdslCrossReference_0_0()); 
            	

            }


            }

            otherlv_1=(Token)match(input,14,FOLLOW_14_in_rulePropertyMdsl1008); 

                	newLeafNode(otherlv_1, grammarAccess.getPropertyMdslAccess().getEqualsSignKeyword_1());
                
            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:460:1: ( (lv_propertyValue_2_0= rulePropertyValueMdsl ) )
            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:461:1: (lv_propertyValue_2_0= rulePropertyValueMdsl )
            {
            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:461:1: (lv_propertyValue_2_0= rulePropertyValueMdsl )
            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:462:3: lv_propertyValue_2_0= rulePropertyValueMdsl
            {
             
            	        newCompositeNode(grammarAccess.getPropertyMdslAccess().getPropertyValuePropertyValueMdslParserRuleCall_2_0()); 
            	    
            pushFollow(FOLLOW_rulePropertyValueMdsl_in_rulePropertyMdsl1029);
            lv_propertyValue_2_0=rulePropertyValueMdsl();

            state._fsp--;


            	        if (current==null) {
            	            current = createModelElementForParent(grammarAccess.getPropertyMdslRule());
            	        }
                   		set(
                   			current, 
                   			"propertyValue",
                    		lv_propertyValue_2_0, 
                    		"PropertyValueMdsl");
            	        afterParserOrEnumRuleCall();
            	    

            }


            }


            }


            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "rulePropertyMdsl"


    // $ANTLR start "entryRulePropertyValueMdsl"
    // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:486:1: entryRulePropertyValueMdsl returns [EObject current=null] : iv_rulePropertyValueMdsl= rulePropertyValueMdsl EOF ;
    public final EObject entryRulePropertyValueMdsl() throws RecognitionException {
        EObject current = null;

        EObject iv_rulePropertyValueMdsl = null;


        try {
            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:487:2: (iv_rulePropertyValueMdsl= rulePropertyValueMdsl EOF )
            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:488:2: iv_rulePropertyValueMdsl= rulePropertyValueMdsl EOF
            {
             newCompositeNode(grammarAccess.getPropertyValueMdslRule()); 
            pushFollow(FOLLOW_rulePropertyValueMdsl_in_entryRulePropertyValueMdsl1065);
            iv_rulePropertyValueMdsl=rulePropertyValueMdsl();

            state._fsp--;

             current =iv_rulePropertyValueMdsl; 
            match(input,EOF,FOLLOW_EOF_in_entryRulePropertyValueMdsl1075); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRulePropertyValueMdsl"


    // $ANTLR start "rulePropertyValueMdsl"
    // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:495:1: rulePropertyValueMdsl returns [EObject current=null] : ( ( (lv_fragments_0_0= rulePropValueExprFragment ) ) (otherlv_1= '+' ( (lv_fragments_2_0= rulePropValueExprFragment ) ) )* ) ;
    public final EObject rulePropertyValueMdsl() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        EObject lv_fragments_0_0 = null;

        EObject lv_fragments_2_0 = null;


         enterRule(); 
            
        try {
            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:498:28: ( ( ( (lv_fragments_0_0= rulePropValueExprFragment ) ) (otherlv_1= '+' ( (lv_fragments_2_0= rulePropValueExprFragment ) ) )* ) )
            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:499:1: ( ( (lv_fragments_0_0= rulePropValueExprFragment ) ) (otherlv_1= '+' ( (lv_fragments_2_0= rulePropValueExprFragment ) ) )* )
            {
            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:499:1: ( ( (lv_fragments_0_0= rulePropValueExprFragment ) ) (otherlv_1= '+' ( (lv_fragments_2_0= rulePropValueExprFragment ) ) )* )
            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:499:2: ( (lv_fragments_0_0= rulePropValueExprFragment ) ) (otherlv_1= '+' ( (lv_fragments_2_0= rulePropValueExprFragment ) ) )*
            {
            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:499:2: ( (lv_fragments_0_0= rulePropValueExprFragment ) )
            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:500:1: (lv_fragments_0_0= rulePropValueExprFragment )
            {
            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:500:1: (lv_fragments_0_0= rulePropValueExprFragment )
            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:501:3: lv_fragments_0_0= rulePropValueExprFragment
            {
             
            	        newCompositeNode(grammarAccess.getPropertyValueMdslAccess().getFragmentsPropValueExprFragmentParserRuleCall_0_0()); 
            	    
            pushFollow(FOLLOW_rulePropValueExprFragment_in_rulePropertyValueMdsl1121);
            lv_fragments_0_0=rulePropValueExprFragment();

            state._fsp--;


            	        if (current==null) {
            	            current = createModelElementForParent(grammarAccess.getPropertyValueMdslRule());
            	        }
                   		add(
                   			current, 
                   			"fragments",
                    		lv_fragments_0_0, 
                    		"PropValueExprFragment");
            	        afterParserOrEnumRuleCall();
            	    

            }


            }

            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:517:2: (otherlv_1= '+' ( (lv_fragments_2_0= rulePropValueExprFragment ) ) )*
            loop5:
            do {
                int alt5=2;
                int LA5_0 = input.LA(1);

                if ( (LA5_0==15) ) {
                    alt5=1;
                }


                switch (alt5) {
            	case 1 :
            	    // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:517:4: otherlv_1= '+' ( (lv_fragments_2_0= rulePropValueExprFragment ) )
            	    {
            	    otherlv_1=(Token)match(input,15,FOLLOW_15_in_rulePropertyValueMdsl1134); 

            	        	newLeafNode(otherlv_1, grammarAccess.getPropertyValueMdslAccess().getPlusSignKeyword_1_0());
            	        
            	    // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:521:1: ( (lv_fragments_2_0= rulePropValueExprFragment ) )
            	    // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:522:1: (lv_fragments_2_0= rulePropValueExprFragment )
            	    {
            	    // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:522:1: (lv_fragments_2_0= rulePropValueExprFragment )
            	    // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:523:3: lv_fragments_2_0= rulePropValueExprFragment
            	    {
            	     
            	    	        newCompositeNode(grammarAccess.getPropertyValueMdslAccess().getFragmentsPropValueExprFragmentParserRuleCall_1_1_0()); 
            	    	    
            	    pushFollow(FOLLOW_rulePropValueExprFragment_in_rulePropertyValueMdsl1155);
            	    lv_fragments_2_0=rulePropValueExprFragment();

            	    state._fsp--;


            	    	        if (current==null) {
            	    	            current = createModelElementForParent(grammarAccess.getPropertyValueMdslRule());
            	    	        }
            	           		add(
            	           			current, 
            	           			"fragments",
            	            		lv_fragments_2_0, 
            	            		"PropValueExprFragment");
            	    	        afterParserOrEnumRuleCall();
            	    	    

            	    }


            	    }


            	    }
            	    break;

            	default :
            	    break loop5;
                }
            } while (true);


            }


            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "rulePropertyValueMdsl"


    // $ANTLR start "entryRulePropValueExprFragment"
    // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:547:1: entryRulePropValueExprFragment returns [EObject current=null] : iv_rulePropValueExprFragment= rulePropValueExprFragment EOF ;
    public final EObject entryRulePropValueExprFragment() throws RecognitionException {
        EObject current = null;

        EObject iv_rulePropValueExprFragment = null;


        try {
            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:548:2: (iv_rulePropValueExprFragment= rulePropValueExprFragment EOF )
            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:549:2: iv_rulePropValueExprFragment= rulePropValueExprFragment EOF
            {
             newCompositeNode(grammarAccess.getPropValueExprFragmentRule()); 
            pushFollow(FOLLOW_rulePropValueExprFragment_in_entryRulePropValueExprFragment1193);
            iv_rulePropValueExprFragment=rulePropValueExprFragment();

            state._fsp--;

             current =iv_rulePropValueExprFragment; 
            match(input,EOF,FOLLOW_EOF_in_entryRulePropValueExprFragment1203); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRulePropValueExprFragment"


    // $ANTLR start "rulePropValueExprFragment"
    // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:556:1: rulePropValueExprFragment returns [EObject current=null] : (this_LiteraPropValueExprFragment_0= ruleLiteraPropValueExprFragment | this_TextMacroRef_1= ruleTextMacroRef ) ;
    public final EObject rulePropValueExprFragment() throws RecognitionException {
        EObject current = null;

        EObject this_LiteraPropValueExprFragment_0 = null;

        EObject this_TextMacroRef_1 = null;


         enterRule(); 
            
        try {
            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:559:28: ( (this_LiteraPropValueExprFragment_0= ruleLiteraPropValueExprFragment | this_TextMacroRef_1= ruleTextMacroRef ) )
            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:560:1: (this_LiteraPropValueExprFragment_0= ruleLiteraPropValueExprFragment | this_TextMacroRef_1= ruleTextMacroRef )
            {
            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:560:1: (this_LiteraPropValueExprFragment_0= ruleLiteraPropValueExprFragment | this_TextMacroRef_1= ruleTextMacroRef )
            int alt6=2;
            int LA6_0 = input.LA(1);

            if ( (LA6_0==RULE_STRING) ) {
                alt6=1;
            }
            else if ( (LA6_0==104) ) {
                alt6=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 6, 0, input);

                throw nvae;
            }
            switch (alt6) {
                case 1 :
                    // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:561:5: this_LiteraPropValueExprFragment_0= ruleLiteraPropValueExprFragment
                    {
                     
                            newCompositeNode(grammarAccess.getPropValueExprFragmentAccess().getLiteraPropValueExprFragmentParserRuleCall_0()); 
                        
                    pushFollow(FOLLOW_ruleLiteraPropValueExprFragment_in_rulePropValueExprFragment1250);
                    this_LiteraPropValueExprFragment_0=ruleLiteraPropValueExprFragment();

                    state._fsp--;

                     
                            current = this_LiteraPropValueExprFragment_0; 
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;
                case 2 :
                    // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:571:5: this_TextMacroRef_1= ruleTextMacroRef
                    {
                     
                            newCompositeNode(grammarAccess.getPropValueExprFragmentAccess().getTextMacroRefParserRuleCall_1()); 
                        
                    pushFollow(FOLLOW_ruleTextMacroRef_in_rulePropValueExprFragment1277);
                    this_TextMacroRef_1=ruleTextMacroRef();

                    state._fsp--;

                     
                            current = this_TextMacroRef_1; 
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;

            }


            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "rulePropValueExprFragment"


    // $ANTLR start "entryRuleLiteraPropValueExprFragment"
    // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:587:1: entryRuleLiteraPropValueExprFragment returns [EObject current=null] : iv_ruleLiteraPropValueExprFragment= ruleLiteraPropValueExprFragment EOF ;
    public final EObject entryRuleLiteraPropValueExprFragment() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleLiteraPropValueExprFragment = null;


        try {
            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:588:2: (iv_ruleLiteraPropValueExprFragment= ruleLiteraPropValueExprFragment EOF )
            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:589:2: iv_ruleLiteraPropValueExprFragment= ruleLiteraPropValueExprFragment EOF
            {
             newCompositeNode(grammarAccess.getLiteraPropValueExprFragmentRule()); 
            pushFollow(FOLLOW_ruleLiteraPropValueExprFragment_in_entryRuleLiteraPropValueExprFragment1312);
            iv_ruleLiteraPropValueExprFragment=ruleLiteraPropValueExprFragment();

            state._fsp--;

             current =iv_ruleLiteraPropValueExprFragment; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleLiteraPropValueExprFragment1322); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleLiteraPropValueExprFragment"


    // $ANTLR start "ruleLiteraPropValueExprFragment"
    // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:596:1: ruleLiteraPropValueExprFragment returns [EObject current=null] : ( (lv_value_0_0= RULE_STRING ) ) ;
    public final EObject ruleLiteraPropValueExprFragment() throws RecognitionException {
        EObject current = null;

        Token lv_value_0_0=null;

         enterRule(); 
            
        try {
            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:599:28: ( ( (lv_value_0_0= RULE_STRING ) ) )
            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:600:1: ( (lv_value_0_0= RULE_STRING ) )
            {
            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:600:1: ( (lv_value_0_0= RULE_STRING ) )
            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:601:1: (lv_value_0_0= RULE_STRING )
            {
            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:601:1: (lv_value_0_0= RULE_STRING )
            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:602:3: lv_value_0_0= RULE_STRING
            {
            lv_value_0_0=(Token)match(input,RULE_STRING,FOLLOW_RULE_STRING_in_ruleLiteraPropValueExprFragment1363); 

            			newLeafNode(lv_value_0_0, grammarAccess.getLiteraPropValueExprFragmentAccess().getValueSTRINGTerminalRuleCall_0()); 
            		

            	        if (current==null) {
            	            current = createModelElement(grammarAccess.getLiteraPropValueExprFragmentRule());
            	        }
                   		setWithLastConsumed(
                   			current, 
                   			"value",
                    		lv_value_0_0, 
                    		"STRING");
            	    

            }


            }


            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleLiteraPropValueExprFragment"


    // $ANTLR start "entryRuleIconDescriptorMdsl"
    // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:626:1: entryRuleIconDescriptorMdsl returns [EObject current=null] : iv_ruleIconDescriptorMdsl= ruleIconDescriptorMdsl EOF ;
    public final EObject entryRuleIconDescriptorMdsl() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleIconDescriptorMdsl = null;


        try {
            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:627:2: (iv_ruleIconDescriptorMdsl= ruleIconDescriptorMdsl EOF )
            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:628:2: iv_ruleIconDescriptorMdsl= ruleIconDescriptorMdsl EOF
            {
             newCompositeNode(grammarAccess.getIconDescriptorMdslRule()); 
            pushFollow(FOLLOW_ruleIconDescriptorMdsl_in_entryRuleIconDescriptorMdsl1403);
            iv_ruleIconDescriptorMdsl=ruleIconDescriptorMdsl();

            state._fsp--;

             current =iv_ruleIconDescriptorMdsl; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleIconDescriptorMdsl1413); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleIconDescriptorMdsl"


    // $ANTLR start "ruleIconDescriptorMdsl"
    // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:635:1: ruleIconDescriptorMdsl returns [EObject current=null] : (otherlv_0= 'Use icon' ( (lv_name_1_0= RULE_ID ) ) (otherlv_2= 'description:' ( (lv_description_3_0= RULE_STRING ) ) )? ( (otherlv_4= 'location:' ( (lv_bundleDescriptor_5_0= ruleClassDescriptorMdsl ) ) ) | (otherlv_6= 'URI:' ( (lv_bundleUri_7_0= RULE_STRING ) ) ) ) ) ;
    public final EObject ruleIconDescriptorMdsl() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token lv_name_1_0=null;
        Token otherlv_2=null;
        Token lv_description_3_0=null;
        Token otherlv_4=null;
        Token otherlv_6=null;
        Token lv_bundleUri_7_0=null;
        EObject lv_bundleDescriptor_5_0 = null;


         enterRule(); 
            
        try {
            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:638:28: ( (otherlv_0= 'Use icon' ( (lv_name_1_0= RULE_ID ) ) (otherlv_2= 'description:' ( (lv_description_3_0= RULE_STRING ) ) )? ( (otherlv_4= 'location:' ( (lv_bundleDescriptor_5_0= ruleClassDescriptorMdsl ) ) ) | (otherlv_6= 'URI:' ( (lv_bundleUri_7_0= RULE_STRING ) ) ) ) ) )
            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:639:1: (otherlv_0= 'Use icon' ( (lv_name_1_0= RULE_ID ) ) (otherlv_2= 'description:' ( (lv_description_3_0= RULE_STRING ) ) )? ( (otherlv_4= 'location:' ( (lv_bundleDescriptor_5_0= ruleClassDescriptorMdsl ) ) ) | (otherlv_6= 'URI:' ( (lv_bundleUri_7_0= RULE_STRING ) ) ) ) )
            {
            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:639:1: (otherlv_0= 'Use icon' ( (lv_name_1_0= RULE_ID ) ) (otherlv_2= 'description:' ( (lv_description_3_0= RULE_STRING ) ) )? ( (otherlv_4= 'location:' ( (lv_bundleDescriptor_5_0= ruleClassDescriptorMdsl ) ) ) | (otherlv_6= 'URI:' ( (lv_bundleUri_7_0= RULE_STRING ) ) ) ) )
            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:639:3: otherlv_0= 'Use icon' ( (lv_name_1_0= RULE_ID ) ) (otherlv_2= 'description:' ( (lv_description_3_0= RULE_STRING ) ) )? ( (otherlv_4= 'location:' ( (lv_bundleDescriptor_5_0= ruleClassDescriptorMdsl ) ) ) | (otherlv_6= 'URI:' ( (lv_bundleUri_7_0= RULE_STRING ) ) ) )
            {
            otherlv_0=(Token)match(input,16,FOLLOW_16_in_ruleIconDescriptorMdsl1450); 

                	newLeafNode(otherlv_0, grammarAccess.getIconDescriptorMdslAccess().getUseIconKeyword_0());
                
            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:643:1: ( (lv_name_1_0= RULE_ID ) )
            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:644:1: (lv_name_1_0= RULE_ID )
            {
            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:644:1: (lv_name_1_0= RULE_ID )
            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:645:3: lv_name_1_0= RULE_ID
            {
            lv_name_1_0=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleIconDescriptorMdsl1467); 

            			newLeafNode(lv_name_1_0, grammarAccess.getIconDescriptorMdslAccess().getNameIDTerminalRuleCall_1_0()); 
            		

            	        if (current==null) {
            	            current = createModelElement(grammarAccess.getIconDescriptorMdslRule());
            	        }
                   		setWithLastConsumed(
                   			current, 
                   			"name",
                    		lv_name_1_0, 
                    		"ID");
            	    

            }


            }

            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:661:2: (otherlv_2= 'description:' ( (lv_description_3_0= RULE_STRING ) ) )?
            int alt7=2;
            int LA7_0 = input.LA(1);

            if ( (LA7_0==17) ) {
                alt7=1;
            }
            switch (alt7) {
                case 1 :
                    // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:661:4: otherlv_2= 'description:' ( (lv_description_3_0= RULE_STRING ) )
                    {
                    otherlv_2=(Token)match(input,17,FOLLOW_17_in_ruleIconDescriptorMdsl1485); 

                        	newLeafNode(otherlv_2, grammarAccess.getIconDescriptorMdslAccess().getDescriptionKeyword_2_0());
                        
                    // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:665:1: ( (lv_description_3_0= RULE_STRING ) )
                    // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:666:1: (lv_description_3_0= RULE_STRING )
                    {
                    // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:666:1: (lv_description_3_0= RULE_STRING )
                    // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:667:3: lv_description_3_0= RULE_STRING
                    {
                    lv_description_3_0=(Token)match(input,RULE_STRING,FOLLOW_RULE_STRING_in_ruleIconDescriptorMdsl1502); 

                    			newLeafNode(lv_description_3_0, grammarAccess.getIconDescriptorMdslAccess().getDescriptionSTRINGTerminalRuleCall_2_1_0()); 
                    		

                    	        if (current==null) {
                    	            current = createModelElement(grammarAccess.getIconDescriptorMdslRule());
                    	        }
                           		setWithLastConsumed(
                           			current, 
                           			"description",
                            		lv_description_3_0, 
                            		"STRING");
                    	    

                    }


                    }


                    }
                    break;

            }

            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:683:4: ( (otherlv_4= 'location:' ( (lv_bundleDescriptor_5_0= ruleClassDescriptorMdsl ) ) ) | (otherlv_6= 'URI:' ( (lv_bundleUri_7_0= RULE_STRING ) ) ) )
            int alt8=2;
            int LA8_0 = input.LA(1);

            if ( (LA8_0==18) ) {
                alt8=1;
            }
            else if ( (LA8_0==19) ) {
                alt8=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 8, 0, input);

                throw nvae;
            }
            switch (alt8) {
                case 1 :
                    // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:683:5: (otherlv_4= 'location:' ( (lv_bundleDescriptor_5_0= ruleClassDescriptorMdsl ) ) )
                    {
                    // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:683:5: (otherlv_4= 'location:' ( (lv_bundleDescriptor_5_0= ruleClassDescriptorMdsl ) ) )
                    // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:683:7: otherlv_4= 'location:' ( (lv_bundleDescriptor_5_0= ruleClassDescriptorMdsl ) )
                    {
                    otherlv_4=(Token)match(input,18,FOLLOW_18_in_ruleIconDescriptorMdsl1523); 

                        	newLeafNode(otherlv_4, grammarAccess.getIconDescriptorMdslAccess().getLocationKeyword_3_0_0());
                        
                    // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:687:1: ( (lv_bundleDescriptor_5_0= ruleClassDescriptorMdsl ) )
                    // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:688:1: (lv_bundleDescriptor_5_0= ruleClassDescriptorMdsl )
                    {
                    // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:688:1: (lv_bundleDescriptor_5_0= ruleClassDescriptorMdsl )
                    // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:689:3: lv_bundleDescriptor_5_0= ruleClassDescriptorMdsl
                    {
                     
                    	        newCompositeNode(grammarAccess.getIconDescriptorMdslAccess().getBundleDescriptorClassDescriptorMdslParserRuleCall_3_0_1_0()); 
                    	    
                    pushFollow(FOLLOW_ruleClassDescriptorMdsl_in_ruleIconDescriptorMdsl1544);
                    lv_bundleDescriptor_5_0=ruleClassDescriptorMdsl();

                    state._fsp--;


                    	        if (current==null) {
                    	            current = createModelElementForParent(grammarAccess.getIconDescriptorMdslRule());
                    	        }
                           		set(
                           			current, 
                           			"bundleDescriptor",
                            		lv_bundleDescriptor_5_0, 
                            		"ClassDescriptorMdsl");
                    	        afterParserOrEnumRuleCall();
                    	    

                    }


                    }


                    }


                    }
                    break;
                case 2 :
                    // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:706:6: (otherlv_6= 'URI:' ( (lv_bundleUri_7_0= RULE_STRING ) ) )
                    {
                    // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:706:6: (otherlv_6= 'URI:' ( (lv_bundleUri_7_0= RULE_STRING ) ) )
                    // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:706:8: otherlv_6= 'URI:' ( (lv_bundleUri_7_0= RULE_STRING ) )
                    {
                    otherlv_6=(Token)match(input,19,FOLLOW_19_in_ruleIconDescriptorMdsl1564); 

                        	newLeafNode(otherlv_6, grammarAccess.getIconDescriptorMdslAccess().getURIKeyword_3_1_0());
                        
                    // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:710:1: ( (lv_bundleUri_7_0= RULE_STRING ) )
                    // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:711:1: (lv_bundleUri_7_0= RULE_STRING )
                    {
                    // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:711:1: (lv_bundleUri_7_0= RULE_STRING )
                    // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:712:3: lv_bundleUri_7_0= RULE_STRING
                    {
                    lv_bundleUri_7_0=(Token)match(input,RULE_STRING,FOLLOW_RULE_STRING_in_ruleIconDescriptorMdsl1581); 

                    			newLeafNode(lv_bundleUri_7_0, grammarAccess.getIconDescriptorMdslAccess().getBundleUriSTRINGTerminalRuleCall_3_1_1_0()); 
                    		

                    	        if (current==null) {
                    	            current = createModelElement(grammarAccess.getIconDescriptorMdslRule());
                    	        }
                           		setWithLastConsumed(
                           			current, 
                           			"bundleUri",
                            		lv_bundleUri_7_0, 
                            		"STRING");
                    	    

                    }


                    }


                    }


                    }
                    break;

            }


            }


            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleIconDescriptorMdsl"


    // $ANTLR start "entryRuleI18NBundleMdsl"
    // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:736:1: entryRuleI18NBundleMdsl returns [EObject current=null] : iv_ruleI18NBundleMdsl= ruleI18NBundleMdsl EOF ;
    public final EObject entryRuleI18NBundleMdsl() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleI18NBundleMdsl = null;


        try {
            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:737:2: (iv_ruleI18NBundleMdsl= ruleI18NBundleMdsl EOF )
            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:738:2: iv_ruleI18NBundleMdsl= ruleI18NBundleMdsl EOF
            {
             newCompositeNode(grammarAccess.getI18NBundleMdslRule()); 
            pushFollow(FOLLOW_ruleI18NBundleMdsl_in_entryRuleI18NBundleMdsl1624);
            iv_ruleI18NBundleMdsl=ruleI18NBundleMdsl();

            state._fsp--;

             current =iv_ruleI18NBundleMdsl; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleI18NBundleMdsl1634); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleI18NBundleMdsl"


    // $ANTLR start "ruleI18NBundleMdsl"
    // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:745:1: ruleI18NBundleMdsl returns [EObject current=null] : (otherlv_0= 'Use I18N Bundle' ( (lv_name_1_0= RULE_ID ) ) (otherlv_2= 'description:' ( (lv_description_3_0= RULE_STRING ) ) )? ( (otherlv_4= 'location:' ( (lv_bundleDescriptor_5_0= ruleClassDescriptorMdsl ) ) ) | (otherlv_6= 'URI:' ( (lv_bundleUri_7_0= RULE_STRING ) ) ) ) ) ;
    public final EObject ruleI18NBundleMdsl() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token lv_name_1_0=null;
        Token otherlv_2=null;
        Token lv_description_3_0=null;
        Token otherlv_4=null;
        Token otherlv_6=null;
        Token lv_bundleUri_7_0=null;
        EObject lv_bundleDescriptor_5_0 = null;


         enterRule(); 
            
        try {
            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:748:28: ( (otherlv_0= 'Use I18N Bundle' ( (lv_name_1_0= RULE_ID ) ) (otherlv_2= 'description:' ( (lv_description_3_0= RULE_STRING ) ) )? ( (otherlv_4= 'location:' ( (lv_bundleDescriptor_5_0= ruleClassDescriptorMdsl ) ) ) | (otherlv_6= 'URI:' ( (lv_bundleUri_7_0= RULE_STRING ) ) ) ) ) )
            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:749:1: (otherlv_0= 'Use I18N Bundle' ( (lv_name_1_0= RULE_ID ) ) (otherlv_2= 'description:' ( (lv_description_3_0= RULE_STRING ) ) )? ( (otherlv_4= 'location:' ( (lv_bundleDescriptor_5_0= ruleClassDescriptorMdsl ) ) ) | (otherlv_6= 'URI:' ( (lv_bundleUri_7_0= RULE_STRING ) ) ) ) )
            {
            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:749:1: (otherlv_0= 'Use I18N Bundle' ( (lv_name_1_0= RULE_ID ) ) (otherlv_2= 'description:' ( (lv_description_3_0= RULE_STRING ) ) )? ( (otherlv_4= 'location:' ( (lv_bundleDescriptor_5_0= ruleClassDescriptorMdsl ) ) ) | (otherlv_6= 'URI:' ( (lv_bundleUri_7_0= RULE_STRING ) ) ) ) )
            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:749:3: otherlv_0= 'Use I18N Bundle' ( (lv_name_1_0= RULE_ID ) ) (otherlv_2= 'description:' ( (lv_description_3_0= RULE_STRING ) ) )? ( (otherlv_4= 'location:' ( (lv_bundleDescriptor_5_0= ruleClassDescriptorMdsl ) ) ) | (otherlv_6= 'URI:' ( (lv_bundleUri_7_0= RULE_STRING ) ) ) )
            {
            otherlv_0=(Token)match(input,20,FOLLOW_20_in_ruleI18NBundleMdsl1671); 

                	newLeafNode(otherlv_0, grammarAccess.getI18NBundleMdslAccess().getUseI18NBundleKeyword_0());
                
            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:753:1: ( (lv_name_1_0= RULE_ID ) )
            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:754:1: (lv_name_1_0= RULE_ID )
            {
            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:754:1: (lv_name_1_0= RULE_ID )
            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:755:3: lv_name_1_0= RULE_ID
            {
            lv_name_1_0=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleI18NBundleMdsl1688); 

            			newLeafNode(lv_name_1_0, grammarAccess.getI18NBundleMdslAccess().getNameIDTerminalRuleCall_1_0()); 
            		

            	        if (current==null) {
            	            current = createModelElement(grammarAccess.getI18NBundleMdslRule());
            	        }
                   		setWithLastConsumed(
                   			current, 
                   			"name",
                    		lv_name_1_0, 
                    		"ID");
            	    

            }


            }

            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:771:2: (otherlv_2= 'description:' ( (lv_description_3_0= RULE_STRING ) ) )?
            int alt9=2;
            int LA9_0 = input.LA(1);

            if ( (LA9_0==17) ) {
                alt9=1;
            }
            switch (alt9) {
                case 1 :
                    // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:771:4: otherlv_2= 'description:' ( (lv_description_3_0= RULE_STRING ) )
                    {
                    otherlv_2=(Token)match(input,17,FOLLOW_17_in_ruleI18NBundleMdsl1706); 

                        	newLeafNode(otherlv_2, grammarAccess.getI18NBundleMdslAccess().getDescriptionKeyword_2_0());
                        
                    // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:775:1: ( (lv_description_3_0= RULE_STRING ) )
                    // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:776:1: (lv_description_3_0= RULE_STRING )
                    {
                    // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:776:1: (lv_description_3_0= RULE_STRING )
                    // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:777:3: lv_description_3_0= RULE_STRING
                    {
                    lv_description_3_0=(Token)match(input,RULE_STRING,FOLLOW_RULE_STRING_in_ruleI18NBundleMdsl1723); 

                    			newLeafNode(lv_description_3_0, grammarAccess.getI18NBundleMdslAccess().getDescriptionSTRINGTerminalRuleCall_2_1_0()); 
                    		

                    	        if (current==null) {
                    	            current = createModelElement(grammarAccess.getI18NBundleMdslRule());
                    	        }
                           		setWithLastConsumed(
                           			current, 
                           			"description",
                            		lv_description_3_0, 
                            		"STRING");
                    	    

                    }


                    }


                    }
                    break;

            }

            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:793:4: ( (otherlv_4= 'location:' ( (lv_bundleDescriptor_5_0= ruleClassDescriptorMdsl ) ) ) | (otherlv_6= 'URI:' ( (lv_bundleUri_7_0= RULE_STRING ) ) ) )
            int alt10=2;
            int LA10_0 = input.LA(1);

            if ( (LA10_0==18) ) {
                alt10=1;
            }
            else if ( (LA10_0==19) ) {
                alt10=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 10, 0, input);

                throw nvae;
            }
            switch (alt10) {
                case 1 :
                    // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:793:5: (otherlv_4= 'location:' ( (lv_bundleDescriptor_5_0= ruleClassDescriptorMdsl ) ) )
                    {
                    // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:793:5: (otherlv_4= 'location:' ( (lv_bundleDescriptor_5_0= ruleClassDescriptorMdsl ) ) )
                    // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:793:7: otherlv_4= 'location:' ( (lv_bundleDescriptor_5_0= ruleClassDescriptorMdsl ) )
                    {
                    otherlv_4=(Token)match(input,18,FOLLOW_18_in_ruleI18NBundleMdsl1744); 

                        	newLeafNode(otherlv_4, grammarAccess.getI18NBundleMdslAccess().getLocationKeyword_3_0_0());
                        
                    // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:797:1: ( (lv_bundleDescriptor_5_0= ruleClassDescriptorMdsl ) )
                    // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:798:1: (lv_bundleDescriptor_5_0= ruleClassDescriptorMdsl )
                    {
                    // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:798:1: (lv_bundleDescriptor_5_0= ruleClassDescriptorMdsl )
                    // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:799:3: lv_bundleDescriptor_5_0= ruleClassDescriptorMdsl
                    {
                     
                    	        newCompositeNode(grammarAccess.getI18NBundleMdslAccess().getBundleDescriptorClassDescriptorMdslParserRuleCall_3_0_1_0()); 
                    	    
                    pushFollow(FOLLOW_ruleClassDescriptorMdsl_in_ruleI18NBundleMdsl1765);
                    lv_bundleDescriptor_5_0=ruleClassDescriptorMdsl();

                    state._fsp--;


                    	        if (current==null) {
                    	            current = createModelElementForParent(grammarAccess.getI18NBundleMdslRule());
                    	        }
                           		set(
                           			current, 
                           			"bundleDescriptor",
                            		lv_bundleDescriptor_5_0, 
                            		"ClassDescriptorMdsl");
                    	        afterParserOrEnumRuleCall();
                    	    

                    }


                    }


                    }


                    }
                    break;
                case 2 :
                    // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:816:6: (otherlv_6= 'URI:' ( (lv_bundleUri_7_0= RULE_STRING ) ) )
                    {
                    // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:816:6: (otherlv_6= 'URI:' ( (lv_bundleUri_7_0= RULE_STRING ) ) )
                    // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:816:8: otherlv_6= 'URI:' ( (lv_bundleUri_7_0= RULE_STRING ) )
                    {
                    otherlv_6=(Token)match(input,19,FOLLOW_19_in_ruleI18NBundleMdsl1785); 

                        	newLeafNode(otherlv_6, grammarAccess.getI18NBundleMdslAccess().getURIKeyword_3_1_0());
                        
                    // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:820:1: ( (lv_bundleUri_7_0= RULE_STRING ) )
                    // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:821:1: (lv_bundleUri_7_0= RULE_STRING )
                    {
                    // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:821:1: (lv_bundleUri_7_0= RULE_STRING )
                    // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:822:3: lv_bundleUri_7_0= RULE_STRING
                    {
                    lv_bundleUri_7_0=(Token)match(input,RULE_STRING,FOLLOW_RULE_STRING_in_ruleI18NBundleMdsl1802); 

                    			newLeafNode(lv_bundleUri_7_0, grammarAccess.getI18NBundleMdslAccess().getBundleUriSTRINGTerminalRuleCall_3_1_1_0()); 
                    		

                    	        if (current==null) {
                    	            current = createModelElement(grammarAccess.getI18NBundleMdslRule());
                    	        }
                           		setWithLastConsumed(
                           			current, 
                           			"bundleUri",
                            		lv_bundleUri_7_0, 
                            		"STRING");
                    	    

                    }


                    }


                    }


                    }
                    break;

            }


            }


            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleI18NBundleMdsl"


    // $ANTLR start "entryRuleForeignModelMdsl"
    // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:846:1: entryRuleForeignModelMdsl returns [EObject current=null] : iv_ruleForeignModelMdsl= ruleForeignModelMdsl EOF ;
    public final EObject entryRuleForeignModelMdsl() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleForeignModelMdsl = null;


        try {
            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:847:2: (iv_ruleForeignModelMdsl= ruleForeignModelMdsl EOF )
            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:848:2: iv_ruleForeignModelMdsl= ruleForeignModelMdsl EOF
            {
             newCompositeNode(grammarAccess.getForeignModelMdslRule()); 
            pushFollow(FOLLOW_ruleForeignModelMdsl_in_entryRuleForeignModelMdsl1845);
            iv_ruleForeignModelMdsl=ruleForeignModelMdsl();

            state._fsp--;

             current =iv_ruleForeignModelMdsl; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleForeignModelMdsl1855); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleForeignModelMdsl"


    // $ANTLR start "ruleForeignModelMdsl"
    // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:855:1: ruleForeignModelMdsl returns [EObject current=null] : (otherlv_0= 'Foreign Model' otherlv_1= '{' otherlv_2= 'model type:' ( (lv_name_3_0= RULE_ID ) ) otherlv_4= 'label:' ( (lv_label_5_0= RULE_STRING ) ) (otherlv_6= 'description:' ( (lv_description_7_0= RULE_STRING ) ) )? ( (lv_provider_8_0= ruleModelProviderMdsl ) ) (otherlv_9= 'synchronizer factory' otherlv_10= ':' ( (lv_synchronizerFactoryClass_11_0= ruleClassDescriptorMdsl ) ) )? (otherlv_12= 'extension manager' otherlv_13= ':' ( (lv_extensionManagerClass_14_0= ruleClassDescriptorMdsl ) ) )? ( (lv_dslReference_15_0= ruleXtextLanguageReference ) )? (otherlv_16= 'model locator:' ( (lv_relocatorQuery_17_0= ruleQuery ) ) )? otherlv_18= '}' ) ;
    public final EObject ruleForeignModelMdsl() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;
        Token otherlv_2=null;
        Token lv_name_3_0=null;
        Token otherlv_4=null;
        Token lv_label_5_0=null;
        Token otherlv_6=null;
        Token lv_description_7_0=null;
        Token otherlv_9=null;
        Token otherlv_10=null;
        Token otherlv_12=null;
        Token otherlv_13=null;
        Token otherlv_16=null;
        Token otherlv_18=null;
        EObject lv_provider_8_0 = null;

        EObject lv_synchronizerFactoryClass_11_0 = null;

        EObject lv_extensionManagerClass_14_0 = null;

        EObject lv_dslReference_15_0 = null;

        EObject lv_relocatorQuery_17_0 = null;


         enterRule(); 
            
        try {
            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:858:28: ( (otherlv_0= 'Foreign Model' otherlv_1= '{' otherlv_2= 'model type:' ( (lv_name_3_0= RULE_ID ) ) otherlv_4= 'label:' ( (lv_label_5_0= RULE_STRING ) ) (otherlv_6= 'description:' ( (lv_description_7_0= RULE_STRING ) ) )? ( (lv_provider_8_0= ruleModelProviderMdsl ) ) (otherlv_9= 'synchronizer factory' otherlv_10= ':' ( (lv_synchronizerFactoryClass_11_0= ruleClassDescriptorMdsl ) ) )? (otherlv_12= 'extension manager' otherlv_13= ':' ( (lv_extensionManagerClass_14_0= ruleClassDescriptorMdsl ) ) )? ( (lv_dslReference_15_0= ruleXtextLanguageReference ) )? (otherlv_16= 'model locator:' ( (lv_relocatorQuery_17_0= ruleQuery ) ) )? otherlv_18= '}' ) )
            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:859:1: (otherlv_0= 'Foreign Model' otherlv_1= '{' otherlv_2= 'model type:' ( (lv_name_3_0= RULE_ID ) ) otherlv_4= 'label:' ( (lv_label_5_0= RULE_STRING ) ) (otherlv_6= 'description:' ( (lv_description_7_0= RULE_STRING ) ) )? ( (lv_provider_8_0= ruleModelProviderMdsl ) ) (otherlv_9= 'synchronizer factory' otherlv_10= ':' ( (lv_synchronizerFactoryClass_11_0= ruleClassDescriptorMdsl ) ) )? (otherlv_12= 'extension manager' otherlv_13= ':' ( (lv_extensionManagerClass_14_0= ruleClassDescriptorMdsl ) ) )? ( (lv_dslReference_15_0= ruleXtextLanguageReference ) )? (otherlv_16= 'model locator:' ( (lv_relocatorQuery_17_0= ruleQuery ) ) )? otherlv_18= '}' )
            {
            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:859:1: (otherlv_0= 'Foreign Model' otherlv_1= '{' otherlv_2= 'model type:' ( (lv_name_3_0= RULE_ID ) ) otherlv_4= 'label:' ( (lv_label_5_0= RULE_STRING ) ) (otherlv_6= 'description:' ( (lv_description_7_0= RULE_STRING ) ) )? ( (lv_provider_8_0= ruleModelProviderMdsl ) ) (otherlv_9= 'synchronizer factory' otherlv_10= ':' ( (lv_synchronizerFactoryClass_11_0= ruleClassDescriptorMdsl ) ) )? (otherlv_12= 'extension manager' otherlv_13= ':' ( (lv_extensionManagerClass_14_0= ruleClassDescriptorMdsl ) ) )? ( (lv_dslReference_15_0= ruleXtextLanguageReference ) )? (otherlv_16= 'model locator:' ( (lv_relocatorQuery_17_0= ruleQuery ) ) )? otherlv_18= '}' )
            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:859:3: otherlv_0= 'Foreign Model' otherlv_1= '{' otherlv_2= 'model type:' ( (lv_name_3_0= RULE_ID ) ) otherlv_4= 'label:' ( (lv_label_5_0= RULE_STRING ) ) (otherlv_6= 'description:' ( (lv_description_7_0= RULE_STRING ) ) )? ( (lv_provider_8_0= ruleModelProviderMdsl ) ) (otherlv_9= 'synchronizer factory' otherlv_10= ':' ( (lv_synchronizerFactoryClass_11_0= ruleClassDescriptorMdsl ) ) )? (otherlv_12= 'extension manager' otherlv_13= ':' ( (lv_extensionManagerClass_14_0= ruleClassDescriptorMdsl ) ) )? ( (lv_dslReference_15_0= ruleXtextLanguageReference ) )? (otherlv_16= 'model locator:' ( (lv_relocatorQuery_17_0= ruleQuery ) ) )? otherlv_18= '}'
            {
            otherlv_0=(Token)match(input,21,FOLLOW_21_in_ruleForeignModelMdsl1892); 

                	newLeafNode(otherlv_0, grammarAccess.getForeignModelMdslAccess().getForeignModelKeyword_0());
                
            otherlv_1=(Token)match(input,22,FOLLOW_22_in_ruleForeignModelMdsl1904); 

                	newLeafNode(otherlv_1, grammarAccess.getForeignModelMdslAccess().getLeftCurlyBracketKeyword_1());
                
            otherlv_2=(Token)match(input,23,FOLLOW_23_in_ruleForeignModelMdsl1916); 

                	newLeafNode(otherlv_2, grammarAccess.getForeignModelMdslAccess().getModelTypeKeyword_2());
                
            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:871:1: ( (lv_name_3_0= RULE_ID ) )
            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:872:1: (lv_name_3_0= RULE_ID )
            {
            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:872:1: (lv_name_3_0= RULE_ID )
            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:873:3: lv_name_3_0= RULE_ID
            {
            lv_name_3_0=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleForeignModelMdsl1933); 

            			newLeafNode(lv_name_3_0, grammarAccess.getForeignModelMdslAccess().getNameIDTerminalRuleCall_3_0()); 
            		

            	        if (current==null) {
            	            current = createModelElement(grammarAccess.getForeignModelMdslRule());
            	        }
                   		setWithLastConsumed(
                   			current, 
                   			"name",
                    		lv_name_3_0, 
                    		"ID");
            	    

            }


            }

            otherlv_4=(Token)match(input,13,FOLLOW_13_in_ruleForeignModelMdsl1950); 

                	newLeafNode(otherlv_4, grammarAccess.getForeignModelMdslAccess().getLabelKeyword_4());
                
            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:893:1: ( (lv_label_5_0= RULE_STRING ) )
            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:894:1: (lv_label_5_0= RULE_STRING )
            {
            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:894:1: (lv_label_5_0= RULE_STRING )
            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:895:3: lv_label_5_0= RULE_STRING
            {
            lv_label_5_0=(Token)match(input,RULE_STRING,FOLLOW_RULE_STRING_in_ruleForeignModelMdsl1967); 

            			newLeafNode(lv_label_5_0, grammarAccess.getForeignModelMdslAccess().getLabelSTRINGTerminalRuleCall_5_0()); 
            		

            	        if (current==null) {
            	            current = createModelElement(grammarAccess.getForeignModelMdslRule());
            	        }
                   		setWithLastConsumed(
                   			current, 
                   			"label",
                    		lv_label_5_0, 
                    		"STRING");
            	    

            }


            }

            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:911:2: (otherlv_6= 'description:' ( (lv_description_7_0= RULE_STRING ) ) )?
            int alt11=2;
            int LA11_0 = input.LA(1);

            if ( (LA11_0==17) ) {
                alt11=1;
            }
            switch (alt11) {
                case 1 :
                    // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:911:4: otherlv_6= 'description:' ( (lv_description_7_0= RULE_STRING ) )
                    {
                    otherlv_6=(Token)match(input,17,FOLLOW_17_in_ruleForeignModelMdsl1985); 

                        	newLeafNode(otherlv_6, grammarAccess.getForeignModelMdslAccess().getDescriptionKeyword_6_0());
                        
                    // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:915:1: ( (lv_description_7_0= RULE_STRING ) )
                    // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:916:1: (lv_description_7_0= RULE_STRING )
                    {
                    // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:916:1: (lv_description_7_0= RULE_STRING )
                    // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:917:3: lv_description_7_0= RULE_STRING
                    {
                    lv_description_7_0=(Token)match(input,RULE_STRING,FOLLOW_RULE_STRING_in_ruleForeignModelMdsl2002); 

                    			newLeafNode(lv_description_7_0, grammarAccess.getForeignModelMdslAccess().getDescriptionSTRINGTerminalRuleCall_6_1_0()); 
                    		

                    	        if (current==null) {
                    	            current = createModelElement(grammarAccess.getForeignModelMdslRule());
                    	        }
                           		setWithLastConsumed(
                           			current, 
                           			"description",
                            		lv_description_7_0, 
                            		"STRING");
                    	    

                    }


                    }


                    }
                    break;

            }

            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:933:4: ( (lv_provider_8_0= ruleModelProviderMdsl ) )
            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:934:1: (lv_provider_8_0= ruleModelProviderMdsl )
            {
            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:934:1: (lv_provider_8_0= ruleModelProviderMdsl )
            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:935:3: lv_provider_8_0= ruleModelProviderMdsl
            {
             
            	        newCompositeNode(grammarAccess.getForeignModelMdslAccess().getProviderModelProviderMdslParserRuleCall_7_0()); 
            	    
            pushFollow(FOLLOW_ruleModelProviderMdsl_in_ruleForeignModelMdsl2030);
            lv_provider_8_0=ruleModelProviderMdsl();

            state._fsp--;


            	        if (current==null) {
            	            current = createModelElementForParent(grammarAccess.getForeignModelMdslRule());
            	        }
                   		set(
                   			current, 
                   			"provider",
                    		lv_provider_8_0, 
                    		"ModelProviderMdsl");
            	        afterParserOrEnumRuleCall();
            	    

            }


            }

            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:951:2: (otherlv_9= 'synchronizer factory' otherlv_10= ':' ( (lv_synchronizerFactoryClass_11_0= ruleClassDescriptorMdsl ) ) )?
            int alt12=2;
            int LA12_0 = input.LA(1);

            if ( (LA12_0==24) ) {
                alt12=1;
            }
            switch (alt12) {
                case 1 :
                    // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:951:4: otherlv_9= 'synchronizer factory' otherlv_10= ':' ( (lv_synchronizerFactoryClass_11_0= ruleClassDescriptorMdsl ) )
                    {
                    otherlv_9=(Token)match(input,24,FOLLOW_24_in_ruleForeignModelMdsl2043); 

                        	newLeafNode(otherlv_9, grammarAccess.getForeignModelMdslAccess().getSynchronizerFactoryKeyword_8_0());
                        
                    otherlv_10=(Token)match(input,25,FOLLOW_25_in_ruleForeignModelMdsl2055); 

                        	newLeafNode(otherlv_10, grammarAccess.getForeignModelMdslAccess().getColonKeyword_8_1());
                        
                    // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:959:1: ( (lv_synchronizerFactoryClass_11_0= ruleClassDescriptorMdsl ) )
                    // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:960:1: (lv_synchronizerFactoryClass_11_0= ruleClassDescriptorMdsl )
                    {
                    // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:960:1: (lv_synchronizerFactoryClass_11_0= ruleClassDescriptorMdsl )
                    // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:961:3: lv_synchronizerFactoryClass_11_0= ruleClassDescriptorMdsl
                    {
                     
                    	        newCompositeNode(grammarAccess.getForeignModelMdslAccess().getSynchronizerFactoryClassClassDescriptorMdslParserRuleCall_8_2_0()); 
                    	    
                    pushFollow(FOLLOW_ruleClassDescriptorMdsl_in_ruleForeignModelMdsl2076);
                    lv_synchronizerFactoryClass_11_0=ruleClassDescriptorMdsl();

                    state._fsp--;


                    	        if (current==null) {
                    	            current = createModelElementForParent(grammarAccess.getForeignModelMdslRule());
                    	        }
                           		set(
                           			current, 
                           			"synchronizerFactoryClass",
                            		lv_synchronizerFactoryClass_11_0, 
                            		"ClassDescriptorMdsl");
                    	        afterParserOrEnumRuleCall();
                    	    

                    }


                    }


                    }
                    break;

            }

            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:977:4: (otherlv_12= 'extension manager' otherlv_13= ':' ( (lv_extensionManagerClass_14_0= ruleClassDescriptorMdsl ) ) )?
            int alt13=2;
            int LA13_0 = input.LA(1);

            if ( (LA13_0==26) ) {
                alt13=1;
            }
            switch (alt13) {
                case 1 :
                    // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:977:6: otherlv_12= 'extension manager' otherlv_13= ':' ( (lv_extensionManagerClass_14_0= ruleClassDescriptorMdsl ) )
                    {
                    otherlv_12=(Token)match(input,26,FOLLOW_26_in_ruleForeignModelMdsl2091); 

                        	newLeafNode(otherlv_12, grammarAccess.getForeignModelMdslAccess().getExtensionManagerKeyword_9_0());
                        
                    otherlv_13=(Token)match(input,25,FOLLOW_25_in_ruleForeignModelMdsl2103); 

                        	newLeafNode(otherlv_13, grammarAccess.getForeignModelMdslAccess().getColonKeyword_9_1());
                        
                    // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:985:1: ( (lv_extensionManagerClass_14_0= ruleClassDescriptorMdsl ) )
                    // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:986:1: (lv_extensionManagerClass_14_0= ruleClassDescriptorMdsl )
                    {
                    // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:986:1: (lv_extensionManagerClass_14_0= ruleClassDescriptorMdsl )
                    // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:987:3: lv_extensionManagerClass_14_0= ruleClassDescriptorMdsl
                    {
                     
                    	        newCompositeNode(grammarAccess.getForeignModelMdslAccess().getExtensionManagerClassClassDescriptorMdslParserRuleCall_9_2_0()); 
                    	    
                    pushFollow(FOLLOW_ruleClassDescriptorMdsl_in_ruleForeignModelMdsl2124);
                    lv_extensionManagerClass_14_0=ruleClassDescriptorMdsl();

                    state._fsp--;


                    	        if (current==null) {
                    	            current = createModelElementForParent(grammarAccess.getForeignModelMdslRule());
                    	        }
                           		set(
                           			current, 
                           			"extensionManagerClass",
                            		lv_extensionManagerClass_14_0, 
                            		"ClassDescriptorMdsl");
                    	        afterParserOrEnumRuleCall();
                    	    

                    }


                    }


                    }
                    break;

            }

            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:1003:4: ( (lv_dslReference_15_0= ruleXtextLanguageReference ) )?
            int alt14=2;
            int LA14_0 = input.LA(1);

            if ( (LA14_0==38) ) {
                alt14=1;
            }
            switch (alt14) {
                case 1 :
                    // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:1004:1: (lv_dslReference_15_0= ruleXtextLanguageReference )
                    {
                    // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:1004:1: (lv_dslReference_15_0= ruleXtextLanguageReference )
                    // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:1005:3: lv_dslReference_15_0= ruleXtextLanguageReference
                    {
                     
                    	        newCompositeNode(grammarAccess.getForeignModelMdslAccess().getDslReferenceXtextLanguageReferenceParserRuleCall_10_0()); 
                    	    
                    pushFollow(FOLLOW_ruleXtextLanguageReference_in_ruleForeignModelMdsl2147);
                    lv_dslReference_15_0=ruleXtextLanguageReference();

                    state._fsp--;


                    	        if (current==null) {
                    	            current = createModelElementForParent(grammarAccess.getForeignModelMdslRule());
                    	        }
                           		set(
                           			current, 
                           			"dslReference",
                            		lv_dslReference_15_0, 
                            		"XtextLanguageReference");
                    	        afterParserOrEnumRuleCall();
                    	    

                    }


                    }
                    break;

            }

            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:1021:3: (otherlv_16= 'model locator:' ( (lv_relocatorQuery_17_0= ruleQuery ) ) )?
            int alt15=2;
            int LA15_0 = input.LA(1);

            if ( (LA15_0==27) ) {
                alt15=1;
            }
            switch (alt15) {
                case 1 :
                    // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:1021:5: otherlv_16= 'model locator:' ( (lv_relocatorQuery_17_0= ruleQuery ) )
                    {
                    otherlv_16=(Token)match(input,27,FOLLOW_27_in_ruleForeignModelMdsl2161); 

                        	newLeafNode(otherlv_16, grammarAccess.getForeignModelMdslAccess().getModelLocatorKeyword_11_0());
                        
                    // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:1025:1: ( (lv_relocatorQuery_17_0= ruleQuery ) )
                    // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:1026:1: (lv_relocatorQuery_17_0= ruleQuery )
                    {
                    // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:1026:1: (lv_relocatorQuery_17_0= ruleQuery )
                    // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:1027:3: lv_relocatorQuery_17_0= ruleQuery
                    {
                     
                    	        newCompositeNode(grammarAccess.getForeignModelMdslAccess().getRelocatorQueryQueryParserRuleCall_11_1_0()); 
                    	    
                    pushFollow(FOLLOW_ruleQuery_in_ruleForeignModelMdsl2182);
                    lv_relocatorQuery_17_0=ruleQuery();

                    state._fsp--;


                    	        if (current==null) {
                    	            current = createModelElementForParent(grammarAccess.getForeignModelMdslRule());
                    	        }
                           		set(
                           			current, 
                           			"relocatorQuery",
                            		lv_relocatorQuery_17_0, 
                            		"Query");
                    	        afterParserOrEnumRuleCall();
                    	    

                    }


                    }


                    }
                    break;

            }

            otherlv_18=(Token)match(input,28,FOLLOW_28_in_ruleForeignModelMdsl2196); 

                	newLeafNode(otherlv_18, grammarAccess.getForeignModelMdslAccess().getRightCurlyBracketKeyword_12());
                

            }


            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleForeignModelMdsl"


    // $ANTLR start "entryRuleModelProviderMdsl"
    // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:1055:1: entryRuleModelProviderMdsl returns [EObject current=null] : iv_ruleModelProviderMdsl= ruleModelProviderMdsl EOF ;
    public final EObject entryRuleModelProviderMdsl() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleModelProviderMdsl = null;


        try {
            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:1056:2: (iv_ruleModelProviderMdsl= ruleModelProviderMdsl EOF )
            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:1057:2: iv_ruleModelProviderMdsl= ruleModelProviderMdsl EOF
            {
             newCompositeNode(grammarAccess.getModelProviderMdslRule()); 
            pushFollow(FOLLOW_ruleModelProviderMdsl_in_entryRuleModelProviderMdsl2232);
            iv_ruleModelProviderMdsl=ruleModelProviderMdsl();

            state._fsp--;

             current =iv_ruleModelProviderMdsl; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleModelProviderMdsl2242); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleModelProviderMdsl"


    // $ANTLR start "ruleModelProviderMdsl"
    // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:1064:1: ruleModelProviderMdsl returns [EObject current=null] : (this_URIModelProviderMdsl_0= ruleURIModelProviderMdsl | this_URIExtensionModelProviderMdsl_1= ruleURIExtensionModelProviderMdsl | this_CustomModelProviderMdsl_2= ruleCustomModelProviderMdsl ) ;
    public final EObject ruleModelProviderMdsl() throws RecognitionException {
        EObject current = null;

        EObject this_URIModelProviderMdsl_0 = null;

        EObject this_URIExtensionModelProviderMdsl_1 = null;

        EObject this_CustomModelProviderMdsl_2 = null;


         enterRule(); 
            
        try {
            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:1067:28: ( (this_URIModelProviderMdsl_0= ruleURIModelProviderMdsl | this_URIExtensionModelProviderMdsl_1= ruleURIExtensionModelProviderMdsl | this_CustomModelProviderMdsl_2= ruleCustomModelProviderMdsl ) )
            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:1068:1: (this_URIModelProviderMdsl_0= ruleURIModelProviderMdsl | this_URIExtensionModelProviderMdsl_1= ruleURIExtensionModelProviderMdsl | this_CustomModelProviderMdsl_2= ruleCustomModelProviderMdsl )
            {
            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:1068:1: (this_URIModelProviderMdsl_0= ruleURIModelProviderMdsl | this_URIExtensionModelProviderMdsl_1= ruleURIExtensionModelProviderMdsl | this_CustomModelProviderMdsl_2= ruleCustomModelProviderMdsl )
            int alt16=3;
            switch ( input.LA(1) ) {
            case 30:
                {
                alt16=1;
                }
                break;
            case 29:
                {
                alt16=2;
                }
                break;
            case 31:
                {
                alt16=3;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 16, 0, input);

                throw nvae;
            }

            switch (alt16) {
                case 1 :
                    // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:1069:5: this_URIModelProviderMdsl_0= ruleURIModelProviderMdsl
                    {
                     
                            newCompositeNode(grammarAccess.getModelProviderMdslAccess().getURIModelProviderMdslParserRuleCall_0()); 
                        
                    pushFollow(FOLLOW_ruleURIModelProviderMdsl_in_ruleModelProviderMdsl2289);
                    this_URIModelProviderMdsl_0=ruleURIModelProviderMdsl();

                    state._fsp--;

                     
                            current = this_URIModelProviderMdsl_0; 
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;
                case 2 :
                    // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:1079:5: this_URIExtensionModelProviderMdsl_1= ruleURIExtensionModelProviderMdsl
                    {
                     
                            newCompositeNode(grammarAccess.getModelProviderMdslAccess().getURIExtensionModelProviderMdslParserRuleCall_1()); 
                        
                    pushFollow(FOLLOW_ruleURIExtensionModelProviderMdsl_in_ruleModelProviderMdsl2316);
                    this_URIExtensionModelProviderMdsl_1=ruleURIExtensionModelProviderMdsl();

                    state._fsp--;

                     
                            current = this_URIExtensionModelProviderMdsl_1; 
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;
                case 3 :
                    // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:1089:5: this_CustomModelProviderMdsl_2= ruleCustomModelProviderMdsl
                    {
                     
                            newCompositeNode(grammarAccess.getModelProviderMdslAccess().getCustomModelProviderMdslParserRuleCall_2()); 
                        
                    pushFollow(FOLLOW_ruleCustomModelProviderMdsl_in_ruleModelProviderMdsl2343);
                    this_CustomModelProviderMdsl_2=ruleCustomModelProviderMdsl();

                    state._fsp--;

                     
                            current = this_CustomModelProviderMdsl_2; 
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;

            }


            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleModelProviderMdsl"


    // $ANTLR start "entryRuleURIExtensionModelProviderMdsl"
    // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:1105:1: entryRuleURIExtensionModelProviderMdsl returns [EObject current=null] : iv_ruleURIExtensionModelProviderMdsl= ruleURIExtensionModelProviderMdsl EOF ;
    public final EObject entryRuleURIExtensionModelProviderMdsl() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleURIExtensionModelProviderMdsl = null;


        try {
            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:1106:2: (iv_ruleURIExtensionModelProviderMdsl= ruleURIExtensionModelProviderMdsl EOF )
            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:1107:2: iv_ruleURIExtensionModelProviderMdsl= ruleURIExtensionModelProviderMdsl EOF
            {
             newCompositeNode(grammarAccess.getURIExtensionModelProviderMdslRule()); 
            pushFollow(FOLLOW_ruleURIExtensionModelProviderMdsl_in_entryRuleURIExtensionModelProviderMdsl2378);
            iv_ruleURIExtensionModelProviderMdsl=ruleURIExtensionModelProviderMdsl();

            state._fsp--;

             current =iv_ruleURIExtensionModelProviderMdsl; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleURIExtensionModelProviderMdsl2388); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleURIExtensionModelProviderMdsl"


    // $ANTLR start "ruleURIExtensionModelProviderMdsl"
    // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:1114:1: ruleURIExtensionModelProviderMdsl returns [EObject current=null] : (otherlv_0= 'Uri Extension:' ( (lv_uriExtension_1_0= RULE_STRING ) ) ) ;
    public final EObject ruleURIExtensionModelProviderMdsl() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token lv_uriExtension_1_0=null;

         enterRule(); 
            
        try {
            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:1117:28: ( (otherlv_0= 'Uri Extension:' ( (lv_uriExtension_1_0= RULE_STRING ) ) ) )
            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:1118:1: (otherlv_0= 'Uri Extension:' ( (lv_uriExtension_1_0= RULE_STRING ) ) )
            {
            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:1118:1: (otherlv_0= 'Uri Extension:' ( (lv_uriExtension_1_0= RULE_STRING ) ) )
            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:1118:3: otherlv_0= 'Uri Extension:' ( (lv_uriExtension_1_0= RULE_STRING ) )
            {
            otherlv_0=(Token)match(input,29,FOLLOW_29_in_ruleURIExtensionModelProviderMdsl2425); 

                	newLeafNode(otherlv_0, grammarAccess.getURIExtensionModelProviderMdslAccess().getUriExtensionKeyword_0());
                
            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:1122:1: ( (lv_uriExtension_1_0= RULE_STRING ) )
            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:1123:1: (lv_uriExtension_1_0= RULE_STRING )
            {
            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:1123:1: (lv_uriExtension_1_0= RULE_STRING )
            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:1124:3: lv_uriExtension_1_0= RULE_STRING
            {
            lv_uriExtension_1_0=(Token)match(input,RULE_STRING,FOLLOW_RULE_STRING_in_ruleURIExtensionModelProviderMdsl2442); 

            			newLeafNode(lv_uriExtension_1_0, grammarAccess.getURIExtensionModelProviderMdslAccess().getUriExtensionSTRINGTerminalRuleCall_1_0()); 
            		

            	        if (current==null) {
            	            current = createModelElement(grammarAccess.getURIExtensionModelProviderMdslRule());
            	        }
                   		setWithLastConsumed(
                   			current, 
                   			"uriExtension",
                    		lv_uriExtension_1_0, 
                    		"STRING");
            	    

            }


            }


            }


            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleURIExtensionModelProviderMdsl"


    // $ANTLR start "entryRuleURIModelProviderMdsl"
    // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:1148:1: entryRuleURIModelProviderMdsl returns [EObject current=null] : iv_ruleURIModelProviderMdsl= ruleURIModelProviderMdsl EOF ;
    public final EObject entryRuleURIModelProviderMdsl() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleURIModelProviderMdsl = null;


        try {
            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:1149:2: (iv_ruleURIModelProviderMdsl= ruleURIModelProviderMdsl EOF )
            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:1150:2: iv_ruleURIModelProviderMdsl= ruleURIModelProviderMdsl EOF
            {
             newCompositeNode(grammarAccess.getURIModelProviderMdslRule()); 
            pushFollow(FOLLOW_ruleURIModelProviderMdsl_in_entryRuleURIModelProviderMdsl2483);
            iv_ruleURIModelProviderMdsl=ruleURIModelProviderMdsl();

            state._fsp--;

             current =iv_ruleURIModelProviderMdsl; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleURIModelProviderMdsl2493); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleURIModelProviderMdsl"


    // $ANTLR start "ruleURIModelProviderMdsl"
    // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:1157:1: ruleURIModelProviderMdsl returns [EObject current=null] : (otherlv_0= 'Model Uri:' ( (lv_modelUri_1_0= RULE_STRING ) ) ) ;
    public final EObject ruleURIModelProviderMdsl() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token lv_modelUri_1_0=null;

         enterRule(); 
            
        try {
            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:1160:28: ( (otherlv_0= 'Model Uri:' ( (lv_modelUri_1_0= RULE_STRING ) ) ) )
            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:1161:1: (otherlv_0= 'Model Uri:' ( (lv_modelUri_1_0= RULE_STRING ) ) )
            {
            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:1161:1: (otherlv_0= 'Model Uri:' ( (lv_modelUri_1_0= RULE_STRING ) ) )
            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:1161:3: otherlv_0= 'Model Uri:' ( (lv_modelUri_1_0= RULE_STRING ) )
            {
            otherlv_0=(Token)match(input,30,FOLLOW_30_in_ruleURIModelProviderMdsl2530); 

                	newLeafNode(otherlv_0, grammarAccess.getURIModelProviderMdslAccess().getModelUriKeyword_0());
                
            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:1165:1: ( (lv_modelUri_1_0= RULE_STRING ) )
            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:1166:1: (lv_modelUri_1_0= RULE_STRING )
            {
            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:1166:1: (lv_modelUri_1_0= RULE_STRING )
            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:1167:3: lv_modelUri_1_0= RULE_STRING
            {
            lv_modelUri_1_0=(Token)match(input,RULE_STRING,FOLLOW_RULE_STRING_in_ruleURIModelProviderMdsl2547); 

            			newLeafNode(lv_modelUri_1_0, grammarAccess.getURIModelProviderMdslAccess().getModelUriSTRINGTerminalRuleCall_1_0()); 
            		

            	        if (current==null) {
            	            current = createModelElement(grammarAccess.getURIModelProviderMdslRule());
            	        }
                   		setWithLastConsumed(
                   			current, 
                   			"modelUri",
                    		lv_modelUri_1_0, 
                    		"STRING");
            	    

            }


            }


            }


            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleURIModelProviderMdsl"


    // $ANTLR start "entryRuleCustomModelProviderMdsl"
    // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:1191:1: entryRuleCustomModelProviderMdsl returns [EObject current=null] : iv_ruleCustomModelProviderMdsl= ruleCustomModelProviderMdsl EOF ;
    public final EObject entryRuleCustomModelProviderMdsl() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleCustomModelProviderMdsl = null;


        try {
            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:1192:2: (iv_ruleCustomModelProviderMdsl= ruleCustomModelProviderMdsl EOF )
            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:1193:2: iv_ruleCustomModelProviderMdsl= ruleCustomModelProviderMdsl EOF
            {
             newCompositeNode(grammarAccess.getCustomModelProviderMdslRule()); 
            pushFollow(FOLLOW_ruleCustomModelProviderMdsl_in_entryRuleCustomModelProviderMdsl2588);
            iv_ruleCustomModelProviderMdsl=ruleCustomModelProviderMdsl();

            state._fsp--;

             current =iv_ruleCustomModelProviderMdsl; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleCustomModelProviderMdsl2598); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleCustomModelProviderMdsl"


    // $ANTLR start "ruleCustomModelProviderMdsl"
    // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:1200:1: ruleCustomModelProviderMdsl returns [EObject current=null] : (otherlv_0= 'Provider Class:' ( (lv_classDescriptor_1_0= ruleClassDescriptorMdsl ) ) (otherlv_2= 'parameters:' ( (lv_parameters_3_0= RULE_STRING ) ) (otherlv_4= ',' ( (lv_parameters_5_0= RULE_STRING ) ) )? )? ) ;
    public final EObject ruleCustomModelProviderMdsl() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_2=null;
        Token lv_parameters_3_0=null;
        Token otherlv_4=null;
        Token lv_parameters_5_0=null;
        EObject lv_classDescriptor_1_0 = null;


         enterRule(); 
            
        try {
            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:1203:28: ( (otherlv_0= 'Provider Class:' ( (lv_classDescriptor_1_0= ruleClassDescriptorMdsl ) ) (otherlv_2= 'parameters:' ( (lv_parameters_3_0= RULE_STRING ) ) (otherlv_4= ',' ( (lv_parameters_5_0= RULE_STRING ) ) )? )? ) )
            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:1204:1: (otherlv_0= 'Provider Class:' ( (lv_classDescriptor_1_0= ruleClassDescriptorMdsl ) ) (otherlv_2= 'parameters:' ( (lv_parameters_3_0= RULE_STRING ) ) (otherlv_4= ',' ( (lv_parameters_5_0= RULE_STRING ) ) )? )? )
            {
            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:1204:1: (otherlv_0= 'Provider Class:' ( (lv_classDescriptor_1_0= ruleClassDescriptorMdsl ) ) (otherlv_2= 'parameters:' ( (lv_parameters_3_0= RULE_STRING ) ) (otherlv_4= ',' ( (lv_parameters_5_0= RULE_STRING ) ) )? )? )
            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:1204:3: otherlv_0= 'Provider Class:' ( (lv_classDescriptor_1_0= ruleClassDescriptorMdsl ) ) (otherlv_2= 'parameters:' ( (lv_parameters_3_0= RULE_STRING ) ) (otherlv_4= ',' ( (lv_parameters_5_0= RULE_STRING ) ) )? )?
            {
            otherlv_0=(Token)match(input,31,FOLLOW_31_in_ruleCustomModelProviderMdsl2635); 

                	newLeafNode(otherlv_0, grammarAccess.getCustomModelProviderMdslAccess().getProviderClassKeyword_0());
                
            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:1208:1: ( (lv_classDescriptor_1_0= ruleClassDescriptorMdsl ) )
            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:1209:1: (lv_classDescriptor_1_0= ruleClassDescriptorMdsl )
            {
            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:1209:1: (lv_classDescriptor_1_0= ruleClassDescriptorMdsl )
            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:1210:3: lv_classDescriptor_1_0= ruleClassDescriptorMdsl
            {
             
            	        newCompositeNode(grammarAccess.getCustomModelProviderMdslAccess().getClassDescriptorClassDescriptorMdslParserRuleCall_1_0()); 
            	    
            pushFollow(FOLLOW_ruleClassDescriptorMdsl_in_ruleCustomModelProviderMdsl2656);
            lv_classDescriptor_1_0=ruleClassDescriptorMdsl();

            state._fsp--;


            	        if (current==null) {
            	            current = createModelElementForParent(grammarAccess.getCustomModelProviderMdslRule());
            	        }
                   		set(
                   			current, 
                   			"classDescriptor",
                    		lv_classDescriptor_1_0, 
                    		"ClassDescriptorMdsl");
            	        afterParserOrEnumRuleCall();
            	    

            }


            }

            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:1226:2: (otherlv_2= 'parameters:' ( (lv_parameters_3_0= RULE_STRING ) ) (otherlv_4= ',' ( (lv_parameters_5_0= RULE_STRING ) ) )? )?
            int alt18=2;
            int LA18_0 = input.LA(1);

            if ( (LA18_0==32) ) {
                alt18=1;
            }
            switch (alt18) {
                case 1 :
                    // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:1226:4: otherlv_2= 'parameters:' ( (lv_parameters_3_0= RULE_STRING ) ) (otherlv_4= ',' ( (lv_parameters_5_0= RULE_STRING ) ) )?
                    {
                    otherlv_2=(Token)match(input,32,FOLLOW_32_in_ruleCustomModelProviderMdsl2669); 

                        	newLeafNode(otherlv_2, grammarAccess.getCustomModelProviderMdslAccess().getParametersKeyword_2_0());
                        
                    // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:1230:1: ( (lv_parameters_3_0= RULE_STRING ) )
                    // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:1231:1: (lv_parameters_3_0= RULE_STRING )
                    {
                    // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:1231:1: (lv_parameters_3_0= RULE_STRING )
                    // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:1232:3: lv_parameters_3_0= RULE_STRING
                    {
                    lv_parameters_3_0=(Token)match(input,RULE_STRING,FOLLOW_RULE_STRING_in_ruleCustomModelProviderMdsl2686); 

                    			newLeafNode(lv_parameters_3_0, grammarAccess.getCustomModelProviderMdslAccess().getParametersSTRINGTerminalRuleCall_2_1_0()); 
                    		

                    	        if (current==null) {
                    	            current = createModelElement(grammarAccess.getCustomModelProviderMdslRule());
                    	        }
                           		addWithLastConsumed(
                           			current, 
                           			"parameters",
                            		lv_parameters_3_0, 
                            		"STRING");
                    	    

                    }


                    }

                    // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:1248:2: (otherlv_4= ',' ( (lv_parameters_5_0= RULE_STRING ) ) )?
                    int alt17=2;
                    int LA17_0 = input.LA(1);

                    if ( (LA17_0==33) ) {
                        alt17=1;
                    }
                    switch (alt17) {
                        case 1 :
                            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:1248:4: otherlv_4= ',' ( (lv_parameters_5_0= RULE_STRING ) )
                            {
                            otherlv_4=(Token)match(input,33,FOLLOW_33_in_ruleCustomModelProviderMdsl2704); 

                                	newLeafNode(otherlv_4, grammarAccess.getCustomModelProviderMdslAccess().getCommaKeyword_2_2_0());
                                
                            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:1252:1: ( (lv_parameters_5_0= RULE_STRING ) )
                            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:1253:1: (lv_parameters_5_0= RULE_STRING )
                            {
                            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:1253:1: (lv_parameters_5_0= RULE_STRING )
                            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:1254:3: lv_parameters_5_0= RULE_STRING
                            {
                            lv_parameters_5_0=(Token)match(input,RULE_STRING,FOLLOW_RULE_STRING_in_ruleCustomModelProviderMdsl2721); 

                            			newLeafNode(lv_parameters_5_0, grammarAccess.getCustomModelProviderMdslAccess().getParametersSTRINGTerminalRuleCall_2_2_1_0()); 
                            		

                            	        if (current==null) {
                            	            current = createModelElement(grammarAccess.getCustomModelProviderMdslRule());
                            	        }
                                   		addWithLastConsumed(
                                   			current, 
                                   			"parameters",
                                    		lv_parameters_5_0, 
                                    		"STRING");
                            	    

                            }


                            }


                            }
                            break;

                    }


                    }
                    break;

            }


            }


            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleCustomModelProviderMdsl"


    // $ANTLR start "entryRuleXtextLanguageDescriptorMdsl"
    // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:1278:1: entryRuleXtextLanguageDescriptorMdsl returns [EObject current=null] : iv_ruleXtextLanguageDescriptorMdsl= ruleXtextLanguageDescriptorMdsl EOF ;
    public final EObject entryRuleXtextLanguageDescriptorMdsl() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleXtextLanguageDescriptorMdsl = null;


        try {
            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:1279:2: (iv_ruleXtextLanguageDescriptorMdsl= ruleXtextLanguageDescriptorMdsl EOF )
            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:1280:2: iv_ruleXtextLanguageDescriptorMdsl= ruleXtextLanguageDescriptorMdsl EOF
            {
             newCompositeNode(grammarAccess.getXtextLanguageDescriptorMdslRule()); 
            pushFollow(FOLLOW_ruleXtextLanguageDescriptorMdsl_in_entryRuleXtextLanguageDescriptorMdsl2766);
            iv_ruleXtextLanguageDescriptorMdsl=ruleXtextLanguageDescriptorMdsl();

            state._fsp--;

             current =iv_ruleXtextLanguageDescriptorMdsl; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleXtextLanguageDescriptorMdsl2776); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleXtextLanguageDescriptorMdsl"


    // $ANTLR start "ruleXtextLanguageDescriptorMdsl"
    // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:1287:1: ruleXtextLanguageDescriptorMdsl returns [EObject current=null] : (otherlv_0= 'Xtext DSL:' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= 'language Id:' ( (lv_languageId_3_0= RULE_ID ) ) otherlv_4= 'from bundle:' ( (lv_bundleId_5_0= RULE_ID ) ) otherlv_6= 'with activator:' ( (lv_activatorClassName_7_0= RULE_ID ) ) ) ;
    public final EObject ruleXtextLanguageDescriptorMdsl() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token lv_name_1_0=null;
        Token otherlv_2=null;
        Token lv_languageId_3_0=null;
        Token otherlv_4=null;
        Token lv_bundleId_5_0=null;
        Token otherlv_6=null;
        Token lv_activatorClassName_7_0=null;

         enterRule(); 
            
        try {
            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:1290:28: ( (otherlv_0= 'Xtext DSL:' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= 'language Id:' ( (lv_languageId_3_0= RULE_ID ) ) otherlv_4= 'from bundle:' ( (lv_bundleId_5_0= RULE_ID ) ) otherlv_6= 'with activator:' ( (lv_activatorClassName_7_0= RULE_ID ) ) ) )
            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:1291:1: (otherlv_0= 'Xtext DSL:' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= 'language Id:' ( (lv_languageId_3_0= RULE_ID ) ) otherlv_4= 'from bundle:' ( (lv_bundleId_5_0= RULE_ID ) ) otherlv_6= 'with activator:' ( (lv_activatorClassName_7_0= RULE_ID ) ) )
            {
            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:1291:1: (otherlv_0= 'Xtext DSL:' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= 'language Id:' ( (lv_languageId_3_0= RULE_ID ) ) otherlv_4= 'from bundle:' ( (lv_bundleId_5_0= RULE_ID ) ) otherlv_6= 'with activator:' ( (lv_activatorClassName_7_0= RULE_ID ) ) )
            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:1291:3: otherlv_0= 'Xtext DSL:' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= 'language Id:' ( (lv_languageId_3_0= RULE_ID ) ) otherlv_4= 'from bundle:' ( (lv_bundleId_5_0= RULE_ID ) ) otherlv_6= 'with activator:' ( (lv_activatorClassName_7_0= RULE_ID ) )
            {
            otherlv_0=(Token)match(input,34,FOLLOW_34_in_ruleXtextLanguageDescriptorMdsl2813); 

                	newLeafNode(otherlv_0, grammarAccess.getXtextLanguageDescriptorMdslAccess().getXtextDSLKeyword_0());
                
            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:1295:1: ( (lv_name_1_0= RULE_ID ) )
            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:1296:1: (lv_name_1_0= RULE_ID )
            {
            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:1296:1: (lv_name_1_0= RULE_ID )
            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:1297:3: lv_name_1_0= RULE_ID
            {
            lv_name_1_0=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleXtextLanguageDescriptorMdsl2830); 

            			newLeafNode(lv_name_1_0, grammarAccess.getXtextLanguageDescriptorMdslAccess().getNameIDTerminalRuleCall_1_0()); 
            		

            	        if (current==null) {
            	            current = createModelElement(grammarAccess.getXtextLanguageDescriptorMdslRule());
            	        }
                   		setWithLastConsumed(
                   			current, 
                   			"name",
                    		lv_name_1_0, 
                    		"ID");
            	    

            }


            }

            otherlv_2=(Token)match(input,35,FOLLOW_35_in_ruleXtextLanguageDescriptorMdsl2847); 

                	newLeafNode(otherlv_2, grammarAccess.getXtextLanguageDescriptorMdslAccess().getLanguageIdKeyword_2());
                
            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:1317:1: ( (lv_languageId_3_0= RULE_ID ) )
            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:1318:1: (lv_languageId_3_0= RULE_ID )
            {
            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:1318:1: (lv_languageId_3_0= RULE_ID )
            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:1319:3: lv_languageId_3_0= RULE_ID
            {
            lv_languageId_3_0=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleXtextLanguageDescriptorMdsl2864); 

            			newLeafNode(lv_languageId_3_0, grammarAccess.getXtextLanguageDescriptorMdslAccess().getLanguageIdIDTerminalRuleCall_3_0()); 
            		

            	        if (current==null) {
            	            current = createModelElement(grammarAccess.getXtextLanguageDescriptorMdslRule());
            	        }
                   		setWithLastConsumed(
                   			current, 
                   			"languageId",
                    		lv_languageId_3_0, 
                    		"ID");
            	    

            }


            }

            otherlv_4=(Token)match(input,36,FOLLOW_36_in_ruleXtextLanguageDescriptorMdsl2881); 

                	newLeafNode(otherlv_4, grammarAccess.getXtextLanguageDescriptorMdslAccess().getFromBundleKeyword_4());
                
            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:1339:1: ( (lv_bundleId_5_0= RULE_ID ) )
            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:1340:1: (lv_bundleId_5_0= RULE_ID )
            {
            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:1340:1: (lv_bundleId_5_0= RULE_ID )
            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:1341:3: lv_bundleId_5_0= RULE_ID
            {
            lv_bundleId_5_0=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleXtextLanguageDescriptorMdsl2898); 

            			newLeafNode(lv_bundleId_5_0, grammarAccess.getXtextLanguageDescriptorMdslAccess().getBundleIdIDTerminalRuleCall_5_0()); 
            		

            	        if (current==null) {
            	            current = createModelElement(grammarAccess.getXtextLanguageDescriptorMdslRule());
            	        }
                   		setWithLastConsumed(
                   			current, 
                   			"bundleId",
                    		lv_bundleId_5_0, 
                    		"ID");
            	    

            }


            }

            otherlv_6=(Token)match(input,37,FOLLOW_37_in_ruleXtextLanguageDescriptorMdsl2915); 

                	newLeafNode(otherlv_6, grammarAccess.getXtextLanguageDescriptorMdslAccess().getWithActivatorKeyword_6());
                
            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:1361:1: ( (lv_activatorClassName_7_0= RULE_ID ) )
            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:1362:1: (lv_activatorClassName_7_0= RULE_ID )
            {
            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:1362:1: (lv_activatorClassName_7_0= RULE_ID )
            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:1363:3: lv_activatorClassName_7_0= RULE_ID
            {
            lv_activatorClassName_7_0=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleXtextLanguageDescriptorMdsl2932); 

            			newLeafNode(lv_activatorClassName_7_0, grammarAccess.getXtextLanguageDescriptorMdslAccess().getActivatorClassNameIDTerminalRuleCall_7_0()); 
            		

            	        if (current==null) {
            	            current = createModelElement(grammarAccess.getXtextLanguageDescriptorMdslRule());
            	        }
                   		setWithLastConsumed(
                   			current, 
                   			"activatorClassName",
                    		lv_activatorClassName_7_0, 
                    		"ID");
            	    

            }


            }


            }


            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleXtextLanguageDescriptorMdsl"


    // $ANTLR start "entryRuleXtextLanguageReference"
    // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:1387:1: entryRuleXtextLanguageReference returns [EObject current=null] : iv_ruleXtextLanguageReference= ruleXtextLanguageReference EOF ;
    public final EObject entryRuleXtextLanguageReference() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleXtextLanguageReference = null;


        try {
            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:1388:2: (iv_ruleXtextLanguageReference= ruleXtextLanguageReference EOF )
            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:1389:2: iv_ruleXtextLanguageReference= ruleXtextLanguageReference EOF
            {
             newCompositeNode(grammarAccess.getXtextLanguageReferenceRule()); 
            pushFollow(FOLLOW_ruleXtextLanguageReference_in_entryRuleXtextLanguageReference2973);
            iv_ruleXtextLanguageReference=ruleXtextLanguageReference();

            state._fsp--;

             current =iv_ruleXtextLanguageReference; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleXtextLanguageReference2983); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleXtextLanguageReference"


    // $ANTLR start "ruleXtextLanguageReference"
    // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:1396:1: ruleXtextLanguageReference returns [EObject current=null] : (otherlv_0= 'DSL:' ( (otherlv_1= RULE_ID ) ) ) ;
    public final EObject ruleXtextLanguageReference() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;

         enterRule(); 
            
        try {
            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:1399:28: ( (otherlv_0= 'DSL:' ( (otherlv_1= RULE_ID ) ) ) )
            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:1400:1: (otherlv_0= 'DSL:' ( (otherlv_1= RULE_ID ) ) )
            {
            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:1400:1: (otherlv_0= 'DSL:' ( (otherlv_1= RULE_ID ) ) )
            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:1400:3: otherlv_0= 'DSL:' ( (otherlv_1= RULE_ID ) )
            {
            otherlv_0=(Token)match(input,38,FOLLOW_38_in_ruleXtextLanguageReference3020); 

                	newLeafNode(otherlv_0, grammarAccess.getXtextLanguageReferenceAccess().getDSLKeyword_0());
                
            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:1404:1: ( (otherlv_1= RULE_ID ) )
            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:1405:1: (otherlv_1= RULE_ID )
            {
            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:1405:1: (otherlv_1= RULE_ID )
            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:1406:3: otherlv_1= RULE_ID
            {

            			if (current==null) {
            	            current = createModelElement(grammarAccess.getXtextLanguageReferenceRule());
            	        }
                    
            otherlv_1=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleXtextLanguageReference3040); 

            		newLeafNode(otherlv_1, grammarAccess.getXtextLanguageReferenceAccess().getXtextLanguageDescriptorXtextLanguageDescriptorMdslCrossReference_1_0()); 
            	

            }


            }


            }


            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleXtextLanguageReference"


    // $ANTLR start "entryRuleQueryEvaluatorMdsl"
    // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:1425:1: entryRuleQueryEvaluatorMdsl returns [EObject current=null] : iv_ruleQueryEvaluatorMdsl= ruleQueryEvaluatorMdsl EOF ;
    public final EObject entryRuleQueryEvaluatorMdsl() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleQueryEvaluatorMdsl = null;


        try {
            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:1426:2: (iv_ruleQueryEvaluatorMdsl= ruleQueryEvaluatorMdsl EOF )
            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:1427:2: iv_ruleQueryEvaluatorMdsl= ruleQueryEvaluatorMdsl EOF
            {
             newCompositeNode(grammarAccess.getQueryEvaluatorMdslRule()); 
            pushFollow(FOLLOW_ruleQueryEvaluatorMdsl_in_entryRuleQueryEvaluatorMdsl3076);
            iv_ruleQueryEvaluatorMdsl=ruleQueryEvaluatorMdsl();

            state._fsp--;

             current =iv_ruleQueryEvaluatorMdsl; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleQueryEvaluatorMdsl3086); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleQueryEvaluatorMdsl"


    // $ANTLR start "ruleQueryEvaluatorMdsl"
    // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:1434:1: ruleQueryEvaluatorMdsl returns [EObject current=null] : (otherlv_0= 'Query Evaluator' otherlv_1= '{' otherlv_2= 'language id:' ( (lv_name_3_0= RULE_ID ) ) otherlv_4= 'label:' ( (lv_label_5_0= RULE_STRING ) ) otherlv_6= 'Evaluator' otherlv_7= 'Class:' ( (lv_classDescriptor_8_0= ruleClassDescriptorMdsl ) ) (otherlv_9= 'query Properties type:' ( (lv_queryPropertiesTypes_10_0= rulePropertyTypeMdsl ) ) (otherlv_11= ',' ( (lv_queryPropertiesTypes_12_0= rulePropertyTypeMdsl ) ) )* )? (otherlv_13= 'external query provider:' ( (lv_extQServiceClassDescriptor_14_0= ruleClassDescriptorMdsl ) ) )? (otherlv_15= 'description:' ( (lv_description_16_0= RULE_STRING ) ) )? otherlv_17= '}' ) ;
    public final EObject ruleQueryEvaluatorMdsl() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;
        Token otherlv_2=null;
        Token lv_name_3_0=null;
        Token otherlv_4=null;
        Token lv_label_5_0=null;
        Token otherlv_6=null;
        Token otherlv_7=null;
        Token otherlv_9=null;
        Token otherlv_11=null;
        Token otherlv_13=null;
        Token otherlv_15=null;
        Token lv_description_16_0=null;
        Token otherlv_17=null;
        EObject lv_classDescriptor_8_0 = null;

        EObject lv_queryPropertiesTypes_10_0 = null;

        EObject lv_queryPropertiesTypes_12_0 = null;

        EObject lv_extQServiceClassDescriptor_14_0 = null;


         enterRule(); 
            
        try {
            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:1437:28: ( (otherlv_0= 'Query Evaluator' otherlv_1= '{' otherlv_2= 'language id:' ( (lv_name_3_0= RULE_ID ) ) otherlv_4= 'label:' ( (lv_label_5_0= RULE_STRING ) ) otherlv_6= 'Evaluator' otherlv_7= 'Class:' ( (lv_classDescriptor_8_0= ruleClassDescriptorMdsl ) ) (otherlv_9= 'query Properties type:' ( (lv_queryPropertiesTypes_10_0= rulePropertyTypeMdsl ) ) (otherlv_11= ',' ( (lv_queryPropertiesTypes_12_0= rulePropertyTypeMdsl ) ) )* )? (otherlv_13= 'external query provider:' ( (lv_extQServiceClassDescriptor_14_0= ruleClassDescriptorMdsl ) ) )? (otherlv_15= 'description:' ( (lv_description_16_0= RULE_STRING ) ) )? otherlv_17= '}' ) )
            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:1438:1: (otherlv_0= 'Query Evaluator' otherlv_1= '{' otherlv_2= 'language id:' ( (lv_name_3_0= RULE_ID ) ) otherlv_4= 'label:' ( (lv_label_5_0= RULE_STRING ) ) otherlv_6= 'Evaluator' otherlv_7= 'Class:' ( (lv_classDescriptor_8_0= ruleClassDescriptorMdsl ) ) (otherlv_9= 'query Properties type:' ( (lv_queryPropertiesTypes_10_0= rulePropertyTypeMdsl ) ) (otherlv_11= ',' ( (lv_queryPropertiesTypes_12_0= rulePropertyTypeMdsl ) ) )* )? (otherlv_13= 'external query provider:' ( (lv_extQServiceClassDescriptor_14_0= ruleClassDescriptorMdsl ) ) )? (otherlv_15= 'description:' ( (lv_description_16_0= RULE_STRING ) ) )? otherlv_17= '}' )
            {
            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:1438:1: (otherlv_0= 'Query Evaluator' otherlv_1= '{' otherlv_2= 'language id:' ( (lv_name_3_0= RULE_ID ) ) otherlv_4= 'label:' ( (lv_label_5_0= RULE_STRING ) ) otherlv_6= 'Evaluator' otherlv_7= 'Class:' ( (lv_classDescriptor_8_0= ruleClassDescriptorMdsl ) ) (otherlv_9= 'query Properties type:' ( (lv_queryPropertiesTypes_10_0= rulePropertyTypeMdsl ) ) (otherlv_11= ',' ( (lv_queryPropertiesTypes_12_0= rulePropertyTypeMdsl ) ) )* )? (otherlv_13= 'external query provider:' ( (lv_extQServiceClassDescriptor_14_0= ruleClassDescriptorMdsl ) ) )? (otherlv_15= 'description:' ( (lv_description_16_0= RULE_STRING ) ) )? otherlv_17= '}' )
            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:1438:3: otherlv_0= 'Query Evaluator' otherlv_1= '{' otherlv_2= 'language id:' ( (lv_name_3_0= RULE_ID ) ) otherlv_4= 'label:' ( (lv_label_5_0= RULE_STRING ) ) otherlv_6= 'Evaluator' otherlv_7= 'Class:' ( (lv_classDescriptor_8_0= ruleClassDescriptorMdsl ) ) (otherlv_9= 'query Properties type:' ( (lv_queryPropertiesTypes_10_0= rulePropertyTypeMdsl ) ) (otherlv_11= ',' ( (lv_queryPropertiesTypes_12_0= rulePropertyTypeMdsl ) ) )* )? (otherlv_13= 'external query provider:' ( (lv_extQServiceClassDescriptor_14_0= ruleClassDescriptorMdsl ) ) )? (otherlv_15= 'description:' ( (lv_description_16_0= RULE_STRING ) ) )? otherlv_17= '}'
            {
            otherlv_0=(Token)match(input,39,FOLLOW_39_in_ruleQueryEvaluatorMdsl3123); 

                	newLeafNode(otherlv_0, grammarAccess.getQueryEvaluatorMdslAccess().getQueryEvaluatorKeyword_0());
                
            otherlv_1=(Token)match(input,22,FOLLOW_22_in_ruleQueryEvaluatorMdsl3135); 

                	newLeafNode(otherlv_1, grammarAccess.getQueryEvaluatorMdslAccess().getLeftCurlyBracketKeyword_1());
                
            otherlv_2=(Token)match(input,40,FOLLOW_40_in_ruleQueryEvaluatorMdsl3147); 

                	newLeafNode(otherlv_2, grammarAccess.getQueryEvaluatorMdslAccess().getLanguageIdKeyword_2());
                
            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:1450:1: ( (lv_name_3_0= RULE_ID ) )
            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:1451:1: (lv_name_3_0= RULE_ID )
            {
            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:1451:1: (lv_name_3_0= RULE_ID )
            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:1452:3: lv_name_3_0= RULE_ID
            {
            lv_name_3_0=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleQueryEvaluatorMdsl3164); 

            			newLeafNode(lv_name_3_0, grammarAccess.getQueryEvaluatorMdslAccess().getNameIDTerminalRuleCall_3_0()); 
            		

            	        if (current==null) {
            	            current = createModelElement(grammarAccess.getQueryEvaluatorMdslRule());
            	        }
                   		setWithLastConsumed(
                   			current, 
                   			"name",
                    		lv_name_3_0, 
                    		"ID");
            	    

            }


            }

            otherlv_4=(Token)match(input,13,FOLLOW_13_in_ruleQueryEvaluatorMdsl3181); 

                	newLeafNode(otherlv_4, grammarAccess.getQueryEvaluatorMdslAccess().getLabelKeyword_4());
                
            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:1472:1: ( (lv_label_5_0= RULE_STRING ) )
            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:1473:1: (lv_label_5_0= RULE_STRING )
            {
            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:1473:1: (lv_label_5_0= RULE_STRING )
            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:1474:3: lv_label_5_0= RULE_STRING
            {
            lv_label_5_0=(Token)match(input,RULE_STRING,FOLLOW_RULE_STRING_in_ruleQueryEvaluatorMdsl3198); 

            			newLeafNode(lv_label_5_0, grammarAccess.getQueryEvaluatorMdslAccess().getLabelSTRINGTerminalRuleCall_5_0()); 
            		

            	        if (current==null) {
            	            current = createModelElement(grammarAccess.getQueryEvaluatorMdslRule());
            	        }
                   		setWithLastConsumed(
                   			current, 
                   			"label",
                    		lv_label_5_0, 
                    		"STRING");
            	    

            }


            }

            otherlv_6=(Token)match(input,41,FOLLOW_41_in_ruleQueryEvaluatorMdsl3215); 

                	newLeafNode(otherlv_6, grammarAccess.getQueryEvaluatorMdslAccess().getEvaluatorKeyword_6());
                
            otherlv_7=(Token)match(input,42,FOLLOW_42_in_ruleQueryEvaluatorMdsl3227); 

                	newLeafNode(otherlv_7, grammarAccess.getQueryEvaluatorMdslAccess().getClassKeyword_7());
                
            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:1498:1: ( (lv_classDescriptor_8_0= ruleClassDescriptorMdsl ) )
            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:1499:1: (lv_classDescriptor_8_0= ruleClassDescriptorMdsl )
            {
            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:1499:1: (lv_classDescriptor_8_0= ruleClassDescriptorMdsl )
            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:1500:3: lv_classDescriptor_8_0= ruleClassDescriptorMdsl
            {
             
            	        newCompositeNode(grammarAccess.getQueryEvaluatorMdslAccess().getClassDescriptorClassDescriptorMdslParserRuleCall_8_0()); 
            	    
            pushFollow(FOLLOW_ruleClassDescriptorMdsl_in_ruleQueryEvaluatorMdsl3248);
            lv_classDescriptor_8_0=ruleClassDescriptorMdsl();

            state._fsp--;


            	        if (current==null) {
            	            current = createModelElementForParent(grammarAccess.getQueryEvaluatorMdslRule());
            	        }
                   		set(
                   			current, 
                   			"classDescriptor",
                    		lv_classDescriptor_8_0, 
                    		"ClassDescriptorMdsl");
            	        afterParserOrEnumRuleCall();
            	    

            }


            }

            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:1516:2: (otherlv_9= 'query Properties type:' ( (lv_queryPropertiesTypes_10_0= rulePropertyTypeMdsl ) ) (otherlv_11= ',' ( (lv_queryPropertiesTypes_12_0= rulePropertyTypeMdsl ) ) )* )?
            int alt20=2;
            int LA20_0 = input.LA(1);

            if ( (LA20_0==43) ) {
                alt20=1;
            }
            switch (alt20) {
                case 1 :
                    // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:1516:4: otherlv_9= 'query Properties type:' ( (lv_queryPropertiesTypes_10_0= rulePropertyTypeMdsl ) ) (otherlv_11= ',' ( (lv_queryPropertiesTypes_12_0= rulePropertyTypeMdsl ) ) )*
                    {
                    otherlv_9=(Token)match(input,43,FOLLOW_43_in_ruleQueryEvaluatorMdsl3261); 

                        	newLeafNode(otherlv_9, grammarAccess.getQueryEvaluatorMdslAccess().getQueryPropertiesTypeKeyword_9_0());
                        
                    // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:1520:1: ( (lv_queryPropertiesTypes_10_0= rulePropertyTypeMdsl ) )
                    // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:1521:1: (lv_queryPropertiesTypes_10_0= rulePropertyTypeMdsl )
                    {
                    // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:1521:1: (lv_queryPropertiesTypes_10_0= rulePropertyTypeMdsl )
                    // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:1522:3: lv_queryPropertiesTypes_10_0= rulePropertyTypeMdsl
                    {
                     
                    	        newCompositeNode(grammarAccess.getQueryEvaluatorMdslAccess().getQueryPropertiesTypesPropertyTypeMdslParserRuleCall_9_1_0()); 
                    	    
                    pushFollow(FOLLOW_rulePropertyTypeMdsl_in_ruleQueryEvaluatorMdsl3282);
                    lv_queryPropertiesTypes_10_0=rulePropertyTypeMdsl();

                    state._fsp--;


                    	        if (current==null) {
                    	            current = createModelElementForParent(grammarAccess.getQueryEvaluatorMdslRule());
                    	        }
                           		add(
                           			current, 
                           			"queryPropertiesTypes",
                            		lv_queryPropertiesTypes_10_0, 
                            		"PropertyTypeMdsl");
                    	        afterParserOrEnumRuleCall();
                    	    

                    }


                    }

                    // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:1538:2: (otherlv_11= ',' ( (lv_queryPropertiesTypes_12_0= rulePropertyTypeMdsl ) ) )*
                    loop19:
                    do {
                        int alt19=2;
                        int LA19_0 = input.LA(1);

                        if ( (LA19_0==33) ) {
                            alt19=1;
                        }


                        switch (alt19) {
                    	case 1 :
                    	    // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:1538:4: otherlv_11= ',' ( (lv_queryPropertiesTypes_12_0= rulePropertyTypeMdsl ) )
                    	    {
                    	    otherlv_11=(Token)match(input,33,FOLLOW_33_in_ruleQueryEvaluatorMdsl3295); 

                    	        	newLeafNode(otherlv_11, grammarAccess.getQueryEvaluatorMdslAccess().getCommaKeyword_9_2_0());
                    	        
                    	    // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:1542:1: ( (lv_queryPropertiesTypes_12_0= rulePropertyTypeMdsl ) )
                    	    // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:1543:1: (lv_queryPropertiesTypes_12_0= rulePropertyTypeMdsl )
                    	    {
                    	    // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:1543:1: (lv_queryPropertiesTypes_12_0= rulePropertyTypeMdsl )
                    	    // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:1544:3: lv_queryPropertiesTypes_12_0= rulePropertyTypeMdsl
                    	    {
                    	     
                    	    	        newCompositeNode(grammarAccess.getQueryEvaluatorMdslAccess().getQueryPropertiesTypesPropertyTypeMdslParserRuleCall_9_2_1_0()); 
                    	    	    
                    	    pushFollow(FOLLOW_rulePropertyTypeMdsl_in_ruleQueryEvaluatorMdsl3316);
                    	    lv_queryPropertiesTypes_12_0=rulePropertyTypeMdsl();

                    	    state._fsp--;


                    	    	        if (current==null) {
                    	    	            current = createModelElementForParent(grammarAccess.getQueryEvaluatorMdslRule());
                    	    	        }
                    	           		add(
                    	           			current, 
                    	           			"queryPropertiesTypes",
                    	            		lv_queryPropertiesTypes_12_0, 
                    	            		"PropertyTypeMdsl");
                    	    	        afterParserOrEnumRuleCall();
                    	    	    

                    	    }


                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop19;
                        }
                    } while (true);


                    }
                    break;

            }

            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:1560:6: (otherlv_13= 'external query provider:' ( (lv_extQServiceClassDescriptor_14_0= ruleClassDescriptorMdsl ) ) )?
            int alt21=2;
            int LA21_0 = input.LA(1);

            if ( (LA21_0==44) ) {
                alt21=1;
            }
            switch (alt21) {
                case 1 :
                    // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:1560:8: otherlv_13= 'external query provider:' ( (lv_extQServiceClassDescriptor_14_0= ruleClassDescriptorMdsl ) )
                    {
                    otherlv_13=(Token)match(input,44,FOLLOW_44_in_ruleQueryEvaluatorMdsl3333); 

                        	newLeafNode(otherlv_13, grammarAccess.getQueryEvaluatorMdslAccess().getExternalQueryProviderKeyword_10_0());
                        
                    // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:1564:1: ( (lv_extQServiceClassDescriptor_14_0= ruleClassDescriptorMdsl ) )
                    // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:1565:1: (lv_extQServiceClassDescriptor_14_0= ruleClassDescriptorMdsl )
                    {
                    // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:1565:1: (lv_extQServiceClassDescriptor_14_0= ruleClassDescriptorMdsl )
                    // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:1566:3: lv_extQServiceClassDescriptor_14_0= ruleClassDescriptorMdsl
                    {
                     
                    	        newCompositeNode(grammarAccess.getQueryEvaluatorMdslAccess().getExtQServiceClassDescriptorClassDescriptorMdslParserRuleCall_10_1_0()); 
                    	    
                    pushFollow(FOLLOW_ruleClassDescriptorMdsl_in_ruleQueryEvaluatorMdsl3354);
                    lv_extQServiceClassDescriptor_14_0=ruleClassDescriptorMdsl();

                    state._fsp--;


                    	        if (current==null) {
                    	            current = createModelElementForParent(grammarAccess.getQueryEvaluatorMdslRule());
                    	        }
                           		set(
                           			current, 
                           			"extQServiceClassDescriptor",
                            		lv_extQServiceClassDescriptor_14_0, 
                            		"ClassDescriptorMdsl");
                    	        afterParserOrEnumRuleCall();
                    	    

                    }


                    }


                    }
                    break;

            }

            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:1582:4: (otherlv_15= 'description:' ( (lv_description_16_0= RULE_STRING ) ) )?
            int alt22=2;
            int LA22_0 = input.LA(1);

            if ( (LA22_0==17) ) {
                alt22=1;
            }
            switch (alt22) {
                case 1 :
                    // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:1582:6: otherlv_15= 'description:' ( (lv_description_16_0= RULE_STRING ) )
                    {
                    otherlv_15=(Token)match(input,17,FOLLOW_17_in_ruleQueryEvaluatorMdsl3369); 

                        	newLeafNode(otherlv_15, grammarAccess.getQueryEvaluatorMdslAccess().getDescriptionKeyword_11_0());
                        
                    // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:1586:1: ( (lv_description_16_0= RULE_STRING ) )
                    // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:1587:1: (lv_description_16_0= RULE_STRING )
                    {
                    // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:1587:1: (lv_description_16_0= RULE_STRING )
                    // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:1588:3: lv_description_16_0= RULE_STRING
                    {
                    lv_description_16_0=(Token)match(input,RULE_STRING,FOLLOW_RULE_STRING_in_ruleQueryEvaluatorMdsl3386); 

                    			newLeafNode(lv_description_16_0, grammarAccess.getQueryEvaluatorMdslAccess().getDescriptionSTRINGTerminalRuleCall_11_1_0()); 
                    		

                    	        if (current==null) {
                    	            current = createModelElement(grammarAccess.getQueryEvaluatorMdslRule());
                    	        }
                           		setWithLastConsumed(
                           			current, 
                           			"description",
                            		lv_description_16_0, 
                            		"STRING");
                    	    

                    }


                    }


                    }
                    break;

            }

            otherlv_17=(Token)match(input,28,FOLLOW_28_in_ruleQueryEvaluatorMdsl3405); 

                	newLeafNode(otherlv_17, grammarAccess.getQueryEvaluatorMdslAccess().getRightCurlyBracketKeyword_12());
                

            }


            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleQueryEvaluatorMdsl"


    // $ANTLR start "entryRuleWidgetType"
    // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:1616:1: entryRuleWidgetType returns [EObject current=null] : iv_ruleWidgetType= ruleWidgetType EOF ;
    public final EObject entryRuleWidgetType() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleWidgetType = null;


        try {
            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:1617:2: (iv_ruleWidgetType= ruleWidgetType EOF )
            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:1618:2: iv_ruleWidgetType= ruleWidgetType EOF
            {
             newCompositeNode(grammarAccess.getWidgetTypeRule()); 
            pushFollow(FOLLOW_ruleWidgetType_in_entryRuleWidgetType3441);
            iv_ruleWidgetType=ruleWidgetType();

            state._fsp--;

             current =iv_ruleWidgetType; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleWidgetType3451); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleWidgetType"


    // $ANTLR start "ruleWidgetType"
    // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:1625:1: ruleWidgetType returns [EObject current=null] : (otherlv_0= 'Widget type' otherlv_1= '{' otherlv_2= 'name:' ( (lv_name_3_0= RULE_ID ) ) otherlv_4= 'category:' ( (lv_category_5_0= ruleWIDGET_CATEGORY_MDSL ) ) otherlv_6= 'label:' ( (lv_label_7_0= RULE_STRING ) ) otherlv_8= 'custom widget:' ( (lv_classDescriptor_9_0= ruleClassDescriptorMdsl ) ) (otherlv_10= 'description:' ( (lv_description_11_0= RULE_STRING ) ) )? otherlv_12= '}' ) ;
    public final EObject ruleWidgetType() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;
        Token otherlv_2=null;
        Token lv_name_3_0=null;
        Token otherlv_4=null;
        Token otherlv_6=null;
        Token lv_label_7_0=null;
        Token otherlv_8=null;
        Token otherlv_10=null;
        Token lv_description_11_0=null;
        Token otherlv_12=null;
        Enumerator lv_category_5_0 = null;

        EObject lv_classDescriptor_9_0 = null;


         enterRule(); 
            
        try {
            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:1628:28: ( (otherlv_0= 'Widget type' otherlv_1= '{' otherlv_2= 'name:' ( (lv_name_3_0= RULE_ID ) ) otherlv_4= 'category:' ( (lv_category_5_0= ruleWIDGET_CATEGORY_MDSL ) ) otherlv_6= 'label:' ( (lv_label_7_0= RULE_STRING ) ) otherlv_8= 'custom widget:' ( (lv_classDescriptor_9_0= ruleClassDescriptorMdsl ) ) (otherlv_10= 'description:' ( (lv_description_11_0= RULE_STRING ) ) )? otherlv_12= '}' ) )
            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:1629:1: (otherlv_0= 'Widget type' otherlv_1= '{' otherlv_2= 'name:' ( (lv_name_3_0= RULE_ID ) ) otherlv_4= 'category:' ( (lv_category_5_0= ruleWIDGET_CATEGORY_MDSL ) ) otherlv_6= 'label:' ( (lv_label_7_0= RULE_STRING ) ) otherlv_8= 'custom widget:' ( (lv_classDescriptor_9_0= ruleClassDescriptorMdsl ) ) (otherlv_10= 'description:' ( (lv_description_11_0= RULE_STRING ) ) )? otherlv_12= '}' )
            {
            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:1629:1: (otherlv_0= 'Widget type' otherlv_1= '{' otherlv_2= 'name:' ( (lv_name_3_0= RULE_ID ) ) otherlv_4= 'category:' ( (lv_category_5_0= ruleWIDGET_CATEGORY_MDSL ) ) otherlv_6= 'label:' ( (lv_label_7_0= RULE_STRING ) ) otherlv_8= 'custom widget:' ( (lv_classDescriptor_9_0= ruleClassDescriptorMdsl ) ) (otherlv_10= 'description:' ( (lv_description_11_0= RULE_STRING ) ) )? otherlv_12= '}' )
            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:1629:3: otherlv_0= 'Widget type' otherlv_1= '{' otherlv_2= 'name:' ( (lv_name_3_0= RULE_ID ) ) otherlv_4= 'category:' ( (lv_category_5_0= ruleWIDGET_CATEGORY_MDSL ) ) otherlv_6= 'label:' ( (lv_label_7_0= RULE_STRING ) ) otherlv_8= 'custom widget:' ( (lv_classDescriptor_9_0= ruleClassDescriptorMdsl ) ) (otherlv_10= 'description:' ( (lv_description_11_0= RULE_STRING ) ) )? otherlv_12= '}'
            {
            otherlv_0=(Token)match(input,45,FOLLOW_45_in_ruleWidgetType3488); 

                	newLeafNode(otherlv_0, grammarAccess.getWidgetTypeAccess().getWidgetTypeKeyword_0());
                
            otherlv_1=(Token)match(input,22,FOLLOW_22_in_ruleWidgetType3500); 

                	newLeafNode(otherlv_1, grammarAccess.getWidgetTypeAccess().getLeftCurlyBracketKeyword_1());
                
            otherlv_2=(Token)match(input,46,FOLLOW_46_in_ruleWidgetType3512); 

                	newLeafNode(otherlv_2, grammarAccess.getWidgetTypeAccess().getNameKeyword_2());
                
            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:1641:1: ( (lv_name_3_0= RULE_ID ) )
            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:1642:1: (lv_name_3_0= RULE_ID )
            {
            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:1642:1: (lv_name_3_0= RULE_ID )
            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:1643:3: lv_name_3_0= RULE_ID
            {
            lv_name_3_0=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleWidgetType3529); 

            			newLeafNode(lv_name_3_0, grammarAccess.getWidgetTypeAccess().getNameIDTerminalRuleCall_3_0()); 
            		

            	        if (current==null) {
            	            current = createModelElement(grammarAccess.getWidgetTypeRule());
            	        }
                   		setWithLastConsumed(
                   			current, 
                   			"name",
                    		lv_name_3_0, 
                    		"ID");
            	    

            }


            }

            otherlv_4=(Token)match(input,47,FOLLOW_47_in_ruleWidgetType3546); 

                	newLeafNode(otherlv_4, grammarAccess.getWidgetTypeAccess().getCategoryKeyword_4());
                
            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:1663:1: ( (lv_category_5_0= ruleWIDGET_CATEGORY_MDSL ) )
            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:1664:1: (lv_category_5_0= ruleWIDGET_CATEGORY_MDSL )
            {
            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:1664:1: (lv_category_5_0= ruleWIDGET_CATEGORY_MDSL )
            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:1665:3: lv_category_5_0= ruleWIDGET_CATEGORY_MDSL
            {
             
            	        newCompositeNode(grammarAccess.getWidgetTypeAccess().getCategoryWIDGET_CATEGORY_MDSLEnumRuleCall_5_0()); 
            	    
            pushFollow(FOLLOW_ruleWIDGET_CATEGORY_MDSL_in_ruleWidgetType3567);
            lv_category_5_0=ruleWIDGET_CATEGORY_MDSL();

            state._fsp--;


            	        if (current==null) {
            	            current = createModelElementForParent(grammarAccess.getWidgetTypeRule());
            	        }
                   		set(
                   			current, 
                   			"category",
                    		lv_category_5_0, 
                    		"WIDGET_CATEGORY_MDSL");
            	        afterParserOrEnumRuleCall();
            	    

            }


            }

            otherlv_6=(Token)match(input,13,FOLLOW_13_in_ruleWidgetType3579); 

                	newLeafNode(otherlv_6, grammarAccess.getWidgetTypeAccess().getLabelKeyword_6());
                
            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:1685:1: ( (lv_label_7_0= RULE_STRING ) )
            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:1686:1: (lv_label_7_0= RULE_STRING )
            {
            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:1686:1: (lv_label_7_0= RULE_STRING )
            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:1687:3: lv_label_7_0= RULE_STRING
            {
            lv_label_7_0=(Token)match(input,RULE_STRING,FOLLOW_RULE_STRING_in_ruleWidgetType3596); 

            			newLeafNode(lv_label_7_0, grammarAccess.getWidgetTypeAccess().getLabelSTRINGTerminalRuleCall_7_0()); 
            		

            	        if (current==null) {
            	            current = createModelElement(grammarAccess.getWidgetTypeRule());
            	        }
                   		setWithLastConsumed(
                   			current, 
                   			"label",
                    		lv_label_7_0, 
                    		"STRING");
            	    

            }


            }

            otherlv_8=(Token)match(input,48,FOLLOW_48_in_ruleWidgetType3613); 

                	newLeafNode(otherlv_8, grammarAccess.getWidgetTypeAccess().getCustomWidgetKeyword_8());
                
            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:1707:1: ( (lv_classDescriptor_9_0= ruleClassDescriptorMdsl ) )
            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:1708:1: (lv_classDescriptor_9_0= ruleClassDescriptorMdsl )
            {
            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:1708:1: (lv_classDescriptor_9_0= ruleClassDescriptorMdsl )
            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:1709:3: lv_classDescriptor_9_0= ruleClassDescriptorMdsl
            {
             
            	        newCompositeNode(grammarAccess.getWidgetTypeAccess().getClassDescriptorClassDescriptorMdslParserRuleCall_9_0()); 
            	    
            pushFollow(FOLLOW_ruleClassDescriptorMdsl_in_ruleWidgetType3634);
            lv_classDescriptor_9_0=ruleClassDescriptorMdsl();

            state._fsp--;


            	        if (current==null) {
            	            current = createModelElementForParent(grammarAccess.getWidgetTypeRule());
            	        }
                   		set(
                   			current, 
                   			"classDescriptor",
                    		lv_classDescriptor_9_0, 
                    		"ClassDescriptorMdsl");
            	        afterParserOrEnumRuleCall();
            	    

            }


            }

            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:1725:2: (otherlv_10= 'description:' ( (lv_description_11_0= RULE_STRING ) ) )?
            int alt23=2;
            int LA23_0 = input.LA(1);

            if ( (LA23_0==17) ) {
                alt23=1;
            }
            switch (alt23) {
                case 1 :
                    // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:1725:4: otherlv_10= 'description:' ( (lv_description_11_0= RULE_STRING ) )
                    {
                    otherlv_10=(Token)match(input,17,FOLLOW_17_in_ruleWidgetType3647); 

                        	newLeafNode(otherlv_10, grammarAccess.getWidgetTypeAccess().getDescriptionKeyword_10_0());
                        
                    // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:1729:1: ( (lv_description_11_0= RULE_STRING ) )
                    // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:1730:1: (lv_description_11_0= RULE_STRING )
                    {
                    // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:1730:1: (lv_description_11_0= RULE_STRING )
                    // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:1731:3: lv_description_11_0= RULE_STRING
                    {
                    lv_description_11_0=(Token)match(input,RULE_STRING,FOLLOW_RULE_STRING_in_ruleWidgetType3664); 

                    			newLeafNode(lv_description_11_0, grammarAccess.getWidgetTypeAccess().getDescriptionSTRINGTerminalRuleCall_10_1_0()); 
                    		

                    	        if (current==null) {
                    	            current = createModelElement(grammarAccess.getWidgetTypeRule());
                    	        }
                           		setWithLastConsumed(
                           			current, 
                           			"description",
                            		lv_description_11_0, 
                            		"STRING");
                    	    

                    }


                    }


                    }
                    break;

            }

            otherlv_12=(Token)match(input,28,FOLLOW_28_in_ruleWidgetType3683); 

                	newLeafNode(otherlv_12, grammarAccess.getWidgetTypeAccess().getRightCurlyBracketKeyword_11());
                

            }


            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleWidgetType"


    // $ANTLR start "entryRuleUITabMdsl"
    // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:1759:1: entryRuleUITabMdsl returns [EObject current=null] : iv_ruleUITabMdsl= ruleUITabMdsl EOF ;
    public final EObject entryRuleUITabMdsl() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleUITabMdsl = null;


        try {
            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:1760:2: (iv_ruleUITabMdsl= ruleUITabMdsl EOF )
            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:1761:2: iv_ruleUITabMdsl= ruleUITabMdsl EOF
            {
             newCompositeNode(grammarAccess.getUITabMdslRule()); 
            pushFollow(FOLLOW_ruleUITabMdsl_in_entryRuleUITabMdsl3719);
            iv_ruleUITabMdsl=ruleUITabMdsl();

            state._fsp--;

             current =iv_ruleUITabMdsl; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleUITabMdsl3729); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleUITabMdsl"


    // $ANTLR start "ruleUITabMdsl"
    // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:1768:1: ruleUITabMdsl returns [EObject current=null] : (otherlv_0= 'UI' otherlv_1= 'Tab' otherlv_2= '{' otherlv_3= 'id:' ( (lv_name_4_0= RULE_ID ) ) ( (lv_i18NLabel_5_0= 'I18N' ) )? otherlv_6= 'label:' ( (lv_labelFormatExpr_7_0= ruleFormatExpr ) ) (otherlv_8= 'description:' ( (lv_description_9_0= RULE_STRING ) ) )? otherlv_10= '}' ) ;
    public final EObject ruleUITabMdsl() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;
        Token otherlv_2=null;
        Token otherlv_3=null;
        Token lv_name_4_0=null;
        Token lv_i18NLabel_5_0=null;
        Token otherlv_6=null;
        Token otherlv_8=null;
        Token lv_description_9_0=null;
        Token otherlv_10=null;
        EObject lv_labelFormatExpr_7_0 = null;


         enterRule(); 
            
        try {
            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:1771:28: ( (otherlv_0= 'UI' otherlv_1= 'Tab' otherlv_2= '{' otherlv_3= 'id:' ( (lv_name_4_0= RULE_ID ) ) ( (lv_i18NLabel_5_0= 'I18N' ) )? otherlv_6= 'label:' ( (lv_labelFormatExpr_7_0= ruleFormatExpr ) ) (otherlv_8= 'description:' ( (lv_description_9_0= RULE_STRING ) ) )? otherlv_10= '}' ) )
            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:1772:1: (otherlv_0= 'UI' otherlv_1= 'Tab' otherlv_2= '{' otherlv_3= 'id:' ( (lv_name_4_0= RULE_ID ) ) ( (lv_i18NLabel_5_0= 'I18N' ) )? otherlv_6= 'label:' ( (lv_labelFormatExpr_7_0= ruleFormatExpr ) ) (otherlv_8= 'description:' ( (lv_description_9_0= RULE_STRING ) ) )? otherlv_10= '}' )
            {
            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:1772:1: (otherlv_0= 'UI' otherlv_1= 'Tab' otherlv_2= '{' otherlv_3= 'id:' ( (lv_name_4_0= RULE_ID ) ) ( (lv_i18NLabel_5_0= 'I18N' ) )? otherlv_6= 'label:' ( (lv_labelFormatExpr_7_0= ruleFormatExpr ) ) (otherlv_8= 'description:' ( (lv_description_9_0= RULE_STRING ) ) )? otherlv_10= '}' )
            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:1772:3: otherlv_0= 'UI' otherlv_1= 'Tab' otherlv_2= '{' otherlv_3= 'id:' ( (lv_name_4_0= RULE_ID ) ) ( (lv_i18NLabel_5_0= 'I18N' ) )? otherlv_6= 'label:' ( (lv_labelFormatExpr_7_0= ruleFormatExpr ) ) (otherlv_8= 'description:' ( (lv_description_9_0= RULE_STRING ) ) )? otherlv_10= '}'
            {
            otherlv_0=(Token)match(input,49,FOLLOW_49_in_ruleUITabMdsl3766); 

                	newLeafNode(otherlv_0, grammarAccess.getUITabMdslAccess().getUIKeyword_0());
                
            otherlv_1=(Token)match(input,50,FOLLOW_50_in_ruleUITabMdsl3778); 

                	newLeafNode(otherlv_1, grammarAccess.getUITabMdslAccess().getTabKeyword_1());
                
            otherlv_2=(Token)match(input,22,FOLLOW_22_in_ruleUITabMdsl3790); 

                	newLeafNode(otherlv_2, grammarAccess.getUITabMdslAccess().getLeftCurlyBracketKeyword_2());
                
            otherlv_3=(Token)match(input,51,FOLLOW_51_in_ruleUITabMdsl3802); 

                	newLeafNode(otherlv_3, grammarAccess.getUITabMdslAccess().getIdKeyword_3());
                
            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:1788:1: ( (lv_name_4_0= RULE_ID ) )
            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:1789:1: (lv_name_4_0= RULE_ID )
            {
            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:1789:1: (lv_name_4_0= RULE_ID )
            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:1790:3: lv_name_4_0= RULE_ID
            {
            lv_name_4_0=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleUITabMdsl3819); 

            			newLeafNode(lv_name_4_0, grammarAccess.getUITabMdslAccess().getNameIDTerminalRuleCall_4_0()); 
            		

            	        if (current==null) {
            	            current = createModelElement(grammarAccess.getUITabMdslRule());
            	        }
                   		setWithLastConsumed(
                   			current, 
                   			"name",
                    		lv_name_4_0, 
                    		"ID");
            	    

            }


            }

            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:1806:2: ( (lv_i18NLabel_5_0= 'I18N' ) )?
            int alt24=2;
            int LA24_0 = input.LA(1);

            if ( (LA24_0==52) ) {
                alt24=1;
            }
            switch (alt24) {
                case 1 :
                    // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:1807:1: (lv_i18NLabel_5_0= 'I18N' )
                    {
                    // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:1807:1: (lv_i18NLabel_5_0= 'I18N' )
                    // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:1808:3: lv_i18NLabel_5_0= 'I18N'
                    {
                    lv_i18NLabel_5_0=(Token)match(input,52,FOLLOW_52_in_ruleUITabMdsl3842); 

                            newLeafNode(lv_i18NLabel_5_0, grammarAccess.getUITabMdslAccess().getI18NLabelI18NKeyword_5_0());
                        

                    	        if (current==null) {
                    	            current = createModelElement(grammarAccess.getUITabMdslRule());
                    	        }
                           		setWithLastConsumed(current, "i18NLabel", true, "I18N");
                    	    

                    }


                    }
                    break;

            }

            otherlv_6=(Token)match(input,13,FOLLOW_13_in_ruleUITabMdsl3868); 

                	newLeafNode(otherlv_6, grammarAccess.getUITabMdslAccess().getLabelKeyword_6());
                
            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:1825:1: ( (lv_labelFormatExpr_7_0= ruleFormatExpr ) )
            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:1826:1: (lv_labelFormatExpr_7_0= ruleFormatExpr )
            {
            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:1826:1: (lv_labelFormatExpr_7_0= ruleFormatExpr )
            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:1827:3: lv_labelFormatExpr_7_0= ruleFormatExpr
            {
             
            	        newCompositeNode(grammarAccess.getUITabMdslAccess().getLabelFormatExprFormatExprParserRuleCall_7_0()); 
            	    
            pushFollow(FOLLOW_ruleFormatExpr_in_ruleUITabMdsl3889);
            lv_labelFormatExpr_7_0=ruleFormatExpr();

            state._fsp--;


            	        if (current==null) {
            	            current = createModelElementForParent(grammarAccess.getUITabMdslRule());
            	        }
                   		set(
                   			current, 
                   			"labelFormatExpr",
                    		lv_labelFormatExpr_7_0, 
                    		"FormatExpr");
            	        afterParserOrEnumRuleCall();
            	    

            }


            }

            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:1843:2: (otherlv_8= 'description:' ( (lv_description_9_0= RULE_STRING ) ) )?
            int alt25=2;
            int LA25_0 = input.LA(1);

            if ( (LA25_0==17) ) {
                alt25=1;
            }
            switch (alt25) {
                case 1 :
                    // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:1843:4: otherlv_8= 'description:' ( (lv_description_9_0= RULE_STRING ) )
                    {
                    otherlv_8=(Token)match(input,17,FOLLOW_17_in_ruleUITabMdsl3902); 

                        	newLeafNode(otherlv_8, grammarAccess.getUITabMdslAccess().getDescriptionKeyword_8_0());
                        
                    // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:1847:1: ( (lv_description_9_0= RULE_STRING ) )
                    // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:1848:1: (lv_description_9_0= RULE_STRING )
                    {
                    // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:1848:1: (lv_description_9_0= RULE_STRING )
                    // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:1849:3: lv_description_9_0= RULE_STRING
                    {
                    lv_description_9_0=(Token)match(input,RULE_STRING,FOLLOW_RULE_STRING_in_ruleUITabMdsl3919); 

                    			newLeafNode(lv_description_9_0, grammarAccess.getUITabMdslAccess().getDescriptionSTRINGTerminalRuleCall_8_1_0()); 
                    		

                    	        if (current==null) {
                    	            current = createModelElement(grammarAccess.getUITabMdslRule());
                    	        }
                           		setWithLastConsumed(
                           			current, 
                           			"description",
                            		lv_description_9_0, 
                            		"STRING");
                    	    

                    }


                    }


                    }
                    break;

            }

            otherlv_10=(Token)match(input,28,FOLLOW_28_in_ruleUITabMdsl3938); 

                	newLeafNode(otherlv_10, grammarAccess.getUITabMdslAccess().getRightCurlyBracketKeyword_9());
                

            }


            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleUITabMdsl"


    // $ANTLR start "entryRuleLayerMdsl"
    // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:1877:1: entryRuleLayerMdsl returns [EObject current=null] : iv_ruleLayerMdsl= ruleLayerMdsl EOF ;
    public final EObject entryRuleLayerMdsl() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleLayerMdsl = null;


        try {
            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:1878:2: (iv_ruleLayerMdsl= ruleLayerMdsl EOF )
            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:1879:2: iv_ruleLayerMdsl= ruleLayerMdsl EOF
            {
             newCompositeNode(grammarAccess.getLayerMdslRule()); 
            pushFollow(FOLLOW_ruleLayerMdsl_in_entryRuleLayerMdsl3974);
            iv_ruleLayerMdsl=ruleLayerMdsl();

            state._fsp--;

             current =iv_ruleLayerMdsl; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleLayerMdsl3984); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleLayerMdsl"


    // $ANTLR start "ruleLayerMdsl"
    // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:1886:1: ruleLayerMdsl returns [EObject current=null] : (otherlv_0= 'Layer' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' ( (lv_i18NLabel_3_0= 'I18N' ) )? otherlv_4= 'label:' ( (lv_labelFormatExpr_5_0= ruleFormatExpr ) ) (otherlv_6= 'description:' ( (lv_description_7_0= RULE_STRING ) ) )? (otherlv_8= 'Sub' otherlv_9= 'layers' otherlv_10= '{' ( (lv_subLayers_11_0= ruleLayerMdsl ) )* otherlv_12= '}' )? otherlv_13= '}' ) ;
    public final EObject ruleLayerMdsl() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token lv_name_1_0=null;
        Token otherlv_2=null;
        Token lv_i18NLabel_3_0=null;
        Token otherlv_4=null;
        Token otherlv_6=null;
        Token lv_description_7_0=null;
        Token otherlv_8=null;
        Token otherlv_9=null;
        Token otherlv_10=null;
        Token otherlv_12=null;
        Token otherlv_13=null;
        EObject lv_labelFormatExpr_5_0 = null;

        EObject lv_subLayers_11_0 = null;


         enterRule(); 
            
        try {
            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:1889:28: ( (otherlv_0= 'Layer' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' ( (lv_i18NLabel_3_0= 'I18N' ) )? otherlv_4= 'label:' ( (lv_labelFormatExpr_5_0= ruleFormatExpr ) ) (otherlv_6= 'description:' ( (lv_description_7_0= RULE_STRING ) ) )? (otherlv_8= 'Sub' otherlv_9= 'layers' otherlv_10= '{' ( (lv_subLayers_11_0= ruleLayerMdsl ) )* otherlv_12= '}' )? otherlv_13= '}' ) )
            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:1890:1: (otherlv_0= 'Layer' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' ( (lv_i18NLabel_3_0= 'I18N' ) )? otherlv_4= 'label:' ( (lv_labelFormatExpr_5_0= ruleFormatExpr ) ) (otherlv_6= 'description:' ( (lv_description_7_0= RULE_STRING ) ) )? (otherlv_8= 'Sub' otherlv_9= 'layers' otherlv_10= '{' ( (lv_subLayers_11_0= ruleLayerMdsl ) )* otherlv_12= '}' )? otherlv_13= '}' )
            {
            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:1890:1: (otherlv_0= 'Layer' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' ( (lv_i18NLabel_3_0= 'I18N' ) )? otherlv_4= 'label:' ( (lv_labelFormatExpr_5_0= ruleFormatExpr ) ) (otherlv_6= 'description:' ( (lv_description_7_0= RULE_STRING ) ) )? (otherlv_8= 'Sub' otherlv_9= 'layers' otherlv_10= '{' ( (lv_subLayers_11_0= ruleLayerMdsl ) )* otherlv_12= '}' )? otherlv_13= '}' )
            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:1890:3: otherlv_0= 'Layer' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' ( (lv_i18NLabel_3_0= 'I18N' ) )? otherlv_4= 'label:' ( (lv_labelFormatExpr_5_0= ruleFormatExpr ) ) (otherlv_6= 'description:' ( (lv_description_7_0= RULE_STRING ) ) )? (otherlv_8= 'Sub' otherlv_9= 'layers' otherlv_10= '{' ( (lv_subLayers_11_0= ruleLayerMdsl ) )* otherlv_12= '}' )? otherlv_13= '}'
            {
            otherlv_0=(Token)match(input,53,FOLLOW_53_in_ruleLayerMdsl4021); 

                	newLeafNode(otherlv_0, grammarAccess.getLayerMdslAccess().getLayerKeyword_0());
                
            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:1894:1: ( (lv_name_1_0= RULE_ID ) )
            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:1895:1: (lv_name_1_0= RULE_ID )
            {
            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:1895:1: (lv_name_1_0= RULE_ID )
            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:1896:3: lv_name_1_0= RULE_ID
            {
            lv_name_1_0=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleLayerMdsl4038); 

            			newLeafNode(lv_name_1_0, grammarAccess.getLayerMdslAccess().getNameIDTerminalRuleCall_1_0()); 
            		

            	        if (current==null) {
            	            current = createModelElement(grammarAccess.getLayerMdslRule());
            	        }
                   		setWithLastConsumed(
                   			current, 
                   			"name",
                    		lv_name_1_0, 
                    		"ID");
            	    

            }


            }

            otherlv_2=(Token)match(input,22,FOLLOW_22_in_ruleLayerMdsl4055); 

                	newLeafNode(otherlv_2, grammarAccess.getLayerMdslAccess().getLeftCurlyBracketKeyword_2());
                
            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:1916:1: ( (lv_i18NLabel_3_0= 'I18N' ) )?
            int alt26=2;
            int LA26_0 = input.LA(1);

            if ( (LA26_0==52) ) {
                alt26=1;
            }
            switch (alt26) {
                case 1 :
                    // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:1917:1: (lv_i18NLabel_3_0= 'I18N' )
                    {
                    // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:1917:1: (lv_i18NLabel_3_0= 'I18N' )
                    // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:1918:3: lv_i18NLabel_3_0= 'I18N'
                    {
                    lv_i18NLabel_3_0=(Token)match(input,52,FOLLOW_52_in_ruleLayerMdsl4073); 

                            newLeafNode(lv_i18NLabel_3_0, grammarAccess.getLayerMdslAccess().getI18NLabelI18NKeyword_3_0());
                        

                    	        if (current==null) {
                    	            current = createModelElement(grammarAccess.getLayerMdslRule());
                    	        }
                           		setWithLastConsumed(current, "i18NLabel", true, "I18N");
                    	    

                    }


                    }
                    break;

            }

            otherlv_4=(Token)match(input,13,FOLLOW_13_in_ruleLayerMdsl4099); 

                	newLeafNode(otherlv_4, grammarAccess.getLayerMdslAccess().getLabelKeyword_4());
                
            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:1935:1: ( (lv_labelFormatExpr_5_0= ruleFormatExpr ) )
            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:1936:1: (lv_labelFormatExpr_5_0= ruleFormatExpr )
            {
            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:1936:1: (lv_labelFormatExpr_5_0= ruleFormatExpr )
            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:1937:3: lv_labelFormatExpr_5_0= ruleFormatExpr
            {
             
            	        newCompositeNode(grammarAccess.getLayerMdslAccess().getLabelFormatExprFormatExprParserRuleCall_5_0()); 
            	    
            pushFollow(FOLLOW_ruleFormatExpr_in_ruleLayerMdsl4120);
            lv_labelFormatExpr_5_0=ruleFormatExpr();

            state._fsp--;


            	        if (current==null) {
            	            current = createModelElementForParent(grammarAccess.getLayerMdslRule());
            	        }
                   		set(
                   			current, 
                   			"labelFormatExpr",
                    		lv_labelFormatExpr_5_0, 
                    		"FormatExpr");
            	        afterParserOrEnumRuleCall();
            	    

            }


            }

            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:1953:2: (otherlv_6= 'description:' ( (lv_description_7_0= RULE_STRING ) ) )?
            int alt27=2;
            int LA27_0 = input.LA(1);

            if ( (LA27_0==17) ) {
                alt27=1;
            }
            switch (alt27) {
                case 1 :
                    // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:1953:4: otherlv_6= 'description:' ( (lv_description_7_0= RULE_STRING ) )
                    {
                    otherlv_6=(Token)match(input,17,FOLLOW_17_in_ruleLayerMdsl4133); 

                        	newLeafNode(otherlv_6, grammarAccess.getLayerMdslAccess().getDescriptionKeyword_6_0());
                        
                    // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:1957:1: ( (lv_description_7_0= RULE_STRING ) )
                    // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:1958:1: (lv_description_7_0= RULE_STRING )
                    {
                    // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:1958:1: (lv_description_7_0= RULE_STRING )
                    // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:1959:3: lv_description_7_0= RULE_STRING
                    {
                    lv_description_7_0=(Token)match(input,RULE_STRING,FOLLOW_RULE_STRING_in_ruleLayerMdsl4150); 

                    			newLeafNode(lv_description_7_0, grammarAccess.getLayerMdslAccess().getDescriptionSTRINGTerminalRuleCall_6_1_0()); 
                    		

                    	        if (current==null) {
                    	            current = createModelElement(grammarAccess.getLayerMdslRule());
                    	        }
                           		setWithLastConsumed(
                           			current, 
                           			"description",
                            		lv_description_7_0, 
                            		"STRING");
                    	    

                    }


                    }


                    }
                    break;

            }

            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:1975:4: (otherlv_8= 'Sub' otherlv_9= 'layers' otherlv_10= '{' ( (lv_subLayers_11_0= ruleLayerMdsl ) )* otherlv_12= '}' )?
            int alt29=2;
            int LA29_0 = input.LA(1);

            if ( (LA29_0==54) ) {
                alt29=1;
            }
            switch (alt29) {
                case 1 :
                    // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:1975:6: otherlv_8= 'Sub' otherlv_9= 'layers' otherlv_10= '{' ( (lv_subLayers_11_0= ruleLayerMdsl ) )* otherlv_12= '}'
                    {
                    otherlv_8=(Token)match(input,54,FOLLOW_54_in_ruleLayerMdsl4170); 

                        	newLeafNode(otherlv_8, grammarAccess.getLayerMdslAccess().getSubKeyword_7_0());
                        
                    otherlv_9=(Token)match(input,55,FOLLOW_55_in_ruleLayerMdsl4182); 

                        	newLeafNode(otherlv_9, grammarAccess.getLayerMdslAccess().getLayersKeyword_7_1());
                        
                    otherlv_10=(Token)match(input,22,FOLLOW_22_in_ruleLayerMdsl4194); 

                        	newLeafNode(otherlv_10, grammarAccess.getLayerMdslAccess().getLeftCurlyBracketKeyword_7_2());
                        
                    // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:1987:1: ( (lv_subLayers_11_0= ruleLayerMdsl ) )*
                    loop28:
                    do {
                        int alt28=2;
                        int LA28_0 = input.LA(1);

                        if ( (LA28_0==53) ) {
                            alt28=1;
                        }


                        switch (alt28) {
                    	case 1 :
                    	    // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:1988:1: (lv_subLayers_11_0= ruleLayerMdsl )
                    	    {
                    	    // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:1988:1: (lv_subLayers_11_0= ruleLayerMdsl )
                    	    // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:1989:3: lv_subLayers_11_0= ruleLayerMdsl
                    	    {
                    	     
                    	    	        newCompositeNode(grammarAccess.getLayerMdslAccess().getSubLayersLayerMdslParserRuleCall_7_3_0()); 
                    	    	    
                    	    pushFollow(FOLLOW_ruleLayerMdsl_in_ruleLayerMdsl4215);
                    	    lv_subLayers_11_0=ruleLayerMdsl();

                    	    state._fsp--;


                    	    	        if (current==null) {
                    	    	            current = createModelElementForParent(grammarAccess.getLayerMdslRule());
                    	    	        }
                    	           		add(
                    	           			current, 
                    	           			"subLayers",
                    	            		lv_subLayers_11_0, 
                    	            		"LayerMdsl");
                    	    	        afterParserOrEnumRuleCall();
                    	    	    

                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop28;
                        }
                    } while (true);

                    otherlv_12=(Token)match(input,28,FOLLOW_28_in_ruleLayerMdsl4228); 

                        	newLeafNode(otherlv_12, grammarAccess.getLayerMdslAccess().getRightCurlyBracketKeyword_7_4());
                        

                    }
                    break;

            }

            otherlv_13=(Token)match(input,28,FOLLOW_28_in_ruleLayerMdsl4242); 

                	newLeafNode(otherlv_13, grammarAccess.getLayerMdslAccess().getRightCurlyBracketKeyword_8());
                

            }


            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleLayerMdsl"


    // $ANTLR start "entryRuleTypeConfigurationMdsl"
    // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:2021:1: entryRuleTypeConfigurationMdsl returns [EObject current=null] : iv_ruleTypeConfigurationMdsl= ruleTypeConfigurationMdsl EOF ;
    public final EObject entryRuleTypeConfigurationMdsl() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleTypeConfigurationMdsl = null;


        try {
            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:2022:2: (iv_ruleTypeConfigurationMdsl= ruleTypeConfigurationMdsl EOF )
            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:2023:2: iv_ruleTypeConfigurationMdsl= ruleTypeConfigurationMdsl EOF
            {
             newCompositeNode(grammarAccess.getTypeConfigurationMdslRule()); 
            pushFollow(FOLLOW_ruleTypeConfigurationMdsl_in_entryRuleTypeConfigurationMdsl4278);
            iv_ruleTypeConfigurationMdsl=ruleTypeConfigurationMdsl();

            state._fsp--;

             current =iv_ruleTypeConfigurationMdsl; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleTypeConfigurationMdsl4288); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleTypeConfigurationMdsl"


    // $ANTLR start "ruleTypeConfigurationMdsl"
    // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:2030:1: ruleTypeConfigurationMdsl returns [EObject current=null] : ( ( (lv_defaultConfiguration_0_0= 'DEFAULT' ) )? otherlv_1= 'Configuration' ( (lv_name_2_0= RULE_ID ) ) (otherlv_3= 'for' ( (otherlv_4= RULE_ID ) ) )? otherlv_5= '{' ( ( (lv_i18NLabelProvider_6_0= 'I18N' ) )? otherlv_7= 'label provider:' ( (lv_labelProviderExpression_8_0= ruleFormatExpr ) ) )? ( ( (lv_useExplicitExtends_9_0= 'extends:' ) ) ( (otherlv_10= RULE_ID ) ) (otherlv_11= ',' ( (otherlv_12= RULE_ID ) ) )* )? otherlv_13= 'template:' ( (lv_templateElements_14_0= ruleTypeConfigurationTemplateElement ) )* ( ( (lv_layoutDefined_15_0= 'layout:' ) ) ( (otherlv_16= RULE_ID ) )* )? otherlv_17= '}' ) ;
    public final EObject ruleTypeConfigurationMdsl() throws RecognitionException {
        EObject current = null;

        Token lv_defaultConfiguration_0_0=null;
        Token otherlv_1=null;
        Token lv_name_2_0=null;
        Token otherlv_3=null;
        Token otherlv_4=null;
        Token otherlv_5=null;
        Token lv_i18NLabelProvider_6_0=null;
        Token otherlv_7=null;
        Token lv_useExplicitExtends_9_0=null;
        Token otherlv_10=null;
        Token otherlv_11=null;
        Token otherlv_12=null;
        Token otherlv_13=null;
        Token lv_layoutDefined_15_0=null;
        Token otherlv_16=null;
        Token otherlv_17=null;
        EObject lv_labelProviderExpression_8_0 = null;

        EObject lv_templateElements_14_0 = null;


         enterRule(); 
            
        try {
            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:2033:28: ( ( ( (lv_defaultConfiguration_0_0= 'DEFAULT' ) )? otherlv_1= 'Configuration' ( (lv_name_2_0= RULE_ID ) ) (otherlv_3= 'for' ( (otherlv_4= RULE_ID ) ) )? otherlv_5= '{' ( ( (lv_i18NLabelProvider_6_0= 'I18N' ) )? otherlv_7= 'label provider:' ( (lv_labelProviderExpression_8_0= ruleFormatExpr ) ) )? ( ( (lv_useExplicitExtends_9_0= 'extends:' ) ) ( (otherlv_10= RULE_ID ) ) (otherlv_11= ',' ( (otherlv_12= RULE_ID ) ) )* )? otherlv_13= 'template:' ( (lv_templateElements_14_0= ruleTypeConfigurationTemplateElement ) )* ( ( (lv_layoutDefined_15_0= 'layout:' ) ) ( (otherlv_16= RULE_ID ) )* )? otherlv_17= '}' ) )
            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:2034:1: ( ( (lv_defaultConfiguration_0_0= 'DEFAULT' ) )? otherlv_1= 'Configuration' ( (lv_name_2_0= RULE_ID ) ) (otherlv_3= 'for' ( (otherlv_4= RULE_ID ) ) )? otherlv_5= '{' ( ( (lv_i18NLabelProvider_6_0= 'I18N' ) )? otherlv_7= 'label provider:' ( (lv_labelProviderExpression_8_0= ruleFormatExpr ) ) )? ( ( (lv_useExplicitExtends_9_0= 'extends:' ) ) ( (otherlv_10= RULE_ID ) ) (otherlv_11= ',' ( (otherlv_12= RULE_ID ) ) )* )? otherlv_13= 'template:' ( (lv_templateElements_14_0= ruleTypeConfigurationTemplateElement ) )* ( ( (lv_layoutDefined_15_0= 'layout:' ) ) ( (otherlv_16= RULE_ID ) )* )? otherlv_17= '}' )
            {
            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:2034:1: ( ( (lv_defaultConfiguration_0_0= 'DEFAULT' ) )? otherlv_1= 'Configuration' ( (lv_name_2_0= RULE_ID ) ) (otherlv_3= 'for' ( (otherlv_4= RULE_ID ) ) )? otherlv_5= '{' ( ( (lv_i18NLabelProvider_6_0= 'I18N' ) )? otherlv_7= 'label provider:' ( (lv_labelProviderExpression_8_0= ruleFormatExpr ) ) )? ( ( (lv_useExplicitExtends_9_0= 'extends:' ) ) ( (otherlv_10= RULE_ID ) ) (otherlv_11= ',' ( (otherlv_12= RULE_ID ) ) )* )? otherlv_13= 'template:' ( (lv_templateElements_14_0= ruleTypeConfigurationTemplateElement ) )* ( ( (lv_layoutDefined_15_0= 'layout:' ) ) ( (otherlv_16= RULE_ID ) )* )? otherlv_17= '}' )
            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:2034:2: ( (lv_defaultConfiguration_0_0= 'DEFAULT' ) )? otherlv_1= 'Configuration' ( (lv_name_2_0= RULE_ID ) ) (otherlv_3= 'for' ( (otherlv_4= RULE_ID ) ) )? otherlv_5= '{' ( ( (lv_i18NLabelProvider_6_0= 'I18N' ) )? otherlv_7= 'label provider:' ( (lv_labelProviderExpression_8_0= ruleFormatExpr ) ) )? ( ( (lv_useExplicitExtends_9_0= 'extends:' ) ) ( (otherlv_10= RULE_ID ) ) (otherlv_11= ',' ( (otherlv_12= RULE_ID ) ) )* )? otherlv_13= 'template:' ( (lv_templateElements_14_0= ruleTypeConfigurationTemplateElement ) )* ( ( (lv_layoutDefined_15_0= 'layout:' ) ) ( (otherlv_16= RULE_ID ) )* )? otherlv_17= '}'
            {
            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:2034:2: ( (lv_defaultConfiguration_0_0= 'DEFAULT' ) )?
            int alt30=2;
            int LA30_0 = input.LA(1);

            if ( (LA30_0==56) ) {
                alt30=1;
            }
            switch (alt30) {
                case 1 :
                    // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:2035:1: (lv_defaultConfiguration_0_0= 'DEFAULT' )
                    {
                    // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:2035:1: (lv_defaultConfiguration_0_0= 'DEFAULT' )
                    // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:2036:3: lv_defaultConfiguration_0_0= 'DEFAULT'
                    {
                    lv_defaultConfiguration_0_0=(Token)match(input,56,FOLLOW_56_in_ruleTypeConfigurationMdsl4331); 

                            newLeafNode(lv_defaultConfiguration_0_0, grammarAccess.getTypeConfigurationMdslAccess().getDefaultConfigurationDEFAULTKeyword_0_0());
                        

                    	        if (current==null) {
                    	            current = createModelElement(grammarAccess.getTypeConfigurationMdslRule());
                    	        }
                           		setWithLastConsumed(current, "defaultConfiguration", true, "DEFAULT");
                    	    

                    }


                    }
                    break;

            }

            otherlv_1=(Token)match(input,57,FOLLOW_57_in_ruleTypeConfigurationMdsl4357); 

                	newLeafNode(otherlv_1, grammarAccess.getTypeConfigurationMdslAccess().getConfigurationKeyword_1());
                
            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:2053:1: ( (lv_name_2_0= RULE_ID ) )
            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:2054:1: (lv_name_2_0= RULE_ID )
            {
            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:2054:1: (lv_name_2_0= RULE_ID )
            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:2055:3: lv_name_2_0= RULE_ID
            {
            lv_name_2_0=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleTypeConfigurationMdsl4374); 

            			newLeafNode(lv_name_2_0, grammarAccess.getTypeConfigurationMdslAccess().getNameIDTerminalRuleCall_2_0()); 
            		

            	        if (current==null) {
            	            current = createModelElement(grammarAccess.getTypeConfigurationMdslRule());
            	        }
                   		setWithLastConsumed(
                   			current, 
                   			"name",
                    		lv_name_2_0, 
                    		"ID");
            	    

            }


            }

            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:2071:2: (otherlv_3= 'for' ( (otherlv_4= RULE_ID ) ) )?
            int alt31=2;
            int LA31_0 = input.LA(1);

            if ( (LA31_0==58) ) {
                alt31=1;
            }
            switch (alt31) {
                case 1 :
                    // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:2071:4: otherlv_3= 'for' ( (otherlv_4= RULE_ID ) )
                    {
                    otherlv_3=(Token)match(input,58,FOLLOW_58_in_ruleTypeConfigurationMdsl4392); 

                        	newLeafNode(otherlv_3, grammarAccess.getTypeConfigurationMdslAccess().getForKeyword_3_0());
                        
                    // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:2075:1: ( (otherlv_4= RULE_ID ) )
                    // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:2076:1: (otherlv_4= RULE_ID )
                    {
                    // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:2076:1: (otherlv_4= RULE_ID )
                    // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:2077:3: otherlv_4= RULE_ID
                    {

                    			if (current==null) {
                    	            current = createModelElement(grammarAccess.getTypeConfigurationMdslRule());
                    	        }
                            
                    otherlv_4=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleTypeConfigurationMdsl4412); 

                    		newLeafNode(otherlv_4, grammarAccess.getTypeConfigurationMdslAccess().getTypeEClassCrossReference_3_1_0()); 
                    	

                    }


                    }


                    }
                    break;

            }

            otherlv_5=(Token)match(input,22,FOLLOW_22_in_ruleTypeConfigurationMdsl4426); 

                	newLeafNode(otherlv_5, grammarAccess.getTypeConfigurationMdslAccess().getLeftCurlyBracketKeyword_4());
                
            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:2092:1: ( ( (lv_i18NLabelProvider_6_0= 'I18N' ) )? otherlv_7= 'label provider:' ( (lv_labelProviderExpression_8_0= ruleFormatExpr ) ) )?
            int alt33=2;
            int LA33_0 = input.LA(1);

            if ( (LA33_0==52||LA33_0==59) ) {
                alt33=1;
            }
            switch (alt33) {
                case 1 :
                    // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:2092:2: ( (lv_i18NLabelProvider_6_0= 'I18N' ) )? otherlv_7= 'label provider:' ( (lv_labelProviderExpression_8_0= ruleFormatExpr ) )
                    {
                    // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:2092:2: ( (lv_i18NLabelProvider_6_0= 'I18N' ) )?
                    int alt32=2;
                    int LA32_0 = input.LA(1);

                    if ( (LA32_0==52) ) {
                        alt32=1;
                    }
                    switch (alt32) {
                        case 1 :
                            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:2093:1: (lv_i18NLabelProvider_6_0= 'I18N' )
                            {
                            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:2093:1: (lv_i18NLabelProvider_6_0= 'I18N' )
                            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:2094:3: lv_i18NLabelProvider_6_0= 'I18N'
                            {
                            lv_i18NLabelProvider_6_0=(Token)match(input,52,FOLLOW_52_in_ruleTypeConfigurationMdsl4445); 

                                    newLeafNode(lv_i18NLabelProvider_6_0, grammarAccess.getTypeConfigurationMdslAccess().getI18NLabelProviderI18NKeyword_5_0_0());
                                

                            	        if (current==null) {
                            	            current = createModelElement(grammarAccess.getTypeConfigurationMdslRule());
                            	        }
                                   		setWithLastConsumed(current, "i18NLabelProvider", true, "I18N");
                            	    

                            }


                            }
                            break;

                    }

                    otherlv_7=(Token)match(input,59,FOLLOW_59_in_ruleTypeConfigurationMdsl4471); 

                        	newLeafNode(otherlv_7, grammarAccess.getTypeConfigurationMdslAccess().getLabelProviderKeyword_5_1());
                        
                    // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:2111:1: ( (lv_labelProviderExpression_8_0= ruleFormatExpr ) )
                    // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:2112:1: (lv_labelProviderExpression_8_0= ruleFormatExpr )
                    {
                    // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:2112:1: (lv_labelProviderExpression_8_0= ruleFormatExpr )
                    // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:2113:3: lv_labelProviderExpression_8_0= ruleFormatExpr
                    {
                     
                    	        newCompositeNode(grammarAccess.getTypeConfigurationMdslAccess().getLabelProviderExpressionFormatExprParserRuleCall_5_2_0()); 
                    	    
                    pushFollow(FOLLOW_ruleFormatExpr_in_ruleTypeConfigurationMdsl4492);
                    lv_labelProviderExpression_8_0=ruleFormatExpr();

                    state._fsp--;


                    	        if (current==null) {
                    	            current = createModelElementForParent(grammarAccess.getTypeConfigurationMdslRule());
                    	        }
                           		set(
                           			current, 
                           			"labelProviderExpression",
                            		lv_labelProviderExpression_8_0, 
                            		"FormatExpr");
                    	        afterParserOrEnumRuleCall();
                    	    

                    }


                    }


                    }
                    break;

            }

            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:2129:4: ( ( (lv_useExplicitExtends_9_0= 'extends:' ) ) ( (otherlv_10= RULE_ID ) ) (otherlv_11= ',' ( (otherlv_12= RULE_ID ) ) )* )?
            int alt35=2;
            int LA35_0 = input.LA(1);

            if ( (LA35_0==60) ) {
                alt35=1;
            }
            switch (alt35) {
                case 1 :
                    // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:2129:5: ( (lv_useExplicitExtends_9_0= 'extends:' ) ) ( (otherlv_10= RULE_ID ) ) (otherlv_11= ',' ( (otherlv_12= RULE_ID ) ) )*
                    {
                    // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:2129:5: ( (lv_useExplicitExtends_9_0= 'extends:' ) )
                    // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:2130:1: (lv_useExplicitExtends_9_0= 'extends:' )
                    {
                    // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:2130:1: (lv_useExplicitExtends_9_0= 'extends:' )
                    // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:2131:3: lv_useExplicitExtends_9_0= 'extends:'
                    {
                    lv_useExplicitExtends_9_0=(Token)match(input,60,FOLLOW_60_in_ruleTypeConfigurationMdsl4513); 

                            newLeafNode(lv_useExplicitExtends_9_0, grammarAccess.getTypeConfigurationMdslAccess().getUseExplicitExtendsExtendsKeyword_6_0_0());
                        

                    	        if (current==null) {
                    	            current = createModelElement(grammarAccess.getTypeConfigurationMdslRule());
                    	        }
                           		setWithLastConsumed(current, "useExplicitExtends", true, "extends:");
                    	    

                    }


                    }

                    // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:2144:2: ( (otherlv_10= RULE_ID ) )
                    // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:2145:1: (otherlv_10= RULE_ID )
                    {
                    // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:2145:1: (otherlv_10= RULE_ID )
                    // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:2146:3: otherlv_10= RULE_ID
                    {

                    			if (current==null) {
                    	            current = createModelElement(grammarAccess.getTypeConfigurationMdslRule());
                    	        }
                            
                    otherlv_10=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleTypeConfigurationMdsl4546); 

                    		newLeafNode(otherlv_10, grammarAccess.getTypeConfigurationMdslAccess().getSuperConfigurationsTypeConfigurationMdslCrossReference_6_1_0()); 
                    	

                    }


                    }

                    // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:2157:2: (otherlv_11= ',' ( (otherlv_12= RULE_ID ) ) )*
                    loop34:
                    do {
                        int alt34=2;
                        int LA34_0 = input.LA(1);

                        if ( (LA34_0==33) ) {
                            alt34=1;
                        }


                        switch (alt34) {
                    	case 1 :
                    	    // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:2157:4: otherlv_11= ',' ( (otherlv_12= RULE_ID ) )
                    	    {
                    	    otherlv_11=(Token)match(input,33,FOLLOW_33_in_ruleTypeConfigurationMdsl4559); 

                    	        	newLeafNode(otherlv_11, grammarAccess.getTypeConfigurationMdslAccess().getCommaKeyword_6_2_0());
                    	        
                    	    // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:2161:1: ( (otherlv_12= RULE_ID ) )
                    	    // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:2162:1: (otherlv_12= RULE_ID )
                    	    {
                    	    // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:2162:1: (otherlv_12= RULE_ID )
                    	    // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:2163:3: otherlv_12= RULE_ID
                    	    {

                    	    			if (current==null) {
                    	    	            current = createModelElement(grammarAccess.getTypeConfigurationMdslRule());
                    	    	        }
                    	            
                    	    otherlv_12=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleTypeConfigurationMdsl4579); 

                    	    		newLeafNode(otherlv_12, grammarAccess.getTypeConfigurationMdslAccess().getSuperConfigurationsTypeConfigurationMdslCrossReference_6_2_1_0()); 
                    	    	

                    	    }


                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop34;
                        }
                    } while (true);


                    }
                    break;

            }

            otherlv_13=(Token)match(input,61,FOLLOW_61_in_ruleTypeConfigurationMdsl4595); 

                	newLeafNode(otherlv_13, grammarAccess.getTypeConfigurationMdslAccess().getTemplateKeyword_7());
                
            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:2178:1: ( (lv_templateElements_14_0= ruleTypeConfigurationTemplateElement ) )*
            loop36:
            do {
                int alt36=2;
                int LA36_0 = input.LA(1);

                if ( (LA36_0==63||LA36_0==67) ) {
                    alt36=1;
                }


                switch (alt36) {
            	case 1 :
            	    // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:2179:1: (lv_templateElements_14_0= ruleTypeConfigurationTemplateElement )
            	    {
            	    // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:2179:1: (lv_templateElements_14_0= ruleTypeConfigurationTemplateElement )
            	    // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:2180:3: lv_templateElements_14_0= ruleTypeConfigurationTemplateElement
            	    {
            	     
            	    	        newCompositeNode(grammarAccess.getTypeConfigurationMdslAccess().getTemplateElementsTypeConfigurationTemplateElementParserRuleCall_8_0()); 
            	    	    
            	    pushFollow(FOLLOW_ruleTypeConfigurationTemplateElement_in_ruleTypeConfigurationMdsl4616);
            	    lv_templateElements_14_0=ruleTypeConfigurationTemplateElement();

            	    state._fsp--;


            	    	        if (current==null) {
            	    	            current = createModelElementForParent(grammarAccess.getTypeConfigurationMdslRule());
            	    	        }
            	           		add(
            	           			current, 
            	           			"templateElements",
            	            		lv_templateElements_14_0, 
            	            		"TypeConfigurationTemplateElement");
            	    	        afterParserOrEnumRuleCall();
            	    	    

            	    }


            	    }
            	    break;

            	default :
            	    break loop36;
                }
            } while (true);

            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:2196:3: ( ( (lv_layoutDefined_15_0= 'layout:' ) ) ( (otherlv_16= RULE_ID ) )* )?
            int alt38=2;
            int LA38_0 = input.LA(1);

            if ( (LA38_0==62) ) {
                alt38=1;
            }
            switch (alt38) {
                case 1 :
                    // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:2196:4: ( (lv_layoutDefined_15_0= 'layout:' ) ) ( (otherlv_16= RULE_ID ) )*
                    {
                    // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:2196:4: ( (lv_layoutDefined_15_0= 'layout:' ) )
                    // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:2197:1: (lv_layoutDefined_15_0= 'layout:' )
                    {
                    // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:2197:1: (lv_layoutDefined_15_0= 'layout:' )
                    // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:2198:3: lv_layoutDefined_15_0= 'layout:'
                    {
                    lv_layoutDefined_15_0=(Token)match(input,62,FOLLOW_62_in_ruleTypeConfigurationMdsl4636); 

                            newLeafNode(lv_layoutDefined_15_0, grammarAccess.getTypeConfigurationMdslAccess().getLayoutDefinedLayoutKeyword_9_0_0());
                        

                    	        if (current==null) {
                    	            current = createModelElement(grammarAccess.getTypeConfigurationMdslRule());
                    	        }
                           		setWithLastConsumed(current, "layoutDefined", true, "layout:");
                    	    

                    }


                    }

                    // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:2211:2: ( (otherlv_16= RULE_ID ) )*
                    loop37:
                    do {
                        int alt37=2;
                        int LA37_0 = input.LA(1);

                        if ( (LA37_0==RULE_ID) ) {
                            alt37=1;
                        }


                        switch (alt37) {
                    	case 1 :
                    	    // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:2212:1: (otherlv_16= RULE_ID )
                    	    {
                    	    // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:2212:1: (otherlv_16= RULE_ID )
                    	    // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:2213:3: otherlv_16= RULE_ID
                    	    {

                    	    			if (current==null) {
                    	    	            current = createModelElement(grammarAccess.getTypeConfigurationMdslRule());
                    	    	        }
                    	            
                    	    otherlv_16=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleTypeConfigurationMdsl4669); 

                    	    		newLeafNode(otherlv_16, grammarAccess.getTypeConfigurationMdslAccess().getLayoutElementsWidgetConfigurationMdslCrossReference_9_1_0()); 
                    	    	

                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop37;
                        }
                    } while (true);


                    }
                    break;

            }

            otherlv_17=(Token)match(input,28,FOLLOW_28_in_ruleTypeConfigurationMdsl4684); 

                	newLeafNode(otherlv_17, grammarAccess.getTypeConfigurationMdslAccess().getRightCurlyBracketKeyword_10());
                

            }


            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleTypeConfigurationMdsl"


    // $ANTLR start "entryRuleTypeConfigurationTemplateElement"
    // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:2236:1: entryRuleTypeConfigurationTemplateElement returns [EObject current=null] : iv_ruleTypeConfigurationTemplateElement= ruleTypeConfigurationTemplateElement EOF ;
    public final EObject entryRuleTypeConfigurationTemplateElement() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleTypeConfigurationTemplateElement = null;


        try {
            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:2237:2: (iv_ruleTypeConfigurationTemplateElement= ruleTypeConfigurationTemplateElement EOF )
            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:2238:2: iv_ruleTypeConfigurationTemplateElement= ruleTypeConfigurationTemplateElement EOF
            {
             newCompositeNode(grammarAccess.getTypeConfigurationTemplateElementRule()); 
            pushFollow(FOLLOW_ruleTypeConfigurationTemplateElement_in_entryRuleTypeConfigurationTemplateElement4720);
            iv_ruleTypeConfigurationTemplateElement=ruleTypeConfigurationTemplateElement();

            state._fsp--;

             current =iv_ruleTypeConfigurationTemplateElement; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleTypeConfigurationTemplateElement4730); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleTypeConfigurationTemplateElement"


    // $ANTLR start "ruleTypeConfigurationTemplateElement"
    // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:2245:1: ruleTypeConfigurationTemplateElement returns [EObject current=null] : (this_WidgetConfigurationMdsl_0= ruleWidgetConfigurationMdsl | this_IncludeTemplateElementMdsl_1= ruleIncludeTemplateElementMdsl ) ;
    public final EObject ruleTypeConfigurationTemplateElement() throws RecognitionException {
        EObject current = null;

        EObject this_WidgetConfigurationMdsl_0 = null;

        EObject this_IncludeTemplateElementMdsl_1 = null;


         enterRule(); 
            
        try {
            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:2248:28: ( (this_WidgetConfigurationMdsl_0= ruleWidgetConfigurationMdsl | this_IncludeTemplateElementMdsl_1= ruleIncludeTemplateElementMdsl ) )
            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:2249:1: (this_WidgetConfigurationMdsl_0= ruleWidgetConfigurationMdsl | this_IncludeTemplateElementMdsl_1= ruleIncludeTemplateElementMdsl )
            {
            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:2249:1: (this_WidgetConfigurationMdsl_0= ruleWidgetConfigurationMdsl | this_IncludeTemplateElementMdsl_1= ruleIncludeTemplateElementMdsl )
            int alt39=2;
            int LA39_0 = input.LA(1);

            if ( (LA39_0==67) ) {
                alt39=1;
            }
            else if ( (LA39_0==63) ) {
                alt39=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 39, 0, input);

                throw nvae;
            }
            switch (alt39) {
                case 1 :
                    // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:2250:5: this_WidgetConfigurationMdsl_0= ruleWidgetConfigurationMdsl
                    {
                     
                            newCompositeNode(grammarAccess.getTypeConfigurationTemplateElementAccess().getWidgetConfigurationMdslParserRuleCall_0()); 
                        
                    pushFollow(FOLLOW_ruleWidgetConfigurationMdsl_in_ruleTypeConfigurationTemplateElement4777);
                    this_WidgetConfigurationMdsl_0=ruleWidgetConfigurationMdsl();

                    state._fsp--;

                     
                            current = this_WidgetConfigurationMdsl_0; 
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;
                case 2 :
                    // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:2260:5: this_IncludeTemplateElementMdsl_1= ruleIncludeTemplateElementMdsl
                    {
                     
                            newCompositeNode(grammarAccess.getTypeConfigurationTemplateElementAccess().getIncludeTemplateElementMdslParserRuleCall_1()); 
                        
                    pushFollow(FOLLOW_ruleIncludeTemplateElementMdsl_in_ruleTypeConfigurationTemplateElement4804);
                    this_IncludeTemplateElementMdsl_1=ruleIncludeTemplateElementMdsl();

                    state._fsp--;

                     
                            current = this_IncludeTemplateElementMdsl_1; 
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;

            }


            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleTypeConfigurationTemplateElement"


    // $ANTLR start "entryRuleIncludeTemplateElementMdsl"
    // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:2276:1: entryRuleIncludeTemplateElementMdsl returns [EObject current=null] : iv_ruleIncludeTemplateElementMdsl= ruleIncludeTemplateElementMdsl EOF ;
    public final EObject entryRuleIncludeTemplateElementMdsl() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleIncludeTemplateElementMdsl = null;


        try {
            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:2277:2: (iv_ruleIncludeTemplateElementMdsl= ruleIncludeTemplateElementMdsl EOF )
            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:2278:2: iv_ruleIncludeTemplateElementMdsl= ruleIncludeTemplateElementMdsl EOF
            {
             newCompositeNode(grammarAccess.getIncludeTemplateElementMdslRule()); 
            pushFollow(FOLLOW_ruleIncludeTemplateElementMdsl_in_entryRuleIncludeTemplateElementMdsl4839);
            iv_ruleIncludeTemplateElementMdsl=ruleIncludeTemplateElementMdsl();

            state._fsp--;

             current =iv_ruleIncludeTemplateElementMdsl; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleIncludeTemplateElementMdsl4849); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleIncludeTemplateElementMdsl"


    // $ANTLR start "ruleIncludeTemplateElementMdsl"
    // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:2285:1: ruleIncludeTemplateElementMdsl returns [EObject current=null] : (otherlv_0= 'include widget:' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= 'source template:' ( (otherlv_3= RULE_ID ) ) otherlv_4= 'value:' ( (lv_valueQuery_5_0= ruleQueryUsage ) ) ) ;
    public final EObject ruleIncludeTemplateElementMdsl() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token lv_name_1_0=null;
        Token otherlv_2=null;
        Token otherlv_3=null;
        Token otherlv_4=null;
        EObject lv_valueQuery_5_0 = null;


         enterRule(); 
            
        try {
            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:2288:28: ( (otherlv_0= 'include widget:' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= 'source template:' ( (otherlv_3= RULE_ID ) ) otherlv_4= 'value:' ( (lv_valueQuery_5_0= ruleQueryUsage ) ) ) )
            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:2289:1: (otherlv_0= 'include widget:' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= 'source template:' ( (otherlv_3= RULE_ID ) ) otherlv_4= 'value:' ( (lv_valueQuery_5_0= ruleQueryUsage ) ) )
            {
            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:2289:1: (otherlv_0= 'include widget:' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= 'source template:' ( (otherlv_3= RULE_ID ) ) otherlv_4= 'value:' ( (lv_valueQuery_5_0= ruleQueryUsage ) ) )
            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:2289:3: otherlv_0= 'include widget:' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= 'source template:' ( (otherlv_3= RULE_ID ) ) otherlv_4= 'value:' ( (lv_valueQuery_5_0= ruleQueryUsage ) )
            {
            otherlv_0=(Token)match(input,63,FOLLOW_63_in_ruleIncludeTemplateElementMdsl4886); 

                	newLeafNode(otherlv_0, grammarAccess.getIncludeTemplateElementMdslAccess().getIncludeWidgetKeyword_0());
                
            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:2293:1: ( (lv_name_1_0= RULE_ID ) )
            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:2294:1: (lv_name_1_0= RULE_ID )
            {
            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:2294:1: (lv_name_1_0= RULE_ID )
            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:2295:3: lv_name_1_0= RULE_ID
            {
            lv_name_1_0=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleIncludeTemplateElementMdsl4903); 

            			newLeafNode(lv_name_1_0, grammarAccess.getIncludeTemplateElementMdslAccess().getNameIDTerminalRuleCall_1_0()); 
            		

            	        if (current==null) {
            	            current = createModelElement(grammarAccess.getIncludeTemplateElementMdslRule());
            	        }
                   		setWithLastConsumed(
                   			current, 
                   			"name",
                    		lv_name_1_0, 
                    		"ID");
            	    

            }


            }

            otherlv_2=(Token)match(input,64,FOLLOW_64_in_ruleIncludeTemplateElementMdsl4920); 

                	newLeafNode(otherlv_2, grammarAccess.getIncludeTemplateElementMdslAccess().getSourceTemplateKeyword_2());
                
            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:2315:1: ( (otherlv_3= RULE_ID ) )
            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:2316:1: (otherlv_3= RULE_ID )
            {
            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:2316:1: (otherlv_3= RULE_ID )
            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:2317:3: otherlv_3= RULE_ID
            {

            			if (current==null) {
            	            current = createModelElement(grammarAccess.getIncludeTemplateElementMdslRule());
            	        }
                    
            otherlv_3=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleIncludeTemplateElementMdsl4940); 

            		newLeafNode(otherlv_3, grammarAccess.getIncludeTemplateElementMdslAccess().getRefIncludedTemplateTypeConfigurationMdslCrossReference_3_0()); 
            	

            }


            }

            otherlv_4=(Token)match(input,65,FOLLOW_65_in_ruleIncludeTemplateElementMdsl4952); 

                	newLeafNode(otherlv_4, grammarAccess.getIncludeTemplateElementMdslAccess().getValueKeyword_4());
                
            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:2332:1: ( (lv_valueQuery_5_0= ruleQueryUsage ) )
            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:2333:1: (lv_valueQuery_5_0= ruleQueryUsage )
            {
            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:2333:1: (lv_valueQuery_5_0= ruleQueryUsage )
            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:2334:3: lv_valueQuery_5_0= ruleQueryUsage
            {
             
            	        newCompositeNode(grammarAccess.getIncludeTemplateElementMdslAccess().getValueQueryQueryUsageParserRuleCall_5_0()); 
            	    
            pushFollow(FOLLOW_ruleQueryUsage_in_ruleIncludeTemplateElementMdsl4973);
            lv_valueQuery_5_0=ruleQueryUsage();

            state._fsp--;


            	        if (current==null) {
            	            current = createModelElementForParent(grammarAccess.getIncludeTemplateElementMdslRule());
            	        }
                   		set(
                   			current, 
                   			"valueQuery",
                    		lv_valueQuery_5_0, 
                    		"QueryUsage");
            	        afterParserOrEnumRuleCall();
            	    

            }


            }


            }


            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleIncludeTemplateElementMdsl"


    // $ANTLR start "entryRuleValueConverter"
    // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:2358:1: entryRuleValueConverter returns [EObject current=null] : iv_ruleValueConverter= ruleValueConverter EOF ;
    public final EObject entryRuleValueConverter() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleValueConverter = null;


        try {
            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:2359:2: (iv_ruleValueConverter= ruleValueConverter EOF )
            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:2360:2: iv_ruleValueConverter= ruleValueConverter EOF
            {
             newCompositeNode(grammarAccess.getValueConverterRule()); 
            pushFollow(FOLLOW_ruleValueConverter_in_entryRuleValueConverter5009);
            iv_ruleValueConverter=ruleValueConverter();

            state._fsp--;

             current =iv_ruleValueConverter; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleValueConverter5019); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleValueConverter"


    // $ANTLR start "ruleValueConverter"
    // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:2367:1: ruleValueConverter returns [EObject current=null] : (this_BasicTypeValueConverter_0= ruleBasicTypeValueConverter | this_QueryBasedValueConverter_1= ruleQueryBasedValueConverter ) ;
    public final EObject ruleValueConverter() throws RecognitionException {
        EObject current = null;

        EObject this_BasicTypeValueConverter_0 = null;

        EObject this_QueryBasedValueConverter_1 = null;


         enterRule(); 
            
        try {
            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:2370:28: ( (this_BasicTypeValueConverter_0= ruleBasicTypeValueConverter | this_QueryBasedValueConverter_1= ruleQueryBasedValueConverter ) )
            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:2371:1: (this_BasicTypeValueConverter_0= ruleBasicTypeValueConverter | this_QueryBasedValueConverter_1= ruleQueryBasedValueConverter )
            {
            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:2371:1: (this_BasicTypeValueConverter_0= ruleBasicTypeValueConverter | this_QueryBasedValueConverter_1= ruleQueryBasedValueConverter )
            int alt40=2;
            int LA40_0 = input.LA(1);

            if ( ((LA40_0>=105 && LA40_0<=110)) ) {
                alt40=1;
            }
            else if ( (LA40_0==66) ) {
                alt40=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 40, 0, input);

                throw nvae;
            }
            switch (alt40) {
                case 1 :
                    // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:2372:5: this_BasicTypeValueConverter_0= ruleBasicTypeValueConverter
                    {
                     
                            newCompositeNode(grammarAccess.getValueConverterAccess().getBasicTypeValueConverterParserRuleCall_0()); 
                        
                    pushFollow(FOLLOW_ruleBasicTypeValueConverter_in_ruleValueConverter5066);
                    this_BasicTypeValueConverter_0=ruleBasicTypeValueConverter();

                    state._fsp--;

                     
                            current = this_BasicTypeValueConverter_0; 
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;
                case 2 :
                    // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:2382:5: this_QueryBasedValueConverter_1= ruleQueryBasedValueConverter
                    {
                     
                            newCompositeNode(grammarAccess.getValueConverterAccess().getQueryBasedValueConverterParserRuleCall_1()); 
                        
                    pushFollow(FOLLOW_ruleQueryBasedValueConverter_in_ruleValueConverter5093);
                    this_QueryBasedValueConverter_1=ruleQueryBasedValueConverter();

                    state._fsp--;

                     
                            current = this_QueryBasedValueConverter_1; 
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;

            }


            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleValueConverter"


    // $ANTLR start "entryRuleQueryBasedValueConverter"
    // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:2398:1: entryRuleQueryBasedValueConverter returns [EObject current=null] : iv_ruleQueryBasedValueConverter= ruleQueryBasedValueConverter EOF ;
    public final EObject entryRuleQueryBasedValueConverter() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleQueryBasedValueConverter = null;


        try {
            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:2399:2: (iv_ruleQueryBasedValueConverter= ruleQueryBasedValueConverter EOF )
            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:2400:2: iv_ruleQueryBasedValueConverter= ruleQueryBasedValueConverter EOF
            {
             newCompositeNode(grammarAccess.getQueryBasedValueConverterRule()); 
            pushFollow(FOLLOW_ruleQueryBasedValueConverter_in_entryRuleQueryBasedValueConverter5128);
            iv_ruleQueryBasedValueConverter=ruleQueryBasedValueConverter();

            state._fsp--;

             current =iv_ruleQueryBasedValueConverter; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleQueryBasedValueConverter5138); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleQueryBasedValueConverter"


    // $ANTLR start "ruleQueryBasedValueConverter"
    // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:2407:1: ruleQueryBasedValueConverter returns [EObject current=null] : (otherlv_0= 'Query' ( (lv_converterQuery_1_0= ruleQueryUsage ) ) ) ;
    public final EObject ruleQueryBasedValueConverter() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        EObject lv_converterQuery_1_0 = null;


         enterRule(); 
            
        try {
            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:2410:28: ( (otherlv_0= 'Query' ( (lv_converterQuery_1_0= ruleQueryUsage ) ) ) )
            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:2411:1: (otherlv_0= 'Query' ( (lv_converterQuery_1_0= ruleQueryUsage ) ) )
            {
            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:2411:1: (otherlv_0= 'Query' ( (lv_converterQuery_1_0= ruleQueryUsage ) ) )
            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:2411:3: otherlv_0= 'Query' ( (lv_converterQuery_1_0= ruleQueryUsage ) )
            {
            otherlv_0=(Token)match(input,66,FOLLOW_66_in_ruleQueryBasedValueConverter5175); 

                	newLeafNode(otherlv_0, grammarAccess.getQueryBasedValueConverterAccess().getQueryKeyword_0());
                
            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:2415:1: ( (lv_converterQuery_1_0= ruleQueryUsage ) )
            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:2416:1: (lv_converterQuery_1_0= ruleQueryUsage )
            {
            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:2416:1: (lv_converterQuery_1_0= ruleQueryUsage )
            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:2417:3: lv_converterQuery_1_0= ruleQueryUsage
            {
             
            	        newCompositeNode(grammarAccess.getQueryBasedValueConverterAccess().getConverterQueryQueryUsageParserRuleCall_1_0()); 
            	    
            pushFollow(FOLLOW_ruleQueryUsage_in_ruleQueryBasedValueConverter5196);
            lv_converterQuery_1_0=ruleQueryUsage();

            state._fsp--;


            	        if (current==null) {
            	            current = createModelElementForParent(grammarAccess.getQueryBasedValueConverterRule());
            	        }
                   		set(
                   			current, 
                   			"converterQuery",
                    		lv_converterQuery_1_0, 
                    		"QueryUsage");
            	        afterParserOrEnumRuleCall();
            	    

            }


            }


            }


            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleQueryBasedValueConverter"


    // $ANTLR start "entryRuleBasicTypeValueConverter"
    // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:2441:1: entryRuleBasicTypeValueConverter returns [EObject current=null] : iv_ruleBasicTypeValueConverter= ruleBasicTypeValueConverter EOF ;
    public final EObject entryRuleBasicTypeValueConverter() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleBasicTypeValueConverter = null;


        try {
            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:2442:2: (iv_ruleBasicTypeValueConverter= ruleBasicTypeValueConverter EOF )
            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:2443:2: iv_ruleBasicTypeValueConverter= ruleBasicTypeValueConverter EOF
            {
             newCompositeNode(grammarAccess.getBasicTypeValueConverterRule()); 
            pushFollow(FOLLOW_ruleBasicTypeValueConverter_in_entryRuleBasicTypeValueConverter5232);
            iv_ruleBasicTypeValueConverter=ruleBasicTypeValueConverter();

            state._fsp--;

             current =iv_ruleBasicTypeValueConverter; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleBasicTypeValueConverter5242); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleBasicTypeValueConverter"


    // $ANTLR start "ruleBasicTypeValueConverter"
    // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:2450:1: ruleBasicTypeValueConverter returns [EObject current=null] : ( ( (lv_category_0_0= ruleVALUE_CONVERTER_CATEGORY_MDSL ) ) (otherlv_1= ':' ( (lv_configuration_2_0= RULE_STRING ) ) )? ) ;
    public final EObject ruleBasicTypeValueConverter() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token lv_configuration_2_0=null;
        Enumerator lv_category_0_0 = null;


         enterRule(); 
            
        try {
            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:2453:28: ( ( ( (lv_category_0_0= ruleVALUE_CONVERTER_CATEGORY_MDSL ) ) (otherlv_1= ':' ( (lv_configuration_2_0= RULE_STRING ) ) )? ) )
            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:2454:1: ( ( (lv_category_0_0= ruleVALUE_CONVERTER_CATEGORY_MDSL ) ) (otherlv_1= ':' ( (lv_configuration_2_0= RULE_STRING ) ) )? )
            {
            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:2454:1: ( ( (lv_category_0_0= ruleVALUE_CONVERTER_CATEGORY_MDSL ) ) (otherlv_1= ':' ( (lv_configuration_2_0= RULE_STRING ) ) )? )
            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:2454:2: ( (lv_category_0_0= ruleVALUE_CONVERTER_CATEGORY_MDSL ) ) (otherlv_1= ':' ( (lv_configuration_2_0= RULE_STRING ) ) )?
            {
            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:2454:2: ( (lv_category_0_0= ruleVALUE_CONVERTER_CATEGORY_MDSL ) )
            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:2455:1: (lv_category_0_0= ruleVALUE_CONVERTER_CATEGORY_MDSL )
            {
            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:2455:1: (lv_category_0_0= ruleVALUE_CONVERTER_CATEGORY_MDSL )
            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:2456:3: lv_category_0_0= ruleVALUE_CONVERTER_CATEGORY_MDSL
            {
             
            	        newCompositeNode(grammarAccess.getBasicTypeValueConverterAccess().getCategoryVALUE_CONVERTER_CATEGORY_MDSLEnumRuleCall_0_0()); 
            	    
            pushFollow(FOLLOW_ruleVALUE_CONVERTER_CATEGORY_MDSL_in_ruleBasicTypeValueConverter5288);
            lv_category_0_0=ruleVALUE_CONVERTER_CATEGORY_MDSL();

            state._fsp--;


            	        if (current==null) {
            	            current = createModelElementForParent(grammarAccess.getBasicTypeValueConverterRule());
            	        }
                   		set(
                   			current, 
                   			"category",
                    		lv_category_0_0, 
                    		"VALUE_CONVERTER_CATEGORY_MDSL");
            	        afterParserOrEnumRuleCall();
            	    

            }


            }

            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:2472:2: (otherlv_1= ':' ( (lv_configuration_2_0= RULE_STRING ) ) )?
            int alt41=2;
            int LA41_0 = input.LA(1);

            if ( (LA41_0==25) ) {
                alt41=1;
            }
            switch (alt41) {
                case 1 :
                    // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:2472:4: otherlv_1= ':' ( (lv_configuration_2_0= RULE_STRING ) )
                    {
                    otherlv_1=(Token)match(input,25,FOLLOW_25_in_ruleBasicTypeValueConverter5301); 

                        	newLeafNode(otherlv_1, grammarAccess.getBasicTypeValueConverterAccess().getColonKeyword_1_0());
                        
                    // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:2476:1: ( (lv_configuration_2_0= RULE_STRING ) )
                    // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:2477:1: (lv_configuration_2_0= RULE_STRING )
                    {
                    // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:2477:1: (lv_configuration_2_0= RULE_STRING )
                    // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:2478:3: lv_configuration_2_0= RULE_STRING
                    {
                    lv_configuration_2_0=(Token)match(input,RULE_STRING,FOLLOW_RULE_STRING_in_ruleBasicTypeValueConverter5318); 

                    			newLeafNode(lv_configuration_2_0, grammarAccess.getBasicTypeValueConverterAccess().getConfigurationSTRINGTerminalRuleCall_1_1_0()); 
                    		

                    	        if (current==null) {
                    	            current = createModelElement(grammarAccess.getBasicTypeValueConverterRule());
                    	        }
                           		setWithLastConsumed(
                           			current, 
                           			"configuration",
                            		lv_configuration_2_0, 
                            		"STRING");
                    	    

                    }


                    }


                    }
                    break;

            }


            }


            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleBasicTypeValueConverter"


    // $ANTLR start "entryRuleWidgetConfigurationMdsl"
    // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:2502:1: entryRuleWidgetConfigurationMdsl returns [EObject current=null] : iv_ruleWidgetConfigurationMdsl= ruleWidgetConfigurationMdsl EOF ;
    public final EObject entryRuleWidgetConfigurationMdsl() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleWidgetConfigurationMdsl = null;


        try {
            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:2503:2: (iv_ruleWidgetConfigurationMdsl= ruleWidgetConfigurationMdsl EOF )
            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:2504:2: iv_ruleWidgetConfigurationMdsl= ruleWidgetConfigurationMdsl EOF
            {
             newCompositeNode(grammarAccess.getWidgetConfigurationMdslRule()); 
            pushFollow(FOLLOW_ruleWidgetConfigurationMdsl_in_entryRuleWidgetConfigurationMdsl5361);
            iv_ruleWidgetConfigurationMdsl=ruleWidgetConfigurationMdsl();

            state._fsp--;

             current =iv_ruleWidgetConfigurationMdsl; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleWidgetConfigurationMdsl5371); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleWidgetConfigurationMdsl"


    // $ANTLR start "ruleWidgetConfigurationMdsl"
    // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:2511:1: ruleWidgetConfigurationMdsl returns [EObject current=null] : (otherlv_0= 'widget:' ( (lv_name_1_0= RULE_ID ) ) (otherlv_2= 'description:' ( (lv_description_3_0= RULE_STRING ) ) )? (otherlv_4= 'tab:' ( (otherlv_5= RULE_ID ) ) )? (otherlv_6= 'layers:' ( (otherlv_7= RULE_ID ) ) (otherlv_8= ',' ( (otherlv_9= RULE_ID ) ) )* )? ( (lv_i18NLabel_10_0= 'I18N' ) )? otherlv_11= 'label:' ( (lv_label_12_0= ruleFormatExpr ) ) otherlv_13= 'type:' ( (lv_widgetCategory_14_0= ruleWIDGET_CATEGORY_MDSL ) ) (otherlv_15= ':' ( (otherlv_16= RULE_ID ) ) )? ( (lv_dslReference_17_0= ruleXtextLanguageReference ) )? ( (otherlv_18= 'flexible template:' | otherlv_19= 'target template:' ) ( (otherlv_20= RULE_ID ) ) )? ( ( ( ( ({...}? => ( ({...}? => (otherlv_22= 'visible when:' ( (lv_visibilityQuery_23_0= ruleQuery ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_24= 'editable when:' ( (lv_editableQuery_25_0= ruleQuery ) ) ) ) ) ) )* ) ) ) (otherlv_26= 'value:' ( (lv_valueQuery_27_0= ruleQueryUsage ) ) )? (otherlv_28= 'valueConverter:' ( (lv_valueConverter_29_0= ruleValueConverter ) ) )? (otherlv_30= 'validators:' ( (lv_validators_31_0= ruleValidatorMdsl ) )* )? ( ( (lv_i18NFormat_32_0= 'I18N' ) )? otherlv_33= 'format:' ( (lv_valueFormat_34_0= ruleFormatExpr ) ) )? (otherlv_35= 'candidates:' ( (lv_candidatesQuery_36_0= ruleQueryUsage ) ) )? ( ( (lv_i18NItemLabel_37_0= 'I18N' ) )? otherlv_38= 'item label:' ( (lv_itemLabelExpression_39_0= ruleFormatExpr ) ) )? (otherlv_40= 'commands:' ( (lv_commands_41_0= ruleCommand ) ) (otherlv_42= ',' ( (lv_commands_43_0= ruleCommand ) ) )* )? ) ;
    public final EObject ruleWidgetConfigurationMdsl() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token lv_name_1_0=null;
        Token otherlv_2=null;
        Token lv_description_3_0=null;
        Token otherlv_4=null;
        Token otherlv_5=null;
        Token otherlv_6=null;
        Token otherlv_7=null;
        Token otherlv_8=null;
        Token otherlv_9=null;
        Token lv_i18NLabel_10_0=null;
        Token otherlv_11=null;
        Token otherlv_13=null;
        Token otherlv_15=null;
        Token otherlv_16=null;
        Token otherlv_18=null;
        Token otherlv_19=null;
        Token otherlv_20=null;
        Token otherlv_22=null;
        Token otherlv_24=null;
        Token otherlv_26=null;
        Token otherlv_28=null;
        Token otherlv_30=null;
        Token lv_i18NFormat_32_0=null;
        Token otherlv_33=null;
        Token otherlv_35=null;
        Token lv_i18NItemLabel_37_0=null;
        Token otherlv_38=null;
        Token otherlv_40=null;
        Token otherlv_42=null;
        EObject lv_label_12_0 = null;

        Enumerator lv_widgetCategory_14_0 = null;

        EObject lv_dslReference_17_0 = null;

        EObject lv_visibilityQuery_23_0 = null;

        EObject lv_editableQuery_25_0 = null;

        EObject lv_valueQuery_27_0 = null;

        EObject lv_valueConverter_29_0 = null;

        EObject lv_validators_31_0 = null;

        EObject lv_valueFormat_34_0 = null;

        EObject lv_candidatesQuery_36_0 = null;

        EObject lv_itemLabelExpression_39_0 = null;

        EObject lv_commands_41_0 = null;

        EObject lv_commands_43_0 = null;


         enterRule(); 
            
        try {
            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:2514:28: ( (otherlv_0= 'widget:' ( (lv_name_1_0= RULE_ID ) ) (otherlv_2= 'description:' ( (lv_description_3_0= RULE_STRING ) ) )? (otherlv_4= 'tab:' ( (otherlv_5= RULE_ID ) ) )? (otherlv_6= 'layers:' ( (otherlv_7= RULE_ID ) ) (otherlv_8= ',' ( (otherlv_9= RULE_ID ) ) )* )? ( (lv_i18NLabel_10_0= 'I18N' ) )? otherlv_11= 'label:' ( (lv_label_12_0= ruleFormatExpr ) ) otherlv_13= 'type:' ( (lv_widgetCategory_14_0= ruleWIDGET_CATEGORY_MDSL ) ) (otherlv_15= ':' ( (otherlv_16= RULE_ID ) ) )? ( (lv_dslReference_17_0= ruleXtextLanguageReference ) )? ( (otherlv_18= 'flexible template:' | otherlv_19= 'target template:' ) ( (otherlv_20= RULE_ID ) ) )? ( ( ( ( ({...}? => ( ({...}? => (otherlv_22= 'visible when:' ( (lv_visibilityQuery_23_0= ruleQuery ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_24= 'editable when:' ( (lv_editableQuery_25_0= ruleQuery ) ) ) ) ) ) )* ) ) ) (otherlv_26= 'value:' ( (lv_valueQuery_27_0= ruleQueryUsage ) ) )? (otherlv_28= 'valueConverter:' ( (lv_valueConverter_29_0= ruleValueConverter ) ) )? (otherlv_30= 'validators:' ( (lv_validators_31_0= ruleValidatorMdsl ) )* )? ( ( (lv_i18NFormat_32_0= 'I18N' ) )? otherlv_33= 'format:' ( (lv_valueFormat_34_0= ruleFormatExpr ) ) )? (otherlv_35= 'candidates:' ( (lv_candidatesQuery_36_0= ruleQueryUsage ) ) )? ( ( (lv_i18NItemLabel_37_0= 'I18N' ) )? otherlv_38= 'item label:' ( (lv_itemLabelExpression_39_0= ruleFormatExpr ) ) )? (otherlv_40= 'commands:' ( (lv_commands_41_0= ruleCommand ) ) (otherlv_42= ',' ( (lv_commands_43_0= ruleCommand ) ) )* )? ) )
            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:2515:1: (otherlv_0= 'widget:' ( (lv_name_1_0= RULE_ID ) ) (otherlv_2= 'description:' ( (lv_description_3_0= RULE_STRING ) ) )? (otherlv_4= 'tab:' ( (otherlv_5= RULE_ID ) ) )? (otherlv_6= 'layers:' ( (otherlv_7= RULE_ID ) ) (otherlv_8= ',' ( (otherlv_9= RULE_ID ) ) )* )? ( (lv_i18NLabel_10_0= 'I18N' ) )? otherlv_11= 'label:' ( (lv_label_12_0= ruleFormatExpr ) ) otherlv_13= 'type:' ( (lv_widgetCategory_14_0= ruleWIDGET_CATEGORY_MDSL ) ) (otherlv_15= ':' ( (otherlv_16= RULE_ID ) ) )? ( (lv_dslReference_17_0= ruleXtextLanguageReference ) )? ( (otherlv_18= 'flexible template:' | otherlv_19= 'target template:' ) ( (otherlv_20= RULE_ID ) ) )? ( ( ( ( ({...}? => ( ({...}? => (otherlv_22= 'visible when:' ( (lv_visibilityQuery_23_0= ruleQuery ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_24= 'editable when:' ( (lv_editableQuery_25_0= ruleQuery ) ) ) ) ) ) )* ) ) ) (otherlv_26= 'value:' ( (lv_valueQuery_27_0= ruleQueryUsage ) ) )? (otherlv_28= 'valueConverter:' ( (lv_valueConverter_29_0= ruleValueConverter ) ) )? (otherlv_30= 'validators:' ( (lv_validators_31_0= ruleValidatorMdsl ) )* )? ( ( (lv_i18NFormat_32_0= 'I18N' ) )? otherlv_33= 'format:' ( (lv_valueFormat_34_0= ruleFormatExpr ) ) )? (otherlv_35= 'candidates:' ( (lv_candidatesQuery_36_0= ruleQueryUsage ) ) )? ( ( (lv_i18NItemLabel_37_0= 'I18N' ) )? otherlv_38= 'item label:' ( (lv_itemLabelExpression_39_0= ruleFormatExpr ) ) )? (otherlv_40= 'commands:' ( (lv_commands_41_0= ruleCommand ) ) (otherlv_42= ',' ( (lv_commands_43_0= ruleCommand ) ) )* )? )
            {
            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:2515:1: (otherlv_0= 'widget:' ( (lv_name_1_0= RULE_ID ) ) (otherlv_2= 'description:' ( (lv_description_3_0= RULE_STRING ) ) )? (otherlv_4= 'tab:' ( (otherlv_5= RULE_ID ) ) )? (otherlv_6= 'layers:' ( (otherlv_7= RULE_ID ) ) (otherlv_8= ',' ( (otherlv_9= RULE_ID ) ) )* )? ( (lv_i18NLabel_10_0= 'I18N' ) )? otherlv_11= 'label:' ( (lv_label_12_0= ruleFormatExpr ) ) otherlv_13= 'type:' ( (lv_widgetCategory_14_0= ruleWIDGET_CATEGORY_MDSL ) ) (otherlv_15= ':' ( (otherlv_16= RULE_ID ) ) )? ( (lv_dslReference_17_0= ruleXtextLanguageReference ) )? ( (otherlv_18= 'flexible template:' | otherlv_19= 'target template:' ) ( (otherlv_20= RULE_ID ) ) )? ( ( ( ( ({...}? => ( ({...}? => (otherlv_22= 'visible when:' ( (lv_visibilityQuery_23_0= ruleQuery ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_24= 'editable when:' ( (lv_editableQuery_25_0= ruleQuery ) ) ) ) ) ) )* ) ) ) (otherlv_26= 'value:' ( (lv_valueQuery_27_0= ruleQueryUsage ) ) )? (otherlv_28= 'valueConverter:' ( (lv_valueConverter_29_0= ruleValueConverter ) ) )? (otherlv_30= 'validators:' ( (lv_validators_31_0= ruleValidatorMdsl ) )* )? ( ( (lv_i18NFormat_32_0= 'I18N' ) )? otherlv_33= 'format:' ( (lv_valueFormat_34_0= ruleFormatExpr ) ) )? (otherlv_35= 'candidates:' ( (lv_candidatesQuery_36_0= ruleQueryUsage ) ) )? ( ( (lv_i18NItemLabel_37_0= 'I18N' ) )? otherlv_38= 'item label:' ( (lv_itemLabelExpression_39_0= ruleFormatExpr ) ) )? (otherlv_40= 'commands:' ( (lv_commands_41_0= ruleCommand ) ) (otherlv_42= ',' ( (lv_commands_43_0= ruleCommand ) ) )* )? )
            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:2515:3: otherlv_0= 'widget:' ( (lv_name_1_0= RULE_ID ) ) (otherlv_2= 'description:' ( (lv_description_3_0= RULE_STRING ) ) )? (otherlv_4= 'tab:' ( (otherlv_5= RULE_ID ) ) )? (otherlv_6= 'layers:' ( (otherlv_7= RULE_ID ) ) (otherlv_8= ',' ( (otherlv_9= RULE_ID ) ) )* )? ( (lv_i18NLabel_10_0= 'I18N' ) )? otherlv_11= 'label:' ( (lv_label_12_0= ruleFormatExpr ) ) otherlv_13= 'type:' ( (lv_widgetCategory_14_0= ruleWIDGET_CATEGORY_MDSL ) ) (otherlv_15= ':' ( (otherlv_16= RULE_ID ) ) )? ( (lv_dslReference_17_0= ruleXtextLanguageReference ) )? ( (otherlv_18= 'flexible template:' | otherlv_19= 'target template:' ) ( (otherlv_20= RULE_ID ) ) )? ( ( ( ( ({...}? => ( ({...}? => (otherlv_22= 'visible when:' ( (lv_visibilityQuery_23_0= ruleQuery ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_24= 'editable when:' ( (lv_editableQuery_25_0= ruleQuery ) ) ) ) ) ) )* ) ) ) (otherlv_26= 'value:' ( (lv_valueQuery_27_0= ruleQueryUsage ) ) )? (otherlv_28= 'valueConverter:' ( (lv_valueConverter_29_0= ruleValueConverter ) ) )? (otherlv_30= 'validators:' ( (lv_validators_31_0= ruleValidatorMdsl ) )* )? ( ( (lv_i18NFormat_32_0= 'I18N' ) )? otherlv_33= 'format:' ( (lv_valueFormat_34_0= ruleFormatExpr ) ) )? (otherlv_35= 'candidates:' ( (lv_candidatesQuery_36_0= ruleQueryUsage ) ) )? ( ( (lv_i18NItemLabel_37_0= 'I18N' ) )? otherlv_38= 'item label:' ( (lv_itemLabelExpression_39_0= ruleFormatExpr ) ) )? (otherlv_40= 'commands:' ( (lv_commands_41_0= ruleCommand ) ) (otherlv_42= ',' ( (lv_commands_43_0= ruleCommand ) ) )* )?
            {
            otherlv_0=(Token)match(input,67,FOLLOW_67_in_ruleWidgetConfigurationMdsl5408); 

                	newLeafNode(otherlv_0, grammarAccess.getWidgetConfigurationMdslAccess().getWidgetKeyword_0());
                
            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:2519:1: ( (lv_name_1_0= RULE_ID ) )
            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:2520:1: (lv_name_1_0= RULE_ID )
            {
            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:2520:1: (lv_name_1_0= RULE_ID )
            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:2521:3: lv_name_1_0= RULE_ID
            {
            lv_name_1_0=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleWidgetConfigurationMdsl5425); 

            			newLeafNode(lv_name_1_0, grammarAccess.getWidgetConfigurationMdslAccess().getNameIDTerminalRuleCall_1_0()); 
            		

            	        if (current==null) {
            	            current = createModelElement(grammarAccess.getWidgetConfigurationMdslRule());
            	        }
                   		setWithLastConsumed(
                   			current, 
                   			"name",
                    		lv_name_1_0, 
                    		"ID");
            	    

            }


            }

            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:2537:2: (otherlv_2= 'description:' ( (lv_description_3_0= RULE_STRING ) ) )?
            int alt42=2;
            int LA42_0 = input.LA(1);

            if ( (LA42_0==17) ) {
                alt42=1;
            }
            switch (alt42) {
                case 1 :
                    // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:2537:4: otherlv_2= 'description:' ( (lv_description_3_0= RULE_STRING ) )
                    {
                    otherlv_2=(Token)match(input,17,FOLLOW_17_in_ruleWidgetConfigurationMdsl5443); 

                        	newLeafNode(otherlv_2, grammarAccess.getWidgetConfigurationMdslAccess().getDescriptionKeyword_2_0());
                        
                    // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:2541:1: ( (lv_description_3_0= RULE_STRING ) )
                    // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:2542:1: (lv_description_3_0= RULE_STRING )
                    {
                    // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:2542:1: (lv_description_3_0= RULE_STRING )
                    // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:2543:3: lv_description_3_0= RULE_STRING
                    {
                    lv_description_3_0=(Token)match(input,RULE_STRING,FOLLOW_RULE_STRING_in_ruleWidgetConfigurationMdsl5460); 

                    			newLeafNode(lv_description_3_0, grammarAccess.getWidgetConfigurationMdslAccess().getDescriptionSTRINGTerminalRuleCall_2_1_0()); 
                    		

                    	        if (current==null) {
                    	            current = createModelElement(grammarAccess.getWidgetConfigurationMdslRule());
                    	        }
                           		setWithLastConsumed(
                           			current, 
                           			"description",
                            		lv_description_3_0, 
                            		"STRING");
                    	    

                    }


                    }


                    }
                    break;

            }

            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:2559:4: (otherlv_4= 'tab:' ( (otherlv_5= RULE_ID ) ) )?
            int alt43=2;
            int LA43_0 = input.LA(1);

            if ( (LA43_0==68) ) {
                alt43=1;
            }
            switch (alt43) {
                case 1 :
                    // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:2559:6: otherlv_4= 'tab:' ( (otherlv_5= RULE_ID ) )
                    {
                    otherlv_4=(Token)match(input,68,FOLLOW_68_in_ruleWidgetConfigurationMdsl5480); 

                        	newLeafNode(otherlv_4, grammarAccess.getWidgetConfigurationMdslAccess().getTabKeyword_3_0());
                        
                    // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:2563:1: ( (otherlv_5= RULE_ID ) )
                    // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:2564:1: (otherlv_5= RULE_ID )
                    {
                    // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:2564:1: (otherlv_5= RULE_ID )
                    // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:2565:3: otherlv_5= RULE_ID
                    {

                    			if (current==null) {
                    	            current = createModelElement(grammarAccess.getWidgetConfigurationMdslRule());
                    	        }
                            
                    otherlv_5=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleWidgetConfigurationMdsl5500); 

                    		newLeafNode(otherlv_5, grammarAccess.getWidgetConfigurationMdslAccess().getUiTabUITabMdslCrossReference_3_1_0()); 
                    	

                    }


                    }


                    }
                    break;

            }

            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:2576:4: (otherlv_6= 'layers:' ( (otherlv_7= RULE_ID ) ) (otherlv_8= ',' ( (otherlv_9= RULE_ID ) ) )* )?
            int alt45=2;
            int LA45_0 = input.LA(1);

            if ( (LA45_0==69) ) {
                alt45=1;
            }
            switch (alt45) {
                case 1 :
                    // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:2576:6: otherlv_6= 'layers:' ( (otherlv_7= RULE_ID ) ) (otherlv_8= ',' ( (otherlv_9= RULE_ID ) ) )*
                    {
                    otherlv_6=(Token)match(input,69,FOLLOW_69_in_ruleWidgetConfigurationMdsl5515); 

                        	newLeafNode(otherlv_6, grammarAccess.getWidgetConfigurationMdslAccess().getLayersKeyword_4_0());
                        
                    // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:2580:1: ( (otherlv_7= RULE_ID ) )
                    // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:2581:1: (otherlv_7= RULE_ID )
                    {
                    // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:2581:1: (otherlv_7= RULE_ID )
                    // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:2582:3: otherlv_7= RULE_ID
                    {

                    			if (current==null) {
                    	            current = createModelElement(grammarAccess.getWidgetConfigurationMdslRule());
                    	        }
                            
                    otherlv_7=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleWidgetConfigurationMdsl5535); 

                    		newLeafNode(otherlv_7, grammarAccess.getWidgetConfigurationMdslAccess().getLayersLayerMdslCrossReference_4_1_0()); 
                    	

                    }


                    }

                    // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:2593:2: (otherlv_8= ',' ( (otherlv_9= RULE_ID ) ) )*
                    loop44:
                    do {
                        int alt44=2;
                        int LA44_0 = input.LA(1);

                        if ( (LA44_0==33) ) {
                            alt44=1;
                        }


                        switch (alt44) {
                    	case 1 :
                    	    // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:2593:4: otherlv_8= ',' ( (otherlv_9= RULE_ID ) )
                    	    {
                    	    otherlv_8=(Token)match(input,33,FOLLOW_33_in_ruleWidgetConfigurationMdsl5548); 

                    	        	newLeafNode(otherlv_8, grammarAccess.getWidgetConfigurationMdslAccess().getCommaKeyword_4_2_0());
                    	        
                    	    // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:2597:1: ( (otherlv_9= RULE_ID ) )
                    	    // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:2598:1: (otherlv_9= RULE_ID )
                    	    {
                    	    // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:2598:1: (otherlv_9= RULE_ID )
                    	    // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:2599:3: otherlv_9= RULE_ID
                    	    {

                    	    			if (current==null) {
                    	    	            current = createModelElement(grammarAccess.getWidgetConfigurationMdslRule());
                    	    	        }
                    	            
                    	    otherlv_9=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleWidgetConfigurationMdsl5568); 

                    	    		newLeafNode(otherlv_9, grammarAccess.getWidgetConfigurationMdslAccess().getLayersLayerMdslCrossReference_4_2_1_0()); 
                    	    	

                    	    }


                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop44;
                        }
                    } while (true);


                    }
                    break;

            }

            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:2610:6: ( (lv_i18NLabel_10_0= 'I18N' ) )?
            int alt46=2;
            int LA46_0 = input.LA(1);

            if ( (LA46_0==52) ) {
                alt46=1;
            }
            switch (alt46) {
                case 1 :
                    // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:2611:1: (lv_i18NLabel_10_0= 'I18N' )
                    {
                    // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:2611:1: (lv_i18NLabel_10_0= 'I18N' )
                    // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:2612:3: lv_i18NLabel_10_0= 'I18N'
                    {
                    lv_i18NLabel_10_0=(Token)match(input,52,FOLLOW_52_in_ruleWidgetConfigurationMdsl5590); 

                            newLeafNode(lv_i18NLabel_10_0, grammarAccess.getWidgetConfigurationMdslAccess().getI18NLabelI18NKeyword_5_0());
                        

                    	        if (current==null) {
                    	            current = createModelElement(grammarAccess.getWidgetConfigurationMdslRule());
                    	        }
                           		setWithLastConsumed(current, "i18NLabel", true, "I18N");
                    	    

                    }


                    }
                    break;

            }

            otherlv_11=(Token)match(input,13,FOLLOW_13_in_ruleWidgetConfigurationMdsl5616); 

                	newLeafNode(otherlv_11, grammarAccess.getWidgetConfigurationMdslAccess().getLabelKeyword_6());
                
            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:2629:1: ( (lv_label_12_0= ruleFormatExpr ) )
            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:2630:1: (lv_label_12_0= ruleFormatExpr )
            {
            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:2630:1: (lv_label_12_0= ruleFormatExpr )
            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:2631:3: lv_label_12_0= ruleFormatExpr
            {
             
            	        newCompositeNode(grammarAccess.getWidgetConfigurationMdslAccess().getLabelFormatExprParserRuleCall_7_0()); 
            	    
            pushFollow(FOLLOW_ruleFormatExpr_in_ruleWidgetConfigurationMdsl5637);
            lv_label_12_0=ruleFormatExpr();

            state._fsp--;


            	        if (current==null) {
            	            current = createModelElementForParent(grammarAccess.getWidgetConfigurationMdslRule());
            	        }
                   		set(
                   			current, 
                   			"label",
                    		lv_label_12_0, 
                    		"FormatExpr");
            	        afterParserOrEnumRuleCall();
            	    

            }


            }

            otherlv_13=(Token)match(input,70,FOLLOW_70_in_ruleWidgetConfigurationMdsl5649); 

                	newLeafNode(otherlv_13, grammarAccess.getWidgetConfigurationMdslAccess().getTypeKeyword_8());
                
            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:2651:1: ( (lv_widgetCategory_14_0= ruleWIDGET_CATEGORY_MDSL ) )
            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:2652:1: (lv_widgetCategory_14_0= ruleWIDGET_CATEGORY_MDSL )
            {
            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:2652:1: (lv_widgetCategory_14_0= ruleWIDGET_CATEGORY_MDSL )
            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:2653:3: lv_widgetCategory_14_0= ruleWIDGET_CATEGORY_MDSL
            {
             
            	        newCompositeNode(grammarAccess.getWidgetConfigurationMdslAccess().getWidgetCategoryWIDGET_CATEGORY_MDSLEnumRuleCall_9_0()); 
            	    
            pushFollow(FOLLOW_ruleWIDGET_CATEGORY_MDSL_in_ruleWidgetConfigurationMdsl5670);
            lv_widgetCategory_14_0=ruleWIDGET_CATEGORY_MDSL();

            state._fsp--;


            	        if (current==null) {
            	            current = createModelElementForParent(grammarAccess.getWidgetConfigurationMdslRule());
            	        }
                   		set(
                   			current, 
                   			"widgetCategory",
                    		lv_widgetCategory_14_0, 
                    		"WIDGET_CATEGORY_MDSL");
            	        afterParserOrEnumRuleCall();
            	    

            }


            }

            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:2669:2: (otherlv_15= ':' ( (otherlv_16= RULE_ID ) ) )?
            int alt47=2;
            int LA47_0 = input.LA(1);

            if ( (LA47_0==25) ) {
                alt47=1;
            }
            switch (alt47) {
                case 1 :
                    // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:2669:4: otherlv_15= ':' ( (otherlv_16= RULE_ID ) )
                    {
                    otherlv_15=(Token)match(input,25,FOLLOW_25_in_ruleWidgetConfigurationMdsl5683); 

                        	newLeafNode(otherlv_15, grammarAccess.getWidgetConfigurationMdslAccess().getColonKeyword_10_0());
                        
                    // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:2673:1: ( (otherlv_16= RULE_ID ) )
                    // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:2674:1: (otherlv_16= RULE_ID )
                    {
                    // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:2674:1: (otherlv_16= RULE_ID )
                    // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:2675:3: otherlv_16= RULE_ID
                    {

                    			if (current==null) {
                    	            current = createModelElement(grammarAccess.getWidgetConfigurationMdslRule());
                    	        }
                            
                    otherlv_16=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleWidgetConfigurationMdsl5703); 

                    		newLeafNode(otherlv_16, grammarAccess.getWidgetConfigurationMdslAccess().getWidgetTypeWidgetTypeCrossReference_10_1_0()); 
                    	

                    }


                    }


                    }
                    break;

            }

            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:2686:4: ( (lv_dslReference_17_0= ruleXtextLanguageReference ) )?
            int alt48=2;
            int LA48_0 = input.LA(1);

            if ( (LA48_0==38) ) {
                alt48=1;
            }
            switch (alt48) {
                case 1 :
                    // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:2687:1: (lv_dslReference_17_0= ruleXtextLanguageReference )
                    {
                    // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:2687:1: (lv_dslReference_17_0= ruleXtextLanguageReference )
                    // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:2688:3: lv_dslReference_17_0= ruleXtextLanguageReference
                    {
                     
                    	        newCompositeNode(grammarAccess.getWidgetConfigurationMdslAccess().getDslReferenceXtextLanguageReferenceParserRuleCall_11_0()); 
                    	    
                    pushFollow(FOLLOW_ruleXtextLanguageReference_in_ruleWidgetConfigurationMdsl5726);
                    lv_dslReference_17_0=ruleXtextLanguageReference();

                    state._fsp--;


                    	        if (current==null) {
                    	            current = createModelElementForParent(grammarAccess.getWidgetConfigurationMdslRule());
                    	        }
                           		set(
                           			current, 
                           			"dslReference",
                            		lv_dslReference_17_0, 
                            		"XtextLanguageReference");
                    	        afterParserOrEnumRuleCall();
                    	    

                    }


                    }
                    break;

            }

            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:2704:3: ( (otherlv_18= 'flexible template:' | otherlv_19= 'target template:' ) ( (otherlv_20= RULE_ID ) ) )?
            int alt50=2;
            int LA50_0 = input.LA(1);

            if ( ((LA50_0>=71 && LA50_0<=72)) ) {
                alt50=1;
            }
            switch (alt50) {
                case 1 :
                    // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:2704:4: (otherlv_18= 'flexible template:' | otherlv_19= 'target template:' ) ( (otherlv_20= RULE_ID ) )
                    {
                    // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:2704:4: (otherlv_18= 'flexible template:' | otherlv_19= 'target template:' )
                    int alt49=2;
                    int LA49_0 = input.LA(1);

                    if ( (LA49_0==71) ) {
                        alt49=1;
                    }
                    else if ( (LA49_0==72) ) {
                        alt49=2;
                    }
                    else {
                        NoViableAltException nvae =
                            new NoViableAltException("", 49, 0, input);

                        throw nvae;
                    }
                    switch (alt49) {
                        case 1 :
                            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:2704:6: otherlv_18= 'flexible template:'
                            {
                            otherlv_18=(Token)match(input,71,FOLLOW_71_in_ruleWidgetConfigurationMdsl5741); 

                                	newLeafNode(otherlv_18, grammarAccess.getWidgetConfigurationMdslAccess().getFlexibleTemplateKeyword_12_0_0());
                                

                            }
                            break;
                        case 2 :
                            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:2709:7: otherlv_19= 'target template:'
                            {
                            otherlv_19=(Token)match(input,72,FOLLOW_72_in_ruleWidgetConfigurationMdsl5759); 

                                	newLeafNode(otherlv_19, grammarAccess.getWidgetConfigurationMdslAccess().getTargetTemplateKeyword_12_0_1());
                                

                            }
                            break;

                    }

                    // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:2713:2: ( (otherlv_20= RULE_ID ) )
                    // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:2714:1: (otherlv_20= RULE_ID )
                    {
                    // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:2714:1: (otherlv_20= RULE_ID )
                    // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:2715:3: otherlv_20= RULE_ID
                    {

                    			if (current==null) {
                    	            current = createModelElement(grammarAccess.getWidgetConfigurationMdslRule());
                    	        }
                            
                    otherlv_20=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleWidgetConfigurationMdsl5780); 

                    		newLeafNode(otherlv_20, grammarAccess.getWidgetConfigurationMdslAccess().getFlexibleTemplateTypeConfigurationMdslCrossReference_12_1_0()); 
                    	

                    }


                    }


                    }
                    break;

            }

            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:2726:4: ( ( ( ( ({...}? => ( ({...}? => (otherlv_22= 'visible when:' ( (lv_visibilityQuery_23_0= ruleQuery ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_24= 'editable when:' ( (lv_editableQuery_25_0= ruleQuery ) ) ) ) ) ) )* ) ) )
            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:2728:1: ( ( ( ({...}? => ( ({...}? => (otherlv_22= 'visible when:' ( (lv_visibilityQuery_23_0= ruleQuery ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_24= 'editable when:' ( (lv_editableQuery_25_0= ruleQuery ) ) ) ) ) ) )* ) )
            {
            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:2728:1: ( ( ( ({...}? => ( ({...}? => (otherlv_22= 'visible when:' ( (lv_visibilityQuery_23_0= ruleQuery ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_24= 'editable when:' ( (lv_editableQuery_25_0= ruleQuery ) ) ) ) ) ) )* ) )
            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:2729:2: ( ( ({...}? => ( ({...}? => (otherlv_22= 'visible when:' ( (lv_visibilityQuery_23_0= ruleQuery ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_24= 'editable when:' ( (lv_editableQuery_25_0= ruleQuery ) ) ) ) ) ) )* )
            {
             
            	  getUnorderedGroupHelper().enter(grammarAccess.getWidgetConfigurationMdslAccess().getUnorderedGroup_13());
            	
            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:2732:2: ( ( ({...}? => ( ({...}? => (otherlv_22= 'visible when:' ( (lv_visibilityQuery_23_0= ruleQuery ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_24= 'editable when:' ( (lv_editableQuery_25_0= ruleQuery ) ) ) ) ) ) )* )
            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:2733:3: ( ({...}? => ( ({...}? => (otherlv_22= 'visible when:' ( (lv_visibilityQuery_23_0= ruleQuery ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_24= 'editable when:' ( (lv_editableQuery_25_0= ruleQuery ) ) ) ) ) ) )*
            {
            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:2733:3: ( ({...}? => ( ({...}? => (otherlv_22= 'visible when:' ( (lv_visibilityQuery_23_0= ruleQuery ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_24= 'editable when:' ( (lv_editableQuery_25_0= ruleQuery ) ) ) ) ) ) )*
            loop51:
            do {
                int alt51=3;
                int LA51_0 = input.LA(1);

                if ( LA51_0 ==73 && getUnorderedGroupHelper().canSelect(grammarAccess.getWidgetConfigurationMdslAccess().getUnorderedGroup_13(), 0) ) {
                    alt51=1;
                }
                else if ( LA51_0 ==74 && getUnorderedGroupHelper().canSelect(grammarAccess.getWidgetConfigurationMdslAccess().getUnorderedGroup_13(), 1) ) {
                    alt51=2;
                }


                switch (alt51) {
            	case 1 :
            	    // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:2735:4: ({...}? => ( ({...}? => (otherlv_22= 'visible when:' ( (lv_visibilityQuery_23_0= ruleQuery ) ) ) ) ) )
            	    {
            	    // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:2735:4: ({...}? => ( ({...}? => (otherlv_22= 'visible when:' ( (lv_visibilityQuery_23_0= ruleQuery ) ) ) ) ) )
            	    // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:2736:5: {...}? => ( ({...}? => (otherlv_22= 'visible when:' ( (lv_visibilityQuery_23_0= ruleQuery ) ) ) ) )
            	    {
            	    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getWidgetConfigurationMdslAccess().getUnorderedGroup_13(), 0) ) {
            	        throw new FailedPredicateException(input, "ruleWidgetConfigurationMdsl", "getUnorderedGroupHelper().canSelect(grammarAccess.getWidgetConfigurationMdslAccess().getUnorderedGroup_13(), 0)");
            	    }
            	    // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:2736:121: ( ({...}? => (otherlv_22= 'visible when:' ( (lv_visibilityQuery_23_0= ruleQuery ) ) ) ) )
            	    // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:2737:6: ({...}? => (otherlv_22= 'visible when:' ( (lv_visibilityQuery_23_0= ruleQuery ) ) ) )
            	    {
            	     
            	    	 				  getUnorderedGroupHelper().select(grammarAccess.getWidgetConfigurationMdslAccess().getUnorderedGroup_13(), 0);
            	    	 				
            	    // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:2740:6: ({...}? => (otherlv_22= 'visible when:' ( (lv_visibilityQuery_23_0= ruleQuery ) ) ) )
            	    // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:2740:7: {...}? => (otherlv_22= 'visible when:' ( (lv_visibilityQuery_23_0= ruleQuery ) ) )
            	    {
            	    if ( !((true)) ) {
            	        throw new FailedPredicateException(input, "ruleWidgetConfigurationMdsl", "true");
            	    }
            	    // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:2740:16: (otherlv_22= 'visible when:' ( (lv_visibilityQuery_23_0= ruleQuery ) ) )
            	    // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:2740:18: otherlv_22= 'visible when:' ( (lv_visibilityQuery_23_0= ruleQuery ) )
            	    {
            	    otherlv_22=(Token)match(input,73,FOLLOW_73_in_ruleWidgetConfigurationMdsl5840); 

            	        	newLeafNode(otherlv_22, grammarAccess.getWidgetConfigurationMdslAccess().getVisibleWhenKeyword_13_0_0());
            	        
            	    // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:2744:1: ( (lv_visibilityQuery_23_0= ruleQuery ) )
            	    // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:2745:1: (lv_visibilityQuery_23_0= ruleQuery )
            	    {
            	    // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:2745:1: (lv_visibilityQuery_23_0= ruleQuery )
            	    // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:2746:3: lv_visibilityQuery_23_0= ruleQuery
            	    {
            	     
            	    	        newCompositeNode(grammarAccess.getWidgetConfigurationMdslAccess().getVisibilityQueryQueryParserRuleCall_13_0_1_0()); 
            	    	    
            	    pushFollow(FOLLOW_ruleQuery_in_ruleWidgetConfigurationMdsl5861);
            	    lv_visibilityQuery_23_0=ruleQuery();

            	    state._fsp--;


            	    	        if (current==null) {
            	    	            current = createModelElementForParent(grammarAccess.getWidgetConfigurationMdslRule());
            	    	        }
            	           		set(
            	           			current, 
            	           			"visibilityQuery",
            	            		lv_visibilityQuery_23_0, 
            	            		"Query");
            	    	        afterParserOrEnumRuleCall();
            	    	    

            	    }


            	    }


            	    }


            	    }

            	     
            	    	 				  getUnorderedGroupHelper().returnFromSelection(grammarAccess.getWidgetConfigurationMdslAccess().getUnorderedGroup_13());
            	    	 				

            	    }


            	    }


            	    }
            	    break;
            	case 2 :
            	    // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:2769:4: ({...}? => ( ({...}? => (otherlv_24= 'editable when:' ( (lv_editableQuery_25_0= ruleQuery ) ) ) ) ) )
            	    {
            	    // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:2769:4: ({...}? => ( ({...}? => (otherlv_24= 'editable when:' ( (lv_editableQuery_25_0= ruleQuery ) ) ) ) ) )
            	    // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:2770:5: {...}? => ( ({...}? => (otherlv_24= 'editable when:' ( (lv_editableQuery_25_0= ruleQuery ) ) ) ) )
            	    {
            	    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getWidgetConfigurationMdslAccess().getUnorderedGroup_13(), 1) ) {
            	        throw new FailedPredicateException(input, "ruleWidgetConfigurationMdsl", "getUnorderedGroupHelper().canSelect(grammarAccess.getWidgetConfigurationMdslAccess().getUnorderedGroup_13(), 1)");
            	    }
            	    // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:2770:121: ( ({...}? => (otherlv_24= 'editable when:' ( (lv_editableQuery_25_0= ruleQuery ) ) ) ) )
            	    // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:2771:6: ({...}? => (otherlv_24= 'editable when:' ( (lv_editableQuery_25_0= ruleQuery ) ) ) )
            	    {
            	     
            	    	 				  getUnorderedGroupHelper().select(grammarAccess.getWidgetConfigurationMdslAccess().getUnorderedGroup_13(), 1);
            	    	 				
            	    // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:2774:6: ({...}? => (otherlv_24= 'editable when:' ( (lv_editableQuery_25_0= ruleQuery ) ) ) )
            	    // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:2774:7: {...}? => (otherlv_24= 'editable when:' ( (lv_editableQuery_25_0= ruleQuery ) ) )
            	    {
            	    if ( !((true)) ) {
            	        throw new FailedPredicateException(input, "ruleWidgetConfigurationMdsl", "true");
            	    }
            	    // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:2774:16: (otherlv_24= 'editable when:' ( (lv_editableQuery_25_0= ruleQuery ) ) )
            	    // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:2774:18: otherlv_24= 'editable when:' ( (lv_editableQuery_25_0= ruleQuery ) )
            	    {
            	    otherlv_24=(Token)match(input,74,FOLLOW_74_in_ruleWidgetConfigurationMdsl5929); 

            	        	newLeafNode(otherlv_24, grammarAccess.getWidgetConfigurationMdslAccess().getEditableWhenKeyword_13_1_0());
            	        
            	    // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:2778:1: ( (lv_editableQuery_25_0= ruleQuery ) )
            	    // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:2779:1: (lv_editableQuery_25_0= ruleQuery )
            	    {
            	    // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:2779:1: (lv_editableQuery_25_0= ruleQuery )
            	    // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:2780:3: lv_editableQuery_25_0= ruleQuery
            	    {
            	     
            	    	        newCompositeNode(grammarAccess.getWidgetConfigurationMdslAccess().getEditableQueryQueryParserRuleCall_13_1_1_0()); 
            	    	    
            	    pushFollow(FOLLOW_ruleQuery_in_ruleWidgetConfigurationMdsl5950);
            	    lv_editableQuery_25_0=ruleQuery();

            	    state._fsp--;


            	    	        if (current==null) {
            	    	            current = createModelElementForParent(grammarAccess.getWidgetConfigurationMdslRule());
            	    	        }
            	           		set(
            	           			current, 
            	           			"editableQuery",
            	            		lv_editableQuery_25_0, 
            	            		"Query");
            	    	        afterParserOrEnumRuleCall();
            	    	    

            	    }


            	    }


            	    }


            	    }

            	     
            	    	 				  getUnorderedGroupHelper().returnFromSelection(grammarAccess.getWidgetConfigurationMdslAccess().getUnorderedGroup_13());
            	    	 				

            	    }


            	    }


            	    }
            	    break;

            	default :
            	    break loop51;
                }
            } while (true);


            }


            }

             
            	  getUnorderedGroupHelper().leave(grammarAccess.getWidgetConfigurationMdslAccess().getUnorderedGroup_13());
            	

            }

            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:2810:2: (otherlv_26= 'value:' ( (lv_valueQuery_27_0= ruleQueryUsage ) ) )?
            int alt52=2;
            int LA52_0 = input.LA(1);

            if ( (LA52_0==65) ) {
                alt52=1;
            }
            switch (alt52) {
                case 1 :
                    // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:2810:4: otherlv_26= 'value:' ( (lv_valueQuery_27_0= ruleQueryUsage ) )
                    {
                    otherlv_26=(Token)match(input,65,FOLLOW_65_in_ruleWidgetConfigurationMdsl6004); 

                        	newLeafNode(otherlv_26, grammarAccess.getWidgetConfigurationMdslAccess().getValueKeyword_14_0());
                        
                    // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:2814:1: ( (lv_valueQuery_27_0= ruleQueryUsage ) )
                    // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:2815:1: (lv_valueQuery_27_0= ruleQueryUsage )
                    {
                    // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:2815:1: (lv_valueQuery_27_0= ruleQueryUsage )
                    // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:2816:3: lv_valueQuery_27_0= ruleQueryUsage
                    {
                     
                    	        newCompositeNode(grammarAccess.getWidgetConfigurationMdslAccess().getValueQueryQueryUsageParserRuleCall_14_1_0()); 
                    	    
                    pushFollow(FOLLOW_ruleQueryUsage_in_ruleWidgetConfigurationMdsl6025);
                    lv_valueQuery_27_0=ruleQueryUsage();

                    state._fsp--;


                    	        if (current==null) {
                    	            current = createModelElementForParent(grammarAccess.getWidgetConfigurationMdslRule());
                    	        }
                           		set(
                           			current, 
                           			"valueQuery",
                            		lv_valueQuery_27_0, 
                            		"QueryUsage");
                    	        afterParserOrEnumRuleCall();
                    	    

                    }


                    }


                    }
                    break;

            }

            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:2832:4: (otherlv_28= 'valueConverter:' ( (lv_valueConverter_29_0= ruleValueConverter ) ) )?
            int alt53=2;
            int LA53_0 = input.LA(1);

            if ( (LA53_0==75) ) {
                alt53=1;
            }
            switch (alt53) {
                case 1 :
                    // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:2832:6: otherlv_28= 'valueConverter:' ( (lv_valueConverter_29_0= ruleValueConverter ) )
                    {
                    otherlv_28=(Token)match(input,75,FOLLOW_75_in_ruleWidgetConfigurationMdsl6040); 

                        	newLeafNode(otherlv_28, grammarAccess.getWidgetConfigurationMdslAccess().getValueConverterKeyword_15_0());
                        
                    // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:2836:1: ( (lv_valueConverter_29_0= ruleValueConverter ) )
                    // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:2837:1: (lv_valueConverter_29_0= ruleValueConverter )
                    {
                    // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:2837:1: (lv_valueConverter_29_0= ruleValueConverter )
                    // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:2838:3: lv_valueConverter_29_0= ruleValueConverter
                    {
                     
                    	        newCompositeNode(grammarAccess.getWidgetConfigurationMdslAccess().getValueConverterValueConverterParserRuleCall_15_1_0()); 
                    	    
                    pushFollow(FOLLOW_ruleValueConverter_in_ruleWidgetConfigurationMdsl6061);
                    lv_valueConverter_29_0=ruleValueConverter();

                    state._fsp--;


                    	        if (current==null) {
                    	            current = createModelElementForParent(grammarAccess.getWidgetConfigurationMdslRule());
                    	        }
                           		set(
                           			current, 
                           			"valueConverter",
                            		lv_valueConverter_29_0, 
                            		"ValueConverter");
                    	        afterParserOrEnumRuleCall();
                    	    

                    }


                    }


                    }
                    break;

            }

            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:2854:4: (otherlv_30= 'validators:' ( (lv_validators_31_0= ruleValidatorMdsl ) )* )?
            int alt55=2;
            int LA55_0 = input.LA(1);

            if ( (LA55_0==76) ) {
                alt55=1;
            }
            switch (alt55) {
                case 1 :
                    // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:2854:6: otherlv_30= 'validators:' ( (lv_validators_31_0= ruleValidatorMdsl ) )*
                    {
                    otherlv_30=(Token)match(input,76,FOLLOW_76_in_ruleWidgetConfigurationMdsl6076); 

                        	newLeafNode(otherlv_30, grammarAccess.getWidgetConfigurationMdslAccess().getValidatorsKeyword_16_0());
                        
                    // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:2858:1: ( (lv_validators_31_0= ruleValidatorMdsl ) )*
                    loop54:
                    do {
                        int alt54=2;
                        int LA54_0 = input.LA(1);

                        if ( (LA54_0==81) ) {
                            alt54=1;
                        }


                        switch (alt54) {
                    	case 1 :
                    	    // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:2859:1: (lv_validators_31_0= ruleValidatorMdsl )
                    	    {
                    	    // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:2859:1: (lv_validators_31_0= ruleValidatorMdsl )
                    	    // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:2860:3: lv_validators_31_0= ruleValidatorMdsl
                    	    {
                    	     
                    	    	        newCompositeNode(grammarAccess.getWidgetConfigurationMdslAccess().getValidatorsValidatorMdslParserRuleCall_16_1_0()); 
                    	    	    
                    	    pushFollow(FOLLOW_ruleValidatorMdsl_in_ruleWidgetConfigurationMdsl6097);
                    	    lv_validators_31_0=ruleValidatorMdsl();

                    	    state._fsp--;


                    	    	        if (current==null) {
                    	    	            current = createModelElementForParent(grammarAccess.getWidgetConfigurationMdslRule());
                    	    	        }
                    	           		add(
                    	           			current, 
                    	           			"validators",
                    	            		lv_validators_31_0, 
                    	            		"ValidatorMdsl");
                    	    	        afterParserOrEnumRuleCall();
                    	    	    

                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop54;
                        }
                    } while (true);


                    }
                    break;

            }

            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:2876:5: ( ( (lv_i18NFormat_32_0= 'I18N' ) )? otherlv_33= 'format:' ( (lv_valueFormat_34_0= ruleFormatExpr ) ) )?
            int alt57=2;
            int LA57_0 = input.LA(1);

            if ( (LA57_0==52) ) {
                int LA57_1 = input.LA(2);

                if ( (LA57_1==77) ) {
                    alt57=1;
                }
            }
            else if ( (LA57_0==77) ) {
                alt57=1;
            }
            switch (alt57) {
                case 1 :
                    // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:2876:6: ( (lv_i18NFormat_32_0= 'I18N' ) )? otherlv_33= 'format:' ( (lv_valueFormat_34_0= ruleFormatExpr ) )
                    {
                    // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:2876:6: ( (lv_i18NFormat_32_0= 'I18N' ) )?
                    int alt56=2;
                    int LA56_0 = input.LA(1);

                    if ( (LA56_0==52) ) {
                        alt56=1;
                    }
                    switch (alt56) {
                        case 1 :
                            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:2877:1: (lv_i18NFormat_32_0= 'I18N' )
                            {
                            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:2877:1: (lv_i18NFormat_32_0= 'I18N' )
                            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:2878:3: lv_i18NFormat_32_0= 'I18N'
                            {
                            lv_i18NFormat_32_0=(Token)match(input,52,FOLLOW_52_in_ruleWidgetConfigurationMdsl6119); 

                                    newLeafNode(lv_i18NFormat_32_0, grammarAccess.getWidgetConfigurationMdslAccess().getI18NFormatI18NKeyword_17_0_0());
                                

                            	        if (current==null) {
                            	            current = createModelElement(grammarAccess.getWidgetConfigurationMdslRule());
                            	        }
                                   		setWithLastConsumed(current, "i18NFormat", true, "I18N");
                            	    

                            }


                            }
                            break;

                    }

                    otherlv_33=(Token)match(input,77,FOLLOW_77_in_ruleWidgetConfigurationMdsl6145); 

                        	newLeafNode(otherlv_33, grammarAccess.getWidgetConfigurationMdslAccess().getFormatKeyword_17_1());
                        
                    // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:2895:1: ( (lv_valueFormat_34_0= ruleFormatExpr ) )
                    // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:2896:1: (lv_valueFormat_34_0= ruleFormatExpr )
                    {
                    // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:2896:1: (lv_valueFormat_34_0= ruleFormatExpr )
                    // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:2897:3: lv_valueFormat_34_0= ruleFormatExpr
                    {
                     
                    	        newCompositeNode(grammarAccess.getWidgetConfigurationMdslAccess().getValueFormatFormatExprParserRuleCall_17_2_0()); 
                    	    
                    pushFollow(FOLLOW_ruleFormatExpr_in_ruleWidgetConfigurationMdsl6166);
                    lv_valueFormat_34_0=ruleFormatExpr();

                    state._fsp--;


                    	        if (current==null) {
                    	            current = createModelElementForParent(grammarAccess.getWidgetConfigurationMdslRule());
                    	        }
                           		set(
                           			current, 
                           			"valueFormat",
                            		lv_valueFormat_34_0, 
                            		"FormatExpr");
                    	        afterParserOrEnumRuleCall();
                    	    

                    }


                    }


                    }
                    break;

            }

            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:2913:4: (otherlv_35= 'candidates:' ( (lv_candidatesQuery_36_0= ruleQueryUsage ) ) )?
            int alt58=2;
            int LA58_0 = input.LA(1);

            if ( (LA58_0==78) ) {
                alt58=1;
            }
            switch (alt58) {
                case 1 :
                    // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:2913:6: otherlv_35= 'candidates:' ( (lv_candidatesQuery_36_0= ruleQueryUsage ) )
                    {
                    otherlv_35=(Token)match(input,78,FOLLOW_78_in_ruleWidgetConfigurationMdsl6181); 

                        	newLeafNode(otherlv_35, grammarAccess.getWidgetConfigurationMdslAccess().getCandidatesKeyword_18_0());
                        
                    // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:2917:1: ( (lv_candidatesQuery_36_0= ruleQueryUsage ) )
                    // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:2918:1: (lv_candidatesQuery_36_0= ruleQueryUsage )
                    {
                    // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:2918:1: (lv_candidatesQuery_36_0= ruleQueryUsage )
                    // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:2919:3: lv_candidatesQuery_36_0= ruleQueryUsage
                    {
                     
                    	        newCompositeNode(grammarAccess.getWidgetConfigurationMdslAccess().getCandidatesQueryQueryUsageParserRuleCall_18_1_0()); 
                    	    
                    pushFollow(FOLLOW_ruleQueryUsage_in_ruleWidgetConfigurationMdsl6202);
                    lv_candidatesQuery_36_0=ruleQueryUsage();

                    state._fsp--;


                    	        if (current==null) {
                    	            current = createModelElementForParent(grammarAccess.getWidgetConfigurationMdslRule());
                    	        }
                           		set(
                           			current, 
                           			"candidatesQuery",
                            		lv_candidatesQuery_36_0, 
                            		"QueryUsage");
                    	        afterParserOrEnumRuleCall();
                    	    

                    }


                    }


                    }
                    break;

            }

            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:2935:4: ( ( (lv_i18NItemLabel_37_0= 'I18N' ) )? otherlv_38= 'item label:' ( (lv_itemLabelExpression_39_0= ruleFormatExpr ) ) )?
            int alt60=2;
            int LA60_0 = input.LA(1);

            if ( (LA60_0==52||LA60_0==79) ) {
                alt60=1;
            }
            switch (alt60) {
                case 1 :
                    // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:2935:5: ( (lv_i18NItemLabel_37_0= 'I18N' ) )? otherlv_38= 'item label:' ( (lv_itemLabelExpression_39_0= ruleFormatExpr ) )
                    {
                    // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:2935:5: ( (lv_i18NItemLabel_37_0= 'I18N' ) )?
                    int alt59=2;
                    int LA59_0 = input.LA(1);

                    if ( (LA59_0==52) ) {
                        alt59=1;
                    }
                    switch (alt59) {
                        case 1 :
                            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:2936:1: (lv_i18NItemLabel_37_0= 'I18N' )
                            {
                            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:2936:1: (lv_i18NItemLabel_37_0= 'I18N' )
                            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:2937:3: lv_i18NItemLabel_37_0= 'I18N'
                            {
                            lv_i18NItemLabel_37_0=(Token)match(input,52,FOLLOW_52_in_ruleWidgetConfigurationMdsl6223); 

                                    newLeafNode(lv_i18NItemLabel_37_0, grammarAccess.getWidgetConfigurationMdslAccess().getI18NItemLabelI18NKeyword_19_0_0());
                                

                            	        if (current==null) {
                            	            current = createModelElement(grammarAccess.getWidgetConfigurationMdslRule());
                            	        }
                                   		setWithLastConsumed(current, "i18NItemLabel", true, "I18N");
                            	    

                            }


                            }
                            break;

                    }

                    otherlv_38=(Token)match(input,79,FOLLOW_79_in_ruleWidgetConfigurationMdsl6249); 

                        	newLeafNode(otherlv_38, grammarAccess.getWidgetConfigurationMdslAccess().getItemLabelKeyword_19_1());
                        
                    // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:2954:1: ( (lv_itemLabelExpression_39_0= ruleFormatExpr ) )
                    // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:2955:1: (lv_itemLabelExpression_39_0= ruleFormatExpr )
                    {
                    // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:2955:1: (lv_itemLabelExpression_39_0= ruleFormatExpr )
                    // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:2956:3: lv_itemLabelExpression_39_0= ruleFormatExpr
                    {
                     
                    	        newCompositeNode(grammarAccess.getWidgetConfigurationMdslAccess().getItemLabelExpressionFormatExprParserRuleCall_19_2_0()); 
                    	    
                    pushFollow(FOLLOW_ruleFormatExpr_in_ruleWidgetConfigurationMdsl6270);
                    lv_itemLabelExpression_39_0=ruleFormatExpr();

                    state._fsp--;


                    	        if (current==null) {
                    	            current = createModelElementForParent(grammarAccess.getWidgetConfigurationMdslRule());
                    	        }
                           		set(
                           			current, 
                           			"itemLabelExpression",
                            		lv_itemLabelExpression_39_0, 
                            		"FormatExpr");
                    	        afterParserOrEnumRuleCall();
                    	    

                    }


                    }


                    }
                    break;

            }

            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:2972:4: (otherlv_40= 'commands:' ( (lv_commands_41_0= ruleCommand ) ) (otherlv_42= ',' ( (lv_commands_43_0= ruleCommand ) ) )* )?
            int alt62=2;
            int LA62_0 = input.LA(1);

            if ( (LA62_0==80) ) {
                alt62=1;
            }
            switch (alt62) {
                case 1 :
                    // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:2972:6: otherlv_40= 'commands:' ( (lv_commands_41_0= ruleCommand ) ) (otherlv_42= ',' ( (lv_commands_43_0= ruleCommand ) ) )*
                    {
                    otherlv_40=(Token)match(input,80,FOLLOW_80_in_ruleWidgetConfigurationMdsl6285); 

                        	newLeafNode(otherlv_40, grammarAccess.getWidgetConfigurationMdslAccess().getCommandsKeyword_20_0());
                        
                    // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:2976:1: ( (lv_commands_41_0= ruleCommand ) )
                    // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:2977:1: (lv_commands_41_0= ruleCommand )
                    {
                    // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:2977:1: (lv_commands_41_0= ruleCommand )
                    // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:2978:3: lv_commands_41_0= ruleCommand
                    {
                     
                    	        newCompositeNode(grammarAccess.getWidgetConfigurationMdslAccess().getCommandsCommandParserRuleCall_20_1_0()); 
                    	    
                    pushFollow(FOLLOW_ruleCommand_in_ruleWidgetConfigurationMdsl6306);
                    lv_commands_41_0=ruleCommand();

                    state._fsp--;


                    	        if (current==null) {
                    	            current = createModelElementForParent(grammarAccess.getWidgetConfigurationMdslRule());
                    	        }
                           		add(
                           			current, 
                           			"commands",
                            		lv_commands_41_0, 
                            		"Command");
                    	        afterParserOrEnumRuleCall();
                    	    

                    }


                    }

                    // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:2994:2: (otherlv_42= ',' ( (lv_commands_43_0= ruleCommand ) ) )*
                    loop61:
                    do {
                        int alt61=2;
                        int LA61_0 = input.LA(1);

                        if ( (LA61_0==33) ) {
                            alt61=1;
                        }


                        switch (alt61) {
                    	case 1 :
                    	    // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:2994:4: otherlv_42= ',' ( (lv_commands_43_0= ruleCommand ) )
                    	    {
                    	    otherlv_42=(Token)match(input,33,FOLLOW_33_in_ruleWidgetConfigurationMdsl6319); 

                    	        	newLeafNode(otherlv_42, grammarAccess.getWidgetConfigurationMdslAccess().getCommaKeyword_20_2_0());
                    	        
                    	    // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:2998:1: ( (lv_commands_43_0= ruleCommand ) )
                    	    // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:2999:1: (lv_commands_43_0= ruleCommand )
                    	    {
                    	    // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:2999:1: (lv_commands_43_0= ruleCommand )
                    	    // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:3000:3: lv_commands_43_0= ruleCommand
                    	    {
                    	     
                    	    	        newCompositeNode(grammarAccess.getWidgetConfigurationMdslAccess().getCommandsCommandParserRuleCall_20_2_1_0()); 
                    	    	    
                    	    pushFollow(FOLLOW_ruleCommand_in_ruleWidgetConfigurationMdsl6340);
                    	    lv_commands_43_0=ruleCommand();

                    	    state._fsp--;


                    	    	        if (current==null) {
                    	    	            current = createModelElementForParent(grammarAccess.getWidgetConfigurationMdslRule());
                    	    	        }
                    	           		add(
                    	           			current, 
                    	           			"commands",
                    	            		lv_commands_43_0, 
                    	            		"Command");
                    	    	        afterParserOrEnumRuleCall();
                    	    	    

                    	    }


                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop61;
                        }
                    } while (true);


                    }
                    break;

            }


            }


            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleWidgetConfigurationMdsl"


    // $ANTLR start "entryRuleValidatorMdsl"
    // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:3024:1: entryRuleValidatorMdsl returns [EObject current=null] : iv_ruleValidatorMdsl= ruleValidatorMdsl EOF ;
    public final EObject entryRuleValidatorMdsl() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleValidatorMdsl = null;


        try {
            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:3025:2: (iv_ruleValidatorMdsl= ruleValidatorMdsl EOF )
            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:3026:2: iv_ruleValidatorMdsl= ruleValidatorMdsl EOF
            {
             newCompositeNode(grammarAccess.getValidatorMdslRule()); 
            pushFollow(FOLLOW_ruleValidatorMdsl_in_entryRuleValidatorMdsl6380);
            iv_ruleValidatorMdsl=ruleValidatorMdsl();

            state._fsp--;

             current =iv_ruleValidatorMdsl; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleValidatorMdsl6390); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleValidatorMdsl"


    // $ANTLR start "ruleValidatorMdsl"
    // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:3033:1: ruleValidatorMdsl returns [EObject current=null] : (otherlv_0= 'validation rule:' ( (lv_validationQuery_1_0= ruleQueryUsage ) ) ( (lv_i18NMessage_2_0= 'I18N' ) )? otherlv_3= 'Error message:' ( (lv_errorMessageExpr_4_0= ruleFormatExpr ) ) ) ;
    public final EObject ruleValidatorMdsl() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token lv_i18NMessage_2_0=null;
        Token otherlv_3=null;
        EObject lv_validationQuery_1_0 = null;

        EObject lv_errorMessageExpr_4_0 = null;


         enterRule(); 
            
        try {
            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:3036:28: ( (otherlv_0= 'validation rule:' ( (lv_validationQuery_1_0= ruleQueryUsage ) ) ( (lv_i18NMessage_2_0= 'I18N' ) )? otherlv_3= 'Error message:' ( (lv_errorMessageExpr_4_0= ruleFormatExpr ) ) ) )
            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:3037:1: (otherlv_0= 'validation rule:' ( (lv_validationQuery_1_0= ruleQueryUsage ) ) ( (lv_i18NMessage_2_0= 'I18N' ) )? otherlv_3= 'Error message:' ( (lv_errorMessageExpr_4_0= ruleFormatExpr ) ) )
            {
            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:3037:1: (otherlv_0= 'validation rule:' ( (lv_validationQuery_1_0= ruleQueryUsage ) ) ( (lv_i18NMessage_2_0= 'I18N' ) )? otherlv_3= 'Error message:' ( (lv_errorMessageExpr_4_0= ruleFormatExpr ) ) )
            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:3037:3: otherlv_0= 'validation rule:' ( (lv_validationQuery_1_0= ruleQueryUsage ) ) ( (lv_i18NMessage_2_0= 'I18N' ) )? otherlv_3= 'Error message:' ( (lv_errorMessageExpr_4_0= ruleFormatExpr ) )
            {
            otherlv_0=(Token)match(input,81,FOLLOW_81_in_ruleValidatorMdsl6427); 

                	newLeafNode(otherlv_0, grammarAccess.getValidatorMdslAccess().getValidationRuleKeyword_0());
                
            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:3041:1: ( (lv_validationQuery_1_0= ruleQueryUsage ) )
            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:3042:1: (lv_validationQuery_1_0= ruleQueryUsage )
            {
            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:3042:1: (lv_validationQuery_1_0= ruleQueryUsage )
            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:3043:3: lv_validationQuery_1_0= ruleQueryUsage
            {
             
            	        newCompositeNode(grammarAccess.getValidatorMdslAccess().getValidationQueryQueryUsageParserRuleCall_1_0()); 
            	    
            pushFollow(FOLLOW_ruleQueryUsage_in_ruleValidatorMdsl6448);
            lv_validationQuery_1_0=ruleQueryUsage();

            state._fsp--;


            	        if (current==null) {
            	            current = createModelElementForParent(grammarAccess.getValidatorMdslRule());
            	        }
                   		set(
                   			current, 
                   			"validationQuery",
                    		lv_validationQuery_1_0, 
                    		"QueryUsage");
            	        afterParserOrEnumRuleCall();
            	    

            }


            }

            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:3059:2: ( (lv_i18NMessage_2_0= 'I18N' ) )?
            int alt63=2;
            int LA63_0 = input.LA(1);

            if ( (LA63_0==52) ) {
                alt63=1;
            }
            switch (alt63) {
                case 1 :
                    // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:3060:1: (lv_i18NMessage_2_0= 'I18N' )
                    {
                    // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:3060:1: (lv_i18NMessage_2_0= 'I18N' )
                    // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:3061:3: lv_i18NMessage_2_0= 'I18N'
                    {
                    lv_i18NMessage_2_0=(Token)match(input,52,FOLLOW_52_in_ruleValidatorMdsl6466); 

                            newLeafNode(lv_i18NMessage_2_0, grammarAccess.getValidatorMdslAccess().getI18NMessageI18NKeyword_2_0());
                        

                    	        if (current==null) {
                    	            current = createModelElement(grammarAccess.getValidatorMdslRule());
                    	        }
                           		setWithLastConsumed(current, "i18NMessage", true, "I18N");
                    	    

                    }


                    }
                    break;

            }

            otherlv_3=(Token)match(input,82,FOLLOW_82_in_ruleValidatorMdsl6492); 

                	newLeafNode(otherlv_3, grammarAccess.getValidatorMdslAccess().getErrorMessageKeyword_3());
                
            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:3078:1: ( (lv_errorMessageExpr_4_0= ruleFormatExpr ) )
            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:3079:1: (lv_errorMessageExpr_4_0= ruleFormatExpr )
            {
            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:3079:1: (lv_errorMessageExpr_4_0= ruleFormatExpr )
            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:3080:3: lv_errorMessageExpr_4_0= ruleFormatExpr
            {
             
            	        newCompositeNode(grammarAccess.getValidatorMdslAccess().getErrorMessageExprFormatExprParserRuleCall_4_0()); 
            	    
            pushFollow(FOLLOW_ruleFormatExpr_in_ruleValidatorMdsl6513);
            lv_errorMessageExpr_4_0=ruleFormatExpr();

            state._fsp--;


            	        if (current==null) {
            	            current = createModelElementForParent(grammarAccess.getValidatorMdslRule());
            	        }
                   		set(
                   			current, 
                   			"errorMessageExpr",
                    		lv_errorMessageExpr_4_0, 
                    		"FormatExpr");
            	        afterParserOrEnumRuleCall();
            	    

            }


            }


            }


            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleValidatorMdsl"


    // $ANTLR start "entryRuleCommand"
    // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:3104:1: entryRuleCommand returns [EObject current=null] : iv_ruleCommand= ruleCommand EOF ;
    public final EObject entryRuleCommand() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleCommand = null;


        try {
            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:3105:2: (iv_ruleCommand= ruleCommand EOF )
            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:3106:2: iv_ruleCommand= ruleCommand EOF
            {
             newCompositeNode(grammarAccess.getCommandRule()); 
            pushFollow(FOLLOW_ruleCommand_in_entryRuleCommand6549);
            iv_ruleCommand=ruleCommand();

            state._fsp--;

             current =iv_ruleCommand; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleCommand6559); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleCommand"


    // $ANTLR start "ruleCommand"
    // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:3113:1: ruleCommand returns [EObject current=null] : (this_CommandDefinitionMdsl_0= ruleCommandDefinitionMdsl | this_CommandRefMdsl_1= ruleCommandRefMdsl ) ;
    public final EObject ruleCommand() throws RecognitionException {
        EObject current = null;

        EObject this_CommandDefinitionMdsl_0 = null;

        EObject this_CommandRefMdsl_1 = null;


         enterRule(); 
            
        try {
            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:3116:28: ( (this_CommandDefinitionMdsl_0= ruleCommandDefinitionMdsl | this_CommandRefMdsl_1= ruleCommandRefMdsl ) )
            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:3117:1: (this_CommandDefinitionMdsl_0= ruleCommandDefinitionMdsl | this_CommandRefMdsl_1= ruleCommandRefMdsl )
            {
            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:3117:1: (this_CommandDefinitionMdsl_0= ruleCommandDefinitionMdsl | this_CommandRefMdsl_1= ruleCommandRefMdsl )
            int alt64=2;
            int LA64_0 = input.LA(1);

            if ( ((LA64_0>=122 && LA64_0<=124)) ) {
                alt64=1;
            }
            else if ( (LA64_0==RULE_ID) ) {
                alt64=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 64, 0, input);

                throw nvae;
            }
            switch (alt64) {
                case 1 :
                    // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:3118:5: this_CommandDefinitionMdsl_0= ruleCommandDefinitionMdsl
                    {
                     
                            newCompositeNode(grammarAccess.getCommandAccess().getCommandDefinitionMdslParserRuleCall_0()); 
                        
                    pushFollow(FOLLOW_ruleCommandDefinitionMdsl_in_ruleCommand6606);
                    this_CommandDefinitionMdsl_0=ruleCommandDefinitionMdsl();

                    state._fsp--;

                     
                            current = this_CommandDefinitionMdsl_0; 
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;
                case 2 :
                    // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:3128:5: this_CommandRefMdsl_1= ruleCommandRefMdsl
                    {
                     
                            newCompositeNode(grammarAccess.getCommandAccess().getCommandRefMdslParserRuleCall_1()); 
                        
                    pushFollow(FOLLOW_ruleCommandRefMdsl_in_ruleCommand6633);
                    this_CommandRefMdsl_1=ruleCommandRefMdsl();

                    state._fsp--;

                     
                            current = this_CommandRefMdsl_1; 
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;

            }


            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleCommand"


    // $ANTLR start "entryRuleCommandDeclaration"
    // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:3144:1: entryRuleCommandDeclaration returns [EObject current=null] : iv_ruleCommandDeclaration= ruleCommandDeclaration EOF ;
    public final EObject entryRuleCommandDeclaration() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleCommandDeclaration = null;


        try {
            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:3145:2: (iv_ruleCommandDeclaration= ruleCommandDeclaration EOF )
            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:3146:2: iv_ruleCommandDeclaration= ruleCommandDeclaration EOF
            {
             newCompositeNode(grammarAccess.getCommandDeclarationRule()); 
            pushFollow(FOLLOW_ruleCommandDeclaration_in_entryRuleCommandDeclaration6668);
            iv_ruleCommandDeclaration=ruleCommandDeclaration();

            state._fsp--;

             current =iv_ruleCommandDeclaration; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleCommandDeclaration6678); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleCommandDeclaration"


    // $ANTLR start "ruleCommandDeclaration"
    // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:3153:1: ruleCommandDeclaration returns [EObject current=null] : (otherlv_0= 'Common Command' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' (otherlv_3= 'label:' ( (lv_label_4_0= RULE_STRING ) ) )? (otherlv_5= 'description:' ( (lv_description_6_0= RULE_STRING ) ) )? ( (lv_definition_7_0= ruleCommandDefinitionMdsl ) ) otherlv_8= '}' ) ;
    public final EObject ruleCommandDeclaration() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token lv_name_1_0=null;
        Token otherlv_2=null;
        Token otherlv_3=null;
        Token lv_label_4_0=null;
        Token otherlv_5=null;
        Token lv_description_6_0=null;
        Token otherlv_8=null;
        EObject lv_definition_7_0 = null;


         enterRule(); 
            
        try {
            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:3156:28: ( (otherlv_0= 'Common Command' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' (otherlv_3= 'label:' ( (lv_label_4_0= RULE_STRING ) ) )? (otherlv_5= 'description:' ( (lv_description_6_0= RULE_STRING ) ) )? ( (lv_definition_7_0= ruleCommandDefinitionMdsl ) ) otherlv_8= '}' ) )
            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:3157:1: (otherlv_0= 'Common Command' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' (otherlv_3= 'label:' ( (lv_label_4_0= RULE_STRING ) ) )? (otherlv_5= 'description:' ( (lv_description_6_0= RULE_STRING ) ) )? ( (lv_definition_7_0= ruleCommandDefinitionMdsl ) ) otherlv_8= '}' )
            {
            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:3157:1: (otherlv_0= 'Common Command' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' (otherlv_3= 'label:' ( (lv_label_4_0= RULE_STRING ) ) )? (otherlv_5= 'description:' ( (lv_description_6_0= RULE_STRING ) ) )? ( (lv_definition_7_0= ruleCommandDefinitionMdsl ) ) otherlv_8= '}' )
            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:3157:3: otherlv_0= 'Common Command' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' (otherlv_3= 'label:' ( (lv_label_4_0= RULE_STRING ) ) )? (otherlv_5= 'description:' ( (lv_description_6_0= RULE_STRING ) ) )? ( (lv_definition_7_0= ruleCommandDefinitionMdsl ) ) otherlv_8= '}'
            {
            otherlv_0=(Token)match(input,83,FOLLOW_83_in_ruleCommandDeclaration6715); 

                	newLeafNode(otherlv_0, grammarAccess.getCommandDeclarationAccess().getCommonCommandKeyword_0());
                
            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:3161:1: ( (lv_name_1_0= RULE_ID ) )
            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:3162:1: (lv_name_1_0= RULE_ID )
            {
            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:3162:1: (lv_name_1_0= RULE_ID )
            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:3163:3: lv_name_1_0= RULE_ID
            {
            lv_name_1_0=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleCommandDeclaration6732); 

            			newLeafNode(lv_name_1_0, grammarAccess.getCommandDeclarationAccess().getNameIDTerminalRuleCall_1_0()); 
            		

            	        if (current==null) {
            	            current = createModelElement(grammarAccess.getCommandDeclarationRule());
            	        }
                   		setWithLastConsumed(
                   			current, 
                   			"name",
                    		lv_name_1_0, 
                    		"ID");
            	    

            }


            }

            otherlv_2=(Token)match(input,22,FOLLOW_22_in_ruleCommandDeclaration6749); 

                	newLeafNode(otherlv_2, grammarAccess.getCommandDeclarationAccess().getLeftCurlyBracketKeyword_2());
                
            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:3183:1: (otherlv_3= 'label:' ( (lv_label_4_0= RULE_STRING ) ) )?
            int alt65=2;
            int LA65_0 = input.LA(1);

            if ( (LA65_0==13) ) {
                alt65=1;
            }
            switch (alt65) {
                case 1 :
                    // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:3183:3: otherlv_3= 'label:' ( (lv_label_4_0= RULE_STRING ) )
                    {
                    otherlv_3=(Token)match(input,13,FOLLOW_13_in_ruleCommandDeclaration6762); 

                        	newLeafNode(otherlv_3, grammarAccess.getCommandDeclarationAccess().getLabelKeyword_3_0());
                        
                    // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:3187:1: ( (lv_label_4_0= RULE_STRING ) )
                    // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:3188:1: (lv_label_4_0= RULE_STRING )
                    {
                    // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:3188:1: (lv_label_4_0= RULE_STRING )
                    // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:3189:3: lv_label_4_0= RULE_STRING
                    {
                    lv_label_4_0=(Token)match(input,RULE_STRING,FOLLOW_RULE_STRING_in_ruleCommandDeclaration6779); 

                    			newLeafNode(lv_label_4_0, grammarAccess.getCommandDeclarationAccess().getLabelSTRINGTerminalRuleCall_3_1_0()); 
                    		

                    	        if (current==null) {
                    	            current = createModelElement(grammarAccess.getCommandDeclarationRule());
                    	        }
                           		setWithLastConsumed(
                           			current, 
                           			"label",
                            		lv_label_4_0, 
                            		"STRING");
                    	    

                    }


                    }


                    }
                    break;

            }

            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:3205:4: (otherlv_5= 'description:' ( (lv_description_6_0= RULE_STRING ) ) )?
            int alt66=2;
            int LA66_0 = input.LA(1);

            if ( (LA66_0==17) ) {
                alt66=1;
            }
            switch (alt66) {
                case 1 :
                    // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:3205:6: otherlv_5= 'description:' ( (lv_description_6_0= RULE_STRING ) )
                    {
                    otherlv_5=(Token)match(input,17,FOLLOW_17_in_ruleCommandDeclaration6799); 

                        	newLeafNode(otherlv_5, grammarAccess.getCommandDeclarationAccess().getDescriptionKeyword_4_0());
                        
                    // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:3209:1: ( (lv_description_6_0= RULE_STRING ) )
                    // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:3210:1: (lv_description_6_0= RULE_STRING )
                    {
                    // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:3210:1: (lv_description_6_0= RULE_STRING )
                    // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:3211:3: lv_description_6_0= RULE_STRING
                    {
                    lv_description_6_0=(Token)match(input,RULE_STRING,FOLLOW_RULE_STRING_in_ruleCommandDeclaration6816); 

                    			newLeafNode(lv_description_6_0, grammarAccess.getCommandDeclarationAccess().getDescriptionSTRINGTerminalRuleCall_4_1_0()); 
                    		

                    	        if (current==null) {
                    	            current = createModelElement(grammarAccess.getCommandDeclarationRule());
                    	        }
                           		setWithLastConsumed(
                           			current, 
                           			"description",
                            		lv_description_6_0, 
                            		"STRING");
                    	    

                    }


                    }


                    }
                    break;

            }

            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:3227:4: ( (lv_definition_7_0= ruleCommandDefinitionMdsl ) )
            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:3228:1: (lv_definition_7_0= ruleCommandDefinitionMdsl )
            {
            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:3228:1: (lv_definition_7_0= ruleCommandDefinitionMdsl )
            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:3229:3: lv_definition_7_0= ruleCommandDefinitionMdsl
            {
             
            	        newCompositeNode(grammarAccess.getCommandDeclarationAccess().getDefinitionCommandDefinitionMdslParserRuleCall_5_0()); 
            	    
            pushFollow(FOLLOW_ruleCommandDefinitionMdsl_in_ruleCommandDeclaration6844);
            lv_definition_7_0=ruleCommandDefinitionMdsl();

            state._fsp--;


            	        if (current==null) {
            	            current = createModelElementForParent(grammarAccess.getCommandDeclarationRule());
            	        }
                   		set(
                   			current, 
                   			"definition",
                    		lv_definition_7_0, 
                    		"CommandDefinitionMdsl");
            	        afterParserOrEnumRuleCall();
            	    

            }


            }

            otherlv_8=(Token)match(input,28,FOLLOW_28_in_ruleCommandDeclaration6856); 

                	newLeafNode(otherlv_8, grammarAccess.getCommandDeclarationAccess().getRightCurlyBracketKeyword_6());
                

            }


            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleCommandDeclaration"


    // $ANTLR start "entryRuleCommandDefinitionMdsl"
    // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:3257:1: entryRuleCommandDefinitionMdsl returns [EObject current=null] : iv_ruleCommandDefinitionMdsl= ruleCommandDefinitionMdsl EOF ;
    public final EObject entryRuleCommandDefinitionMdsl() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleCommandDefinitionMdsl = null;


        try {
            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:3258:2: (iv_ruleCommandDefinitionMdsl= ruleCommandDefinitionMdsl EOF )
            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:3259:2: iv_ruleCommandDefinitionMdsl= ruleCommandDefinitionMdsl EOF
            {
             newCompositeNode(grammarAccess.getCommandDefinitionMdslRule()); 
            pushFollow(FOLLOW_ruleCommandDefinitionMdsl_in_entryRuleCommandDefinitionMdsl6892);
            iv_ruleCommandDefinitionMdsl=ruleCommandDefinitionMdsl();

            state._fsp--;

             current =iv_ruleCommandDefinitionMdsl; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleCommandDefinitionMdsl6902); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleCommandDefinitionMdsl"


    // $ANTLR start "ruleCommandDefinitionMdsl"
    // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:3266:1: ruleCommandDefinitionMdsl returns [EObject current=null] : ( ( (lv_category_0_0= ruleCOMMAND_CATEGORY_MDSL ) ) ( (lv_i18NLabel_1_0= 'I18N' ) )? ( (lv_label_2_0= ruleFormatExpr ) ) (otherlv_3= 'icon:' ( (otherlv_4= RULE_ID ) ) )? otherlv_5= 'action:' ( (lv_action_6_0= ruleQuery ) ) (otherlv_7= 'on success:' ( (lv_onActionSuccessUICommands_8_0= ruleUICommandMdsl ) )* )? (otherlv_9= 'on error:' ( (lv_onActionErrorUICommands_10_0= ruleUICommandMdsl ) )* )? ) ;
    public final EObject ruleCommandDefinitionMdsl() throws RecognitionException {
        EObject current = null;

        Token lv_i18NLabel_1_0=null;
        Token otherlv_3=null;
        Token otherlv_4=null;
        Token otherlv_5=null;
        Token otherlv_7=null;
        Token otherlv_9=null;
        Enumerator lv_category_0_0 = null;

        EObject lv_label_2_0 = null;

        EObject lv_action_6_0 = null;

        EObject lv_onActionSuccessUICommands_8_0 = null;

        EObject lv_onActionErrorUICommands_10_0 = null;


         enterRule(); 
            
        try {
            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:3269:28: ( ( ( (lv_category_0_0= ruleCOMMAND_CATEGORY_MDSL ) ) ( (lv_i18NLabel_1_0= 'I18N' ) )? ( (lv_label_2_0= ruleFormatExpr ) ) (otherlv_3= 'icon:' ( (otherlv_4= RULE_ID ) ) )? otherlv_5= 'action:' ( (lv_action_6_0= ruleQuery ) ) (otherlv_7= 'on success:' ( (lv_onActionSuccessUICommands_8_0= ruleUICommandMdsl ) )* )? (otherlv_9= 'on error:' ( (lv_onActionErrorUICommands_10_0= ruleUICommandMdsl ) )* )? ) )
            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:3270:1: ( ( (lv_category_0_0= ruleCOMMAND_CATEGORY_MDSL ) ) ( (lv_i18NLabel_1_0= 'I18N' ) )? ( (lv_label_2_0= ruleFormatExpr ) ) (otherlv_3= 'icon:' ( (otherlv_4= RULE_ID ) ) )? otherlv_5= 'action:' ( (lv_action_6_0= ruleQuery ) ) (otherlv_7= 'on success:' ( (lv_onActionSuccessUICommands_8_0= ruleUICommandMdsl ) )* )? (otherlv_9= 'on error:' ( (lv_onActionErrorUICommands_10_0= ruleUICommandMdsl ) )* )? )
            {
            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:3270:1: ( ( (lv_category_0_0= ruleCOMMAND_CATEGORY_MDSL ) ) ( (lv_i18NLabel_1_0= 'I18N' ) )? ( (lv_label_2_0= ruleFormatExpr ) ) (otherlv_3= 'icon:' ( (otherlv_4= RULE_ID ) ) )? otherlv_5= 'action:' ( (lv_action_6_0= ruleQuery ) ) (otherlv_7= 'on success:' ( (lv_onActionSuccessUICommands_8_0= ruleUICommandMdsl ) )* )? (otherlv_9= 'on error:' ( (lv_onActionErrorUICommands_10_0= ruleUICommandMdsl ) )* )? )
            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:3270:2: ( (lv_category_0_0= ruleCOMMAND_CATEGORY_MDSL ) ) ( (lv_i18NLabel_1_0= 'I18N' ) )? ( (lv_label_2_0= ruleFormatExpr ) ) (otherlv_3= 'icon:' ( (otherlv_4= RULE_ID ) ) )? otherlv_5= 'action:' ( (lv_action_6_0= ruleQuery ) ) (otherlv_7= 'on success:' ( (lv_onActionSuccessUICommands_8_0= ruleUICommandMdsl ) )* )? (otherlv_9= 'on error:' ( (lv_onActionErrorUICommands_10_0= ruleUICommandMdsl ) )* )?
            {
            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:3270:2: ( (lv_category_0_0= ruleCOMMAND_CATEGORY_MDSL ) )
            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:3271:1: (lv_category_0_0= ruleCOMMAND_CATEGORY_MDSL )
            {
            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:3271:1: (lv_category_0_0= ruleCOMMAND_CATEGORY_MDSL )
            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:3272:3: lv_category_0_0= ruleCOMMAND_CATEGORY_MDSL
            {
             
            	        newCompositeNode(grammarAccess.getCommandDefinitionMdslAccess().getCategoryCOMMAND_CATEGORY_MDSLEnumRuleCall_0_0()); 
            	    
            pushFollow(FOLLOW_ruleCOMMAND_CATEGORY_MDSL_in_ruleCommandDefinitionMdsl6948);
            lv_category_0_0=ruleCOMMAND_CATEGORY_MDSL();

            state._fsp--;


            	        if (current==null) {
            	            current = createModelElementForParent(grammarAccess.getCommandDefinitionMdslRule());
            	        }
                   		set(
                   			current, 
                   			"category",
                    		lv_category_0_0, 
                    		"COMMAND_CATEGORY_MDSL");
            	        afterParserOrEnumRuleCall();
            	    

            }


            }

            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:3288:2: ( (lv_i18NLabel_1_0= 'I18N' ) )?
            int alt67=2;
            int LA67_0 = input.LA(1);

            if ( (LA67_0==52) ) {
                alt67=1;
            }
            switch (alt67) {
                case 1 :
                    // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:3289:1: (lv_i18NLabel_1_0= 'I18N' )
                    {
                    // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:3289:1: (lv_i18NLabel_1_0= 'I18N' )
                    // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:3290:3: lv_i18NLabel_1_0= 'I18N'
                    {
                    lv_i18NLabel_1_0=(Token)match(input,52,FOLLOW_52_in_ruleCommandDefinitionMdsl6966); 

                            newLeafNode(lv_i18NLabel_1_0, grammarAccess.getCommandDefinitionMdslAccess().getI18NLabelI18NKeyword_1_0());
                        

                    	        if (current==null) {
                    	            current = createModelElement(grammarAccess.getCommandDefinitionMdslRule());
                    	        }
                           		setWithLastConsumed(current, "i18NLabel", true, "I18N");
                    	    

                    }


                    }
                    break;

            }

            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:3303:3: ( (lv_label_2_0= ruleFormatExpr ) )
            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:3304:1: (lv_label_2_0= ruleFormatExpr )
            {
            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:3304:1: (lv_label_2_0= ruleFormatExpr )
            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:3305:3: lv_label_2_0= ruleFormatExpr
            {
             
            	        newCompositeNode(grammarAccess.getCommandDefinitionMdslAccess().getLabelFormatExprParserRuleCall_2_0()); 
            	    
            pushFollow(FOLLOW_ruleFormatExpr_in_ruleCommandDefinitionMdsl7001);
            lv_label_2_0=ruleFormatExpr();

            state._fsp--;


            	        if (current==null) {
            	            current = createModelElementForParent(grammarAccess.getCommandDefinitionMdslRule());
            	        }
                   		set(
                   			current, 
                   			"label",
                    		lv_label_2_0, 
                    		"FormatExpr");
            	        afterParserOrEnumRuleCall();
            	    

            }


            }

            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:3321:2: (otherlv_3= 'icon:' ( (otherlv_4= RULE_ID ) ) )?
            int alt68=2;
            int LA68_0 = input.LA(1);

            if ( (LA68_0==84) ) {
                alt68=1;
            }
            switch (alt68) {
                case 1 :
                    // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:3321:4: otherlv_3= 'icon:' ( (otherlv_4= RULE_ID ) )
                    {
                    otherlv_3=(Token)match(input,84,FOLLOW_84_in_ruleCommandDefinitionMdsl7014); 

                        	newLeafNode(otherlv_3, grammarAccess.getCommandDefinitionMdslAccess().getIconKeyword_3_0());
                        
                    // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:3325:1: ( (otherlv_4= RULE_ID ) )
                    // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:3326:1: (otherlv_4= RULE_ID )
                    {
                    // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:3326:1: (otherlv_4= RULE_ID )
                    // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:3327:3: otherlv_4= RULE_ID
                    {

                    			if (current==null) {
                    	            current = createModelElement(grammarAccess.getCommandDefinitionMdslRule());
                    	        }
                            
                    otherlv_4=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleCommandDefinitionMdsl7034); 

                    		newLeafNode(otherlv_4, grammarAccess.getCommandDefinitionMdslAccess().getIconIconDescriptorMdslCrossReference_3_1_0()); 
                    	

                    }


                    }


                    }
                    break;

            }

            otherlv_5=(Token)match(input,85,FOLLOW_85_in_ruleCommandDefinitionMdsl7048); 

                	newLeafNode(otherlv_5, grammarAccess.getCommandDefinitionMdslAccess().getActionKeyword_4());
                
            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:3342:1: ( (lv_action_6_0= ruleQuery ) )
            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:3343:1: (lv_action_6_0= ruleQuery )
            {
            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:3343:1: (lv_action_6_0= ruleQuery )
            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:3344:3: lv_action_6_0= ruleQuery
            {
             
            	        newCompositeNode(grammarAccess.getCommandDefinitionMdslAccess().getActionQueryParserRuleCall_5_0()); 
            	    
            pushFollow(FOLLOW_ruleQuery_in_ruleCommandDefinitionMdsl7069);
            lv_action_6_0=ruleQuery();

            state._fsp--;


            	        if (current==null) {
            	            current = createModelElementForParent(grammarAccess.getCommandDefinitionMdslRule());
            	        }
                   		set(
                   			current, 
                   			"action",
                    		lv_action_6_0, 
                    		"Query");
            	        afterParserOrEnumRuleCall();
            	    

            }


            }

            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:3360:2: (otherlv_7= 'on success:' ( (lv_onActionSuccessUICommands_8_0= ruleUICommandMdsl ) )* )?
            int alt70=2;
            int LA70_0 = input.LA(1);

            if ( (LA70_0==86) ) {
                alt70=1;
            }
            switch (alt70) {
                case 1 :
                    // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:3360:4: otherlv_7= 'on success:' ( (lv_onActionSuccessUICommands_8_0= ruleUICommandMdsl ) )*
                    {
                    otherlv_7=(Token)match(input,86,FOLLOW_86_in_ruleCommandDefinitionMdsl7082); 

                        	newLeafNode(otherlv_7, grammarAccess.getCommandDefinitionMdslAccess().getOnSuccessKeyword_6_0());
                        
                    // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:3364:1: ( (lv_onActionSuccessUICommands_8_0= ruleUICommandMdsl ) )*
                    loop69:
                    do {
                        int alt69=2;
                        int LA69_0 = input.LA(1);

                        if ( ((LA69_0>=90 && LA69_0<=91)) ) {
                            alt69=1;
                        }


                        switch (alt69) {
                    	case 1 :
                    	    // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:3365:1: (lv_onActionSuccessUICommands_8_0= ruleUICommandMdsl )
                    	    {
                    	    // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:3365:1: (lv_onActionSuccessUICommands_8_0= ruleUICommandMdsl )
                    	    // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:3366:3: lv_onActionSuccessUICommands_8_0= ruleUICommandMdsl
                    	    {
                    	     
                    	    	        newCompositeNode(grammarAccess.getCommandDefinitionMdslAccess().getOnActionSuccessUICommandsUICommandMdslParserRuleCall_6_1_0()); 
                    	    	    
                    	    pushFollow(FOLLOW_ruleUICommandMdsl_in_ruleCommandDefinitionMdsl7103);
                    	    lv_onActionSuccessUICommands_8_0=ruleUICommandMdsl();

                    	    state._fsp--;


                    	    	        if (current==null) {
                    	    	            current = createModelElementForParent(grammarAccess.getCommandDefinitionMdslRule());
                    	    	        }
                    	           		add(
                    	           			current, 
                    	           			"onActionSuccessUICommands",
                    	            		lv_onActionSuccessUICommands_8_0, 
                    	            		"UICommandMdsl");
                    	    	        afterParserOrEnumRuleCall();
                    	    	    

                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop69;
                        }
                    } while (true);


                    }
                    break;

            }

            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:3382:5: (otherlv_9= 'on error:' ( (lv_onActionErrorUICommands_10_0= ruleUICommandMdsl ) )* )?
            int alt72=2;
            int LA72_0 = input.LA(1);

            if ( (LA72_0==87) ) {
                alt72=1;
            }
            switch (alt72) {
                case 1 :
                    // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:3382:7: otherlv_9= 'on error:' ( (lv_onActionErrorUICommands_10_0= ruleUICommandMdsl ) )*
                    {
                    otherlv_9=(Token)match(input,87,FOLLOW_87_in_ruleCommandDefinitionMdsl7119); 

                        	newLeafNode(otherlv_9, grammarAccess.getCommandDefinitionMdslAccess().getOnErrorKeyword_7_0());
                        
                    // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:3386:1: ( (lv_onActionErrorUICommands_10_0= ruleUICommandMdsl ) )*
                    loop71:
                    do {
                        int alt71=2;
                        int LA71_0 = input.LA(1);

                        if ( ((LA71_0>=90 && LA71_0<=91)) ) {
                            alt71=1;
                        }


                        switch (alt71) {
                    	case 1 :
                    	    // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:3387:1: (lv_onActionErrorUICommands_10_0= ruleUICommandMdsl )
                    	    {
                    	    // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:3387:1: (lv_onActionErrorUICommands_10_0= ruleUICommandMdsl )
                    	    // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:3388:3: lv_onActionErrorUICommands_10_0= ruleUICommandMdsl
                    	    {
                    	     
                    	    	        newCompositeNode(grammarAccess.getCommandDefinitionMdslAccess().getOnActionErrorUICommandsUICommandMdslParserRuleCall_7_1_0()); 
                    	    	    
                    	    pushFollow(FOLLOW_ruleUICommandMdsl_in_ruleCommandDefinitionMdsl7140);
                    	    lv_onActionErrorUICommands_10_0=ruleUICommandMdsl();

                    	    state._fsp--;


                    	    	        if (current==null) {
                    	    	            current = createModelElementForParent(grammarAccess.getCommandDefinitionMdslRule());
                    	    	        }
                    	           		add(
                    	           			current, 
                    	           			"onActionErrorUICommands",
                    	            		lv_onActionErrorUICommands_10_0, 
                    	            		"UICommandMdsl");
                    	    	        afterParserOrEnumRuleCall();
                    	    	    

                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop71;
                        }
                    } while (true);


                    }
                    break;

            }


            }


            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleCommandDefinitionMdsl"


    // $ANTLR start "entryRuleCommandRefMdsl"
    // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:3412:1: entryRuleCommandRefMdsl returns [EObject current=null] : iv_ruleCommandRefMdsl= ruleCommandRefMdsl EOF ;
    public final EObject entryRuleCommandRefMdsl() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleCommandRefMdsl = null;


        try {
            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:3413:2: (iv_ruleCommandRefMdsl= ruleCommandRefMdsl EOF )
            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:3414:2: iv_ruleCommandRefMdsl= ruleCommandRefMdsl EOF
            {
             newCompositeNode(grammarAccess.getCommandRefMdslRule()); 
            pushFollow(FOLLOW_ruleCommandRefMdsl_in_entryRuleCommandRefMdsl7179);
            iv_ruleCommandRefMdsl=ruleCommandRefMdsl();

            state._fsp--;

             current =iv_ruleCommandRefMdsl; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleCommandRefMdsl7189); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleCommandRefMdsl"


    // $ANTLR start "ruleCommandRefMdsl"
    // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:3421:1: ruleCommandRefMdsl returns [EObject current=null] : ( ( (otherlv_0= RULE_ID ) ) (otherlv_1= '(' ( (lv_i18NLabelOverride_2_0= 'I18N' ) )? ( (lv_labelOverride_3_0= ruleFormatExpr ) ) otherlv_4= ')' )? ) ;
    public final EObject ruleCommandRefMdsl() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;
        Token lv_i18NLabelOverride_2_0=null;
        Token otherlv_4=null;
        EObject lv_labelOverride_3_0 = null;


         enterRule(); 
            
        try {
            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:3424:28: ( ( ( (otherlv_0= RULE_ID ) ) (otherlv_1= '(' ( (lv_i18NLabelOverride_2_0= 'I18N' ) )? ( (lv_labelOverride_3_0= ruleFormatExpr ) ) otherlv_4= ')' )? ) )
            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:3425:1: ( ( (otherlv_0= RULE_ID ) ) (otherlv_1= '(' ( (lv_i18NLabelOverride_2_0= 'I18N' ) )? ( (lv_labelOverride_3_0= ruleFormatExpr ) ) otherlv_4= ')' )? )
            {
            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:3425:1: ( ( (otherlv_0= RULE_ID ) ) (otherlv_1= '(' ( (lv_i18NLabelOverride_2_0= 'I18N' ) )? ( (lv_labelOverride_3_0= ruleFormatExpr ) ) otherlv_4= ')' )? )
            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:3425:2: ( (otherlv_0= RULE_ID ) ) (otherlv_1= '(' ( (lv_i18NLabelOverride_2_0= 'I18N' ) )? ( (lv_labelOverride_3_0= ruleFormatExpr ) ) otherlv_4= ')' )?
            {
            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:3425:2: ( (otherlv_0= RULE_ID ) )
            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:3426:1: (otherlv_0= RULE_ID )
            {
            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:3426:1: (otherlv_0= RULE_ID )
            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:3427:3: otherlv_0= RULE_ID
            {

            			if (current==null) {
            	            current = createModelElement(grammarAccess.getCommandRefMdslRule());
            	        }
                    
            otherlv_0=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleCommandRefMdsl7234); 

            		newLeafNode(otherlv_0, grammarAccess.getCommandRefMdslAccess().getReferencedCommandDeclarationCrossReference_0_0()); 
            	

            }


            }

            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:3438:2: (otherlv_1= '(' ( (lv_i18NLabelOverride_2_0= 'I18N' ) )? ( (lv_labelOverride_3_0= ruleFormatExpr ) ) otherlv_4= ')' )?
            int alt74=2;
            int LA74_0 = input.LA(1);

            if ( (LA74_0==88) ) {
                alt74=1;
            }
            switch (alt74) {
                case 1 :
                    // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:3438:4: otherlv_1= '(' ( (lv_i18NLabelOverride_2_0= 'I18N' ) )? ( (lv_labelOverride_3_0= ruleFormatExpr ) ) otherlv_4= ')'
                    {
                    otherlv_1=(Token)match(input,88,FOLLOW_88_in_ruleCommandRefMdsl7247); 

                        	newLeafNode(otherlv_1, grammarAccess.getCommandRefMdslAccess().getLeftParenthesisKeyword_1_0());
                        
                    // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:3442:1: ( (lv_i18NLabelOverride_2_0= 'I18N' ) )?
                    int alt73=2;
                    int LA73_0 = input.LA(1);

                    if ( (LA73_0==52) ) {
                        alt73=1;
                    }
                    switch (alt73) {
                        case 1 :
                            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:3443:1: (lv_i18NLabelOverride_2_0= 'I18N' )
                            {
                            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:3443:1: (lv_i18NLabelOverride_2_0= 'I18N' )
                            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:3444:3: lv_i18NLabelOverride_2_0= 'I18N'
                            {
                            lv_i18NLabelOverride_2_0=(Token)match(input,52,FOLLOW_52_in_ruleCommandRefMdsl7265); 

                                    newLeafNode(lv_i18NLabelOverride_2_0, grammarAccess.getCommandRefMdslAccess().getI18NLabelOverrideI18NKeyword_1_1_0());
                                

                            	        if (current==null) {
                            	            current = createModelElement(grammarAccess.getCommandRefMdslRule());
                            	        }
                                   		setWithLastConsumed(current, "i18NLabelOverride", true, "I18N");
                            	    

                            }


                            }
                            break;

                    }

                    // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:3457:3: ( (lv_labelOverride_3_0= ruleFormatExpr ) )
                    // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:3458:1: (lv_labelOverride_3_0= ruleFormatExpr )
                    {
                    // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:3458:1: (lv_labelOverride_3_0= ruleFormatExpr )
                    // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:3459:3: lv_labelOverride_3_0= ruleFormatExpr
                    {
                     
                    	        newCompositeNode(grammarAccess.getCommandRefMdslAccess().getLabelOverrideFormatExprParserRuleCall_1_2_0()); 
                    	    
                    pushFollow(FOLLOW_ruleFormatExpr_in_ruleCommandRefMdsl7300);
                    lv_labelOverride_3_0=ruleFormatExpr();

                    state._fsp--;


                    	        if (current==null) {
                    	            current = createModelElementForParent(grammarAccess.getCommandRefMdslRule());
                    	        }
                           		set(
                           			current, 
                           			"labelOverride",
                            		lv_labelOverride_3_0, 
                            		"FormatExpr");
                    	        afterParserOrEnumRuleCall();
                    	    

                    }


                    }

                    otherlv_4=(Token)match(input,89,FOLLOW_89_in_ruleCommandRefMdsl7312); 

                        	newLeafNode(otherlv_4, grammarAccess.getCommandRefMdslAccess().getRightParenthesisKeyword_1_3());
                        

                    }
                    break;

            }


            }


            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleCommandRefMdsl"


    // $ANTLR start "entryRuleUICommandMdsl"
    // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:3487:1: entryRuleUICommandMdsl returns [EObject current=null] : iv_ruleUICommandMdsl= ruleUICommandMdsl EOF ;
    public final EObject entryRuleUICommandMdsl() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleUICommandMdsl = null;


        try {
            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:3488:2: (iv_ruleUICommandMdsl= ruleUICommandMdsl EOF )
            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:3489:2: iv_ruleUICommandMdsl= ruleUICommandMdsl EOF
            {
             newCompositeNode(grammarAccess.getUICommandMdslRule()); 
            pushFollow(FOLLOW_ruleUICommandMdsl_in_entryRuleUICommandMdsl7350);
            iv_ruleUICommandMdsl=ruleUICommandMdsl();

            state._fsp--;

             current =iv_ruleUICommandMdsl; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleUICommandMdsl7360); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleUICommandMdsl"


    // $ANTLR start "ruleUICommandMdsl"
    // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:3496:1: ruleUICommandMdsl returns [EObject current=null] : (this_ReloadWidgetsUICommand_0= ruleReloadWidgetsUICommand | this_ReloadViewUICommand_1= ruleReloadViewUICommand | this_DisplayViewUICommand_2= ruleDisplayViewUICommand ) ;
    public final EObject ruleUICommandMdsl() throws RecognitionException {
        EObject current = null;

        EObject this_ReloadWidgetsUICommand_0 = null;

        EObject this_ReloadViewUICommand_1 = null;

        EObject this_DisplayViewUICommand_2 = null;


         enterRule(); 
            
        try {
            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:3499:28: ( (this_ReloadWidgetsUICommand_0= ruleReloadWidgetsUICommand | this_ReloadViewUICommand_1= ruleReloadViewUICommand | this_DisplayViewUICommand_2= ruleDisplayViewUICommand ) )
            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:3500:1: (this_ReloadWidgetsUICommand_0= ruleReloadWidgetsUICommand | this_ReloadViewUICommand_1= ruleReloadViewUICommand | this_DisplayViewUICommand_2= ruleDisplayViewUICommand )
            {
            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:3500:1: (this_ReloadWidgetsUICommand_0= ruleReloadWidgetsUICommand | this_ReloadViewUICommand_1= ruleReloadViewUICommand | this_DisplayViewUICommand_2= ruleDisplayViewUICommand )
            int alt75=3;
            int LA75_0 = input.LA(1);

            if ( (LA75_0==91) ) {
                int LA75_1 = input.LA(2);

                if ( (LA75_1==93) ) {
                    alt75=1;
                }
                else if ( (LA75_1==92) ) {
                    alt75=2;
                }
                else {
                    NoViableAltException nvae =
                        new NoViableAltException("", 75, 1, input);

                    throw nvae;
                }
            }
            else if ( (LA75_0==90) ) {
                alt75=3;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 75, 0, input);

                throw nvae;
            }
            switch (alt75) {
                case 1 :
                    // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:3501:5: this_ReloadWidgetsUICommand_0= ruleReloadWidgetsUICommand
                    {
                     
                            newCompositeNode(grammarAccess.getUICommandMdslAccess().getReloadWidgetsUICommandParserRuleCall_0()); 
                        
                    pushFollow(FOLLOW_ruleReloadWidgetsUICommand_in_ruleUICommandMdsl7407);
                    this_ReloadWidgetsUICommand_0=ruleReloadWidgetsUICommand();

                    state._fsp--;

                     
                            current = this_ReloadWidgetsUICommand_0; 
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;
                case 2 :
                    // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:3511:5: this_ReloadViewUICommand_1= ruleReloadViewUICommand
                    {
                     
                            newCompositeNode(grammarAccess.getUICommandMdslAccess().getReloadViewUICommandParserRuleCall_1()); 
                        
                    pushFollow(FOLLOW_ruleReloadViewUICommand_in_ruleUICommandMdsl7434);
                    this_ReloadViewUICommand_1=ruleReloadViewUICommand();

                    state._fsp--;

                     
                            current = this_ReloadViewUICommand_1; 
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;
                case 3 :
                    // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:3521:5: this_DisplayViewUICommand_2= ruleDisplayViewUICommand
                    {
                     
                            newCompositeNode(grammarAccess.getUICommandMdslAccess().getDisplayViewUICommandParserRuleCall_2()); 
                        
                    pushFollow(FOLLOW_ruleDisplayViewUICommand_in_ruleUICommandMdsl7461);
                    this_DisplayViewUICommand_2=ruleDisplayViewUICommand();

                    state._fsp--;

                     
                            current = this_DisplayViewUICommand_2; 
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;

            }


            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleUICommandMdsl"


    // $ANTLR start "entryRuleDisplayViewUICommand"
    // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:3537:1: entryRuleDisplayViewUICommand returns [EObject current=null] : iv_ruleDisplayViewUICommand= ruleDisplayViewUICommand EOF ;
    public final EObject entryRuleDisplayViewUICommand() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleDisplayViewUICommand = null;


        try {
            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:3538:2: (iv_ruleDisplayViewUICommand= ruleDisplayViewUICommand EOF )
            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:3539:2: iv_ruleDisplayViewUICommand= ruleDisplayViewUICommand EOF
            {
             newCompositeNode(grammarAccess.getDisplayViewUICommandRule()); 
            pushFollow(FOLLOW_ruleDisplayViewUICommand_in_entryRuleDisplayViewUICommand7496);
            iv_ruleDisplayViewUICommand=ruleDisplayViewUICommand();

            state._fsp--;

             current =iv_ruleDisplayViewUICommand; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleDisplayViewUICommand7506); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleDisplayViewUICommand"


    // $ANTLR start "ruleDisplayViewUICommand"
    // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:3546:1: ruleDisplayViewUICommand returns [EObject current=null] : (otherlv_0= 'Display view' (otherlv_1= 'for' ( (lv_target_2_0= ruleQueryUsage ) ) )? ) ;
    public final EObject ruleDisplayViewUICommand() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;
        EObject lv_target_2_0 = null;


         enterRule(); 
            
        try {
            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:3549:28: ( (otherlv_0= 'Display view' (otherlv_1= 'for' ( (lv_target_2_0= ruleQueryUsage ) ) )? ) )
            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:3550:1: (otherlv_0= 'Display view' (otherlv_1= 'for' ( (lv_target_2_0= ruleQueryUsage ) ) )? )
            {
            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:3550:1: (otherlv_0= 'Display view' (otherlv_1= 'for' ( (lv_target_2_0= ruleQueryUsage ) ) )? )
            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:3550:3: otherlv_0= 'Display view' (otherlv_1= 'for' ( (lv_target_2_0= ruleQueryUsage ) ) )?
            {
            otherlv_0=(Token)match(input,90,FOLLOW_90_in_ruleDisplayViewUICommand7543); 

                	newLeafNode(otherlv_0, grammarAccess.getDisplayViewUICommandAccess().getDisplayViewKeyword_0());
                
            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:3554:1: (otherlv_1= 'for' ( (lv_target_2_0= ruleQueryUsage ) ) )?
            int alt76=2;
            int LA76_0 = input.LA(1);

            if ( (LA76_0==58) ) {
                alt76=1;
            }
            switch (alt76) {
                case 1 :
                    // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:3554:3: otherlv_1= 'for' ( (lv_target_2_0= ruleQueryUsage ) )
                    {
                    otherlv_1=(Token)match(input,58,FOLLOW_58_in_ruleDisplayViewUICommand7556); 

                        	newLeafNode(otherlv_1, grammarAccess.getDisplayViewUICommandAccess().getForKeyword_1_0());
                        
                    // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:3558:1: ( (lv_target_2_0= ruleQueryUsage ) )
                    // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:3559:1: (lv_target_2_0= ruleQueryUsage )
                    {
                    // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:3559:1: (lv_target_2_0= ruleQueryUsage )
                    // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:3560:3: lv_target_2_0= ruleQueryUsage
                    {
                     
                    	        newCompositeNode(grammarAccess.getDisplayViewUICommandAccess().getTargetQueryUsageParserRuleCall_1_1_0()); 
                    	    
                    pushFollow(FOLLOW_ruleQueryUsage_in_ruleDisplayViewUICommand7577);
                    lv_target_2_0=ruleQueryUsage();

                    state._fsp--;


                    	        if (current==null) {
                    	            current = createModelElementForParent(grammarAccess.getDisplayViewUICommandRule());
                    	        }
                           		set(
                           			current, 
                           			"target",
                            		lv_target_2_0, 
                            		"QueryUsage");
                    	        afterParserOrEnumRuleCall();
                    	    

                    }


                    }


                    }
                    break;

            }


            }


            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleDisplayViewUICommand"


    // $ANTLR start "entryRuleReloadViewUICommand"
    // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:3584:1: entryRuleReloadViewUICommand returns [EObject current=null] : iv_ruleReloadViewUICommand= ruleReloadViewUICommand EOF ;
    public final EObject entryRuleReloadViewUICommand() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleReloadViewUICommand = null;


        try {
            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:3585:2: (iv_ruleReloadViewUICommand= ruleReloadViewUICommand EOF )
            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:3586:2: iv_ruleReloadViewUICommand= ruleReloadViewUICommand EOF
            {
             newCompositeNode(grammarAccess.getReloadViewUICommandRule()); 
            pushFollow(FOLLOW_ruleReloadViewUICommand_in_entryRuleReloadViewUICommand7615);
            iv_ruleReloadViewUICommand=ruleReloadViewUICommand();

            state._fsp--;

             current =iv_ruleReloadViewUICommand; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleReloadViewUICommand7625); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleReloadViewUICommand"


    // $ANTLR start "ruleReloadViewUICommand"
    // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:3593:1: ruleReloadViewUICommand returns [EObject current=null] : ( () otherlv_1= 'Reload' otherlv_2= 'view' ) ;
    public final EObject ruleReloadViewUICommand() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_2=null;

         enterRule(); 
            
        try {
            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:3596:28: ( ( () otherlv_1= 'Reload' otherlv_2= 'view' ) )
            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:3597:1: ( () otherlv_1= 'Reload' otherlv_2= 'view' )
            {
            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:3597:1: ( () otherlv_1= 'Reload' otherlv_2= 'view' )
            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:3597:2: () otherlv_1= 'Reload' otherlv_2= 'view'
            {
            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:3597:2: ()
            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:3598:5: 
            {

                    current = forceCreateModelElement(
                        grammarAccess.getReloadViewUICommandAccess().getReloadViewUICommandAction_0(),
                        current);
                

            }

            otherlv_1=(Token)match(input,91,FOLLOW_91_in_ruleReloadViewUICommand7671); 

                	newLeafNode(otherlv_1, grammarAccess.getReloadViewUICommandAccess().getReloadKeyword_1());
                
            otherlv_2=(Token)match(input,92,FOLLOW_92_in_ruleReloadViewUICommand7683); 

                	newLeafNode(otherlv_2, grammarAccess.getReloadViewUICommandAccess().getViewKeyword_2());
                

            }


            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleReloadViewUICommand"


    // $ANTLR start "entryRuleReloadWidgetsUICommand"
    // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:3619:1: entryRuleReloadWidgetsUICommand returns [EObject current=null] : iv_ruleReloadWidgetsUICommand= ruleReloadWidgetsUICommand EOF ;
    public final EObject entryRuleReloadWidgetsUICommand() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleReloadWidgetsUICommand = null;


        try {
            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:3620:2: (iv_ruleReloadWidgetsUICommand= ruleReloadWidgetsUICommand EOF )
            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:3621:2: iv_ruleReloadWidgetsUICommand= ruleReloadWidgetsUICommand EOF
            {
             newCompositeNode(grammarAccess.getReloadWidgetsUICommandRule()); 
            pushFollow(FOLLOW_ruleReloadWidgetsUICommand_in_entryRuleReloadWidgetsUICommand7719);
            iv_ruleReloadWidgetsUICommand=ruleReloadWidgetsUICommand();

            state._fsp--;

             current =iv_ruleReloadWidgetsUICommand; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleReloadWidgetsUICommand7729); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleReloadWidgetsUICommand"


    // $ANTLR start "ruleReloadWidgetsUICommand"
    // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:3628:1: ruleReloadWidgetsUICommand returns [EObject current=null] : (otherlv_0= 'Reload' otherlv_1= 'widgets:' ( (otherlv_2= RULE_ID ) )* ) ;
    public final EObject ruleReloadWidgetsUICommand() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;
        Token otherlv_2=null;

         enterRule(); 
            
        try {
            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:3631:28: ( (otherlv_0= 'Reload' otherlv_1= 'widgets:' ( (otherlv_2= RULE_ID ) )* ) )
            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:3632:1: (otherlv_0= 'Reload' otherlv_1= 'widgets:' ( (otherlv_2= RULE_ID ) )* )
            {
            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:3632:1: (otherlv_0= 'Reload' otherlv_1= 'widgets:' ( (otherlv_2= RULE_ID ) )* )
            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:3632:3: otherlv_0= 'Reload' otherlv_1= 'widgets:' ( (otherlv_2= RULE_ID ) )*
            {
            otherlv_0=(Token)match(input,91,FOLLOW_91_in_ruleReloadWidgetsUICommand7766); 

                	newLeafNode(otherlv_0, grammarAccess.getReloadWidgetsUICommandAccess().getReloadKeyword_0());
                
            otherlv_1=(Token)match(input,93,FOLLOW_93_in_ruleReloadWidgetsUICommand7778); 

                	newLeafNode(otherlv_1, grammarAccess.getReloadWidgetsUICommandAccess().getWidgetsKeyword_1());
                
            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:3640:1: ( (otherlv_2= RULE_ID ) )*
            loop77:
            do {
                int alt77=2;
                int LA77_0 = input.LA(1);

                if ( (LA77_0==RULE_ID) ) {
                    alt77=1;
                }


                switch (alt77) {
            	case 1 :
            	    // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:3641:1: (otherlv_2= RULE_ID )
            	    {
            	    // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:3641:1: (otherlv_2= RULE_ID )
            	    // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:3642:3: otherlv_2= RULE_ID
            	    {

            	    			if (current==null) {
            	    	            current = createModelElement(grammarAccess.getReloadWidgetsUICommandRule());
            	    	        }
            	            
            	    otherlv_2=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleReloadWidgetsUICommand7798); 

            	    		newLeafNode(otherlv_2, grammarAccess.getReloadWidgetsUICommandAccess().getWidgetsToReloadWidgetConfigurationMdslCrossReference_2_0()); 
            	    	

            	    }


            	    }
            	    break;

            	default :
            	    break loop77;
                }
            } while (true);


            }


            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleReloadWidgetsUICommand"


    // $ANTLR start "entryRuleQueryUsage"
    // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:3661:1: entryRuleQueryUsage returns [EObject current=null] : iv_ruleQueryUsage= ruleQueryUsage EOF ;
    public final EObject entryRuleQueryUsage() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleQueryUsage = null;


        try {
            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:3662:2: (iv_ruleQueryUsage= ruleQueryUsage EOF )
            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:3663:2: iv_ruleQueryUsage= ruleQueryUsage EOF
            {
             newCompositeNode(grammarAccess.getQueryUsageRule()); 
            pushFollow(FOLLOW_ruleQueryUsage_in_entryRuleQueryUsage7835);
            iv_ruleQueryUsage=ruleQueryUsage();

            state._fsp--;

             current =iv_ruleQueryUsage; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleQueryUsage7845); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleQueryUsage"


    // $ANTLR start "ruleQueryUsage"
    // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:3670:1: ruleQueryUsage returns [EObject current=null] : (this_Query_0= ruleQuery | this_QueryChain_1= ruleQueryChain ) ;
    public final EObject ruleQueryUsage() throws RecognitionException {
        EObject current = null;

        EObject this_Query_0 = null;

        EObject this_QueryChain_1 = null;


         enterRule(); 
            
        try {
            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:3673:28: ( (this_Query_0= ruleQuery | this_QueryChain_1= ruleQueryChain ) )
            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:3674:1: (this_Query_0= ruleQuery | this_QueryChain_1= ruleQueryChain )
            {
            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:3674:1: (this_Query_0= ruleQuery | this_QueryChain_1= ruleQueryChain )
            int alt78=2;
            int LA78_0 = input.LA(1);

            if ( ((LA78_0>=RULE_STRING && LA78_0<=RULE_ID)||(LA78_0>=95 && LA78_0<=97)||LA78_0==100||LA78_0==104) ) {
                alt78=1;
            }
            else if ( (LA78_0==102) ) {
                alt78=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 78, 0, input);

                throw nvae;
            }
            switch (alt78) {
                case 1 :
                    // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:3675:5: this_Query_0= ruleQuery
                    {
                     
                            newCompositeNode(grammarAccess.getQueryUsageAccess().getQueryParserRuleCall_0()); 
                        
                    pushFollow(FOLLOW_ruleQuery_in_ruleQueryUsage7892);
                    this_Query_0=ruleQuery();

                    state._fsp--;

                     
                            current = this_Query_0; 
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;
                case 2 :
                    // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:3685:5: this_QueryChain_1= ruleQueryChain
                    {
                     
                            newCompositeNode(grammarAccess.getQueryUsageAccess().getQueryChainParserRuleCall_1()); 
                        
                    pushFollow(FOLLOW_ruleQueryChain_in_ruleQueryUsage7919);
                    this_QueryChain_1=ruleQueryChain();

                    state._fsp--;

                     
                            current = this_QueryChain_1; 
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;

            }


            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleQueryUsage"


    // $ANTLR start "entryRuleQuery"
    // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:3701:1: entryRuleQuery returns [EObject current=null] : iv_ruleQuery= ruleQuery EOF ;
    public final EObject entryRuleQuery() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleQuery = null;


        try {
            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:3702:2: (iv_ruleQuery= ruleQuery EOF )
            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:3703:2: iv_ruleQuery= ruleQuery EOF
            {
             newCompositeNode(grammarAccess.getQueryRule()); 
            pushFollow(FOLLOW_ruleQuery_in_entryRuleQuery7954);
            iv_ruleQuery=ruleQuery();

            state._fsp--;

             current =iv_ruleQuery; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleQuery7964); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleQuery"


    // $ANTLR start "ruleQuery"
    // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:3710:1: ruleQuery returns [EObject current=null] : (this_QueryDefinitionMdsl_0= ruleQueryDefinitionMdsl | this_QueryRefMdsl_1= ruleQueryRefMdsl ) ;
    public final EObject ruleQuery() throws RecognitionException {
        EObject current = null;

        EObject this_QueryDefinitionMdsl_0 = null;

        EObject this_QueryRefMdsl_1 = null;


         enterRule(); 
            
        try {
            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:3713:28: ( (this_QueryDefinitionMdsl_0= ruleQueryDefinitionMdsl | this_QueryRefMdsl_1= ruleQueryRefMdsl ) )
            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:3714:1: (this_QueryDefinitionMdsl_0= ruleQueryDefinitionMdsl | this_QueryRefMdsl_1= ruleQueryRefMdsl )
            {
            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:3714:1: (this_QueryDefinitionMdsl_0= ruleQueryDefinitionMdsl | this_QueryRefMdsl_1= ruleQueryRefMdsl )
            int alt79=2;
            int LA79_0 = input.LA(1);

            if ( (LA79_0==RULE_STRING||(LA79_0>=95 && LA79_0<=97)||LA79_0==100||LA79_0==104) ) {
                alt79=1;
            }
            else if ( (LA79_0==RULE_ID) ) {
                alt79=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 79, 0, input);

                throw nvae;
            }
            switch (alt79) {
                case 1 :
                    // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:3715:5: this_QueryDefinitionMdsl_0= ruleQueryDefinitionMdsl
                    {
                     
                            newCompositeNode(grammarAccess.getQueryAccess().getQueryDefinitionMdslParserRuleCall_0()); 
                        
                    pushFollow(FOLLOW_ruleQueryDefinitionMdsl_in_ruleQuery8011);
                    this_QueryDefinitionMdsl_0=ruleQueryDefinitionMdsl();

                    state._fsp--;

                     
                            current = this_QueryDefinitionMdsl_0; 
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;
                case 2 :
                    // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:3725:5: this_QueryRefMdsl_1= ruleQueryRefMdsl
                    {
                     
                            newCompositeNode(grammarAccess.getQueryAccess().getQueryRefMdslParserRuleCall_1()); 
                        
                    pushFollow(FOLLOW_ruleQueryRefMdsl_in_ruleQuery8038);
                    this_QueryRefMdsl_1=ruleQueryRefMdsl();

                    state._fsp--;

                     
                            current = this_QueryRefMdsl_1; 
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;

            }


            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleQuery"


    // $ANTLR start "entryRuleQueryDeclaration"
    // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:3741:1: entryRuleQueryDeclaration returns [EObject current=null] : iv_ruleQueryDeclaration= ruleQueryDeclaration EOF ;
    public final EObject entryRuleQueryDeclaration() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleQueryDeclaration = null;


        try {
            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:3742:2: (iv_ruleQueryDeclaration= ruleQueryDeclaration EOF )
            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:3743:2: iv_ruleQueryDeclaration= ruleQueryDeclaration EOF
            {
             newCompositeNode(grammarAccess.getQueryDeclarationRule()); 
            pushFollow(FOLLOW_ruleQueryDeclaration_in_entryRuleQueryDeclaration8073);
            iv_ruleQueryDeclaration=ruleQueryDeclaration();

            state._fsp--;

             current =iv_ruleQueryDeclaration; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleQueryDeclaration8083); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleQueryDeclaration"


    // $ANTLR start "ruleQueryDeclaration"
    // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:3750:1: ruleQueryDeclaration returns [EObject current=null] : (otherlv_0= 'Common Query' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' (otherlv_3= 'label:' ( (lv_label_4_0= RULE_STRING ) ) )? (otherlv_5= 'description:' ( (lv_description_6_0= RULE_STRING ) ) )? ( (lv_definition_7_0= ruleQueryDefinitionMdsl ) ) otherlv_8= '}' ) ;
    public final EObject ruleQueryDeclaration() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token lv_name_1_0=null;
        Token otherlv_2=null;
        Token otherlv_3=null;
        Token lv_label_4_0=null;
        Token otherlv_5=null;
        Token lv_description_6_0=null;
        Token otherlv_8=null;
        EObject lv_definition_7_0 = null;


         enterRule(); 
            
        try {
            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:3753:28: ( (otherlv_0= 'Common Query' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' (otherlv_3= 'label:' ( (lv_label_4_0= RULE_STRING ) ) )? (otherlv_5= 'description:' ( (lv_description_6_0= RULE_STRING ) ) )? ( (lv_definition_7_0= ruleQueryDefinitionMdsl ) ) otherlv_8= '}' ) )
            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:3754:1: (otherlv_0= 'Common Query' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' (otherlv_3= 'label:' ( (lv_label_4_0= RULE_STRING ) ) )? (otherlv_5= 'description:' ( (lv_description_6_0= RULE_STRING ) ) )? ( (lv_definition_7_0= ruleQueryDefinitionMdsl ) ) otherlv_8= '}' )
            {
            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:3754:1: (otherlv_0= 'Common Query' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' (otherlv_3= 'label:' ( (lv_label_4_0= RULE_STRING ) ) )? (otherlv_5= 'description:' ( (lv_description_6_0= RULE_STRING ) ) )? ( (lv_definition_7_0= ruleQueryDefinitionMdsl ) ) otherlv_8= '}' )
            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:3754:3: otherlv_0= 'Common Query' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' (otherlv_3= 'label:' ( (lv_label_4_0= RULE_STRING ) ) )? (otherlv_5= 'description:' ( (lv_description_6_0= RULE_STRING ) ) )? ( (lv_definition_7_0= ruleQueryDefinitionMdsl ) ) otherlv_8= '}'
            {
            otherlv_0=(Token)match(input,94,FOLLOW_94_in_ruleQueryDeclaration8120); 

                	newLeafNode(otherlv_0, grammarAccess.getQueryDeclarationAccess().getCommonQueryKeyword_0());
                
            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:3758:1: ( (lv_name_1_0= RULE_ID ) )
            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:3759:1: (lv_name_1_0= RULE_ID )
            {
            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:3759:1: (lv_name_1_0= RULE_ID )
            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:3760:3: lv_name_1_0= RULE_ID
            {
            lv_name_1_0=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleQueryDeclaration8137); 

            			newLeafNode(lv_name_1_0, grammarAccess.getQueryDeclarationAccess().getNameIDTerminalRuleCall_1_0()); 
            		

            	        if (current==null) {
            	            current = createModelElement(grammarAccess.getQueryDeclarationRule());
            	        }
                   		setWithLastConsumed(
                   			current, 
                   			"name",
                    		lv_name_1_0, 
                    		"ID");
            	    

            }


            }

            otherlv_2=(Token)match(input,22,FOLLOW_22_in_ruleQueryDeclaration8154); 

                	newLeafNode(otherlv_2, grammarAccess.getQueryDeclarationAccess().getLeftCurlyBracketKeyword_2());
                
            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:3780:1: (otherlv_3= 'label:' ( (lv_label_4_0= RULE_STRING ) ) )?
            int alt80=2;
            int LA80_0 = input.LA(1);

            if ( (LA80_0==13) ) {
                alt80=1;
            }
            switch (alt80) {
                case 1 :
                    // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:3780:3: otherlv_3= 'label:' ( (lv_label_4_0= RULE_STRING ) )
                    {
                    otherlv_3=(Token)match(input,13,FOLLOW_13_in_ruleQueryDeclaration8167); 

                        	newLeafNode(otherlv_3, grammarAccess.getQueryDeclarationAccess().getLabelKeyword_3_0());
                        
                    // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:3784:1: ( (lv_label_4_0= RULE_STRING ) )
                    // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:3785:1: (lv_label_4_0= RULE_STRING )
                    {
                    // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:3785:1: (lv_label_4_0= RULE_STRING )
                    // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:3786:3: lv_label_4_0= RULE_STRING
                    {
                    lv_label_4_0=(Token)match(input,RULE_STRING,FOLLOW_RULE_STRING_in_ruleQueryDeclaration8184); 

                    			newLeafNode(lv_label_4_0, grammarAccess.getQueryDeclarationAccess().getLabelSTRINGTerminalRuleCall_3_1_0()); 
                    		

                    	        if (current==null) {
                    	            current = createModelElement(grammarAccess.getQueryDeclarationRule());
                    	        }
                           		setWithLastConsumed(
                           			current, 
                           			"label",
                            		lv_label_4_0, 
                            		"STRING");
                    	    

                    }


                    }


                    }
                    break;

            }

            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:3802:4: (otherlv_5= 'description:' ( (lv_description_6_0= RULE_STRING ) ) )?
            int alt81=2;
            int LA81_0 = input.LA(1);

            if ( (LA81_0==17) ) {
                alt81=1;
            }
            switch (alt81) {
                case 1 :
                    // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:3802:6: otherlv_5= 'description:' ( (lv_description_6_0= RULE_STRING ) )
                    {
                    otherlv_5=(Token)match(input,17,FOLLOW_17_in_ruleQueryDeclaration8204); 

                        	newLeafNode(otherlv_5, grammarAccess.getQueryDeclarationAccess().getDescriptionKeyword_4_0());
                        
                    // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:3806:1: ( (lv_description_6_0= RULE_STRING ) )
                    // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:3807:1: (lv_description_6_0= RULE_STRING )
                    {
                    // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:3807:1: (lv_description_6_0= RULE_STRING )
                    // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:3808:3: lv_description_6_0= RULE_STRING
                    {
                    lv_description_6_0=(Token)match(input,RULE_STRING,FOLLOW_RULE_STRING_in_ruleQueryDeclaration8221); 

                    			newLeafNode(lv_description_6_0, grammarAccess.getQueryDeclarationAccess().getDescriptionSTRINGTerminalRuleCall_4_1_0()); 
                    		

                    	        if (current==null) {
                    	            current = createModelElement(grammarAccess.getQueryDeclarationRule());
                    	        }
                           		setWithLastConsumed(
                           			current, 
                           			"description",
                            		lv_description_6_0, 
                            		"STRING");
                    	    

                    }


                    }


                    }
                    break;

            }

            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:3824:4: ( (lv_definition_7_0= ruleQueryDefinitionMdsl ) )
            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:3825:1: (lv_definition_7_0= ruleQueryDefinitionMdsl )
            {
            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:3825:1: (lv_definition_7_0= ruleQueryDefinitionMdsl )
            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:3826:3: lv_definition_7_0= ruleQueryDefinitionMdsl
            {
             
            	        newCompositeNode(grammarAccess.getQueryDeclarationAccess().getDefinitionQueryDefinitionMdslParserRuleCall_5_0()); 
            	    
            pushFollow(FOLLOW_ruleQueryDefinitionMdsl_in_ruleQueryDeclaration8249);
            lv_definition_7_0=ruleQueryDefinitionMdsl();

            state._fsp--;


            	        if (current==null) {
            	            current = createModelElementForParent(grammarAccess.getQueryDeclarationRule());
            	        }
                   		set(
                   			current, 
                   			"definition",
                    		lv_definition_7_0, 
                    		"QueryDefinitionMdsl");
            	        afterParserOrEnumRuleCall();
            	    

            }


            }

            otherlv_8=(Token)match(input,28,FOLLOW_28_in_ruleQueryDeclaration8261); 

                	newLeafNode(otherlv_8, grammarAccess.getQueryDeclarationAccess().getRightCurlyBracketKeyword_6());
                

            }


            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleQueryDeclaration"


    // $ANTLR start "entryRuleQueryDefinitionMdsl"
    // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:3854:1: entryRuleQueryDefinitionMdsl returns [EObject current=null] : iv_ruleQueryDefinitionMdsl= ruleQueryDefinitionMdsl EOF ;
    public final EObject entryRuleQueryDefinitionMdsl() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleQueryDefinitionMdsl = null;


        try {
            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:3855:2: (iv_ruleQueryDefinitionMdsl= ruleQueryDefinitionMdsl EOF )
            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:3856:2: iv_ruleQueryDefinitionMdsl= ruleQueryDefinitionMdsl EOF
            {
             newCompositeNode(grammarAccess.getQueryDefinitionMdslRule()); 
            pushFollow(FOLLOW_ruleQueryDefinitionMdsl_in_entryRuleQueryDefinitionMdsl8297);
            iv_ruleQueryDefinitionMdsl=ruleQueryDefinitionMdsl();

            state._fsp--;

             current =iv_ruleQueryDefinitionMdsl; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleQueryDefinitionMdsl8307); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleQueryDefinitionMdsl"


    // $ANTLR start "ruleQueryDefinitionMdsl"
    // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:3863:1: ruleQueryDefinitionMdsl returns [EObject current=null] : ( (otherlv_0= 'language:' ( (otherlv_1= RULE_ID ) ) )? (otherlv_2= 'foreign model:' ( (otherlv_3= RULE_ID ) ) )? (otherlv_4= 'context locator:' ( (lv_contextLocator_5_0= RULE_STRING ) ) )? ( ( (lv_query_6_0= ruleQueryBody ) ) | ( (lv_externalQueryCall_7_0= ruleExternalQueryCallMdsl ) ) ) (otherlv_8= ':' ( (otherlv_9= RULE_ID ) ) )? (otherlv_10= 'properties:' ( (lv_properties_11_0= rulePropertyMdsl ) ) (otherlv_12= ',' ( (lv_properties_13_0= rulePropertyMdsl ) ) )* )? (otherlv_14= 'Optimisation:' ( (lv_optimisationLevel_15_0= ruleQUERY_OPTIMISATION_LEVEL ) ) )? ) ;
    public final EObject ruleQueryDefinitionMdsl() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;
        Token otherlv_2=null;
        Token otherlv_3=null;
        Token otherlv_4=null;
        Token lv_contextLocator_5_0=null;
        Token otherlv_8=null;
        Token otherlv_9=null;
        Token otherlv_10=null;
        Token otherlv_12=null;
        Token otherlv_14=null;
        EObject lv_query_6_0 = null;

        EObject lv_externalQueryCall_7_0 = null;

        EObject lv_properties_11_0 = null;

        EObject lv_properties_13_0 = null;

        Enumerator lv_optimisationLevel_15_0 = null;


         enterRule(); 
            
        try {
            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:3866:28: ( ( (otherlv_0= 'language:' ( (otherlv_1= RULE_ID ) ) )? (otherlv_2= 'foreign model:' ( (otherlv_3= RULE_ID ) ) )? (otherlv_4= 'context locator:' ( (lv_contextLocator_5_0= RULE_STRING ) ) )? ( ( (lv_query_6_0= ruleQueryBody ) ) | ( (lv_externalQueryCall_7_0= ruleExternalQueryCallMdsl ) ) ) (otherlv_8= ':' ( (otherlv_9= RULE_ID ) ) )? (otherlv_10= 'properties:' ( (lv_properties_11_0= rulePropertyMdsl ) ) (otherlv_12= ',' ( (lv_properties_13_0= rulePropertyMdsl ) ) )* )? (otherlv_14= 'Optimisation:' ( (lv_optimisationLevel_15_0= ruleQUERY_OPTIMISATION_LEVEL ) ) )? ) )
            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:3867:1: ( (otherlv_0= 'language:' ( (otherlv_1= RULE_ID ) ) )? (otherlv_2= 'foreign model:' ( (otherlv_3= RULE_ID ) ) )? (otherlv_4= 'context locator:' ( (lv_contextLocator_5_0= RULE_STRING ) ) )? ( ( (lv_query_6_0= ruleQueryBody ) ) | ( (lv_externalQueryCall_7_0= ruleExternalQueryCallMdsl ) ) ) (otherlv_8= ':' ( (otherlv_9= RULE_ID ) ) )? (otherlv_10= 'properties:' ( (lv_properties_11_0= rulePropertyMdsl ) ) (otherlv_12= ',' ( (lv_properties_13_0= rulePropertyMdsl ) ) )* )? (otherlv_14= 'Optimisation:' ( (lv_optimisationLevel_15_0= ruleQUERY_OPTIMISATION_LEVEL ) ) )? )
            {
            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:3867:1: ( (otherlv_0= 'language:' ( (otherlv_1= RULE_ID ) ) )? (otherlv_2= 'foreign model:' ( (otherlv_3= RULE_ID ) ) )? (otherlv_4= 'context locator:' ( (lv_contextLocator_5_0= RULE_STRING ) ) )? ( ( (lv_query_6_0= ruleQueryBody ) ) | ( (lv_externalQueryCall_7_0= ruleExternalQueryCallMdsl ) ) ) (otherlv_8= ':' ( (otherlv_9= RULE_ID ) ) )? (otherlv_10= 'properties:' ( (lv_properties_11_0= rulePropertyMdsl ) ) (otherlv_12= ',' ( (lv_properties_13_0= rulePropertyMdsl ) ) )* )? (otherlv_14= 'Optimisation:' ( (lv_optimisationLevel_15_0= ruleQUERY_OPTIMISATION_LEVEL ) ) )? )
            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:3867:2: (otherlv_0= 'language:' ( (otherlv_1= RULE_ID ) ) )? (otherlv_2= 'foreign model:' ( (otherlv_3= RULE_ID ) ) )? (otherlv_4= 'context locator:' ( (lv_contextLocator_5_0= RULE_STRING ) ) )? ( ( (lv_query_6_0= ruleQueryBody ) ) | ( (lv_externalQueryCall_7_0= ruleExternalQueryCallMdsl ) ) ) (otherlv_8= ':' ( (otherlv_9= RULE_ID ) ) )? (otherlv_10= 'properties:' ( (lv_properties_11_0= rulePropertyMdsl ) ) (otherlv_12= ',' ( (lv_properties_13_0= rulePropertyMdsl ) ) )* )? (otherlv_14= 'Optimisation:' ( (lv_optimisationLevel_15_0= ruleQUERY_OPTIMISATION_LEVEL ) ) )?
            {
            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:3867:2: (otherlv_0= 'language:' ( (otherlv_1= RULE_ID ) ) )?
            int alt82=2;
            int LA82_0 = input.LA(1);

            if ( (LA82_0==95) ) {
                alt82=1;
            }
            switch (alt82) {
                case 1 :
                    // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:3867:4: otherlv_0= 'language:' ( (otherlv_1= RULE_ID ) )
                    {
                    otherlv_0=(Token)match(input,95,FOLLOW_95_in_ruleQueryDefinitionMdsl8345); 

                        	newLeafNode(otherlv_0, grammarAccess.getQueryDefinitionMdslAccess().getLanguageKeyword_0_0());
                        
                    // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:3871:1: ( (otherlv_1= RULE_ID ) )
                    // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:3872:1: (otherlv_1= RULE_ID )
                    {
                    // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:3872:1: (otherlv_1= RULE_ID )
                    // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:3873:3: otherlv_1= RULE_ID
                    {

                    			if (current==null) {
                    	            current = createModelElement(grammarAccess.getQueryDefinitionMdslRule());
                    	        }
                            
                    otherlv_1=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleQueryDefinitionMdsl8365); 

                    		newLeafNode(otherlv_1, grammarAccess.getQueryDefinitionMdslAccess().getEvaluatorQueryEvaluatorMdslCrossReference_0_1_0()); 
                    	

                    }


                    }


                    }
                    break;

            }

            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:3884:4: (otherlv_2= 'foreign model:' ( (otherlv_3= RULE_ID ) ) )?
            int alt83=2;
            int LA83_0 = input.LA(1);

            if ( (LA83_0==96) ) {
                alt83=1;
            }
            switch (alt83) {
                case 1 :
                    // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:3884:6: otherlv_2= 'foreign model:' ( (otherlv_3= RULE_ID ) )
                    {
                    otherlv_2=(Token)match(input,96,FOLLOW_96_in_ruleQueryDefinitionMdsl8380); 

                        	newLeafNode(otherlv_2, grammarAccess.getQueryDefinitionMdslAccess().getForeignModelKeyword_1_0());
                        
                    // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:3888:1: ( (otherlv_3= RULE_ID ) )
                    // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:3889:1: (otherlv_3= RULE_ID )
                    {
                    // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:3889:1: (otherlv_3= RULE_ID )
                    // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:3890:3: otherlv_3= RULE_ID
                    {

                    			if (current==null) {
                    	            current = createModelElement(grammarAccess.getQueryDefinitionMdslRule());
                    	        }
                            
                    otherlv_3=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleQueryDefinitionMdsl8400); 

                    		newLeafNode(otherlv_3, grammarAccess.getQueryDefinitionMdslAccess().getForeignModelForeignModelMdslCrossReference_1_1_0()); 
                    	

                    }


                    }


                    }
                    break;

            }

            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:3901:4: (otherlv_4= 'context locator:' ( (lv_contextLocator_5_0= RULE_STRING ) ) )?
            int alt84=2;
            int LA84_0 = input.LA(1);

            if ( (LA84_0==97) ) {
                alt84=1;
            }
            switch (alt84) {
                case 1 :
                    // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:3901:6: otherlv_4= 'context locator:' ( (lv_contextLocator_5_0= RULE_STRING ) )
                    {
                    otherlv_4=(Token)match(input,97,FOLLOW_97_in_ruleQueryDefinitionMdsl8415); 

                        	newLeafNode(otherlv_4, grammarAccess.getQueryDefinitionMdslAccess().getContextLocatorKeyword_2_0());
                        
                    // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:3905:1: ( (lv_contextLocator_5_0= RULE_STRING ) )
                    // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:3906:1: (lv_contextLocator_5_0= RULE_STRING )
                    {
                    // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:3906:1: (lv_contextLocator_5_0= RULE_STRING )
                    // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:3907:3: lv_contextLocator_5_0= RULE_STRING
                    {
                    lv_contextLocator_5_0=(Token)match(input,RULE_STRING,FOLLOW_RULE_STRING_in_ruleQueryDefinitionMdsl8432); 

                    			newLeafNode(lv_contextLocator_5_0, grammarAccess.getQueryDefinitionMdslAccess().getContextLocatorSTRINGTerminalRuleCall_2_1_0()); 
                    		

                    	        if (current==null) {
                    	            current = createModelElement(grammarAccess.getQueryDefinitionMdslRule());
                    	        }
                           		setWithLastConsumed(
                           			current, 
                           			"contextLocator",
                            		lv_contextLocator_5_0, 
                            		"STRING");
                    	    

                    }


                    }


                    }
                    break;

            }

            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:3923:4: ( ( (lv_query_6_0= ruleQueryBody ) ) | ( (lv_externalQueryCall_7_0= ruleExternalQueryCallMdsl ) ) )
            int alt85=2;
            int LA85_0 = input.LA(1);

            if ( (LA85_0==RULE_STRING||LA85_0==104) ) {
                alt85=1;
            }
            else if ( (LA85_0==100) ) {
                alt85=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 85, 0, input);

                throw nvae;
            }
            switch (alt85) {
                case 1 :
                    // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:3923:5: ( (lv_query_6_0= ruleQueryBody ) )
                    {
                    // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:3923:5: ( (lv_query_6_0= ruleQueryBody ) )
                    // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:3924:1: (lv_query_6_0= ruleQueryBody )
                    {
                    // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:3924:1: (lv_query_6_0= ruleQueryBody )
                    // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:3925:3: lv_query_6_0= ruleQueryBody
                    {
                     
                    	        newCompositeNode(grammarAccess.getQueryDefinitionMdslAccess().getQueryQueryBodyParserRuleCall_3_0_0()); 
                    	    
                    pushFollow(FOLLOW_ruleQueryBody_in_ruleQueryDefinitionMdsl8461);
                    lv_query_6_0=ruleQueryBody();

                    state._fsp--;


                    	        if (current==null) {
                    	            current = createModelElementForParent(grammarAccess.getQueryDefinitionMdslRule());
                    	        }
                           		set(
                           			current, 
                           			"query",
                            		lv_query_6_0, 
                            		"QueryBody");
                    	        afterParserOrEnumRuleCall();
                    	    

                    }


                    }


                    }
                    break;
                case 2 :
                    // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:3942:6: ( (lv_externalQueryCall_7_0= ruleExternalQueryCallMdsl ) )
                    {
                    // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:3942:6: ( (lv_externalQueryCall_7_0= ruleExternalQueryCallMdsl ) )
                    // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:3943:1: (lv_externalQueryCall_7_0= ruleExternalQueryCallMdsl )
                    {
                    // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:3943:1: (lv_externalQueryCall_7_0= ruleExternalQueryCallMdsl )
                    // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:3944:3: lv_externalQueryCall_7_0= ruleExternalQueryCallMdsl
                    {
                     
                    	        newCompositeNode(grammarAccess.getQueryDefinitionMdslAccess().getExternalQueryCallExternalQueryCallMdslParserRuleCall_3_1_0()); 
                    	    
                    pushFollow(FOLLOW_ruleExternalQueryCallMdsl_in_ruleQueryDefinitionMdsl8488);
                    lv_externalQueryCall_7_0=ruleExternalQueryCallMdsl();

                    state._fsp--;


                    	        if (current==null) {
                    	            current = createModelElementForParent(grammarAccess.getQueryDefinitionMdslRule());
                    	        }
                           		set(
                           			current, 
                           			"externalQueryCall",
                            		lv_externalQueryCall_7_0, 
                            		"ExternalQueryCallMdsl");
                    	        afterParserOrEnumRuleCall();
                    	    

                    }


                    }


                    }
                    break;

            }

            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:3960:3: (otherlv_8= ':' ( (otherlv_9= RULE_ID ) ) )?
            int alt86=2;
            int LA86_0 = input.LA(1);

            if ( (LA86_0==25) ) {
                alt86=1;
            }
            switch (alt86) {
                case 1 :
                    // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:3960:5: otherlv_8= ':' ( (otherlv_9= RULE_ID ) )
                    {
                    otherlv_8=(Token)match(input,25,FOLLOW_25_in_ruleQueryDefinitionMdsl8502); 

                        	newLeafNode(otherlv_8, grammarAccess.getQueryDefinitionMdslAccess().getColonKeyword_4_0());
                        
                    // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:3964:1: ( (otherlv_9= RULE_ID ) )
                    // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:3965:1: (otherlv_9= RULE_ID )
                    {
                    // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:3965:1: (otherlv_9= RULE_ID )
                    // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:3966:3: otherlv_9= RULE_ID
                    {

                    			if (current==null) {
                    	            current = createModelElement(grammarAccess.getQueryDefinitionMdslRule());
                    	        }
                            
                    otherlv_9=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleQueryDefinitionMdsl8522); 

                    		newLeafNode(otherlv_9, grammarAccess.getQueryDefinitionMdslAccess().getReturnTypeEClassifierCrossReference_4_1_0()); 
                    	

                    }


                    }


                    }
                    break;

            }

            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:3977:4: (otherlv_10= 'properties:' ( (lv_properties_11_0= rulePropertyMdsl ) ) (otherlv_12= ',' ( (lv_properties_13_0= rulePropertyMdsl ) ) )* )?
            int alt88=2;
            int LA88_0 = input.LA(1);

            if ( (LA88_0==98) ) {
                alt88=1;
            }
            switch (alt88) {
                case 1 :
                    // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:3977:6: otherlv_10= 'properties:' ( (lv_properties_11_0= rulePropertyMdsl ) ) (otherlv_12= ',' ( (lv_properties_13_0= rulePropertyMdsl ) ) )*
                    {
                    otherlv_10=(Token)match(input,98,FOLLOW_98_in_ruleQueryDefinitionMdsl8537); 

                        	newLeafNode(otherlv_10, grammarAccess.getQueryDefinitionMdslAccess().getPropertiesKeyword_5_0());
                        
                    // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:3981:1: ( (lv_properties_11_0= rulePropertyMdsl ) )
                    // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:3982:1: (lv_properties_11_0= rulePropertyMdsl )
                    {
                    // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:3982:1: (lv_properties_11_0= rulePropertyMdsl )
                    // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:3983:3: lv_properties_11_0= rulePropertyMdsl
                    {
                     
                    	        newCompositeNode(grammarAccess.getQueryDefinitionMdslAccess().getPropertiesPropertyMdslParserRuleCall_5_1_0()); 
                    	    
                    pushFollow(FOLLOW_rulePropertyMdsl_in_ruleQueryDefinitionMdsl8558);
                    lv_properties_11_0=rulePropertyMdsl();

                    state._fsp--;


                    	        if (current==null) {
                    	            current = createModelElementForParent(grammarAccess.getQueryDefinitionMdslRule());
                    	        }
                           		add(
                           			current, 
                           			"properties",
                            		lv_properties_11_0, 
                            		"PropertyMdsl");
                    	        afterParserOrEnumRuleCall();
                    	    

                    }


                    }

                    // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:3999:2: (otherlv_12= ',' ( (lv_properties_13_0= rulePropertyMdsl ) ) )*
                    loop87:
                    do {
                        int alt87=2;
                        int LA87_0 = input.LA(1);

                        if ( (LA87_0==33) ) {
                            int LA87_2 = input.LA(2);

                            if ( (LA87_2==RULE_ID) ) {
                                int LA87_3 = input.LA(3);

                                if ( (LA87_3==14) ) {
                                    alt87=1;
                                }


                            }


                        }


                        switch (alt87) {
                    	case 1 :
                    	    // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:3999:4: otherlv_12= ',' ( (lv_properties_13_0= rulePropertyMdsl ) )
                    	    {
                    	    otherlv_12=(Token)match(input,33,FOLLOW_33_in_ruleQueryDefinitionMdsl8571); 

                    	        	newLeafNode(otherlv_12, grammarAccess.getQueryDefinitionMdslAccess().getCommaKeyword_5_2_0());
                    	        
                    	    // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:4003:1: ( (lv_properties_13_0= rulePropertyMdsl ) )
                    	    // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:4004:1: (lv_properties_13_0= rulePropertyMdsl )
                    	    {
                    	    // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:4004:1: (lv_properties_13_0= rulePropertyMdsl )
                    	    // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:4005:3: lv_properties_13_0= rulePropertyMdsl
                    	    {
                    	     
                    	    	        newCompositeNode(grammarAccess.getQueryDefinitionMdslAccess().getPropertiesPropertyMdslParserRuleCall_5_2_1_0()); 
                    	    	    
                    	    pushFollow(FOLLOW_rulePropertyMdsl_in_ruleQueryDefinitionMdsl8592);
                    	    lv_properties_13_0=rulePropertyMdsl();

                    	    state._fsp--;


                    	    	        if (current==null) {
                    	    	            current = createModelElementForParent(grammarAccess.getQueryDefinitionMdslRule());
                    	    	        }
                    	           		add(
                    	           			current, 
                    	           			"properties",
                    	            		lv_properties_13_0, 
                    	            		"PropertyMdsl");
                    	    	        afterParserOrEnumRuleCall();
                    	    	    

                    	    }


                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop87;
                        }
                    } while (true);


                    }
                    break;

            }

            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:4021:6: (otherlv_14= 'Optimisation:' ( (lv_optimisationLevel_15_0= ruleQUERY_OPTIMISATION_LEVEL ) ) )?
            int alt89=2;
            int LA89_0 = input.LA(1);

            if ( (LA89_0==99) ) {
                alt89=1;
            }
            switch (alt89) {
                case 1 :
                    // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:4021:8: otherlv_14= 'Optimisation:' ( (lv_optimisationLevel_15_0= ruleQUERY_OPTIMISATION_LEVEL ) )
                    {
                    otherlv_14=(Token)match(input,99,FOLLOW_99_in_ruleQueryDefinitionMdsl8609); 

                        	newLeafNode(otherlv_14, grammarAccess.getQueryDefinitionMdslAccess().getOptimisationKeyword_6_0());
                        
                    // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:4025:1: ( (lv_optimisationLevel_15_0= ruleQUERY_OPTIMISATION_LEVEL ) )
                    // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:4026:1: (lv_optimisationLevel_15_0= ruleQUERY_OPTIMISATION_LEVEL )
                    {
                    // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:4026:1: (lv_optimisationLevel_15_0= ruleQUERY_OPTIMISATION_LEVEL )
                    // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:4027:3: lv_optimisationLevel_15_0= ruleQUERY_OPTIMISATION_LEVEL
                    {
                     
                    	        newCompositeNode(grammarAccess.getQueryDefinitionMdslAccess().getOptimisationLevelQUERY_OPTIMISATION_LEVELEnumRuleCall_6_1_0()); 
                    	    
                    pushFollow(FOLLOW_ruleQUERY_OPTIMISATION_LEVEL_in_ruleQueryDefinitionMdsl8630);
                    lv_optimisationLevel_15_0=ruleQUERY_OPTIMISATION_LEVEL();

                    state._fsp--;


                    	        if (current==null) {
                    	            current = createModelElementForParent(grammarAccess.getQueryDefinitionMdslRule());
                    	        }
                           		set(
                           			current, 
                           			"optimisationLevel",
                            		lv_optimisationLevel_15_0, 
                            		"QUERY_OPTIMISATION_LEVEL");
                    	        afterParserOrEnumRuleCall();
                    	    

                    }


                    }


                    }
                    break;

            }


            }


            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleQueryDefinitionMdsl"


    // $ANTLR start "entryRuleQueryFragment"
    // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:4051:1: entryRuleQueryFragment returns [EObject current=null] : iv_ruleQueryFragment= ruleQueryFragment EOF ;
    public final EObject entryRuleQueryFragment() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleQueryFragment = null;


        try {
            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:4052:2: (iv_ruleQueryFragment= ruleQueryFragment EOF )
            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:4053:2: iv_ruleQueryFragment= ruleQueryFragment EOF
            {
             newCompositeNode(grammarAccess.getQueryFragmentRule()); 
            pushFollow(FOLLOW_ruleQueryFragment_in_entryRuleQueryFragment8668);
            iv_ruleQueryFragment=ruleQueryFragment();

            state._fsp--;

             current =iv_ruleQueryFragment; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleQueryFragment8678); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleQueryFragment"


    // $ANTLR start "ruleQueryFragment"
    // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:4060:1: ruleQueryFragment returns [EObject current=null] : (this_LiteralQueryFragment_0= ruleLiteralQueryFragment | this_TextMacroRef_1= ruleTextMacroRef ) ;
    public final EObject ruleQueryFragment() throws RecognitionException {
        EObject current = null;

        EObject this_LiteralQueryFragment_0 = null;

        EObject this_TextMacroRef_1 = null;


         enterRule(); 
            
        try {
            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:4063:28: ( (this_LiteralQueryFragment_0= ruleLiteralQueryFragment | this_TextMacroRef_1= ruleTextMacroRef ) )
            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:4064:1: (this_LiteralQueryFragment_0= ruleLiteralQueryFragment | this_TextMacroRef_1= ruleTextMacroRef )
            {
            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:4064:1: (this_LiteralQueryFragment_0= ruleLiteralQueryFragment | this_TextMacroRef_1= ruleTextMacroRef )
            int alt90=2;
            int LA90_0 = input.LA(1);

            if ( (LA90_0==RULE_STRING) ) {
                alt90=1;
            }
            else if ( (LA90_0==104) ) {
                alt90=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 90, 0, input);

                throw nvae;
            }
            switch (alt90) {
                case 1 :
                    // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:4065:5: this_LiteralQueryFragment_0= ruleLiteralQueryFragment
                    {
                     
                            newCompositeNode(grammarAccess.getQueryFragmentAccess().getLiteralQueryFragmentParserRuleCall_0()); 
                        
                    pushFollow(FOLLOW_ruleLiteralQueryFragment_in_ruleQueryFragment8725);
                    this_LiteralQueryFragment_0=ruleLiteralQueryFragment();

                    state._fsp--;

                     
                            current = this_LiteralQueryFragment_0; 
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;
                case 2 :
                    // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:4075:5: this_TextMacroRef_1= ruleTextMacroRef
                    {
                     
                            newCompositeNode(grammarAccess.getQueryFragmentAccess().getTextMacroRefParserRuleCall_1()); 
                        
                    pushFollow(FOLLOW_ruleTextMacroRef_in_ruleQueryFragment8752);
                    this_TextMacroRef_1=ruleTextMacroRef();

                    state._fsp--;

                     
                            current = this_TextMacroRef_1; 
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;

            }


            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleQueryFragment"


    // $ANTLR start "entryRuleLiteralQueryFragment"
    // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:4091:1: entryRuleLiteralQueryFragment returns [EObject current=null] : iv_ruleLiteralQueryFragment= ruleLiteralQueryFragment EOF ;
    public final EObject entryRuleLiteralQueryFragment() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleLiteralQueryFragment = null;


        try {
            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:4092:2: (iv_ruleLiteralQueryFragment= ruleLiteralQueryFragment EOF )
            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:4093:2: iv_ruleLiteralQueryFragment= ruleLiteralQueryFragment EOF
            {
             newCompositeNode(grammarAccess.getLiteralQueryFragmentRule()); 
            pushFollow(FOLLOW_ruleLiteralQueryFragment_in_entryRuleLiteralQueryFragment8787);
            iv_ruleLiteralQueryFragment=ruleLiteralQueryFragment();

            state._fsp--;

             current =iv_ruleLiteralQueryFragment; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleLiteralQueryFragment8797); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleLiteralQueryFragment"


    // $ANTLR start "ruleLiteralQueryFragment"
    // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:4100:1: ruleLiteralQueryFragment returns [EObject current=null] : ( (lv_value_0_0= RULE_STRING ) ) ;
    public final EObject ruleLiteralQueryFragment() throws RecognitionException {
        EObject current = null;

        Token lv_value_0_0=null;

         enterRule(); 
            
        try {
            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:4103:28: ( ( (lv_value_0_0= RULE_STRING ) ) )
            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:4104:1: ( (lv_value_0_0= RULE_STRING ) )
            {
            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:4104:1: ( (lv_value_0_0= RULE_STRING ) )
            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:4105:1: (lv_value_0_0= RULE_STRING )
            {
            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:4105:1: (lv_value_0_0= RULE_STRING )
            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:4106:3: lv_value_0_0= RULE_STRING
            {
            lv_value_0_0=(Token)match(input,RULE_STRING,FOLLOW_RULE_STRING_in_ruleLiteralQueryFragment8838); 

            			newLeafNode(lv_value_0_0, grammarAccess.getLiteralQueryFragmentAccess().getValueSTRINGTerminalRuleCall_0()); 
            		

            	        if (current==null) {
            	            current = createModelElement(grammarAccess.getLiteralQueryFragmentRule());
            	        }
                   		setWithLastConsumed(
                   			current, 
                   			"value",
                    		lv_value_0_0, 
                    		"STRING");
            	    

            }


            }


            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleLiteralQueryFragment"


    // $ANTLR start "entryRuleQueryBody"
    // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:4130:1: entryRuleQueryBody returns [EObject current=null] : iv_ruleQueryBody= ruleQueryBody EOF ;
    public final EObject entryRuleQueryBody() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleQueryBody = null;


        try {
            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:4131:2: (iv_ruleQueryBody= ruleQueryBody EOF )
            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:4132:2: iv_ruleQueryBody= ruleQueryBody EOF
            {
             newCompositeNode(grammarAccess.getQueryBodyRule()); 
            pushFollow(FOLLOW_ruleQueryBody_in_entryRuleQueryBody8878);
            iv_ruleQueryBody=ruleQueryBody();

            state._fsp--;

             current =iv_ruleQueryBody; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleQueryBody8888); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleQueryBody"


    // $ANTLR start "ruleQueryBody"
    // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:4139:1: ruleQueryBody returns [EObject current=null] : ( ( (lv_fragments_0_0= ruleQueryFragment ) ) (otherlv_1= '+' ( (lv_fragments_2_0= ruleQueryFragment ) ) )* ) ;
    public final EObject ruleQueryBody() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        EObject lv_fragments_0_0 = null;

        EObject lv_fragments_2_0 = null;


         enterRule(); 
            
        try {
            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:4142:28: ( ( ( (lv_fragments_0_0= ruleQueryFragment ) ) (otherlv_1= '+' ( (lv_fragments_2_0= ruleQueryFragment ) ) )* ) )
            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:4143:1: ( ( (lv_fragments_0_0= ruleQueryFragment ) ) (otherlv_1= '+' ( (lv_fragments_2_0= ruleQueryFragment ) ) )* )
            {
            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:4143:1: ( ( (lv_fragments_0_0= ruleQueryFragment ) ) (otherlv_1= '+' ( (lv_fragments_2_0= ruleQueryFragment ) ) )* )
            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:4143:2: ( (lv_fragments_0_0= ruleQueryFragment ) ) (otherlv_1= '+' ( (lv_fragments_2_0= ruleQueryFragment ) ) )*
            {
            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:4143:2: ( (lv_fragments_0_0= ruleQueryFragment ) )
            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:4144:1: (lv_fragments_0_0= ruleQueryFragment )
            {
            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:4144:1: (lv_fragments_0_0= ruleQueryFragment )
            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:4145:3: lv_fragments_0_0= ruleQueryFragment
            {
             
            	        newCompositeNode(grammarAccess.getQueryBodyAccess().getFragmentsQueryFragmentParserRuleCall_0_0()); 
            	    
            pushFollow(FOLLOW_ruleQueryFragment_in_ruleQueryBody8934);
            lv_fragments_0_0=ruleQueryFragment();

            state._fsp--;


            	        if (current==null) {
            	            current = createModelElementForParent(grammarAccess.getQueryBodyRule());
            	        }
                   		add(
                   			current, 
                   			"fragments",
                    		lv_fragments_0_0, 
                    		"QueryFragment");
            	        afterParserOrEnumRuleCall();
            	    

            }


            }

            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:4161:2: (otherlv_1= '+' ( (lv_fragments_2_0= ruleQueryFragment ) ) )*
            loop91:
            do {
                int alt91=2;
                int LA91_0 = input.LA(1);

                if ( (LA91_0==15) ) {
                    alt91=1;
                }


                switch (alt91) {
            	case 1 :
            	    // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:4161:4: otherlv_1= '+' ( (lv_fragments_2_0= ruleQueryFragment ) )
            	    {
            	    otherlv_1=(Token)match(input,15,FOLLOW_15_in_ruleQueryBody8947); 

            	        	newLeafNode(otherlv_1, grammarAccess.getQueryBodyAccess().getPlusSignKeyword_1_0());
            	        
            	    // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:4165:1: ( (lv_fragments_2_0= ruleQueryFragment ) )
            	    // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:4166:1: (lv_fragments_2_0= ruleQueryFragment )
            	    {
            	    // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:4166:1: (lv_fragments_2_0= ruleQueryFragment )
            	    // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:4167:3: lv_fragments_2_0= ruleQueryFragment
            	    {
            	     
            	    	        newCompositeNode(grammarAccess.getQueryBodyAccess().getFragmentsQueryFragmentParserRuleCall_1_1_0()); 
            	    	    
            	    pushFollow(FOLLOW_ruleQueryFragment_in_ruleQueryBody8968);
            	    lv_fragments_2_0=ruleQueryFragment();

            	    state._fsp--;


            	    	        if (current==null) {
            	    	            current = createModelElementForParent(grammarAccess.getQueryBodyRule());
            	    	        }
            	           		add(
            	           			current, 
            	           			"fragments",
            	            		lv_fragments_2_0, 
            	            		"QueryFragment");
            	    	        afterParserOrEnumRuleCall();
            	    	    

            	    }


            	    }


            	    }
            	    break;

            	default :
            	    break loop91;
                }
            } while (true);


            }


            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleQueryBody"


    // $ANTLR start "entryRuleQueryRefMdsl"
    // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:4191:1: entryRuleQueryRefMdsl returns [EObject current=null] : iv_ruleQueryRefMdsl= ruleQueryRefMdsl EOF ;
    public final EObject entryRuleQueryRefMdsl() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleQueryRefMdsl = null;


        try {
            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:4192:2: (iv_ruleQueryRefMdsl= ruleQueryRefMdsl EOF )
            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:4193:2: iv_ruleQueryRefMdsl= ruleQueryRefMdsl EOF
            {
             newCompositeNode(grammarAccess.getQueryRefMdslRule()); 
            pushFollow(FOLLOW_ruleQueryRefMdsl_in_entryRuleQueryRefMdsl9006);
            iv_ruleQueryRefMdsl=ruleQueryRefMdsl();

            state._fsp--;

             current =iv_ruleQueryRefMdsl; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleQueryRefMdsl9016); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleQueryRefMdsl"


    // $ANTLR start "ruleQueryRefMdsl"
    // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:4200:1: ruleQueryRefMdsl returns [EObject current=null] : ( (otherlv_0= RULE_ID ) ) ;
    public final EObject ruleQueryRefMdsl() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;

         enterRule(); 
            
        try {
            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:4203:28: ( ( (otherlv_0= RULE_ID ) ) )
            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:4204:1: ( (otherlv_0= RULE_ID ) )
            {
            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:4204:1: ( (otherlv_0= RULE_ID ) )
            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:4205:1: (otherlv_0= RULE_ID )
            {
            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:4205:1: (otherlv_0= RULE_ID )
            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:4206:3: otherlv_0= RULE_ID
            {

            			if (current==null) {
            	            current = createModelElement(grammarAccess.getQueryRefMdslRule());
            	        }
                    
            otherlv_0=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleQueryRefMdsl9060); 

            		newLeafNode(otherlv_0, grammarAccess.getQueryRefMdslAccess().getReferencedQueryDeclarationCrossReference_0()); 
            	

            }


            }


            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleQueryRefMdsl"


    // $ANTLR start "entryRuleExternalQueryCallMdsl"
    // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:4225:1: entryRuleExternalQueryCallMdsl returns [EObject current=null] : iv_ruleExternalQueryCallMdsl= ruleExternalQueryCallMdsl EOF ;
    public final EObject entryRuleExternalQueryCallMdsl() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleExternalQueryCallMdsl = null;


        try {
            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:4226:2: (iv_ruleExternalQueryCallMdsl= ruleExternalQueryCallMdsl EOF )
            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:4227:2: iv_ruleExternalQueryCallMdsl= ruleExternalQueryCallMdsl EOF
            {
             newCompositeNode(grammarAccess.getExternalQueryCallMdslRule()); 
            pushFollow(FOLLOW_ruleExternalQueryCallMdsl_in_entryRuleExternalQueryCallMdsl9095);
            iv_ruleExternalQueryCallMdsl=ruleExternalQueryCallMdsl();

            state._fsp--;

             current =iv_ruleExternalQueryCallMdsl; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleExternalQueryCallMdsl9105); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleExternalQueryCallMdsl"


    // $ANTLR start "ruleExternalQueryCallMdsl"
    // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:4234:1: ruleExternalQueryCallMdsl returns [EObject current=null] : (otherlv_0= 'call' ( (otherlv_1= RULE_ID ) ) otherlv_2= '()' ) ;
    public final EObject ruleExternalQueryCallMdsl() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;
        Token otherlv_2=null;

         enterRule(); 
            
        try {
            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:4237:28: ( (otherlv_0= 'call' ( (otherlv_1= RULE_ID ) ) otherlv_2= '()' ) )
            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:4238:1: (otherlv_0= 'call' ( (otherlv_1= RULE_ID ) ) otherlv_2= '()' )
            {
            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:4238:1: (otherlv_0= 'call' ( (otherlv_1= RULE_ID ) ) otherlv_2= '()' )
            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:4238:3: otherlv_0= 'call' ( (otherlv_1= RULE_ID ) ) otherlv_2= '()'
            {
            otherlv_0=(Token)match(input,100,FOLLOW_100_in_ruleExternalQueryCallMdsl9142); 

                	newLeafNode(otherlv_0, grammarAccess.getExternalQueryCallMdslAccess().getCallKeyword_0());
                
            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:4242:1: ( (otherlv_1= RULE_ID ) )
            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:4243:1: (otherlv_1= RULE_ID )
            {
            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:4243:1: (otherlv_1= RULE_ID )
            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:4244:3: otherlv_1= RULE_ID
            {

            			if (current==null) {
            	            current = createModelElement(grammarAccess.getExternalQueryCallMdslRule());
            	        }
                    
            otherlv_1=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleExternalQueryCallMdsl9162); 

            		newLeafNode(otherlv_1, grammarAccess.getExternalQueryCallMdslAccess().getExternalQueryEObjectCrossReference_1_0()); 
            	

            }


            }

            otherlv_2=(Token)match(input,101,FOLLOW_101_in_ruleExternalQueryCallMdsl9174); 

                	newLeafNode(otherlv_2, grammarAccess.getExternalQueryCallMdslAccess().getLeftParenthesisRightParenthesisKeyword_2());
                

            }


            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleExternalQueryCallMdsl"


    // $ANTLR start "entryRuleQueryChain"
    // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:4267:1: entryRuleQueryChain returns [EObject current=null] : iv_ruleQueryChain= ruleQueryChain EOF ;
    public final EObject entryRuleQueryChain() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleQueryChain = null;


        try {
            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:4268:2: (iv_ruleQueryChain= ruleQueryChain EOF )
            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:4269:2: iv_ruleQueryChain= ruleQueryChain EOF
            {
             newCompositeNode(grammarAccess.getQueryChainRule()); 
            pushFollow(FOLLOW_ruleQueryChain_in_entryRuleQueryChain9210);
            iv_ruleQueryChain=ruleQueryChain();

            state._fsp--;

             current =iv_ruleQueryChain; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleQueryChain9220); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleQueryChain"


    // $ANTLR start "ruleQueryChain"
    // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:4276:1: ruleQueryChain returns [EObject current=null] : (otherlv_0= 'Query Chain' otherlv_1= '{' ( (lv_queries_2_0= ruleQuery ) )+ (otherlv_3= ',' ( (lv_queries_4_0= ruleQuery ) ) )* otherlv_5= '}' ) ;
    public final EObject ruleQueryChain() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;
        Token otherlv_3=null;
        Token otherlv_5=null;
        EObject lv_queries_2_0 = null;

        EObject lv_queries_4_0 = null;


         enterRule(); 
            
        try {
            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:4279:28: ( (otherlv_0= 'Query Chain' otherlv_1= '{' ( (lv_queries_2_0= ruleQuery ) )+ (otherlv_3= ',' ( (lv_queries_4_0= ruleQuery ) ) )* otherlv_5= '}' ) )
            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:4280:1: (otherlv_0= 'Query Chain' otherlv_1= '{' ( (lv_queries_2_0= ruleQuery ) )+ (otherlv_3= ',' ( (lv_queries_4_0= ruleQuery ) ) )* otherlv_5= '}' )
            {
            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:4280:1: (otherlv_0= 'Query Chain' otherlv_1= '{' ( (lv_queries_2_0= ruleQuery ) )+ (otherlv_3= ',' ( (lv_queries_4_0= ruleQuery ) ) )* otherlv_5= '}' )
            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:4280:3: otherlv_0= 'Query Chain' otherlv_1= '{' ( (lv_queries_2_0= ruleQuery ) )+ (otherlv_3= ',' ( (lv_queries_4_0= ruleQuery ) ) )* otherlv_5= '}'
            {
            otherlv_0=(Token)match(input,102,FOLLOW_102_in_ruleQueryChain9257); 

                	newLeafNode(otherlv_0, grammarAccess.getQueryChainAccess().getQueryChainKeyword_0());
                
            otherlv_1=(Token)match(input,22,FOLLOW_22_in_ruleQueryChain9269); 

                	newLeafNode(otherlv_1, grammarAccess.getQueryChainAccess().getLeftCurlyBracketKeyword_1());
                
            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:4288:1: ( (lv_queries_2_0= ruleQuery ) )+
            int cnt92=0;
            loop92:
            do {
                int alt92=2;
                int LA92_0 = input.LA(1);

                if ( ((LA92_0>=RULE_STRING && LA92_0<=RULE_ID)||(LA92_0>=95 && LA92_0<=97)||LA92_0==100||LA92_0==104) ) {
                    alt92=1;
                }


                switch (alt92) {
            	case 1 :
            	    // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:4289:1: (lv_queries_2_0= ruleQuery )
            	    {
            	    // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:4289:1: (lv_queries_2_0= ruleQuery )
            	    // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:4290:3: lv_queries_2_0= ruleQuery
            	    {
            	     
            	    	        newCompositeNode(grammarAccess.getQueryChainAccess().getQueriesQueryParserRuleCall_2_0()); 
            	    	    
            	    pushFollow(FOLLOW_ruleQuery_in_ruleQueryChain9290);
            	    lv_queries_2_0=ruleQuery();

            	    state._fsp--;


            	    	        if (current==null) {
            	    	            current = createModelElementForParent(grammarAccess.getQueryChainRule());
            	    	        }
            	           		add(
            	           			current, 
            	           			"queries",
            	            		lv_queries_2_0, 
            	            		"Query");
            	    	        afterParserOrEnumRuleCall();
            	    	    

            	    }


            	    }
            	    break;

            	default :
            	    if ( cnt92 >= 1 ) break loop92;
                        EarlyExitException eee =
                            new EarlyExitException(92, input);
                        throw eee;
                }
                cnt92++;
            } while (true);

            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:4306:3: (otherlv_3= ',' ( (lv_queries_4_0= ruleQuery ) ) )*
            loop93:
            do {
                int alt93=2;
                int LA93_0 = input.LA(1);

                if ( (LA93_0==33) ) {
                    alt93=1;
                }


                switch (alt93) {
            	case 1 :
            	    // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:4306:5: otherlv_3= ',' ( (lv_queries_4_0= ruleQuery ) )
            	    {
            	    otherlv_3=(Token)match(input,33,FOLLOW_33_in_ruleQueryChain9304); 

            	        	newLeafNode(otherlv_3, grammarAccess.getQueryChainAccess().getCommaKeyword_3_0());
            	        
            	    // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:4310:1: ( (lv_queries_4_0= ruleQuery ) )
            	    // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:4311:1: (lv_queries_4_0= ruleQuery )
            	    {
            	    // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:4311:1: (lv_queries_4_0= ruleQuery )
            	    // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:4312:3: lv_queries_4_0= ruleQuery
            	    {
            	     
            	    	        newCompositeNode(grammarAccess.getQueryChainAccess().getQueriesQueryParserRuleCall_3_1_0()); 
            	    	    
            	    pushFollow(FOLLOW_ruleQuery_in_ruleQueryChain9325);
            	    lv_queries_4_0=ruleQuery();

            	    state._fsp--;


            	    	        if (current==null) {
            	    	            current = createModelElementForParent(grammarAccess.getQueryChainRule());
            	    	        }
            	           		add(
            	           			current, 
            	           			"queries",
            	            		lv_queries_4_0, 
            	            		"Query");
            	    	        afterParserOrEnumRuleCall();
            	    	    

            	    }


            	    }


            	    }
            	    break;

            	default :
            	    break loop93;
                }
            } while (true);

            otherlv_5=(Token)match(input,28,FOLLOW_28_in_ruleQueryChain9339); 

                	newLeafNode(otherlv_5, grammarAccess.getQueryChainAccess().getRightCurlyBracketKeyword_4());
                

            }


            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleQueryChain"


    // $ANTLR start "entryRuleFormatExpr"
    // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:4340:1: entryRuleFormatExpr returns [EObject current=null] : iv_ruleFormatExpr= ruleFormatExpr EOF ;
    public final EObject entryRuleFormatExpr() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleFormatExpr = null;


        try {
            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:4341:2: (iv_ruleFormatExpr= ruleFormatExpr EOF )
            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:4342:2: iv_ruleFormatExpr= ruleFormatExpr EOF
            {
             newCompositeNode(grammarAccess.getFormatExprRule()); 
            pushFollow(FOLLOW_ruleFormatExpr_in_entryRuleFormatExpr9375);
            iv_ruleFormatExpr=ruleFormatExpr();

            state._fsp--;

             current =iv_ruleFormatExpr; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleFormatExpr9385); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleFormatExpr"


    // $ANTLR start "ruleFormatExpr"
    // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:4349:1: ruleFormatExpr returns [EObject current=null] : ( ( (lv_fragments_0_0= ruleFormatExprFragment ) ) (otherlv_1= '+' ( (lv_fragments_2_0= ruleFormatExprFragment ) ) )* ) ;
    public final EObject ruleFormatExpr() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        EObject lv_fragments_0_0 = null;

        EObject lv_fragments_2_0 = null;


         enterRule(); 
            
        try {
            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:4352:28: ( ( ( (lv_fragments_0_0= ruleFormatExprFragment ) ) (otherlv_1= '+' ( (lv_fragments_2_0= ruleFormatExprFragment ) ) )* ) )
            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:4353:1: ( ( (lv_fragments_0_0= ruleFormatExprFragment ) ) (otherlv_1= '+' ( (lv_fragments_2_0= ruleFormatExprFragment ) ) )* )
            {
            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:4353:1: ( ( (lv_fragments_0_0= ruleFormatExprFragment ) ) (otherlv_1= '+' ( (lv_fragments_2_0= ruleFormatExprFragment ) ) )* )
            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:4353:2: ( (lv_fragments_0_0= ruleFormatExprFragment ) ) (otherlv_1= '+' ( (lv_fragments_2_0= ruleFormatExprFragment ) ) )*
            {
            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:4353:2: ( (lv_fragments_0_0= ruleFormatExprFragment ) )
            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:4354:1: (lv_fragments_0_0= ruleFormatExprFragment )
            {
            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:4354:1: (lv_fragments_0_0= ruleFormatExprFragment )
            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:4355:3: lv_fragments_0_0= ruleFormatExprFragment
            {
             
            	        newCompositeNode(grammarAccess.getFormatExprAccess().getFragmentsFormatExprFragmentParserRuleCall_0_0()); 
            	    
            pushFollow(FOLLOW_ruleFormatExprFragment_in_ruleFormatExpr9431);
            lv_fragments_0_0=ruleFormatExprFragment();

            state._fsp--;


            	        if (current==null) {
            	            current = createModelElementForParent(grammarAccess.getFormatExprRule());
            	        }
                   		add(
                   			current, 
                   			"fragments",
                    		lv_fragments_0_0, 
                    		"FormatExprFragment");
            	        afterParserOrEnumRuleCall();
            	    

            }


            }

            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:4371:2: (otherlv_1= '+' ( (lv_fragments_2_0= ruleFormatExprFragment ) ) )*
            loop94:
            do {
                int alt94=2;
                int LA94_0 = input.LA(1);

                if ( (LA94_0==15) ) {
                    alt94=1;
                }


                switch (alt94) {
            	case 1 :
            	    // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:4371:4: otherlv_1= '+' ( (lv_fragments_2_0= ruleFormatExprFragment ) )
            	    {
            	    otherlv_1=(Token)match(input,15,FOLLOW_15_in_ruleFormatExpr9444); 

            	        	newLeafNode(otherlv_1, grammarAccess.getFormatExprAccess().getPlusSignKeyword_1_0());
            	        
            	    // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:4375:1: ( (lv_fragments_2_0= ruleFormatExprFragment ) )
            	    // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:4376:1: (lv_fragments_2_0= ruleFormatExprFragment )
            	    {
            	    // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:4376:1: (lv_fragments_2_0= ruleFormatExprFragment )
            	    // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:4377:3: lv_fragments_2_0= ruleFormatExprFragment
            	    {
            	     
            	    	        newCompositeNode(grammarAccess.getFormatExprAccess().getFragmentsFormatExprFragmentParserRuleCall_1_1_0()); 
            	    	    
            	    pushFollow(FOLLOW_ruleFormatExprFragment_in_ruleFormatExpr9465);
            	    lv_fragments_2_0=ruleFormatExprFragment();

            	    state._fsp--;


            	    	        if (current==null) {
            	    	            current = createModelElementForParent(grammarAccess.getFormatExprRule());
            	    	        }
            	           		add(
            	           			current, 
            	           			"fragments",
            	            		lv_fragments_2_0, 
            	            		"FormatExprFragment");
            	    	        afterParserOrEnumRuleCall();
            	    	    

            	    }


            	    }


            	    }
            	    break;

            	default :
            	    break loop94;
                }
            } while (true);


            }


            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleFormatExpr"


    // $ANTLR start "entryRuleFormatExprFragment"
    // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:4401:1: entryRuleFormatExprFragment returns [EObject current=null] : iv_ruleFormatExprFragment= ruleFormatExprFragment EOF ;
    public final EObject entryRuleFormatExprFragment() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleFormatExprFragment = null;


        try {
            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:4402:2: (iv_ruleFormatExprFragment= ruleFormatExprFragment EOF )
            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:4403:2: iv_ruleFormatExprFragment= ruleFormatExprFragment EOF
            {
             newCompositeNode(grammarAccess.getFormatExprFragmentRule()); 
            pushFollow(FOLLOW_ruleFormatExprFragment_in_entryRuleFormatExprFragment9503);
            iv_ruleFormatExprFragment=ruleFormatExprFragment();

            state._fsp--;

             current =iv_ruleFormatExprFragment; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleFormatExprFragment9513); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleFormatExprFragment"


    // $ANTLR start "ruleFormatExprFragment"
    // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:4410:1: ruleFormatExprFragment returns [EObject current=null] : (this_LiteralFormatExprFragment_0= ruleLiteralFormatExprFragment | this_TextMacroRef_1= ruleTextMacroRef ) ;
    public final EObject ruleFormatExprFragment() throws RecognitionException {
        EObject current = null;

        EObject this_LiteralFormatExprFragment_0 = null;

        EObject this_TextMacroRef_1 = null;


         enterRule(); 
            
        try {
            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:4413:28: ( (this_LiteralFormatExprFragment_0= ruleLiteralFormatExprFragment | this_TextMacroRef_1= ruleTextMacroRef ) )
            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:4414:1: (this_LiteralFormatExprFragment_0= ruleLiteralFormatExprFragment | this_TextMacroRef_1= ruleTextMacroRef )
            {
            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:4414:1: (this_LiteralFormatExprFragment_0= ruleLiteralFormatExprFragment | this_TextMacroRef_1= ruleTextMacroRef )
            int alt95=2;
            int LA95_0 = input.LA(1);

            if ( (LA95_0==RULE_STRING) ) {
                alt95=1;
            }
            else if ( (LA95_0==104) ) {
                alt95=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 95, 0, input);

                throw nvae;
            }
            switch (alt95) {
                case 1 :
                    // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:4415:5: this_LiteralFormatExprFragment_0= ruleLiteralFormatExprFragment
                    {
                     
                            newCompositeNode(grammarAccess.getFormatExprFragmentAccess().getLiteralFormatExprFragmentParserRuleCall_0()); 
                        
                    pushFollow(FOLLOW_ruleLiteralFormatExprFragment_in_ruleFormatExprFragment9560);
                    this_LiteralFormatExprFragment_0=ruleLiteralFormatExprFragment();

                    state._fsp--;

                     
                            current = this_LiteralFormatExprFragment_0; 
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;
                case 2 :
                    // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:4425:5: this_TextMacroRef_1= ruleTextMacroRef
                    {
                     
                            newCompositeNode(grammarAccess.getFormatExprFragmentAccess().getTextMacroRefParserRuleCall_1()); 
                        
                    pushFollow(FOLLOW_ruleTextMacroRef_in_ruleFormatExprFragment9587);
                    this_TextMacroRef_1=ruleTextMacroRef();

                    state._fsp--;

                     
                            current = this_TextMacroRef_1; 
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;

            }


            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleFormatExprFragment"


    // $ANTLR start "entryRuleLiteralFormatExprFragment"
    // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:4441:1: entryRuleLiteralFormatExprFragment returns [EObject current=null] : iv_ruleLiteralFormatExprFragment= ruleLiteralFormatExprFragment EOF ;
    public final EObject entryRuleLiteralFormatExprFragment() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleLiteralFormatExprFragment = null;


        try {
            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:4442:2: (iv_ruleLiteralFormatExprFragment= ruleLiteralFormatExprFragment EOF )
            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:4443:2: iv_ruleLiteralFormatExprFragment= ruleLiteralFormatExprFragment EOF
            {
             newCompositeNode(grammarAccess.getLiteralFormatExprFragmentRule()); 
            pushFollow(FOLLOW_ruleLiteralFormatExprFragment_in_entryRuleLiteralFormatExprFragment9622);
            iv_ruleLiteralFormatExprFragment=ruleLiteralFormatExprFragment();

            state._fsp--;

             current =iv_ruleLiteralFormatExprFragment; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleLiteralFormatExprFragment9632); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleLiteralFormatExprFragment"


    // $ANTLR start "ruleLiteralFormatExprFragment"
    // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:4450:1: ruleLiteralFormatExprFragment returns [EObject current=null] : ( (lv_value_0_0= RULE_STRING ) ) ;
    public final EObject ruleLiteralFormatExprFragment() throws RecognitionException {
        EObject current = null;

        Token lv_value_0_0=null;

         enterRule(); 
            
        try {
            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:4453:28: ( ( (lv_value_0_0= RULE_STRING ) ) )
            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:4454:1: ( (lv_value_0_0= RULE_STRING ) )
            {
            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:4454:1: ( (lv_value_0_0= RULE_STRING ) )
            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:4455:1: (lv_value_0_0= RULE_STRING )
            {
            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:4455:1: (lv_value_0_0= RULE_STRING )
            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:4456:3: lv_value_0_0= RULE_STRING
            {
            lv_value_0_0=(Token)match(input,RULE_STRING,FOLLOW_RULE_STRING_in_ruleLiteralFormatExprFragment9673); 

            			newLeafNode(lv_value_0_0, grammarAccess.getLiteralFormatExprFragmentAccess().getValueSTRINGTerminalRuleCall_0()); 
            		

            	        if (current==null) {
            	            current = createModelElement(grammarAccess.getLiteralFormatExprFragmentRule());
            	        }
                   		setWithLastConsumed(
                   			current, 
                   			"value",
                    		lv_value_0_0, 
                    		"STRING");
            	    

            }


            }


            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleLiteralFormatExprFragment"


    // $ANTLR start "entryRuleTextMacro"
    // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:4480:1: entryRuleTextMacro returns [EObject current=null] : iv_ruleTextMacro= ruleTextMacro EOF ;
    public final EObject entryRuleTextMacro() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleTextMacro = null;


        try {
            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:4481:2: (iv_ruleTextMacro= ruleTextMacro EOF )
            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:4482:2: iv_ruleTextMacro= ruleTextMacro EOF
            {
             newCompositeNode(grammarAccess.getTextMacroRule()); 
            pushFollow(FOLLOW_ruleTextMacro_in_entryRuleTextMacro9713);
            iv_ruleTextMacro=ruleTextMacro();

            state._fsp--;

             current =iv_ruleTextMacro; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleTextMacro9723); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleTextMacro"


    // $ANTLR start "ruleTextMacro"
    // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:4489:1: ruleTextMacro returns [EObject current=null] : (otherlv_0= 'Macro:' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' (otherlv_3= 'label:' ( (lv_label_4_0= RULE_STRING ) ) )? (otherlv_5= 'description:' ( (lv_description_6_0= RULE_STRING ) ) )? otherlv_7= 'value:' ( (lv_macroValue_8_0= RULE_STRING ) ) otherlv_9= '}' ) ;
    public final EObject ruleTextMacro() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token lv_name_1_0=null;
        Token otherlv_2=null;
        Token otherlv_3=null;
        Token lv_label_4_0=null;
        Token otherlv_5=null;
        Token lv_description_6_0=null;
        Token otherlv_7=null;
        Token lv_macroValue_8_0=null;
        Token otherlv_9=null;

         enterRule(); 
            
        try {
            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:4492:28: ( (otherlv_0= 'Macro:' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' (otherlv_3= 'label:' ( (lv_label_4_0= RULE_STRING ) ) )? (otherlv_5= 'description:' ( (lv_description_6_0= RULE_STRING ) ) )? otherlv_7= 'value:' ( (lv_macroValue_8_0= RULE_STRING ) ) otherlv_9= '}' ) )
            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:4493:1: (otherlv_0= 'Macro:' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' (otherlv_3= 'label:' ( (lv_label_4_0= RULE_STRING ) ) )? (otherlv_5= 'description:' ( (lv_description_6_0= RULE_STRING ) ) )? otherlv_7= 'value:' ( (lv_macroValue_8_0= RULE_STRING ) ) otherlv_9= '}' )
            {
            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:4493:1: (otherlv_0= 'Macro:' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' (otherlv_3= 'label:' ( (lv_label_4_0= RULE_STRING ) ) )? (otherlv_5= 'description:' ( (lv_description_6_0= RULE_STRING ) ) )? otherlv_7= 'value:' ( (lv_macroValue_8_0= RULE_STRING ) ) otherlv_9= '}' )
            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:4493:3: otherlv_0= 'Macro:' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' (otherlv_3= 'label:' ( (lv_label_4_0= RULE_STRING ) ) )? (otherlv_5= 'description:' ( (lv_description_6_0= RULE_STRING ) ) )? otherlv_7= 'value:' ( (lv_macroValue_8_0= RULE_STRING ) ) otherlv_9= '}'
            {
            otherlv_0=(Token)match(input,103,FOLLOW_103_in_ruleTextMacro9760); 

                	newLeafNode(otherlv_0, grammarAccess.getTextMacroAccess().getMacroKeyword_0());
                
            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:4497:1: ( (lv_name_1_0= RULE_ID ) )
            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:4498:1: (lv_name_1_0= RULE_ID )
            {
            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:4498:1: (lv_name_1_0= RULE_ID )
            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:4499:3: lv_name_1_0= RULE_ID
            {
            lv_name_1_0=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleTextMacro9777); 

            			newLeafNode(lv_name_1_0, grammarAccess.getTextMacroAccess().getNameIDTerminalRuleCall_1_0()); 
            		

            	        if (current==null) {
            	            current = createModelElement(grammarAccess.getTextMacroRule());
            	        }
                   		setWithLastConsumed(
                   			current, 
                   			"name",
                    		lv_name_1_0, 
                    		"ID");
            	    

            }


            }

            otherlv_2=(Token)match(input,22,FOLLOW_22_in_ruleTextMacro9794); 

                	newLeafNode(otherlv_2, grammarAccess.getTextMacroAccess().getLeftCurlyBracketKeyword_2());
                
            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:4519:1: (otherlv_3= 'label:' ( (lv_label_4_0= RULE_STRING ) ) )?
            int alt96=2;
            int LA96_0 = input.LA(1);

            if ( (LA96_0==13) ) {
                alt96=1;
            }
            switch (alt96) {
                case 1 :
                    // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:4519:3: otherlv_3= 'label:' ( (lv_label_4_0= RULE_STRING ) )
                    {
                    otherlv_3=(Token)match(input,13,FOLLOW_13_in_ruleTextMacro9807); 

                        	newLeafNode(otherlv_3, grammarAccess.getTextMacroAccess().getLabelKeyword_3_0());
                        
                    // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:4523:1: ( (lv_label_4_0= RULE_STRING ) )
                    // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:4524:1: (lv_label_4_0= RULE_STRING )
                    {
                    // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:4524:1: (lv_label_4_0= RULE_STRING )
                    // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:4525:3: lv_label_4_0= RULE_STRING
                    {
                    lv_label_4_0=(Token)match(input,RULE_STRING,FOLLOW_RULE_STRING_in_ruleTextMacro9824); 

                    			newLeafNode(lv_label_4_0, grammarAccess.getTextMacroAccess().getLabelSTRINGTerminalRuleCall_3_1_0()); 
                    		

                    	        if (current==null) {
                    	            current = createModelElement(grammarAccess.getTextMacroRule());
                    	        }
                           		setWithLastConsumed(
                           			current, 
                           			"label",
                            		lv_label_4_0, 
                            		"STRING");
                    	    

                    }


                    }


                    }
                    break;

            }

            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:4541:4: (otherlv_5= 'description:' ( (lv_description_6_0= RULE_STRING ) ) )?
            int alt97=2;
            int LA97_0 = input.LA(1);

            if ( (LA97_0==17) ) {
                alt97=1;
            }
            switch (alt97) {
                case 1 :
                    // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:4541:6: otherlv_5= 'description:' ( (lv_description_6_0= RULE_STRING ) )
                    {
                    otherlv_5=(Token)match(input,17,FOLLOW_17_in_ruleTextMacro9844); 

                        	newLeafNode(otherlv_5, grammarAccess.getTextMacroAccess().getDescriptionKeyword_4_0());
                        
                    // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:4545:1: ( (lv_description_6_0= RULE_STRING ) )
                    // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:4546:1: (lv_description_6_0= RULE_STRING )
                    {
                    // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:4546:1: (lv_description_6_0= RULE_STRING )
                    // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:4547:3: lv_description_6_0= RULE_STRING
                    {
                    lv_description_6_0=(Token)match(input,RULE_STRING,FOLLOW_RULE_STRING_in_ruleTextMacro9861); 

                    			newLeafNode(lv_description_6_0, grammarAccess.getTextMacroAccess().getDescriptionSTRINGTerminalRuleCall_4_1_0()); 
                    		

                    	        if (current==null) {
                    	            current = createModelElement(grammarAccess.getTextMacroRule());
                    	        }
                           		setWithLastConsumed(
                           			current, 
                           			"description",
                            		lv_description_6_0, 
                            		"STRING");
                    	    

                    }


                    }


                    }
                    break;

            }

            otherlv_7=(Token)match(input,65,FOLLOW_65_in_ruleTextMacro9880); 

                	newLeafNode(otherlv_7, grammarAccess.getTextMacroAccess().getValueKeyword_5());
                
            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:4567:1: ( (lv_macroValue_8_0= RULE_STRING ) )
            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:4568:1: (lv_macroValue_8_0= RULE_STRING )
            {
            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:4568:1: (lv_macroValue_8_0= RULE_STRING )
            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:4569:3: lv_macroValue_8_0= RULE_STRING
            {
            lv_macroValue_8_0=(Token)match(input,RULE_STRING,FOLLOW_RULE_STRING_in_ruleTextMacro9897); 

            			newLeafNode(lv_macroValue_8_0, grammarAccess.getTextMacroAccess().getMacroValueSTRINGTerminalRuleCall_6_0()); 
            		

            	        if (current==null) {
            	            current = createModelElement(grammarAccess.getTextMacroRule());
            	        }
                   		setWithLastConsumed(
                   			current, 
                   			"macroValue",
                    		lv_macroValue_8_0, 
                    		"STRING");
            	    

            }


            }

            otherlv_9=(Token)match(input,28,FOLLOW_28_in_ruleTextMacro9914); 

                	newLeafNode(otherlv_9, grammarAccess.getTextMacroAccess().getRightCurlyBracketKeyword_7());
                

            }


            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleTextMacro"


    // $ANTLR start "entryRuleTextMacroRef"
    // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:4597:1: entryRuleTextMacroRef returns [EObject current=null] : iv_ruleTextMacroRef= ruleTextMacroRef EOF ;
    public final EObject entryRuleTextMacroRef() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleTextMacroRef = null;


        try {
            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:4598:2: (iv_ruleTextMacroRef= ruleTextMacroRef EOF )
            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:4599:2: iv_ruleTextMacroRef= ruleTextMacroRef EOF
            {
             newCompositeNode(grammarAccess.getTextMacroRefRule()); 
            pushFollow(FOLLOW_ruleTextMacroRef_in_entryRuleTextMacroRef9950);
            iv_ruleTextMacroRef=ruleTextMacroRef();

            state._fsp--;

             current =iv_ruleTextMacroRef; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleTextMacroRef9960); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleTextMacroRef"


    // $ANTLR start "ruleTextMacroRef"
    // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:4606:1: ruleTextMacroRef returns [EObject current=null] : (otherlv_0= '#' ( (otherlv_1= RULE_ID ) ) ) ;
    public final EObject ruleTextMacroRef() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;

         enterRule(); 
            
        try {
            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:4609:28: ( (otherlv_0= '#' ( (otherlv_1= RULE_ID ) ) ) )
            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:4610:1: (otherlv_0= '#' ( (otherlv_1= RULE_ID ) ) )
            {
            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:4610:1: (otherlv_0= '#' ( (otherlv_1= RULE_ID ) ) )
            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:4610:3: otherlv_0= '#' ( (otherlv_1= RULE_ID ) )
            {
            otherlv_0=(Token)match(input,104,FOLLOW_104_in_ruleTextMacroRef9997); 

                	newLeafNode(otherlv_0, grammarAccess.getTextMacroRefAccess().getNumberSignKeyword_0());
                
            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:4614:1: ( (otherlv_1= RULE_ID ) )
            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:4615:1: (otherlv_1= RULE_ID )
            {
            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:4615:1: (otherlv_1= RULE_ID )
            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:4616:3: otherlv_1= RULE_ID
            {

            			if (current==null) {
            	            current = createModelElement(grammarAccess.getTextMacroRefRule());
            	        }
                    
            otherlv_1=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleTextMacroRef10017); 

            		newLeafNode(otherlv_1, grammarAccess.getTextMacroRefAccess().getReferencedTextMacroCrossReference_1_0()); 
            	

            }


            }


            }


            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleTextMacroRef"


    // $ANTLR start "ruleVALUE_CONVERTER_CATEGORY_MDSL"
    // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:4635:1: ruleVALUE_CONVERTER_CATEGORY_MDSL returns [Enumerator current=null] : ( (enumLiteral_0= 'DATE' ) | (enumLiteral_1= 'DATETIME' ) | (enumLiteral_2= 'INTEGER' ) | (enumLiteral_3= 'FLOAT' ) | (enumLiteral_4= 'DOUBLE' ) | (enumLiteral_5= 'XTEXT' ) ) ;
    public final Enumerator ruleVALUE_CONVERTER_CATEGORY_MDSL() throws RecognitionException {
        Enumerator current = null;

        Token enumLiteral_0=null;
        Token enumLiteral_1=null;
        Token enumLiteral_2=null;
        Token enumLiteral_3=null;
        Token enumLiteral_4=null;
        Token enumLiteral_5=null;

         enterRule(); 
        try {
            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:4637:28: ( ( (enumLiteral_0= 'DATE' ) | (enumLiteral_1= 'DATETIME' ) | (enumLiteral_2= 'INTEGER' ) | (enumLiteral_3= 'FLOAT' ) | (enumLiteral_4= 'DOUBLE' ) | (enumLiteral_5= 'XTEXT' ) ) )
            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:4638:1: ( (enumLiteral_0= 'DATE' ) | (enumLiteral_1= 'DATETIME' ) | (enumLiteral_2= 'INTEGER' ) | (enumLiteral_3= 'FLOAT' ) | (enumLiteral_4= 'DOUBLE' ) | (enumLiteral_5= 'XTEXT' ) )
            {
            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:4638:1: ( (enumLiteral_0= 'DATE' ) | (enumLiteral_1= 'DATETIME' ) | (enumLiteral_2= 'INTEGER' ) | (enumLiteral_3= 'FLOAT' ) | (enumLiteral_4= 'DOUBLE' ) | (enumLiteral_5= 'XTEXT' ) )
            int alt98=6;
            switch ( input.LA(1) ) {
            case 105:
                {
                alt98=1;
                }
                break;
            case 106:
                {
                alt98=2;
                }
                break;
            case 107:
                {
                alt98=3;
                }
                break;
            case 108:
                {
                alt98=4;
                }
                break;
            case 109:
                {
                alt98=5;
                }
                break;
            case 110:
                {
                alt98=6;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 98, 0, input);

                throw nvae;
            }

            switch (alt98) {
                case 1 :
                    // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:4638:2: (enumLiteral_0= 'DATE' )
                    {
                    // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:4638:2: (enumLiteral_0= 'DATE' )
                    // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:4638:4: enumLiteral_0= 'DATE'
                    {
                    enumLiteral_0=(Token)match(input,105,FOLLOW_105_in_ruleVALUE_CONVERTER_CATEGORY_MDSL10067); 

                            current = grammarAccess.getVALUE_CONVERTER_CATEGORY_MDSLAccess().getDATEEnumLiteralDeclaration_0().getEnumLiteral().getInstance();
                            newLeafNode(enumLiteral_0, grammarAccess.getVALUE_CONVERTER_CATEGORY_MDSLAccess().getDATEEnumLiteralDeclaration_0()); 
                        

                    }


                    }
                    break;
                case 2 :
                    // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:4644:6: (enumLiteral_1= 'DATETIME' )
                    {
                    // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:4644:6: (enumLiteral_1= 'DATETIME' )
                    // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:4644:8: enumLiteral_1= 'DATETIME'
                    {
                    enumLiteral_1=(Token)match(input,106,FOLLOW_106_in_ruleVALUE_CONVERTER_CATEGORY_MDSL10084); 

                            current = grammarAccess.getVALUE_CONVERTER_CATEGORY_MDSLAccess().getDATETIMEEnumLiteralDeclaration_1().getEnumLiteral().getInstance();
                            newLeafNode(enumLiteral_1, grammarAccess.getVALUE_CONVERTER_CATEGORY_MDSLAccess().getDATETIMEEnumLiteralDeclaration_1()); 
                        

                    }


                    }
                    break;
                case 3 :
                    // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:4650:6: (enumLiteral_2= 'INTEGER' )
                    {
                    // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:4650:6: (enumLiteral_2= 'INTEGER' )
                    // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:4650:8: enumLiteral_2= 'INTEGER'
                    {
                    enumLiteral_2=(Token)match(input,107,FOLLOW_107_in_ruleVALUE_CONVERTER_CATEGORY_MDSL10101); 

                            current = grammarAccess.getVALUE_CONVERTER_CATEGORY_MDSLAccess().getINTEGEREnumLiteralDeclaration_2().getEnumLiteral().getInstance();
                            newLeafNode(enumLiteral_2, grammarAccess.getVALUE_CONVERTER_CATEGORY_MDSLAccess().getINTEGEREnumLiteralDeclaration_2()); 
                        

                    }


                    }
                    break;
                case 4 :
                    // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:4656:6: (enumLiteral_3= 'FLOAT' )
                    {
                    // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:4656:6: (enumLiteral_3= 'FLOAT' )
                    // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:4656:8: enumLiteral_3= 'FLOAT'
                    {
                    enumLiteral_3=(Token)match(input,108,FOLLOW_108_in_ruleVALUE_CONVERTER_CATEGORY_MDSL10118); 

                            current = grammarAccess.getVALUE_CONVERTER_CATEGORY_MDSLAccess().getFLOATEnumLiteralDeclaration_3().getEnumLiteral().getInstance();
                            newLeafNode(enumLiteral_3, grammarAccess.getVALUE_CONVERTER_CATEGORY_MDSLAccess().getFLOATEnumLiteralDeclaration_3()); 
                        

                    }


                    }
                    break;
                case 5 :
                    // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:4662:6: (enumLiteral_4= 'DOUBLE' )
                    {
                    // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:4662:6: (enumLiteral_4= 'DOUBLE' )
                    // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:4662:8: enumLiteral_4= 'DOUBLE'
                    {
                    enumLiteral_4=(Token)match(input,109,FOLLOW_109_in_ruleVALUE_CONVERTER_CATEGORY_MDSL10135); 

                            current = grammarAccess.getVALUE_CONVERTER_CATEGORY_MDSLAccess().getDOUBLEEnumLiteralDeclaration_4().getEnumLiteral().getInstance();
                            newLeafNode(enumLiteral_4, grammarAccess.getVALUE_CONVERTER_CATEGORY_MDSLAccess().getDOUBLEEnumLiteralDeclaration_4()); 
                        

                    }


                    }
                    break;
                case 6 :
                    // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:4668:6: (enumLiteral_5= 'XTEXT' )
                    {
                    // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:4668:6: (enumLiteral_5= 'XTEXT' )
                    // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:4668:8: enumLiteral_5= 'XTEXT'
                    {
                    enumLiteral_5=(Token)match(input,110,FOLLOW_110_in_ruleVALUE_CONVERTER_CATEGORY_MDSL10152); 

                            current = grammarAccess.getVALUE_CONVERTER_CATEGORY_MDSLAccess().getXTEXTEnumLiteralDeclaration_5().getEnumLiteral().getInstance();
                            newLeafNode(enumLiteral_5, grammarAccess.getVALUE_CONVERTER_CATEGORY_MDSLAccess().getXTEXTEnumLiteralDeclaration_5()); 
                        

                    }


                    }
                    break;

            }


            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleVALUE_CONVERTER_CATEGORY_MDSL"


    // $ANTLR start "ruleWIDGET_CATEGORY_MDSL"
    // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:4678:1: ruleWIDGET_CATEGORY_MDSL returns [Enumerator current=null] : ( (enumLiteral_0= 'OUTPUTTEXT_WIDGET' ) | (enumLiteral_1= 'NAVIGATION_WIDGET' ) | (enumLiteral_2= 'TEXT_WIDGET' ) | (enumLiteral_3= 'BOOL_WIDGET' ) | (enumLiteral_4= 'DATE_WIDGET' ) | (enumLiteral_5= 'NUMBER_WIDGET' ) | (enumLiteral_6= 'SINGLE_SELECT_WIDGET' ) | (enumLiteral_7= 'MULTI_SELECT_WIDGET' ) | (enumLiteral_8= 'XTEXT_EDITOR' ) | (enumLiteral_9= 'XTEXT_TEXT_EDITOR' ) | (enumLiteral_10= 'FLEXIBLE_WIDGET' ) ) ;
    public final Enumerator ruleWIDGET_CATEGORY_MDSL() throws RecognitionException {
        Enumerator current = null;

        Token enumLiteral_0=null;
        Token enumLiteral_1=null;
        Token enumLiteral_2=null;
        Token enumLiteral_3=null;
        Token enumLiteral_4=null;
        Token enumLiteral_5=null;
        Token enumLiteral_6=null;
        Token enumLiteral_7=null;
        Token enumLiteral_8=null;
        Token enumLiteral_9=null;
        Token enumLiteral_10=null;

         enterRule(); 
        try {
            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:4680:28: ( ( (enumLiteral_0= 'OUTPUTTEXT_WIDGET' ) | (enumLiteral_1= 'NAVIGATION_WIDGET' ) | (enumLiteral_2= 'TEXT_WIDGET' ) | (enumLiteral_3= 'BOOL_WIDGET' ) | (enumLiteral_4= 'DATE_WIDGET' ) | (enumLiteral_5= 'NUMBER_WIDGET' ) | (enumLiteral_6= 'SINGLE_SELECT_WIDGET' ) | (enumLiteral_7= 'MULTI_SELECT_WIDGET' ) | (enumLiteral_8= 'XTEXT_EDITOR' ) | (enumLiteral_9= 'XTEXT_TEXT_EDITOR' ) | (enumLiteral_10= 'FLEXIBLE_WIDGET' ) ) )
            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:4681:1: ( (enumLiteral_0= 'OUTPUTTEXT_WIDGET' ) | (enumLiteral_1= 'NAVIGATION_WIDGET' ) | (enumLiteral_2= 'TEXT_WIDGET' ) | (enumLiteral_3= 'BOOL_WIDGET' ) | (enumLiteral_4= 'DATE_WIDGET' ) | (enumLiteral_5= 'NUMBER_WIDGET' ) | (enumLiteral_6= 'SINGLE_SELECT_WIDGET' ) | (enumLiteral_7= 'MULTI_SELECT_WIDGET' ) | (enumLiteral_8= 'XTEXT_EDITOR' ) | (enumLiteral_9= 'XTEXT_TEXT_EDITOR' ) | (enumLiteral_10= 'FLEXIBLE_WIDGET' ) )
            {
            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:4681:1: ( (enumLiteral_0= 'OUTPUTTEXT_WIDGET' ) | (enumLiteral_1= 'NAVIGATION_WIDGET' ) | (enumLiteral_2= 'TEXT_WIDGET' ) | (enumLiteral_3= 'BOOL_WIDGET' ) | (enumLiteral_4= 'DATE_WIDGET' ) | (enumLiteral_5= 'NUMBER_WIDGET' ) | (enumLiteral_6= 'SINGLE_SELECT_WIDGET' ) | (enumLiteral_7= 'MULTI_SELECT_WIDGET' ) | (enumLiteral_8= 'XTEXT_EDITOR' ) | (enumLiteral_9= 'XTEXT_TEXT_EDITOR' ) | (enumLiteral_10= 'FLEXIBLE_WIDGET' ) )
            int alt99=11;
            switch ( input.LA(1) ) {
            case 111:
                {
                alt99=1;
                }
                break;
            case 112:
                {
                alt99=2;
                }
                break;
            case 113:
                {
                alt99=3;
                }
                break;
            case 114:
                {
                alt99=4;
                }
                break;
            case 115:
                {
                alt99=5;
                }
                break;
            case 116:
                {
                alt99=6;
                }
                break;
            case 117:
                {
                alt99=7;
                }
                break;
            case 118:
                {
                alt99=8;
                }
                break;
            case 119:
                {
                alt99=9;
                }
                break;
            case 120:
                {
                alt99=10;
                }
                break;
            case 121:
                {
                alt99=11;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 99, 0, input);

                throw nvae;
            }

            switch (alt99) {
                case 1 :
                    // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:4681:2: (enumLiteral_0= 'OUTPUTTEXT_WIDGET' )
                    {
                    // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:4681:2: (enumLiteral_0= 'OUTPUTTEXT_WIDGET' )
                    // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:4681:4: enumLiteral_0= 'OUTPUTTEXT_WIDGET'
                    {
                    enumLiteral_0=(Token)match(input,111,FOLLOW_111_in_ruleWIDGET_CATEGORY_MDSL10197); 

                            current = grammarAccess.getWIDGET_CATEGORY_MDSLAccess().getOUTPUTTEXT_WIDGETEnumLiteralDeclaration_0().getEnumLiteral().getInstance();
                            newLeafNode(enumLiteral_0, grammarAccess.getWIDGET_CATEGORY_MDSLAccess().getOUTPUTTEXT_WIDGETEnumLiteralDeclaration_0()); 
                        

                    }


                    }
                    break;
                case 2 :
                    // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:4687:6: (enumLiteral_1= 'NAVIGATION_WIDGET' )
                    {
                    // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:4687:6: (enumLiteral_1= 'NAVIGATION_WIDGET' )
                    // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:4687:8: enumLiteral_1= 'NAVIGATION_WIDGET'
                    {
                    enumLiteral_1=(Token)match(input,112,FOLLOW_112_in_ruleWIDGET_CATEGORY_MDSL10214); 

                            current = grammarAccess.getWIDGET_CATEGORY_MDSLAccess().getNAVIGATION_WIDGETEnumLiteralDeclaration_1().getEnumLiteral().getInstance();
                            newLeafNode(enumLiteral_1, grammarAccess.getWIDGET_CATEGORY_MDSLAccess().getNAVIGATION_WIDGETEnumLiteralDeclaration_1()); 
                        

                    }


                    }
                    break;
                case 3 :
                    // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:4693:6: (enumLiteral_2= 'TEXT_WIDGET' )
                    {
                    // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:4693:6: (enumLiteral_2= 'TEXT_WIDGET' )
                    // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:4693:8: enumLiteral_2= 'TEXT_WIDGET'
                    {
                    enumLiteral_2=(Token)match(input,113,FOLLOW_113_in_ruleWIDGET_CATEGORY_MDSL10231); 

                            current = grammarAccess.getWIDGET_CATEGORY_MDSLAccess().getTEXT_WIDGETEnumLiteralDeclaration_2().getEnumLiteral().getInstance();
                            newLeafNode(enumLiteral_2, grammarAccess.getWIDGET_CATEGORY_MDSLAccess().getTEXT_WIDGETEnumLiteralDeclaration_2()); 
                        

                    }


                    }
                    break;
                case 4 :
                    // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:4699:6: (enumLiteral_3= 'BOOL_WIDGET' )
                    {
                    // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:4699:6: (enumLiteral_3= 'BOOL_WIDGET' )
                    // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:4699:8: enumLiteral_3= 'BOOL_WIDGET'
                    {
                    enumLiteral_3=(Token)match(input,114,FOLLOW_114_in_ruleWIDGET_CATEGORY_MDSL10248); 

                            current = grammarAccess.getWIDGET_CATEGORY_MDSLAccess().getBOOL_WIDGETEnumLiteralDeclaration_3().getEnumLiteral().getInstance();
                            newLeafNode(enumLiteral_3, grammarAccess.getWIDGET_CATEGORY_MDSLAccess().getBOOL_WIDGETEnumLiteralDeclaration_3()); 
                        

                    }


                    }
                    break;
                case 5 :
                    // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:4705:6: (enumLiteral_4= 'DATE_WIDGET' )
                    {
                    // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:4705:6: (enumLiteral_4= 'DATE_WIDGET' )
                    // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:4705:8: enumLiteral_4= 'DATE_WIDGET'
                    {
                    enumLiteral_4=(Token)match(input,115,FOLLOW_115_in_ruleWIDGET_CATEGORY_MDSL10265); 

                            current = grammarAccess.getWIDGET_CATEGORY_MDSLAccess().getDATE_WIDGETEnumLiteralDeclaration_4().getEnumLiteral().getInstance();
                            newLeafNode(enumLiteral_4, grammarAccess.getWIDGET_CATEGORY_MDSLAccess().getDATE_WIDGETEnumLiteralDeclaration_4()); 
                        

                    }


                    }
                    break;
                case 6 :
                    // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:4711:6: (enumLiteral_5= 'NUMBER_WIDGET' )
                    {
                    // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:4711:6: (enumLiteral_5= 'NUMBER_WIDGET' )
                    // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:4711:8: enumLiteral_5= 'NUMBER_WIDGET'
                    {
                    enumLiteral_5=(Token)match(input,116,FOLLOW_116_in_ruleWIDGET_CATEGORY_MDSL10282); 

                            current = grammarAccess.getWIDGET_CATEGORY_MDSLAccess().getNUMBER_WIDGETEnumLiteralDeclaration_5().getEnumLiteral().getInstance();
                            newLeafNode(enumLiteral_5, grammarAccess.getWIDGET_CATEGORY_MDSLAccess().getNUMBER_WIDGETEnumLiteralDeclaration_5()); 
                        

                    }


                    }
                    break;
                case 7 :
                    // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:4717:6: (enumLiteral_6= 'SINGLE_SELECT_WIDGET' )
                    {
                    // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:4717:6: (enumLiteral_6= 'SINGLE_SELECT_WIDGET' )
                    // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:4717:8: enumLiteral_6= 'SINGLE_SELECT_WIDGET'
                    {
                    enumLiteral_6=(Token)match(input,117,FOLLOW_117_in_ruleWIDGET_CATEGORY_MDSL10299); 

                            current = grammarAccess.getWIDGET_CATEGORY_MDSLAccess().getSINGLE_SELECT_WIDGETEnumLiteralDeclaration_6().getEnumLiteral().getInstance();
                            newLeafNode(enumLiteral_6, grammarAccess.getWIDGET_CATEGORY_MDSLAccess().getSINGLE_SELECT_WIDGETEnumLiteralDeclaration_6()); 
                        

                    }


                    }
                    break;
                case 8 :
                    // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:4723:6: (enumLiteral_7= 'MULTI_SELECT_WIDGET' )
                    {
                    // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:4723:6: (enumLiteral_7= 'MULTI_SELECT_WIDGET' )
                    // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:4723:8: enumLiteral_7= 'MULTI_SELECT_WIDGET'
                    {
                    enumLiteral_7=(Token)match(input,118,FOLLOW_118_in_ruleWIDGET_CATEGORY_MDSL10316); 

                            current = grammarAccess.getWIDGET_CATEGORY_MDSLAccess().getMULTI_SELECT_WIDGETEnumLiteralDeclaration_7().getEnumLiteral().getInstance();
                            newLeafNode(enumLiteral_7, grammarAccess.getWIDGET_CATEGORY_MDSLAccess().getMULTI_SELECT_WIDGETEnumLiteralDeclaration_7()); 
                        

                    }


                    }
                    break;
                case 9 :
                    // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:4729:6: (enumLiteral_8= 'XTEXT_EDITOR' )
                    {
                    // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:4729:6: (enumLiteral_8= 'XTEXT_EDITOR' )
                    // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:4729:8: enumLiteral_8= 'XTEXT_EDITOR'
                    {
                    enumLiteral_8=(Token)match(input,119,FOLLOW_119_in_ruleWIDGET_CATEGORY_MDSL10333); 

                            current = grammarAccess.getWIDGET_CATEGORY_MDSLAccess().getXTEXT_EDITOREnumLiteralDeclaration_8().getEnumLiteral().getInstance();
                            newLeafNode(enumLiteral_8, grammarAccess.getWIDGET_CATEGORY_MDSLAccess().getXTEXT_EDITOREnumLiteralDeclaration_8()); 
                        

                    }


                    }
                    break;
                case 10 :
                    // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:4735:6: (enumLiteral_9= 'XTEXT_TEXT_EDITOR' )
                    {
                    // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:4735:6: (enumLiteral_9= 'XTEXT_TEXT_EDITOR' )
                    // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:4735:8: enumLiteral_9= 'XTEXT_TEXT_EDITOR'
                    {
                    enumLiteral_9=(Token)match(input,120,FOLLOW_120_in_ruleWIDGET_CATEGORY_MDSL10350); 

                            current = grammarAccess.getWIDGET_CATEGORY_MDSLAccess().getXTEXT_TEXT_EDITOREnumLiteralDeclaration_9().getEnumLiteral().getInstance();
                            newLeafNode(enumLiteral_9, grammarAccess.getWIDGET_CATEGORY_MDSLAccess().getXTEXT_TEXT_EDITOREnumLiteralDeclaration_9()); 
                        

                    }


                    }
                    break;
                case 11 :
                    // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:4741:6: (enumLiteral_10= 'FLEXIBLE_WIDGET' )
                    {
                    // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:4741:6: (enumLiteral_10= 'FLEXIBLE_WIDGET' )
                    // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:4741:8: enumLiteral_10= 'FLEXIBLE_WIDGET'
                    {
                    enumLiteral_10=(Token)match(input,121,FOLLOW_121_in_ruleWIDGET_CATEGORY_MDSL10367); 

                            current = grammarAccess.getWIDGET_CATEGORY_MDSLAccess().getFLEXIBLE_WIDGETEnumLiteralDeclaration_10().getEnumLiteral().getInstance();
                            newLeafNode(enumLiteral_10, grammarAccess.getWIDGET_CATEGORY_MDSLAccess().getFLEXIBLE_WIDGETEnumLiteralDeclaration_10()); 
                        

                    }


                    }
                    break;

            }


            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleWIDGET_CATEGORY_MDSL"


    // $ANTLR start "ruleCOMMAND_CATEGORY_MDSL"
    // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:4751:1: ruleCOMMAND_CATEGORY_MDSL returns [Enumerator current=null] : ( (enumLiteral_0= 'UPDATE_COMMAND' ) | (enumLiteral_1= 'GLOBAL_COMMAND' ) | (enumLiteral_2= 'ITEM_COMMAND' ) ) ;
    public final Enumerator ruleCOMMAND_CATEGORY_MDSL() throws RecognitionException {
        Enumerator current = null;

        Token enumLiteral_0=null;
        Token enumLiteral_1=null;
        Token enumLiteral_2=null;

         enterRule(); 
        try {
            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:4753:28: ( ( (enumLiteral_0= 'UPDATE_COMMAND' ) | (enumLiteral_1= 'GLOBAL_COMMAND' ) | (enumLiteral_2= 'ITEM_COMMAND' ) ) )
            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:4754:1: ( (enumLiteral_0= 'UPDATE_COMMAND' ) | (enumLiteral_1= 'GLOBAL_COMMAND' ) | (enumLiteral_2= 'ITEM_COMMAND' ) )
            {
            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:4754:1: ( (enumLiteral_0= 'UPDATE_COMMAND' ) | (enumLiteral_1= 'GLOBAL_COMMAND' ) | (enumLiteral_2= 'ITEM_COMMAND' ) )
            int alt100=3;
            switch ( input.LA(1) ) {
            case 122:
                {
                alt100=1;
                }
                break;
            case 123:
                {
                alt100=2;
                }
                break;
            case 124:
                {
                alt100=3;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 100, 0, input);

                throw nvae;
            }

            switch (alt100) {
                case 1 :
                    // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:4754:2: (enumLiteral_0= 'UPDATE_COMMAND' )
                    {
                    // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:4754:2: (enumLiteral_0= 'UPDATE_COMMAND' )
                    // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:4754:4: enumLiteral_0= 'UPDATE_COMMAND'
                    {
                    enumLiteral_0=(Token)match(input,122,FOLLOW_122_in_ruleCOMMAND_CATEGORY_MDSL10412); 

                            current = grammarAccess.getCOMMAND_CATEGORY_MDSLAccess().getUPDATE_COMMANDEnumLiteralDeclaration_0().getEnumLiteral().getInstance();
                            newLeafNode(enumLiteral_0, grammarAccess.getCOMMAND_CATEGORY_MDSLAccess().getUPDATE_COMMANDEnumLiteralDeclaration_0()); 
                        

                    }


                    }
                    break;
                case 2 :
                    // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:4760:6: (enumLiteral_1= 'GLOBAL_COMMAND' )
                    {
                    // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:4760:6: (enumLiteral_1= 'GLOBAL_COMMAND' )
                    // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:4760:8: enumLiteral_1= 'GLOBAL_COMMAND'
                    {
                    enumLiteral_1=(Token)match(input,123,FOLLOW_123_in_ruleCOMMAND_CATEGORY_MDSL10429); 

                            current = grammarAccess.getCOMMAND_CATEGORY_MDSLAccess().getGLOBAL_COMMANDEnumLiteralDeclaration_1().getEnumLiteral().getInstance();
                            newLeafNode(enumLiteral_1, grammarAccess.getCOMMAND_CATEGORY_MDSLAccess().getGLOBAL_COMMANDEnumLiteralDeclaration_1()); 
                        

                    }


                    }
                    break;
                case 3 :
                    // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:4766:6: (enumLiteral_2= 'ITEM_COMMAND' )
                    {
                    // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:4766:6: (enumLiteral_2= 'ITEM_COMMAND' )
                    // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:4766:8: enumLiteral_2= 'ITEM_COMMAND'
                    {
                    enumLiteral_2=(Token)match(input,124,FOLLOW_124_in_ruleCOMMAND_CATEGORY_MDSL10446); 

                            current = grammarAccess.getCOMMAND_CATEGORY_MDSLAccess().getITEM_COMMANDEnumLiteralDeclaration_2().getEnumLiteral().getInstance();
                            newLeafNode(enumLiteral_2, grammarAccess.getCOMMAND_CATEGORY_MDSLAccess().getITEM_COMMANDEnumLiteralDeclaration_2()); 
                        

                    }


                    }
                    break;

            }


            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleCOMMAND_CATEGORY_MDSL"


    // $ANTLR start "ruleQUERY_OPTIMISATION_LEVEL"
    // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:4776:1: ruleQUERY_OPTIMISATION_LEVEL returns [Enumerator current=null] : ( (enumLiteral_0= 'NONE' ) | (enumLiteral_1= 'VIEW' ) | (enumLiteral_2= 'CONTEXT' ) ) ;
    public final Enumerator ruleQUERY_OPTIMISATION_LEVEL() throws RecognitionException {
        Enumerator current = null;

        Token enumLiteral_0=null;
        Token enumLiteral_1=null;
        Token enumLiteral_2=null;

         enterRule(); 
        try {
            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:4778:28: ( ( (enumLiteral_0= 'NONE' ) | (enumLiteral_1= 'VIEW' ) | (enumLiteral_2= 'CONTEXT' ) ) )
            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:4779:1: ( (enumLiteral_0= 'NONE' ) | (enumLiteral_1= 'VIEW' ) | (enumLiteral_2= 'CONTEXT' ) )
            {
            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:4779:1: ( (enumLiteral_0= 'NONE' ) | (enumLiteral_1= 'VIEW' ) | (enumLiteral_2= 'CONTEXT' ) )
            int alt101=3;
            switch ( input.LA(1) ) {
            case 125:
                {
                alt101=1;
                }
                break;
            case 126:
                {
                alt101=2;
                }
                break;
            case 127:
                {
                alt101=3;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 101, 0, input);

                throw nvae;
            }

            switch (alt101) {
                case 1 :
                    // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:4779:2: (enumLiteral_0= 'NONE' )
                    {
                    // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:4779:2: (enumLiteral_0= 'NONE' )
                    // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:4779:4: enumLiteral_0= 'NONE'
                    {
                    enumLiteral_0=(Token)match(input,125,FOLLOW_125_in_ruleQUERY_OPTIMISATION_LEVEL10491); 

                            current = grammarAccess.getQUERY_OPTIMISATION_LEVELAccess().getNONEEnumLiteralDeclaration_0().getEnumLiteral().getInstance();
                            newLeafNode(enumLiteral_0, grammarAccess.getQUERY_OPTIMISATION_LEVELAccess().getNONEEnumLiteralDeclaration_0()); 
                        

                    }


                    }
                    break;
                case 2 :
                    // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:4785:6: (enumLiteral_1= 'VIEW' )
                    {
                    // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:4785:6: (enumLiteral_1= 'VIEW' )
                    // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:4785:8: enumLiteral_1= 'VIEW'
                    {
                    enumLiteral_1=(Token)match(input,126,FOLLOW_126_in_ruleQUERY_OPTIMISATION_LEVEL10508); 

                            current = grammarAccess.getQUERY_OPTIMISATION_LEVELAccess().getVIEWEnumLiteralDeclaration_1().getEnumLiteral().getInstance();
                            newLeafNode(enumLiteral_1, grammarAccess.getQUERY_OPTIMISATION_LEVELAccess().getVIEWEnumLiteralDeclaration_1()); 
                        

                    }


                    }
                    break;
                case 3 :
                    // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:4791:6: (enumLiteral_2= 'CONTEXT' )
                    {
                    // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:4791:6: (enumLiteral_2= 'CONTEXT' )
                    // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:4791:8: enumLiteral_2= 'CONTEXT'
                    {
                    enumLiteral_2=(Token)match(input,127,FOLLOW_127_in_ruleQUERY_OPTIMISATION_LEVEL10525); 

                            current = grammarAccess.getQUERY_OPTIMISATION_LEVELAccess().getCONTEXTEnumLiteralDeclaration_2().getEnumLiteral().getInstance();
                            newLeafNode(enumLiteral_2, grammarAccess.getQUERY_OPTIMISATION_LEVELAccess().getCONTEXTEnumLiteralDeclaration_2()); 
                        

                    }


                    }
                    break;

            }


            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleQUERY_OPTIMISATION_LEVEL"

    // Delegated rules


 

    public static final BitSet FOLLOW_ruleMADConfiguration_in_entryRuleMADConfiguration75 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleMADConfiguration85 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleImport_in_ruleMADConfiguration131 = new BitSet(new long[]{0x0322208400310802L,0x0000008040080000L});
    public static final BitSet FOLLOW_ruleMADConfigElement_in_ruleMADConfiguration153 = new BitSet(new long[]{0x0322208400310002L,0x0000008040080000L});
    public static final BitSet FOLLOW_ruleMADConfigElement_in_entryRuleMADConfigElement190 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleMADConfigElement200 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleLayerMdsl_in_ruleMADConfigElement247 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleForeignModelMdsl_in_ruleMADConfigElement274 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleXtextLanguageDescriptorMdsl_in_ruleMADConfigElement301 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleQueryEvaluatorMdsl_in_ruleMADConfigElement328 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleQueryDeclaration_in_ruleMADConfigElement355 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleWidgetType_in_ruleMADConfigElement382 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleUITabMdsl_in_ruleMADConfigElement409 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleCommandDeclaration_in_ruleMADConfigElement436 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleTypeConfigurationMdsl_in_ruleMADConfigElement463 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleTextMacro_in_ruleMADConfigElement490 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleI18NBundleMdsl_in_ruleMADConfigElement517 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleIconDescriptorMdsl_in_ruleMADConfigElement544 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleImport_in_entryRuleImport579 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleImport589 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_11_in_ruleImport626 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_STRING_in_ruleImport643 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleClassDescriptorMdsl_in_entryRuleClassDescriptorMdsl684 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleClassDescriptorMdsl694 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleClassDescriptorMdsl736 = new BitSet(new long[]{0x0000000000001002L});
    public static final BitSet FOLLOW_12_in_ruleClassDescriptorMdsl754 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleClassDescriptorMdsl771 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rulePropertyTypeMdsl_in_entryRulePropertyTypeMdsl814 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRulePropertyTypeMdsl824 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_rulePropertyTypeMdsl866 = new BitSet(new long[]{0x0000000000002000L});
    public static final BitSet FOLLOW_13_in_rulePropertyTypeMdsl883 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_STRING_in_rulePropertyTypeMdsl900 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rulePropertyMdsl_in_entryRulePropertyMdsl941 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRulePropertyMdsl951 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_rulePropertyMdsl996 = new BitSet(new long[]{0x0000000000004000L});
    public static final BitSet FOLLOW_14_in_rulePropertyMdsl1008 = new BitSet(new long[]{0x0000000000000010L,0x0000010000000000L});
    public static final BitSet FOLLOW_rulePropertyValueMdsl_in_rulePropertyMdsl1029 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rulePropertyValueMdsl_in_entryRulePropertyValueMdsl1065 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRulePropertyValueMdsl1075 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rulePropValueExprFragment_in_rulePropertyValueMdsl1121 = new BitSet(new long[]{0x0000000000008002L});
    public static final BitSet FOLLOW_15_in_rulePropertyValueMdsl1134 = new BitSet(new long[]{0x0000000000000010L,0x0000010000000000L});
    public static final BitSet FOLLOW_rulePropValueExprFragment_in_rulePropertyValueMdsl1155 = new BitSet(new long[]{0x0000000000008002L});
    public static final BitSet FOLLOW_rulePropValueExprFragment_in_entryRulePropValueExprFragment1193 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRulePropValueExprFragment1203 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleLiteraPropValueExprFragment_in_rulePropValueExprFragment1250 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleTextMacroRef_in_rulePropValueExprFragment1277 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleLiteraPropValueExprFragment_in_entryRuleLiteraPropValueExprFragment1312 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleLiteraPropValueExprFragment1322 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_STRING_in_ruleLiteraPropValueExprFragment1363 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleIconDescriptorMdsl_in_entryRuleIconDescriptorMdsl1403 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleIconDescriptorMdsl1413 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_16_in_ruleIconDescriptorMdsl1450 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleIconDescriptorMdsl1467 = new BitSet(new long[]{0x00000000000E0000L});
    public static final BitSet FOLLOW_17_in_ruleIconDescriptorMdsl1485 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_STRING_in_ruleIconDescriptorMdsl1502 = new BitSet(new long[]{0x00000000000C0000L});
    public static final BitSet FOLLOW_18_in_ruleIconDescriptorMdsl1523 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_ruleClassDescriptorMdsl_in_ruleIconDescriptorMdsl1544 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_19_in_ruleIconDescriptorMdsl1564 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_STRING_in_ruleIconDescriptorMdsl1581 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleI18NBundleMdsl_in_entryRuleI18NBundleMdsl1624 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleI18NBundleMdsl1634 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_20_in_ruleI18NBundleMdsl1671 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleI18NBundleMdsl1688 = new BitSet(new long[]{0x00000000000E0000L});
    public static final BitSet FOLLOW_17_in_ruleI18NBundleMdsl1706 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_STRING_in_ruleI18NBundleMdsl1723 = new BitSet(new long[]{0x00000000000C0000L});
    public static final BitSet FOLLOW_18_in_ruleI18NBundleMdsl1744 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_ruleClassDescriptorMdsl_in_ruleI18NBundleMdsl1765 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_19_in_ruleI18NBundleMdsl1785 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_STRING_in_ruleI18NBundleMdsl1802 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleForeignModelMdsl_in_entryRuleForeignModelMdsl1845 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleForeignModelMdsl1855 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_21_in_ruleForeignModelMdsl1892 = new BitSet(new long[]{0x0000000000400000L});
    public static final BitSet FOLLOW_22_in_ruleForeignModelMdsl1904 = new BitSet(new long[]{0x0000000000800000L});
    public static final BitSet FOLLOW_23_in_ruleForeignModelMdsl1916 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleForeignModelMdsl1933 = new BitSet(new long[]{0x0000000000002000L});
    public static final BitSet FOLLOW_13_in_ruleForeignModelMdsl1950 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_STRING_in_ruleForeignModelMdsl1967 = new BitSet(new long[]{0x00000000E0020000L});
    public static final BitSet FOLLOW_17_in_ruleForeignModelMdsl1985 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_STRING_in_ruleForeignModelMdsl2002 = new BitSet(new long[]{0x00000000E0020000L});
    public static final BitSet FOLLOW_ruleModelProviderMdsl_in_ruleForeignModelMdsl2030 = new BitSet(new long[]{0x000000401D000000L});
    public static final BitSet FOLLOW_24_in_ruleForeignModelMdsl2043 = new BitSet(new long[]{0x0000000002000000L});
    public static final BitSet FOLLOW_25_in_ruleForeignModelMdsl2055 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_ruleClassDescriptorMdsl_in_ruleForeignModelMdsl2076 = new BitSet(new long[]{0x000000401C000000L});
    public static final BitSet FOLLOW_26_in_ruleForeignModelMdsl2091 = new BitSet(new long[]{0x0000000002000000L});
    public static final BitSet FOLLOW_25_in_ruleForeignModelMdsl2103 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_ruleClassDescriptorMdsl_in_ruleForeignModelMdsl2124 = new BitSet(new long[]{0x0000004018000000L});
    public static final BitSet FOLLOW_ruleXtextLanguageReference_in_ruleForeignModelMdsl2147 = new BitSet(new long[]{0x0000000018000000L});
    public static final BitSet FOLLOW_27_in_ruleForeignModelMdsl2161 = new BitSet(new long[]{0x0000000000000030L,0x0000011380000000L});
    public static final BitSet FOLLOW_ruleQuery_in_ruleForeignModelMdsl2182 = new BitSet(new long[]{0x0000000010000000L});
    public static final BitSet FOLLOW_28_in_ruleForeignModelMdsl2196 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleModelProviderMdsl_in_entryRuleModelProviderMdsl2232 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleModelProviderMdsl2242 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleURIModelProviderMdsl_in_ruleModelProviderMdsl2289 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleURIExtensionModelProviderMdsl_in_ruleModelProviderMdsl2316 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleCustomModelProviderMdsl_in_ruleModelProviderMdsl2343 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleURIExtensionModelProviderMdsl_in_entryRuleURIExtensionModelProviderMdsl2378 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleURIExtensionModelProviderMdsl2388 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_29_in_ruleURIExtensionModelProviderMdsl2425 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_STRING_in_ruleURIExtensionModelProviderMdsl2442 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleURIModelProviderMdsl_in_entryRuleURIModelProviderMdsl2483 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleURIModelProviderMdsl2493 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_30_in_ruleURIModelProviderMdsl2530 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_STRING_in_ruleURIModelProviderMdsl2547 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleCustomModelProviderMdsl_in_entryRuleCustomModelProviderMdsl2588 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleCustomModelProviderMdsl2598 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_31_in_ruleCustomModelProviderMdsl2635 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_ruleClassDescriptorMdsl_in_ruleCustomModelProviderMdsl2656 = new BitSet(new long[]{0x0000000100000002L});
    public static final BitSet FOLLOW_32_in_ruleCustomModelProviderMdsl2669 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_STRING_in_ruleCustomModelProviderMdsl2686 = new BitSet(new long[]{0x0000000200000002L});
    public static final BitSet FOLLOW_33_in_ruleCustomModelProviderMdsl2704 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_STRING_in_ruleCustomModelProviderMdsl2721 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleXtextLanguageDescriptorMdsl_in_entryRuleXtextLanguageDescriptorMdsl2766 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleXtextLanguageDescriptorMdsl2776 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_34_in_ruleXtextLanguageDescriptorMdsl2813 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleXtextLanguageDescriptorMdsl2830 = new BitSet(new long[]{0x0000000800000000L});
    public static final BitSet FOLLOW_35_in_ruleXtextLanguageDescriptorMdsl2847 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleXtextLanguageDescriptorMdsl2864 = new BitSet(new long[]{0x0000001000000000L});
    public static final BitSet FOLLOW_36_in_ruleXtextLanguageDescriptorMdsl2881 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleXtextLanguageDescriptorMdsl2898 = new BitSet(new long[]{0x0000002000000000L});
    public static final BitSet FOLLOW_37_in_ruleXtextLanguageDescriptorMdsl2915 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleXtextLanguageDescriptorMdsl2932 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleXtextLanguageReference_in_entryRuleXtextLanguageReference2973 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleXtextLanguageReference2983 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_38_in_ruleXtextLanguageReference3020 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleXtextLanguageReference3040 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleQueryEvaluatorMdsl_in_entryRuleQueryEvaluatorMdsl3076 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleQueryEvaluatorMdsl3086 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_39_in_ruleQueryEvaluatorMdsl3123 = new BitSet(new long[]{0x0000000000400000L});
    public static final BitSet FOLLOW_22_in_ruleQueryEvaluatorMdsl3135 = new BitSet(new long[]{0x0000010000000000L});
    public static final BitSet FOLLOW_40_in_ruleQueryEvaluatorMdsl3147 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleQueryEvaluatorMdsl3164 = new BitSet(new long[]{0x0000000000002000L});
    public static final BitSet FOLLOW_13_in_ruleQueryEvaluatorMdsl3181 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_STRING_in_ruleQueryEvaluatorMdsl3198 = new BitSet(new long[]{0x0000020000000000L});
    public static final BitSet FOLLOW_41_in_ruleQueryEvaluatorMdsl3215 = new BitSet(new long[]{0x0000040000000000L});
    public static final BitSet FOLLOW_42_in_ruleQueryEvaluatorMdsl3227 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_ruleClassDescriptorMdsl_in_ruleQueryEvaluatorMdsl3248 = new BitSet(new long[]{0x0000180010020000L});
    public static final BitSet FOLLOW_43_in_ruleQueryEvaluatorMdsl3261 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_rulePropertyTypeMdsl_in_ruleQueryEvaluatorMdsl3282 = new BitSet(new long[]{0x0000100210020000L});
    public static final BitSet FOLLOW_33_in_ruleQueryEvaluatorMdsl3295 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_rulePropertyTypeMdsl_in_ruleQueryEvaluatorMdsl3316 = new BitSet(new long[]{0x0000100210020000L});
    public static final BitSet FOLLOW_44_in_ruleQueryEvaluatorMdsl3333 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_ruleClassDescriptorMdsl_in_ruleQueryEvaluatorMdsl3354 = new BitSet(new long[]{0x0000000010020000L});
    public static final BitSet FOLLOW_17_in_ruleQueryEvaluatorMdsl3369 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_STRING_in_ruleQueryEvaluatorMdsl3386 = new BitSet(new long[]{0x0000000010000000L});
    public static final BitSet FOLLOW_28_in_ruleQueryEvaluatorMdsl3405 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleWidgetType_in_entryRuleWidgetType3441 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleWidgetType3451 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_45_in_ruleWidgetType3488 = new BitSet(new long[]{0x0000000000400000L});
    public static final BitSet FOLLOW_22_in_ruleWidgetType3500 = new BitSet(new long[]{0x0000400000000000L});
    public static final BitSet FOLLOW_46_in_ruleWidgetType3512 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleWidgetType3529 = new BitSet(new long[]{0x0000800000000000L});
    public static final BitSet FOLLOW_47_in_ruleWidgetType3546 = new BitSet(new long[]{0x0000000000000000L,0x03FF800000000000L});
    public static final BitSet FOLLOW_ruleWIDGET_CATEGORY_MDSL_in_ruleWidgetType3567 = new BitSet(new long[]{0x0000000000002000L});
    public static final BitSet FOLLOW_13_in_ruleWidgetType3579 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_STRING_in_ruleWidgetType3596 = new BitSet(new long[]{0x0001000000000000L});
    public static final BitSet FOLLOW_48_in_ruleWidgetType3613 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_ruleClassDescriptorMdsl_in_ruleWidgetType3634 = new BitSet(new long[]{0x0000000010020000L});
    public static final BitSet FOLLOW_17_in_ruleWidgetType3647 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_STRING_in_ruleWidgetType3664 = new BitSet(new long[]{0x0000000010000000L});
    public static final BitSet FOLLOW_28_in_ruleWidgetType3683 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleUITabMdsl_in_entryRuleUITabMdsl3719 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleUITabMdsl3729 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_49_in_ruleUITabMdsl3766 = new BitSet(new long[]{0x0004000000000000L});
    public static final BitSet FOLLOW_50_in_ruleUITabMdsl3778 = new BitSet(new long[]{0x0000000000400000L});
    public static final BitSet FOLLOW_22_in_ruleUITabMdsl3790 = new BitSet(new long[]{0x0008000000000000L});
    public static final BitSet FOLLOW_51_in_ruleUITabMdsl3802 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleUITabMdsl3819 = new BitSet(new long[]{0x0010000000002000L});
    public static final BitSet FOLLOW_52_in_ruleUITabMdsl3842 = new BitSet(new long[]{0x0000000000002000L});
    public static final BitSet FOLLOW_13_in_ruleUITabMdsl3868 = new BitSet(new long[]{0x0000000000000010L,0x0000010000000000L});
    public static final BitSet FOLLOW_ruleFormatExpr_in_ruleUITabMdsl3889 = new BitSet(new long[]{0x0000000010020000L});
    public static final BitSet FOLLOW_17_in_ruleUITabMdsl3902 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_STRING_in_ruleUITabMdsl3919 = new BitSet(new long[]{0x0000000010000000L});
    public static final BitSet FOLLOW_28_in_ruleUITabMdsl3938 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleLayerMdsl_in_entryRuleLayerMdsl3974 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleLayerMdsl3984 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_53_in_ruleLayerMdsl4021 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleLayerMdsl4038 = new BitSet(new long[]{0x0000000000400000L});
    public static final BitSet FOLLOW_22_in_ruleLayerMdsl4055 = new BitSet(new long[]{0x0010000000002000L});
    public static final BitSet FOLLOW_52_in_ruleLayerMdsl4073 = new BitSet(new long[]{0x0000000000002000L});
    public static final BitSet FOLLOW_13_in_ruleLayerMdsl4099 = new BitSet(new long[]{0x0000000000000010L,0x0000010000000000L});
    public static final BitSet FOLLOW_ruleFormatExpr_in_ruleLayerMdsl4120 = new BitSet(new long[]{0x0040000010020000L});
    public static final BitSet FOLLOW_17_in_ruleLayerMdsl4133 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_STRING_in_ruleLayerMdsl4150 = new BitSet(new long[]{0x0040000010000000L});
    public static final BitSet FOLLOW_54_in_ruleLayerMdsl4170 = new BitSet(new long[]{0x0080000000000000L});
    public static final BitSet FOLLOW_55_in_ruleLayerMdsl4182 = new BitSet(new long[]{0x0000000000400000L});
    public static final BitSet FOLLOW_22_in_ruleLayerMdsl4194 = new BitSet(new long[]{0x0020000010000000L});
    public static final BitSet FOLLOW_ruleLayerMdsl_in_ruleLayerMdsl4215 = new BitSet(new long[]{0x0020000010000000L});
    public static final BitSet FOLLOW_28_in_ruleLayerMdsl4228 = new BitSet(new long[]{0x0000000010000000L});
    public static final BitSet FOLLOW_28_in_ruleLayerMdsl4242 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleTypeConfigurationMdsl_in_entryRuleTypeConfigurationMdsl4278 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleTypeConfigurationMdsl4288 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_56_in_ruleTypeConfigurationMdsl4331 = new BitSet(new long[]{0x0200000000000000L});
    public static final BitSet FOLLOW_57_in_ruleTypeConfigurationMdsl4357 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleTypeConfigurationMdsl4374 = new BitSet(new long[]{0x0400000000400000L});
    public static final BitSet FOLLOW_58_in_ruleTypeConfigurationMdsl4392 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleTypeConfigurationMdsl4412 = new BitSet(new long[]{0x0000000000400000L});
    public static final BitSet FOLLOW_22_in_ruleTypeConfigurationMdsl4426 = new BitSet(new long[]{0x3810000000000000L});
    public static final BitSet FOLLOW_52_in_ruleTypeConfigurationMdsl4445 = new BitSet(new long[]{0x0800000000000000L});
    public static final BitSet FOLLOW_59_in_ruleTypeConfigurationMdsl4471 = new BitSet(new long[]{0x0000000000000010L,0x0000010000000000L});
    public static final BitSet FOLLOW_ruleFormatExpr_in_ruleTypeConfigurationMdsl4492 = new BitSet(new long[]{0x3000000000000000L});
    public static final BitSet FOLLOW_60_in_ruleTypeConfigurationMdsl4513 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleTypeConfigurationMdsl4546 = new BitSet(new long[]{0x2000000200000000L});
    public static final BitSet FOLLOW_33_in_ruleTypeConfigurationMdsl4559 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleTypeConfigurationMdsl4579 = new BitSet(new long[]{0x2000000200000000L});
    public static final BitSet FOLLOW_61_in_ruleTypeConfigurationMdsl4595 = new BitSet(new long[]{0xC000000010000000L,0x0000000000000008L});
    public static final BitSet FOLLOW_ruleTypeConfigurationTemplateElement_in_ruleTypeConfigurationMdsl4616 = new BitSet(new long[]{0xC000000010000000L,0x0000000000000008L});
    public static final BitSet FOLLOW_62_in_ruleTypeConfigurationMdsl4636 = new BitSet(new long[]{0x0000000010000020L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleTypeConfigurationMdsl4669 = new BitSet(new long[]{0x0000000010000020L});
    public static final BitSet FOLLOW_28_in_ruleTypeConfigurationMdsl4684 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleTypeConfigurationTemplateElement_in_entryRuleTypeConfigurationTemplateElement4720 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleTypeConfigurationTemplateElement4730 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleWidgetConfigurationMdsl_in_ruleTypeConfigurationTemplateElement4777 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleIncludeTemplateElementMdsl_in_ruleTypeConfigurationTemplateElement4804 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleIncludeTemplateElementMdsl_in_entryRuleIncludeTemplateElementMdsl4839 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleIncludeTemplateElementMdsl4849 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_63_in_ruleIncludeTemplateElementMdsl4886 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleIncludeTemplateElementMdsl4903 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000001L});
    public static final BitSet FOLLOW_64_in_ruleIncludeTemplateElementMdsl4920 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleIncludeTemplateElementMdsl4940 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000002L});
    public static final BitSet FOLLOW_65_in_ruleIncludeTemplateElementMdsl4952 = new BitSet(new long[]{0x0000000000000030L,0x0000015380000000L});
    public static final BitSet FOLLOW_ruleQueryUsage_in_ruleIncludeTemplateElementMdsl4973 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleValueConverter_in_entryRuleValueConverter5009 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleValueConverter5019 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleBasicTypeValueConverter_in_ruleValueConverter5066 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleQueryBasedValueConverter_in_ruleValueConverter5093 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleQueryBasedValueConverter_in_entryRuleQueryBasedValueConverter5128 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleQueryBasedValueConverter5138 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_66_in_ruleQueryBasedValueConverter5175 = new BitSet(new long[]{0x0000000000000030L,0x0000015380000000L});
    public static final BitSet FOLLOW_ruleQueryUsage_in_ruleQueryBasedValueConverter5196 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleBasicTypeValueConverter_in_entryRuleBasicTypeValueConverter5232 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleBasicTypeValueConverter5242 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleVALUE_CONVERTER_CATEGORY_MDSL_in_ruleBasicTypeValueConverter5288 = new BitSet(new long[]{0x0000000002000002L});
    public static final BitSet FOLLOW_25_in_ruleBasicTypeValueConverter5301 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_STRING_in_ruleBasicTypeValueConverter5318 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleWidgetConfigurationMdsl_in_entryRuleWidgetConfigurationMdsl5361 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleWidgetConfigurationMdsl5371 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_67_in_ruleWidgetConfigurationMdsl5408 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleWidgetConfigurationMdsl5425 = new BitSet(new long[]{0x0010000000022000L,0x0000000000000030L});
    public static final BitSet FOLLOW_17_in_ruleWidgetConfigurationMdsl5443 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_STRING_in_ruleWidgetConfigurationMdsl5460 = new BitSet(new long[]{0x0010000000002000L,0x0000000000000030L});
    public static final BitSet FOLLOW_68_in_ruleWidgetConfigurationMdsl5480 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleWidgetConfigurationMdsl5500 = new BitSet(new long[]{0x0010000000002000L,0x0000000000000020L});
    public static final BitSet FOLLOW_69_in_ruleWidgetConfigurationMdsl5515 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleWidgetConfigurationMdsl5535 = new BitSet(new long[]{0x0010000200002000L});
    public static final BitSet FOLLOW_33_in_ruleWidgetConfigurationMdsl5548 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleWidgetConfigurationMdsl5568 = new BitSet(new long[]{0x0010000200002000L});
    public static final BitSet FOLLOW_52_in_ruleWidgetConfigurationMdsl5590 = new BitSet(new long[]{0x0000000000002000L});
    public static final BitSet FOLLOW_13_in_ruleWidgetConfigurationMdsl5616 = new BitSet(new long[]{0x0000000000000010L,0x0000010000000000L});
    public static final BitSet FOLLOW_ruleFormatExpr_in_ruleWidgetConfigurationMdsl5637 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000040L});
    public static final BitSet FOLLOW_70_in_ruleWidgetConfigurationMdsl5649 = new BitSet(new long[]{0x0000000000000000L,0x03FF800000000000L});
    public static final BitSet FOLLOW_ruleWIDGET_CATEGORY_MDSL_in_ruleWidgetConfigurationMdsl5670 = new BitSet(new long[]{0x0010004002000002L,0x000000000001FF82L});
    public static final BitSet FOLLOW_25_in_ruleWidgetConfigurationMdsl5683 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleWidgetConfigurationMdsl5703 = new BitSet(new long[]{0x0010004000000002L,0x000000000001FF82L});
    public static final BitSet FOLLOW_ruleXtextLanguageReference_in_ruleWidgetConfigurationMdsl5726 = new BitSet(new long[]{0x0010000000000002L,0x000000000001FF82L});
    public static final BitSet FOLLOW_71_in_ruleWidgetConfigurationMdsl5741 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_72_in_ruleWidgetConfigurationMdsl5759 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleWidgetConfigurationMdsl5780 = new BitSet(new long[]{0x0010000000000002L,0x000000000001FE02L});
    public static final BitSet FOLLOW_73_in_ruleWidgetConfigurationMdsl5840 = new BitSet(new long[]{0x0000000000000030L,0x0000011380000000L});
    public static final BitSet FOLLOW_ruleQuery_in_ruleWidgetConfigurationMdsl5861 = new BitSet(new long[]{0x0010000000000002L,0x000000000001FE02L});
    public static final BitSet FOLLOW_74_in_ruleWidgetConfigurationMdsl5929 = new BitSet(new long[]{0x0000000000000030L,0x0000011380000000L});
    public static final BitSet FOLLOW_ruleQuery_in_ruleWidgetConfigurationMdsl5950 = new BitSet(new long[]{0x0010000000000002L,0x000000000001FE02L});
    public static final BitSet FOLLOW_65_in_ruleWidgetConfigurationMdsl6004 = new BitSet(new long[]{0x0000000000000030L,0x0000015380000000L});
    public static final BitSet FOLLOW_ruleQueryUsage_in_ruleWidgetConfigurationMdsl6025 = new BitSet(new long[]{0x0010000000000002L,0x000000000001F800L});
    public static final BitSet FOLLOW_75_in_ruleWidgetConfigurationMdsl6040 = new BitSet(new long[]{0x0000000000000000L,0x00007E0000000004L});
    public static final BitSet FOLLOW_ruleValueConverter_in_ruleWidgetConfigurationMdsl6061 = new BitSet(new long[]{0x0010000000000002L,0x000000000001F000L});
    public static final BitSet FOLLOW_76_in_ruleWidgetConfigurationMdsl6076 = new BitSet(new long[]{0x0010000000000002L,0x000000000003E000L});
    public static final BitSet FOLLOW_ruleValidatorMdsl_in_ruleWidgetConfigurationMdsl6097 = new BitSet(new long[]{0x0010000000000002L,0x000000000003E000L});
    public static final BitSet FOLLOW_52_in_ruleWidgetConfigurationMdsl6119 = new BitSet(new long[]{0x0000000000000000L,0x0000000000002000L});
    public static final BitSet FOLLOW_77_in_ruleWidgetConfigurationMdsl6145 = new BitSet(new long[]{0x0000000000000010L,0x0000010000000000L});
    public static final BitSet FOLLOW_ruleFormatExpr_in_ruleWidgetConfigurationMdsl6166 = new BitSet(new long[]{0x0010000000000002L,0x000000000001C000L});
    public static final BitSet FOLLOW_78_in_ruleWidgetConfigurationMdsl6181 = new BitSet(new long[]{0x0000000000000030L,0x0000015380000000L});
    public static final BitSet FOLLOW_ruleQueryUsage_in_ruleWidgetConfigurationMdsl6202 = new BitSet(new long[]{0x0010000000000002L,0x0000000000018000L});
    public static final BitSet FOLLOW_52_in_ruleWidgetConfigurationMdsl6223 = new BitSet(new long[]{0x0000000000000000L,0x0000000000008000L});
    public static final BitSet FOLLOW_79_in_ruleWidgetConfigurationMdsl6249 = new BitSet(new long[]{0x0000000000000010L,0x0000010000000000L});
    public static final BitSet FOLLOW_ruleFormatExpr_in_ruleWidgetConfigurationMdsl6270 = new BitSet(new long[]{0x0000000000000002L,0x0000000000010000L});
    public static final BitSet FOLLOW_80_in_ruleWidgetConfigurationMdsl6285 = new BitSet(new long[]{0x0000000000000020L,0x1C00000000000000L});
    public static final BitSet FOLLOW_ruleCommand_in_ruleWidgetConfigurationMdsl6306 = new BitSet(new long[]{0x0000000200000002L});
    public static final BitSet FOLLOW_33_in_ruleWidgetConfigurationMdsl6319 = new BitSet(new long[]{0x0000000000000020L,0x1C00000000000000L});
    public static final BitSet FOLLOW_ruleCommand_in_ruleWidgetConfigurationMdsl6340 = new BitSet(new long[]{0x0000000200000002L});
    public static final BitSet FOLLOW_ruleValidatorMdsl_in_entryRuleValidatorMdsl6380 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleValidatorMdsl6390 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_81_in_ruleValidatorMdsl6427 = new BitSet(new long[]{0x0000000000000030L,0x0000015380000000L});
    public static final BitSet FOLLOW_ruleQueryUsage_in_ruleValidatorMdsl6448 = new BitSet(new long[]{0x0010000000000000L,0x0000000000040000L});
    public static final BitSet FOLLOW_52_in_ruleValidatorMdsl6466 = new BitSet(new long[]{0x0000000000000000L,0x0000000000040000L});
    public static final BitSet FOLLOW_82_in_ruleValidatorMdsl6492 = new BitSet(new long[]{0x0000000000000010L,0x0000010000000000L});
    public static final BitSet FOLLOW_ruleFormatExpr_in_ruleValidatorMdsl6513 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleCommand_in_entryRuleCommand6549 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleCommand6559 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleCommandDefinitionMdsl_in_ruleCommand6606 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleCommandRefMdsl_in_ruleCommand6633 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleCommandDeclaration_in_entryRuleCommandDeclaration6668 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleCommandDeclaration6678 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_83_in_ruleCommandDeclaration6715 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleCommandDeclaration6732 = new BitSet(new long[]{0x0000000000400000L});
    public static final BitSet FOLLOW_22_in_ruleCommandDeclaration6749 = new BitSet(new long[]{0x0000000000022000L,0x1C00000000000000L});
    public static final BitSet FOLLOW_13_in_ruleCommandDeclaration6762 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_STRING_in_ruleCommandDeclaration6779 = new BitSet(new long[]{0x0000000000020000L,0x1C00000000000000L});
    public static final BitSet FOLLOW_17_in_ruleCommandDeclaration6799 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_STRING_in_ruleCommandDeclaration6816 = new BitSet(new long[]{0x0000000000000000L,0x1C00000000000000L});
    public static final BitSet FOLLOW_ruleCommandDefinitionMdsl_in_ruleCommandDeclaration6844 = new BitSet(new long[]{0x0000000010000000L});
    public static final BitSet FOLLOW_28_in_ruleCommandDeclaration6856 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleCommandDefinitionMdsl_in_entryRuleCommandDefinitionMdsl6892 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleCommandDefinitionMdsl6902 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleCOMMAND_CATEGORY_MDSL_in_ruleCommandDefinitionMdsl6948 = new BitSet(new long[]{0x0010000000000010L,0x0000010000000000L});
    public static final BitSet FOLLOW_52_in_ruleCommandDefinitionMdsl6966 = new BitSet(new long[]{0x0000000000000010L,0x0000010000000000L});
    public static final BitSet FOLLOW_ruleFormatExpr_in_ruleCommandDefinitionMdsl7001 = new BitSet(new long[]{0x0000000000000000L,0x0000000000300000L});
    public static final BitSet FOLLOW_84_in_ruleCommandDefinitionMdsl7014 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleCommandDefinitionMdsl7034 = new BitSet(new long[]{0x0000000000000000L,0x0000000000200000L});
    public static final BitSet FOLLOW_85_in_ruleCommandDefinitionMdsl7048 = new BitSet(new long[]{0x0000000000000030L,0x0000011380000000L});
    public static final BitSet FOLLOW_ruleQuery_in_ruleCommandDefinitionMdsl7069 = new BitSet(new long[]{0x0000000000000002L,0x0000000000C00000L});
    public static final BitSet FOLLOW_86_in_ruleCommandDefinitionMdsl7082 = new BitSet(new long[]{0x0000000000000002L,0x000000000C800000L});
    public static final BitSet FOLLOW_ruleUICommandMdsl_in_ruleCommandDefinitionMdsl7103 = new BitSet(new long[]{0x0000000000000002L,0x000000000C800000L});
    public static final BitSet FOLLOW_87_in_ruleCommandDefinitionMdsl7119 = new BitSet(new long[]{0x0000000000000002L,0x000000000C000000L});
    public static final BitSet FOLLOW_ruleUICommandMdsl_in_ruleCommandDefinitionMdsl7140 = new BitSet(new long[]{0x0000000000000002L,0x000000000C000000L});
    public static final BitSet FOLLOW_ruleCommandRefMdsl_in_entryRuleCommandRefMdsl7179 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleCommandRefMdsl7189 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleCommandRefMdsl7234 = new BitSet(new long[]{0x0000000000000002L,0x0000000001000000L});
    public static final BitSet FOLLOW_88_in_ruleCommandRefMdsl7247 = new BitSet(new long[]{0x0010000000000010L,0x0000010000000000L});
    public static final BitSet FOLLOW_52_in_ruleCommandRefMdsl7265 = new BitSet(new long[]{0x0000000000000010L,0x0000010000000000L});
    public static final BitSet FOLLOW_ruleFormatExpr_in_ruleCommandRefMdsl7300 = new BitSet(new long[]{0x0000000000000000L,0x0000000002000000L});
    public static final BitSet FOLLOW_89_in_ruleCommandRefMdsl7312 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleUICommandMdsl_in_entryRuleUICommandMdsl7350 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleUICommandMdsl7360 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleReloadWidgetsUICommand_in_ruleUICommandMdsl7407 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleReloadViewUICommand_in_ruleUICommandMdsl7434 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleDisplayViewUICommand_in_ruleUICommandMdsl7461 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleDisplayViewUICommand_in_entryRuleDisplayViewUICommand7496 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleDisplayViewUICommand7506 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_90_in_ruleDisplayViewUICommand7543 = new BitSet(new long[]{0x0400000000000002L});
    public static final BitSet FOLLOW_58_in_ruleDisplayViewUICommand7556 = new BitSet(new long[]{0x0000000000000030L,0x0000015380000000L});
    public static final BitSet FOLLOW_ruleQueryUsage_in_ruleDisplayViewUICommand7577 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleReloadViewUICommand_in_entryRuleReloadViewUICommand7615 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleReloadViewUICommand7625 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_91_in_ruleReloadViewUICommand7671 = new BitSet(new long[]{0x0000000000000000L,0x0000000010000000L});
    public static final BitSet FOLLOW_92_in_ruleReloadViewUICommand7683 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleReloadWidgetsUICommand_in_entryRuleReloadWidgetsUICommand7719 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleReloadWidgetsUICommand7729 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_91_in_ruleReloadWidgetsUICommand7766 = new BitSet(new long[]{0x0000000000000000L,0x0000000020000000L});
    public static final BitSet FOLLOW_93_in_ruleReloadWidgetsUICommand7778 = new BitSet(new long[]{0x0000000000000022L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleReloadWidgetsUICommand7798 = new BitSet(new long[]{0x0000000000000022L});
    public static final BitSet FOLLOW_ruleQueryUsage_in_entryRuleQueryUsage7835 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleQueryUsage7845 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleQuery_in_ruleQueryUsage7892 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleQueryChain_in_ruleQueryUsage7919 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleQuery_in_entryRuleQuery7954 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleQuery7964 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleQueryDefinitionMdsl_in_ruleQuery8011 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleQueryRefMdsl_in_ruleQuery8038 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleQueryDeclaration_in_entryRuleQueryDeclaration8073 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleQueryDeclaration8083 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_94_in_ruleQueryDeclaration8120 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleQueryDeclaration8137 = new BitSet(new long[]{0x0000000000400000L});
    public static final BitSet FOLLOW_22_in_ruleQueryDeclaration8154 = new BitSet(new long[]{0x0000000000022010L,0x0000011380000000L});
    public static final BitSet FOLLOW_13_in_ruleQueryDeclaration8167 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_STRING_in_ruleQueryDeclaration8184 = new BitSet(new long[]{0x0000000000020010L,0x0000011380000000L});
    public static final BitSet FOLLOW_17_in_ruleQueryDeclaration8204 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_STRING_in_ruleQueryDeclaration8221 = new BitSet(new long[]{0x0000000000000010L,0x0000011380000000L});
    public static final BitSet FOLLOW_ruleQueryDefinitionMdsl_in_ruleQueryDeclaration8249 = new BitSet(new long[]{0x0000000010000000L});
    public static final BitSet FOLLOW_28_in_ruleQueryDeclaration8261 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleQueryDefinitionMdsl_in_entryRuleQueryDefinitionMdsl8297 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleQueryDefinitionMdsl8307 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_95_in_ruleQueryDefinitionMdsl8345 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleQueryDefinitionMdsl8365 = new BitSet(new long[]{0x0000000000000010L,0x0000011380000000L});
    public static final BitSet FOLLOW_96_in_ruleQueryDefinitionMdsl8380 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleQueryDefinitionMdsl8400 = new BitSet(new long[]{0x0000000000000010L,0x0000011380000000L});
    public static final BitSet FOLLOW_97_in_ruleQueryDefinitionMdsl8415 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_STRING_in_ruleQueryDefinitionMdsl8432 = new BitSet(new long[]{0x0000000000000010L,0x0000011380000000L});
    public static final BitSet FOLLOW_ruleQueryBody_in_ruleQueryDefinitionMdsl8461 = new BitSet(new long[]{0x0000000002000002L,0x0000000C00000000L});
    public static final BitSet FOLLOW_ruleExternalQueryCallMdsl_in_ruleQueryDefinitionMdsl8488 = new BitSet(new long[]{0x0000000002000002L,0x0000000C00000000L});
    public static final BitSet FOLLOW_25_in_ruleQueryDefinitionMdsl8502 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleQueryDefinitionMdsl8522 = new BitSet(new long[]{0x0000000000000002L,0x0000000C00000000L});
    public static final BitSet FOLLOW_98_in_ruleQueryDefinitionMdsl8537 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_rulePropertyMdsl_in_ruleQueryDefinitionMdsl8558 = new BitSet(new long[]{0x0000000200000002L,0x0000000800000000L});
    public static final BitSet FOLLOW_33_in_ruleQueryDefinitionMdsl8571 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_rulePropertyMdsl_in_ruleQueryDefinitionMdsl8592 = new BitSet(new long[]{0x0000000200000002L,0x0000000800000000L});
    public static final BitSet FOLLOW_99_in_ruleQueryDefinitionMdsl8609 = new BitSet(new long[]{0x0000000000000000L,0xE000000000000000L});
    public static final BitSet FOLLOW_ruleQUERY_OPTIMISATION_LEVEL_in_ruleQueryDefinitionMdsl8630 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleQueryFragment_in_entryRuleQueryFragment8668 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleQueryFragment8678 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleLiteralQueryFragment_in_ruleQueryFragment8725 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleTextMacroRef_in_ruleQueryFragment8752 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleLiteralQueryFragment_in_entryRuleLiteralQueryFragment8787 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleLiteralQueryFragment8797 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_STRING_in_ruleLiteralQueryFragment8838 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleQueryBody_in_entryRuleQueryBody8878 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleQueryBody8888 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleQueryFragment_in_ruleQueryBody8934 = new BitSet(new long[]{0x0000000000008002L});
    public static final BitSet FOLLOW_15_in_ruleQueryBody8947 = new BitSet(new long[]{0x0000000000000010L,0x0000010000000000L});
    public static final BitSet FOLLOW_ruleQueryFragment_in_ruleQueryBody8968 = new BitSet(new long[]{0x0000000000008002L});
    public static final BitSet FOLLOW_ruleQueryRefMdsl_in_entryRuleQueryRefMdsl9006 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleQueryRefMdsl9016 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleQueryRefMdsl9060 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleExternalQueryCallMdsl_in_entryRuleExternalQueryCallMdsl9095 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleExternalQueryCallMdsl9105 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_100_in_ruleExternalQueryCallMdsl9142 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleExternalQueryCallMdsl9162 = new BitSet(new long[]{0x0000000000000000L,0x0000002000000000L});
    public static final BitSet FOLLOW_101_in_ruleExternalQueryCallMdsl9174 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleQueryChain_in_entryRuleQueryChain9210 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleQueryChain9220 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_102_in_ruleQueryChain9257 = new BitSet(new long[]{0x0000000000400000L});
    public static final BitSet FOLLOW_22_in_ruleQueryChain9269 = new BitSet(new long[]{0x0000000000000030L,0x0000011380000000L});
    public static final BitSet FOLLOW_ruleQuery_in_ruleQueryChain9290 = new BitSet(new long[]{0x0000000210000030L,0x0000011380000000L});
    public static final BitSet FOLLOW_33_in_ruleQueryChain9304 = new BitSet(new long[]{0x0000000000000030L,0x0000011380000000L});
    public static final BitSet FOLLOW_ruleQuery_in_ruleQueryChain9325 = new BitSet(new long[]{0x0000000210000000L});
    public static final BitSet FOLLOW_28_in_ruleQueryChain9339 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleFormatExpr_in_entryRuleFormatExpr9375 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleFormatExpr9385 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleFormatExprFragment_in_ruleFormatExpr9431 = new BitSet(new long[]{0x0000000000008002L});
    public static final BitSet FOLLOW_15_in_ruleFormatExpr9444 = new BitSet(new long[]{0x0000000000000010L,0x0000010000000000L});
    public static final BitSet FOLLOW_ruleFormatExprFragment_in_ruleFormatExpr9465 = new BitSet(new long[]{0x0000000000008002L});
    public static final BitSet FOLLOW_ruleFormatExprFragment_in_entryRuleFormatExprFragment9503 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleFormatExprFragment9513 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleLiteralFormatExprFragment_in_ruleFormatExprFragment9560 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleTextMacroRef_in_ruleFormatExprFragment9587 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleLiteralFormatExprFragment_in_entryRuleLiteralFormatExprFragment9622 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleLiteralFormatExprFragment9632 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_STRING_in_ruleLiteralFormatExprFragment9673 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleTextMacro_in_entryRuleTextMacro9713 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleTextMacro9723 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_103_in_ruleTextMacro9760 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleTextMacro9777 = new BitSet(new long[]{0x0000000000400000L});
    public static final BitSet FOLLOW_22_in_ruleTextMacro9794 = new BitSet(new long[]{0x0000000000022000L,0x0000000000000002L});
    public static final BitSet FOLLOW_13_in_ruleTextMacro9807 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_STRING_in_ruleTextMacro9824 = new BitSet(new long[]{0x0000000000020000L,0x0000000000000002L});
    public static final BitSet FOLLOW_17_in_ruleTextMacro9844 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_STRING_in_ruleTextMacro9861 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000002L});
    public static final BitSet FOLLOW_65_in_ruleTextMacro9880 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_STRING_in_ruleTextMacro9897 = new BitSet(new long[]{0x0000000010000000L});
    public static final BitSet FOLLOW_28_in_ruleTextMacro9914 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleTextMacroRef_in_entryRuleTextMacroRef9950 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleTextMacroRef9960 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_104_in_ruleTextMacroRef9997 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleTextMacroRef10017 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_105_in_ruleVALUE_CONVERTER_CATEGORY_MDSL10067 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_106_in_ruleVALUE_CONVERTER_CATEGORY_MDSL10084 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_107_in_ruleVALUE_CONVERTER_CATEGORY_MDSL10101 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_108_in_ruleVALUE_CONVERTER_CATEGORY_MDSL10118 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_109_in_ruleVALUE_CONVERTER_CATEGORY_MDSL10135 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_110_in_ruleVALUE_CONVERTER_CATEGORY_MDSL10152 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_111_in_ruleWIDGET_CATEGORY_MDSL10197 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_112_in_ruleWIDGET_CATEGORY_MDSL10214 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_113_in_ruleWIDGET_CATEGORY_MDSL10231 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_114_in_ruleWIDGET_CATEGORY_MDSL10248 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_115_in_ruleWIDGET_CATEGORY_MDSL10265 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_116_in_ruleWIDGET_CATEGORY_MDSL10282 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_117_in_ruleWIDGET_CATEGORY_MDSL10299 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_118_in_ruleWIDGET_CATEGORY_MDSL10316 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_119_in_ruleWIDGET_CATEGORY_MDSL10333 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_120_in_ruleWIDGET_CATEGORY_MDSL10350 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_121_in_ruleWIDGET_CATEGORY_MDSL10367 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_122_in_ruleCOMMAND_CATEGORY_MDSL10412 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_123_in_ruleCOMMAND_CATEGORY_MDSL10429 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_124_in_ruleCOMMAND_CATEGORY_MDSL10446 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_125_in_ruleQUERY_OPTIMISATION_LEVEL10491 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_126_in_ruleQUERY_OPTIMISATION_LEVEL10508 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_127_in_ruleQUERY_OPTIMISATION_LEVEL10525 = new BitSet(new long[]{0x0000000000000002L});

}
