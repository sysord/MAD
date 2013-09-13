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
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "RULE_STRING", "RULE_ID", "RULE_INT", "RULE_ML_COMMENT", "RULE_SL_COMMENT", "RULE_WS", "RULE_ANY_OTHER", "'import'", "'from plugin'", "'label:'", "'='", "'+'", "'Use icon'", "'description:'", "'location:'", "'URI:'", "'Use I18N Bundle'", "'Foreign Model'", "'{'", "'model type:'", "'options:'", "'AUTO_RELOAD'", "'synchronizer factory'", "':'", "'extension manager'", "'model locator:'", "'}'", "'Uri Extension:'", "'Model Uri:'", "'Provider Class:'", "'parameters:'", "','", "'Xtext DSL:'", "'language Id:'", "'from bundle:'", "'with activator:'", "'DSL:'", "'Custom OCL Library'", "'Class:'", "'Query Evaluator'", "'language id:'", "'Evaluator'", "'query Properties type:'", "'external query provider:'", "'Widget type'", "'name:'", "'category:'", "'custom widget:'", "'UI'", "'Tab'", "'id:'", "'I18N'", "'Layer'", "'Sub'", "'layers'", "'DEFAULT'", "'Configuration'", "'for'", "'label provider:'", "'extends:'", "'template:'", "'layout:'", "'include widget:'", "'source template:'", "'value:'", "'Query'", "'widget:'", "'tab:'", "'layers:'", "'type:'", "'flexible template:'", "'target template:'", "'visible when:'", "'editable when:'", "'valueConverter:'", "'validators:'", "'format:'", "'candidates:'", "'item label:'", "'commands:'", "'validation rule:'", "'Error message:'", "'Common Command'", "'icon:'", "'action:'", "'on success:'", "'on error:'", "'('", "')'", "'Display view'", "'Reload'", "'view'", "'widgets:'", "'Common Query'", "'language:'", "'foreign model:'", "'context locator:'", "'properties:'", "'Optimisation:'", "'call'", "'()'", "'Query Chain'", "'Macro:'", "'#'", "'DATE'", "'DATETIME'", "'INTEGER'", "'FLOAT'", "'DOUBLE'", "'XTEXT'", "'OUTPUTTEXT_WIDGET'", "'NAVIGATION_WIDGET'", "'TEXT_WIDGET'", "'BOOL_WIDGET'", "'DATE_WIDGET'", "'NUMBER_WIDGET'", "'SINGLE_SELECT_WIDGET'", "'MULTI_SELECT_WIDGET'", "'XTEXT_EDITOR'", "'XTEXT_TEXT_EDITOR'", "'FLEXIBLE_WIDGET'", "'UPDATE_COMMAND'", "'GLOBAL_COMMAND'", "'ITEM_COMMAND'", "'NONE'", "'VIEW'", "'CONTEXT'"
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
    public static final int T__128=128;
    public static final int RULE_STRING=4;
    public static final int T__127=127;
    public static final int T__71=71;
    public static final int T__129=129;
    public static final int T__72=72;
    public static final int T__70=70;
    public static final int T__76=76;
    public static final int T__75=75;
    public static final int T__130=130;
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

                if ( (LA2_0==16||(LA2_0>=20 && LA2_0<=21)||LA2_0==36||LA2_0==41||LA2_0==43||LA2_0==48||LA2_0==52||LA2_0==56||(LA2_0>=59 && LA2_0<=60)||LA2_0==86||LA2_0==97||LA2_0==106) ) {
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
    // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:134:1: ruleMADConfigElement returns [EObject current=null] : (this_LayerMdsl_0= ruleLayerMdsl | this_ForeignModelMdsl_1= ruleForeignModelMdsl | this_XtextLanguageDescriptorMdsl_2= ruleXtextLanguageDescriptorMdsl | this_QueryEvaluatorMdsl_3= ruleQueryEvaluatorMdsl | this_OCLCustomLibraryMdsl_4= ruleOCLCustomLibraryMdsl | this_QueryDeclaration_5= ruleQueryDeclaration | this_WidgetType_6= ruleWidgetType | this_UITabMdsl_7= ruleUITabMdsl | this_CommandDeclaration_8= ruleCommandDeclaration | this_TypeConfigurationMdsl_9= ruleTypeConfigurationMdsl | this_TextMacro_10= ruleTextMacro | this_I18NBundleMdsl_11= ruleI18NBundleMdsl | this_IconDescriptorMdsl_12= ruleIconDescriptorMdsl ) ;
    public final EObject ruleMADConfigElement() throws RecognitionException {
        EObject current = null;

        EObject this_LayerMdsl_0 = null;

        EObject this_ForeignModelMdsl_1 = null;

        EObject this_XtextLanguageDescriptorMdsl_2 = null;

        EObject this_QueryEvaluatorMdsl_3 = null;

        EObject this_OCLCustomLibraryMdsl_4 = null;

        EObject this_QueryDeclaration_5 = null;

        EObject this_WidgetType_6 = null;

        EObject this_UITabMdsl_7 = null;

        EObject this_CommandDeclaration_8 = null;

        EObject this_TypeConfigurationMdsl_9 = null;

        EObject this_TextMacro_10 = null;

        EObject this_I18NBundleMdsl_11 = null;

        EObject this_IconDescriptorMdsl_12 = null;


         enterRule(); 
            
        try {
            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:137:28: ( (this_LayerMdsl_0= ruleLayerMdsl | this_ForeignModelMdsl_1= ruleForeignModelMdsl | this_XtextLanguageDescriptorMdsl_2= ruleXtextLanguageDescriptorMdsl | this_QueryEvaluatorMdsl_3= ruleQueryEvaluatorMdsl | this_OCLCustomLibraryMdsl_4= ruleOCLCustomLibraryMdsl | this_QueryDeclaration_5= ruleQueryDeclaration | this_WidgetType_6= ruleWidgetType | this_UITabMdsl_7= ruleUITabMdsl | this_CommandDeclaration_8= ruleCommandDeclaration | this_TypeConfigurationMdsl_9= ruleTypeConfigurationMdsl | this_TextMacro_10= ruleTextMacro | this_I18NBundleMdsl_11= ruleI18NBundleMdsl | this_IconDescriptorMdsl_12= ruleIconDescriptorMdsl ) )
            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:138:1: (this_LayerMdsl_0= ruleLayerMdsl | this_ForeignModelMdsl_1= ruleForeignModelMdsl | this_XtextLanguageDescriptorMdsl_2= ruleXtextLanguageDescriptorMdsl | this_QueryEvaluatorMdsl_3= ruleQueryEvaluatorMdsl | this_OCLCustomLibraryMdsl_4= ruleOCLCustomLibraryMdsl | this_QueryDeclaration_5= ruleQueryDeclaration | this_WidgetType_6= ruleWidgetType | this_UITabMdsl_7= ruleUITabMdsl | this_CommandDeclaration_8= ruleCommandDeclaration | this_TypeConfigurationMdsl_9= ruleTypeConfigurationMdsl | this_TextMacro_10= ruleTextMacro | this_I18NBundleMdsl_11= ruleI18NBundleMdsl | this_IconDescriptorMdsl_12= ruleIconDescriptorMdsl )
            {
            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:138:1: (this_LayerMdsl_0= ruleLayerMdsl | this_ForeignModelMdsl_1= ruleForeignModelMdsl | this_XtextLanguageDescriptorMdsl_2= ruleXtextLanguageDescriptorMdsl | this_QueryEvaluatorMdsl_3= ruleQueryEvaluatorMdsl | this_OCLCustomLibraryMdsl_4= ruleOCLCustomLibraryMdsl | this_QueryDeclaration_5= ruleQueryDeclaration | this_WidgetType_6= ruleWidgetType | this_UITabMdsl_7= ruleUITabMdsl | this_CommandDeclaration_8= ruleCommandDeclaration | this_TypeConfigurationMdsl_9= ruleTypeConfigurationMdsl | this_TextMacro_10= ruleTextMacro | this_I18NBundleMdsl_11= ruleI18NBundleMdsl | this_IconDescriptorMdsl_12= ruleIconDescriptorMdsl )
            int alt3=13;
            switch ( input.LA(1) ) {
            case 56:
                {
                alt3=1;
                }
                break;
            case 21:
                {
                alt3=2;
                }
                break;
            case 36:
                {
                alt3=3;
                }
                break;
            case 43:
                {
                alt3=4;
                }
                break;
            case 41:
                {
                alt3=5;
                }
                break;
            case 97:
                {
                alt3=6;
                }
                break;
            case 48:
                {
                alt3=7;
                }
                break;
            case 52:
                {
                alt3=8;
                }
                break;
            case 86:
                {
                alt3=9;
                }
                break;
            case 59:
            case 60:
                {
                alt3=10;
                }
                break;
            case 106:
                {
                alt3=11;
                }
                break;
            case 20:
                {
                alt3=12;
                }
                break;
            case 16:
                {
                alt3=13;
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
                    // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:179:5: this_OCLCustomLibraryMdsl_4= ruleOCLCustomLibraryMdsl
                    {
                     
                            newCompositeNode(grammarAccess.getMADConfigElementAccess().getOCLCustomLibraryMdslParserRuleCall_4()); 
                        
                    pushFollow(FOLLOW_ruleOCLCustomLibraryMdsl_in_ruleMADConfigElement355);
                    this_OCLCustomLibraryMdsl_4=ruleOCLCustomLibraryMdsl();

                    state._fsp--;

                     
                            current = this_OCLCustomLibraryMdsl_4; 
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;
                case 6 :
                    // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:189:5: this_QueryDeclaration_5= ruleQueryDeclaration
                    {
                     
                            newCompositeNode(grammarAccess.getMADConfigElementAccess().getQueryDeclarationParserRuleCall_5()); 
                        
                    pushFollow(FOLLOW_ruleQueryDeclaration_in_ruleMADConfigElement382);
                    this_QueryDeclaration_5=ruleQueryDeclaration();

                    state._fsp--;

                     
                            current = this_QueryDeclaration_5; 
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;
                case 7 :
                    // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:199:5: this_WidgetType_6= ruleWidgetType
                    {
                     
                            newCompositeNode(grammarAccess.getMADConfigElementAccess().getWidgetTypeParserRuleCall_6()); 
                        
                    pushFollow(FOLLOW_ruleWidgetType_in_ruleMADConfigElement409);
                    this_WidgetType_6=ruleWidgetType();

                    state._fsp--;

                     
                            current = this_WidgetType_6; 
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;
                case 8 :
                    // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:209:5: this_UITabMdsl_7= ruleUITabMdsl
                    {
                     
                            newCompositeNode(grammarAccess.getMADConfigElementAccess().getUITabMdslParserRuleCall_7()); 
                        
                    pushFollow(FOLLOW_ruleUITabMdsl_in_ruleMADConfigElement436);
                    this_UITabMdsl_7=ruleUITabMdsl();

                    state._fsp--;

                     
                            current = this_UITabMdsl_7; 
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;
                case 9 :
                    // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:219:5: this_CommandDeclaration_8= ruleCommandDeclaration
                    {
                     
                            newCompositeNode(grammarAccess.getMADConfigElementAccess().getCommandDeclarationParserRuleCall_8()); 
                        
                    pushFollow(FOLLOW_ruleCommandDeclaration_in_ruleMADConfigElement463);
                    this_CommandDeclaration_8=ruleCommandDeclaration();

                    state._fsp--;

                     
                            current = this_CommandDeclaration_8; 
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;
                case 10 :
                    // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:229:5: this_TypeConfigurationMdsl_9= ruleTypeConfigurationMdsl
                    {
                     
                            newCompositeNode(grammarAccess.getMADConfigElementAccess().getTypeConfigurationMdslParserRuleCall_9()); 
                        
                    pushFollow(FOLLOW_ruleTypeConfigurationMdsl_in_ruleMADConfigElement490);
                    this_TypeConfigurationMdsl_9=ruleTypeConfigurationMdsl();

                    state._fsp--;

                     
                            current = this_TypeConfigurationMdsl_9; 
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;
                case 11 :
                    // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:239:5: this_TextMacro_10= ruleTextMacro
                    {
                     
                            newCompositeNode(grammarAccess.getMADConfigElementAccess().getTextMacroParserRuleCall_10()); 
                        
                    pushFollow(FOLLOW_ruleTextMacro_in_ruleMADConfigElement517);
                    this_TextMacro_10=ruleTextMacro();

                    state._fsp--;

                     
                            current = this_TextMacro_10; 
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;
                case 12 :
                    // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:249:5: this_I18NBundleMdsl_11= ruleI18NBundleMdsl
                    {
                     
                            newCompositeNode(grammarAccess.getMADConfigElementAccess().getI18NBundleMdslParserRuleCall_11()); 
                        
                    pushFollow(FOLLOW_ruleI18NBundleMdsl_in_ruleMADConfigElement544);
                    this_I18NBundleMdsl_11=ruleI18NBundleMdsl();

                    state._fsp--;

                     
                            current = this_I18NBundleMdsl_11; 
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;
                case 13 :
                    // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:259:5: this_IconDescriptorMdsl_12= ruleIconDescriptorMdsl
                    {
                     
                            newCompositeNode(grammarAccess.getMADConfigElementAccess().getIconDescriptorMdslParserRuleCall_12()); 
                        
                    pushFollow(FOLLOW_ruleIconDescriptorMdsl_in_ruleMADConfigElement571);
                    this_IconDescriptorMdsl_12=ruleIconDescriptorMdsl();

                    state._fsp--;

                     
                            current = this_IconDescriptorMdsl_12; 
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
    // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:275:1: entryRuleImport returns [EObject current=null] : iv_ruleImport= ruleImport EOF ;
    public final EObject entryRuleImport() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleImport = null;


        try {
            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:276:2: (iv_ruleImport= ruleImport EOF )
            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:277:2: iv_ruleImport= ruleImport EOF
            {
             newCompositeNode(grammarAccess.getImportRule()); 
            pushFollow(FOLLOW_ruleImport_in_entryRuleImport606);
            iv_ruleImport=ruleImport();

            state._fsp--;

             current =iv_ruleImport; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleImport616); 

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
    // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:284:1: ruleImport returns [EObject current=null] : (otherlv_0= 'import' ( (lv_importURI_1_0= RULE_STRING ) ) ) ;
    public final EObject ruleImport() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token lv_importURI_1_0=null;

         enterRule(); 
            
        try {
            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:287:28: ( (otherlv_0= 'import' ( (lv_importURI_1_0= RULE_STRING ) ) ) )
            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:288:1: (otherlv_0= 'import' ( (lv_importURI_1_0= RULE_STRING ) ) )
            {
            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:288:1: (otherlv_0= 'import' ( (lv_importURI_1_0= RULE_STRING ) ) )
            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:288:3: otherlv_0= 'import' ( (lv_importURI_1_0= RULE_STRING ) )
            {
            otherlv_0=(Token)match(input,11,FOLLOW_11_in_ruleImport653); 

                	newLeafNode(otherlv_0, grammarAccess.getImportAccess().getImportKeyword_0());
                
            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:292:1: ( (lv_importURI_1_0= RULE_STRING ) )
            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:293:1: (lv_importURI_1_0= RULE_STRING )
            {
            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:293:1: (lv_importURI_1_0= RULE_STRING )
            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:294:3: lv_importURI_1_0= RULE_STRING
            {
            lv_importURI_1_0=(Token)match(input,RULE_STRING,FOLLOW_RULE_STRING_in_ruleImport670); 

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
    // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:318:1: entryRuleClassDescriptorMdsl returns [EObject current=null] : iv_ruleClassDescriptorMdsl= ruleClassDescriptorMdsl EOF ;
    public final EObject entryRuleClassDescriptorMdsl() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleClassDescriptorMdsl = null;


        try {
            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:319:2: (iv_ruleClassDescriptorMdsl= ruleClassDescriptorMdsl EOF )
            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:320:2: iv_ruleClassDescriptorMdsl= ruleClassDescriptorMdsl EOF
            {
             newCompositeNode(grammarAccess.getClassDescriptorMdslRule()); 
            pushFollow(FOLLOW_ruleClassDescriptorMdsl_in_entryRuleClassDescriptorMdsl711);
            iv_ruleClassDescriptorMdsl=ruleClassDescriptorMdsl();

            state._fsp--;

             current =iv_ruleClassDescriptorMdsl; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleClassDescriptorMdsl721); 

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
    // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:327:1: ruleClassDescriptorMdsl returns [EObject current=null] : ( ( (lv_ClassName_0_0= RULE_ID ) ) (otherlv_1= 'from plugin' ( (lv_pluginId_2_0= RULE_ID ) ) )? ) ;
    public final EObject ruleClassDescriptorMdsl() throws RecognitionException {
        EObject current = null;

        Token lv_ClassName_0_0=null;
        Token otherlv_1=null;
        Token lv_pluginId_2_0=null;

         enterRule(); 
            
        try {
            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:330:28: ( ( ( (lv_ClassName_0_0= RULE_ID ) ) (otherlv_1= 'from plugin' ( (lv_pluginId_2_0= RULE_ID ) ) )? ) )
            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:331:1: ( ( (lv_ClassName_0_0= RULE_ID ) ) (otherlv_1= 'from plugin' ( (lv_pluginId_2_0= RULE_ID ) ) )? )
            {
            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:331:1: ( ( (lv_ClassName_0_0= RULE_ID ) ) (otherlv_1= 'from plugin' ( (lv_pluginId_2_0= RULE_ID ) ) )? )
            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:331:2: ( (lv_ClassName_0_0= RULE_ID ) ) (otherlv_1= 'from plugin' ( (lv_pluginId_2_0= RULE_ID ) ) )?
            {
            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:331:2: ( (lv_ClassName_0_0= RULE_ID ) )
            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:332:1: (lv_ClassName_0_0= RULE_ID )
            {
            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:332:1: (lv_ClassName_0_0= RULE_ID )
            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:333:3: lv_ClassName_0_0= RULE_ID
            {
            lv_ClassName_0_0=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleClassDescriptorMdsl763); 

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

            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:349:2: (otherlv_1= 'from plugin' ( (lv_pluginId_2_0= RULE_ID ) ) )?
            int alt4=2;
            int LA4_0 = input.LA(1);

            if ( (LA4_0==12) ) {
                alt4=1;
            }
            switch (alt4) {
                case 1 :
                    // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:349:4: otherlv_1= 'from plugin' ( (lv_pluginId_2_0= RULE_ID ) )
                    {
                    otherlv_1=(Token)match(input,12,FOLLOW_12_in_ruleClassDescriptorMdsl781); 

                        	newLeafNode(otherlv_1, grammarAccess.getClassDescriptorMdslAccess().getFromPluginKeyword_1_0());
                        
                    // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:353:1: ( (lv_pluginId_2_0= RULE_ID ) )
                    // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:354:1: (lv_pluginId_2_0= RULE_ID )
                    {
                    // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:354:1: (lv_pluginId_2_0= RULE_ID )
                    // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:355:3: lv_pluginId_2_0= RULE_ID
                    {
                    lv_pluginId_2_0=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleClassDescriptorMdsl798); 

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
    // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:379:1: entryRulePropertyTypeMdsl returns [EObject current=null] : iv_rulePropertyTypeMdsl= rulePropertyTypeMdsl EOF ;
    public final EObject entryRulePropertyTypeMdsl() throws RecognitionException {
        EObject current = null;

        EObject iv_rulePropertyTypeMdsl = null;


        try {
            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:380:2: (iv_rulePropertyTypeMdsl= rulePropertyTypeMdsl EOF )
            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:381:2: iv_rulePropertyTypeMdsl= rulePropertyTypeMdsl EOF
            {
             newCompositeNode(grammarAccess.getPropertyTypeMdslRule()); 
            pushFollow(FOLLOW_rulePropertyTypeMdsl_in_entryRulePropertyTypeMdsl841);
            iv_rulePropertyTypeMdsl=rulePropertyTypeMdsl();

            state._fsp--;

             current =iv_rulePropertyTypeMdsl; 
            match(input,EOF,FOLLOW_EOF_in_entryRulePropertyTypeMdsl851); 

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
    // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:388:1: rulePropertyTypeMdsl returns [EObject current=null] : ( ( (lv_name_0_0= RULE_ID ) ) otherlv_1= 'label:' ( (lv_label_2_0= RULE_STRING ) ) ) ;
    public final EObject rulePropertyTypeMdsl() throws RecognitionException {
        EObject current = null;

        Token lv_name_0_0=null;
        Token otherlv_1=null;
        Token lv_label_2_0=null;

         enterRule(); 
            
        try {
            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:391:28: ( ( ( (lv_name_0_0= RULE_ID ) ) otherlv_1= 'label:' ( (lv_label_2_0= RULE_STRING ) ) ) )
            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:392:1: ( ( (lv_name_0_0= RULE_ID ) ) otherlv_1= 'label:' ( (lv_label_2_0= RULE_STRING ) ) )
            {
            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:392:1: ( ( (lv_name_0_0= RULE_ID ) ) otherlv_1= 'label:' ( (lv_label_2_0= RULE_STRING ) ) )
            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:392:2: ( (lv_name_0_0= RULE_ID ) ) otherlv_1= 'label:' ( (lv_label_2_0= RULE_STRING ) )
            {
            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:392:2: ( (lv_name_0_0= RULE_ID ) )
            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:393:1: (lv_name_0_0= RULE_ID )
            {
            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:393:1: (lv_name_0_0= RULE_ID )
            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:394:3: lv_name_0_0= RULE_ID
            {
            lv_name_0_0=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_rulePropertyTypeMdsl893); 

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

            otherlv_1=(Token)match(input,13,FOLLOW_13_in_rulePropertyTypeMdsl910); 

                	newLeafNode(otherlv_1, grammarAccess.getPropertyTypeMdslAccess().getLabelKeyword_1());
                
            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:414:1: ( (lv_label_2_0= RULE_STRING ) )
            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:415:1: (lv_label_2_0= RULE_STRING )
            {
            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:415:1: (lv_label_2_0= RULE_STRING )
            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:416:3: lv_label_2_0= RULE_STRING
            {
            lv_label_2_0=(Token)match(input,RULE_STRING,FOLLOW_RULE_STRING_in_rulePropertyTypeMdsl927); 

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
    // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:440:1: entryRulePropertyMdsl returns [EObject current=null] : iv_rulePropertyMdsl= rulePropertyMdsl EOF ;
    public final EObject entryRulePropertyMdsl() throws RecognitionException {
        EObject current = null;

        EObject iv_rulePropertyMdsl = null;


        try {
            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:441:2: (iv_rulePropertyMdsl= rulePropertyMdsl EOF )
            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:442:2: iv_rulePropertyMdsl= rulePropertyMdsl EOF
            {
             newCompositeNode(grammarAccess.getPropertyMdslRule()); 
            pushFollow(FOLLOW_rulePropertyMdsl_in_entryRulePropertyMdsl968);
            iv_rulePropertyMdsl=rulePropertyMdsl();

            state._fsp--;

             current =iv_rulePropertyMdsl; 
            match(input,EOF,FOLLOW_EOF_in_entryRulePropertyMdsl978); 

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
    // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:449:1: rulePropertyMdsl returns [EObject current=null] : ( ( (otherlv_0= RULE_ID ) ) otherlv_1= '=' ( (lv_propertyValue_2_0= rulePropertyValueMdsl ) ) ) ;
    public final EObject rulePropertyMdsl() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;
        EObject lv_propertyValue_2_0 = null;


         enterRule(); 
            
        try {
            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:452:28: ( ( ( (otherlv_0= RULE_ID ) ) otherlv_1= '=' ( (lv_propertyValue_2_0= rulePropertyValueMdsl ) ) ) )
            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:453:1: ( ( (otherlv_0= RULE_ID ) ) otherlv_1= '=' ( (lv_propertyValue_2_0= rulePropertyValueMdsl ) ) )
            {
            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:453:1: ( ( (otherlv_0= RULE_ID ) ) otherlv_1= '=' ( (lv_propertyValue_2_0= rulePropertyValueMdsl ) ) )
            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:453:2: ( (otherlv_0= RULE_ID ) ) otherlv_1= '=' ( (lv_propertyValue_2_0= rulePropertyValueMdsl ) )
            {
            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:453:2: ( (otherlv_0= RULE_ID ) )
            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:454:1: (otherlv_0= RULE_ID )
            {
            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:454:1: (otherlv_0= RULE_ID )
            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:455:3: otherlv_0= RULE_ID
            {

            			if (current==null) {
            	            current = createModelElement(grammarAccess.getPropertyMdslRule());
            	        }
                    
            otherlv_0=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_rulePropertyMdsl1023); 

            		newLeafNode(otherlv_0, grammarAccess.getPropertyMdslAccess().getPropertyNamePropertyTypeMdslCrossReference_0_0()); 
            	

            }


            }

            otherlv_1=(Token)match(input,14,FOLLOW_14_in_rulePropertyMdsl1035); 

                	newLeafNode(otherlv_1, grammarAccess.getPropertyMdslAccess().getEqualsSignKeyword_1());
                
            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:470:1: ( (lv_propertyValue_2_0= rulePropertyValueMdsl ) )
            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:471:1: (lv_propertyValue_2_0= rulePropertyValueMdsl )
            {
            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:471:1: (lv_propertyValue_2_0= rulePropertyValueMdsl )
            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:472:3: lv_propertyValue_2_0= rulePropertyValueMdsl
            {
             
            	        newCompositeNode(grammarAccess.getPropertyMdslAccess().getPropertyValuePropertyValueMdslParserRuleCall_2_0()); 
            	    
            pushFollow(FOLLOW_rulePropertyValueMdsl_in_rulePropertyMdsl1056);
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
    // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:496:1: entryRulePropertyValueMdsl returns [EObject current=null] : iv_rulePropertyValueMdsl= rulePropertyValueMdsl EOF ;
    public final EObject entryRulePropertyValueMdsl() throws RecognitionException {
        EObject current = null;

        EObject iv_rulePropertyValueMdsl = null;


        try {
            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:497:2: (iv_rulePropertyValueMdsl= rulePropertyValueMdsl EOF )
            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:498:2: iv_rulePropertyValueMdsl= rulePropertyValueMdsl EOF
            {
             newCompositeNode(grammarAccess.getPropertyValueMdslRule()); 
            pushFollow(FOLLOW_rulePropertyValueMdsl_in_entryRulePropertyValueMdsl1092);
            iv_rulePropertyValueMdsl=rulePropertyValueMdsl();

            state._fsp--;

             current =iv_rulePropertyValueMdsl; 
            match(input,EOF,FOLLOW_EOF_in_entryRulePropertyValueMdsl1102); 

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
    // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:505:1: rulePropertyValueMdsl returns [EObject current=null] : ( ( (lv_fragments_0_0= rulePropValueExprFragment ) ) (otherlv_1= '+' ( (lv_fragments_2_0= rulePropValueExprFragment ) ) )* ) ;
    public final EObject rulePropertyValueMdsl() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        EObject lv_fragments_0_0 = null;

        EObject lv_fragments_2_0 = null;


         enterRule(); 
            
        try {
            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:508:28: ( ( ( (lv_fragments_0_0= rulePropValueExprFragment ) ) (otherlv_1= '+' ( (lv_fragments_2_0= rulePropValueExprFragment ) ) )* ) )
            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:509:1: ( ( (lv_fragments_0_0= rulePropValueExprFragment ) ) (otherlv_1= '+' ( (lv_fragments_2_0= rulePropValueExprFragment ) ) )* )
            {
            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:509:1: ( ( (lv_fragments_0_0= rulePropValueExprFragment ) ) (otherlv_1= '+' ( (lv_fragments_2_0= rulePropValueExprFragment ) ) )* )
            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:509:2: ( (lv_fragments_0_0= rulePropValueExprFragment ) ) (otherlv_1= '+' ( (lv_fragments_2_0= rulePropValueExprFragment ) ) )*
            {
            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:509:2: ( (lv_fragments_0_0= rulePropValueExprFragment ) )
            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:510:1: (lv_fragments_0_0= rulePropValueExprFragment )
            {
            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:510:1: (lv_fragments_0_0= rulePropValueExprFragment )
            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:511:3: lv_fragments_0_0= rulePropValueExprFragment
            {
             
            	        newCompositeNode(grammarAccess.getPropertyValueMdslAccess().getFragmentsPropValueExprFragmentParserRuleCall_0_0()); 
            	    
            pushFollow(FOLLOW_rulePropValueExprFragment_in_rulePropertyValueMdsl1148);
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

            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:527:2: (otherlv_1= '+' ( (lv_fragments_2_0= rulePropValueExprFragment ) ) )*
            loop5:
            do {
                int alt5=2;
                int LA5_0 = input.LA(1);

                if ( (LA5_0==15) ) {
                    alt5=1;
                }


                switch (alt5) {
            	case 1 :
            	    // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:527:4: otherlv_1= '+' ( (lv_fragments_2_0= rulePropValueExprFragment ) )
            	    {
            	    otherlv_1=(Token)match(input,15,FOLLOW_15_in_rulePropertyValueMdsl1161); 

            	        	newLeafNode(otherlv_1, grammarAccess.getPropertyValueMdslAccess().getPlusSignKeyword_1_0());
            	        
            	    // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:531:1: ( (lv_fragments_2_0= rulePropValueExprFragment ) )
            	    // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:532:1: (lv_fragments_2_0= rulePropValueExprFragment )
            	    {
            	    // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:532:1: (lv_fragments_2_0= rulePropValueExprFragment )
            	    // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:533:3: lv_fragments_2_0= rulePropValueExprFragment
            	    {
            	     
            	    	        newCompositeNode(grammarAccess.getPropertyValueMdslAccess().getFragmentsPropValueExprFragmentParserRuleCall_1_1_0()); 
            	    	    
            	    pushFollow(FOLLOW_rulePropValueExprFragment_in_rulePropertyValueMdsl1182);
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
    // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:557:1: entryRulePropValueExprFragment returns [EObject current=null] : iv_rulePropValueExprFragment= rulePropValueExprFragment EOF ;
    public final EObject entryRulePropValueExprFragment() throws RecognitionException {
        EObject current = null;

        EObject iv_rulePropValueExprFragment = null;


        try {
            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:558:2: (iv_rulePropValueExprFragment= rulePropValueExprFragment EOF )
            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:559:2: iv_rulePropValueExprFragment= rulePropValueExprFragment EOF
            {
             newCompositeNode(grammarAccess.getPropValueExprFragmentRule()); 
            pushFollow(FOLLOW_rulePropValueExprFragment_in_entryRulePropValueExprFragment1220);
            iv_rulePropValueExprFragment=rulePropValueExprFragment();

            state._fsp--;

             current =iv_rulePropValueExprFragment; 
            match(input,EOF,FOLLOW_EOF_in_entryRulePropValueExprFragment1230); 

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
    // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:566:1: rulePropValueExprFragment returns [EObject current=null] : (this_LiteraPropValueExprFragment_0= ruleLiteraPropValueExprFragment | this_TextMacroRef_1= ruleTextMacroRef ) ;
    public final EObject rulePropValueExprFragment() throws RecognitionException {
        EObject current = null;

        EObject this_LiteraPropValueExprFragment_0 = null;

        EObject this_TextMacroRef_1 = null;


         enterRule(); 
            
        try {
            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:569:28: ( (this_LiteraPropValueExprFragment_0= ruleLiteraPropValueExprFragment | this_TextMacroRef_1= ruleTextMacroRef ) )
            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:570:1: (this_LiteraPropValueExprFragment_0= ruleLiteraPropValueExprFragment | this_TextMacroRef_1= ruleTextMacroRef )
            {
            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:570:1: (this_LiteraPropValueExprFragment_0= ruleLiteraPropValueExprFragment | this_TextMacroRef_1= ruleTextMacroRef )
            int alt6=2;
            int LA6_0 = input.LA(1);

            if ( (LA6_0==RULE_STRING) ) {
                alt6=1;
            }
            else if ( (LA6_0==107) ) {
                alt6=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 6, 0, input);

                throw nvae;
            }
            switch (alt6) {
                case 1 :
                    // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:571:5: this_LiteraPropValueExprFragment_0= ruleLiteraPropValueExprFragment
                    {
                     
                            newCompositeNode(grammarAccess.getPropValueExprFragmentAccess().getLiteraPropValueExprFragmentParserRuleCall_0()); 
                        
                    pushFollow(FOLLOW_ruleLiteraPropValueExprFragment_in_rulePropValueExprFragment1277);
                    this_LiteraPropValueExprFragment_0=ruleLiteraPropValueExprFragment();

                    state._fsp--;

                     
                            current = this_LiteraPropValueExprFragment_0; 
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;
                case 2 :
                    // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:581:5: this_TextMacroRef_1= ruleTextMacroRef
                    {
                     
                            newCompositeNode(grammarAccess.getPropValueExprFragmentAccess().getTextMacroRefParserRuleCall_1()); 
                        
                    pushFollow(FOLLOW_ruleTextMacroRef_in_rulePropValueExprFragment1304);
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
    // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:597:1: entryRuleLiteraPropValueExprFragment returns [EObject current=null] : iv_ruleLiteraPropValueExprFragment= ruleLiteraPropValueExprFragment EOF ;
    public final EObject entryRuleLiteraPropValueExprFragment() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleLiteraPropValueExprFragment = null;


        try {
            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:598:2: (iv_ruleLiteraPropValueExprFragment= ruleLiteraPropValueExprFragment EOF )
            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:599:2: iv_ruleLiteraPropValueExprFragment= ruleLiteraPropValueExprFragment EOF
            {
             newCompositeNode(grammarAccess.getLiteraPropValueExprFragmentRule()); 
            pushFollow(FOLLOW_ruleLiteraPropValueExprFragment_in_entryRuleLiteraPropValueExprFragment1339);
            iv_ruleLiteraPropValueExprFragment=ruleLiteraPropValueExprFragment();

            state._fsp--;

             current =iv_ruleLiteraPropValueExprFragment; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleLiteraPropValueExprFragment1349); 

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
    // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:606:1: ruleLiteraPropValueExprFragment returns [EObject current=null] : ( (lv_value_0_0= RULE_STRING ) ) ;
    public final EObject ruleLiteraPropValueExprFragment() throws RecognitionException {
        EObject current = null;

        Token lv_value_0_0=null;

         enterRule(); 
            
        try {
            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:609:28: ( ( (lv_value_0_0= RULE_STRING ) ) )
            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:610:1: ( (lv_value_0_0= RULE_STRING ) )
            {
            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:610:1: ( (lv_value_0_0= RULE_STRING ) )
            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:611:1: (lv_value_0_0= RULE_STRING )
            {
            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:611:1: (lv_value_0_0= RULE_STRING )
            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:612:3: lv_value_0_0= RULE_STRING
            {
            lv_value_0_0=(Token)match(input,RULE_STRING,FOLLOW_RULE_STRING_in_ruleLiteraPropValueExprFragment1390); 

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
    // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:636:1: entryRuleIconDescriptorMdsl returns [EObject current=null] : iv_ruleIconDescriptorMdsl= ruleIconDescriptorMdsl EOF ;
    public final EObject entryRuleIconDescriptorMdsl() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleIconDescriptorMdsl = null;


        try {
            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:637:2: (iv_ruleIconDescriptorMdsl= ruleIconDescriptorMdsl EOF )
            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:638:2: iv_ruleIconDescriptorMdsl= ruleIconDescriptorMdsl EOF
            {
             newCompositeNode(grammarAccess.getIconDescriptorMdslRule()); 
            pushFollow(FOLLOW_ruleIconDescriptorMdsl_in_entryRuleIconDescriptorMdsl1430);
            iv_ruleIconDescriptorMdsl=ruleIconDescriptorMdsl();

            state._fsp--;

             current =iv_ruleIconDescriptorMdsl; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleIconDescriptorMdsl1440); 

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
    // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:645:1: ruleIconDescriptorMdsl returns [EObject current=null] : (otherlv_0= 'Use icon' ( (lv_name_1_0= RULE_ID ) ) (otherlv_2= 'description:' ( (lv_description_3_0= RULE_STRING ) ) )? ( (otherlv_4= 'location:' ( (lv_bundleDescriptor_5_0= ruleClassDescriptorMdsl ) ) ) | (otherlv_6= 'URI:' ( (lv_bundleUri_7_0= RULE_STRING ) ) ) ) ) ;
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
            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:648:28: ( (otherlv_0= 'Use icon' ( (lv_name_1_0= RULE_ID ) ) (otherlv_2= 'description:' ( (lv_description_3_0= RULE_STRING ) ) )? ( (otherlv_4= 'location:' ( (lv_bundleDescriptor_5_0= ruleClassDescriptorMdsl ) ) ) | (otherlv_6= 'URI:' ( (lv_bundleUri_7_0= RULE_STRING ) ) ) ) ) )
            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:649:1: (otherlv_0= 'Use icon' ( (lv_name_1_0= RULE_ID ) ) (otherlv_2= 'description:' ( (lv_description_3_0= RULE_STRING ) ) )? ( (otherlv_4= 'location:' ( (lv_bundleDescriptor_5_0= ruleClassDescriptorMdsl ) ) ) | (otherlv_6= 'URI:' ( (lv_bundleUri_7_0= RULE_STRING ) ) ) ) )
            {
            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:649:1: (otherlv_0= 'Use icon' ( (lv_name_1_0= RULE_ID ) ) (otherlv_2= 'description:' ( (lv_description_3_0= RULE_STRING ) ) )? ( (otherlv_4= 'location:' ( (lv_bundleDescriptor_5_0= ruleClassDescriptorMdsl ) ) ) | (otherlv_6= 'URI:' ( (lv_bundleUri_7_0= RULE_STRING ) ) ) ) )
            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:649:3: otherlv_0= 'Use icon' ( (lv_name_1_0= RULE_ID ) ) (otherlv_2= 'description:' ( (lv_description_3_0= RULE_STRING ) ) )? ( (otherlv_4= 'location:' ( (lv_bundleDescriptor_5_0= ruleClassDescriptorMdsl ) ) ) | (otherlv_6= 'URI:' ( (lv_bundleUri_7_0= RULE_STRING ) ) ) )
            {
            otherlv_0=(Token)match(input,16,FOLLOW_16_in_ruleIconDescriptorMdsl1477); 

                	newLeafNode(otherlv_0, grammarAccess.getIconDescriptorMdslAccess().getUseIconKeyword_0());
                
            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:653:1: ( (lv_name_1_0= RULE_ID ) )
            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:654:1: (lv_name_1_0= RULE_ID )
            {
            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:654:1: (lv_name_1_0= RULE_ID )
            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:655:3: lv_name_1_0= RULE_ID
            {
            lv_name_1_0=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleIconDescriptorMdsl1494); 

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

            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:671:2: (otherlv_2= 'description:' ( (lv_description_3_0= RULE_STRING ) ) )?
            int alt7=2;
            int LA7_0 = input.LA(1);

            if ( (LA7_0==17) ) {
                alt7=1;
            }
            switch (alt7) {
                case 1 :
                    // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:671:4: otherlv_2= 'description:' ( (lv_description_3_0= RULE_STRING ) )
                    {
                    otherlv_2=(Token)match(input,17,FOLLOW_17_in_ruleIconDescriptorMdsl1512); 

                        	newLeafNode(otherlv_2, grammarAccess.getIconDescriptorMdslAccess().getDescriptionKeyword_2_0());
                        
                    // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:675:1: ( (lv_description_3_0= RULE_STRING ) )
                    // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:676:1: (lv_description_3_0= RULE_STRING )
                    {
                    // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:676:1: (lv_description_3_0= RULE_STRING )
                    // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:677:3: lv_description_3_0= RULE_STRING
                    {
                    lv_description_3_0=(Token)match(input,RULE_STRING,FOLLOW_RULE_STRING_in_ruleIconDescriptorMdsl1529); 

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

            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:693:4: ( (otherlv_4= 'location:' ( (lv_bundleDescriptor_5_0= ruleClassDescriptorMdsl ) ) ) | (otherlv_6= 'URI:' ( (lv_bundleUri_7_0= RULE_STRING ) ) ) )
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
                    // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:693:5: (otherlv_4= 'location:' ( (lv_bundleDescriptor_5_0= ruleClassDescriptorMdsl ) ) )
                    {
                    // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:693:5: (otherlv_4= 'location:' ( (lv_bundleDescriptor_5_0= ruleClassDescriptorMdsl ) ) )
                    // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:693:7: otherlv_4= 'location:' ( (lv_bundleDescriptor_5_0= ruleClassDescriptorMdsl ) )
                    {
                    otherlv_4=(Token)match(input,18,FOLLOW_18_in_ruleIconDescriptorMdsl1550); 

                        	newLeafNode(otherlv_4, grammarAccess.getIconDescriptorMdslAccess().getLocationKeyword_3_0_0());
                        
                    // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:697:1: ( (lv_bundleDescriptor_5_0= ruleClassDescriptorMdsl ) )
                    // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:698:1: (lv_bundleDescriptor_5_0= ruleClassDescriptorMdsl )
                    {
                    // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:698:1: (lv_bundleDescriptor_5_0= ruleClassDescriptorMdsl )
                    // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:699:3: lv_bundleDescriptor_5_0= ruleClassDescriptorMdsl
                    {
                     
                    	        newCompositeNode(grammarAccess.getIconDescriptorMdslAccess().getBundleDescriptorClassDescriptorMdslParserRuleCall_3_0_1_0()); 
                    	    
                    pushFollow(FOLLOW_ruleClassDescriptorMdsl_in_ruleIconDescriptorMdsl1571);
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
                    // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:716:6: (otherlv_6= 'URI:' ( (lv_bundleUri_7_0= RULE_STRING ) ) )
                    {
                    // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:716:6: (otherlv_6= 'URI:' ( (lv_bundleUri_7_0= RULE_STRING ) ) )
                    // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:716:8: otherlv_6= 'URI:' ( (lv_bundleUri_7_0= RULE_STRING ) )
                    {
                    otherlv_6=(Token)match(input,19,FOLLOW_19_in_ruleIconDescriptorMdsl1591); 

                        	newLeafNode(otherlv_6, grammarAccess.getIconDescriptorMdslAccess().getURIKeyword_3_1_0());
                        
                    // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:720:1: ( (lv_bundleUri_7_0= RULE_STRING ) )
                    // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:721:1: (lv_bundleUri_7_0= RULE_STRING )
                    {
                    // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:721:1: (lv_bundleUri_7_0= RULE_STRING )
                    // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:722:3: lv_bundleUri_7_0= RULE_STRING
                    {
                    lv_bundleUri_7_0=(Token)match(input,RULE_STRING,FOLLOW_RULE_STRING_in_ruleIconDescriptorMdsl1608); 

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
    // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:746:1: entryRuleI18NBundleMdsl returns [EObject current=null] : iv_ruleI18NBundleMdsl= ruleI18NBundleMdsl EOF ;
    public final EObject entryRuleI18NBundleMdsl() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleI18NBundleMdsl = null;


        try {
            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:747:2: (iv_ruleI18NBundleMdsl= ruleI18NBundleMdsl EOF )
            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:748:2: iv_ruleI18NBundleMdsl= ruleI18NBundleMdsl EOF
            {
             newCompositeNode(grammarAccess.getI18NBundleMdslRule()); 
            pushFollow(FOLLOW_ruleI18NBundleMdsl_in_entryRuleI18NBundleMdsl1651);
            iv_ruleI18NBundleMdsl=ruleI18NBundleMdsl();

            state._fsp--;

             current =iv_ruleI18NBundleMdsl; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleI18NBundleMdsl1661); 

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
    // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:755:1: ruleI18NBundleMdsl returns [EObject current=null] : (otherlv_0= 'Use I18N Bundle' ( (lv_name_1_0= RULE_ID ) ) (otherlv_2= 'description:' ( (lv_description_3_0= RULE_STRING ) ) )? ( (otherlv_4= 'location:' ( (lv_bundleDescriptor_5_0= ruleClassDescriptorMdsl ) ) ) | (otherlv_6= 'URI:' ( (lv_bundleUri_7_0= RULE_STRING ) ) ) ) ) ;
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
            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:758:28: ( (otherlv_0= 'Use I18N Bundle' ( (lv_name_1_0= RULE_ID ) ) (otherlv_2= 'description:' ( (lv_description_3_0= RULE_STRING ) ) )? ( (otherlv_4= 'location:' ( (lv_bundleDescriptor_5_0= ruleClassDescriptorMdsl ) ) ) | (otherlv_6= 'URI:' ( (lv_bundleUri_7_0= RULE_STRING ) ) ) ) ) )
            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:759:1: (otherlv_0= 'Use I18N Bundle' ( (lv_name_1_0= RULE_ID ) ) (otherlv_2= 'description:' ( (lv_description_3_0= RULE_STRING ) ) )? ( (otherlv_4= 'location:' ( (lv_bundleDescriptor_5_0= ruleClassDescriptorMdsl ) ) ) | (otherlv_6= 'URI:' ( (lv_bundleUri_7_0= RULE_STRING ) ) ) ) )
            {
            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:759:1: (otherlv_0= 'Use I18N Bundle' ( (lv_name_1_0= RULE_ID ) ) (otherlv_2= 'description:' ( (lv_description_3_0= RULE_STRING ) ) )? ( (otherlv_4= 'location:' ( (lv_bundleDescriptor_5_0= ruleClassDescriptorMdsl ) ) ) | (otherlv_6= 'URI:' ( (lv_bundleUri_7_0= RULE_STRING ) ) ) ) )
            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:759:3: otherlv_0= 'Use I18N Bundle' ( (lv_name_1_0= RULE_ID ) ) (otherlv_2= 'description:' ( (lv_description_3_0= RULE_STRING ) ) )? ( (otherlv_4= 'location:' ( (lv_bundleDescriptor_5_0= ruleClassDescriptorMdsl ) ) ) | (otherlv_6= 'URI:' ( (lv_bundleUri_7_0= RULE_STRING ) ) ) )
            {
            otherlv_0=(Token)match(input,20,FOLLOW_20_in_ruleI18NBundleMdsl1698); 

                	newLeafNode(otherlv_0, grammarAccess.getI18NBundleMdslAccess().getUseI18NBundleKeyword_0());
                
            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:763:1: ( (lv_name_1_0= RULE_ID ) )
            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:764:1: (lv_name_1_0= RULE_ID )
            {
            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:764:1: (lv_name_1_0= RULE_ID )
            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:765:3: lv_name_1_0= RULE_ID
            {
            lv_name_1_0=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleI18NBundleMdsl1715); 

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

            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:781:2: (otherlv_2= 'description:' ( (lv_description_3_0= RULE_STRING ) ) )?
            int alt9=2;
            int LA9_0 = input.LA(1);

            if ( (LA9_0==17) ) {
                alt9=1;
            }
            switch (alt9) {
                case 1 :
                    // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:781:4: otherlv_2= 'description:' ( (lv_description_3_0= RULE_STRING ) )
                    {
                    otherlv_2=(Token)match(input,17,FOLLOW_17_in_ruleI18NBundleMdsl1733); 

                        	newLeafNode(otherlv_2, grammarAccess.getI18NBundleMdslAccess().getDescriptionKeyword_2_0());
                        
                    // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:785:1: ( (lv_description_3_0= RULE_STRING ) )
                    // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:786:1: (lv_description_3_0= RULE_STRING )
                    {
                    // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:786:1: (lv_description_3_0= RULE_STRING )
                    // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:787:3: lv_description_3_0= RULE_STRING
                    {
                    lv_description_3_0=(Token)match(input,RULE_STRING,FOLLOW_RULE_STRING_in_ruleI18NBundleMdsl1750); 

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

            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:803:4: ( (otherlv_4= 'location:' ( (lv_bundleDescriptor_5_0= ruleClassDescriptorMdsl ) ) ) | (otherlv_6= 'URI:' ( (lv_bundleUri_7_0= RULE_STRING ) ) ) )
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
                    // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:803:5: (otherlv_4= 'location:' ( (lv_bundleDescriptor_5_0= ruleClassDescriptorMdsl ) ) )
                    {
                    // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:803:5: (otherlv_4= 'location:' ( (lv_bundleDescriptor_5_0= ruleClassDescriptorMdsl ) ) )
                    // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:803:7: otherlv_4= 'location:' ( (lv_bundleDescriptor_5_0= ruleClassDescriptorMdsl ) )
                    {
                    otherlv_4=(Token)match(input,18,FOLLOW_18_in_ruleI18NBundleMdsl1771); 

                        	newLeafNode(otherlv_4, grammarAccess.getI18NBundleMdslAccess().getLocationKeyword_3_0_0());
                        
                    // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:807:1: ( (lv_bundleDescriptor_5_0= ruleClassDescriptorMdsl ) )
                    // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:808:1: (lv_bundleDescriptor_5_0= ruleClassDescriptorMdsl )
                    {
                    // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:808:1: (lv_bundleDescriptor_5_0= ruleClassDescriptorMdsl )
                    // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:809:3: lv_bundleDescriptor_5_0= ruleClassDescriptorMdsl
                    {
                     
                    	        newCompositeNode(grammarAccess.getI18NBundleMdslAccess().getBundleDescriptorClassDescriptorMdslParserRuleCall_3_0_1_0()); 
                    	    
                    pushFollow(FOLLOW_ruleClassDescriptorMdsl_in_ruleI18NBundleMdsl1792);
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
                    // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:826:6: (otherlv_6= 'URI:' ( (lv_bundleUri_7_0= RULE_STRING ) ) )
                    {
                    // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:826:6: (otherlv_6= 'URI:' ( (lv_bundleUri_7_0= RULE_STRING ) ) )
                    // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:826:8: otherlv_6= 'URI:' ( (lv_bundleUri_7_0= RULE_STRING ) )
                    {
                    otherlv_6=(Token)match(input,19,FOLLOW_19_in_ruleI18NBundleMdsl1812); 

                        	newLeafNode(otherlv_6, grammarAccess.getI18NBundleMdslAccess().getURIKeyword_3_1_0());
                        
                    // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:830:1: ( (lv_bundleUri_7_0= RULE_STRING ) )
                    // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:831:1: (lv_bundleUri_7_0= RULE_STRING )
                    {
                    // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:831:1: (lv_bundleUri_7_0= RULE_STRING )
                    // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:832:3: lv_bundleUri_7_0= RULE_STRING
                    {
                    lv_bundleUri_7_0=(Token)match(input,RULE_STRING,FOLLOW_RULE_STRING_in_ruleI18NBundleMdsl1829); 

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
    // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:856:1: entryRuleForeignModelMdsl returns [EObject current=null] : iv_ruleForeignModelMdsl= ruleForeignModelMdsl EOF ;
    public final EObject entryRuleForeignModelMdsl() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleForeignModelMdsl = null;


        try {
            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:857:2: (iv_ruleForeignModelMdsl= ruleForeignModelMdsl EOF )
            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:858:2: iv_ruleForeignModelMdsl= ruleForeignModelMdsl EOF
            {
             newCompositeNode(grammarAccess.getForeignModelMdslRule()); 
            pushFollow(FOLLOW_ruleForeignModelMdsl_in_entryRuleForeignModelMdsl1872);
            iv_ruleForeignModelMdsl=ruleForeignModelMdsl();

            state._fsp--;

             current =iv_ruleForeignModelMdsl; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleForeignModelMdsl1882); 

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
    // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:865:1: ruleForeignModelMdsl returns [EObject current=null] : (otherlv_0= 'Foreign Model' otherlv_1= '{' otherlv_2= 'model type:' ( (lv_name_3_0= RULE_ID ) ) otherlv_4= 'label:' ( (lv_label_5_0= RULE_STRING ) ) (otherlv_6= 'description:' ( (lv_description_7_0= RULE_STRING ) ) )? ( (lv_provider_8_0= ruleModelProviderMdsl ) ) (otherlv_9= 'options:' ( (lv_autoReloadEnabled_10_0= 'AUTO_RELOAD' ) )? )? (otherlv_11= 'synchronizer factory' otherlv_12= ':' ( (lv_synchronizerFactoryClass_13_0= ruleClassDescriptorMdsl ) ) )? (otherlv_14= 'extension manager' otherlv_15= ':' ( (lv_extensionManagerClass_16_0= ruleClassDescriptorMdsl ) ) )? ( (lv_dslReference_17_0= ruleXtextLanguageReference ) )? (otherlv_18= 'model locator:' ( (lv_relocatorQuery_19_0= ruleQuery ) ) )? otherlv_20= '}' ) ;
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
        Token lv_autoReloadEnabled_10_0=null;
        Token otherlv_11=null;
        Token otherlv_12=null;
        Token otherlv_14=null;
        Token otherlv_15=null;
        Token otherlv_18=null;
        Token otherlv_20=null;
        EObject lv_provider_8_0 = null;

        EObject lv_synchronizerFactoryClass_13_0 = null;

        EObject lv_extensionManagerClass_16_0 = null;

        EObject lv_dslReference_17_0 = null;

        EObject lv_relocatorQuery_19_0 = null;


         enterRule(); 
            
        try {
            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:868:28: ( (otherlv_0= 'Foreign Model' otherlv_1= '{' otherlv_2= 'model type:' ( (lv_name_3_0= RULE_ID ) ) otherlv_4= 'label:' ( (lv_label_5_0= RULE_STRING ) ) (otherlv_6= 'description:' ( (lv_description_7_0= RULE_STRING ) ) )? ( (lv_provider_8_0= ruleModelProviderMdsl ) ) (otherlv_9= 'options:' ( (lv_autoReloadEnabled_10_0= 'AUTO_RELOAD' ) )? )? (otherlv_11= 'synchronizer factory' otherlv_12= ':' ( (lv_synchronizerFactoryClass_13_0= ruleClassDescriptorMdsl ) ) )? (otherlv_14= 'extension manager' otherlv_15= ':' ( (lv_extensionManagerClass_16_0= ruleClassDescriptorMdsl ) ) )? ( (lv_dslReference_17_0= ruleXtextLanguageReference ) )? (otherlv_18= 'model locator:' ( (lv_relocatorQuery_19_0= ruleQuery ) ) )? otherlv_20= '}' ) )
            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:869:1: (otherlv_0= 'Foreign Model' otherlv_1= '{' otherlv_2= 'model type:' ( (lv_name_3_0= RULE_ID ) ) otherlv_4= 'label:' ( (lv_label_5_0= RULE_STRING ) ) (otherlv_6= 'description:' ( (lv_description_7_0= RULE_STRING ) ) )? ( (lv_provider_8_0= ruleModelProviderMdsl ) ) (otherlv_9= 'options:' ( (lv_autoReloadEnabled_10_0= 'AUTO_RELOAD' ) )? )? (otherlv_11= 'synchronizer factory' otherlv_12= ':' ( (lv_synchronizerFactoryClass_13_0= ruleClassDescriptorMdsl ) ) )? (otherlv_14= 'extension manager' otherlv_15= ':' ( (lv_extensionManagerClass_16_0= ruleClassDescriptorMdsl ) ) )? ( (lv_dslReference_17_0= ruleXtextLanguageReference ) )? (otherlv_18= 'model locator:' ( (lv_relocatorQuery_19_0= ruleQuery ) ) )? otherlv_20= '}' )
            {
            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:869:1: (otherlv_0= 'Foreign Model' otherlv_1= '{' otherlv_2= 'model type:' ( (lv_name_3_0= RULE_ID ) ) otherlv_4= 'label:' ( (lv_label_5_0= RULE_STRING ) ) (otherlv_6= 'description:' ( (lv_description_7_0= RULE_STRING ) ) )? ( (lv_provider_8_0= ruleModelProviderMdsl ) ) (otherlv_9= 'options:' ( (lv_autoReloadEnabled_10_0= 'AUTO_RELOAD' ) )? )? (otherlv_11= 'synchronizer factory' otherlv_12= ':' ( (lv_synchronizerFactoryClass_13_0= ruleClassDescriptorMdsl ) ) )? (otherlv_14= 'extension manager' otherlv_15= ':' ( (lv_extensionManagerClass_16_0= ruleClassDescriptorMdsl ) ) )? ( (lv_dslReference_17_0= ruleXtextLanguageReference ) )? (otherlv_18= 'model locator:' ( (lv_relocatorQuery_19_0= ruleQuery ) ) )? otherlv_20= '}' )
            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:869:3: otherlv_0= 'Foreign Model' otherlv_1= '{' otherlv_2= 'model type:' ( (lv_name_3_0= RULE_ID ) ) otherlv_4= 'label:' ( (lv_label_5_0= RULE_STRING ) ) (otherlv_6= 'description:' ( (lv_description_7_0= RULE_STRING ) ) )? ( (lv_provider_8_0= ruleModelProviderMdsl ) ) (otherlv_9= 'options:' ( (lv_autoReloadEnabled_10_0= 'AUTO_RELOAD' ) )? )? (otherlv_11= 'synchronizer factory' otherlv_12= ':' ( (lv_synchronizerFactoryClass_13_0= ruleClassDescriptorMdsl ) ) )? (otherlv_14= 'extension manager' otherlv_15= ':' ( (lv_extensionManagerClass_16_0= ruleClassDescriptorMdsl ) ) )? ( (lv_dslReference_17_0= ruleXtextLanguageReference ) )? (otherlv_18= 'model locator:' ( (lv_relocatorQuery_19_0= ruleQuery ) ) )? otherlv_20= '}'
            {
            otherlv_0=(Token)match(input,21,FOLLOW_21_in_ruleForeignModelMdsl1919); 

                	newLeafNode(otherlv_0, grammarAccess.getForeignModelMdslAccess().getForeignModelKeyword_0());
                
            otherlv_1=(Token)match(input,22,FOLLOW_22_in_ruleForeignModelMdsl1931); 

                	newLeafNode(otherlv_1, grammarAccess.getForeignModelMdslAccess().getLeftCurlyBracketKeyword_1());
                
            otherlv_2=(Token)match(input,23,FOLLOW_23_in_ruleForeignModelMdsl1943); 

                	newLeafNode(otherlv_2, grammarAccess.getForeignModelMdslAccess().getModelTypeKeyword_2());
                
            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:881:1: ( (lv_name_3_0= RULE_ID ) )
            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:882:1: (lv_name_3_0= RULE_ID )
            {
            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:882:1: (lv_name_3_0= RULE_ID )
            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:883:3: lv_name_3_0= RULE_ID
            {
            lv_name_3_0=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleForeignModelMdsl1960); 

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

            otherlv_4=(Token)match(input,13,FOLLOW_13_in_ruleForeignModelMdsl1977); 

                	newLeafNode(otherlv_4, grammarAccess.getForeignModelMdslAccess().getLabelKeyword_4());
                
            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:903:1: ( (lv_label_5_0= RULE_STRING ) )
            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:904:1: (lv_label_5_0= RULE_STRING )
            {
            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:904:1: (lv_label_5_0= RULE_STRING )
            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:905:3: lv_label_5_0= RULE_STRING
            {
            lv_label_5_0=(Token)match(input,RULE_STRING,FOLLOW_RULE_STRING_in_ruleForeignModelMdsl1994); 

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

            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:921:2: (otherlv_6= 'description:' ( (lv_description_7_0= RULE_STRING ) ) )?
            int alt11=2;
            int LA11_0 = input.LA(1);

            if ( (LA11_0==17) ) {
                alt11=1;
            }
            switch (alt11) {
                case 1 :
                    // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:921:4: otherlv_6= 'description:' ( (lv_description_7_0= RULE_STRING ) )
                    {
                    otherlv_6=(Token)match(input,17,FOLLOW_17_in_ruleForeignModelMdsl2012); 

                        	newLeafNode(otherlv_6, grammarAccess.getForeignModelMdslAccess().getDescriptionKeyword_6_0());
                        
                    // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:925:1: ( (lv_description_7_0= RULE_STRING ) )
                    // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:926:1: (lv_description_7_0= RULE_STRING )
                    {
                    // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:926:1: (lv_description_7_0= RULE_STRING )
                    // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:927:3: lv_description_7_0= RULE_STRING
                    {
                    lv_description_7_0=(Token)match(input,RULE_STRING,FOLLOW_RULE_STRING_in_ruleForeignModelMdsl2029); 

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

            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:943:4: ( (lv_provider_8_0= ruleModelProviderMdsl ) )
            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:944:1: (lv_provider_8_0= ruleModelProviderMdsl )
            {
            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:944:1: (lv_provider_8_0= ruleModelProviderMdsl )
            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:945:3: lv_provider_8_0= ruleModelProviderMdsl
            {
             
            	        newCompositeNode(grammarAccess.getForeignModelMdslAccess().getProviderModelProviderMdslParserRuleCall_7_0()); 
            	    
            pushFollow(FOLLOW_ruleModelProviderMdsl_in_ruleForeignModelMdsl2057);
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

            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:961:2: (otherlv_9= 'options:' ( (lv_autoReloadEnabled_10_0= 'AUTO_RELOAD' ) )? )?
            int alt13=2;
            int LA13_0 = input.LA(1);

            if ( (LA13_0==24) ) {
                alt13=1;
            }
            switch (alt13) {
                case 1 :
                    // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:961:4: otherlv_9= 'options:' ( (lv_autoReloadEnabled_10_0= 'AUTO_RELOAD' ) )?
                    {
                    otherlv_9=(Token)match(input,24,FOLLOW_24_in_ruleForeignModelMdsl2070); 

                        	newLeafNode(otherlv_9, grammarAccess.getForeignModelMdslAccess().getOptionsKeyword_8_0());
                        
                    // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:965:1: ( (lv_autoReloadEnabled_10_0= 'AUTO_RELOAD' ) )?
                    int alt12=2;
                    int LA12_0 = input.LA(1);

                    if ( (LA12_0==25) ) {
                        alt12=1;
                    }
                    switch (alt12) {
                        case 1 :
                            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:966:1: (lv_autoReloadEnabled_10_0= 'AUTO_RELOAD' )
                            {
                            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:966:1: (lv_autoReloadEnabled_10_0= 'AUTO_RELOAD' )
                            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:967:3: lv_autoReloadEnabled_10_0= 'AUTO_RELOAD'
                            {
                            lv_autoReloadEnabled_10_0=(Token)match(input,25,FOLLOW_25_in_ruleForeignModelMdsl2088); 

                                    newLeafNode(lv_autoReloadEnabled_10_0, grammarAccess.getForeignModelMdslAccess().getAutoReloadEnabledAUTO_RELOADKeyword_8_1_0());
                                

                            	        if (current==null) {
                            	            current = createModelElement(grammarAccess.getForeignModelMdslRule());
                            	        }
                                   		setWithLastConsumed(current, "autoReloadEnabled", true, "AUTO_RELOAD");
                            	    

                            }


                            }
                            break;

                    }


                    }
                    break;

            }

            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:980:5: (otherlv_11= 'synchronizer factory' otherlv_12= ':' ( (lv_synchronizerFactoryClass_13_0= ruleClassDescriptorMdsl ) ) )?
            int alt14=2;
            int LA14_0 = input.LA(1);

            if ( (LA14_0==26) ) {
                alt14=1;
            }
            switch (alt14) {
                case 1 :
                    // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:980:7: otherlv_11= 'synchronizer factory' otherlv_12= ':' ( (lv_synchronizerFactoryClass_13_0= ruleClassDescriptorMdsl ) )
                    {
                    otherlv_11=(Token)match(input,26,FOLLOW_26_in_ruleForeignModelMdsl2117); 

                        	newLeafNode(otherlv_11, grammarAccess.getForeignModelMdslAccess().getSynchronizerFactoryKeyword_9_0());
                        
                    otherlv_12=(Token)match(input,27,FOLLOW_27_in_ruleForeignModelMdsl2129); 

                        	newLeafNode(otherlv_12, grammarAccess.getForeignModelMdslAccess().getColonKeyword_9_1());
                        
                    // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:988:1: ( (lv_synchronizerFactoryClass_13_0= ruleClassDescriptorMdsl ) )
                    // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:989:1: (lv_synchronizerFactoryClass_13_0= ruleClassDescriptorMdsl )
                    {
                    // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:989:1: (lv_synchronizerFactoryClass_13_0= ruleClassDescriptorMdsl )
                    // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:990:3: lv_synchronizerFactoryClass_13_0= ruleClassDescriptorMdsl
                    {
                     
                    	        newCompositeNode(grammarAccess.getForeignModelMdslAccess().getSynchronizerFactoryClassClassDescriptorMdslParserRuleCall_9_2_0()); 
                    	    
                    pushFollow(FOLLOW_ruleClassDescriptorMdsl_in_ruleForeignModelMdsl2150);
                    lv_synchronizerFactoryClass_13_0=ruleClassDescriptorMdsl();

                    state._fsp--;


                    	        if (current==null) {
                    	            current = createModelElementForParent(grammarAccess.getForeignModelMdslRule());
                    	        }
                           		set(
                           			current, 
                           			"synchronizerFactoryClass",
                            		lv_synchronizerFactoryClass_13_0, 
                            		"ClassDescriptorMdsl");
                    	        afterParserOrEnumRuleCall();
                    	    

                    }


                    }


                    }
                    break;

            }

            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:1006:4: (otherlv_14= 'extension manager' otherlv_15= ':' ( (lv_extensionManagerClass_16_0= ruleClassDescriptorMdsl ) ) )?
            int alt15=2;
            int LA15_0 = input.LA(1);

            if ( (LA15_0==28) ) {
                alt15=1;
            }
            switch (alt15) {
                case 1 :
                    // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:1006:6: otherlv_14= 'extension manager' otherlv_15= ':' ( (lv_extensionManagerClass_16_0= ruleClassDescriptorMdsl ) )
                    {
                    otherlv_14=(Token)match(input,28,FOLLOW_28_in_ruleForeignModelMdsl2165); 

                        	newLeafNode(otherlv_14, grammarAccess.getForeignModelMdslAccess().getExtensionManagerKeyword_10_0());
                        
                    otherlv_15=(Token)match(input,27,FOLLOW_27_in_ruleForeignModelMdsl2177); 

                        	newLeafNode(otherlv_15, grammarAccess.getForeignModelMdslAccess().getColonKeyword_10_1());
                        
                    // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:1014:1: ( (lv_extensionManagerClass_16_0= ruleClassDescriptorMdsl ) )
                    // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:1015:1: (lv_extensionManagerClass_16_0= ruleClassDescriptorMdsl )
                    {
                    // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:1015:1: (lv_extensionManagerClass_16_0= ruleClassDescriptorMdsl )
                    // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:1016:3: lv_extensionManagerClass_16_0= ruleClassDescriptorMdsl
                    {
                     
                    	        newCompositeNode(grammarAccess.getForeignModelMdslAccess().getExtensionManagerClassClassDescriptorMdslParserRuleCall_10_2_0()); 
                    	    
                    pushFollow(FOLLOW_ruleClassDescriptorMdsl_in_ruleForeignModelMdsl2198);
                    lv_extensionManagerClass_16_0=ruleClassDescriptorMdsl();

                    state._fsp--;


                    	        if (current==null) {
                    	            current = createModelElementForParent(grammarAccess.getForeignModelMdslRule());
                    	        }
                           		set(
                           			current, 
                           			"extensionManagerClass",
                            		lv_extensionManagerClass_16_0, 
                            		"ClassDescriptorMdsl");
                    	        afterParserOrEnumRuleCall();
                    	    

                    }


                    }


                    }
                    break;

            }

            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:1032:4: ( (lv_dslReference_17_0= ruleXtextLanguageReference ) )?
            int alt16=2;
            int LA16_0 = input.LA(1);

            if ( (LA16_0==40) ) {
                alt16=1;
            }
            switch (alt16) {
                case 1 :
                    // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:1033:1: (lv_dslReference_17_0= ruleXtextLanguageReference )
                    {
                    // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:1033:1: (lv_dslReference_17_0= ruleXtextLanguageReference )
                    // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:1034:3: lv_dslReference_17_0= ruleXtextLanguageReference
                    {
                     
                    	        newCompositeNode(grammarAccess.getForeignModelMdslAccess().getDslReferenceXtextLanguageReferenceParserRuleCall_11_0()); 
                    	    
                    pushFollow(FOLLOW_ruleXtextLanguageReference_in_ruleForeignModelMdsl2221);
                    lv_dslReference_17_0=ruleXtextLanguageReference();

                    state._fsp--;


                    	        if (current==null) {
                    	            current = createModelElementForParent(grammarAccess.getForeignModelMdslRule());
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

            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:1050:3: (otherlv_18= 'model locator:' ( (lv_relocatorQuery_19_0= ruleQuery ) ) )?
            int alt17=2;
            int LA17_0 = input.LA(1);

            if ( (LA17_0==29) ) {
                alt17=1;
            }
            switch (alt17) {
                case 1 :
                    // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:1050:5: otherlv_18= 'model locator:' ( (lv_relocatorQuery_19_0= ruleQuery ) )
                    {
                    otherlv_18=(Token)match(input,29,FOLLOW_29_in_ruleForeignModelMdsl2235); 

                        	newLeafNode(otherlv_18, grammarAccess.getForeignModelMdslAccess().getModelLocatorKeyword_12_0());
                        
                    // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:1054:1: ( (lv_relocatorQuery_19_0= ruleQuery ) )
                    // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:1055:1: (lv_relocatorQuery_19_0= ruleQuery )
                    {
                    // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:1055:1: (lv_relocatorQuery_19_0= ruleQuery )
                    // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:1056:3: lv_relocatorQuery_19_0= ruleQuery
                    {
                     
                    	        newCompositeNode(grammarAccess.getForeignModelMdslAccess().getRelocatorQueryQueryParserRuleCall_12_1_0()); 
                    	    
                    pushFollow(FOLLOW_ruleQuery_in_ruleForeignModelMdsl2256);
                    lv_relocatorQuery_19_0=ruleQuery();

                    state._fsp--;


                    	        if (current==null) {
                    	            current = createModelElementForParent(grammarAccess.getForeignModelMdslRule());
                    	        }
                           		set(
                           			current, 
                           			"relocatorQuery",
                            		lv_relocatorQuery_19_0, 
                            		"Query");
                    	        afterParserOrEnumRuleCall();
                    	    

                    }


                    }


                    }
                    break;

            }

            otherlv_20=(Token)match(input,30,FOLLOW_30_in_ruleForeignModelMdsl2270); 

                	newLeafNode(otherlv_20, grammarAccess.getForeignModelMdslAccess().getRightCurlyBracketKeyword_13());
                

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
    // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:1084:1: entryRuleModelProviderMdsl returns [EObject current=null] : iv_ruleModelProviderMdsl= ruleModelProviderMdsl EOF ;
    public final EObject entryRuleModelProviderMdsl() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleModelProviderMdsl = null;


        try {
            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:1085:2: (iv_ruleModelProviderMdsl= ruleModelProviderMdsl EOF )
            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:1086:2: iv_ruleModelProviderMdsl= ruleModelProviderMdsl EOF
            {
             newCompositeNode(grammarAccess.getModelProviderMdslRule()); 
            pushFollow(FOLLOW_ruleModelProviderMdsl_in_entryRuleModelProviderMdsl2306);
            iv_ruleModelProviderMdsl=ruleModelProviderMdsl();

            state._fsp--;

             current =iv_ruleModelProviderMdsl; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleModelProviderMdsl2316); 

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
    // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:1093:1: ruleModelProviderMdsl returns [EObject current=null] : (this_URIModelProviderMdsl_0= ruleURIModelProviderMdsl | this_URIExtensionModelProviderMdsl_1= ruleURIExtensionModelProviderMdsl | this_CustomModelProviderMdsl_2= ruleCustomModelProviderMdsl ) ;
    public final EObject ruleModelProviderMdsl() throws RecognitionException {
        EObject current = null;

        EObject this_URIModelProviderMdsl_0 = null;

        EObject this_URIExtensionModelProviderMdsl_1 = null;

        EObject this_CustomModelProviderMdsl_2 = null;


         enterRule(); 
            
        try {
            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:1096:28: ( (this_URIModelProviderMdsl_0= ruleURIModelProviderMdsl | this_URIExtensionModelProviderMdsl_1= ruleURIExtensionModelProviderMdsl | this_CustomModelProviderMdsl_2= ruleCustomModelProviderMdsl ) )
            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:1097:1: (this_URIModelProviderMdsl_0= ruleURIModelProviderMdsl | this_URIExtensionModelProviderMdsl_1= ruleURIExtensionModelProviderMdsl | this_CustomModelProviderMdsl_2= ruleCustomModelProviderMdsl )
            {
            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:1097:1: (this_URIModelProviderMdsl_0= ruleURIModelProviderMdsl | this_URIExtensionModelProviderMdsl_1= ruleURIExtensionModelProviderMdsl | this_CustomModelProviderMdsl_2= ruleCustomModelProviderMdsl )
            int alt18=3;
            switch ( input.LA(1) ) {
            case 32:
                {
                alt18=1;
                }
                break;
            case 31:
                {
                alt18=2;
                }
                break;
            case 33:
                {
                alt18=3;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 18, 0, input);

                throw nvae;
            }

            switch (alt18) {
                case 1 :
                    // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:1098:5: this_URIModelProviderMdsl_0= ruleURIModelProviderMdsl
                    {
                     
                            newCompositeNode(grammarAccess.getModelProviderMdslAccess().getURIModelProviderMdslParserRuleCall_0()); 
                        
                    pushFollow(FOLLOW_ruleURIModelProviderMdsl_in_ruleModelProviderMdsl2363);
                    this_URIModelProviderMdsl_0=ruleURIModelProviderMdsl();

                    state._fsp--;

                     
                            current = this_URIModelProviderMdsl_0; 
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;
                case 2 :
                    // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:1108:5: this_URIExtensionModelProviderMdsl_1= ruleURIExtensionModelProviderMdsl
                    {
                     
                            newCompositeNode(grammarAccess.getModelProviderMdslAccess().getURIExtensionModelProviderMdslParserRuleCall_1()); 
                        
                    pushFollow(FOLLOW_ruleURIExtensionModelProviderMdsl_in_ruleModelProviderMdsl2390);
                    this_URIExtensionModelProviderMdsl_1=ruleURIExtensionModelProviderMdsl();

                    state._fsp--;

                     
                            current = this_URIExtensionModelProviderMdsl_1; 
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;
                case 3 :
                    // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:1118:5: this_CustomModelProviderMdsl_2= ruleCustomModelProviderMdsl
                    {
                     
                            newCompositeNode(grammarAccess.getModelProviderMdslAccess().getCustomModelProviderMdslParserRuleCall_2()); 
                        
                    pushFollow(FOLLOW_ruleCustomModelProviderMdsl_in_ruleModelProviderMdsl2417);
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
    // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:1134:1: entryRuleURIExtensionModelProviderMdsl returns [EObject current=null] : iv_ruleURIExtensionModelProviderMdsl= ruleURIExtensionModelProviderMdsl EOF ;
    public final EObject entryRuleURIExtensionModelProviderMdsl() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleURIExtensionModelProviderMdsl = null;


        try {
            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:1135:2: (iv_ruleURIExtensionModelProviderMdsl= ruleURIExtensionModelProviderMdsl EOF )
            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:1136:2: iv_ruleURIExtensionModelProviderMdsl= ruleURIExtensionModelProviderMdsl EOF
            {
             newCompositeNode(grammarAccess.getURIExtensionModelProviderMdslRule()); 
            pushFollow(FOLLOW_ruleURIExtensionModelProviderMdsl_in_entryRuleURIExtensionModelProviderMdsl2452);
            iv_ruleURIExtensionModelProviderMdsl=ruleURIExtensionModelProviderMdsl();

            state._fsp--;

             current =iv_ruleURIExtensionModelProviderMdsl; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleURIExtensionModelProviderMdsl2462); 

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
    // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:1143:1: ruleURIExtensionModelProviderMdsl returns [EObject current=null] : (otherlv_0= 'Uri Extension:' ( (lv_uriExtension_1_0= RULE_STRING ) ) ) ;
    public final EObject ruleURIExtensionModelProviderMdsl() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token lv_uriExtension_1_0=null;

         enterRule(); 
            
        try {
            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:1146:28: ( (otherlv_0= 'Uri Extension:' ( (lv_uriExtension_1_0= RULE_STRING ) ) ) )
            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:1147:1: (otherlv_0= 'Uri Extension:' ( (lv_uriExtension_1_0= RULE_STRING ) ) )
            {
            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:1147:1: (otherlv_0= 'Uri Extension:' ( (lv_uriExtension_1_0= RULE_STRING ) ) )
            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:1147:3: otherlv_0= 'Uri Extension:' ( (lv_uriExtension_1_0= RULE_STRING ) )
            {
            otherlv_0=(Token)match(input,31,FOLLOW_31_in_ruleURIExtensionModelProviderMdsl2499); 

                	newLeafNode(otherlv_0, grammarAccess.getURIExtensionModelProviderMdslAccess().getUriExtensionKeyword_0());
                
            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:1151:1: ( (lv_uriExtension_1_0= RULE_STRING ) )
            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:1152:1: (lv_uriExtension_1_0= RULE_STRING )
            {
            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:1152:1: (lv_uriExtension_1_0= RULE_STRING )
            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:1153:3: lv_uriExtension_1_0= RULE_STRING
            {
            lv_uriExtension_1_0=(Token)match(input,RULE_STRING,FOLLOW_RULE_STRING_in_ruleURIExtensionModelProviderMdsl2516); 

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
    // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:1177:1: entryRuleURIModelProviderMdsl returns [EObject current=null] : iv_ruleURIModelProviderMdsl= ruleURIModelProviderMdsl EOF ;
    public final EObject entryRuleURIModelProviderMdsl() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleURIModelProviderMdsl = null;


        try {
            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:1178:2: (iv_ruleURIModelProviderMdsl= ruleURIModelProviderMdsl EOF )
            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:1179:2: iv_ruleURIModelProviderMdsl= ruleURIModelProviderMdsl EOF
            {
             newCompositeNode(grammarAccess.getURIModelProviderMdslRule()); 
            pushFollow(FOLLOW_ruleURIModelProviderMdsl_in_entryRuleURIModelProviderMdsl2557);
            iv_ruleURIModelProviderMdsl=ruleURIModelProviderMdsl();

            state._fsp--;

             current =iv_ruleURIModelProviderMdsl; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleURIModelProviderMdsl2567); 

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
    // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:1186:1: ruleURIModelProviderMdsl returns [EObject current=null] : (otherlv_0= 'Model Uri:' ( (lv_modelUri_1_0= RULE_STRING ) ) ) ;
    public final EObject ruleURIModelProviderMdsl() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token lv_modelUri_1_0=null;

         enterRule(); 
            
        try {
            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:1189:28: ( (otherlv_0= 'Model Uri:' ( (lv_modelUri_1_0= RULE_STRING ) ) ) )
            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:1190:1: (otherlv_0= 'Model Uri:' ( (lv_modelUri_1_0= RULE_STRING ) ) )
            {
            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:1190:1: (otherlv_0= 'Model Uri:' ( (lv_modelUri_1_0= RULE_STRING ) ) )
            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:1190:3: otherlv_0= 'Model Uri:' ( (lv_modelUri_1_0= RULE_STRING ) )
            {
            otherlv_0=(Token)match(input,32,FOLLOW_32_in_ruleURIModelProviderMdsl2604); 

                	newLeafNode(otherlv_0, grammarAccess.getURIModelProviderMdslAccess().getModelUriKeyword_0());
                
            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:1194:1: ( (lv_modelUri_1_0= RULE_STRING ) )
            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:1195:1: (lv_modelUri_1_0= RULE_STRING )
            {
            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:1195:1: (lv_modelUri_1_0= RULE_STRING )
            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:1196:3: lv_modelUri_1_0= RULE_STRING
            {
            lv_modelUri_1_0=(Token)match(input,RULE_STRING,FOLLOW_RULE_STRING_in_ruleURIModelProviderMdsl2621); 

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
    // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:1220:1: entryRuleCustomModelProviderMdsl returns [EObject current=null] : iv_ruleCustomModelProviderMdsl= ruleCustomModelProviderMdsl EOF ;
    public final EObject entryRuleCustomModelProviderMdsl() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleCustomModelProviderMdsl = null;


        try {
            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:1221:2: (iv_ruleCustomModelProviderMdsl= ruleCustomModelProviderMdsl EOF )
            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:1222:2: iv_ruleCustomModelProviderMdsl= ruleCustomModelProviderMdsl EOF
            {
             newCompositeNode(grammarAccess.getCustomModelProviderMdslRule()); 
            pushFollow(FOLLOW_ruleCustomModelProviderMdsl_in_entryRuleCustomModelProviderMdsl2662);
            iv_ruleCustomModelProviderMdsl=ruleCustomModelProviderMdsl();

            state._fsp--;

             current =iv_ruleCustomModelProviderMdsl; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleCustomModelProviderMdsl2672); 

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
    // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:1229:1: ruleCustomModelProviderMdsl returns [EObject current=null] : (otherlv_0= 'Provider Class:' ( (lv_classDescriptor_1_0= ruleClassDescriptorMdsl ) ) (otherlv_2= 'parameters:' ( (lv_parameters_3_0= RULE_STRING ) ) (otherlv_4= ',' ( (lv_parameters_5_0= RULE_STRING ) ) )? )? ) ;
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
            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:1232:28: ( (otherlv_0= 'Provider Class:' ( (lv_classDescriptor_1_0= ruleClassDescriptorMdsl ) ) (otherlv_2= 'parameters:' ( (lv_parameters_3_0= RULE_STRING ) ) (otherlv_4= ',' ( (lv_parameters_5_0= RULE_STRING ) ) )? )? ) )
            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:1233:1: (otherlv_0= 'Provider Class:' ( (lv_classDescriptor_1_0= ruleClassDescriptorMdsl ) ) (otherlv_2= 'parameters:' ( (lv_parameters_3_0= RULE_STRING ) ) (otherlv_4= ',' ( (lv_parameters_5_0= RULE_STRING ) ) )? )? )
            {
            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:1233:1: (otherlv_0= 'Provider Class:' ( (lv_classDescriptor_1_0= ruleClassDescriptorMdsl ) ) (otherlv_2= 'parameters:' ( (lv_parameters_3_0= RULE_STRING ) ) (otherlv_4= ',' ( (lv_parameters_5_0= RULE_STRING ) ) )? )? )
            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:1233:3: otherlv_0= 'Provider Class:' ( (lv_classDescriptor_1_0= ruleClassDescriptorMdsl ) ) (otherlv_2= 'parameters:' ( (lv_parameters_3_0= RULE_STRING ) ) (otherlv_4= ',' ( (lv_parameters_5_0= RULE_STRING ) ) )? )?
            {
            otherlv_0=(Token)match(input,33,FOLLOW_33_in_ruleCustomModelProviderMdsl2709); 

                	newLeafNode(otherlv_0, grammarAccess.getCustomModelProviderMdslAccess().getProviderClassKeyword_0());
                
            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:1237:1: ( (lv_classDescriptor_1_0= ruleClassDescriptorMdsl ) )
            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:1238:1: (lv_classDescriptor_1_0= ruleClassDescriptorMdsl )
            {
            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:1238:1: (lv_classDescriptor_1_0= ruleClassDescriptorMdsl )
            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:1239:3: lv_classDescriptor_1_0= ruleClassDescriptorMdsl
            {
             
            	        newCompositeNode(grammarAccess.getCustomModelProviderMdslAccess().getClassDescriptorClassDescriptorMdslParserRuleCall_1_0()); 
            	    
            pushFollow(FOLLOW_ruleClassDescriptorMdsl_in_ruleCustomModelProviderMdsl2730);
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

            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:1255:2: (otherlv_2= 'parameters:' ( (lv_parameters_3_0= RULE_STRING ) ) (otherlv_4= ',' ( (lv_parameters_5_0= RULE_STRING ) ) )? )?
            int alt20=2;
            int LA20_0 = input.LA(1);

            if ( (LA20_0==34) ) {
                alt20=1;
            }
            switch (alt20) {
                case 1 :
                    // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:1255:4: otherlv_2= 'parameters:' ( (lv_parameters_3_0= RULE_STRING ) ) (otherlv_4= ',' ( (lv_parameters_5_0= RULE_STRING ) ) )?
                    {
                    otherlv_2=(Token)match(input,34,FOLLOW_34_in_ruleCustomModelProviderMdsl2743); 

                        	newLeafNode(otherlv_2, grammarAccess.getCustomModelProviderMdslAccess().getParametersKeyword_2_0());
                        
                    // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:1259:1: ( (lv_parameters_3_0= RULE_STRING ) )
                    // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:1260:1: (lv_parameters_3_0= RULE_STRING )
                    {
                    // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:1260:1: (lv_parameters_3_0= RULE_STRING )
                    // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:1261:3: lv_parameters_3_0= RULE_STRING
                    {
                    lv_parameters_3_0=(Token)match(input,RULE_STRING,FOLLOW_RULE_STRING_in_ruleCustomModelProviderMdsl2760); 

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

                    // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:1277:2: (otherlv_4= ',' ( (lv_parameters_5_0= RULE_STRING ) ) )?
                    int alt19=2;
                    int LA19_0 = input.LA(1);

                    if ( (LA19_0==35) ) {
                        alt19=1;
                    }
                    switch (alt19) {
                        case 1 :
                            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:1277:4: otherlv_4= ',' ( (lv_parameters_5_0= RULE_STRING ) )
                            {
                            otherlv_4=(Token)match(input,35,FOLLOW_35_in_ruleCustomModelProviderMdsl2778); 

                                	newLeafNode(otherlv_4, grammarAccess.getCustomModelProviderMdslAccess().getCommaKeyword_2_2_0());
                                
                            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:1281:1: ( (lv_parameters_5_0= RULE_STRING ) )
                            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:1282:1: (lv_parameters_5_0= RULE_STRING )
                            {
                            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:1282:1: (lv_parameters_5_0= RULE_STRING )
                            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:1283:3: lv_parameters_5_0= RULE_STRING
                            {
                            lv_parameters_5_0=(Token)match(input,RULE_STRING,FOLLOW_RULE_STRING_in_ruleCustomModelProviderMdsl2795); 

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
    // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:1307:1: entryRuleXtextLanguageDescriptorMdsl returns [EObject current=null] : iv_ruleXtextLanguageDescriptorMdsl= ruleXtextLanguageDescriptorMdsl EOF ;
    public final EObject entryRuleXtextLanguageDescriptorMdsl() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleXtextLanguageDescriptorMdsl = null;


        try {
            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:1308:2: (iv_ruleXtextLanguageDescriptorMdsl= ruleXtextLanguageDescriptorMdsl EOF )
            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:1309:2: iv_ruleXtextLanguageDescriptorMdsl= ruleXtextLanguageDescriptorMdsl EOF
            {
             newCompositeNode(grammarAccess.getXtextLanguageDescriptorMdslRule()); 
            pushFollow(FOLLOW_ruleXtextLanguageDescriptorMdsl_in_entryRuleXtextLanguageDescriptorMdsl2840);
            iv_ruleXtextLanguageDescriptorMdsl=ruleXtextLanguageDescriptorMdsl();

            state._fsp--;

             current =iv_ruleXtextLanguageDescriptorMdsl; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleXtextLanguageDescriptorMdsl2850); 

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
    // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:1316:1: ruleXtextLanguageDescriptorMdsl returns [EObject current=null] : (otherlv_0= 'Xtext DSL:' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= 'language Id:' ( (lv_languageId_3_0= RULE_ID ) ) otherlv_4= 'from bundle:' ( (lv_bundleId_5_0= RULE_ID ) ) otherlv_6= 'with activator:' ( (lv_activatorClassName_7_0= RULE_ID ) ) ) ;
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
            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:1319:28: ( (otherlv_0= 'Xtext DSL:' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= 'language Id:' ( (lv_languageId_3_0= RULE_ID ) ) otherlv_4= 'from bundle:' ( (lv_bundleId_5_0= RULE_ID ) ) otherlv_6= 'with activator:' ( (lv_activatorClassName_7_0= RULE_ID ) ) ) )
            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:1320:1: (otherlv_0= 'Xtext DSL:' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= 'language Id:' ( (lv_languageId_3_0= RULE_ID ) ) otherlv_4= 'from bundle:' ( (lv_bundleId_5_0= RULE_ID ) ) otherlv_6= 'with activator:' ( (lv_activatorClassName_7_0= RULE_ID ) ) )
            {
            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:1320:1: (otherlv_0= 'Xtext DSL:' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= 'language Id:' ( (lv_languageId_3_0= RULE_ID ) ) otherlv_4= 'from bundle:' ( (lv_bundleId_5_0= RULE_ID ) ) otherlv_6= 'with activator:' ( (lv_activatorClassName_7_0= RULE_ID ) ) )
            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:1320:3: otherlv_0= 'Xtext DSL:' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= 'language Id:' ( (lv_languageId_3_0= RULE_ID ) ) otherlv_4= 'from bundle:' ( (lv_bundleId_5_0= RULE_ID ) ) otherlv_6= 'with activator:' ( (lv_activatorClassName_7_0= RULE_ID ) )
            {
            otherlv_0=(Token)match(input,36,FOLLOW_36_in_ruleXtextLanguageDescriptorMdsl2887); 

                	newLeafNode(otherlv_0, grammarAccess.getXtextLanguageDescriptorMdslAccess().getXtextDSLKeyword_0());
                
            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:1324:1: ( (lv_name_1_0= RULE_ID ) )
            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:1325:1: (lv_name_1_0= RULE_ID )
            {
            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:1325:1: (lv_name_1_0= RULE_ID )
            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:1326:3: lv_name_1_0= RULE_ID
            {
            lv_name_1_0=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleXtextLanguageDescriptorMdsl2904); 

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

            otherlv_2=(Token)match(input,37,FOLLOW_37_in_ruleXtextLanguageDescriptorMdsl2921); 

                	newLeafNode(otherlv_2, grammarAccess.getXtextLanguageDescriptorMdslAccess().getLanguageIdKeyword_2());
                
            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:1346:1: ( (lv_languageId_3_0= RULE_ID ) )
            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:1347:1: (lv_languageId_3_0= RULE_ID )
            {
            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:1347:1: (lv_languageId_3_0= RULE_ID )
            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:1348:3: lv_languageId_3_0= RULE_ID
            {
            lv_languageId_3_0=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleXtextLanguageDescriptorMdsl2938); 

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

            otherlv_4=(Token)match(input,38,FOLLOW_38_in_ruleXtextLanguageDescriptorMdsl2955); 

                	newLeafNode(otherlv_4, grammarAccess.getXtextLanguageDescriptorMdslAccess().getFromBundleKeyword_4());
                
            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:1368:1: ( (lv_bundleId_5_0= RULE_ID ) )
            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:1369:1: (lv_bundleId_5_0= RULE_ID )
            {
            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:1369:1: (lv_bundleId_5_0= RULE_ID )
            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:1370:3: lv_bundleId_5_0= RULE_ID
            {
            lv_bundleId_5_0=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleXtextLanguageDescriptorMdsl2972); 

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

            otherlv_6=(Token)match(input,39,FOLLOW_39_in_ruleXtextLanguageDescriptorMdsl2989); 

                	newLeafNode(otherlv_6, grammarAccess.getXtextLanguageDescriptorMdslAccess().getWithActivatorKeyword_6());
                
            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:1390:1: ( (lv_activatorClassName_7_0= RULE_ID ) )
            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:1391:1: (lv_activatorClassName_7_0= RULE_ID )
            {
            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:1391:1: (lv_activatorClassName_7_0= RULE_ID )
            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:1392:3: lv_activatorClassName_7_0= RULE_ID
            {
            lv_activatorClassName_7_0=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleXtextLanguageDescriptorMdsl3006); 

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
    // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:1416:1: entryRuleXtextLanguageReference returns [EObject current=null] : iv_ruleXtextLanguageReference= ruleXtextLanguageReference EOF ;
    public final EObject entryRuleXtextLanguageReference() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleXtextLanguageReference = null;


        try {
            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:1417:2: (iv_ruleXtextLanguageReference= ruleXtextLanguageReference EOF )
            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:1418:2: iv_ruleXtextLanguageReference= ruleXtextLanguageReference EOF
            {
             newCompositeNode(grammarAccess.getXtextLanguageReferenceRule()); 
            pushFollow(FOLLOW_ruleXtextLanguageReference_in_entryRuleXtextLanguageReference3047);
            iv_ruleXtextLanguageReference=ruleXtextLanguageReference();

            state._fsp--;

             current =iv_ruleXtextLanguageReference; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleXtextLanguageReference3057); 

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
    // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:1425:1: ruleXtextLanguageReference returns [EObject current=null] : (otherlv_0= 'DSL:' ( (otherlv_1= RULE_ID ) ) ) ;
    public final EObject ruleXtextLanguageReference() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;

         enterRule(); 
            
        try {
            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:1428:28: ( (otherlv_0= 'DSL:' ( (otherlv_1= RULE_ID ) ) ) )
            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:1429:1: (otherlv_0= 'DSL:' ( (otherlv_1= RULE_ID ) ) )
            {
            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:1429:1: (otherlv_0= 'DSL:' ( (otherlv_1= RULE_ID ) ) )
            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:1429:3: otherlv_0= 'DSL:' ( (otherlv_1= RULE_ID ) )
            {
            otherlv_0=(Token)match(input,40,FOLLOW_40_in_ruleXtextLanguageReference3094); 

                	newLeafNode(otherlv_0, grammarAccess.getXtextLanguageReferenceAccess().getDSLKeyword_0());
                
            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:1433:1: ( (otherlv_1= RULE_ID ) )
            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:1434:1: (otherlv_1= RULE_ID )
            {
            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:1434:1: (otherlv_1= RULE_ID )
            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:1435:3: otherlv_1= RULE_ID
            {

            			if (current==null) {
            	            current = createModelElement(grammarAccess.getXtextLanguageReferenceRule());
            	        }
                    
            otherlv_1=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleXtextLanguageReference3114); 

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


    // $ANTLR start "entryRuleOCLCustomLibraryMdsl"
    // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:1454:1: entryRuleOCLCustomLibraryMdsl returns [EObject current=null] : iv_ruleOCLCustomLibraryMdsl= ruleOCLCustomLibraryMdsl EOF ;
    public final EObject entryRuleOCLCustomLibraryMdsl() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleOCLCustomLibraryMdsl = null;


        try {
            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:1455:2: (iv_ruleOCLCustomLibraryMdsl= ruleOCLCustomLibraryMdsl EOF )
            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:1456:2: iv_ruleOCLCustomLibraryMdsl= ruleOCLCustomLibraryMdsl EOF
            {
             newCompositeNode(grammarAccess.getOCLCustomLibraryMdslRule()); 
            pushFollow(FOLLOW_ruleOCLCustomLibraryMdsl_in_entryRuleOCLCustomLibraryMdsl3150);
            iv_ruleOCLCustomLibraryMdsl=ruleOCLCustomLibraryMdsl();

            state._fsp--;

             current =iv_ruleOCLCustomLibraryMdsl; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleOCLCustomLibraryMdsl3160); 

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
    // $ANTLR end "entryRuleOCLCustomLibraryMdsl"


    // $ANTLR start "ruleOCLCustomLibraryMdsl"
    // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:1463:1: ruleOCLCustomLibraryMdsl returns [EObject current=null] : (otherlv_0= 'Custom OCL Library' otherlv_1= '{' otherlv_2= 'label:' ( (lv_label_3_0= RULE_STRING ) ) otherlv_4= 'Class:' ( (lv_classDescriptor_5_0= ruleClassDescriptorMdsl ) ) (otherlv_6= 'description:' ( (lv_description_7_0= RULE_STRING ) ) )? otherlv_8= '}' ) ;
    public final EObject ruleOCLCustomLibraryMdsl() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;
        Token otherlv_2=null;
        Token lv_label_3_0=null;
        Token otherlv_4=null;
        Token otherlv_6=null;
        Token lv_description_7_0=null;
        Token otherlv_8=null;
        EObject lv_classDescriptor_5_0 = null;


         enterRule(); 
            
        try {
            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:1466:28: ( (otherlv_0= 'Custom OCL Library' otherlv_1= '{' otherlv_2= 'label:' ( (lv_label_3_0= RULE_STRING ) ) otherlv_4= 'Class:' ( (lv_classDescriptor_5_0= ruleClassDescriptorMdsl ) ) (otherlv_6= 'description:' ( (lv_description_7_0= RULE_STRING ) ) )? otherlv_8= '}' ) )
            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:1467:1: (otherlv_0= 'Custom OCL Library' otherlv_1= '{' otherlv_2= 'label:' ( (lv_label_3_0= RULE_STRING ) ) otherlv_4= 'Class:' ( (lv_classDescriptor_5_0= ruleClassDescriptorMdsl ) ) (otherlv_6= 'description:' ( (lv_description_7_0= RULE_STRING ) ) )? otherlv_8= '}' )
            {
            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:1467:1: (otherlv_0= 'Custom OCL Library' otherlv_1= '{' otherlv_2= 'label:' ( (lv_label_3_0= RULE_STRING ) ) otherlv_4= 'Class:' ( (lv_classDescriptor_5_0= ruleClassDescriptorMdsl ) ) (otherlv_6= 'description:' ( (lv_description_7_0= RULE_STRING ) ) )? otherlv_8= '}' )
            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:1467:3: otherlv_0= 'Custom OCL Library' otherlv_1= '{' otherlv_2= 'label:' ( (lv_label_3_0= RULE_STRING ) ) otherlv_4= 'Class:' ( (lv_classDescriptor_5_0= ruleClassDescriptorMdsl ) ) (otherlv_6= 'description:' ( (lv_description_7_0= RULE_STRING ) ) )? otherlv_8= '}'
            {
            otherlv_0=(Token)match(input,41,FOLLOW_41_in_ruleOCLCustomLibraryMdsl3197); 

                	newLeafNode(otherlv_0, grammarAccess.getOCLCustomLibraryMdslAccess().getCustomOCLLibraryKeyword_0());
                
            otherlv_1=(Token)match(input,22,FOLLOW_22_in_ruleOCLCustomLibraryMdsl3209); 

                	newLeafNode(otherlv_1, grammarAccess.getOCLCustomLibraryMdslAccess().getLeftCurlyBracketKeyword_1());
                
            otherlv_2=(Token)match(input,13,FOLLOW_13_in_ruleOCLCustomLibraryMdsl3221); 

                	newLeafNode(otherlv_2, grammarAccess.getOCLCustomLibraryMdslAccess().getLabelKeyword_2());
                
            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:1479:1: ( (lv_label_3_0= RULE_STRING ) )
            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:1480:1: (lv_label_3_0= RULE_STRING )
            {
            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:1480:1: (lv_label_3_0= RULE_STRING )
            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:1481:3: lv_label_3_0= RULE_STRING
            {
            lv_label_3_0=(Token)match(input,RULE_STRING,FOLLOW_RULE_STRING_in_ruleOCLCustomLibraryMdsl3238); 

            			newLeafNode(lv_label_3_0, grammarAccess.getOCLCustomLibraryMdslAccess().getLabelSTRINGTerminalRuleCall_3_0()); 
            		

            	        if (current==null) {
            	            current = createModelElement(grammarAccess.getOCLCustomLibraryMdslRule());
            	        }
                   		setWithLastConsumed(
                   			current, 
                   			"label",
                    		lv_label_3_0, 
                    		"STRING");
            	    

            }


            }

            otherlv_4=(Token)match(input,42,FOLLOW_42_in_ruleOCLCustomLibraryMdsl3255); 

                	newLeafNode(otherlv_4, grammarAccess.getOCLCustomLibraryMdslAccess().getClassKeyword_4());
                
            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:1501:1: ( (lv_classDescriptor_5_0= ruleClassDescriptorMdsl ) )
            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:1502:1: (lv_classDescriptor_5_0= ruleClassDescriptorMdsl )
            {
            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:1502:1: (lv_classDescriptor_5_0= ruleClassDescriptorMdsl )
            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:1503:3: lv_classDescriptor_5_0= ruleClassDescriptorMdsl
            {
             
            	        newCompositeNode(grammarAccess.getOCLCustomLibraryMdslAccess().getClassDescriptorClassDescriptorMdslParserRuleCall_5_0()); 
            	    
            pushFollow(FOLLOW_ruleClassDescriptorMdsl_in_ruleOCLCustomLibraryMdsl3276);
            lv_classDescriptor_5_0=ruleClassDescriptorMdsl();

            state._fsp--;


            	        if (current==null) {
            	            current = createModelElementForParent(grammarAccess.getOCLCustomLibraryMdslRule());
            	        }
                   		set(
                   			current, 
                   			"classDescriptor",
                    		lv_classDescriptor_5_0, 
                    		"ClassDescriptorMdsl");
            	        afterParserOrEnumRuleCall();
            	    

            }


            }

            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:1519:2: (otherlv_6= 'description:' ( (lv_description_7_0= RULE_STRING ) ) )?
            int alt21=2;
            int LA21_0 = input.LA(1);

            if ( (LA21_0==17) ) {
                alt21=1;
            }
            switch (alt21) {
                case 1 :
                    // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:1519:4: otherlv_6= 'description:' ( (lv_description_7_0= RULE_STRING ) )
                    {
                    otherlv_6=(Token)match(input,17,FOLLOW_17_in_ruleOCLCustomLibraryMdsl3289); 

                        	newLeafNode(otherlv_6, grammarAccess.getOCLCustomLibraryMdslAccess().getDescriptionKeyword_6_0());
                        
                    // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:1523:1: ( (lv_description_7_0= RULE_STRING ) )
                    // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:1524:1: (lv_description_7_0= RULE_STRING )
                    {
                    // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:1524:1: (lv_description_7_0= RULE_STRING )
                    // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:1525:3: lv_description_7_0= RULE_STRING
                    {
                    lv_description_7_0=(Token)match(input,RULE_STRING,FOLLOW_RULE_STRING_in_ruleOCLCustomLibraryMdsl3306); 

                    			newLeafNode(lv_description_7_0, grammarAccess.getOCLCustomLibraryMdslAccess().getDescriptionSTRINGTerminalRuleCall_6_1_0()); 
                    		

                    	        if (current==null) {
                    	            current = createModelElement(grammarAccess.getOCLCustomLibraryMdslRule());
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

            otherlv_8=(Token)match(input,30,FOLLOW_30_in_ruleOCLCustomLibraryMdsl3325); 

                	newLeafNode(otherlv_8, grammarAccess.getOCLCustomLibraryMdslAccess().getRightCurlyBracketKeyword_7());
                

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
    // $ANTLR end "ruleOCLCustomLibraryMdsl"


    // $ANTLR start "entryRuleQueryEvaluatorMdsl"
    // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:1553:1: entryRuleQueryEvaluatorMdsl returns [EObject current=null] : iv_ruleQueryEvaluatorMdsl= ruleQueryEvaluatorMdsl EOF ;
    public final EObject entryRuleQueryEvaluatorMdsl() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleQueryEvaluatorMdsl = null;


        try {
            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:1554:2: (iv_ruleQueryEvaluatorMdsl= ruleQueryEvaluatorMdsl EOF )
            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:1555:2: iv_ruleQueryEvaluatorMdsl= ruleQueryEvaluatorMdsl EOF
            {
             newCompositeNode(grammarAccess.getQueryEvaluatorMdslRule()); 
            pushFollow(FOLLOW_ruleQueryEvaluatorMdsl_in_entryRuleQueryEvaluatorMdsl3361);
            iv_ruleQueryEvaluatorMdsl=ruleQueryEvaluatorMdsl();

            state._fsp--;

             current =iv_ruleQueryEvaluatorMdsl; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleQueryEvaluatorMdsl3371); 

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
    // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:1562:1: ruleQueryEvaluatorMdsl returns [EObject current=null] : (otherlv_0= 'Query Evaluator' otherlv_1= '{' otherlv_2= 'language id:' ( (lv_name_3_0= RULE_ID ) ) otherlv_4= 'label:' ( (lv_label_5_0= RULE_STRING ) ) otherlv_6= 'Evaluator' otherlv_7= 'Class:' ( (lv_classDescriptor_8_0= ruleClassDescriptorMdsl ) ) (otherlv_9= 'query Properties type:' ( (lv_queryPropertiesTypes_10_0= rulePropertyTypeMdsl ) ) (otherlv_11= ',' ( (lv_queryPropertiesTypes_12_0= rulePropertyTypeMdsl ) ) )* )? (otherlv_13= 'external query provider:' ( (lv_extQServiceClassDescriptor_14_0= ruleClassDescriptorMdsl ) ) )? (otherlv_15= 'description:' ( (lv_description_16_0= RULE_STRING ) ) )? otherlv_17= '}' ) ;
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
            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:1565:28: ( (otherlv_0= 'Query Evaluator' otherlv_1= '{' otherlv_2= 'language id:' ( (lv_name_3_0= RULE_ID ) ) otherlv_4= 'label:' ( (lv_label_5_0= RULE_STRING ) ) otherlv_6= 'Evaluator' otherlv_7= 'Class:' ( (lv_classDescriptor_8_0= ruleClassDescriptorMdsl ) ) (otherlv_9= 'query Properties type:' ( (lv_queryPropertiesTypes_10_0= rulePropertyTypeMdsl ) ) (otherlv_11= ',' ( (lv_queryPropertiesTypes_12_0= rulePropertyTypeMdsl ) ) )* )? (otherlv_13= 'external query provider:' ( (lv_extQServiceClassDescriptor_14_0= ruleClassDescriptorMdsl ) ) )? (otherlv_15= 'description:' ( (lv_description_16_0= RULE_STRING ) ) )? otherlv_17= '}' ) )
            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:1566:1: (otherlv_0= 'Query Evaluator' otherlv_1= '{' otherlv_2= 'language id:' ( (lv_name_3_0= RULE_ID ) ) otherlv_4= 'label:' ( (lv_label_5_0= RULE_STRING ) ) otherlv_6= 'Evaluator' otherlv_7= 'Class:' ( (lv_classDescriptor_8_0= ruleClassDescriptorMdsl ) ) (otherlv_9= 'query Properties type:' ( (lv_queryPropertiesTypes_10_0= rulePropertyTypeMdsl ) ) (otherlv_11= ',' ( (lv_queryPropertiesTypes_12_0= rulePropertyTypeMdsl ) ) )* )? (otherlv_13= 'external query provider:' ( (lv_extQServiceClassDescriptor_14_0= ruleClassDescriptorMdsl ) ) )? (otherlv_15= 'description:' ( (lv_description_16_0= RULE_STRING ) ) )? otherlv_17= '}' )
            {
            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:1566:1: (otherlv_0= 'Query Evaluator' otherlv_1= '{' otherlv_2= 'language id:' ( (lv_name_3_0= RULE_ID ) ) otherlv_4= 'label:' ( (lv_label_5_0= RULE_STRING ) ) otherlv_6= 'Evaluator' otherlv_7= 'Class:' ( (lv_classDescriptor_8_0= ruleClassDescriptorMdsl ) ) (otherlv_9= 'query Properties type:' ( (lv_queryPropertiesTypes_10_0= rulePropertyTypeMdsl ) ) (otherlv_11= ',' ( (lv_queryPropertiesTypes_12_0= rulePropertyTypeMdsl ) ) )* )? (otherlv_13= 'external query provider:' ( (lv_extQServiceClassDescriptor_14_0= ruleClassDescriptorMdsl ) ) )? (otherlv_15= 'description:' ( (lv_description_16_0= RULE_STRING ) ) )? otherlv_17= '}' )
            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:1566:3: otherlv_0= 'Query Evaluator' otherlv_1= '{' otherlv_2= 'language id:' ( (lv_name_3_0= RULE_ID ) ) otherlv_4= 'label:' ( (lv_label_5_0= RULE_STRING ) ) otherlv_6= 'Evaluator' otherlv_7= 'Class:' ( (lv_classDescriptor_8_0= ruleClassDescriptorMdsl ) ) (otherlv_9= 'query Properties type:' ( (lv_queryPropertiesTypes_10_0= rulePropertyTypeMdsl ) ) (otherlv_11= ',' ( (lv_queryPropertiesTypes_12_0= rulePropertyTypeMdsl ) ) )* )? (otherlv_13= 'external query provider:' ( (lv_extQServiceClassDescriptor_14_0= ruleClassDescriptorMdsl ) ) )? (otherlv_15= 'description:' ( (lv_description_16_0= RULE_STRING ) ) )? otherlv_17= '}'
            {
            otherlv_0=(Token)match(input,43,FOLLOW_43_in_ruleQueryEvaluatorMdsl3408); 

                	newLeafNode(otherlv_0, grammarAccess.getQueryEvaluatorMdslAccess().getQueryEvaluatorKeyword_0());
                
            otherlv_1=(Token)match(input,22,FOLLOW_22_in_ruleQueryEvaluatorMdsl3420); 

                	newLeafNode(otherlv_1, grammarAccess.getQueryEvaluatorMdslAccess().getLeftCurlyBracketKeyword_1());
                
            otherlv_2=(Token)match(input,44,FOLLOW_44_in_ruleQueryEvaluatorMdsl3432); 

                	newLeafNode(otherlv_2, grammarAccess.getQueryEvaluatorMdslAccess().getLanguageIdKeyword_2());
                
            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:1578:1: ( (lv_name_3_0= RULE_ID ) )
            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:1579:1: (lv_name_3_0= RULE_ID )
            {
            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:1579:1: (lv_name_3_0= RULE_ID )
            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:1580:3: lv_name_3_0= RULE_ID
            {
            lv_name_3_0=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleQueryEvaluatorMdsl3449); 

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

            otherlv_4=(Token)match(input,13,FOLLOW_13_in_ruleQueryEvaluatorMdsl3466); 

                	newLeafNode(otherlv_4, grammarAccess.getQueryEvaluatorMdslAccess().getLabelKeyword_4());
                
            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:1600:1: ( (lv_label_5_0= RULE_STRING ) )
            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:1601:1: (lv_label_5_0= RULE_STRING )
            {
            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:1601:1: (lv_label_5_0= RULE_STRING )
            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:1602:3: lv_label_5_0= RULE_STRING
            {
            lv_label_5_0=(Token)match(input,RULE_STRING,FOLLOW_RULE_STRING_in_ruleQueryEvaluatorMdsl3483); 

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

            otherlv_6=(Token)match(input,45,FOLLOW_45_in_ruleQueryEvaluatorMdsl3500); 

                	newLeafNode(otherlv_6, grammarAccess.getQueryEvaluatorMdslAccess().getEvaluatorKeyword_6());
                
            otherlv_7=(Token)match(input,42,FOLLOW_42_in_ruleQueryEvaluatorMdsl3512); 

                	newLeafNode(otherlv_7, grammarAccess.getQueryEvaluatorMdslAccess().getClassKeyword_7());
                
            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:1626:1: ( (lv_classDescriptor_8_0= ruleClassDescriptorMdsl ) )
            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:1627:1: (lv_classDescriptor_8_0= ruleClassDescriptorMdsl )
            {
            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:1627:1: (lv_classDescriptor_8_0= ruleClassDescriptorMdsl )
            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:1628:3: lv_classDescriptor_8_0= ruleClassDescriptorMdsl
            {
             
            	        newCompositeNode(grammarAccess.getQueryEvaluatorMdslAccess().getClassDescriptorClassDescriptorMdslParserRuleCall_8_0()); 
            	    
            pushFollow(FOLLOW_ruleClassDescriptorMdsl_in_ruleQueryEvaluatorMdsl3533);
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

            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:1644:2: (otherlv_9= 'query Properties type:' ( (lv_queryPropertiesTypes_10_0= rulePropertyTypeMdsl ) ) (otherlv_11= ',' ( (lv_queryPropertiesTypes_12_0= rulePropertyTypeMdsl ) ) )* )?
            int alt23=2;
            int LA23_0 = input.LA(1);

            if ( (LA23_0==46) ) {
                alt23=1;
            }
            switch (alt23) {
                case 1 :
                    // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:1644:4: otherlv_9= 'query Properties type:' ( (lv_queryPropertiesTypes_10_0= rulePropertyTypeMdsl ) ) (otherlv_11= ',' ( (lv_queryPropertiesTypes_12_0= rulePropertyTypeMdsl ) ) )*
                    {
                    otherlv_9=(Token)match(input,46,FOLLOW_46_in_ruleQueryEvaluatorMdsl3546); 

                        	newLeafNode(otherlv_9, grammarAccess.getQueryEvaluatorMdslAccess().getQueryPropertiesTypeKeyword_9_0());
                        
                    // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:1648:1: ( (lv_queryPropertiesTypes_10_0= rulePropertyTypeMdsl ) )
                    // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:1649:1: (lv_queryPropertiesTypes_10_0= rulePropertyTypeMdsl )
                    {
                    // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:1649:1: (lv_queryPropertiesTypes_10_0= rulePropertyTypeMdsl )
                    // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:1650:3: lv_queryPropertiesTypes_10_0= rulePropertyTypeMdsl
                    {
                     
                    	        newCompositeNode(grammarAccess.getQueryEvaluatorMdslAccess().getQueryPropertiesTypesPropertyTypeMdslParserRuleCall_9_1_0()); 
                    	    
                    pushFollow(FOLLOW_rulePropertyTypeMdsl_in_ruleQueryEvaluatorMdsl3567);
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

                    // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:1666:2: (otherlv_11= ',' ( (lv_queryPropertiesTypes_12_0= rulePropertyTypeMdsl ) ) )*
                    loop22:
                    do {
                        int alt22=2;
                        int LA22_0 = input.LA(1);

                        if ( (LA22_0==35) ) {
                            alt22=1;
                        }


                        switch (alt22) {
                    	case 1 :
                    	    // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:1666:4: otherlv_11= ',' ( (lv_queryPropertiesTypes_12_0= rulePropertyTypeMdsl ) )
                    	    {
                    	    otherlv_11=(Token)match(input,35,FOLLOW_35_in_ruleQueryEvaluatorMdsl3580); 

                    	        	newLeafNode(otherlv_11, grammarAccess.getQueryEvaluatorMdslAccess().getCommaKeyword_9_2_0());
                    	        
                    	    // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:1670:1: ( (lv_queryPropertiesTypes_12_0= rulePropertyTypeMdsl ) )
                    	    // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:1671:1: (lv_queryPropertiesTypes_12_0= rulePropertyTypeMdsl )
                    	    {
                    	    // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:1671:1: (lv_queryPropertiesTypes_12_0= rulePropertyTypeMdsl )
                    	    // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:1672:3: lv_queryPropertiesTypes_12_0= rulePropertyTypeMdsl
                    	    {
                    	     
                    	    	        newCompositeNode(grammarAccess.getQueryEvaluatorMdslAccess().getQueryPropertiesTypesPropertyTypeMdslParserRuleCall_9_2_1_0()); 
                    	    	    
                    	    pushFollow(FOLLOW_rulePropertyTypeMdsl_in_ruleQueryEvaluatorMdsl3601);
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
                    	    break loop22;
                        }
                    } while (true);


                    }
                    break;

            }

            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:1688:6: (otherlv_13= 'external query provider:' ( (lv_extQServiceClassDescriptor_14_0= ruleClassDescriptorMdsl ) ) )?
            int alt24=2;
            int LA24_0 = input.LA(1);

            if ( (LA24_0==47) ) {
                alt24=1;
            }
            switch (alt24) {
                case 1 :
                    // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:1688:8: otherlv_13= 'external query provider:' ( (lv_extQServiceClassDescriptor_14_0= ruleClassDescriptorMdsl ) )
                    {
                    otherlv_13=(Token)match(input,47,FOLLOW_47_in_ruleQueryEvaluatorMdsl3618); 

                        	newLeafNode(otherlv_13, grammarAccess.getQueryEvaluatorMdslAccess().getExternalQueryProviderKeyword_10_0());
                        
                    // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:1692:1: ( (lv_extQServiceClassDescriptor_14_0= ruleClassDescriptorMdsl ) )
                    // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:1693:1: (lv_extQServiceClassDescriptor_14_0= ruleClassDescriptorMdsl )
                    {
                    // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:1693:1: (lv_extQServiceClassDescriptor_14_0= ruleClassDescriptorMdsl )
                    // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:1694:3: lv_extQServiceClassDescriptor_14_0= ruleClassDescriptorMdsl
                    {
                     
                    	        newCompositeNode(grammarAccess.getQueryEvaluatorMdslAccess().getExtQServiceClassDescriptorClassDescriptorMdslParserRuleCall_10_1_0()); 
                    	    
                    pushFollow(FOLLOW_ruleClassDescriptorMdsl_in_ruleQueryEvaluatorMdsl3639);
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

            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:1710:4: (otherlv_15= 'description:' ( (lv_description_16_0= RULE_STRING ) ) )?
            int alt25=2;
            int LA25_0 = input.LA(1);

            if ( (LA25_0==17) ) {
                alt25=1;
            }
            switch (alt25) {
                case 1 :
                    // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:1710:6: otherlv_15= 'description:' ( (lv_description_16_0= RULE_STRING ) )
                    {
                    otherlv_15=(Token)match(input,17,FOLLOW_17_in_ruleQueryEvaluatorMdsl3654); 

                        	newLeafNode(otherlv_15, grammarAccess.getQueryEvaluatorMdslAccess().getDescriptionKeyword_11_0());
                        
                    // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:1714:1: ( (lv_description_16_0= RULE_STRING ) )
                    // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:1715:1: (lv_description_16_0= RULE_STRING )
                    {
                    // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:1715:1: (lv_description_16_0= RULE_STRING )
                    // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:1716:3: lv_description_16_0= RULE_STRING
                    {
                    lv_description_16_0=(Token)match(input,RULE_STRING,FOLLOW_RULE_STRING_in_ruleQueryEvaluatorMdsl3671); 

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

            otherlv_17=(Token)match(input,30,FOLLOW_30_in_ruleQueryEvaluatorMdsl3690); 

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
    // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:1744:1: entryRuleWidgetType returns [EObject current=null] : iv_ruleWidgetType= ruleWidgetType EOF ;
    public final EObject entryRuleWidgetType() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleWidgetType = null;


        try {
            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:1745:2: (iv_ruleWidgetType= ruleWidgetType EOF )
            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:1746:2: iv_ruleWidgetType= ruleWidgetType EOF
            {
             newCompositeNode(grammarAccess.getWidgetTypeRule()); 
            pushFollow(FOLLOW_ruleWidgetType_in_entryRuleWidgetType3726);
            iv_ruleWidgetType=ruleWidgetType();

            state._fsp--;

             current =iv_ruleWidgetType; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleWidgetType3736); 

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
    // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:1753:1: ruleWidgetType returns [EObject current=null] : (otherlv_0= 'Widget type' otherlv_1= '{' otherlv_2= 'name:' ( (lv_name_3_0= RULE_ID ) ) otherlv_4= 'category:' ( (lv_category_5_0= ruleWIDGET_CATEGORY_MDSL ) ) otherlv_6= 'label:' ( (lv_label_7_0= RULE_STRING ) ) otherlv_8= 'custom widget:' ( (lv_classDescriptor_9_0= ruleClassDescriptorMdsl ) ) (otherlv_10= 'description:' ( (lv_description_11_0= RULE_STRING ) ) )? otherlv_12= '}' ) ;
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
            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:1756:28: ( (otherlv_0= 'Widget type' otherlv_1= '{' otherlv_2= 'name:' ( (lv_name_3_0= RULE_ID ) ) otherlv_4= 'category:' ( (lv_category_5_0= ruleWIDGET_CATEGORY_MDSL ) ) otherlv_6= 'label:' ( (lv_label_7_0= RULE_STRING ) ) otherlv_8= 'custom widget:' ( (lv_classDescriptor_9_0= ruleClassDescriptorMdsl ) ) (otherlv_10= 'description:' ( (lv_description_11_0= RULE_STRING ) ) )? otherlv_12= '}' ) )
            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:1757:1: (otherlv_0= 'Widget type' otherlv_1= '{' otherlv_2= 'name:' ( (lv_name_3_0= RULE_ID ) ) otherlv_4= 'category:' ( (lv_category_5_0= ruleWIDGET_CATEGORY_MDSL ) ) otherlv_6= 'label:' ( (lv_label_7_0= RULE_STRING ) ) otherlv_8= 'custom widget:' ( (lv_classDescriptor_9_0= ruleClassDescriptorMdsl ) ) (otherlv_10= 'description:' ( (lv_description_11_0= RULE_STRING ) ) )? otherlv_12= '}' )
            {
            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:1757:1: (otherlv_0= 'Widget type' otherlv_1= '{' otherlv_2= 'name:' ( (lv_name_3_0= RULE_ID ) ) otherlv_4= 'category:' ( (lv_category_5_0= ruleWIDGET_CATEGORY_MDSL ) ) otherlv_6= 'label:' ( (lv_label_7_0= RULE_STRING ) ) otherlv_8= 'custom widget:' ( (lv_classDescriptor_9_0= ruleClassDescriptorMdsl ) ) (otherlv_10= 'description:' ( (lv_description_11_0= RULE_STRING ) ) )? otherlv_12= '}' )
            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:1757:3: otherlv_0= 'Widget type' otherlv_1= '{' otherlv_2= 'name:' ( (lv_name_3_0= RULE_ID ) ) otherlv_4= 'category:' ( (lv_category_5_0= ruleWIDGET_CATEGORY_MDSL ) ) otherlv_6= 'label:' ( (lv_label_7_0= RULE_STRING ) ) otherlv_8= 'custom widget:' ( (lv_classDescriptor_9_0= ruleClassDescriptorMdsl ) ) (otherlv_10= 'description:' ( (lv_description_11_0= RULE_STRING ) ) )? otherlv_12= '}'
            {
            otherlv_0=(Token)match(input,48,FOLLOW_48_in_ruleWidgetType3773); 

                	newLeafNode(otherlv_0, grammarAccess.getWidgetTypeAccess().getWidgetTypeKeyword_0());
                
            otherlv_1=(Token)match(input,22,FOLLOW_22_in_ruleWidgetType3785); 

                	newLeafNode(otherlv_1, grammarAccess.getWidgetTypeAccess().getLeftCurlyBracketKeyword_1());
                
            otherlv_2=(Token)match(input,49,FOLLOW_49_in_ruleWidgetType3797); 

                	newLeafNode(otherlv_2, grammarAccess.getWidgetTypeAccess().getNameKeyword_2());
                
            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:1769:1: ( (lv_name_3_0= RULE_ID ) )
            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:1770:1: (lv_name_3_0= RULE_ID )
            {
            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:1770:1: (lv_name_3_0= RULE_ID )
            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:1771:3: lv_name_3_0= RULE_ID
            {
            lv_name_3_0=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleWidgetType3814); 

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

            otherlv_4=(Token)match(input,50,FOLLOW_50_in_ruleWidgetType3831); 

                	newLeafNode(otherlv_4, grammarAccess.getWidgetTypeAccess().getCategoryKeyword_4());
                
            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:1791:1: ( (lv_category_5_0= ruleWIDGET_CATEGORY_MDSL ) )
            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:1792:1: (lv_category_5_0= ruleWIDGET_CATEGORY_MDSL )
            {
            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:1792:1: (lv_category_5_0= ruleWIDGET_CATEGORY_MDSL )
            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:1793:3: lv_category_5_0= ruleWIDGET_CATEGORY_MDSL
            {
             
            	        newCompositeNode(grammarAccess.getWidgetTypeAccess().getCategoryWIDGET_CATEGORY_MDSLEnumRuleCall_5_0()); 
            	    
            pushFollow(FOLLOW_ruleWIDGET_CATEGORY_MDSL_in_ruleWidgetType3852);
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

            otherlv_6=(Token)match(input,13,FOLLOW_13_in_ruleWidgetType3864); 

                	newLeafNode(otherlv_6, grammarAccess.getWidgetTypeAccess().getLabelKeyword_6());
                
            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:1813:1: ( (lv_label_7_0= RULE_STRING ) )
            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:1814:1: (lv_label_7_0= RULE_STRING )
            {
            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:1814:1: (lv_label_7_0= RULE_STRING )
            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:1815:3: lv_label_7_0= RULE_STRING
            {
            lv_label_7_0=(Token)match(input,RULE_STRING,FOLLOW_RULE_STRING_in_ruleWidgetType3881); 

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

            otherlv_8=(Token)match(input,51,FOLLOW_51_in_ruleWidgetType3898); 

                	newLeafNode(otherlv_8, grammarAccess.getWidgetTypeAccess().getCustomWidgetKeyword_8());
                
            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:1835:1: ( (lv_classDescriptor_9_0= ruleClassDescriptorMdsl ) )
            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:1836:1: (lv_classDescriptor_9_0= ruleClassDescriptorMdsl )
            {
            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:1836:1: (lv_classDescriptor_9_0= ruleClassDescriptorMdsl )
            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:1837:3: lv_classDescriptor_9_0= ruleClassDescriptorMdsl
            {
             
            	        newCompositeNode(grammarAccess.getWidgetTypeAccess().getClassDescriptorClassDescriptorMdslParserRuleCall_9_0()); 
            	    
            pushFollow(FOLLOW_ruleClassDescriptorMdsl_in_ruleWidgetType3919);
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

            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:1853:2: (otherlv_10= 'description:' ( (lv_description_11_0= RULE_STRING ) ) )?
            int alt26=2;
            int LA26_0 = input.LA(1);

            if ( (LA26_0==17) ) {
                alt26=1;
            }
            switch (alt26) {
                case 1 :
                    // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:1853:4: otherlv_10= 'description:' ( (lv_description_11_0= RULE_STRING ) )
                    {
                    otherlv_10=(Token)match(input,17,FOLLOW_17_in_ruleWidgetType3932); 

                        	newLeafNode(otherlv_10, grammarAccess.getWidgetTypeAccess().getDescriptionKeyword_10_0());
                        
                    // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:1857:1: ( (lv_description_11_0= RULE_STRING ) )
                    // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:1858:1: (lv_description_11_0= RULE_STRING )
                    {
                    // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:1858:1: (lv_description_11_0= RULE_STRING )
                    // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:1859:3: lv_description_11_0= RULE_STRING
                    {
                    lv_description_11_0=(Token)match(input,RULE_STRING,FOLLOW_RULE_STRING_in_ruleWidgetType3949); 

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

            otherlv_12=(Token)match(input,30,FOLLOW_30_in_ruleWidgetType3968); 

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
    // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:1887:1: entryRuleUITabMdsl returns [EObject current=null] : iv_ruleUITabMdsl= ruleUITabMdsl EOF ;
    public final EObject entryRuleUITabMdsl() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleUITabMdsl = null;


        try {
            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:1888:2: (iv_ruleUITabMdsl= ruleUITabMdsl EOF )
            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:1889:2: iv_ruleUITabMdsl= ruleUITabMdsl EOF
            {
             newCompositeNode(grammarAccess.getUITabMdslRule()); 
            pushFollow(FOLLOW_ruleUITabMdsl_in_entryRuleUITabMdsl4004);
            iv_ruleUITabMdsl=ruleUITabMdsl();

            state._fsp--;

             current =iv_ruleUITabMdsl; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleUITabMdsl4014); 

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
    // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:1896:1: ruleUITabMdsl returns [EObject current=null] : (otherlv_0= 'UI' otherlv_1= 'Tab' otherlv_2= '{' otherlv_3= 'id:' ( (lv_name_4_0= RULE_ID ) ) ( (lv_i18NLabel_5_0= 'I18N' ) )? otherlv_6= 'label:' ( (lv_labelFormatExpr_7_0= ruleFormatExpr ) ) (otherlv_8= 'description:' ( (lv_description_9_0= RULE_STRING ) ) )? otherlv_10= '}' ) ;
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
            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:1899:28: ( (otherlv_0= 'UI' otherlv_1= 'Tab' otherlv_2= '{' otherlv_3= 'id:' ( (lv_name_4_0= RULE_ID ) ) ( (lv_i18NLabel_5_0= 'I18N' ) )? otherlv_6= 'label:' ( (lv_labelFormatExpr_7_0= ruleFormatExpr ) ) (otherlv_8= 'description:' ( (lv_description_9_0= RULE_STRING ) ) )? otherlv_10= '}' ) )
            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:1900:1: (otherlv_0= 'UI' otherlv_1= 'Tab' otherlv_2= '{' otherlv_3= 'id:' ( (lv_name_4_0= RULE_ID ) ) ( (lv_i18NLabel_5_0= 'I18N' ) )? otherlv_6= 'label:' ( (lv_labelFormatExpr_7_0= ruleFormatExpr ) ) (otherlv_8= 'description:' ( (lv_description_9_0= RULE_STRING ) ) )? otherlv_10= '}' )
            {
            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:1900:1: (otherlv_0= 'UI' otherlv_1= 'Tab' otherlv_2= '{' otherlv_3= 'id:' ( (lv_name_4_0= RULE_ID ) ) ( (lv_i18NLabel_5_0= 'I18N' ) )? otherlv_6= 'label:' ( (lv_labelFormatExpr_7_0= ruleFormatExpr ) ) (otherlv_8= 'description:' ( (lv_description_9_0= RULE_STRING ) ) )? otherlv_10= '}' )
            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:1900:3: otherlv_0= 'UI' otherlv_1= 'Tab' otherlv_2= '{' otherlv_3= 'id:' ( (lv_name_4_0= RULE_ID ) ) ( (lv_i18NLabel_5_0= 'I18N' ) )? otherlv_6= 'label:' ( (lv_labelFormatExpr_7_0= ruleFormatExpr ) ) (otherlv_8= 'description:' ( (lv_description_9_0= RULE_STRING ) ) )? otherlv_10= '}'
            {
            otherlv_0=(Token)match(input,52,FOLLOW_52_in_ruleUITabMdsl4051); 

                	newLeafNode(otherlv_0, grammarAccess.getUITabMdslAccess().getUIKeyword_0());
                
            otherlv_1=(Token)match(input,53,FOLLOW_53_in_ruleUITabMdsl4063); 

                	newLeafNode(otherlv_1, grammarAccess.getUITabMdslAccess().getTabKeyword_1());
                
            otherlv_2=(Token)match(input,22,FOLLOW_22_in_ruleUITabMdsl4075); 

                	newLeafNode(otherlv_2, grammarAccess.getUITabMdslAccess().getLeftCurlyBracketKeyword_2());
                
            otherlv_3=(Token)match(input,54,FOLLOW_54_in_ruleUITabMdsl4087); 

                	newLeafNode(otherlv_3, grammarAccess.getUITabMdslAccess().getIdKeyword_3());
                
            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:1916:1: ( (lv_name_4_0= RULE_ID ) )
            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:1917:1: (lv_name_4_0= RULE_ID )
            {
            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:1917:1: (lv_name_4_0= RULE_ID )
            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:1918:3: lv_name_4_0= RULE_ID
            {
            lv_name_4_0=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleUITabMdsl4104); 

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

            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:1934:2: ( (lv_i18NLabel_5_0= 'I18N' ) )?
            int alt27=2;
            int LA27_0 = input.LA(1);

            if ( (LA27_0==55) ) {
                alt27=1;
            }
            switch (alt27) {
                case 1 :
                    // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:1935:1: (lv_i18NLabel_5_0= 'I18N' )
                    {
                    // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:1935:1: (lv_i18NLabel_5_0= 'I18N' )
                    // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:1936:3: lv_i18NLabel_5_0= 'I18N'
                    {
                    lv_i18NLabel_5_0=(Token)match(input,55,FOLLOW_55_in_ruleUITabMdsl4127); 

                            newLeafNode(lv_i18NLabel_5_0, grammarAccess.getUITabMdslAccess().getI18NLabelI18NKeyword_5_0());
                        

                    	        if (current==null) {
                    	            current = createModelElement(grammarAccess.getUITabMdslRule());
                    	        }
                           		setWithLastConsumed(current, "i18NLabel", true, "I18N");
                    	    

                    }


                    }
                    break;

            }

            otherlv_6=(Token)match(input,13,FOLLOW_13_in_ruleUITabMdsl4153); 

                	newLeafNode(otherlv_6, grammarAccess.getUITabMdslAccess().getLabelKeyword_6());
                
            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:1953:1: ( (lv_labelFormatExpr_7_0= ruleFormatExpr ) )
            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:1954:1: (lv_labelFormatExpr_7_0= ruleFormatExpr )
            {
            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:1954:1: (lv_labelFormatExpr_7_0= ruleFormatExpr )
            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:1955:3: lv_labelFormatExpr_7_0= ruleFormatExpr
            {
             
            	        newCompositeNode(grammarAccess.getUITabMdslAccess().getLabelFormatExprFormatExprParserRuleCall_7_0()); 
            	    
            pushFollow(FOLLOW_ruleFormatExpr_in_ruleUITabMdsl4174);
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

            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:1971:2: (otherlv_8= 'description:' ( (lv_description_9_0= RULE_STRING ) ) )?
            int alt28=2;
            int LA28_0 = input.LA(1);

            if ( (LA28_0==17) ) {
                alt28=1;
            }
            switch (alt28) {
                case 1 :
                    // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:1971:4: otherlv_8= 'description:' ( (lv_description_9_0= RULE_STRING ) )
                    {
                    otherlv_8=(Token)match(input,17,FOLLOW_17_in_ruleUITabMdsl4187); 

                        	newLeafNode(otherlv_8, grammarAccess.getUITabMdslAccess().getDescriptionKeyword_8_0());
                        
                    // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:1975:1: ( (lv_description_9_0= RULE_STRING ) )
                    // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:1976:1: (lv_description_9_0= RULE_STRING )
                    {
                    // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:1976:1: (lv_description_9_0= RULE_STRING )
                    // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:1977:3: lv_description_9_0= RULE_STRING
                    {
                    lv_description_9_0=(Token)match(input,RULE_STRING,FOLLOW_RULE_STRING_in_ruleUITabMdsl4204); 

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

            otherlv_10=(Token)match(input,30,FOLLOW_30_in_ruleUITabMdsl4223); 

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
    // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:2005:1: entryRuleLayerMdsl returns [EObject current=null] : iv_ruleLayerMdsl= ruleLayerMdsl EOF ;
    public final EObject entryRuleLayerMdsl() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleLayerMdsl = null;


        try {
            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:2006:2: (iv_ruleLayerMdsl= ruleLayerMdsl EOF )
            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:2007:2: iv_ruleLayerMdsl= ruleLayerMdsl EOF
            {
             newCompositeNode(grammarAccess.getLayerMdslRule()); 
            pushFollow(FOLLOW_ruleLayerMdsl_in_entryRuleLayerMdsl4259);
            iv_ruleLayerMdsl=ruleLayerMdsl();

            state._fsp--;

             current =iv_ruleLayerMdsl; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleLayerMdsl4269); 

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
    // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:2014:1: ruleLayerMdsl returns [EObject current=null] : (otherlv_0= 'Layer' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' ( (lv_i18NLabel_3_0= 'I18N' ) )? otherlv_4= 'label:' ( (lv_labelFormatExpr_5_0= ruleFormatExpr ) ) (otherlv_6= 'description:' ( (lv_description_7_0= RULE_STRING ) ) )? (otherlv_8= 'Sub' otherlv_9= 'layers' otherlv_10= '{' ( (lv_subLayers_11_0= ruleLayerMdsl ) )* otherlv_12= '}' )? otherlv_13= '}' ) ;
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
            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:2017:28: ( (otherlv_0= 'Layer' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' ( (lv_i18NLabel_3_0= 'I18N' ) )? otherlv_4= 'label:' ( (lv_labelFormatExpr_5_0= ruleFormatExpr ) ) (otherlv_6= 'description:' ( (lv_description_7_0= RULE_STRING ) ) )? (otherlv_8= 'Sub' otherlv_9= 'layers' otherlv_10= '{' ( (lv_subLayers_11_0= ruleLayerMdsl ) )* otherlv_12= '}' )? otherlv_13= '}' ) )
            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:2018:1: (otherlv_0= 'Layer' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' ( (lv_i18NLabel_3_0= 'I18N' ) )? otherlv_4= 'label:' ( (lv_labelFormatExpr_5_0= ruleFormatExpr ) ) (otherlv_6= 'description:' ( (lv_description_7_0= RULE_STRING ) ) )? (otherlv_8= 'Sub' otherlv_9= 'layers' otherlv_10= '{' ( (lv_subLayers_11_0= ruleLayerMdsl ) )* otherlv_12= '}' )? otherlv_13= '}' )
            {
            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:2018:1: (otherlv_0= 'Layer' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' ( (lv_i18NLabel_3_0= 'I18N' ) )? otherlv_4= 'label:' ( (lv_labelFormatExpr_5_0= ruleFormatExpr ) ) (otherlv_6= 'description:' ( (lv_description_7_0= RULE_STRING ) ) )? (otherlv_8= 'Sub' otherlv_9= 'layers' otherlv_10= '{' ( (lv_subLayers_11_0= ruleLayerMdsl ) )* otherlv_12= '}' )? otherlv_13= '}' )
            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:2018:3: otherlv_0= 'Layer' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' ( (lv_i18NLabel_3_0= 'I18N' ) )? otherlv_4= 'label:' ( (lv_labelFormatExpr_5_0= ruleFormatExpr ) ) (otherlv_6= 'description:' ( (lv_description_7_0= RULE_STRING ) ) )? (otherlv_8= 'Sub' otherlv_9= 'layers' otherlv_10= '{' ( (lv_subLayers_11_0= ruleLayerMdsl ) )* otherlv_12= '}' )? otherlv_13= '}'
            {
            otherlv_0=(Token)match(input,56,FOLLOW_56_in_ruleLayerMdsl4306); 

                	newLeafNode(otherlv_0, grammarAccess.getLayerMdslAccess().getLayerKeyword_0());
                
            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:2022:1: ( (lv_name_1_0= RULE_ID ) )
            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:2023:1: (lv_name_1_0= RULE_ID )
            {
            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:2023:1: (lv_name_1_0= RULE_ID )
            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:2024:3: lv_name_1_0= RULE_ID
            {
            lv_name_1_0=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleLayerMdsl4323); 

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

            otherlv_2=(Token)match(input,22,FOLLOW_22_in_ruleLayerMdsl4340); 

                	newLeafNode(otherlv_2, grammarAccess.getLayerMdslAccess().getLeftCurlyBracketKeyword_2());
                
            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:2044:1: ( (lv_i18NLabel_3_0= 'I18N' ) )?
            int alt29=2;
            int LA29_0 = input.LA(1);

            if ( (LA29_0==55) ) {
                alt29=1;
            }
            switch (alt29) {
                case 1 :
                    // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:2045:1: (lv_i18NLabel_3_0= 'I18N' )
                    {
                    // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:2045:1: (lv_i18NLabel_3_0= 'I18N' )
                    // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:2046:3: lv_i18NLabel_3_0= 'I18N'
                    {
                    lv_i18NLabel_3_0=(Token)match(input,55,FOLLOW_55_in_ruleLayerMdsl4358); 

                            newLeafNode(lv_i18NLabel_3_0, grammarAccess.getLayerMdslAccess().getI18NLabelI18NKeyword_3_0());
                        

                    	        if (current==null) {
                    	            current = createModelElement(grammarAccess.getLayerMdslRule());
                    	        }
                           		setWithLastConsumed(current, "i18NLabel", true, "I18N");
                    	    

                    }


                    }
                    break;

            }

            otherlv_4=(Token)match(input,13,FOLLOW_13_in_ruleLayerMdsl4384); 

                	newLeafNode(otherlv_4, grammarAccess.getLayerMdslAccess().getLabelKeyword_4());
                
            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:2063:1: ( (lv_labelFormatExpr_5_0= ruleFormatExpr ) )
            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:2064:1: (lv_labelFormatExpr_5_0= ruleFormatExpr )
            {
            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:2064:1: (lv_labelFormatExpr_5_0= ruleFormatExpr )
            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:2065:3: lv_labelFormatExpr_5_0= ruleFormatExpr
            {
             
            	        newCompositeNode(grammarAccess.getLayerMdslAccess().getLabelFormatExprFormatExprParserRuleCall_5_0()); 
            	    
            pushFollow(FOLLOW_ruleFormatExpr_in_ruleLayerMdsl4405);
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

            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:2081:2: (otherlv_6= 'description:' ( (lv_description_7_0= RULE_STRING ) ) )?
            int alt30=2;
            int LA30_0 = input.LA(1);

            if ( (LA30_0==17) ) {
                alt30=1;
            }
            switch (alt30) {
                case 1 :
                    // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:2081:4: otherlv_6= 'description:' ( (lv_description_7_0= RULE_STRING ) )
                    {
                    otherlv_6=(Token)match(input,17,FOLLOW_17_in_ruleLayerMdsl4418); 

                        	newLeafNode(otherlv_6, grammarAccess.getLayerMdslAccess().getDescriptionKeyword_6_0());
                        
                    // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:2085:1: ( (lv_description_7_0= RULE_STRING ) )
                    // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:2086:1: (lv_description_7_0= RULE_STRING )
                    {
                    // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:2086:1: (lv_description_7_0= RULE_STRING )
                    // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:2087:3: lv_description_7_0= RULE_STRING
                    {
                    lv_description_7_0=(Token)match(input,RULE_STRING,FOLLOW_RULE_STRING_in_ruleLayerMdsl4435); 

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

            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:2103:4: (otherlv_8= 'Sub' otherlv_9= 'layers' otherlv_10= '{' ( (lv_subLayers_11_0= ruleLayerMdsl ) )* otherlv_12= '}' )?
            int alt32=2;
            int LA32_0 = input.LA(1);

            if ( (LA32_0==57) ) {
                alt32=1;
            }
            switch (alt32) {
                case 1 :
                    // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:2103:6: otherlv_8= 'Sub' otherlv_9= 'layers' otherlv_10= '{' ( (lv_subLayers_11_0= ruleLayerMdsl ) )* otherlv_12= '}'
                    {
                    otherlv_8=(Token)match(input,57,FOLLOW_57_in_ruleLayerMdsl4455); 

                        	newLeafNode(otherlv_8, grammarAccess.getLayerMdslAccess().getSubKeyword_7_0());
                        
                    otherlv_9=(Token)match(input,58,FOLLOW_58_in_ruleLayerMdsl4467); 

                        	newLeafNode(otherlv_9, grammarAccess.getLayerMdslAccess().getLayersKeyword_7_1());
                        
                    otherlv_10=(Token)match(input,22,FOLLOW_22_in_ruleLayerMdsl4479); 

                        	newLeafNode(otherlv_10, grammarAccess.getLayerMdslAccess().getLeftCurlyBracketKeyword_7_2());
                        
                    // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:2115:1: ( (lv_subLayers_11_0= ruleLayerMdsl ) )*
                    loop31:
                    do {
                        int alt31=2;
                        int LA31_0 = input.LA(1);

                        if ( (LA31_0==56) ) {
                            alt31=1;
                        }


                        switch (alt31) {
                    	case 1 :
                    	    // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:2116:1: (lv_subLayers_11_0= ruleLayerMdsl )
                    	    {
                    	    // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:2116:1: (lv_subLayers_11_0= ruleLayerMdsl )
                    	    // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:2117:3: lv_subLayers_11_0= ruleLayerMdsl
                    	    {
                    	     
                    	    	        newCompositeNode(grammarAccess.getLayerMdslAccess().getSubLayersLayerMdslParserRuleCall_7_3_0()); 
                    	    	    
                    	    pushFollow(FOLLOW_ruleLayerMdsl_in_ruleLayerMdsl4500);
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
                    	    break loop31;
                        }
                    } while (true);

                    otherlv_12=(Token)match(input,30,FOLLOW_30_in_ruleLayerMdsl4513); 

                        	newLeafNode(otherlv_12, grammarAccess.getLayerMdslAccess().getRightCurlyBracketKeyword_7_4());
                        

                    }
                    break;

            }

            otherlv_13=(Token)match(input,30,FOLLOW_30_in_ruleLayerMdsl4527); 

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
    // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:2149:1: entryRuleTypeConfigurationMdsl returns [EObject current=null] : iv_ruleTypeConfigurationMdsl= ruleTypeConfigurationMdsl EOF ;
    public final EObject entryRuleTypeConfigurationMdsl() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleTypeConfigurationMdsl = null;


        try {
            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:2150:2: (iv_ruleTypeConfigurationMdsl= ruleTypeConfigurationMdsl EOF )
            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:2151:2: iv_ruleTypeConfigurationMdsl= ruleTypeConfigurationMdsl EOF
            {
             newCompositeNode(grammarAccess.getTypeConfigurationMdslRule()); 
            pushFollow(FOLLOW_ruleTypeConfigurationMdsl_in_entryRuleTypeConfigurationMdsl4563);
            iv_ruleTypeConfigurationMdsl=ruleTypeConfigurationMdsl();

            state._fsp--;

             current =iv_ruleTypeConfigurationMdsl; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleTypeConfigurationMdsl4573); 

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
    // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:2158:1: ruleTypeConfigurationMdsl returns [EObject current=null] : ( ( (lv_defaultConfiguration_0_0= 'DEFAULT' ) )? otherlv_1= 'Configuration' ( (lv_name_2_0= RULE_ID ) ) (otherlv_3= 'for' ( (otherlv_4= RULE_ID ) ) )? otherlv_5= '{' ( ( (lv_i18NLabelProvider_6_0= 'I18N' ) )? otherlv_7= 'label provider:' ( (lv_labelProviderExpression_8_0= ruleFormatExpr ) ) )? ( ( (lv_useExplicitExtends_9_0= 'extends:' ) ) ( (otherlv_10= RULE_ID ) ) (otherlv_11= ',' ( (otherlv_12= RULE_ID ) ) )* )? otherlv_13= 'template:' ( (lv_templateElements_14_0= ruleTypeConfigurationTemplateElement ) )* ( ( (lv_layoutDefined_15_0= 'layout:' ) ) ( (otherlv_16= RULE_ID ) )* )? otherlv_17= '}' ) ;
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
            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:2161:28: ( ( ( (lv_defaultConfiguration_0_0= 'DEFAULT' ) )? otherlv_1= 'Configuration' ( (lv_name_2_0= RULE_ID ) ) (otherlv_3= 'for' ( (otherlv_4= RULE_ID ) ) )? otherlv_5= '{' ( ( (lv_i18NLabelProvider_6_0= 'I18N' ) )? otherlv_7= 'label provider:' ( (lv_labelProviderExpression_8_0= ruleFormatExpr ) ) )? ( ( (lv_useExplicitExtends_9_0= 'extends:' ) ) ( (otherlv_10= RULE_ID ) ) (otherlv_11= ',' ( (otherlv_12= RULE_ID ) ) )* )? otherlv_13= 'template:' ( (lv_templateElements_14_0= ruleTypeConfigurationTemplateElement ) )* ( ( (lv_layoutDefined_15_0= 'layout:' ) ) ( (otherlv_16= RULE_ID ) )* )? otherlv_17= '}' ) )
            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:2162:1: ( ( (lv_defaultConfiguration_0_0= 'DEFAULT' ) )? otherlv_1= 'Configuration' ( (lv_name_2_0= RULE_ID ) ) (otherlv_3= 'for' ( (otherlv_4= RULE_ID ) ) )? otherlv_5= '{' ( ( (lv_i18NLabelProvider_6_0= 'I18N' ) )? otherlv_7= 'label provider:' ( (lv_labelProviderExpression_8_0= ruleFormatExpr ) ) )? ( ( (lv_useExplicitExtends_9_0= 'extends:' ) ) ( (otherlv_10= RULE_ID ) ) (otherlv_11= ',' ( (otherlv_12= RULE_ID ) ) )* )? otherlv_13= 'template:' ( (lv_templateElements_14_0= ruleTypeConfigurationTemplateElement ) )* ( ( (lv_layoutDefined_15_0= 'layout:' ) ) ( (otherlv_16= RULE_ID ) )* )? otherlv_17= '}' )
            {
            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:2162:1: ( ( (lv_defaultConfiguration_0_0= 'DEFAULT' ) )? otherlv_1= 'Configuration' ( (lv_name_2_0= RULE_ID ) ) (otherlv_3= 'for' ( (otherlv_4= RULE_ID ) ) )? otherlv_5= '{' ( ( (lv_i18NLabelProvider_6_0= 'I18N' ) )? otherlv_7= 'label provider:' ( (lv_labelProviderExpression_8_0= ruleFormatExpr ) ) )? ( ( (lv_useExplicitExtends_9_0= 'extends:' ) ) ( (otherlv_10= RULE_ID ) ) (otherlv_11= ',' ( (otherlv_12= RULE_ID ) ) )* )? otherlv_13= 'template:' ( (lv_templateElements_14_0= ruleTypeConfigurationTemplateElement ) )* ( ( (lv_layoutDefined_15_0= 'layout:' ) ) ( (otherlv_16= RULE_ID ) )* )? otherlv_17= '}' )
            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:2162:2: ( (lv_defaultConfiguration_0_0= 'DEFAULT' ) )? otherlv_1= 'Configuration' ( (lv_name_2_0= RULE_ID ) ) (otherlv_3= 'for' ( (otherlv_4= RULE_ID ) ) )? otherlv_5= '{' ( ( (lv_i18NLabelProvider_6_0= 'I18N' ) )? otherlv_7= 'label provider:' ( (lv_labelProviderExpression_8_0= ruleFormatExpr ) ) )? ( ( (lv_useExplicitExtends_9_0= 'extends:' ) ) ( (otherlv_10= RULE_ID ) ) (otherlv_11= ',' ( (otherlv_12= RULE_ID ) ) )* )? otherlv_13= 'template:' ( (lv_templateElements_14_0= ruleTypeConfigurationTemplateElement ) )* ( ( (lv_layoutDefined_15_0= 'layout:' ) ) ( (otherlv_16= RULE_ID ) )* )? otherlv_17= '}'
            {
            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:2162:2: ( (lv_defaultConfiguration_0_0= 'DEFAULT' ) )?
            int alt33=2;
            int LA33_0 = input.LA(1);

            if ( (LA33_0==59) ) {
                alt33=1;
            }
            switch (alt33) {
                case 1 :
                    // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:2163:1: (lv_defaultConfiguration_0_0= 'DEFAULT' )
                    {
                    // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:2163:1: (lv_defaultConfiguration_0_0= 'DEFAULT' )
                    // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:2164:3: lv_defaultConfiguration_0_0= 'DEFAULT'
                    {
                    lv_defaultConfiguration_0_0=(Token)match(input,59,FOLLOW_59_in_ruleTypeConfigurationMdsl4616); 

                            newLeafNode(lv_defaultConfiguration_0_0, grammarAccess.getTypeConfigurationMdslAccess().getDefaultConfigurationDEFAULTKeyword_0_0());
                        

                    	        if (current==null) {
                    	            current = createModelElement(grammarAccess.getTypeConfigurationMdslRule());
                    	        }
                           		setWithLastConsumed(current, "defaultConfiguration", true, "DEFAULT");
                    	    

                    }


                    }
                    break;

            }

            otherlv_1=(Token)match(input,60,FOLLOW_60_in_ruleTypeConfigurationMdsl4642); 

                	newLeafNode(otherlv_1, grammarAccess.getTypeConfigurationMdslAccess().getConfigurationKeyword_1());
                
            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:2181:1: ( (lv_name_2_0= RULE_ID ) )
            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:2182:1: (lv_name_2_0= RULE_ID )
            {
            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:2182:1: (lv_name_2_0= RULE_ID )
            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:2183:3: lv_name_2_0= RULE_ID
            {
            lv_name_2_0=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleTypeConfigurationMdsl4659); 

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

            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:2199:2: (otherlv_3= 'for' ( (otherlv_4= RULE_ID ) ) )?
            int alt34=2;
            int LA34_0 = input.LA(1);

            if ( (LA34_0==61) ) {
                alt34=1;
            }
            switch (alt34) {
                case 1 :
                    // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:2199:4: otherlv_3= 'for' ( (otherlv_4= RULE_ID ) )
                    {
                    otherlv_3=(Token)match(input,61,FOLLOW_61_in_ruleTypeConfigurationMdsl4677); 

                        	newLeafNode(otherlv_3, grammarAccess.getTypeConfigurationMdslAccess().getForKeyword_3_0());
                        
                    // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:2203:1: ( (otherlv_4= RULE_ID ) )
                    // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:2204:1: (otherlv_4= RULE_ID )
                    {
                    // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:2204:1: (otherlv_4= RULE_ID )
                    // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:2205:3: otherlv_4= RULE_ID
                    {

                    			if (current==null) {
                    	            current = createModelElement(grammarAccess.getTypeConfigurationMdslRule());
                    	        }
                            
                    otherlv_4=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleTypeConfigurationMdsl4697); 

                    		newLeafNode(otherlv_4, grammarAccess.getTypeConfigurationMdslAccess().getTypeEClassCrossReference_3_1_0()); 
                    	

                    }


                    }


                    }
                    break;

            }

            otherlv_5=(Token)match(input,22,FOLLOW_22_in_ruleTypeConfigurationMdsl4711); 

                	newLeafNode(otherlv_5, grammarAccess.getTypeConfigurationMdslAccess().getLeftCurlyBracketKeyword_4());
                
            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:2220:1: ( ( (lv_i18NLabelProvider_6_0= 'I18N' ) )? otherlv_7= 'label provider:' ( (lv_labelProviderExpression_8_0= ruleFormatExpr ) ) )?
            int alt36=2;
            int LA36_0 = input.LA(1);

            if ( (LA36_0==55||LA36_0==62) ) {
                alt36=1;
            }
            switch (alt36) {
                case 1 :
                    // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:2220:2: ( (lv_i18NLabelProvider_6_0= 'I18N' ) )? otherlv_7= 'label provider:' ( (lv_labelProviderExpression_8_0= ruleFormatExpr ) )
                    {
                    // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:2220:2: ( (lv_i18NLabelProvider_6_0= 'I18N' ) )?
                    int alt35=2;
                    int LA35_0 = input.LA(1);

                    if ( (LA35_0==55) ) {
                        alt35=1;
                    }
                    switch (alt35) {
                        case 1 :
                            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:2221:1: (lv_i18NLabelProvider_6_0= 'I18N' )
                            {
                            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:2221:1: (lv_i18NLabelProvider_6_0= 'I18N' )
                            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:2222:3: lv_i18NLabelProvider_6_0= 'I18N'
                            {
                            lv_i18NLabelProvider_6_0=(Token)match(input,55,FOLLOW_55_in_ruleTypeConfigurationMdsl4730); 

                                    newLeafNode(lv_i18NLabelProvider_6_0, grammarAccess.getTypeConfigurationMdslAccess().getI18NLabelProviderI18NKeyword_5_0_0());
                                

                            	        if (current==null) {
                            	            current = createModelElement(grammarAccess.getTypeConfigurationMdslRule());
                            	        }
                                   		setWithLastConsumed(current, "i18NLabelProvider", true, "I18N");
                            	    

                            }


                            }
                            break;

                    }

                    otherlv_7=(Token)match(input,62,FOLLOW_62_in_ruleTypeConfigurationMdsl4756); 

                        	newLeafNode(otherlv_7, grammarAccess.getTypeConfigurationMdslAccess().getLabelProviderKeyword_5_1());
                        
                    // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:2239:1: ( (lv_labelProviderExpression_8_0= ruleFormatExpr ) )
                    // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:2240:1: (lv_labelProviderExpression_8_0= ruleFormatExpr )
                    {
                    // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:2240:1: (lv_labelProviderExpression_8_0= ruleFormatExpr )
                    // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:2241:3: lv_labelProviderExpression_8_0= ruleFormatExpr
                    {
                     
                    	        newCompositeNode(grammarAccess.getTypeConfigurationMdslAccess().getLabelProviderExpressionFormatExprParserRuleCall_5_2_0()); 
                    	    
                    pushFollow(FOLLOW_ruleFormatExpr_in_ruleTypeConfigurationMdsl4777);
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

            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:2257:4: ( ( (lv_useExplicitExtends_9_0= 'extends:' ) ) ( (otherlv_10= RULE_ID ) ) (otherlv_11= ',' ( (otherlv_12= RULE_ID ) ) )* )?
            int alt38=2;
            int LA38_0 = input.LA(1);

            if ( (LA38_0==63) ) {
                alt38=1;
            }
            switch (alt38) {
                case 1 :
                    // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:2257:5: ( (lv_useExplicitExtends_9_0= 'extends:' ) ) ( (otherlv_10= RULE_ID ) ) (otherlv_11= ',' ( (otherlv_12= RULE_ID ) ) )*
                    {
                    // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:2257:5: ( (lv_useExplicitExtends_9_0= 'extends:' ) )
                    // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:2258:1: (lv_useExplicitExtends_9_0= 'extends:' )
                    {
                    // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:2258:1: (lv_useExplicitExtends_9_0= 'extends:' )
                    // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:2259:3: lv_useExplicitExtends_9_0= 'extends:'
                    {
                    lv_useExplicitExtends_9_0=(Token)match(input,63,FOLLOW_63_in_ruleTypeConfigurationMdsl4798); 

                            newLeafNode(lv_useExplicitExtends_9_0, grammarAccess.getTypeConfigurationMdslAccess().getUseExplicitExtendsExtendsKeyword_6_0_0());
                        

                    	        if (current==null) {
                    	            current = createModelElement(grammarAccess.getTypeConfigurationMdslRule());
                    	        }
                           		setWithLastConsumed(current, "useExplicitExtends", true, "extends:");
                    	    

                    }


                    }

                    // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:2272:2: ( (otherlv_10= RULE_ID ) )
                    // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:2273:1: (otherlv_10= RULE_ID )
                    {
                    // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:2273:1: (otherlv_10= RULE_ID )
                    // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:2274:3: otherlv_10= RULE_ID
                    {

                    			if (current==null) {
                    	            current = createModelElement(grammarAccess.getTypeConfigurationMdslRule());
                    	        }
                            
                    otherlv_10=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleTypeConfigurationMdsl4831); 

                    		newLeafNode(otherlv_10, grammarAccess.getTypeConfigurationMdslAccess().getSuperConfigurationsTypeConfigurationMdslCrossReference_6_1_0()); 
                    	

                    }


                    }

                    // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:2285:2: (otherlv_11= ',' ( (otherlv_12= RULE_ID ) ) )*
                    loop37:
                    do {
                        int alt37=2;
                        int LA37_0 = input.LA(1);

                        if ( (LA37_0==35) ) {
                            alt37=1;
                        }


                        switch (alt37) {
                    	case 1 :
                    	    // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:2285:4: otherlv_11= ',' ( (otherlv_12= RULE_ID ) )
                    	    {
                    	    otherlv_11=(Token)match(input,35,FOLLOW_35_in_ruleTypeConfigurationMdsl4844); 

                    	        	newLeafNode(otherlv_11, grammarAccess.getTypeConfigurationMdslAccess().getCommaKeyword_6_2_0());
                    	        
                    	    // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:2289:1: ( (otherlv_12= RULE_ID ) )
                    	    // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:2290:1: (otherlv_12= RULE_ID )
                    	    {
                    	    // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:2290:1: (otherlv_12= RULE_ID )
                    	    // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:2291:3: otherlv_12= RULE_ID
                    	    {

                    	    			if (current==null) {
                    	    	            current = createModelElement(grammarAccess.getTypeConfigurationMdslRule());
                    	    	        }
                    	            
                    	    otherlv_12=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleTypeConfigurationMdsl4864); 

                    	    		newLeafNode(otherlv_12, grammarAccess.getTypeConfigurationMdslAccess().getSuperConfigurationsTypeConfigurationMdslCrossReference_6_2_1_0()); 
                    	    	

                    	    }


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

            otherlv_13=(Token)match(input,64,FOLLOW_64_in_ruleTypeConfigurationMdsl4880); 

                	newLeafNode(otherlv_13, grammarAccess.getTypeConfigurationMdslAccess().getTemplateKeyword_7());
                
            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:2306:1: ( (lv_templateElements_14_0= ruleTypeConfigurationTemplateElement ) )*
            loop39:
            do {
                int alt39=2;
                int LA39_0 = input.LA(1);

                if ( (LA39_0==66||LA39_0==70) ) {
                    alt39=1;
                }


                switch (alt39) {
            	case 1 :
            	    // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:2307:1: (lv_templateElements_14_0= ruleTypeConfigurationTemplateElement )
            	    {
            	    // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:2307:1: (lv_templateElements_14_0= ruleTypeConfigurationTemplateElement )
            	    // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:2308:3: lv_templateElements_14_0= ruleTypeConfigurationTemplateElement
            	    {
            	     
            	    	        newCompositeNode(grammarAccess.getTypeConfigurationMdslAccess().getTemplateElementsTypeConfigurationTemplateElementParserRuleCall_8_0()); 
            	    	    
            	    pushFollow(FOLLOW_ruleTypeConfigurationTemplateElement_in_ruleTypeConfigurationMdsl4901);
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
            	    break loop39;
                }
            } while (true);

            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:2324:3: ( ( (lv_layoutDefined_15_0= 'layout:' ) ) ( (otherlv_16= RULE_ID ) )* )?
            int alt41=2;
            int LA41_0 = input.LA(1);

            if ( (LA41_0==65) ) {
                alt41=1;
            }
            switch (alt41) {
                case 1 :
                    // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:2324:4: ( (lv_layoutDefined_15_0= 'layout:' ) ) ( (otherlv_16= RULE_ID ) )*
                    {
                    // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:2324:4: ( (lv_layoutDefined_15_0= 'layout:' ) )
                    // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:2325:1: (lv_layoutDefined_15_0= 'layout:' )
                    {
                    // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:2325:1: (lv_layoutDefined_15_0= 'layout:' )
                    // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:2326:3: lv_layoutDefined_15_0= 'layout:'
                    {
                    lv_layoutDefined_15_0=(Token)match(input,65,FOLLOW_65_in_ruleTypeConfigurationMdsl4921); 

                            newLeafNode(lv_layoutDefined_15_0, grammarAccess.getTypeConfigurationMdslAccess().getLayoutDefinedLayoutKeyword_9_0_0());
                        

                    	        if (current==null) {
                    	            current = createModelElement(grammarAccess.getTypeConfigurationMdslRule());
                    	        }
                           		setWithLastConsumed(current, "layoutDefined", true, "layout:");
                    	    

                    }


                    }

                    // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:2339:2: ( (otherlv_16= RULE_ID ) )*
                    loop40:
                    do {
                        int alt40=2;
                        int LA40_0 = input.LA(1);

                        if ( (LA40_0==RULE_ID) ) {
                            alt40=1;
                        }


                        switch (alt40) {
                    	case 1 :
                    	    // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:2340:1: (otherlv_16= RULE_ID )
                    	    {
                    	    // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:2340:1: (otherlv_16= RULE_ID )
                    	    // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:2341:3: otherlv_16= RULE_ID
                    	    {

                    	    			if (current==null) {
                    	    	            current = createModelElement(grammarAccess.getTypeConfigurationMdslRule());
                    	    	        }
                    	            
                    	    otherlv_16=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleTypeConfigurationMdsl4954); 

                    	    		newLeafNode(otherlv_16, grammarAccess.getTypeConfigurationMdslAccess().getLayoutElementsTypeConfigurationTemplateElementCrossReference_9_1_0()); 
                    	    	

                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop40;
                        }
                    } while (true);


                    }
                    break;

            }

            otherlv_17=(Token)match(input,30,FOLLOW_30_in_ruleTypeConfigurationMdsl4969); 

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
    // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:2364:1: entryRuleTypeConfigurationTemplateElement returns [EObject current=null] : iv_ruleTypeConfigurationTemplateElement= ruleTypeConfigurationTemplateElement EOF ;
    public final EObject entryRuleTypeConfigurationTemplateElement() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleTypeConfigurationTemplateElement = null;


        try {
            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:2365:2: (iv_ruleTypeConfigurationTemplateElement= ruleTypeConfigurationTemplateElement EOF )
            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:2366:2: iv_ruleTypeConfigurationTemplateElement= ruleTypeConfigurationTemplateElement EOF
            {
             newCompositeNode(grammarAccess.getTypeConfigurationTemplateElementRule()); 
            pushFollow(FOLLOW_ruleTypeConfigurationTemplateElement_in_entryRuleTypeConfigurationTemplateElement5005);
            iv_ruleTypeConfigurationTemplateElement=ruleTypeConfigurationTemplateElement();

            state._fsp--;

             current =iv_ruleTypeConfigurationTemplateElement; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleTypeConfigurationTemplateElement5015); 

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
    // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:2373:1: ruleTypeConfigurationTemplateElement returns [EObject current=null] : (this_WidgetConfigurationMdsl_0= ruleWidgetConfigurationMdsl | this_IncludeTemplateElementMdsl_1= ruleIncludeTemplateElementMdsl ) ;
    public final EObject ruleTypeConfigurationTemplateElement() throws RecognitionException {
        EObject current = null;

        EObject this_WidgetConfigurationMdsl_0 = null;

        EObject this_IncludeTemplateElementMdsl_1 = null;


         enterRule(); 
            
        try {
            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:2376:28: ( (this_WidgetConfigurationMdsl_0= ruleWidgetConfigurationMdsl | this_IncludeTemplateElementMdsl_1= ruleIncludeTemplateElementMdsl ) )
            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:2377:1: (this_WidgetConfigurationMdsl_0= ruleWidgetConfigurationMdsl | this_IncludeTemplateElementMdsl_1= ruleIncludeTemplateElementMdsl )
            {
            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:2377:1: (this_WidgetConfigurationMdsl_0= ruleWidgetConfigurationMdsl | this_IncludeTemplateElementMdsl_1= ruleIncludeTemplateElementMdsl )
            int alt42=2;
            int LA42_0 = input.LA(1);

            if ( (LA42_0==70) ) {
                alt42=1;
            }
            else if ( (LA42_0==66) ) {
                alt42=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 42, 0, input);

                throw nvae;
            }
            switch (alt42) {
                case 1 :
                    // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:2378:5: this_WidgetConfigurationMdsl_0= ruleWidgetConfigurationMdsl
                    {
                     
                            newCompositeNode(grammarAccess.getTypeConfigurationTemplateElementAccess().getWidgetConfigurationMdslParserRuleCall_0()); 
                        
                    pushFollow(FOLLOW_ruleWidgetConfigurationMdsl_in_ruleTypeConfigurationTemplateElement5062);
                    this_WidgetConfigurationMdsl_0=ruleWidgetConfigurationMdsl();

                    state._fsp--;

                     
                            current = this_WidgetConfigurationMdsl_0; 
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;
                case 2 :
                    // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:2388:5: this_IncludeTemplateElementMdsl_1= ruleIncludeTemplateElementMdsl
                    {
                     
                            newCompositeNode(grammarAccess.getTypeConfigurationTemplateElementAccess().getIncludeTemplateElementMdslParserRuleCall_1()); 
                        
                    pushFollow(FOLLOW_ruleIncludeTemplateElementMdsl_in_ruleTypeConfigurationTemplateElement5089);
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
    // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:2404:1: entryRuleIncludeTemplateElementMdsl returns [EObject current=null] : iv_ruleIncludeTemplateElementMdsl= ruleIncludeTemplateElementMdsl EOF ;
    public final EObject entryRuleIncludeTemplateElementMdsl() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleIncludeTemplateElementMdsl = null;


        try {
            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:2405:2: (iv_ruleIncludeTemplateElementMdsl= ruleIncludeTemplateElementMdsl EOF )
            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:2406:2: iv_ruleIncludeTemplateElementMdsl= ruleIncludeTemplateElementMdsl EOF
            {
             newCompositeNode(grammarAccess.getIncludeTemplateElementMdslRule()); 
            pushFollow(FOLLOW_ruleIncludeTemplateElementMdsl_in_entryRuleIncludeTemplateElementMdsl5124);
            iv_ruleIncludeTemplateElementMdsl=ruleIncludeTemplateElementMdsl();

            state._fsp--;

             current =iv_ruleIncludeTemplateElementMdsl; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleIncludeTemplateElementMdsl5134); 

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
    // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:2413:1: ruleIncludeTemplateElementMdsl returns [EObject current=null] : (otherlv_0= 'include widget:' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= 'source template:' ( (otherlv_3= RULE_ID ) ) otherlv_4= 'value:' ( (lv_valueQuery_5_0= ruleQueryUsage ) ) ) ;
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
            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:2416:28: ( (otherlv_0= 'include widget:' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= 'source template:' ( (otherlv_3= RULE_ID ) ) otherlv_4= 'value:' ( (lv_valueQuery_5_0= ruleQueryUsage ) ) ) )
            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:2417:1: (otherlv_0= 'include widget:' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= 'source template:' ( (otherlv_3= RULE_ID ) ) otherlv_4= 'value:' ( (lv_valueQuery_5_0= ruleQueryUsage ) ) )
            {
            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:2417:1: (otherlv_0= 'include widget:' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= 'source template:' ( (otherlv_3= RULE_ID ) ) otherlv_4= 'value:' ( (lv_valueQuery_5_0= ruleQueryUsage ) ) )
            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:2417:3: otherlv_0= 'include widget:' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= 'source template:' ( (otherlv_3= RULE_ID ) ) otherlv_4= 'value:' ( (lv_valueQuery_5_0= ruleQueryUsage ) )
            {
            otherlv_0=(Token)match(input,66,FOLLOW_66_in_ruleIncludeTemplateElementMdsl5171); 

                	newLeafNode(otherlv_0, grammarAccess.getIncludeTemplateElementMdslAccess().getIncludeWidgetKeyword_0());
                
            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:2421:1: ( (lv_name_1_0= RULE_ID ) )
            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:2422:1: (lv_name_1_0= RULE_ID )
            {
            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:2422:1: (lv_name_1_0= RULE_ID )
            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:2423:3: lv_name_1_0= RULE_ID
            {
            lv_name_1_0=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleIncludeTemplateElementMdsl5188); 

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

            otherlv_2=(Token)match(input,67,FOLLOW_67_in_ruleIncludeTemplateElementMdsl5205); 

                	newLeafNode(otherlv_2, grammarAccess.getIncludeTemplateElementMdslAccess().getSourceTemplateKeyword_2());
                
            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:2443:1: ( (otherlv_3= RULE_ID ) )
            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:2444:1: (otherlv_3= RULE_ID )
            {
            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:2444:1: (otherlv_3= RULE_ID )
            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:2445:3: otherlv_3= RULE_ID
            {

            			if (current==null) {
            	            current = createModelElement(grammarAccess.getIncludeTemplateElementMdslRule());
            	        }
                    
            otherlv_3=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleIncludeTemplateElementMdsl5225); 

            		newLeafNode(otherlv_3, grammarAccess.getIncludeTemplateElementMdslAccess().getRefIncludedTemplateTypeConfigurationMdslCrossReference_3_0()); 
            	

            }


            }

            otherlv_4=(Token)match(input,68,FOLLOW_68_in_ruleIncludeTemplateElementMdsl5237); 

                	newLeafNode(otherlv_4, grammarAccess.getIncludeTemplateElementMdslAccess().getValueKeyword_4());
                
            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:2460:1: ( (lv_valueQuery_5_0= ruleQueryUsage ) )
            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:2461:1: (lv_valueQuery_5_0= ruleQueryUsage )
            {
            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:2461:1: (lv_valueQuery_5_0= ruleQueryUsage )
            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:2462:3: lv_valueQuery_5_0= ruleQueryUsage
            {
             
            	        newCompositeNode(grammarAccess.getIncludeTemplateElementMdslAccess().getValueQueryQueryUsageParserRuleCall_5_0()); 
            	    
            pushFollow(FOLLOW_ruleQueryUsage_in_ruleIncludeTemplateElementMdsl5258);
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
    // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:2486:1: entryRuleValueConverter returns [EObject current=null] : iv_ruleValueConverter= ruleValueConverter EOF ;
    public final EObject entryRuleValueConverter() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleValueConverter = null;


        try {
            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:2487:2: (iv_ruleValueConverter= ruleValueConverter EOF )
            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:2488:2: iv_ruleValueConverter= ruleValueConverter EOF
            {
             newCompositeNode(grammarAccess.getValueConverterRule()); 
            pushFollow(FOLLOW_ruleValueConverter_in_entryRuleValueConverter5294);
            iv_ruleValueConverter=ruleValueConverter();

            state._fsp--;

             current =iv_ruleValueConverter; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleValueConverter5304); 

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
    // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:2495:1: ruleValueConverter returns [EObject current=null] : (this_BasicTypeValueConverter_0= ruleBasicTypeValueConverter | this_QueryBasedValueConverter_1= ruleQueryBasedValueConverter ) ;
    public final EObject ruleValueConverter() throws RecognitionException {
        EObject current = null;

        EObject this_BasicTypeValueConverter_0 = null;

        EObject this_QueryBasedValueConverter_1 = null;


         enterRule(); 
            
        try {
            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:2498:28: ( (this_BasicTypeValueConverter_0= ruleBasicTypeValueConverter | this_QueryBasedValueConverter_1= ruleQueryBasedValueConverter ) )
            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:2499:1: (this_BasicTypeValueConverter_0= ruleBasicTypeValueConverter | this_QueryBasedValueConverter_1= ruleQueryBasedValueConverter )
            {
            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:2499:1: (this_BasicTypeValueConverter_0= ruleBasicTypeValueConverter | this_QueryBasedValueConverter_1= ruleQueryBasedValueConverter )
            int alt43=2;
            int LA43_0 = input.LA(1);

            if ( ((LA43_0>=108 && LA43_0<=113)) ) {
                alt43=1;
            }
            else if ( (LA43_0==69) ) {
                alt43=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 43, 0, input);

                throw nvae;
            }
            switch (alt43) {
                case 1 :
                    // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:2500:5: this_BasicTypeValueConverter_0= ruleBasicTypeValueConverter
                    {
                     
                            newCompositeNode(grammarAccess.getValueConverterAccess().getBasicTypeValueConverterParserRuleCall_0()); 
                        
                    pushFollow(FOLLOW_ruleBasicTypeValueConverter_in_ruleValueConverter5351);
                    this_BasicTypeValueConverter_0=ruleBasicTypeValueConverter();

                    state._fsp--;

                     
                            current = this_BasicTypeValueConverter_0; 
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;
                case 2 :
                    // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:2510:5: this_QueryBasedValueConverter_1= ruleQueryBasedValueConverter
                    {
                     
                            newCompositeNode(grammarAccess.getValueConverterAccess().getQueryBasedValueConverterParserRuleCall_1()); 
                        
                    pushFollow(FOLLOW_ruleQueryBasedValueConverter_in_ruleValueConverter5378);
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
    // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:2526:1: entryRuleQueryBasedValueConverter returns [EObject current=null] : iv_ruleQueryBasedValueConverter= ruleQueryBasedValueConverter EOF ;
    public final EObject entryRuleQueryBasedValueConverter() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleQueryBasedValueConverter = null;


        try {
            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:2527:2: (iv_ruleQueryBasedValueConverter= ruleQueryBasedValueConverter EOF )
            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:2528:2: iv_ruleQueryBasedValueConverter= ruleQueryBasedValueConverter EOF
            {
             newCompositeNode(grammarAccess.getQueryBasedValueConverterRule()); 
            pushFollow(FOLLOW_ruleQueryBasedValueConverter_in_entryRuleQueryBasedValueConverter5413);
            iv_ruleQueryBasedValueConverter=ruleQueryBasedValueConverter();

            state._fsp--;

             current =iv_ruleQueryBasedValueConverter; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleQueryBasedValueConverter5423); 

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
    // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:2535:1: ruleQueryBasedValueConverter returns [EObject current=null] : (otherlv_0= 'Query' ( (lv_converterQuery_1_0= ruleQueryUsage ) ) ) ;
    public final EObject ruleQueryBasedValueConverter() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        EObject lv_converterQuery_1_0 = null;


         enterRule(); 
            
        try {
            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:2538:28: ( (otherlv_0= 'Query' ( (lv_converterQuery_1_0= ruleQueryUsage ) ) ) )
            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:2539:1: (otherlv_0= 'Query' ( (lv_converterQuery_1_0= ruleQueryUsage ) ) )
            {
            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:2539:1: (otherlv_0= 'Query' ( (lv_converterQuery_1_0= ruleQueryUsage ) ) )
            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:2539:3: otherlv_0= 'Query' ( (lv_converterQuery_1_0= ruleQueryUsage ) )
            {
            otherlv_0=(Token)match(input,69,FOLLOW_69_in_ruleQueryBasedValueConverter5460); 

                	newLeafNode(otherlv_0, grammarAccess.getQueryBasedValueConverterAccess().getQueryKeyword_0());
                
            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:2543:1: ( (lv_converterQuery_1_0= ruleQueryUsage ) )
            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:2544:1: (lv_converterQuery_1_0= ruleQueryUsage )
            {
            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:2544:1: (lv_converterQuery_1_0= ruleQueryUsage )
            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:2545:3: lv_converterQuery_1_0= ruleQueryUsage
            {
             
            	        newCompositeNode(grammarAccess.getQueryBasedValueConverterAccess().getConverterQueryQueryUsageParserRuleCall_1_0()); 
            	    
            pushFollow(FOLLOW_ruleQueryUsage_in_ruleQueryBasedValueConverter5481);
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
    // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:2569:1: entryRuleBasicTypeValueConverter returns [EObject current=null] : iv_ruleBasicTypeValueConverter= ruleBasicTypeValueConverter EOF ;
    public final EObject entryRuleBasicTypeValueConverter() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleBasicTypeValueConverter = null;


        try {
            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:2570:2: (iv_ruleBasicTypeValueConverter= ruleBasicTypeValueConverter EOF )
            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:2571:2: iv_ruleBasicTypeValueConverter= ruleBasicTypeValueConverter EOF
            {
             newCompositeNode(grammarAccess.getBasicTypeValueConverterRule()); 
            pushFollow(FOLLOW_ruleBasicTypeValueConverter_in_entryRuleBasicTypeValueConverter5517);
            iv_ruleBasicTypeValueConverter=ruleBasicTypeValueConverter();

            state._fsp--;

             current =iv_ruleBasicTypeValueConverter; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleBasicTypeValueConverter5527); 

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
    // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:2578:1: ruleBasicTypeValueConverter returns [EObject current=null] : ( ( (lv_category_0_0= ruleVALUE_CONVERTER_CATEGORY_MDSL ) ) (otherlv_1= ':' ( (lv_configuration_2_0= RULE_STRING ) ) )? ) ;
    public final EObject ruleBasicTypeValueConverter() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token lv_configuration_2_0=null;
        Enumerator lv_category_0_0 = null;


         enterRule(); 
            
        try {
            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:2581:28: ( ( ( (lv_category_0_0= ruleVALUE_CONVERTER_CATEGORY_MDSL ) ) (otherlv_1= ':' ( (lv_configuration_2_0= RULE_STRING ) ) )? ) )
            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:2582:1: ( ( (lv_category_0_0= ruleVALUE_CONVERTER_CATEGORY_MDSL ) ) (otherlv_1= ':' ( (lv_configuration_2_0= RULE_STRING ) ) )? )
            {
            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:2582:1: ( ( (lv_category_0_0= ruleVALUE_CONVERTER_CATEGORY_MDSL ) ) (otherlv_1= ':' ( (lv_configuration_2_0= RULE_STRING ) ) )? )
            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:2582:2: ( (lv_category_0_0= ruleVALUE_CONVERTER_CATEGORY_MDSL ) ) (otherlv_1= ':' ( (lv_configuration_2_0= RULE_STRING ) ) )?
            {
            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:2582:2: ( (lv_category_0_0= ruleVALUE_CONVERTER_CATEGORY_MDSL ) )
            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:2583:1: (lv_category_0_0= ruleVALUE_CONVERTER_CATEGORY_MDSL )
            {
            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:2583:1: (lv_category_0_0= ruleVALUE_CONVERTER_CATEGORY_MDSL )
            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:2584:3: lv_category_0_0= ruleVALUE_CONVERTER_CATEGORY_MDSL
            {
             
            	        newCompositeNode(grammarAccess.getBasicTypeValueConverterAccess().getCategoryVALUE_CONVERTER_CATEGORY_MDSLEnumRuleCall_0_0()); 
            	    
            pushFollow(FOLLOW_ruleVALUE_CONVERTER_CATEGORY_MDSL_in_ruleBasicTypeValueConverter5573);
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

            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:2600:2: (otherlv_1= ':' ( (lv_configuration_2_0= RULE_STRING ) ) )?
            int alt44=2;
            int LA44_0 = input.LA(1);

            if ( (LA44_0==27) ) {
                alt44=1;
            }
            switch (alt44) {
                case 1 :
                    // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:2600:4: otherlv_1= ':' ( (lv_configuration_2_0= RULE_STRING ) )
                    {
                    otherlv_1=(Token)match(input,27,FOLLOW_27_in_ruleBasicTypeValueConverter5586); 

                        	newLeafNode(otherlv_1, grammarAccess.getBasicTypeValueConverterAccess().getColonKeyword_1_0());
                        
                    // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:2604:1: ( (lv_configuration_2_0= RULE_STRING ) )
                    // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:2605:1: (lv_configuration_2_0= RULE_STRING )
                    {
                    // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:2605:1: (lv_configuration_2_0= RULE_STRING )
                    // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:2606:3: lv_configuration_2_0= RULE_STRING
                    {
                    lv_configuration_2_0=(Token)match(input,RULE_STRING,FOLLOW_RULE_STRING_in_ruleBasicTypeValueConverter5603); 

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
    // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:2630:1: entryRuleWidgetConfigurationMdsl returns [EObject current=null] : iv_ruleWidgetConfigurationMdsl= ruleWidgetConfigurationMdsl EOF ;
    public final EObject entryRuleWidgetConfigurationMdsl() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleWidgetConfigurationMdsl = null;


        try {
            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:2631:2: (iv_ruleWidgetConfigurationMdsl= ruleWidgetConfigurationMdsl EOF )
            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:2632:2: iv_ruleWidgetConfigurationMdsl= ruleWidgetConfigurationMdsl EOF
            {
             newCompositeNode(grammarAccess.getWidgetConfigurationMdslRule()); 
            pushFollow(FOLLOW_ruleWidgetConfigurationMdsl_in_entryRuleWidgetConfigurationMdsl5646);
            iv_ruleWidgetConfigurationMdsl=ruleWidgetConfigurationMdsl();

            state._fsp--;

             current =iv_ruleWidgetConfigurationMdsl; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleWidgetConfigurationMdsl5656); 

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
    // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:2639:1: ruleWidgetConfigurationMdsl returns [EObject current=null] : (otherlv_0= 'widget:' ( (lv_name_1_0= RULE_ID ) ) (otherlv_2= 'description:' ( (lv_description_3_0= RULE_STRING ) ) )? (otherlv_4= 'tab:' ( (otherlv_5= RULE_ID ) ) )? (otherlv_6= 'layers:' ( (otherlv_7= RULE_ID ) ) (otherlv_8= ',' ( (otherlv_9= RULE_ID ) ) )* )? ( (lv_i18NLabel_10_0= 'I18N' ) )? otherlv_11= 'label:' ( (lv_label_12_0= ruleFormatExpr ) ) otherlv_13= 'type:' ( (lv_widgetCategory_14_0= ruleWIDGET_CATEGORY_MDSL ) ) (otherlv_15= ':' ( (otherlv_16= RULE_ID ) ) )? ( (lv_dslReference_17_0= ruleXtextLanguageReference ) )? ( (otherlv_18= 'flexible template:' | otherlv_19= 'target template:' ) ( (otherlv_20= RULE_ID ) ) )? ( ( ( ( ({...}? => ( ({...}? => (otherlv_22= 'visible when:' ( (lv_visibilityQuery_23_0= ruleQuery ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_24= 'editable when:' ( (lv_editableQuery_25_0= ruleQuery ) ) ) ) ) ) )* ) ) ) (otherlv_26= 'value:' ( (lv_valueQuery_27_0= ruleQueryUsage ) ) )? (otherlv_28= 'valueConverter:' ( (lv_valueConverter_29_0= ruleValueConverter ) ) )? (otherlv_30= 'validators:' ( (lv_validators_31_0= ruleValidatorMdsl ) )* )? ( ( (lv_i18NFormat_32_0= 'I18N' ) )? otherlv_33= 'format:' ( (lv_valueFormat_34_0= ruleFormatExpr ) ) )? (otherlv_35= 'candidates:' ( (lv_candidatesQuery_36_0= ruleQueryUsage ) ) )? ( ( (lv_i18NItemLabel_37_0= 'I18N' ) )? otherlv_38= 'item label:' ( (lv_itemLabelExpression_39_0= ruleFormatExpr ) ) )? (otherlv_40= 'commands:' ( (lv_commands_41_0= ruleCommand ) ) (otherlv_42= ',' ( (lv_commands_43_0= ruleCommand ) ) )* )? ) ;
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
            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:2642:28: ( (otherlv_0= 'widget:' ( (lv_name_1_0= RULE_ID ) ) (otherlv_2= 'description:' ( (lv_description_3_0= RULE_STRING ) ) )? (otherlv_4= 'tab:' ( (otherlv_5= RULE_ID ) ) )? (otherlv_6= 'layers:' ( (otherlv_7= RULE_ID ) ) (otherlv_8= ',' ( (otherlv_9= RULE_ID ) ) )* )? ( (lv_i18NLabel_10_0= 'I18N' ) )? otherlv_11= 'label:' ( (lv_label_12_0= ruleFormatExpr ) ) otherlv_13= 'type:' ( (lv_widgetCategory_14_0= ruleWIDGET_CATEGORY_MDSL ) ) (otherlv_15= ':' ( (otherlv_16= RULE_ID ) ) )? ( (lv_dslReference_17_0= ruleXtextLanguageReference ) )? ( (otherlv_18= 'flexible template:' | otherlv_19= 'target template:' ) ( (otherlv_20= RULE_ID ) ) )? ( ( ( ( ({...}? => ( ({...}? => (otherlv_22= 'visible when:' ( (lv_visibilityQuery_23_0= ruleQuery ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_24= 'editable when:' ( (lv_editableQuery_25_0= ruleQuery ) ) ) ) ) ) )* ) ) ) (otherlv_26= 'value:' ( (lv_valueQuery_27_0= ruleQueryUsage ) ) )? (otherlv_28= 'valueConverter:' ( (lv_valueConverter_29_0= ruleValueConverter ) ) )? (otherlv_30= 'validators:' ( (lv_validators_31_0= ruleValidatorMdsl ) )* )? ( ( (lv_i18NFormat_32_0= 'I18N' ) )? otherlv_33= 'format:' ( (lv_valueFormat_34_0= ruleFormatExpr ) ) )? (otherlv_35= 'candidates:' ( (lv_candidatesQuery_36_0= ruleQueryUsage ) ) )? ( ( (lv_i18NItemLabel_37_0= 'I18N' ) )? otherlv_38= 'item label:' ( (lv_itemLabelExpression_39_0= ruleFormatExpr ) ) )? (otherlv_40= 'commands:' ( (lv_commands_41_0= ruleCommand ) ) (otherlv_42= ',' ( (lv_commands_43_0= ruleCommand ) ) )* )? ) )
            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:2643:1: (otherlv_0= 'widget:' ( (lv_name_1_0= RULE_ID ) ) (otherlv_2= 'description:' ( (lv_description_3_0= RULE_STRING ) ) )? (otherlv_4= 'tab:' ( (otherlv_5= RULE_ID ) ) )? (otherlv_6= 'layers:' ( (otherlv_7= RULE_ID ) ) (otherlv_8= ',' ( (otherlv_9= RULE_ID ) ) )* )? ( (lv_i18NLabel_10_0= 'I18N' ) )? otherlv_11= 'label:' ( (lv_label_12_0= ruleFormatExpr ) ) otherlv_13= 'type:' ( (lv_widgetCategory_14_0= ruleWIDGET_CATEGORY_MDSL ) ) (otherlv_15= ':' ( (otherlv_16= RULE_ID ) ) )? ( (lv_dslReference_17_0= ruleXtextLanguageReference ) )? ( (otherlv_18= 'flexible template:' | otherlv_19= 'target template:' ) ( (otherlv_20= RULE_ID ) ) )? ( ( ( ( ({...}? => ( ({...}? => (otherlv_22= 'visible when:' ( (lv_visibilityQuery_23_0= ruleQuery ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_24= 'editable when:' ( (lv_editableQuery_25_0= ruleQuery ) ) ) ) ) ) )* ) ) ) (otherlv_26= 'value:' ( (lv_valueQuery_27_0= ruleQueryUsage ) ) )? (otherlv_28= 'valueConverter:' ( (lv_valueConverter_29_0= ruleValueConverter ) ) )? (otherlv_30= 'validators:' ( (lv_validators_31_0= ruleValidatorMdsl ) )* )? ( ( (lv_i18NFormat_32_0= 'I18N' ) )? otherlv_33= 'format:' ( (lv_valueFormat_34_0= ruleFormatExpr ) ) )? (otherlv_35= 'candidates:' ( (lv_candidatesQuery_36_0= ruleQueryUsage ) ) )? ( ( (lv_i18NItemLabel_37_0= 'I18N' ) )? otherlv_38= 'item label:' ( (lv_itemLabelExpression_39_0= ruleFormatExpr ) ) )? (otherlv_40= 'commands:' ( (lv_commands_41_0= ruleCommand ) ) (otherlv_42= ',' ( (lv_commands_43_0= ruleCommand ) ) )* )? )
            {
            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:2643:1: (otherlv_0= 'widget:' ( (lv_name_1_0= RULE_ID ) ) (otherlv_2= 'description:' ( (lv_description_3_0= RULE_STRING ) ) )? (otherlv_4= 'tab:' ( (otherlv_5= RULE_ID ) ) )? (otherlv_6= 'layers:' ( (otherlv_7= RULE_ID ) ) (otherlv_8= ',' ( (otherlv_9= RULE_ID ) ) )* )? ( (lv_i18NLabel_10_0= 'I18N' ) )? otherlv_11= 'label:' ( (lv_label_12_0= ruleFormatExpr ) ) otherlv_13= 'type:' ( (lv_widgetCategory_14_0= ruleWIDGET_CATEGORY_MDSL ) ) (otherlv_15= ':' ( (otherlv_16= RULE_ID ) ) )? ( (lv_dslReference_17_0= ruleXtextLanguageReference ) )? ( (otherlv_18= 'flexible template:' | otherlv_19= 'target template:' ) ( (otherlv_20= RULE_ID ) ) )? ( ( ( ( ({...}? => ( ({...}? => (otherlv_22= 'visible when:' ( (lv_visibilityQuery_23_0= ruleQuery ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_24= 'editable when:' ( (lv_editableQuery_25_0= ruleQuery ) ) ) ) ) ) )* ) ) ) (otherlv_26= 'value:' ( (lv_valueQuery_27_0= ruleQueryUsage ) ) )? (otherlv_28= 'valueConverter:' ( (lv_valueConverter_29_0= ruleValueConverter ) ) )? (otherlv_30= 'validators:' ( (lv_validators_31_0= ruleValidatorMdsl ) )* )? ( ( (lv_i18NFormat_32_0= 'I18N' ) )? otherlv_33= 'format:' ( (lv_valueFormat_34_0= ruleFormatExpr ) ) )? (otherlv_35= 'candidates:' ( (lv_candidatesQuery_36_0= ruleQueryUsage ) ) )? ( ( (lv_i18NItemLabel_37_0= 'I18N' ) )? otherlv_38= 'item label:' ( (lv_itemLabelExpression_39_0= ruleFormatExpr ) ) )? (otherlv_40= 'commands:' ( (lv_commands_41_0= ruleCommand ) ) (otherlv_42= ',' ( (lv_commands_43_0= ruleCommand ) ) )* )? )
            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:2643:3: otherlv_0= 'widget:' ( (lv_name_1_0= RULE_ID ) ) (otherlv_2= 'description:' ( (lv_description_3_0= RULE_STRING ) ) )? (otherlv_4= 'tab:' ( (otherlv_5= RULE_ID ) ) )? (otherlv_6= 'layers:' ( (otherlv_7= RULE_ID ) ) (otherlv_8= ',' ( (otherlv_9= RULE_ID ) ) )* )? ( (lv_i18NLabel_10_0= 'I18N' ) )? otherlv_11= 'label:' ( (lv_label_12_0= ruleFormatExpr ) ) otherlv_13= 'type:' ( (lv_widgetCategory_14_0= ruleWIDGET_CATEGORY_MDSL ) ) (otherlv_15= ':' ( (otherlv_16= RULE_ID ) ) )? ( (lv_dslReference_17_0= ruleXtextLanguageReference ) )? ( (otherlv_18= 'flexible template:' | otherlv_19= 'target template:' ) ( (otherlv_20= RULE_ID ) ) )? ( ( ( ( ({...}? => ( ({...}? => (otherlv_22= 'visible when:' ( (lv_visibilityQuery_23_0= ruleQuery ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_24= 'editable when:' ( (lv_editableQuery_25_0= ruleQuery ) ) ) ) ) ) )* ) ) ) (otherlv_26= 'value:' ( (lv_valueQuery_27_0= ruleQueryUsage ) ) )? (otherlv_28= 'valueConverter:' ( (lv_valueConverter_29_0= ruleValueConverter ) ) )? (otherlv_30= 'validators:' ( (lv_validators_31_0= ruleValidatorMdsl ) )* )? ( ( (lv_i18NFormat_32_0= 'I18N' ) )? otherlv_33= 'format:' ( (lv_valueFormat_34_0= ruleFormatExpr ) ) )? (otherlv_35= 'candidates:' ( (lv_candidatesQuery_36_0= ruleQueryUsage ) ) )? ( ( (lv_i18NItemLabel_37_0= 'I18N' ) )? otherlv_38= 'item label:' ( (lv_itemLabelExpression_39_0= ruleFormatExpr ) ) )? (otherlv_40= 'commands:' ( (lv_commands_41_0= ruleCommand ) ) (otherlv_42= ',' ( (lv_commands_43_0= ruleCommand ) ) )* )?
            {
            otherlv_0=(Token)match(input,70,FOLLOW_70_in_ruleWidgetConfigurationMdsl5693); 

                	newLeafNode(otherlv_0, grammarAccess.getWidgetConfigurationMdslAccess().getWidgetKeyword_0());
                
            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:2647:1: ( (lv_name_1_0= RULE_ID ) )
            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:2648:1: (lv_name_1_0= RULE_ID )
            {
            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:2648:1: (lv_name_1_0= RULE_ID )
            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:2649:3: lv_name_1_0= RULE_ID
            {
            lv_name_1_0=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleWidgetConfigurationMdsl5710); 

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

            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:2665:2: (otherlv_2= 'description:' ( (lv_description_3_0= RULE_STRING ) ) )?
            int alt45=2;
            int LA45_0 = input.LA(1);

            if ( (LA45_0==17) ) {
                alt45=1;
            }
            switch (alt45) {
                case 1 :
                    // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:2665:4: otherlv_2= 'description:' ( (lv_description_3_0= RULE_STRING ) )
                    {
                    otherlv_2=(Token)match(input,17,FOLLOW_17_in_ruleWidgetConfigurationMdsl5728); 

                        	newLeafNode(otherlv_2, grammarAccess.getWidgetConfigurationMdslAccess().getDescriptionKeyword_2_0());
                        
                    // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:2669:1: ( (lv_description_3_0= RULE_STRING ) )
                    // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:2670:1: (lv_description_3_0= RULE_STRING )
                    {
                    // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:2670:1: (lv_description_3_0= RULE_STRING )
                    // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:2671:3: lv_description_3_0= RULE_STRING
                    {
                    lv_description_3_0=(Token)match(input,RULE_STRING,FOLLOW_RULE_STRING_in_ruleWidgetConfigurationMdsl5745); 

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

            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:2687:4: (otherlv_4= 'tab:' ( (otherlv_5= RULE_ID ) ) )?
            int alt46=2;
            int LA46_0 = input.LA(1);

            if ( (LA46_0==71) ) {
                alt46=1;
            }
            switch (alt46) {
                case 1 :
                    // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:2687:6: otherlv_4= 'tab:' ( (otherlv_5= RULE_ID ) )
                    {
                    otherlv_4=(Token)match(input,71,FOLLOW_71_in_ruleWidgetConfigurationMdsl5765); 

                        	newLeafNode(otherlv_4, grammarAccess.getWidgetConfigurationMdslAccess().getTabKeyword_3_0());
                        
                    // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:2691:1: ( (otherlv_5= RULE_ID ) )
                    // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:2692:1: (otherlv_5= RULE_ID )
                    {
                    // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:2692:1: (otherlv_5= RULE_ID )
                    // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:2693:3: otherlv_5= RULE_ID
                    {

                    			if (current==null) {
                    	            current = createModelElement(grammarAccess.getWidgetConfigurationMdslRule());
                    	        }
                            
                    otherlv_5=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleWidgetConfigurationMdsl5785); 

                    		newLeafNode(otherlv_5, grammarAccess.getWidgetConfigurationMdslAccess().getUiTabUITabMdslCrossReference_3_1_0()); 
                    	

                    }


                    }


                    }
                    break;

            }

            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:2704:4: (otherlv_6= 'layers:' ( (otherlv_7= RULE_ID ) ) (otherlv_8= ',' ( (otherlv_9= RULE_ID ) ) )* )?
            int alt48=2;
            int LA48_0 = input.LA(1);

            if ( (LA48_0==72) ) {
                alt48=1;
            }
            switch (alt48) {
                case 1 :
                    // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:2704:6: otherlv_6= 'layers:' ( (otherlv_7= RULE_ID ) ) (otherlv_8= ',' ( (otherlv_9= RULE_ID ) ) )*
                    {
                    otherlv_6=(Token)match(input,72,FOLLOW_72_in_ruleWidgetConfigurationMdsl5800); 

                        	newLeafNode(otherlv_6, grammarAccess.getWidgetConfigurationMdslAccess().getLayersKeyword_4_0());
                        
                    // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:2708:1: ( (otherlv_7= RULE_ID ) )
                    // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:2709:1: (otherlv_7= RULE_ID )
                    {
                    // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:2709:1: (otherlv_7= RULE_ID )
                    // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:2710:3: otherlv_7= RULE_ID
                    {

                    			if (current==null) {
                    	            current = createModelElement(grammarAccess.getWidgetConfigurationMdslRule());
                    	        }
                            
                    otherlv_7=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleWidgetConfigurationMdsl5820); 

                    		newLeafNode(otherlv_7, grammarAccess.getWidgetConfigurationMdslAccess().getLayersLayerMdslCrossReference_4_1_0()); 
                    	

                    }


                    }

                    // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:2721:2: (otherlv_8= ',' ( (otherlv_9= RULE_ID ) ) )*
                    loop47:
                    do {
                        int alt47=2;
                        int LA47_0 = input.LA(1);

                        if ( (LA47_0==35) ) {
                            alt47=1;
                        }


                        switch (alt47) {
                    	case 1 :
                    	    // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:2721:4: otherlv_8= ',' ( (otherlv_9= RULE_ID ) )
                    	    {
                    	    otherlv_8=(Token)match(input,35,FOLLOW_35_in_ruleWidgetConfigurationMdsl5833); 

                    	        	newLeafNode(otherlv_8, grammarAccess.getWidgetConfigurationMdslAccess().getCommaKeyword_4_2_0());
                    	        
                    	    // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:2725:1: ( (otherlv_9= RULE_ID ) )
                    	    // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:2726:1: (otherlv_9= RULE_ID )
                    	    {
                    	    // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:2726:1: (otherlv_9= RULE_ID )
                    	    // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:2727:3: otherlv_9= RULE_ID
                    	    {

                    	    			if (current==null) {
                    	    	            current = createModelElement(grammarAccess.getWidgetConfigurationMdslRule());
                    	    	        }
                    	            
                    	    otherlv_9=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleWidgetConfigurationMdsl5853); 

                    	    		newLeafNode(otherlv_9, grammarAccess.getWidgetConfigurationMdslAccess().getLayersLayerMdslCrossReference_4_2_1_0()); 
                    	    	

                    	    }


                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop47;
                        }
                    } while (true);


                    }
                    break;

            }

            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:2738:6: ( (lv_i18NLabel_10_0= 'I18N' ) )?
            int alt49=2;
            int LA49_0 = input.LA(1);

            if ( (LA49_0==55) ) {
                alt49=1;
            }
            switch (alt49) {
                case 1 :
                    // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:2739:1: (lv_i18NLabel_10_0= 'I18N' )
                    {
                    // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:2739:1: (lv_i18NLabel_10_0= 'I18N' )
                    // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:2740:3: lv_i18NLabel_10_0= 'I18N'
                    {
                    lv_i18NLabel_10_0=(Token)match(input,55,FOLLOW_55_in_ruleWidgetConfigurationMdsl5875); 

                            newLeafNode(lv_i18NLabel_10_0, grammarAccess.getWidgetConfigurationMdslAccess().getI18NLabelI18NKeyword_5_0());
                        

                    	        if (current==null) {
                    	            current = createModelElement(grammarAccess.getWidgetConfigurationMdslRule());
                    	        }
                           		setWithLastConsumed(current, "i18NLabel", true, "I18N");
                    	    

                    }


                    }
                    break;

            }

            otherlv_11=(Token)match(input,13,FOLLOW_13_in_ruleWidgetConfigurationMdsl5901); 

                	newLeafNode(otherlv_11, grammarAccess.getWidgetConfigurationMdslAccess().getLabelKeyword_6());
                
            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:2757:1: ( (lv_label_12_0= ruleFormatExpr ) )
            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:2758:1: (lv_label_12_0= ruleFormatExpr )
            {
            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:2758:1: (lv_label_12_0= ruleFormatExpr )
            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:2759:3: lv_label_12_0= ruleFormatExpr
            {
             
            	        newCompositeNode(grammarAccess.getWidgetConfigurationMdslAccess().getLabelFormatExprParserRuleCall_7_0()); 
            	    
            pushFollow(FOLLOW_ruleFormatExpr_in_ruleWidgetConfigurationMdsl5922);
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

            otherlv_13=(Token)match(input,73,FOLLOW_73_in_ruleWidgetConfigurationMdsl5934); 

                	newLeafNode(otherlv_13, grammarAccess.getWidgetConfigurationMdslAccess().getTypeKeyword_8());
                
            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:2779:1: ( (lv_widgetCategory_14_0= ruleWIDGET_CATEGORY_MDSL ) )
            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:2780:1: (lv_widgetCategory_14_0= ruleWIDGET_CATEGORY_MDSL )
            {
            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:2780:1: (lv_widgetCategory_14_0= ruleWIDGET_CATEGORY_MDSL )
            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:2781:3: lv_widgetCategory_14_0= ruleWIDGET_CATEGORY_MDSL
            {
             
            	        newCompositeNode(grammarAccess.getWidgetConfigurationMdslAccess().getWidgetCategoryWIDGET_CATEGORY_MDSLEnumRuleCall_9_0()); 
            	    
            pushFollow(FOLLOW_ruleWIDGET_CATEGORY_MDSL_in_ruleWidgetConfigurationMdsl5955);
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

            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:2797:2: (otherlv_15= ':' ( (otherlv_16= RULE_ID ) ) )?
            int alt50=2;
            int LA50_0 = input.LA(1);

            if ( (LA50_0==27) ) {
                alt50=1;
            }
            switch (alt50) {
                case 1 :
                    // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:2797:4: otherlv_15= ':' ( (otherlv_16= RULE_ID ) )
                    {
                    otherlv_15=(Token)match(input,27,FOLLOW_27_in_ruleWidgetConfigurationMdsl5968); 

                        	newLeafNode(otherlv_15, grammarAccess.getWidgetConfigurationMdslAccess().getColonKeyword_10_0());
                        
                    // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:2801:1: ( (otherlv_16= RULE_ID ) )
                    // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:2802:1: (otherlv_16= RULE_ID )
                    {
                    // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:2802:1: (otherlv_16= RULE_ID )
                    // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:2803:3: otherlv_16= RULE_ID
                    {

                    			if (current==null) {
                    	            current = createModelElement(grammarAccess.getWidgetConfigurationMdslRule());
                    	        }
                            
                    otherlv_16=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleWidgetConfigurationMdsl5988); 

                    		newLeafNode(otherlv_16, grammarAccess.getWidgetConfigurationMdslAccess().getWidgetTypeWidgetTypeCrossReference_10_1_0()); 
                    	

                    }


                    }


                    }
                    break;

            }

            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:2814:4: ( (lv_dslReference_17_0= ruleXtextLanguageReference ) )?
            int alt51=2;
            int LA51_0 = input.LA(1);

            if ( (LA51_0==40) ) {
                alt51=1;
            }
            switch (alt51) {
                case 1 :
                    // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:2815:1: (lv_dslReference_17_0= ruleXtextLanguageReference )
                    {
                    // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:2815:1: (lv_dslReference_17_0= ruleXtextLanguageReference )
                    // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:2816:3: lv_dslReference_17_0= ruleXtextLanguageReference
                    {
                     
                    	        newCompositeNode(grammarAccess.getWidgetConfigurationMdslAccess().getDslReferenceXtextLanguageReferenceParserRuleCall_11_0()); 
                    	    
                    pushFollow(FOLLOW_ruleXtextLanguageReference_in_ruleWidgetConfigurationMdsl6011);
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

            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:2832:3: ( (otherlv_18= 'flexible template:' | otherlv_19= 'target template:' ) ( (otherlv_20= RULE_ID ) ) )?
            int alt53=2;
            int LA53_0 = input.LA(1);

            if ( ((LA53_0>=74 && LA53_0<=75)) ) {
                alt53=1;
            }
            switch (alt53) {
                case 1 :
                    // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:2832:4: (otherlv_18= 'flexible template:' | otherlv_19= 'target template:' ) ( (otherlv_20= RULE_ID ) )
                    {
                    // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:2832:4: (otherlv_18= 'flexible template:' | otherlv_19= 'target template:' )
                    int alt52=2;
                    int LA52_0 = input.LA(1);

                    if ( (LA52_0==74) ) {
                        alt52=1;
                    }
                    else if ( (LA52_0==75) ) {
                        alt52=2;
                    }
                    else {
                        NoViableAltException nvae =
                            new NoViableAltException("", 52, 0, input);

                        throw nvae;
                    }
                    switch (alt52) {
                        case 1 :
                            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:2832:6: otherlv_18= 'flexible template:'
                            {
                            otherlv_18=(Token)match(input,74,FOLLOW_74_in_ruleWidgetConfigurationMdsl6026); 

                                	newLeafNode(otherlv_18, grammarAccess.getWidgetConfigurationMdslAccess().getFlexibleTemplateKeyword_12_0_0());
                                

                            }
                            break;
                        case 2 :
                            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:2837:7: otherlv_19= 'target template:'
                            {
                            otherlv_19=(Token)match(input,75,FOLLOW_75_in_ruleWidgetConfigurationMdsl6044); 

                                	newLeafNode(otherlv_19, grammarAccess.getWidgetConfigurationMdslAccess().getTargetTemplateKeyword_12_0_1());
                                

                            }
                            break;

                    }

                    // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:2841:2: ( (otherlv_20= RULE_ID ) )
                    // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:2842:1: (otherlv_20= RULE_ID )
                    {
                    // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:2842:1: (otherlv_20= RULE_ID )
                    // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:2843:3: otherlv_20= RULE_ID
                    {

                    			if (current==null) {
                    	            current = createModelElement(grammarAccess.getWidgetConfigurationMdslRule());
                    	        }
                            
                    otherlv_20=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleWidgetConfigurationMdsl6065); 

                    		newLeafNode(otherlv_20, grammarAccess.getWidgetConfigurationMdslAccess().getFlexibleTemplateTypeConfigurationMdslCrossReference_12_1_0()); 
                    	

                    }


                    }


                    }
                    break;

            }

            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:2854:4: ( ( ( ( ({...}? => ( ({...}? => (otherlv_22= 'visible when:' ( (lv_visibilityQuery_23_0= ruleQuery ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_24= 'editable when:' ( (lv_editableQuery_25_0= ruleQuery ) ) ) ) ) ) )* ) ) )
            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:2856:1: ( ( ( ({...}? => ( ({...}? => (otherlv_22= 'visible when:' ( (lv_visibilityQuery_23_0= ruleQuery ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_24= 'editable when:' ( (lv_editableQuery_25_0= ruleQuery ) ) ) ) ) ) )* ) )
            {
            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:2856:1: ( ( ( ({...}? => ( ({...}? => (otherlv_22= 'visible when:' ( (lv_visibilityQuery_23_0= ruleQuery ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_24= 'editable when:' ( (lv_editableQuery_25_0= ruleQuery ) ) ) ) ) ) )* ) )
            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:2857:2: ( ( ({...}? => ( ({...}? => (otherlv_22= 'visible when:' ( (lv_visibilityQuery_23_0= ruleQuery ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_24= 'editable when:' ( (lv_editableQuery_25_0= ruleQuery ) ) ) ) ) ) )* )
            {
             
            	  getUnorderedGroupHelper().enter(grammarAccess.getWidgetConfigurationMdslAccess().getUnorderedGroup_13());
            	
            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:2860:2: ( ( ({...}? => ( ({...}? => (otherlv_22= 'visible when:' ( (lv_visibilityQuery_23_0= ruleQuery ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_24= 'editable when:' ( (lv_editableQuery_25_0= ruleQuery ) ) ) ) ) ) )* )
            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:2861:3: ( ({...}? => ( ({...}? => (otherlv_22= 'visible when:' ( (lv_visibilityQuery_23_0= ruleQuery ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_24= 'editable when:' ( (lv_editableQuery_25_0= ruleQuery ) ) ) ) ) ) )*
            {
            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:2861:3: ( ({...}? => ( ({...}? => (otherlv_22= 'visible when:' ( (lv_visibilityQuery_23_0= ruleQuery ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_24= 'editable when:' ( (lv_editableQuery_25_0= ruleQuery ) ) ) ) ) ) )*
            loop54:
            do {
                int alt54=3;
                int LA54_0 = input.LA(1);

                if ( LA54_0 ==76 && getUnorderedGroupHelper().canSelect(grammarAccess.getWidgetConfigurationMdslAccess().getUnorderedGroup_13(), 0) ) {
                    alt54=1;
                }
                else if ( LA54_0 ==77 && getUnorderedGroupHelper().canSelect(grammarAccess.getWidgetConfigurationMdslAccess().getUnorderedGroup_13(), 1) ) {
                    alt54=2;
                }


                switch (alt54) {
            	case 1 :
            	    // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:2863:4: ({...}? => ( ({...}? => (otherlv_22= 'visible when:' ( (lv_visibilityQuery_23_0= ruleQuery ) ) ) ) ) )
            	    {
            	    // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:2863:4: ({...}? => ( ({...}? => (otherlv_22= 'visible when:' ( (lv_visibilityQuery_23_0= ruleQuery ) ) ) ) ) )
            	    // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:2864:5: {...}? => ( ({...}? => (otherlv_22= 'visible when:' ( (lv_visibilityQuery_23_0= ruleQuery ) ) ) ) )
            	    {
            	    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getWidgetConfigurationMdslAccess().getUnorderedGroup_13(), 0) ) {
            	        throw new FailedPredicateException(input, "ruleWidgetConfigurationMdsl", "getUnorderedGroupHelper().canSelect(grammarAccess.getWidgetConfigurationMdslAccess().getUnorderedGroup_13(), 0)");
            	    }
            	    // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:2864:121: ( ({...}? => (otherlv_22= 'visible when:' ( (lv_visibilityQuery_23_0= ruleQuery ) ) ) ) )
            	    // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:2865:6: ({...}? => (otherlv_22= 'visible when:' ( (lv_visibilityQuery_23_0= ruleQuery ) ) ) )
            	    {
            	     
            	    	 				  getUnorderedGroupHelper().select(grammarAccess.getWidgetConfigurationMdslAccess().getUnorderedGroup_13(), 0);
            	    	 				
            	    // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:2868:6: ({...}? => (otherlv_22= 'visible when:' ( (lv_visibilityQuery_23_0= ruleQuery ) ) ) )
            	    // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:2868:7: {...}? => (otherlv_22= 'visible when:' ( (lv_visibilityQuery_23_0= ruleQuery ) ) )
            	    {
            	    if ( !((true)) ) {
            	        throw new FailedPredicateException(input, "ruleWidgetConfigurationMdsl", "true");
            	    }
            	    // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:2868:16: (otherlv_22= 'visible when:' ( (lv_visibilityQuery_23_0= ruleQuery ) ) )
            	    // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:2868:18: otherlv_22= 'visible when:' ( (lv_visibilityQuery_23_0= ruleQuery ) )
            	    {
            	    otherlv_22=(Token)match(input,76,FOLLOW_76_in_ruleWidgetConfigurationMdsl6125); 

            	        	newLeafNode(otherlv_22, grammarAccess.getWidgetConfigurationMdslAccess().getVisibleWhenKeyword_13_0_0());
            	        
            	    // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:2872:1: ( (lv_visibilityQuery_23_0= ruleQuery ) )
            	    // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:2873:1: (lv_visibilityQuery_23_0= ruleQuery )
            	    {
            	    // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:2873:1: (lv_visibilityQuery_23_0= ruleQuery )
            	    // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:2874:3: lv_visibilityQuery_23_0= ruleQuery
            	    {
            	     
            	    	        newCompositeNode(grammarAccess.getWidgetConfigurationMdslAccess().getVisibilityQueryQueryParserRuleCall_13_0_1_0()); 
            	    	    
            	    pushFollow(FOLLOW_ruleQuery_in_ruleWidgetConfigurationMdsl6146);
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
            	    // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:2897:4: ({...}? => ( ({...}? => (otherlv_24= 'editable when:' ( (lv_editableQuery_25_0= ruleQuery ) ) ) ) ) )
            	    {
            	    // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:2897:4: ({...}? => ( ({...}? => (otherlv_24= 'editable when:' ( (lv_editableQuery_25_0= ruleQuery ) ) ) ) ) )
            	    // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:2898:5: {...}? => ( ({...}? => (otherlv_24= 'editable when:' ( (lv_editableQuery_25_0= ruleQuery ) ) ) ) )
            	    {
            	    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getWidgetConfigurationMdslAccess().getUnorderedGroup_13(), 1) ) {
            	        throw new FailedPredicateException(input, "ruleWidgetConfigurationMdsl", "getUnorderedGroupHelper().canSelect(grammarAccess.getWidgetConfigurationMdslAccess().getUnorderedGroup_13(), 1)");
            	    }
            	    // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:2898:121: ( ({...}? => (otherlv_24= 'editable when:' ( (lv_editableQuery_25_0= ruleQuery ) ) ) ) )
            	    // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:2899:6: ({...}? => (otherlv_24= 'editable when:' ( (lv_editableQuery_25_0= ruleQuery ) ) ) )
            	    {
            	     
            	    	 				  getUnorderedGroupHelper().select(grammarAccess.getWidgetConfigurationMdslAccess().getUnorderedGroup_13(), 1);
            	    	 				
            	    // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:2902:6: ({...}? => (otherlv_24= 'editable when:' ( (lv_editableQuery_25_0= ruleQuery ) ) ) )
            	    // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:2902:7: {...}? => (otherlv_24= 'editable when:' ( (lv_editableQuery_25_0= ruleQuery ) ) )
            	    {
            	    if ( !((true)) ) {
            	        throw new FailedPredicateException(input, "ruleWidgetConfigurationMdsl", "true");
            	    }
            	    // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:2902:16: (otherlv_24= 'editable when:' ( (lv_editableQuery_25_0= ruleQuery ) ) )
            	    // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:2902:18: otherlv_24= 'editable when:' ( (lv_editableQuery_25_0= ruleQuery ) )
            	    {
            	    otherlv_24=(Token)match(input,77,FOLLOW_77_in_ruleWidgetConfigurationMdsl6214); 

            	        	newLeafNode(otherlv_24, grammarAccess.getWidgetConfigurationMdslAccess().getEditableWhenKeyword_13_1_0());
            	        
            	    // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:2906:1: ( (lv_editableQuery_25_0= ruleQuery ) )
            	    // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:2907:1: (lv_editableQuery_25_0= ruleQuery )
            	    {
            	    // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:2907:1: (lv_editableQuery_25_0= ruleQuery )
            	    // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:2908:3: lv_editableQuery_25_0= ruleQuery
            	    {
            	     
            	    	        newCompositeNode(grammarAccess.getWidgetConfigurationMdslAccess().getEditableQueryQueryParserRuleCall_13_1_1_0()); 
            	    	    
            	    pushFollow(FOLLOW_ruleQuery_in_ruleWidgetConfigurationMdsl6235);
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
            	    break loop54;
                }
            } while (true);


            }


            }

             
            	  getUnorderedGroupHelper().leave(grammarAccess.getWidgetConfigurationMdslAccess().getUnorderedGroup_13());
            	

            }

            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:2938:2: (otherlv_26= 'value:' ( (lv_valueQuery_27_0= ruleQueryUsage ) ) )?
            int alt55=2;
            int LA55_0 = input.LA(1);

            if ( (LA55_0==68) ) {
                alt55=1;
            }
            switch (alt55) {
                case 1 :
                    // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:2938:4: otherlv_26= 'value:' ( (lv_valueQuery_27_0= ruleQueryUsage ) )
                    {
                    otherlv_26=(Token)match(input,68,FOLLOW_68_in_ruleWidgetConfigurationMdsl6289); 

                        	newLeafNode(otherlv_26, grammarAccess.getWidgetConfigurationMdslAccess().getValueKeyword_14_0());
                        
                    // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:2942:1: ( (lv_valueQuery_27_0= ruleQueryUsage ) )
                    // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:2943:1: (lv_valueQuery_27_0= ruleQueryUsage )
                    {
                    // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:2943:1: (lv_valueQuery_27_0= ruleQueryUsage )
                    // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:2944:3: lv_valueQuery_27_0= ruleQueryUsage
                    {
                     
                    	        newCompositeNode(grammarAccess.getWidgetConfigurationMdslAccess().getValueQueryQueryUsageParserRuleCall_14_1_0()); 
                    	    
                    pushFollow(FOLLOW_ruleQueryUsage_in_ruleWidgetConfigurationMdsl6310);
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

            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:2960:4: (otherlv_28= 'valueConverter:' ( (lv_valueConverter_29_0= ruleValueConverter ) ) )?
            int alt56=2;
            int LA56_0 = input.LA(1);

            if ( (LA56_0==78) ) {
                alt56=1;
            }
            switch (alt56) {
                case 1 :
                    // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:2960:6: otherlv_28= 'valueConverter:' ( (lv_valueConverter_29_0= ruleValueConverter ) )
                    {
                    otherlv_28=(Token)match(input,78,FOLLOW_78_in_ruleWidgetConfigurationMdsl6325); 

                        	newLeafNode(otherlv_28, grammarAccess.getWidgetConfigurationMdslAccess().getValueConverterKeyword_15_0());
                        
                    // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:2964:1: ( (lv_valueConverter_29_0= ruleValueConverter ) )
                    // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:2965:1: (lv_valueConverter_29_0= ruleValueConverter )
                    {
                    // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:2965:1: (lv_valueConverter_29_0= ruleValueConverter )
                    // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:2966:3: lv_valueConverter_29_0= ruleValueConverter
                    {
                     
                    	        newCompositeNode(grammarAccess.getWidgetConfigurationMdslAccess().getValueConverterValueConverterParserRuleCall_15_1_0()); 
                    	    
                    pushFollow(FOLLOW_ruleValueConverter_in_ruleWidgetConfigurationMdsl6346);
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

            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:2982:4: (otherlv_30= 'validators:' ( (lv_validators_31_0= ruleValidatorMdsl ) )* )?
            int alt58=2;
            int LA58_0 = input.LA(1);

            if ( (LA58_0==79) ) {
                alt58=1;
            }
            switch (alt58) {
                case 1 :
                    // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:2982:6: otherlv_30= 'validators:' ( (lv_validators_31_0= ruleValidatorMdsl ) )*
                    {
                    otherlv_30=(Token)match(input,79,FOLLOW_79_in_ruleWidgetConfigurationMdsl6361); 

                        	newLeafNode(otherlv_30, grammarAccess.getWidgetConfigurationMdslAccess().getValidatorsKeyword_16_0());
                        
                    // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:2986:1: ( (lv_validators_31_0= ruleValidatorMdsl ) )*
                    loop57:
                    do {
                        int alt57=2;
                        int LA57_0 = input.LA(1);

                        if ( (LA57_0==84) ) {
                            alt57=1;
                        }


                        switch (alt57) {
                    	case 1 :
                    	    // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:2987:1: (lv_validators_31_0= ruleValidatorMdsl )
                    	    {
                    	    // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:2987:1: (lv_validators_31_0= ruleValidatorMdsl )
                    	    // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:2988:3: lv_validators_31_0= ruleValidatorMdsl
                    	    {
                    	     
                    	    	        newCompositeNode(grammarAccess.getWidgetConfigurationMdslAccess().getValidatorsValidatorMdslParserRuleCall_16_1_0()); 
                    	    	    
                    	    pushFollow(FOLLOW_ruleValidatorMdsl_in_ruleWidgetConfigurationMdsl6382);
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
                    	    break loop57;
                        }
                    } while (true);


                    }
                    break;

            }

            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:3004:5: ( ( (lv_i18NFormat_32_0= 'I18N' ) )? otherlv_33= 'format:' ( (lv_valueFormat_34_0= ruleFormatExpr ) ) )?
            int alt60=2;
            int LA60_0 = input.LA(1);

            if ( (LA60_0==55) ) {
                int LA60_1 = input.LA(2);

                if ( (LA60_1==80) ) {
                    alt60=1;
                }
            }
            else if ( (LA60_0==80) ) {
                alt60=1;
            }
            switch (alt60) {
                case 1 :
                    // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:3004:6: ( (lv_i18NFormat_32_0= 'I18N' ) )? otherlv_33= 'format:' ( (lv_valueFormat_34_0= ruleFormatExpr ) )
                    {
                    // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:3004:6: ( (lv_i18NFormat_32_0= 'I18N' ) )?
                    int alt59=2;
                    int LA59_0 = input.LA(1);

                    if ( (LA59_0==55) ) {
                        alt59=1;
                    }
                    switch (alt59) {
                        case 1 :
                            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:3005:1: (lv_i18NFormat_32_0= 'I18N' )
                            {
                            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:3005:1: (lv_i18NFormat_32_0= 'I18N' )
                            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:3006:3: lv_i18NFormat_32_0= 'I18N'
                            {
                            lv_i18NFormat_32_0=(Token)match(input,55,FOLLOW_55_in_ruleWidgetConfigurationMdsl6404); 

                                    newLeafNode(lv_i18NFormat_32_0, grammarAccess.getWidgetConfigurationMdslAccess().getI18NFormatI18NKeyword_17_0_0());
                                

                            	        if (current==null) {
                            	            current = createModelElement(grammarAccess.getWidgetConfigurationMdslRule());
                            	        }
                                   		setWithLastConsumed(current, "i18NFormat", true, "I18N");
                            	    

                            }


                            }
                            break;

                    }

                    otherlv_33=(Token)match(input,80,FOLLOW_80_in_ruleWidgetConfigurationMdsl6430); 

                        	newLeafNode(otherlv_33, grammarAccess.getWidgetConfigurationMdslAccess().getFormatKeyword_17_1());
                        
                    // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:3023:1: ( (lv_valueFormat_34_0= ruleFormatExpr ) )
                    // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:3024:1: (lv_valueFormat_34_0= ruleFormatExpr )
                    {
                    // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:3024:1: (lv_valueFormat_34_0= ruleFormatExpr )
                    // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:3025:3: lv_valueFormat_34_0= ruleFormatExpr
                    {
                     
                    	        newCompositeNode(grammarAccess.getWidgetConfigurationMdslAccess().getValueFormatFormatExprParserRuleCall_17_2_0()); 
                    	    
                    pushFollow(FOLLOW_ruleFormatExpr_in_ruleWidgetConfigurationMdsl6451);
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

            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:3041:4: (otherlv_35= 'candidates:' ( (lv_candidatesQuery_36_0= ruleQueryUsage ) ) )?
            int alt61=2;
            int LA61_0 = input.LA(1);

            if ( (LA61_0==81) ) {
                alt61=1;
            }
            switch (alt61) {
                case 1 :
                    // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:3041:6: otherlv_35= 'candidates:' ( (lv_candidatesQuery_36_0= ruleQueryUsage ) )
                    {
                    otherlv_35=(Token)match(input,81,FOLLOW_81_in_ruleWidgetConfigurationMdsl6466); 

                        	newLeafNode(otherlv_35, grammarAccess.getWidgetConfigurationMdslAccess().getCandidatesKeyword_18_0());
                        
                    // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:3045:1: ( (lv_candidatesQuery_36_0= ruleQueryUsage ) )
                    // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:3046:1: (lv_candidatesQuery_36_0= ruleQueryUsage )
                    {
                    // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:3046:1: (lv_candidatesQuery_36_0= ruleQueryUsage )
                    // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:3047:3: lv_candidatesQuery_36_0= ruleQueryUsage
                    {
                     
                    	        newCompositeNode(grammarAccess.getWidgetConfigurationMdslAccess().getCandidatesQueryQueryUsageParserRuleCall_18_1_0()); 
                    	    
                    pushFollow(FOLLOW_ruleQueryUsage_in_ruleWidgetConfigurationMdsl6487);
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

            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:3063:4: ( ( (lv_i18NItemLabel_37_0= 'I18N' ) )? otherlv_38= 'item label:' ( (lv_itemLabelExpression_39_0= ruleFormatExpr ) ) )?
            int alt63=2;
            int LA63_0 = input.LA(1);

            if ( (LA63_0==55||LA63_0==82) ) {
                alt63=1;
            }
            switch (alt63) {
                case 1 :
                    // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:3063:5: ( (lv_i18NItemLabel_37_0= 'I18N' ) )? otherlv_38= 'item label:' ( (lv_itemLabelExpression_39_0= ruleFormatExpr ) )
                    {
                    // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:3063:5: ( (lv_i18NItemLabel_37_0= 'I18N' ) )?
                    int alt62=2;
                    int LA62_0 = input.LA(1);

                    if ( (LA62_0==55) ) {
                        alt62=1;
                    }
                    switch (alt62) {
                        case 1 :
                            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:3064:1: (lv_i18NItemLabel_37_0= 'I18N' )
                            {
                            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:3064:1: (lv_i18NItemLabel_37_0= 'I18N' )
                            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:3065:3: lv_i18NItemLabel_37_0= 'I18N'
                            {
                            lv_i18NItemLabel_37_0=(Token)match(input,55,FOLLOW_55_in_ruleWidgetConfigurationMdsl6508); 

                                    newLeafNode(lv_i18NItemLabel_37_0, grammarAccess.getWidgetConfigurationMdslAccess().getI18NItemLabelI18NKeyword_19_0_0());
                                

                            	        if (current==null) {
                            	            current = createModelElement(grammarAccess.getWidgetConfigurationMdslRule());
                            	        }
                                   		setWithLastConsumed(current, "i18NItemLabel", true, "I18N");
                            	    

                            }


                            }
                            break;

                    }

                    otherlv_38=(Token)match(input,82,FOLLOW_82_in_ruleWidgetConfigurationMdsl6534); 

                        	newLeafNode(otherlv_38, grammarAccess.getWidgetConfigurationMdslAccess().getItemLabelKeyword_19_1());
                        
                    // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:3082:1: ( (lv_itemLabelExpression_39_0= ruleFormatExpr ) )
                    // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:3083:1: (lv_itemLabelExpression_39_0= ruleFormatExpr )
                    {
                    // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:3083:1: (lv_itemLabelExpression_39_0= ruleFormatExpr )
                    // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:3084:3: lv_itemLabelExpression_39_0= ruleFormatExpr
                    {
                     
                    	        newCompositeNode(grammarAccess.getWidgetConfigurationMdslAccess().getItemLabelExpressionFormatExprParserRuleCall_19_2_0()); 
                    	    
                    pushFollow(FOLLOW_ruleFormatExpr_in_ruleWidgetConfigurationMdsl6555);
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

            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:3100:4: (otherlv_40= 'commands:' ( (lv_commands_41_0= ruleCommand ) ) (otherlv_42= ',' ( (lv_commands_43_0= ruleCommand ) ) )* )?
            int alt65=2;
            int LA65_0 = input.LA(1);

            if ( (LA65_0==83) ) {
                alt65=1;
            }
            switch (alt65) {
                case 1 :
                    // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:3100:6: otherlv_40= 'commands:' ( (lv_commands_41_0= ruleCommand ) ) (otherlv_42= ',' ( (lv_commands_43_0= ruleCommand ) ) )*
                    {
                    otherlv_40=(Token)match(input,83,FOLLOW_83_in_ruleWidgetConfigurationMdsl6570); 

                        	newLeafNode(otherlv_40, grammarAccess.getWidgetConfigurationMdslAccess().getCommandsKeyword_20_0());
                        
                    // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:3104:1: ( (lv_commands_41_0= ruleCommand ) )
                    // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:3105:1: (lv_commands_41_0= ruleCommand )
                    {
                    // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:3105:1: (lv_commands_41_0= ruleCommand )
                    // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:3106:3: lv_commands_41_0= ruleCommand
                    {
                     
                    	        newCompositeNode(grammarAccess.getWidgetConfigurationMdslAccess().getCommandsCommandParserRuleCall_20_1_0()); 
                    	    
                    pushFollow(FOLLOW_ruleCommand_in_ruleWidgetConfigurationMdsl6591);
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

                    // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:3122:2: (otherlv_42= ',' ( (lv_commands_43_0= ruleCommand ) ) )*
                    loop64:
                    do {
                        int alt64=2;
                        int LA64_0 = input.LA(1);

                        if ( (LA64_0==35) ) {
                            alt64=1;
                        }


                        switch (alt64) {
                    	case 1 :
                    	    // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:3122:4: otherlv_42= ',' ( (lv_commands_43_0= ruleCommand ) )
                    	    {
                    	    otherlv_42=(Token)match(input,35,FOLLOW_35_in_ruleWidgetConfigurationMdsl6604); 

                    	        	newLeafNode(otherlv_42, grammarAccess.getWidgetConfigurationMdslAccess().getCommaKeyword_20_2_0());
                    	        
                    	    // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:3126:1: ( (lv_commands_43_0= ruleCommand ) )
                    	    // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:3127:1: (lv_commands_43_0= ruleCommand )
                    	    {
                    	    // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:3127:1: (lv_commands_43_0= ruleCommand )
                    	    // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:3128:3: lv_commands_43_0= ruleCommand
                    	    {
                    	     
                    	    	        newCompositeNode(grammarAccess.getWidgetConfigurationMdslAccess().getCommandsCommandParserRuleCall_20_2_1_0()); 
                    	    	    
                    	    pushFollow(FOLLOW_ruleCommand_in_ruleWidgetConfigurationMdsl6625);
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
                    	    break loop64;
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
    // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:3152:1: entryRuleValidatorMdsl returns [EObject current=null] : iv_ruleValidatorMdsl= ruleValidatorMdsl EOF ;
    public final EObject entryRuleValidatorMdsl() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleValidatorMdsl = null;


        try {
            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:3153:2: (iv_ruleValidatorMdsl= ruleValidatorMdsl EOF )
            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:3154:2: iv_ruleValidatorMdsl= ruleValidatorMdsl EOF
            {
             newCompositeNode(grammarAccess.getValidatorMdslRule()); 
            pushFollow(FOLLOW_ruleValidatorMdsl_in_entryRuleValidatorMdsl6665);
            iv_ruleValidatorMdsl=ruleValidatorMdsl();

            state._fsp--;

             current =iv_ruleValidatorMdsl; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleValidatorMdsl6675); 

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
    // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:3161:1: ruleValidatorMdsl returns [EObject current=null] : (otherlv_0= 'validation rule:' ( (lv_validationQuery_1_0= ruleQueryUsage ) ) ( (lv_i18NMessage_2_0= 'I18N' ) )? otherlv_3= 'Error message:' ( (lv_errorMessageExpr_4_0= ruleFormatExpr ) ) ) ;
    public final EObject ruleValidatorMdsl() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token lv_i18NMessage_2_0=null;
        Token otherlv_3=null;
        EObject lv_validationQuery_1_0 = null;

        EObject lv_errorMessageExpr_4_0 = null;


         enterRule(); 
            
        try {
            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:3164:28: ( (otherlv_0= 'validation rule:' ( (lv_validationQuery_1_0= ruleQueryUsage ) ) ( (lv_i18NMessage_2_0= 'I18N' ) )? otherlv_3= 'Error message:' ( (lv_errorMessageExpr_4_0= ruleFormatExpr ) ) ) )
            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:3165:1: (otherlv_0= 'validation rule:' ( (lv_validationQuery_1_0= ruleQueryUsage ) ) ( (lv_i18NMessage_2_0= 'I18N' ) )? otherlv_3= 'Error message:' ( (lv_errorMessageExpr_4_0= ruleFormatExpr ) ) )
            {
            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:3165:1: (otherlv_0= 'validation rule:' ( (lv_validationQuery_1_0= ruleQueryUsage ) ) ( (lv_i18NMessage_2_0= 'I18N' ) )? otherlv_3= 'Error message:' ( (lv_errorMessageExpr_4_0= ruleFormatExpr ) ) )
            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:3165:3: otherlv_0= 'validation rule:' ( (lv_validationQuery_1_0= ruleQueryUsage ) ) ( (lv_i18NMessage_2_0= 'I18N' ) )? otherlv_3= 'Error message:' ( (lv_errorMessageExpr_4_0= ruleFormatExpr ) )
            {
            otherlv_0=(Token)match(input,84,FOLLOW_84_in_ruleValidatorMdsl6712); 

                	newLeafNode(otherlv_0, grammarAccess.getValidatorMdslAccess().getValidationRuleKeyword_0());
                
            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:3169:1: ( (lv_validationQuery_1_0= ruleQueryUsage ) )
            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:3170:1: (lv_validationQuery_1_0= ruleQueryUsage )
            {
            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:3170:1: (lv_validationQuery_1_0= ruleQueryUsage )
            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:3171:3: lv_validationQuery_1_0= ruleQueryUsage
            {
             
            	        newCompositeNode(grammarAccess.getValidatorMdslAccess().getValidationQueryQueryUsageParserRuleCall_1_0()); 
            	    
            pushFollow(FOLLOW_ruleQueryUsage_in_ruleValidatorMdsl6733);
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

            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:3187:2: ( (lv_i18NMessage_2_0= 'I18N' ) )?
            int alt66=2;
            int LA66_0 = input.LA(1);

            if ( (LA66_0==55) ) {
                alt66=1;
            }
            switch (alt66) {
                case 1 :
                    // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:3188:1: (lv_i18NMessage_2_0= 'I18N' )
                    {
                    // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:3188:1: (lv_i18NMessage_2_0= 'I18N' )
                    // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:3189:3: lv_i18NMessage_2_0= 'I18N'
                    {
                    lv_i18NMessage_2_0=(Token)match(input,55,FOLLOW_55_in_ruleValidatorMdsl6751); 

                            newLeafNode(lv_i18NMessage_2_0, grammarAccess.getValidatorMdslAccess().getI18NMessageI18NKeyword_2_0());
                        

                    	        if (current==null) {
                    	            current = createModelElement(grammarAccess.getValidatorMdslRule());
                    	        }
                           		setWithLastConsumed(current, "i18NMessage", true, "I18N");
                    	    

                    }


                    }
                    break;

            }

            otherlv_3=(Token)match(input,85,FOLLOW_85_in_ruleValidatorMdsl6777); 

                	newLeafNode(otherlv_3, grammarAccess.getValidatorMdslAccess().getErrorMessageKeyword_3());
                
            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:3206:1: ( (lv_errorMessageExpr_4_0= ruleFormatExpr ) )
            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:3207:1: (lv_errorMessageExpr_4_0= ruleFormatExpr )
            {
            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:3207:1: (lv_errorMessageExpr_4_0= ruleFormatExpr )
            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:3208:3: lv_errorMessageExpr_4_0= ruleFormatExpr
            {
             
            	        newCompositeNode(grammarAccess.getValidatorMdslAccess().getErrorMessageExprFormatExprParserRuleCall_4_0()); 
            	    
            pushFollow(FOLLOW_ruleFormatExpr_in_ruleValidatorMdsl6798);
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
    // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:3232:1: entryRuleCommand returns [EObject current=null] : iv_ruleCommand= ruleCommand EOF ;
    public final EObject entryRuleCommand() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleCommand = null;


        try {
            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:3233:2: (iv_ruleCommand= ruleCommand EOF )
            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:3234:2: iv_ruleCommand= ruleCommand EOF
            {
             newCompositeNode(grammarAccess.getCommandRule()); 
            pushFollow(FOLLOW_ruleCommand_in_entryRuleCommand6834);
            iv_ruleCommand=ruleCommand();

            state._fsp--;

             current =iv_ruleCommand; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleCommand6844); 

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
    // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:3241:1: ruleCommand returns [EObject current=null] : (this_CommandDefinitionMdsl_0= ruleCommandDefinitionMdsl | this_CommandRefMdsl_1= ruleCommandRefMdsl ) ;
    public final EObject ruleCommand() throws RecognitionException {
        EObject current = null;

        EObject this_CommandDefinitionMdsl_0 = null;

        EObject this_CommandRefMdsl_1 = null;


         enterRule(); 
            
        try {
            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:3244:28: ( (this_CommandDefinitionMdsl_0= ruleCommandDefinitionMdsl | this_CommandRefMdsl_1= ruleCommandRefMdsl ) )
            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:3245:1: (this_CommandDefinitionMdsl_0= ruleCommandDefinitionMdsl | this_CommandRefMdsl_1= ruleCommandRefMdsl )
            {
            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:3245:1: (this_CommandDefinitionMdsl_0= ruleCommandDefinitionMdsl | this_CommandRefMdsl_1= ruleCommandRefMdsl )
            int alt67=2;
            int LA67_0 = input.LA(1);

            if ( ((LA67_0>=125 && LA67_0<=127)) ) {
                alt67=1;
            }
            else if ( (LA67_0==RULE_ID) ) {
                alt67=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 67, 0, input);

                throw nvae;
            }
            switch (alt67) {
                case 1 :
                    // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:3246:5: this_CommandDefinitionMdsl_0= ruleCommandDefinitionMdsl
                    {
                     
                            newCompositeNode(grammarAccess.getCommandAccess().getCommandDefinitionMdslParserRuleCall_0()); 
                        
                    pushFollow(FOLLOW_ruleCommandDefinitionMdsl_in_ruleCommand6891);
                    this_CommandDefinitionMdsl_0=ruleCommandDefinitionMdsl();

                    state._fsp--;

                     
                            current = this_CommandDefinitionMdsl_0; 
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;
                case 2 :
                    // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:3256:5: this_CommandRefMdsl_1= ruleCommandRefMdsl
                    {
                     
                            newCompositeNode(grammarAccess.getCommandAccess().getCommandRefMdslParserRuleCall_1()); 
                        
                    pushFollow(FOLLOW_ruleCommandRefMdsl_in_ruleCommand6918);
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
    // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:3272:1: entryRuleCommandDeclaration returns [EObject current=null] : iv_ruleCommandDeclaration= ruleCommandDeclaration EOF ;
    public final EObject entryRuleCommandDeclaration() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleCommandDeclaration = null;


        try {
            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:3273:2: (iv_ruleCommandDeclaration= ruleCommandDeclaration EOF )
            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:3274:2: iv_ruleCommandDeclaration= ruleCommandDeclaration EOF
            {
             newCompositeNode(grammarAccess.getCommandDeclarationRule()); 
            pushFollow(FOLLOW_ruleCommandDeclaration_in_entryRuleCommandDeclaration6953);
            iv_ruleCommandDeclaration=ruleCommandDeclaration();

            state._fsp--;

             current =iv_ruleCommandDeclaration; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleCommandDeclaration6963); 

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
    // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:3281:1: ruleCommandDeclaration returns [EObject current=null] : (otherlv_0= 'Common Command' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' (otherlv_3= 'label:' ( (lv_label_4_0= RULE_STRING ) ) )? (otherlv_5= 'description:' ( (lv_description_6_0= RULE_STRING ) ) )? ( (lv_definition_7_0= ruleCommandDefinitionMdsl ) ) otherlv_8= '}' ) ;
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
            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:3284:28: ( (otherlv_0= 'Common Command' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' (otherlv_3= 'label:' ( (lv_label_4_0= RULE_STRING ) ) )? (otherlv_5= 'description:' ( (lv_description_6_0= RULE_STRING ) ) )? ( (lv_definition_7_0= ruleCommandDefinitionMdsl ) ) otherlv_8= '}' ) )
            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:3285:1: (otherlv_0= 'Common Command' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' (otherlv_3= 'label:' ( (lv_label_4_0= RULE_STRING ) ) )? (otherlv_5= 'description:' ( (lv_description_6_0= RULE_STRING ) ) )? ( (lv_definition_7_0= ruleCommandDefinitionMdsl ) ) otherlv_8= '}' )
            {
            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:3285:1: (otherlv_0= 'Common Command' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' (otherlv_3= 'label:' ( (lv_label_4_0= RULE_STRING ) ) )? (otherlv_5= 'description:' ( (lv_description_6_0= RULE_STRING ) ) )? ( (lv_definition_7_0= ruleCommandDefinitionMdsl ) ) otherlv_8= '}' )
            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:3285:3: otherlv_0= 'Common Command' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' (otherlv_3= 'label:' ( (lv_label_4_0= RULE_STRING ) ) )? (otherlv_5= 'description:' ( (lv_description_6_0= RULE_STRING ) ) )? ( (lv_definition_7_0= ruleCommandDefinitionMdsl ) ) otherlv_8= '}'
            {
            otherlv_0=(Token)match(input,86,FOLLOW_86_in_ruleCommandDeclaration7000); 

                	newLeafNode(otherlv_0, grammarAccess.getCommandDeclarationAccess().getCommonCommandKeyword_0());
                
            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:3289:1: ( (lv_name_1_0= RULE_ID ) )
            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:3290:1: (lv_name_1_0= RULE_ID )
            {
            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:3290:1: (lv_name_1_0= RULE_ID )
            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:3291:3: lv_name_1_0= RULE_ID
            {
            lv_name_1_0=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleCommandDeclaration7017); 

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

            otherlv_2=(Token)match(input,22,FOLLOW_22_in_ruleCommandDeclaration7034); 

                	newLeafNode(otherlv_2, grammarAccess.getCommandDeclarationAccess().getLeftCurlyBracketKeyword_2());
                
            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:3311:1: (otherlv_3= 'label:' ( (lv_label_4_0= RULE_STRING ) ) )?
            int alt68=2;
            int LA68_0 = input.LA(1);

            if ( (LA68_0==13) ) {
                alt68=1;
            }
            switch (alt68) {
                case 1 :
                    // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:3311:3: otherlv_3= 'label:' ( (lv_label_4_0= RULE_STRING ) )
                    {
                    otherlv_3=(Token)match(input,13,FOLLOW_13_in_ruleCommandDeclaration7047); 

                        	newLeafNode(otherlv_3, grammarAccess.getCommandDeclarationAccess().getLabelKeyword_3_0());
                        
                    // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:3315:1: ( (lv_label_4_0= RULE_STRING ) )
                    // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:3316:1: (lv_label_4_0= RULE_STRING )
                    {
                    // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:3316:1: (lv_label_4_0= RULE_STRING )
                    // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:3317:3: lv_label_4_0= RULE_STRING
                    {
                    lv_label_4_0=(Token)match(input,RULE_STRING,FOLLOW_RULE_STRING_in_ruleCommandDeclaration7064); 

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

            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:3333:4: (otherlv_5= 'description:' ( (lv_description_6_0= RULE_STRING ) ) )?
            int alt69=2;
            int LA69_0 = input.LA(1);

            if ( (LA69_0==17) ) {
                alt69=1;
            }
            switch (alt69) {
                case 1 :
                    // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:3333:6: otherlv_5= 'description:' ( (lv_description_6_0= RULE_STRING ) )
                    {
                    otherlv_5=(Token)match(input,17,FOLLOW_17_in_ruleCommandDeclaration7084); 

                        	newLeafNode(otherlv_5, grammarAccess.getCommandDeclarationAccess().getDescriptionKeyword_4_0());
                        
                    // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:3337:1: ( (lv_description_6_0= RULE_STRING ) )
                    // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:3338:1: (lv_description_6_0= RULE_STRING )
                    {
                    // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:3338:1: (lv_description_6_0= RULE_STRING )
                    // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:3339:3: lv_description_6_0= RULE_STRING
                    {
                    lv_description_6_0=(Token)match(input,RULE_STRING,FOLLOW_RULE_STRING_in_ruleCommandDeclaration7101); 

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

            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:3355:4: ( (lv_definition_7_0= ruleCommandDefinitionMdsl ) )
            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:3356:1: (lv_definition_7_0= ruleCommandDefinitionMdsl )
            {
            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:3356:1: (lv_definition_7_0= ruleCommandDefinitionMdsl )
            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:3357:3: lv_definition_7_0= ruleCommandDefinitionMdsl
            {
             
            	        newCompositeNode(grammarAccess.getCommandDeclarationAccess().getDefinitionCommandDefinitionMdslParserRuleCall_5_0()); 
            	    
            pushFollow(FOLLOW_ruleCommandDefinitionMdsl_in_ruleCommandDeclaration7129);
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

            otherlv_8=(Token)match(input,30,FOLLOW_30_in_ruleCommandDeclaration7141); 

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
    // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:3385:1: entryRuleCommandDefinitionMdsl returns [EObject current=null] : iv_ruleCommandDefinitionMdsl= ruleCommandDefinitionMdsl EOF ;
    public final EObject entryRuleCommandDefinitionMdsl() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleCommandDefinitionMdsl = null;


        try {
            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:3386:2: (iv_ruleCommandDefinitionMdsl= ruleCommandDefinitionMdsl EOF )
            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:3387:2: iv_ruleCommandDefinitionMdsl= ruleCommandDefinitionMdsl EOF
            {
             newCompositeNode(grammarAccess.getCommandDefinitionMdslRule()); 
            pushFollow(FOLLOW_ruleCommandDefinitionMdsl_in_entryRuleCommandDefinitionMdsl7177);
            iv_ruleCommandDefinitionMdsl=ruleCommandDefinitionMdsl();

            state._fsp--;

             current =iv_ruleCommandDefinitionMdsl; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleCommandDefinitionMdsl7187); 

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
    // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:3394:1: ruleCommandDefinitionMdsl returns [EObject current=null] : ( ( (lv_category_0_0= ruleCOMMAND_CATEGORY_MDSL ) ) ( ( (lv_i18NLabel_1_0= 'I18N' ) )? ( (lv_label_2_0= ruleFormatExpr ) ) )? (otherlv_3= 'icon:' ( (otherlv_4= RULE_ID ) ) )? otherlv_5= 'action:' ( (lv_action_6_0= ruleQuery ) ) (otherlv_7= 'on success:' ( (lv_onActionSuccessUICommands_8_0= ruleUICommandMdsl ) )* )? (otherlv_9= 'on error:' ( (lv_onActionErrorUICommands_10_0= ruleUICommandMdsl ) )* )? ) ;
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
            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:3397:28: ( ( ( (lv_category_0_0= ruleCOMMAND_CATEGORY_MDSL ) ) ( ( (lv_i18NLabel_1_0= 'I18N' ) )? ( (lv_label_2_0= ruleFormatExpr ) ) )? (otherlv_3= 'icon:' ( (otherlv_4= RULE_ID ) ) )? otherlv_5= 'action:' ( (lv_action_6_0= ruleQuery ) ) (otherlv_7= 'on success:' ( (lv_onActionSuccessUICommands_8_0= ruleUICommandMdsl ) )* )? (otherlv_9= 'on error:' ( (lv_onActionErrorUICommands_10_0= ruleUICommandMdsl ) )* )? ) )
            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:3398:1: ( ( (lv_category_0_0= ruleCOMMAND_CATEGORY_MDSL ) ) ( ( (lv_i18NLabel_1_0= 'I18N' ) )? ( (lv_label_2_0= ruleFormatExpr ) ) )? (otherlv_3= 'icon:' ( (otherlv_4= RULE_ID ) ) )? otherlv_5= 'action:' ( (lv_action_6_0= ruleQuery ) ) (otherlv_7= 'on success:' ( (lv_onActionSuccessUICommands_8_0= ruleUICommandMdsl ) )* )? (otherlv_9= 'on error:' ( (lv_onActionErrorUICommands_10_0= ruleUICommandMdsl ) )* )? )
            {
            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:3398:1: ( ( (lv_category_0_0= ruleCOMMAND_CATEGORY_MDSL ) ) ( ( (lv_i18NLabel_1_0= 'I18N' ) )? ( (lv_label_2_0= ruleFormatExpr ) ) )? (otherlv_3= 'icon:' ( (otherlv_4= RULE_ID ) ) )? otherlv_5= 'action:' ( (lv_action_6_0= ruleQuery ) ) (otherlv_7= 'on success:' ( (lv_onActionSuccessUICommands_8_0= ruleUICommandMdsl ) )* )? (otherlv_9= 'on error:' ( (lv_onActionErrorUICommands_10_0= ruleUICommandMdsl ) )* )? )
            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:3398:2: ( (lv_category_0_0= ruleCOMMAND_CATEGORY_MDSL ) ) ( ( (lv_i18NLabel_1_0= 'I18N' ) )? ( (lv_label_2_0= ruleFormatExpr ) ) )? (otherlv_3= 'icon:' ( (otherlv_4= RULE_ID ) ) )? otherlv_5= 'action:' ( (lv_action_6_0= ruleQuery ) ) (otherlv_7= 'on success:' ( (lv_onActionSuccessUICommands_8_0= ruleUICommandMdsl ) )* )? (otherlv_9= 'on error:' ( (lv_onActionErrorUICommands_10_0= ruleUICommandMdsl ) )* )?
            {
            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:3398:2: ( (lv_category_0_0= ruleCOMMAND_CATEGORY_MDSL ) )
            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:3399:1: (lv_category_0_0= ruleCOMMAND_CATEGORY_MDSL )
            {
            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:3399:1: (lv_category_0_0= ruleCOMMAND_CATEGORY_MDSL )
            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:3400:3: lv_category_0_0= ruleCOMMAND_CATEGORY_MDSL
            {
             
            	        newCompositeNode(grammarAccess.getCommandDefinitionMdslAccess().getCategoryCOMMAND_CATEGORY_MDSLEnumRuleCall_0_0()); 
            	    
            pushFollow(FOLLOW_ruleCOMMAND_CATEGORY_MDSL_in_ruleCommandDefinitionMdsl7233);
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

            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:3416:2: ( ( (lv_i18NLabel_1_0= 'I18N' ) )? ( (lv_label_2_0= ruleFormatExpr ) ) )?
            int alt71=2;
            int LA71_0 = input.LA(1);

            if ( (LA71_0==RULE_STRING||LA71_0==55||LA71_0==107) ) {
                alt71=1;
            }
            switch (alt71) {
                case 1 :
                    // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:3416:3: ( (lv_i18NLabel_1_0= 'I18N' ) )? ( (lv_label_2_0= ruleFormatExpr ) )
                    {
                    // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:3416:3: ( (lv_i18NLabel_1_0= 'I18N' ) )?
                    int alt70=2;
                    int LA70_0 = input.LA(1);

                    if ( (LA70_0==55) ) {
                        alt70=1;
                    }
                    switch (alt70) {
                        case 1 :
                            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:3417:1: (lv_i18NLabel_1_0= 'I18N' )
                            {
                            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:3417:1: (lv_i18NLabel_1_0= 'I18N' )
                            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:3418:3: lv_i18NLabel_1_0= 'I18N'
                            {
                            lv_i18NLabel_1_0=(Token)match(input,55,FOLLOW_55_in_ruleCommandDefinitionMdsl7252); 

                                    newLeafNode(lv_i18NLabel_1_0, grammarAccess.getCommandDefinitionMdslAccess().getI18NLabelI18NKeyword_1_0_0());
                                

                            	        if (current==null) {
                            	            current = createModelElement(grammarAccess.getCommandDefinitionMdslRule());
                            	        }
                                   		setWithLastConsumed(current, "i18NLabel", true, "I18N");
                            	    

                            }


                            }
                            break;

                    }

                    // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:3431:3: ( (lv_label_2_0= ruleFormatExpr ) )
                    // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:3432:1: (lv_label_2_0= ruleFormatExpr )
                    {
                    // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:3432:1: (lv_label_2_0= ruleFormatExpr )
                    // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:3433:3: lv_label_2_0= ruleFormatExpr
                    {
                     
                    	        newCompositeNode(grammarAccess.getCommandDefinitionMdslAccess().getLabelFormatExprParserRuleCall_1_1_0()); 
                    	    
                    pushFollow(FOLLOW_ruleFormatExpr_in_ruleCommandDefinitionMdsl7287);
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


                    }
                    break;

            }

            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:3449:4: (otherlv_3= 'icon:' ( (otherlv_4= RULE_ID ) ) )?
            int alt72=2;
            int LA72_0 = input.LA(1);

            if ( (LA72_0==87) ) {
                alt72=1;
            }
            switch (alt72) {
                case 1 :
                    // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:3449:6: otherlv_3= 'icon:' ( (otherlv_4= RULE_ID ) )
                    {
                    otherlv_3=(Token)match(input,87,FOLLOW_87_in_ruleCommandDefinitionMdsl7302); 

                        	newLeafNode(otherlv_3, grammarAccess.getCommandDefinitionMdslAccess().getIconKeyword_2_0());
                        
                    // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:3453:1: ( (otherlv_4= RULE_ID ) )
                    // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:3454:1: (otherlv_4= RULE_ID )
                    {
                    // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:3454:1: (otherlv_4= RULE_ID )
                    // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:3455:3: otherlv_4= RULE_ID
                    {

                    			if (current==null) {
                    	            current = createModelElement(grammarAccess.getCommandDefinitionMdslRule());
                    	        }
                            
                    otherlv_4=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleCommandDefinitionMdsl7322); 

                    		newLeafNode(otherlv_4, grammarAccess.getCommandDefinitionMdslAccess().getIconIconDescriptorMdslCrossReference_2_1_0()); 
                    	

                    }


                    }


                    }
                    break;

            }

            otherlv_5=(Token)match(input,88,FOLLOW_88_in_ruleCommandDefinitionMdsl7336); 

                	newLeafNode(otherlv_5, grammarAccess.getCommandDefinitionMdslAccess().getActionKeyword_3());
                
            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:3470:1: ( (lv_action_6_0= ruleQuery ) )
            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:3471:1: (lv_action_6_0= ruleQuery )
            {
            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:3471:1: (lv_action_6_0= ruleQuery )
            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:3472:3: lv_action_6_0= ruleQuery
            {
             
            	        newCompositeNode(grammarAccess.getCommandDefinitionMdslAccess().getActionQueryParserRuleCall_4_0()); 
            	    
            pushFollow(FOLLOW_ruleQuery_in_ruleCommandDefinitionMdsl7357);
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

            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:3488:2: (otherlv_7= 'on success:' ( (lv_onActionSuccessUICommands_8_0= ruleUICommandMdsl ) )* )?
            int alt74=2;
            int LA74_0 = input.LA(1);

            if ( (LA74_0==89) ) {
                alt74=1;
            }
            switch (alt74) {
                case 1 :
                    // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:3488:4: otherlv_7= 'on success:' ( (lv_onActionSuccessUICommands_8_0= ruleUICommandMdsl ) )*
                    {
                    otherlv_7=(Token)match(input,89,FOLLOW_89_in_ruleCommandDefinitionMdsl7370); 

                        	newLeafNode(otherlv_7, grammarAccess.getCommandDefinitionMdslAccess().getOnSuccessKeyword_5_0());
                        
                    // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:3492:1: ( (lv_onActionSuccessUICommands_8_0= ruleUICommandMdsl ) )*
                    loop73:
                    do {
                        int alt73=2;
                        int LA73_0 = input.LA(1);

                        if ( ((LA73_0>=93 && LA73_0<=94)) ) {
                            alt73=1;
                        }


                        switch (alt73) {
                    	case 1 :
                    	    // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:3493:1: (lv_onActionSuccessUICommands_8_0= ruleUICommandMdsl )
                    	    {
                    	    // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:3493:1: (lv_onActionSuccessUICommands_8_0= ruleUICommandMdsl )
                    	    // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:3494:3: lv_onActionSuccessUICommands_8_0= ruleUICommandMdsl
                    	    {
                    	     
                    	    	        newCompositeNode(grammarAccess.getCommandDefinitionMdslAccess().getOnActionSuccessUICommandsUICommandMdslParserRuleCall_5_1_0()); 
                    	    	    
                    	    pushFollow(FOLLOW_ruleUICommandMdsl_in_ruleCommandDefinitionMdsl7391);
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
                    	    break loop73;
                        }
                    } while (true);


                    }
                    break;

            }

            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:3510:5: (otherlv_9= 'on error:' ( (lv_onActionErrorUICommands_10_0= ruleUICommandMdsl ) )* )?
            int alt76=2;
            int LA76_0 = input.LA(1);

            if ( (LA76_0==90) ) {
                alt76=1;
            }
            switch (alt76) {
                case 1 :
                    // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:3510:7: otherlv_9= 'on error:' ( (lv_onActionErrorUICommands_10_0= ruleUICommandMdsl ) )*
                    {
                    otherlv_9=(Token)match(input,90,FOLLOW_90_in_ruleCommandDefinitionMdsl7407); 

                        	newLeafNode(otherlv_9, grammarAccess.getCommandDefinitionMdslAccess().getOnErrorKeyword_6_0());
                        
                    // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:3514:1: ( (lv_onActionErrorUICommands_10_0= ruleUICommandMdsl ) )*
                    loop75:
                    do {
                        int alt75=2;
                        int LA75_0 = input.LA(1);

                        if ( ((LA75_0>=93 && LA75_0<=94)) ) {
                            alt75=1;
                        }


                        switch (alt75) {
                    	case 1 :
                    	    // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:3515:1: (lv_onActionErrorUICommands_10_0= ruleUICommandMdsl )
                    	    {
                    	    // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:3515:1: (lv_onActionErrorUICommands_10_0= ruleUICommandMdsl )
                    	    // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:3516:3: lv_onActionErrorUICommands_10_0= ruleUICommandMdsl
                    	    {
                    	     
                    	    	        newCompositeNode(grammarAccess.getCommandDefinitionMdslAccess().getOnActionErrorUICommandsUICommandMdslParserRuleCall_6_1_0()); 
                    	    	    
                    	    pushFollow(FOLLOW_ruleUICommandMdsl_in_ruleCommandDefinitionMdsl7428);
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
                    	    break loop75;
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
    // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:3540:1: entryRuleCommandRefMdsl returns [EObject current=null] : iv_ruleCommandRefMdsl= ruleCommandRefMdsl EOF ;
    public final EObject entryRuleCommandRefMdsl() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleCommandRefMdsl = null;


        try {
            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:3541:2: (iv_ruleCommandRefMdsl= ruleCommandRefMdsl EOF )
            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:3542:2: iv_ruleCommandRefMdsl= ruleCommandRefMdsl EOF
            {
             newCompositeNode(grammarAccess.getCommandRefMdslRule()); 
            pushFollow(FOLLOW_ruleCommandRefMdsl_in_entryRuleCommandRefMdsl7467);
            iv_ruleCommandRefMdsl=ruleCommandRefMdsl();

            state._fsp--;

             current =iv_ruleCommandRefMdsl; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleCommandRefMdsl7477); 

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
    // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:3549:1: ruleCommandRefMdsl returns [EObject current=null] : ( ( (otherlv_0= RULE_ID ) ) (otherlv_1= '(' ( (lv_i18NLabelOverride_2_0= 'I18N' ) )? ( (lv_labelOverride_3_0= ruleFormatExpr ) ) otherlv_4= ')' )? ) ;
    public final EObject ruleCommandRefMdsl() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;
        Token lv_i18NLabelOverride_2_0=null;
        Token otherlv_4=null;
        EObject lv_labelOverride_3_0 = null;


         enterRule(); 
            
        try {
            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:3552:28: ( ( ( (otherlv_0= RULE_ID ) ) (otherlv_1= '(' ( (lv_i18NLabelOverride_2_0= 'I18N' ) )? ( (lv_labelOverride_3_0= ruleFormatExpr ) ) otherlv_4= ')' )? ) )
            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:3553:1: ( ( (otherlv_0= RULE_ID ) ) (otherlv_1= '(' ( (lv_i18NLabelOverride_2_0= 'I18N' ) )? ( (lv_labelOverride_3_0= ruleFormatExpr ) ) otherlv_4= ')' )? )
            {
            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:3553:1: ( ( (otherlv_0= RULE_ID ) ) (otherlv_1= '(' ( (lv_i18NLabelOverride_2_0= 'I18N' ) )? ( (lv_labelOverride_3_0= ruleFormatExpr ) ) otherlv_4= ')' )? )
            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:3553:2: ( (otherlv_0= RULE_ID ) ) (otherlv_1= '(' ( (lv_i18NLabelOverride_2_0= 'I18N' ) )? ( (lv_labelOverride_3_0= ruleFormatExpr ) ) otherlv_4= ')' )?
            {
            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:3553:2: ( (otherlv_0= RULE_ID ) )
            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:3554:1: (otherlv_0= RULE_ID )
            {
            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:3554:1: (otherlv_0= RULE_ID )
            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:3555:3: otherlv_0= RULE_ID
            {

            			if (current==null) {
            	            current = createModelElement(grammarAccess.getCommandRefMdslRule());
            	        }
                    
            otherlv_0=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleCommandRefMdsl7522); 

            		newLeafNode(otherlv_0, grammarAccess.getCommandRefMdslAccess().getReferencedCommandDeclarationCrossReference_0_0()); 
            	

            }


            }

            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:3566:2: (otherlv_1= '(' ( (lv_i18NLabelOverride_2_0= 'I18N' ) )? ( (lv_labelOverride_3_0= ruleFormatExpr ) ) otherlv_4= ')' )?
            int alt78=2;
            int LA78_0 = input.LA(1);

            if ( (LA78_0==91) ) {
                alt78=1;
            }
            switch (alt78) {
                case 1 :
                    // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:3566:4: otherlv_1= '(' ( (lv_i18NLabelOverride_2_0= 'I18N' ) )? ( (lv_labelOverride_3_0= ruleFormatExpr ) ) otherlv_4= ')'
                    {
                    otherlv_1=(Token)match(input,91,FOLLOW_91_in_ruleCommandRefMdsl7535); 

                        	newLeafNode(otherlv_1, grammarAccess.getCommandRefMdslAccess().getLeftParenthesisKeyword_1_0());
                        
                    // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:3570:1: ( (lv_i18NLabelOverride_2_0= 'I18N' ) )?
                    int alt77=2;
                    int LA77_0 = input.LA(1);

                    if ( (LA77_0==55) ) {
                        alt77=1;
                    }
                    switch (alt77) {
                        case 1 :
                            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:3571:1: (lv_i18NLabelOverride_2_0= 'I18N' )
                            {
                            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:3571:1: (lv_i18NLabelOverride_2_0= 'I18N' )
                            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:3572:3: lv_i18NLabelOverride_2_0= 'I18N'
                            {
                            lv_i18NLabelOverride_2_0=(Token)match(input,55,FOLLOW_55_in_ruleCommandRefMdsl7553); 

                                    newLeafNode(lv_i18NLabelOverride_2_0, grammarAccess.getCommandRefMdslAccess().getI18NLabelOverrideI18NKeyword_1_1_0());
                                

                            	        if (current==null) {
                            	            current = createModelElement(grammarAccess.getCommandRefMdslRule());
                            	        }
                                   		setWithLastConsumed(current, "i18NLabelOverride", true, "I18N");
                            	    

                            }


                            }
                            break;

                    }

                    // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:3585:3: ( (lv_labelOverride_3_0= ruleFormatExpr ) )
                    // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:3586:1: (lv_labelOverride_3_0= ruleFormatExpr )
                    {
                    // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:3586:1: (lv_labelOverride_3_0= ruleFormatExpr )
                    // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:3587:3: lv_labelOverride_3_0= ruleFormatExpr
                    {
                     
                    	        newCompositeNode(grammarAccess.getCommandRefMdslAccess().getLabelOverrideFormatExprParserRuleCall_1_2_0()); 
                    	    
                    pushFollow(FOLLOW_ruleFormatExpr_in_ruleCommandRefMdsl7588);
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

                    otherlv_4=(Token)match(input,92,FOLLOW_92_in_ruleCommandRefMdsl7600); 

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
    // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:3615:1: entryRuleUICommandMdsl returns [EObject current=null] : iv_ruleUICommandMdsl= ruleUICommandMdsl EOF ;
    public final EObject entryRuleUICommandMdsl() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleUICommandMdsl = null;


        try {
            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:3616:2: (iv_ruleUICommandMdsl= ruleUICommandMdsl EOF )
            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:3617:2: iv_ruleUICommandMdsl= ruleUICommandMdsl EOF
            {
             newCompositeNode(grammarAccess.getUICommandMdslRule()); 
            pushFollow(FOLLOW_ruleUICommandMdsl_in_entryRuleUICommandMdsl7638);
            iv_ruleUICommandMdsl=ruleUICommandMdsl();

            state._fsp--;

             current =iv_ruleUICommandMdsl; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleUICommandMdsl7648); 

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
    // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:3624:1: ruleUICommandMdsl returns [EObject current=null] : (this_ReloadWidgetsUICommand_0= ruleReloadWidgetsUICommand | this_ReloadViewUICommand_1= ruleReloadViewUICommand | this_DisplayViewUICommand_2= ruleDisplayViewUICommand ) ;
    public final EObject ruleUICommandMdsl() throws RecognitionException {
        EObject current = null;

        EObject this_ReloadWidgetsUICommand_0 = null;

        EObject this_ReloadViewUICommand_1 = null;

        EObject this_DisplayViewUICommand_2 = null;


         enterRule(); 
            
        try {
            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:3627:28: ( (this_ReloadWidgetsUICommand_0= ruleReloadWidgetsUICommand | this_ReloadViewUICommand_1= ruleReloadViewUICommand | this_DisplayViewUICommand_2= ruleDisplayViewUICommand ) )
            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:3628:1: (this_ReloadWidgetsUICommand_0= ruleReloadWidgetsUICommand | this_ReloadViewUICommand_1= ruleReloadViewUICommand | this_DisplayViewUICommand_2= ruleDisplayViewUICommand )
            {
            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:3628:1: (this_ReloadWidgetsUICommand_0= ruleReloadWidgetsUICommand | this_ReloadViewUICommand_1= ruleReloadViewUICommand | this_DisplayViewUICommand_2= ruleDisplayViewUICommand )
            int alt79=3;
            int LA79_0 = input.LA(1);

            if ( (LA79_0==94) ) {
                int LA79_1 = input.LA(2);

                if ( (LA79_1==96) ) {
                    alt79=1;
                }
                else if ( (LA79_1==95) ) {
                    alt79=2;
                }
                else {
                    NoViableAltException nvae =
                        new NoViableAltException("", 79, 1, input);

                    throw nvae;
                }
            }
            else if ( (LA79_0==93) ) {
                alt79=3;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 79, 0, input);

                throw nvae;
            }
            switch (alt79) {
                case 1 :
                    // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:3629:5: this_ReloadWidgetsUICommand_0= ruleReloadWidgetsUICommand
                    {
                     
                            newCompositeNode(grammarAccess.getUICommandMdslAccess().getReloadWidgetsUICommandParserRuleCall_0()); 
                        
                    pushFollow(FOLLOW_ruleReloadWidgetsUICommand_in_ruleUICommandMdsl7695);
                    this_ReloadWidgetsUICommand_0=ruleReloadWidgetsUICommand();

                    state._fsp--;

                     
                            current = this_ReloadWidgetsUICommand_0; 
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;
                case 2 :
                    // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:3639:5: this_ReloadViewUICommand_1= ruleReloadViewUICommand
                    {
                     
                            newCompositeNode(grammarAccess.getUICommandMdslAccess().getReloadViewUICommandParserRuleCall_1()); 
                        
                    pushFollow(FOLLOW_ruleReloadViewUICommand_in_ruleUICommandMdsl7722);
                    this_ReloadViewUICommand_1=ruleReloadViewUICommand();

                    state._fsp--;

                     
                            current = this_ReloadViewUICommand_1; 
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;
                case 3 :
                    // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:3649:5: this_DisplayViewUICommand_2= ruleDisplayViewUICommand
                    {
                     
                            newCompositeNode(grammarAccess.getUICommandMdslAccess().getDisplayViewUICommandParserRuleCall_2()); 
                        
                    pushFollow(FOLLOW_ruleDisplayViewUICommand_in_ruleUICommandMdsl7749);
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
    // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:3665:1: entryRuleDisplayViewUICommand returns [EObject current=null] : iv_ruleDisplayViewUICommand= ruleDisplayViewUICommand EOF ;
    public final EObject entryRuleDisplayViewUICommand() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleDisplayViewUICommand = null;


        try {
            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:3666:2: (iv_ruleDisplayViewUICommand= ruleDisplayViewUICommand EOF )
            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:3667:2: iv_ruleDisplayViewUICommand= ruleDisplayViewUICommand EOF
            {
             newCompositeNode(grammarAccess.getDisplayViewUICommandRule()); 
            pushFollow(FOLLOW_ruleDisplayViewUICommand_in_entryRuleDisplayViewUICommand7784);
            iv_ruleDisplayViewUICommand=ruleDisplayViewUICommand();

            state._fsp--;

             current =iv_ruleDisplayViewUICommand; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleDisplayViewUICommand7794); 

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
    // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:3674:1: ruleDisplayViewUICommand returns [EObject current=null] : (otherlv_0= 'Display view' (otherlv_1= 'for' ( (lv_target_2_0= ruleQueryUsage ) ) )? ) ;
    public final EObject ruleDisplayViewUICommand() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;
        EObject lv_target_2_0 = null;


         enterRule(); 
            
        try {
            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:3677:28: ( (otherlv_0= 'Display view' (otherlv_1= 'for' ( (lv_target_2_0= ruleQueryUsage ) ) )? ) )
            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:3678:1: (otherlv_0= 'Display view' (otherlv_1= 'for' ( (lv_target_2_0= ruleQueryUsage ) ) )? )
            {
            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:3678:1: (otherlv_0= 'Display view' (otherlv_1= 'for' ( (lv_target_2_0= ruleQueryUsage ) ) )? )
            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:3678:3: otherlv_0= 'Display view' (otherlv_1= 'for' ( (lv_target_2_0= ruleQueryUsage ) ) )?
            {
            otherlv_0=(Token)match(input,93,FOLLOW_93_in_ruleDisplayViewUICommand7831); 

                	newLeafNode(otherlv_0, grammarAccess.getDisplayViewUICommandAccess().getDisplayViewKeyword_0());
                
            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:3682:1: (otherlv_1= 'for' ( (lv_target_2_0= ruleQueryUsage ) ) )?
            int alt80=2;
            int LA80_0 = input.LA(1);

            if ( (LA80_0==61) ) {
                alt80=1;
            }
            switch (alt80) {
                case 1 :
                    // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:3682:3: otherlv_1= 'for' ( (lv_target_2_0= ruleQueryUsage ) )
                    {
                    otherlv_1=(Token)match(input,61,FOLLOW_61_in_ruleDisplayViewUICommand7844); 

                        	newLeafNode(otherlv_1, grammarAccess.getDisplayViewUICommandAccess().getForKeyword_1_0());
                        
                    // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:3686:1: ( (lv_target_2_0= ruleQueryUsage ) )
                    // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:3687:1: (lv_target_2_0= ruleQueryUsage )
                    {
                    // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:3687:1: (lv_target_2_0= ruleQueryUsage )
                    // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:3688:3: lv_target_2_0= ruleQueryUsage
                    {
                     
                    	        newCompositeNode(grammarAccess.getDisplayViewUICommandAccess().getTargetQueryUsageParserRuleCall_1_1_0()); 
                    	    
                    pushFollow(FOLLOW_ruleQueryUsage_in_ruleDisplayViewUICommand7865);
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
    // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:3712:1: entryRuleReloadViewUICommand returns [EObject current=null] : iv_ruleReloadViewUICommand= ruleReloadViewUICommand EOF ;
    public final EObject entryRuleReloadViewUICommand() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleReloadViewUICommand = null;


        try {
            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:3713:2: (iv_ruleReloadViewUICommand= ruleReloadViewUICommand EOF )
            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:3714:2: iv_ruleReloadViewUICommand= ruleReloadViewUICommand EOF
            {
             newCompositeNode(grammarAccess.getReloadViewUICommandRule()); 
            pushFollow(FOLLOW_ruleReloadViewUICommand_in_entryRuleReloadViewUICommand7903);
            iv_ruleReloadViewUICommand=ruleReloadViewUICommand();

            state._fsp--;

             current =iv_ruleReloadViewUICommand; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleReloadViewUICommand7913); 

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
    // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:3721:1: ruleReloadViewUICommand returns [EObject current=null] : ( () otherlv_1= 'Reload' otherlv_2= 'view' ) ;
    public final EObject ruleReloadViewUICommand() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_2=null;

         enterRule(); 
            
        try {
            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:3724:28: ( ( () otherlv_1= 'Reload' otherlv_2= 'view' ) )
            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:3725:1: ( () otherlv_1= 'Reload' otherlv_2= 'view' )
            {
            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:3725:1: ( () otherlv_1= 'Reload' otherlv_2= 'view' )
            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:3725:2: () otherlv_1= 'Reload' otherlv_2= 'view'
            {
            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:3725:2: ()
            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:3726:5: 
            {

                    current = forceCreateModelElement(
                        grammarAccess.getReloadViewUICommandAccess().getReloadViewUICommandAction_0(),
                        current);
                

            }

            otherlv_1=(Token)match(input,94,FOLLOW_94_in_ruleReloadViewUICommand7959); 

                	newLeafNode(otherlv_1, grammarAccess.getReloadViewUICommandAccess().getReloadKeyword_1());
                
            otherlv_2=(Token)match(input,95,FOLLOW_95_in_ruleReloadViewUICommand7971); 

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
    // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:3747:1: entryRuleReloadWidgetsUICommand returns [EObject current=null] : iv_ruleReloadWidgetsUICommand= ruleReloadWidgetsUICommand EOF ;
    public final EObject entryRuleReloadWidgetsUICommand() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleReloadWidgetsUICommand = null;


        try {
            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:3748:2: (iv_ruleReloadWidgetsUICommand= ruleReloadWidgetsUICommand EOF )
            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:3749:2: iv_ruleReloadWidgetsUICommand= ruleReloadWidgetsUICommand EOF
            {
             newCompositeNode(grammarAccess.getReloadWidgetsUICommandRule()); 
            pushFollow(FOLLOW_ruleReloadWidgetsUICommand_in_entryRuleReloadWidgetsUICommand8007);
            iv_ruleReloadWidgetsUICommand=ruleReloadWidgetsUICommand();

            state._fsp--;

             current =iv_ruleReloadWidgetsUICommand; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleReloadWidgetsUICommand8017); 

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
    // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:3756:1: ruleReloadWidgetsUICommand returns [EObject current=null] : (otherlv_0= 'Reload' otherlv_1= 'widgets:' ( (otherlv_2= RULE_ID ) )* ) ;
    public final EObject ruleReloadWidgetsUICommand() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;
        Token otherlv_2=null;

         enterRule(); 
            
        try {
            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:3759:28: ( (otherlv_0= 'Reload' otherlv_1= 'widgets:' ( (otherlv_2= RULE_ID ) )* ) )
            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:3760:1: (otherlv_0= 'Reload' otherlv_1= 'widgets:' ( (otherlv_2= RULE_ID ) )* )
            {
            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:3760:1: (otherlv_0= 'Reload' otherlv_1= 'widgets:' ( (otherlv_2= RULE_ID ) )* )
            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:3760:3: otherlv_0= 'Reload' otherlv_1= 'widgets:' ( (otherlv_2= RULE_ID ) )*
            {
            otherlv_0=(Token)match(input,94,FOLLOW_94_in_ruleReloadWidgetsUICommand8054); 

                	newLeafNode(otherlv_0, grammarAccess.getReloadWidgetsUICommandAccess().getReloadKeyword_0());
                
            otherlv_1=(Token)match(input,96,FOLLOW_96_in_ruleReloadWidgetsUICommand8066); 

                	newLeafNode(otherlv_1, grammarAccess.getReloadWidgetsUICommandAccess().getWidgetsKeyword_1());
                
            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:3768:1: ( (otherlv_2= RULE_ID ) )*
            loop81:
            do {
                int alt81=2;
                int LA81_0 = input.LA(1);

                if ( (LA81_0==RULE_ID) ) {
                    alt81=1;
                }


                switch (alt81) {
            	case 1 :
            	    // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:3769:1: (otherlv_2= RULE_ID )
            	    {
            	    // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:3769:1: (otherlv_2= RULE_ID )
            	    // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:3770:3: otherlv_2= RULE_ID
            	    {

            	    			if (current==null) {
            	    	            current = createModelElement(grammarAccess.getReloadWidgetsUICommandRule());
            	    	        }
            	            
            	    otherlv_2=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleReloadWidgetsUICommand8086); 

            	    		newLeafNode(otherlv_2, grammarAccess.getReloadWidgetsUICommandAccess().getWidgetsToReloadWidgetConfigurationMdslCrossReference_2_0()); 
            	    	

            	    }


            	    }
            	    break;

            	default :
            	    break loop81;
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
    // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:3789:1: entryRuleQueryUsage returns [EObject current=null] : iv_ruleQueryUsage= ruleQueryUsage EOF ;
    public final EObject entryRuleQueryUsage() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleQueryUsage = null;


        try {
            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:3790:2: (iv_ruleQueryUsage= ruleQueryUsage EOF )
            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:3791:2: iv_ruleQueryUsage= ruleQueryUsage EOF
            {
             newCompositeNode(grammarAccess.getQueryUsageRule()); 
            pushFollow(FOLLOW_ruleQueryUsage_in_entryRuleQueryUsage8123);
            iv_ruleQueryUsage=ruleQueryUsage();

            state._fsp--;

             current =iv_ruleQueryUsage; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleQueryUsage8133); 

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
    // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:3798:1: ruleQueryUsage returns [EObject current=null] : (this_Query_0= ruleQuery | this_QueryChain_1= ruleQueryChain ) ;
    public final EObject ruleQueryUsage() throws RecognitionException {
        EObject current = null;

        EObject this_Query_0 = null;

        EObject this_QueryChain_1 = null;


         enterRule(); 
            
        try {
            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:3801:28: ( (this_Query_0= ruleQuery | this_QueryChain_1= ruleQueryChain ) )
            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:3802:1: (this_Query_0= ruleQuery | this_QueryChain_1= ruleQueryChain )
            {
            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:3802:1: (this_Query_0= ruleQuery | this_QueryChain_1= ruleQueryChain )
            int alt82=2;
            int LA82_0 = input.LA(1);

            if ( ((LA82_0>=RULE_STRING && LA82_0<=RULE_ID)||(LA82_0>=98 && LA82_0<=100)||LA82_0==103||LA82_0==107) ) {
                alt82=1;
            }
            else if ( (LA82_0==105) ) {
                alt82=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 82, 0, input);

                throw nvae;
            }
            switch (alt82) {
                case 1 :
                    // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:3803:5: this_Query_0= ruleQuery
                    {
                     
                            newCompositeNode(grammarAccess.getQueryUsageAccess().getQueryParserRuleCall_0()); 
                        
                    pushFollow(FOLLOW_ruleQuery_in_ruleQueryUsage8180);
                    this_Query_0=ruleQuery();

                    state._fsp--;

                     
                            current = this_Query_0; 
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;
                case 2 :
                    // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:3813:5: this_QueryChain_1= ruleQueryChain
                    {
                     
                            newCompositeNode(grammarAccess.getQueryUsageAccess().getQueryChainParserRuleCall_1()); 
                        
                    pushFollow(FOLLOW_ruleQueryChain_in_ruleQueryUsage8207);
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
    // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:3829:1: entryRuleQuery returns [EObject current=null] : iv_ruleQuery= ruleQuery EOF ;
    public final EObject entryRuleQuery() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleQuery = null;


        try {
            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:3830:2: (iv_ruleQuery= ruleQuery EOF )
            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:3831:2: iv_ruleQuery= ruleQuery EOF
            {
             newCompositeNode(grammarAccess.getQueryRule()); 
            pushFollow(FOLLOW_ruleQuery_in_entryRuleQuery8242);
            iv_ruleQuery=ruleQuery();

            state._fsp--;

             current =iv_ruleQuery; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleQuery8252); 

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
    // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:3838:1: ruleQuery returns [EObject current=null] : (this_QueryDefinitionMdsl_0= ruleQueryDefinitionMdsl | this_QueryRefMdsl_1= ruleQueryRefMdsl ) ;
    public final EObject ruleQuery() throws RecognitionException {
        EObject current = null;

        EObject this_QueryDefinitionMdsl_0 = null;

        EObject this_QueryRefMdsl_1 = null;


         enterRule(); 
            
        try {
            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:3841:28: ( (this_QueryDefinitionMdsl_0= ruleQueryDefinitionMdsl | this_QueryRefMdsl_1= ruleQueryRefMdsl ) )
            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:3842:1: (this_QueryDefinitionMdsl_0= ruleQueryDefinitionMdsl | this_QueryRefMdsl_1= ruleQueryRefMdsl )
            {
            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:3842:1: (this_QueryDefinitionMdsl_0= ruleQueryDefinitionMdsl | this_QueryRefMdsl_1= ruleQueryRefMdsl )
            int alt83=2;
            int LA83_0 = input.LA(1);

            if ( (LA83_0==RULE_STRING||(LA83_0>=98 && LA83_0<=100)||LA83_0==103||LA83_0==107) ) {
                alt83=1;
            }
            else if ( (LA83_0==RULE_ID) ) {
                alt83=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 83, 0, input);

                throw nvae;
            }
            switch (alt83) {
                case 1 :
                    // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:3843:5: this_QueryDefinitionMdsl_0= ruleQueryDefinitionMdsl
                    {
                     
                            newCompositeNode(grammarAccess.getQueryAccess().getQueryDefinitionMdslParserRuleCall_0()); 
                        
                    pushFollow(FOLLOW_ruleQueryDefinitionMdsl_in_ruleQuery8299);
                    this_QueryDefinitionMdsl_0=ruleQueryDefinitionMdsl();

                    state._fsp--;

                     
                            current = this_QueryDefinitionMdsl_0; 
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;
                case 2 :
                    // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:3853:5: this_QueryRefMdsl_1= ruleQueryRefMdsl
                    {
                     
                            newCompositeNode(grammarAccess.getQueryAccess().getQueryRefMdslParserRuleCall_1()); 
                        
                    pushFollow(FOLLOW_ruleQueryRefMdsl_in_ruleQuery8326);
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
    // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:3869:1: entryRuleQueryDeclaration returns [EObject current=null] : iv_ruleQueryDeclaration= ruleQueryDeclaration EOF ;
    public final EObject entryRuleQueryDeclaration() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleQueryDeclaration = null;


        try {
            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:3870:2: (iv_ruleQueryDeclaration= ruleQueryDeclaration EOF )
            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:3871:2: iv_ruleQueryDeclaration= ruleQueryDeclaration EOF
            {
             newCompositeNode(grammarAccess.getQueryDeclarationRule()); 
            pushFollow(FOLLOW_ruleQueryDeclaration_in_entryRuleQueryDeclaration8361);
            iv_ruleQueryDeclaration=ruleQueryDeclaration();

            state._fsp--;

             current =iv_ruleQueryDeclaration; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleQueryDeclaration8371); 

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
    // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:3878:1: ruleQueryDeclaration returns [EObject current=null] : (otherlv_0= 'Common Query' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' (otherlv_3= 'label:' ( (lv_label_4_0= RULE_STRING ) ) )? (otherlv_5= 'description:' ( (lv_description_6_0= RULE_STRING ) ) )? ( (lv_definition_7_0= ruleQueryDefinitionMdsl ) ) otherlv_8= '}' ) ;
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
            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:3881:28: ( (otherlv_0= 'Common Query' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' (otherlv_3= 'label:' ( (lv_label_4_0= RULE_STRING ) ) )? (otherlv_5= 'description:' ( (lv_description_6_0= RULE_STRING ) ) )? ( (lv_definition_7_0= ruleQueryDefinitionMdsl ) ) otherlv_8= '}' ) )
            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:3882:1: (otherlv_0= 'Common Query' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' (otherlv_3= 'label:' ( (lv_label_4_0= RULE_STRING ) ) )? (otherlv_5= 'description:' ( (lv_description_6_0= RULE_STRING ) ) )? ( (lv_definition_7_0= ruleQueryDefinitionMdsl ) ) otherlv_8= '}' )
            {
            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:3882:1: (otherlv_0= 'Common Query' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' (otherlv_3= 'label:' ( (lv_label_4_0= RULE_STRING ) ) )? (otherlv_5= 'description:' ( (lv_description_6_0= RULE_STRING ) ) )? ( (lv_definition_7_0= ruleQueryDefinitionMdsl ) ) otherlv_8= '}' )
            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:3882:3: otherlv_0= 'Common Query' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' (otherlv_3= 'label:' ( (lv_label_4_0= RULE_STRING ) ) )? (otherlv_5= 'description:' ( (lv_description_6_0= RULE_STRING ) ) )? ( (lv_definition_7_0= ruleQueryDefinitionMdsl ) ) otherlv_8= '}'
            {
            otherlv_0=(Token)match(input,97,FOLLOW_97_in_ruleQueryDeclaration8408); 

                	newLeafNode(otherlv_0, grammarAccess.getQueryDeclarationAccess().getCommonQueryKeyword_0());
                
            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:3886:1: ( (lv_name_1_0= RULE_ID ) )
            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:3887:1: (lv_name_1_0= RULE_ID )
            {
            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:3887:1: (lv_name_1_0= RULE_ID )
            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:3888:3: lv_name_1_0= RULE_ID
            {
            lv_name_1_0=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleQueryDeclaration8425); 

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

            otherlv_2=(Token)match(input,22,FOLLOW_22_in_ruleQueryDeclaration8442); 

                	newLeafNode(otherlv_2, grammarAccess.getQueryDeclarationAccess().getLeftCurlyBracketKeyword_2());
                
            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:3908:1: (otherlv_3= 'label:' ( (lv_label_4_0= RULE_STRING ) ) )?
            int alt84=2;
            int LA84_0 = input.LA(1);

            if ( (LA84_0==13) ) {
                alt84=1;
            }
            switch (alt84) {
                case 1 :
                    // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:3908:3: otherlv_3= 'label:' ( (lv_label_4_0= RULE_STRING ) )
                    {
                    otherlv_3=(Token)match(input,13,FOLLOW_13_in_ruleQueryDeclaration8455); 

                        	newLeafNode(otherlv_3, grammarAccess.getQueryDeclarationAccess().getLabelKeyword_3_0());
                        
                    // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:3912:1: ( (lv_label_4_0= RULE_STRING ) )
                    // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:3913:1: (lv_label_4_0= RULE_STRING )
                    {
                    // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:3913:1: (lv_label_4_0= RULE_STRING )
                    // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:3914:3: lv_label_4_0= RULE_STRING
                    {
                    lv_label_4_0=(Token)match(input,RULE_STRING,FOLLOW_RULE_STRING_in_ruleQueryDeclaration8472); 

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

            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:3930:4: (otherlv_5= 'description:' ( (lv_description_6_0= RULE_STRING ) ) )?
            int alt85=2;
            int LA85_0 = input.LA(1);

            if ( (LA85_0==17) ) {
                alt85=1;
            }
            switch (alt85) {
                case 1 :
                    // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:3930:6: otherlv_5= 'description:' ( (lv_description_6_0= RULE_STRING ) )
                    {
                    otherlv_5=(Token)match(input,17,FOLLOW_17_in_ruleQueryDeclaration8492); 

                        	newLeafNode(otherlv_5, grammarAccess.getQueryDeclarationAccess().getDescriptionKeyword_4_0());
                        
                    // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:3934:1: ( (lv_description_6_0= RULE_STRING ) )
                    // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:3935:1: (lv_description_6_0= RULE_STRING )
                    {
                    // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:3935:1: (lv_description_6_0= RULE_STRING )
                    // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:3936:3: lv_description_6_0= RULE_STRING
                    {
                    lv_description_6_0=(Token)match(input,RULE_STRING,FOLLOW_RULE_STRING_in_ruleQueryDeclaration8509); 

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

            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:3952:4: ( (lv_definition_7_0= ruleQueryDefinitionMdsl ) )
            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:3953:1: (lv_definition_7_0= ruleQueryDefinitionMdsl )
            {
            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:3953:1: (lv_definition_7_0= ruleQueryDefinitionMdsl )
            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:3954:3: lv_definition_7_0= ruleQueryDefinitionMdsl
            {
             
            	        newCompositeNode(grammarAccess.getQueryDeclarationAccess().getDefinitionQueryDefinitionMdslParserRuleCall_5_0()); 
            	    
            pushFollow(FOLLOW_ruleQueryDefinitionMdsl_in_ruleQueryDeclaration8537);
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

            otherlv_8=(Token)match(input,30,FOLLOW_30_in_ruleQueryDeclaration8549); 

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
    // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:3982:1: entryRuleQueryDefinitionMdsl returns [EObject current=null] : iv_ruleQueryDefinitionMdsl= ruleQueryDefinitionMdsl EOF ;
    public final EObject entryRuleQueryDefinitionMdsl() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleQueryDefinitionMdsl = null;


        try {
            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:3983:2: (iv_ruleQueryDefinitionMdsl= ruleQueryDefinitionMdsl EOF )
            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:3984:2: iv_ruleQueryDefinitionMdsl= ruleQueryDefinitionMdsl EOF
            {
             newCompositeNode(grammarAccess.getQueryDefinitionMdslRule()); 
            pushFollow(FOLLOW_ruleQueryDefinitionMdsl_in_entryRuleQueryDefinitionMdsl8585);
            iv_ruleQueryDefinitionMdsl=ruleQueryDefinitionMdsl();

            state._fsp--;

             current =iv_ruleQueryDefinitionMdsl; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleQueryDefinitionMdsl8595); 

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
    // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:3991:1: ruleQueryDefinitionMdsl returns [EObject current=null] : ( (otherlv_0= 'language:' ( (otherlv_1= RULE_ID ) ) )? (otherlv_2= 'foreign model:' ( (otherlv_3= RULE_ID ) ) )? (otherlv_4= 'context locator:' ( (lv_contextLocator_5_0= RULE_STRING ) ) )? ( ( (lv_query_6_0= ruleQueryBody ) ) | ( (lv_externalQueryCall_7_0= ruleExternalQueryCallMdsl ) ) ) (otherlv_8= ':' ( (otherlv_9= RULE_ID ) ) )? (otherlv_10= 'properties:' ( (lv_properties_11_0= rulePropertyMdsl ) ) (otherlv_12= ',' ( (lv_properties_13_0= rulePropertyMdsl ) ) )* )? (otherlv_14= 'Optimisation:' ( (lv_optimisationLevel_15_0= ruleQUERY_OPTIMISATION_LEVEL ) ) )? ) ;
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
            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:3994:28: ( ( (otherlv_0= 'language:' ( (otherlv_1= RULE_ID ) ) )? (otherlv_2= 'foreign model:' ( (otherlv_3= RULE_ID ) ) )? (otherlv_4= 'context locator:' ( (lv_contextLocator_5_0= RULE_STRING ) ) )? ( ( (lv_query_6_0= ruleQueryBody ) ) | ( (lv_externalQueryCall_7_0= ruleExternalQueryCallMdsl ) ) ) (otherlv_8= ':' ( (otherlv_9= RULE_ID ) ) )? (otherlv_10= 'properties:' ( (lv_properties_11_0= rulePropertyMdsl ) ) (otherlv_12= ',' ( (lv_properties_13_0= rulePropertyMdsl ) ) )* )? (otherlv_14= 'Optimisation:' ( (lv_optimisationLevel_15_0= ruleQUERY_OPTIMISATION_LEVEL ) ) )? ) )
            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:3995:1: ( (otherlv_0= 'language:' ( (otherlv_1= RULE_ID ) ) )? (otherlv_2= 'foreign model:' ( (otherlv_3= RULE_ID ) ) )? (otherlv_4= 'context locator:' ( (lv_contextLocator_5_0= RULE_STRING ) ) )? ( ( (lv_query_6_0= ruleQueryBody ) ) | ( (lv_externalQueryCall_7_0= ruleExternalQueryCallMdsl ) ) ) (otherlv_8= ':' ( (otherlv_9= RULE_ID ) ) )? (otherlv_10= 'properties:' ( (lv_properties_11_0= rulePropertyMdsl ) ) (otherlv_12= ',' ( (lv_properties_13_0= rulePropertyMdsl ) ) )* )? (otherlv_14= 'Optimisation:' ( (lv_optimisationLevel_15_0= ruleQUERY_OPTIMISATION_LEVEL ) ) )? )
            {
            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:3995:1: ( (otherlv_0= 'language:' ( (otherlv_1= RULE_ID ) ) )? (otherlv_2= 'foreign model:' ( (otherlv_3= RULE_ID ) ) )? (otherlv_4= 'context locator:' ( (lv_contextLocator_5_0= RULE_STRING ) ) )? ( ( (lv_query_6_0= ruleQueryBody ) ) | ( (lv_externalQueryCall_7_0= ruleExternalQueryCallMdsl ) ) ) (otherlv_8= ':' ( (otherlv_9= RULE_ID ) ) )? (otherlv_10= 'properties:' ( (lv_properties_11_0= rulePropertyMdsl ) ) (otherlv_12= ',' ( (lv_properties_13_0= rulePropertyMdsl ) ) )* )? (otherlv_14= 'Optimisation:' ( (lv_optimisationLevel_15_0= ruleQUERY_OPTIMISATION_LEVEL ) ) )? )
            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:3995:2: (otherlv_0= 'language:' ( (otherlv_1= RULE_ID ) ) )? (otherlv_2= 'foreign model:' ( (otherlv_3= RULE_ID ) ) )? (otherlv_4= 'context locator:' ( (lv_contextLocator_5_0= RULE_STRING ) ) )? ( ( (lv_query_6_0= ruleQueryBody ) ) | ( (lv_externalQueryCall_7_0= ruleExternalQueryCallMdsl ) ) ) (otherlv_8= ':' ( (otherlv_9= RULE_ID ) ) )? (otherlv_10= 'properties:' ( (lv_properties_11_0= rulePropertyMdsl ) ) (otherlv_12= ',' ( (lv_properties_13_0= rulePropertyMdsl ) ) )* )? (otherlv_14= 'Optimisation:' ( (lv_optimisationLevel_15_0= ruleQUERY_OPTIMISATION_LEVEL ) ) )?
            {
            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:3995:2: (otherlv_0= 'language:' ( (otherlv_1= RULE_ID ) ) )?
            int alt86=2;
            int LA86_0 = input.LA(1);

            if ( (LA86_0==98) ) {
                alt86=1;
            }
            switch (alt86) {
                case 1 :
                    // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:3995:4: otherlv_0= 'language:' ( (otherlv_1= RULE_ID ) )
                    {
                    otherlv_0=(Token)match(input,98,FOLLOW_98_in_ruleQueryDefinitionMdsl8633); 

                        	newLeafNode(otherlv_0, grammarAccess.getQueryDefinitionMdslAccess().getLanguageKeyword_0_0());
                        
                    // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:3999:1: ( (otherlv_1= RULE_ID ) )
                    // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:4000:1: (otherlv_1= RULE_ID )
                    {
                    // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:4000:1: (otherlv_1= RULE_ID )
                    // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:4001:3: otherlv_1= RULE_ID
                    {

                    			if (current==null) {
                    	            current = createModelElement(grammarAccess.getQueryDefinitionMdslRule());
                    	        }
                            
                    otherlv_1=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleQueryDefinitionMdsl8653); 

                    		newLeafNode(otherlv_1, grammarAccess.getQueryDefinitionMdslAccess().getEvaluatorQueryEvaluatorMdslCrossReference_0_1_0()); 
                    	

                    }


                    }


                    }
                    break;

            }

            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:4012:4: (otherlv_2= 'foreign model:' ( (otherlv_3= RULE_ID ) ) )?
            int alt87=2;
            int LA87_0 = input.LA(1);

            if ( (LA87_0==99) ) {
                alt87=1;
            }
            switch (alt87) {
                case 1 :
                    // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:4012:6: otherlv_2= 'foreign model:' ( (otherlv_3= RULE_ID ) )
                    {
                    otherlv_2=(Token)match(input,99,FOLLOW_99_in_ruleQueryDefinitionMdsl8668); 

                        	newLeafNode(otherlv_2, grammarAccess.getQueryDefinitionMdslAccess().getForeignModelKeyword_1_0());
                        
                    // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:4016:1: ( (otherlv_3= RULE_ID ) )
                    // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:4017:1: (otherlv_3= RULE_ID )
                    {
                    // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:4017:1: (otherlv_3= RULE_ID )
                    // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:4018:3: otherlv_3= RULE_ID
                    {

                    			if (current==null) {
                    	            current = createModelElement(grammarAccess.getQueryDefinitionMdslRule());
                    	        }
                            
                    otherlv_3=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleQueryDefinitionMdsl8688); 

                    		newLeafNode(otherlv_3, grammarAccess.getQueryDefinitionMdslAccess().getForeignModelForeignModelMdslCrossReference_1_1_0()); 
                    	

                    }


                    }


                    }
                    break;

            }

            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:4029:4: (otherlv_4= 'context locator:' ( (lv_contextLocator_5_0= RULE_STRING ) ) )?
            int alt88=2;
            int LA88_0 = input.LA(1);

            if ( (LA88_0==100) ) {
                alt88=1;
            }
            switch (alt88) {
                case 1 :
                    // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:4029:6: otherlv_4= 'context locator:' ( (lv_contextLocator_5_0= RULE_STRING ) )
                    {
                    otherlv_4=(Token)match(input,100,FOLLOW_100_in_ruleQueryDefinitionMdsl8703); 

                        	newLeafNode(otherlv_4, grammarAccess.getQueryDefinitionMdslAccess().getContextLocatorKeyword_2_0());
                        
                    // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:4033:1: ( (lv_contextLocator_5_0= RULE_STRING ) )
                    // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:4034:1: (lv_contextLocator_5_0= RULE_STRING )
                    {
                    // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:4034:1: (lv_contextLocator_5_0= RULE_STRING )
                    // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:4035:3: lv_contextLocator_5_0= RULE_STRING
                    {
                    lv_contextLocator_5_0=(Token)match(input,RULE_STRING,FOLLOW_RULE_STRING_in_ruleQueryDefinitionMdsl8720); 

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

            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:4051:4: ( ( (lv_query_6_0= ruleQueryBody ) ) | ( (lv_externalQueryCall_7_0= ruleExternalQueryCallMdsl ) ) )
            int alt89=2;
            int LA89_0 = input.LA(1);

            if ( (LA89_0==RULE_STRING||LA89_0==107) ) {
                alt89=1;
            }
            else if ( (LA89_0==103) ) {
                alt89=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 89, 0, input);

                throw nvae;
            }
            switch (alt89) {
                case 1 :
                    // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:4051:5: ( (lv_query_6_0= ruleQueryBody ) )
                    {
                    // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:4051:5: ( (lv_query_6_0= ruleQueryBody ) )
                    // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:4052:1: (lv_query_6_0= ruleQueryBody )
                    {
                    // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:4052:1: (lv_query_6_0= ruleQueryBody )
                    // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:4053:3: lv_query_6_0= ruleQueryBody
                    {
                     
                    	        newCompositeNode(grammarAccess.getQueryDefinitionMdslAccess().getQueryQueryBodyParserRuleCall_3_0_0()); 
                    	    
                    pushFollow(FOLLOW_ruleQueryBody_in_ruleQueryDefinitionMdsl8749);
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
                    // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:4070:6: ( (lv_externalQueryCall_7_0= ruleExternalQueryCallMdsl ) )
                    {
                    // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:4070:6: ( (lv_externalQueryCall_7_0= ruleExternalQueryCallMdsl ) )
                    // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:4071:1: (lv_externalQueryCall_7_0= ruleExternalQueryCallMdsl )
                    {
                    // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:4071:1: (lv_externalQueryCall_7_0= ruleExternalQueryCallMdsl )
                    // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:4072:3: lv_externalQueryCall_7_0= ruleExternalQueryCallMdsl
                    {
                     
                    	        newCompositeNode(grammarAccess.getQueryDefinitionMdslAccess().getExternalQueryCallExternalQueryCallMdslParserRuleCall_3_1_0()); 
                    	    
                    pushFollow(FOLLOW_ruleExternalQueryCallMdsl_in_ruleQueryDefinitionMdsl8776);
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

            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:4088:3: (otherlv_8= ':' ( (otherlv_9= RULE_ID ) ) )?
            int alt90=2;
            int LA90_0 = input.LA(1);

            if ( (LA90_0==27) ) {
                alt90=1;
            }
            switch (alt90) {
                case 1 :
                    // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:4088:5: otherlv_8= ':' ( (otherlv_9= RULE_ID ) )
                    {
                    otherlv_8=(Token)match(input,27,FOLLOW_27_in_ruleQueryDefinitionMdsl8790); 

                        	newLeafNode(otherlv_8, grammarAccess.getQueryDefinitionMdslAccess().getColonKeyword_4_0());
                        
                    // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:4092:1: ( (otherlv_9= RULE_ID ) )
                    // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:4093:1: (otherlv_9= RULE_ID )
                    {
                    // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:4093:1: (otherlv_9= RULE_ID )
                    // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:4094:3: otherlv_9= RULE_ID
                    {

                    			if (current==null) {
                    	            current = createModelElement(grammarAccess.getQueryDefinitionMdslRule());
                    	        }
                            
                    otherlv_9=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleQueryDefinitionMdsl8810); 

                    		newLeafNode(otherlv_9, grammarAccess.getQueryDefinitionMdslAccess().getReturnTypeEClassifierCrossReference_4_1_0()); 
                    	

                    }


                    }


                    }
                    break;

            }

            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:4105:4: (otherlv_10= 'properties:' ( (lv_properties_11_0= rulePropertyMdsl ) ) (otherlv_12= ',' ( (lv_properties_13_0= rulePropertyMdsl ) ) )* )?
            int alt92=2;
            int LA92_0 = input.LA(1);

            if ( (LA92_0==101) ) {
                alt92=1;
            }
            switch (alt92) {
                case 1 :
                    // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:4105:6: otherlv_10= 'properties:' ( (lv_properties_11_0= rulePropertyMdsl ) ) (otherlv_12= ',' ( (lv_properties_13_0= rulePropertyMdsl ) ) )*
                    {
                    otherlv_10=(Token)match(input,101,FOLLOW_101_in_ruleQueryDefinitionMdsl8825); 

                        	newLeafNode(otherlv_10, grammarAccess.getQueryDefinitionMdslAccess().getPropertiesKeyword_5_0());
                        
                    // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:4109:1: ( (lv_properties_11_0= rulePropertyMdsl ) )
                    // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:4110:1: (lv_properties_11_0= rulePropertyMdsl )
                    {
                    // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:4110:1: (lv_properties_11_0= rulePropertyMdsl )
                    // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:4111:3: lv_properties_11_0= rulePropertyMdsl
                    {
                     
                    	        newCompositeNode(grammarAccess.getQueryDefinitionMdslAccess().getPropertiesPropertyMdslParserRuleCall_5_1_0()); 
                    	    
                    pushFollow(FOLLOW_rulePropertyMdsl_in_ruleQueryDefinitionMdsl8846);
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

                    // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:4127:2: (otherlv_12= ',' ( (lv_properties_13_0= rulePropertyMdsl ) ) )*
                    loop91:
                    do {
                        int alt91=2;
                        int LA91_0 = input.LA(1);

                        if ( (LA91_0==35) ) {
                            int LA91_2 = input.LA(2);

                            if ( (LA91_2==RULE_ID) ) {
                                int LA91_3 = input.LA(3);

                                if ( (LA91_3==14) ) {
                                    alt91=1;
                                }


                            }


                        }


                        switch (alt91) {
                    	case 1 :
                    	    // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:4127:4: otherlv_12= ',' ( (lv_properties_13_0= rulePropertyMdsl ) )
                    	    {
                    	    otherlv_12=(Token)match(input,35,FOLLOW_35_in_ruleQueryDefinitionMdsl8859); 

                    	        	newLeafNode(otherlv_12, grammarAccess.getQueryDefinitionMdslAccess().getCommaKeyword_5_2_0());
                    	        
                    	    // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:4131:1: ( (lv_properties_13_0= rulePropertyMdsl ) )
                    	    // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:4132:1: (lv_properties_13_0= rulePropertyMdsl )
                    	    {
                    	    // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:4132:1: (lv_properties_13_0= rulePropertyMdsl )
                    	    // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:4133:3: lv_properties_13_0= rulePropertyMdsl
                    	    {
                    	     
                    	    	        newCompositeNode(grammarAccess.getQueryDefinitionMdslAccess().getPropertiesPropertyMdslParserRuleCall_5_2_1_0()); 
                    	    	    
                    	    pushFollow(FOLLOW_rulePropertyMdsl_in_ruleQueryDefinitionMdsl8880);
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
                    	    break loop91;
                        }
                    } while (true);


                    }
                    break;

            }

            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:4149:6: (otherlv_14= 'Optimisation:' ( (lv_optimisationLevel_15_0= ruleQUERY_OPTIMISATION_LEVEL ) ) )?
            int alt93=2;
            int LA93_0 = input.LA(1);

            if ( (LA93_0==102) ) {
                alt93=1;
            }
            switch (alt93) {
                case 1 :
                    // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:4149:8: otherlv_14= 'Optimisation:' ( (lv_optimisationLevel_15_0= ruleQUERY_OPTIMISATION_LEVEL ) )
                    {
                    otherlv_14=(Token)match(input,102,FOLLOW_102_in_ruleQueryDefinitionMdsl8897); 

                        	newLeafNode(otherlv_14, grammarAccess.getQueryDefinitionMdslAccess().getOptimisationKeyword_6_0());
                        
                    // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:4153:1: ( (lv_optimisationLevel_15_0= ruleQUERY_OPTIMISATION_LEVEL ) )
                    // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:4154:1: (lv_optimisationLevel_15_0= ruleQUERY_OPTIMISATION_LEVEL )
                    {
                    // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:4154:1: (lv_optimisationLevel_15_0= ruleQUERY_OPTIMISATION_LEVEL )
                    // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:4155:3: lv_optimisationLevel_15_0= ruleQUERY_OPTIMISATION_LEVEL
                    {
                     
                    	        newCompositeNode(grammarAccess.getQueryDefinitionMdslAccess().getOptimisationLevelQUERY_OPTIMISATION_LEVELEnumRuleCall_6_1_0()); 
                    	    
                    pushFollow(FOLLOW_ruleQUERY_OPTIMISATION_LEVEL_in_ruleQueryDefinitionMdsl8918);
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
    // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:4179:1: entryRuleQueryFragment returns [EObject current=null] : iv_ruleQueryFragment= ruleQueryFragment EOF ;
    public final EObject entryRuleQueryFragment() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleQueryFragment = null;


        try {
            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:4180:2: (iv_ruleQueryFragment= ruleQueryFragment EOF )
            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:4181:2: iv_ruleQueryFragment= ruleQueryFragment EOF
            {
             newCompositeNode(grammarAccess.getQueryFragmentRule()); 
            pushFollow(FOLLOW_ruleQueryFragment_in_entryRuleQueryFragment8956);
            iv_ruleQueryFragment=ruleQueryFragment();

            state._fsp--;

             current =iv_ruleQueryFragment; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleQueryFragment8966); 

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
    // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:4188:1: ruleQueryFragment returns [EObject current=null] : (this_LiteralQueryFragment_0= ruleLiteralQueryFragment | this_TextMacroRef_1= ruleTextMacroRef ) ;
    public final EObject ruleQueryFragment() throws RecognitionException {
        EObject current = null;

        EObject this_LiteralQueryFragment_0 = null;

        EObject this_TextMacroRef_1 = null;


         enterRule(); 
            
        try {
            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:4191:28: ( (this_LiteralQueryFragment_0= ruleLiteralQueryFragment | this_TextMacroRef_1= ruleTextMacroRef ) )
            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:4192:1: (this_LiteralQueryFragment_0= ruleLiteralQueryFragment | this_TextMacroRef_1= ruleTextMacroRef )
            {
            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:4192:1: (this_LiteralQueryFragment_0= ruleLiteralQueryFragment | this_TextMacroRef_1= ruleTextMacroRef )
            int alt94=2;
            int LA94_0 = input.LA(1);

            if ( (LA94_0==RULE_STRING) ) {
                alt94=1;
            }
            else if ( (LA94_0==107) ) {
                alt94=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 94, 0, input);

                throw nvae;
            }
            switch (alt94) {
                case 1 :
                    // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:4193:5: this_LiteralQueryFragment_0= ruleLiteralQueryFragment
                    {
                     
                            newCompositeNode(grammarAccess.getQueryFragmentAccess().getLiteralQueryFragmentParserRuleCall_0()); 
                        
                    pushFollow(FOLLOW_ruleLiteralQueryFragment_in_ruleQueryFragment9013);
                    this_LiteralQueryFragment_0=ruleLiteralQueryFragment();

                    state._fsp--;

                     
                            current = this_LiteralQueryFragment_0; 
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;
                case 2 :
                    // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:4203:5: this_TextMacroRef_1= ruleTextMacroRef
                    {
                     
                            newCompositeNode(grammarAccess.getQueryFragmentAccess().getTextMacroRefParserRuleCall_1()); 
                        
                    pushFollow(FOLLOW_ruleTextMacroRef_in_ruleQueryFragment9040);
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
    // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:4219:1: entryRuleLiteralQueryFragment returns [EObject current=null] : iv_ruleLiteralQueryFragment= ruleLiteralQueryFragment EOF ;
    public final EObject entryRuleLiteralQueryFragment() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleLiteralQueryFragment = null;


        try {
            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:4220:2: (iv_ruleLiteralQueryFragment= ruleLiteralQueryFragment EOF )
            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:4221:2: iv_ruleLiteralQueryFragment= ruleLiteralQueryFragment EOF
            {
             newCompositeNode(grammarAccess.getLiteralQueryFragmentRule()); 
            pushFollow(FOLLOW_ruleLiteralQueryFragment_in_entryRuleLiteralQueryFragment9075);
            iv_ruleLiteralQueryFragment=ruleLiteralQueryFragment();

            state._fsp--;

             current =iv_ruleLiteralQueryFragment; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleLiteralQueryFragment9085); 

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
    // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:4228:1: ruleLiteralQueryFragment returns [EObject current=null] : ( (lv_value_0_0= RULE_STRING ) ) ;
    public final EObject ruleLiteralQueryFragment() throws RecognitionException {
        EObject current = null;

        Token lv_value_0_0=null;

         enterRule(); 
            
        try {
            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:4231:28: ( ( (lv_value_0_0= RULE_STRING ) ) )
            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:4232:1: ( (lv_value_0_0= RULE_STRING ) )
            {
            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:4232:1: ( (lv_value_0_0= RULE_STRING ) )
            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:4233:1: (lv_value_0_0= RULE_STRING )
            {
            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:4233:1: (lv_value_0_0= RULE_STRING )
            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:4234:3: lv_value_0_0= RULE_STRING
            {
            lv_value_0_0=(Token)match(input,RULE_STRING,FOLLOW_RULE_STRING_in_ruleLiteralQueryFragment9126); 

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
    // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:4258:1: entryRuleQueryBody returns [EObject current=null] : iv_ruleQueryBody= ruleQueryBody EOF ;
    public final EObject entryRuleQueryBody() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleQueryBody = null;


        try {
            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:4259:2: (iv_ruleQueryBody= ruleQueryBody EOF )
            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:4260:2: iv_ruleQueryBody= ruleQueryBody EOF
            {
             newCompositeNode(grammarAccess.getQueryBodyRule()); 
            pushFollow(FOLLOW_ruleQueryBody_in_entryRuleQueryBody9166);
            iv_ruleQueryBody=ruleQueryBody();

            state._fsp--;

             current =iv_ruleQueryBody; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleQueryBody9176); 

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
    // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:4267:1: ruleQueryBody returns [EObject current=null] : ( ( (lv_fragments_0_0= ruleQueryFragment ) ) (otherlv_1= '+' ( (lv_fragments_2_0= ruleQueryFragment ) ) )* ) ;
    public final EObject ruleQueryBody() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        EObject lv_fragments_0_0 = null;

        EObject lv_fragments_2_0 = null;


         enterRule(); 
            
        try {
            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:4270:28: ( ( ( (lv_fragments_0_0= ruleQueryFragment ) ) (otherlv_1= '+' ( (lv_fragments_2_0= ruleQueryFragment ) ) )* ) )
            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:4271:1: ( ( (lv_fragments_0_0= ruleQueryFragment ) ) (otherlv_1= '+' ( (lv_fragments_2_0= ruleQueryFragment ) ) )* )
            {
            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:4271:1: ( ( (lv_fragments_0_0= ruleQueryFragment ) ) (otherlv_1= '+' ( (lv_fragments_2_0= ruleQueryFragment ) ) )* )
            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:4271:2: ( (lv_fragments_0_0= ruleQueryFragment ) ) (otherlv_1= '+' ( (lv_fragments_2_0= ruleQueryFragment ) ) )*
            {
            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:4271:2: ( (lv_fragments_0_0= ruleQueryFragment ) )
            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:4272:1: (lv_fragments_0_0= ruleQueryFragment )
            {
            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:4272:1: (lv_fragments_0_0= ruleQueryFragment )
            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:4273:3: lv_fragments_0_0= ruleQueryFragment
            {
             
            	        newCompositeNode(grammarAccess.getQueryBodyAccess().getFragmentsQueryFragmentParserRuleCall_0_0()); 
            	    
            pushFollow(FOLLOW_ruleQueryFragment_in_ruleQueryBody9222);
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

            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:4289:2: (otherlv_1= '+' ( (lv_fragments_2_0= ruleQueryFragment ) ) )*
            loop95:
            do {
                int alt95=2;
                int LA95_0 = input.LA(1);

                if ( (LA95_0==15) ) {
                    alt95=1;
                }


                switch (alt95) {
            	case 1 :
            	    // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:4289:4: otherlv_1= '+' ( (lv_fragments_2_0= ruleQueryFragment ) )
            	    {
            	    otherlv_1=(Token)match(input,15,FOLLOW_15_in_ruleQueryBody9235); 

            	        	newLeafNode(otherlv_1, grammarAccess.getQueryBodyAccess().getPlusSignKeyword_1_0());
            	        
            	    // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:4293:1: ( (lv_fragments_2_0= ruleQueryFragment ) )
            	    // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:4294:1: (lv_fragments_2_0= ruleQueryFragment )
            	    {
            	    // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:4294:1: (lv_fragments_2_0= ruleQueryFragment )
            	    // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:4295:3: lv_fragments_2_0= ruleQueryFragment
            	    {
            	     
            	    	        newCompositeNode(grammarAccess.getQueryBodyAccess().getFragmentsQueryFragmentParserRuleCall_1_1_0()); 
            	    	    
            	    pushFollow(FOLLOW_ruleQueryFragment_in_ruleQueryBody9256);
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
            	    break loop95;
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
    // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:4319:1: entryRuleQueryRefMdsl returns [EObject current=null] : iv_ruleQueryRefMdsl= ruleQueryRefMdsl EOF ;
    public final EObject entryRuleQueryRefMdsl() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleQueryRefMdsl = null;


        try {
            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:4320:2: (iv_ruleQueryRefMdsl= ruleQueryRefMdsl EOF )
            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:4321:2: iv_ruleQueryRefMdsl= ruleQueryRefMdsl EOF
            {
             newCompositeNode(grammarAccess.getQueryRefMdslRule()); 
            pushFollow(FOLLOW_ruleQueryRefMdsl_in_entryRuleQueryRefMdsl9294);
            iv_ruleQueryRefMdsl=ruleQueryRefMdsl();

            state._fsp--;

             current =iv_ruleQueryRefMdsl; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleQueryRefMdsl9304); 

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
    // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:4328:1: ruleQueryRefMdsl returns [EObject current=null] : ( (otherlv_0= RULE_ID ) ) ;
    public final EObject ruleQueryRefMdsl() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;

         enterRule(); 
            
        try {
            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:4331:28: ( ( (otherlv_0= RULE_ID ) ) )
            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:4332:1: ( (otherlv_0= RULE_ID ) )
            {
            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:4332:1: ( (otherlv_0= RULE_ID ) )
            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:4333:1: (otherlv_0= RULE_ID )
            {
            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:4333:1: (otherlv_0= RULE_ID )
            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:4334:3: otherlv_0= RULE_ID
            {

            			if (current==null) {
            	            current = createModelElement(grammarAccess.getQueryRefMdslRule());
            	        }
                    
            otherlv_0=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleQueryRefMdsl9348); 

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
    // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:4353:1: entryRuleExternalQueryCallMdsl returns [EObject current=null] : iv_ruleExternalQueryCallMdsl= ruleExternalQueryCallMdsl EOF ;
    public final EObject entryRuleExternalQueryCallMdsl() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleExternalQueryCallMdsl = null;


        try {
            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:4354:2: (iv_ruleExternalQueryCallMdsl= ruleExternalQueryCallMdsl EOF )
            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:4355:2: iv_ruleExternalQueryCallMdsl= ruleExternalQueryCallMdsl EOF
            {
             newCompositeNode(grammarAccess.getExternalQueryCallMdslRule()); 
            pushFollow(FOLLOW_ruleExternalQueryCallMdsl_in_entryRuleExternalQueryCallMdsl9383);
            iv_ruleExternalQueryCallMdsl=ruleExternalQueryCallMdsl();

            state._fsp--;

             current =iv_ruleExternalQueryCallMdsl; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleExternalQueryCallMdsl9393); 

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
    // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:4362:1: ruleExternalQueryCallMdsl returns [EObject current=null] : (otherlv_0= 'call' ( (otherlv_1= RULE_ID ) ) otherlv_2= '()' ) ;
    public final EObject ruleExternalQueryCallMdsl() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;
        Token otherlv_2=null;

         enterRule(); 
            
        try {
            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:4365:28: ( (otherlv_0= 'call' ( (otherlv_1= RULE_ID ) ) otherlv_2= '()' ) )
            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:4366:1: (otherlv_0= 'call' ( (otherlv_1= RULE_ID ) ) otherlv_2= '()' )
            {
            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:4366:1: (otherlv_0= 'call' ( (otherlv_1= RULE_ID ) ) otherlv_2= '()' )
            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:4366:3: otherlv_0= 'call' ( (otherlv_1= RULE_ID ) ) otherlv_2= '()'
            {
            otherlv_0=(Token)match(input,103,FOLLOW_103_in_ruleExternalQueryCallMdsl9430); 

                	newLeafNode(otherlv_0, grammarAccess.getExternalQueryCallMdslAccess().getCallKeyword_0());
                
            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:4370:1: ( (otherlv_1= RULE_ID ) )
            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:4371:1: (otherlv_1= RULE_ID )
            {
            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:4371:1: (otherlv_1= RULE_ID )
            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:4372:3: otherlv_1= RULE_ID
            {

            			if (current==null) {
            	            current = createModelElement(grammarAccess.getExternalQueryCallMdslRule());
            	        }
                    
            otherlv_1=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleExternalQueryCallMdsl9450); 

            		newLeafNode(otherlv_1, grammarAccess.getExternalQueryCallMdslAccess().getExternalQueryEObjectCrossReference_1_0()); 
            	

            }


            }

            otherlv_2=(Token)match(input,104,FOLLOW_104_in_ruleExternalQueryCallMdsl9462); 

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
    // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:4395:1: entryRuleQueryChain returns [EObject current=null] : iv_ruleQueryChain= ruleQueryChain EOF ;
    public final EObject entryRuleQueryChain() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleQueryChain = null;


        try {
            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:4396:2: (iv_ruleQueryChain= ruleQueryChain EOF )
            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:4397:2: iv_ruleQueryChain= ruleQueryChain EOF
            {
             newCompositeNode(grammarAccess.getQueryChainRule()); 
            pushFollow(FOLLOW_ruleQueryChain_in_entryRuleQueryChain9498);
            iv_ruleQueryChain=ruleQueryChain();

            state._fsp--;

             current =iv_ruleQueryChain; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleQueryChain9508); 

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
    // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:4404:1: ruleQueryChain returns [EObject current=null] : (otherlv_0= 'Query Chain' otherlv_1= '{' ( (lv_queries_2_0= ruleQuery ) )+ (otherlv_3= ',' ( (lv_queries_4_0= ruleQuery ) ) )* otherlv_5= '}' ) ;
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
            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:4407:28: ( (otherlv_0= 'Query Chain' otherlv_1= '{' ( (lv_queries_2_0= ruleQuery ) )+ (otherlv_3= ',' ( (lv_queries_4_0= ruleQuery ) ) )* otherlv_5= '}' ) )
            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:4408:1: (otherlv_0= 'Query Chain' otherlv_1= '{' ( (lv_queries_2_0= ruleQuery ) )+ (otherlv_3= ',' ( (lv_queries_4_0= ruleQuery ) ) )* otherlv_5= '}' )
            {
            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:4408:1: (otherlv_0= 'Query Chain' otherlv_1= '{' ( (lv_queries_2_0= ruleQuery ) )+ (otherlv_3= ',' ( (lv_queries_4_0= ruleQuery ) ) )* otherlv_5= '}' )
            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:4408:3: otherlv_0= 'Query Chain' otherlv_1= '{' ( (lv_queries_2_0= ruleQuery ) )+ (otherlv_3= ',' ( (lv_queries_4_0= ruleQuery ) ) )* otherlv_5= '}'
            {
            otherlv_0=(Token)match(input,105,FOLLOW_105_in_ruleQueryChain9545); 

                	newLeafNode(otherlv_0, grammarAccess.getQueryChainAccess().getQueryChainKeyword_0());
                
            otherlv_1=(Token)match(input,22,FOLLOW_22_in_ruleQueryChain9557); 

                	newLeafNode(otherlv_1, grammarAccess.getQueryChainAccess().getLeftCurlyBracketKeyword_1());
                
            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:4416:1: ( (lv_queries_2_0= ruleQuery ) )+
            int cnt96=0;
            loop96:
            do {
                int alt96=2;
                int LA96_0 = input.LA(1);

                if ( ((LA96_0>=RULE_STRING && LA96_0<=RULE_ID)||(LA96_0>=98 && LA96_0<=100)||LA96_0==103||LA96_0==107) ) {
                    alt96=1;
                }


                switch (alt96) {
            	case 1 :
            	    // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:4417:1: (lv_queries_2_0= ruleQuery )
            	    {
            	    // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:4417:1: (lv_queries_2_0= ruleQuery )
            	    // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:4418:3: lv_queries_2_0= ruleQuery
            	    {
            	     
            	    	        newCompositeNode(grammarAccess.getQueryChainAccess().getQueriesQueryParserRuleCall_2_0()); 
            	    	    
            	    pushFollow(FOLLOW_ruleQuery_in_ruleQueryChain9578);
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
            	    if ( cnt96 >= 1 ) break loop96;
                        EarlyExitException eee =
                            new EarlyExitException(96, input);
                        throw eee;
                }
                cnt96++;
            } while (true);

            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:4434:3: (otherlv_3= ',' ( (lv_queries_4_0= ruleQuery ) ) )*
            loop97:
            do {
                int alt97=2;
                int LA97_0 = input.LA(1);

                if ( (LA97_0==35) ) {
                    alt97=1;
                }


                switch (alt97) {
            	case 1 :
            	    // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:4434:5: otherlv_3= ',' ( (lv_queries_4_0= ruleQuery ) )
            	    {
            	    otherlv_3=(Token)match(input,35,FOLLOW_35_in_ruleQueryChain9592); 

            	        	newLeafNode(otherlv_3, grammarAccess.getQueryChainAccess().getCommaKeyword_3_0());
            	        
            	    // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:4438:1: ( (lv_queries_4_0= ruleQuery ) )
            	    // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:4439:1: (lv_queries_4_0= ruleQuery )
            	    {
            	    // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:4439:1: (lv_queries_4_0= ruleQuery )
            	    // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:4440:3: lv_queries_4_0= ruleQuery
            	    {
            	     
            	    	        newCompositeNode(grammarAccess.getQueryChainAccess().getQueriesQueryParserRuleCall_3_1_0()); 
            	    	    
            	    pushFollow(FOLLOW_ruleQuery_in_ruleQueryChain9613);
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
            	    break loop97;
                }
            } while (true);

            otherlv_5=(Token)match(input,30,FOLLOW_30_in_ruleQueryChain9627); 

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
    // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:4468:1: entryRuleFormatExpr returns [EObject current=null] : iv_ruleFormatExpr= ruleFormatExpr EOF ;
    public final EObject entryRuleFormatExpr() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleFormatExpr = null;


        try {
            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:4469:2: (iv_ruleFormatExpr= ruleFormatExpr EOF )
            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:4470:2: iv_ruleFormatExpr= ruleFormatExpr EOF
            {
             newCompositeNode(grammarAccess.getFormatExprRule()); 
            pushFollow(FOLLOW_ruleFormatExpr_in_entryRuleFormatExpr9663);
            iv_ruleFormatExpr=ruleFormatExpr();

            state._fsp--;

             current =iv_ruleFormatExpr; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleFormatExpr9673); 

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
    // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:4477:1: ruleFormatExpr returns [EObject current=null] : ( ( (lv_fragments_0_0= ruleFormatExprFragment ) ) (otherlv_1= '+' ( (lv_fragments_2_0= ruleFormatExprFragment ) ) )* ) ;
    public final EObject ruleFormatExpr() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        EObject lv_fragments_0_0 = null;

        EObject lv_fragments_2_0 = null;


         enterRule(); 
            
        try {
            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:4480:28: ( ( ( (lv_fragments_0_0= ruleFormatExprFragment ) ) (otherlv_1= '+' ( (lv_fragments_2_0= ruleFormatExprFragment ) ) )* ) )
            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:4481:1: ( ( (lv_fragments_0_0= ruleFormatExprFragment ) ) (otherlv_1= '+' ( (lv_fragments_2_0= ruleFormatExprFragment ) ) )* )
            {
            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:4481:1: ( ( (lv_fragments_0_0= ruleFormatExprFragment ) ) (otherlv_1= '+' ( (lv_fragments_2_0= ruleFormatExprFragment ) ) )* )
            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:4481:2: ( (lv_fragments_0_0= ruleFormatExprFragment ) ) (otherlv_1= '+' ( (lv_fragments_2_0= ruleFormatExprFragment ) ) )*
            {
            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:4481:2: ( (lv_fragments_0_0= ruleFormatExprFragment ) )
            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:4482:1: (lv_fragments_0_0= ruleFormatExprFragment )
            {
            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:4482:1: (lv_fragments_0_0= ruleFormatExprFragment )
            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:4483:3: lv_fragments_0_0= ruleFormatExprFragment
            {
             
            	        newCompositeNode(grammarAccess.getFormatExprAccess().getFragmentsFormatExprFragmentParserRuleCall_0_0()); 
            	    
            pushFollow(FOLLOW_ruleFormatExprFragment_in_ruleFormatExpr9719);
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

            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:4499:2: (otherlv_1= '+' ( (lv_fragments_2_0= ruleFormatExprFragment ) ) )*
            loop98:
            do {
                int alt98=2;
                int LA98_0 = input.LA(1);

                if ( (LA98_0==15) ) {
                    alt98=1;
                }


                switch (alt98) {
            	case 1 :
            	    // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:4499:4: otherlv_1= '+' ( (lv_fragments_2_0= ruleFormatExprFragment ) )
            	    {
            	    otherlv_1=(Token)match(input,15,FOLLOW_15_in_ruleFormatExpr9732); 

            	        	newLeafNode(otherlv_1, grammarAccess.getFormatExprAccess().getPlusSignKeyword_1_0());
            	        
            	    // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:4503:1: ( (lv_fragments_2_0= ruleFormatExprFragment ) )
            	    // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:4504:1: (lv_fragments_2_0= ruleFormatExprFragment )
            	    {
            	    // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:4504:1: (lv_fragments_2_0= ruleFormatExprFragment )
            	    // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:4505:3: lv_fragments_2_0= ruleFormatExprFragment
            	    {
            	     
            	    	        newCompositeNode(grammarAccess.getFormatExprAccess().getFragmentsFormatExprFragmentParserRuleCall_1_1_0()); 
            	    	    
            	    pushFollow(FOLLOW_ruleFormatExprFragment_in_ruleFormatExpr9753);
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
            	    break loop98;
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
    // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:4529:1: entryRuleFormatExprFragment returns [EObject current=null] : iv_ruleFormatExprFragment= ruleFormatExprFragment EOF ;
    public final EObject entryRuleFormatExprFragment() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleFormatExprFragment = null;


        try {
            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:4530:2: (iv_ruleFormatExprFragment= ruleFormatExprFragment EOF )
            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:4531:2: iv_ruleFormatExprFragment= ruleFormatExprFragment EOF
            {
             newCompositeNode(grammarAccess.getFormatExprFragmentRule()); 
            pushFollow(FOLLOW_ruleFormatExprFragment_in_entryRuleFormatExprFragment9791);
            iv_ruleFormatExprFragment=ruleFormatExprFragment();

            state._fsp--;

             current =iv_ruleFormatExprFragment; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleFormatExprFragment9801); 

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
    // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:4538:1: ruleFormatExprFragment returns [EObject current=null] : (this_LiteralFormatExprFragment_0= ruleLiteralFormatExprFragment | this_TextMacroRef_1= ruleTextMacroRef ) ;
    public final EObject ruleFormatExprFragment() throws RecognitionException {
        EObject current = null;

        EObject this_LiteralFormatExprFragment_0 = null;

        EObject this_TextMacroRef_1 = null;


         enterRule(); 
            
        try {
            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:4541:28: ( (this_LiteralFormatExprFragment_0= ruleLiteralFormatExprFragment | this_TextMacroRef_1= ruleTextMacroRef ) )
            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:4542:1: (this_LiteralFormatExprFragment_0= ruleLiteralFormatExprFragment | this_TextMacroRef_1= ruleTextMacroRef )
            {
            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:4542:1: (this_LiteralFormatExprFragment_0= ruleLiteralFormatExprFragment | this_TextMacroRef_1= ruleTextMacroRef )
            int alt99=2;
            int LA99_0 = input.LA(1);

            if ( (LA99_0==RULE_STRING) ) {
                alt99=1;
            }
            else if ( (LA99_0==107) ) {
                alt99=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 99, 0, input);

                throw nvae;
            }
            switch (alt99) {
                case 1 :
                    // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:4543:5: this_LiteralFormatExprFragment_0= ruleLiteralFormatExprFragment
                    {
                     
                            newCompositeNode(grammarAccess.getFormatExprFragmentAccess().getLiteralFormatExprFragmentParserRuleCall_0()); 
                        
                    pushFollow(FOLLOW_ruleLiteralFormatExprFragment_in_ruleFormatExprFragment9848);
                    this_LiteralFormatExprFragment_0=ruleLiteralFormatExprFragment();

                    state._fsp--;

                     
                            current = this_LiteralFormatExprFragment_0; 
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;
                case 2 :
                    // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:4553:5: this_TextMacroRef_1= ruleTextMacroRef
                    {
                     
                            newCompositeNode(grammarAccess.getFormatExprFragmentAccess().getTextMacroRefParserRuleCall_1()); 
                        
                    pushFollow(FOLLOW_ruleTextMacroRef_in_ruleFormatExprFragment9875);
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
    // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:4569:1: entryRuleLiteralFormatExprFragment returns [EObject current=null] : iv_ruleLiteralFormatExprFragment= ruleLiteralFormatExprFragment EOF ;
    public final EObject entryRuleLiteralFormatExprFragment() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleLiteralFormatExprFragment = null;


        try {
            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:4570:2: (iv_ruleLiteralFormatExprFragment= ruleLiteralFormatExprFragment EOF )
            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:4571:2: iv_ruleLiteralFormatExprFragment= ruleLiteralFormatExprFragment EOF
            {
             newCompositeNode(grammarAccess.getLiteralFormatExprFragmentRule()); 
            pushFollow(FOLLOW_ruleLiteralFormatExprFragment_in_entryRuleLiteralFormatExprFragment9910);
            iv_ruleLiteralFormatExprFragment=ruleLiteralFormatExprFragment();

            state._fsp--;

             current =iv_ruleLiteralFormatExprFragment; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleLiteralFormatExprFragment9920); 

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
    // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:4578:1: ruleLiteralFormatExprFragment returns [EObject current=null] : ( (lv_value_0_0= RULE_STRING ) ) ;
    public final EObject ruleLiteralFormatExprFragment() throws RecognitionException {
        EObject current = null;

        Token lv_value_0_0=null;

         enterRule(); 
            
        try {
            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:4581:28: ( ( (lv_value_0_0= RULE_STRING ) ) )
            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:4582:1: ( (lv_value_0_0= RULE_STRING ) )
            {
            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:4582:1: ( (lv_value_0_0= RULE_STRING ) )
            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:4583:1: (lv_value_0_0= RULE_STRING )
            {
            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:4583:1: (lv_value_0_0= RULE_STRING )
            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:4584:3: lv_value_0_0= RULE_STRING
            {
            lv_value_0_0=(Token)match(input,RULE_STRING,FOLLOW_RULE_STRING_in_ruleLiteralFormatExprFragment9961); 

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
    // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:4608:1: entryRuleTextMacro returns [EObject current=null] : iv_ruleTextMacro= ruleTextMacro EOF ;
    public final EObject entryRuleTextMacro() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleTextMacro = null;


        try {
            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:4609:2: (iv_ruleTextMacro= ruleTextMacro EOF )
            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:4610:2: iv_ruleTextMacro= ruleTextMacro EOF
            {
             newCompositeNode(grammarAccess.getTextMacroRule()); 
            pushFollow(FOLLOW_ruleTextMacro_in_entryRuleTextMacro10001);
            iv_ruleTextMacro=ruleTextMacro();

            state._fsp--;

             current =iv_ruleTextMacro; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleTextMacro10011); 

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
    // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:4617:1: ruleTextMacro returns [EObject current=null] : (otherlv_0= 'Macro:' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' (otherlv_3= 'label:' ( (lv_label_4_0= RULE_STRING ) ) )? (otherlv_5= 'description:' ( (lv_description_6_0= RULE_STRING ) ) )? otherlv_7= 'value:' ( (lv_macroValue_8_0= RULE_STRING ) ) otherlv_9= '}' ) ;
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
            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:4620:28: ( (otherlv_0= 'Macro:' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' (otherlv_3= 'label:' ( (lv_label_4_0= RULE_STRING ) ) )? (otherlv_5= 'description:' ( (lv_description_6_0= RULE_STRING ) ) )? otherlv_7= 'value:' ( (lv_macroValue_8_0= RULE_STRING ) ) otherlv_9= '}' ) )
            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:4621:1: (otherlv_0= 'Macro:' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' (otherlv_3= 'label:' ( (lv_label_4_0= RULE_STRING ) ) )? (otherlv_5= 'description:' ( (lv_description_6_0= RULE_STRING ) ) )? otherlv_7= 'value:' ( (lv_macroValue_8_0= RULE_STRING ) ) otherlv_9= '}' )
            {
            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:4621:1: (otherlv_0= 'Macro:' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' (otherlv_3= 'label:' ( (lv_label_4_0= RULE_STRING ) ) )? (otherlv_5= 'description:' ( (lv_description_6_0= RULE_STRING ) ) )? otherlv_7= 'value:' ( (lv_macroValue_8_0= RULE_STRING ) ) otherlv_9= '}' )
            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:4621:3: otherlv_0= 'Macro:' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' (otherlv_3= 'label:' ( (lv_label_4_0= RULE_STRING ) ) )? (otherlv_5= 'description:' ( (lv_description_6_0= RULE_STRING ) ) )? otherlv_7= 'value:' ( (lv_macroValue_8_0= RULE_STRING ) ) otherlv_9= '}'
            {
            otherlv_0=(Token)match(input,106,FOLLOW_106_in_ruleTextMacro10048); 

                	newLeafNode(otherlv_0, grammarAccess.getTextMacroAccess().getMacroKeyword_0());
                
            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:4625:1: ( (lv_name_1_0= RULE_ID ) )
            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:4626:1: (lv_name_1_0= RULE_ID )
            {
            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:4626:1: (lv_name_1_0= RULE_ID )
            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:4627:3: lv_name_1_0= RULE_ID
            {
            lv_name_1_0=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleTextMacro10065); 

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

            otherlv_2=(Token)match(input,22,FOLLOW_22_in_ruleTextMacro10082); 

                	newLeafNode(otherlv_2, grammarAccess.getTextMacroAccess().getLeftCurlyBracketKeyword_2());
                
            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:4647:1: (otherlv_3= 'label:' ( (lv_label_4_0= RULE_STRING ) ) )?
            int alt100=2;
            int LA100_0 = input.LA(1);

            if ( (LA100_0==13) ) {
                alt100=1;
            }
            switch (alt100) {
                case 1 :
                    // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:4647:3: otherlv_3= 'label:' ( (lv_label_4_0= RULE_STRING ) )
                    {
                    otherlv_3=(Token)match(input,13,FOLLOW_13_in_ruleTextMacro10095); 

                        	newLeafNode(otherlv_3, grammarAccess.getTextMacroAccess().getLabelKeyword_3_0());
                        
                    // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:4651:1: ( (lv_label_4_0= RULE_STRING ) )
                    // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:4652:1: (lv_label_4_0= RULE_STRING )
                    {
                    // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:4652:1: (lv_label_4_0= RULE_STRING )
                    // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:4653:3: lv_label_4_0= RULE_STRING
                    {
                    lv_label_4_0=(Token)match(input,RULE_STRING,FOLLOW_RULE_STRING_in_ruleTextMacro10112); 

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

            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:4669:4: (otherlv_5= 'description:' ( (lv_description_6_0= RULE_STRING ) ) )?
            int alt101=2;
            int LA101_0 = input.LA(1);

            if ( (LA101_0==17) ) {
                alt101=1;
            }
            switch (alt101) {
                case 1 :
                    // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:4669:6: otherlv_5= 'description:' ( (lv_description_6_0= RULE_STRING ) )
                    {
                    otherlv_5=(Token)match(input,17,FOLLOW_17_in_ruleTextMacro10132); 

                        	newLeafNode(otherlv_5, grammarAccess.getTextMacroAccess().getDescriptionKeyword_4_0());
                        
                    // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:4673:1: ( (lv_description_6_0= RULE_STRING ) )
                    // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:4674:1: (lv_description_6_0= RULE_STRING )
                    {
                    // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:4674:1: (lv_description_6_0= RULE_STRING )
                    // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:4675:3: lv_description_6_0= RULE_STRING
                    {
                    lv_description_6_0=(Token)match(input,RULE_STRING,FOLLOW_RULE_STRING_in_ruleTextMacro10149); 

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

            otherlv_7=(Token)match(input,68,FOLLOW_68_in_ruleTextMacro10168); 

                	newLeafNode(otherlv_7, grammarAccess.getTextMacroAccess().getValueKeyword_5());
                
            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:4695:1: ( (lv_macroValue_8_0= RULE_STRING ) )
            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:4696:1: (lv_macroValue_8_0= RULE_STRING )
            {
            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:4696:1: (lv_macroValue_8_0= RULE_STRING )
            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:4697:3: lv_macroValue_8_0= RULE_STRING
            {
            lv_macroValue_8_0=(Token)match(input,RULE_STRING,FOLLOW_RULE_STRING_in_ruleTextMacro10185); 

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

            otherlv_9=(Token)match(input,30,FOLLOW_30_in_ruleTextMacro10202); 

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
    // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:4725:1: entryRuleTextMacroRef returns [EObject current=null] : iv_ruleTextMacroRef= ruleTextMacroRef EOF ;
    public final EObject entryRuleTextMacroRef() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleTextMacroRef = null;


        try {
            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:4726:2: (iv_ruleTextMacroRef= ruleTextMacroRef EOF )
            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:4727:2: iv_ruleTextMacroRef= ruleTextMacroRef EOF
            {
             newCompositeNode(grammarAccess.getTextMacroRefRule()); 
            pushFollow(FOLLOW_ruleTextMacroRef_in_entryRuleTextMacroRef10238);
            iv_ruleTextMacroRef=ruleTextMacroRef();

            state._fsp--;

             current =iv_ruleTextMacroRef; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleTextMacroRef10248); 

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
    // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:4734:1: ruleTextMacroRef returns [EObject current=null] : (otherlv_0= '#' ( (otherlv_1= RULE_ID ) ) ) ;
    public final EObject ruleTextMacroRef() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;

         enterRule(); 
            
        try {
            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:4737:28: ( (otherlv_0= '#' ( (otherlv_1= RULE_ID ) ) ) )
            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:4738:1: (otherlv_0= '#' ( (otherlv_1= RULE_ID ) ) )
            {
            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:4738:1: (otherlv_0= '#' ( (otherlv_1= RULE_ID ) ) )
            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:4738:3: otherlv_0= '#' ( (otherlv_1= RULE_ID ) )
            {
            otherlv_0=(Token)match(input,107,FOLLOW_107_in_ruleTextMacroRef10285); 

                	newLeafNode(otherlv_0, grammarAccess.getTextMacroRefAccess().getNumberSignKeyword_0());
                
            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:4742:1: ( (otherlv_1= RULE_ID ) )
            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:4743:1: (otherlv_1= RULE_ID )
            {
            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:4743:1: (otherlv_1= RULE_ID )
            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:4744:3: otherlv_1= RULE_ID
            {

            			if (current==null) {
            	            current = createModelElement(grammarAccess.getTextMacroRefRule());
            	        }
                    
            otherlv_1=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleTextMacroRef10305); 

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
    // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:4763:1: ruleVALUE_CONVERTER_CATEGORY_MDSL returns [Enumerator current=null] : ( (enumLiteral_0= 'DATE' ) | (enumLiteral_1= 'DATETIME' ) | (enumLiteral_2= 'INTEGER' ) | (enumLiteral_3= 'FLOAT' ) | (enumLiteral_4= 'DOUBLE' ) | (enumLiteral_5= 'XTEXT' ) ) ;
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
            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:4765:28: ( ( (enumLiteral_0= 'DATE' ) | (enumLiteral_1= 'DATETIME' ) | (enumLiteral_2= 'INTEGER' ) | (enumLiteral_3= 'FLOAT' ) | (enumLiteral_4= 'DOUBLE' ) | (enumLiteral_5= 'XTEXT' ) ) )
            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:4766:1: ( (enumLiteral_0= 'DATE' ) | (enumLiteral_1= 'DATETIME' ) | (enumLiteral_2= 'INTEGER' ) | (enumLiteral_3= 'FLOAT' ) | (enumLiteral_4= 'DOUBLE' ) | (enumLiteral_5= 'XTEXT' ) )
            {
            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:4766:1: ( (enumLiteral_0= 'DATE' ) | (enumLiteral_1= 'DATETIME' ) | (enumLiteral_2= 'INTEGER' ) | (enumLiteral_3= 'FLOAT' ) | (enumLiteral_4= 'DOUBLE' ) | (enumLiteral_5= 'XTEXT' ) )
            int alt102=6;
            switch ( input.LA(1) ) {
            case 108:
                {
                alt102=1;
                }
                break;
            case 109:
                {
                alt102=2;
                }
                break;
            case 110:
                {
                alt102=3;
                }
                break;
            case 111:
                {
                alt102=4;
                }
                break;
            case 112:
                {
                alt102=5;
                }
                break;
            case 113:
                {
                alt102=6;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 102, 0, input);

                throw nvae;
            }

            switch (alt102) {
                case 1 :
                    // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:4766:2: (enumLiteral_0= 'DATE' )
                    {
                    // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:4766:2: (enumLiteral_0= 'DATE' )
                    // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:4766:4: enumLiteral_0= 'DATE'
                    {
                    enumLiteral_0=(Token)match(input,108,FOLLOW_108_in_ruleVALUE_CONVERTER_CATEGORY_MDSL10355); 

                            current = grammarAccess.getVALUE_CONVERTER_CATEGORY_MDSLAccess().getDATEEnumLiteralDeclaration_0().getEnumLiteral().getInstance();
                            newLeafNode(enumLiteral_0, grammarAccess.getVALUE_CONVERTER_CATEGORY_MDSLAccess().getDATEEnumLiteralDeclaration_0()); 
                        

                    }


                    }
                    break;
                case 2 :
                    // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:4772:6: (enumLiteral_1= 'DATETIME' )
                    {
                    // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:4772:6: (enumLiteral_1= 'DATETIME' )
                    // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:4772:8: enumLiteral_1= 'DATETIME'
                    {
                    enumLiteral_1=(Token)match(input,109,FOLLOW_109_in_ruleVALUE_CONVERTER_CATEGORY_MDSL10372); 

                            current = grammarAccess.getVALUE_CONVERTER_CATEGORY_MDSLAccess().getDATETIMEEnumLiteralDeclaration_1().getEnumLiteral().getInstance();
                            newLeafNode(enumLiteral_1, grammarAccess.getVALUE_CONVERTER_CATEGORY_MDSLAccess().getDATETIMEEnumLiteralDeclaration_1()); 
                        

                    }


                    }
                    break;
                case 3 :
                    // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:4778:6: (enumLiteral_2= 'INTEGER' )
                    {
                    // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:4778:6: (enumLiteral_2= 'INTEGER' )
                    // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:4778:8: enumLiteral_2= 'INTEGER'
                    {
                    enumLiteral_2=(Token)match(input,110,FOLLOW_110_in_ruleVALUE_CONVERTER_CATEGORY_MDSL10389); 

                            current = grammarAccess.getVALUE_CONVERTER_CATEGORY_MDSLAccess().getINTEGEREnumLiteralDeclaration_2().getEnumLiteral().getInstance();
                            newLeafNode(enumLiteral_2, grammarAccess.getVALUE_CONVERTER_CATEGORY_MDSLAccess().getINTEGEREnumLiteralDeclaration_2()); 
                        

                    }


                    }
                    break;
                case 4 :
                    // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:4784:6: (enumLiteral_3= 'FLOAT' )
                    {
                    // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:4784:6: (enumLiteral_3= 'FLOAT' )
                    // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:4784:8: enumLiteral_3= 'FLOAT'
                    {
                    enumLiteral_3=(Token)match(input,111,FOLLOW_111_in_ruleVALUE_CONVERTER_CATEGORY_MDSL10406); 

                            current = grammarAccess.getVALUE_CONVERTER_CATEGORY_MDSLAccess().getFLOATEnumLiteralDeclaration_3().getEnumLiteral().getInstance();
                            newLeafNode(enumLiteral_3, grammarAccess.getVALUE_CONVERTER_CATEGORY_MDSLAccess().getFLOATEnumLiteralDeclaration_3()); 
                        

                    }


                    }
                    break;
                case 5 :
                    // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:4790:6: (enumLiteral_4= 'DOUBLE' )
                    {
                    // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:4790:6: (enumLiteral_4= 'DOUBLE' )
                    // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:4790:8: enumLiteral_4= 'DOUBLE'
                    {
                    enumLiteral_4=(Token)match(input,112,FOLLOW_112_in_ruleVALUE_CONVERTER_CATEGORY_MDSL10423); 

                            current = grammarAccess.getVALUE_CONVERTER_CATEGORY_MDSLAccess().getDOUBLEEnumLiteralDeclaration_4().getEnumLiteral().getInstance();
                            newLeafNode(enumLiteral_4, grammarAccess.getVALUE_CONVERTER_CATEGORY_MDSLAccess().getDOUBLEEnumLiteralDeclaration_4()); 
                        

                    }


                    }
                    break;
                case 6 :
                    // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:4796:6: (enumLiteral_5= 'XTEXT' )
                    {
                    // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:4796:6: (enumLiteral_5= 'XTEXT' )
                    // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:4796:8: enumLiteral_5= 'XTEXT'
                    {
                    enumLiteral_5=(Token)match(input,113,FOLLOW_113_in_ruleVALUE_CONVERTER_CATEGORY_MDSL10440); 

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
    // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:4806:1: ruleWIDGET_CATEGORY_MDSL returns [Enumerator current=null] : ( (enumLiteral_0= 'OUTPUTTEXT_WIDGET' ) | (enumLiteral_1= 'NAVIGATION_WIDGET' ) | (enumLiteral_2= 'TEXT_WIDGET' ) | (enumLiteral_3= 'BOOL_WIDGET' ) | (enumLiteral_4= 'DATE_WIDGET' ) | (enumLiteral_5= 'NUMBER_WIDGET' ) | (enumLiteral_6= 'SINGLE_SELECT_WIDGET' ) | (enumLiteral_7= 'MULTI_SELECT_WIDGET' ) | (enumLiteral_8= 'XTEXT_EDITOR' ) | (enumLiteral_9= 'XTEXT_TEXT_EDITOR' ) | (enumLiteral_10= 'FLEXIBLE_WIDGET' ) ) ;
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
            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:4808:28: ( ( (enumLiteral_0= 'OUTPUTTEXT_WIDGET' ) | (enumLiteral_1= 'NAVIGATION_WIDGET' ) | (enumLiteral_2= 'TEXT_WIDGET' ) | (enumLiteral_3= 'BOOL_WIDGET' ) | (enumLiteral_4= 'DATE_WIDGET' ) | (enumLiteral_5= 'NUMBER_WIDGET' ) | (enumLiteral_6= 'SINGLE_SELECT_WIDGET' ) | (enumLiteral_7= 'MULTI_SELECT_WIDGET' ) | (enumLiteral_8= 'XTEXT_EDITOR' ) | (enumLiteral_9= 'XTEXT_TEXT_EDITOR' ) | (enumLiteral_10= 'FLEXIBLE_WIDGET' ) ) )
            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:4809:1: ( (enumLiteral_0= 'OUTPUTTEXT_WIDGET' ) | (enumLiteral_1= 'NAVIGATION_WIDGET' ) | (enumLiteral_2= 'TEXT_WIDGET' ) | (enumLiteral_3= 'BOOL_WIDGET' ) | (enumLiteral_4= 'DATE_WIDGET' ) | (enumLiteral_5= 'NUMBER_WIDGET' ) | (enumLiteral_6= 'SINGLE_SELECT_WIDGET' ) | (enumLiteral_7= 'MULTI_SELECT_WIDGET' ) | (enumLiteral_8= 'XTEXT_EDITOR' ) | (enumLiteral_9= 'XTEXT_TEXT_EDITOR' ) | (enumLiteral_10= 'FLEXIBLE_WIDGET' ) )
            {
            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:4809:1: ( (enumLiteral_0= 'OUTPUTTEXT_WIDGET' ) | (enumLiteral_1= 'NAVIGATION_WIDGET' ) | (enumLiteral_2= 'TEXT_WIDGET' ) | (enumLiteral_3= 'BOOL_WIDGET' ) | (enumLiteral_4= 'DATE_WIDGET' ) | (enumLiteral_5= 'NUMBER_WIDGET' ) | (enumLiteral_6= 'SINGLE_SELECT_WIDGET' ) | (enumLiteral_7= 'MULTI_SELECT_WIDGET' ) | (enumLiteral_8= 'XTEXT_EDITOR' ) | (enumLiteral_9= 'XTEXT_TEXT_EDITOR' ) | (enumLiteral_10= 'FLEXIBLE_WIDGET' ) )
            int alt103=11;
            switch ( input.LA(1) ) {
            case 114:
                {
                alt103=1;
                }
                break;
            case 115:
                {
                alt103=2;
                }
                break;
            case 116:
                {
                alt103=3;
                }
                break;
            case 117:
                {
                alt103=4;
                }
                break;
            case 118:
                {
                alt103=5;
                }
                break;
            case 119:
                {
                alt103=6;
                }
                break;
            case 120:
                {
                alt103=7;
                }
                break;
            case 121:
                {
                alt103=8;
                }
                break;
            case 122:
                {
                alt103=9;
                }
                break;
            case 123:
                {
                alt103=10;
                }
                break;
            case 124:
                {
                alt103=11;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 103, 0, input);

                throw nvae;
            }

            switch (alt103) {
                case 1 :
                    // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:4809:2: (enumLiteral_0= 'OUTPUTTEXT_WIDGET' )
                    {
                    // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:4809:2: (enumLiteral_0= 'OUTPUTTEXT_WIDGET' )
                    // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:4809:4: enumLiteral_0= 'OUTPUTTEXT_WIDGET'
                    {
                    enumLiteral_0=(Token)match(input,114,FOLLOW_114_in_ruleWIDGET_CATEGORY_MDSL10485); 

                            current = grammarAccess.getWIDGET_CATEGORY_MDSLAccess().getOUTPUTTEXT_WIDGETEnumLiteralDeclaration_0().getEnumLiteral().getInstance();
                            newLeafNode(enumLiteral_0, grammarAccess.getWIDGET_CATEGORY_MDSLAccess().getOUTPUTTEXT_WIDGETEnumLiteralDeclaration_0()); 
                        

                    }


                    }
                    break;
                case 2 :
                    // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:4815:6: (enumLiteral_1= 'NAVIGATION_WIDGET' )
                    {
                    // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:4815:6: (enumLiteral_1= 'NAVIGATION_WIDGET' )
                    // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:4815:8: enumLiteral_1= 'NAVIGATION_WIDGET'
                    {
                    enumLiteral_1=(Token)match(input,115,FOLLOW_115_in_ruleWIDGET_CATEGORY_MDSL10502); 

                            current = grammarAccess.getWIDGET_CATEGORY_MDSLAccess().getNAVIGATION_WIDGETEnumLiteralDeclaration_1().getEnumLiteral().getInstance();
                            newLeafNode(enumLiteral_1, grammarAccess.getWIDGET_CATEGORY_MDSLAccess().getNAVIGATION_WIDGETEnumLiteralDeclaration_1()); 
                        

                    }


                    }
                    break;
                case 3 :
                    // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:4821:6: (enumLiteral_2= 'TEXT_WIDGET' )
                    {
                    // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:4821:6: (enumLiteral_2= 'TEXT_WIDGET' )
                    // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:4821:8: enumLiteral_2= 'TEXT_WIDGET'
                    {
                    enumLiteral_2=(Token)match(input,116,FOLLOW_116_in_ruleWIDGET_CATEGORY_MDSL10519); 

                            current = grammarAccess.getWIDGET_CATEGORY_MDSLAccess().getTEXT_WIDGETEnumLiteralDeclaration_2().getEnumLiteral().getInstance();
                            newLeafNode(enumLiteral_2, grammarAccess.getWIDGET_CATEGORY_MDSLAccess().getTEXT_WIDGETEnumLiteralDeclaration_2()); 
                        

                    }


                    }
                    break;
                case 4 :
                    // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:4827:6: (enumLiteral_3= 'BOOL_WIDGET' )
                    {
                    // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:4827:6: (enumLiteral_3= 'BOOL_WIDGET' )
                    // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:4827:8: enumLiteral_3= 'BOOL_WIDGET'
                    {
                    enumLiteral_3=(Token)match(input,117,FOLLOW_117_in_ruleWIDGET_CATEGORY_MDSL10536); 

                            current = grammarAccess.getWIDGET_CATEGORY_MDSLAccess().getBOOL_WIDGETEnumLiteralDeclaration_3().getEnumLiteral().getInstance();
                            newLeafNode(enumLiteral_3, grammarAccess.getWIDGET_CATEGORY_MDSLAccess().getBOOL_WIDGETEnumLiteralDeclaration_3()); 
                        

                    }


                    }
                    break;
                case 5 :
                    // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:4833:6: (enumLiteral_4= 'DATE_WIDGET' )
                    {
                    // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:4833:6: (enumLiteral_4= 'DATE_WIDGET' )
                    // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:4833:8: enumLiteral_4= 'DATE_WIDGET'
                    {
                    enumLiteral_4=(Token)match(input,118,FOLLOW_118_in_ruleWIDGET_CATEGORY_MDSL10553); 

                            current = grammarAccess.getWIDGET_CATEGORY_MDSLAccess().getDATE_WIDGETEnumLiteralDeclaration_4().getEnumLiteral().getInstance();
                            newLeafNode(enumLiteral_4, grammarAccess.getWIDGET_CATEGORY_MDSLAccess().getDATE_WIDGETEnumLiteralDeclaration_4()); 
                        

                    }


                    }
                    break;
                case 6 :
                    // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:4839:6: (enumLiteral_5= 'NUMBER_WIDGET' )
                    {
                    // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:4839:6: (enumLiteral_5= 'NUMBER_WIDGET' )
                    // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:4839:8: enumLiteral_5= 'NUMBER_WIDGET'
                    {
                    enumLiteral_5=(Token)match(input,119,FOLLOW_119_in_ruleWIDGET_CATEGORY_MDSL10570); 

                            current = grammarAccess.getWIDGET_CATEGORY_MDSLAccess().getNUMBER_WIDGETEnumLiteralDeclaration_5().getEnumLiteral().getInstance();
                            newLeafNode(enumLiteral_5, grammarAccess.getWIDGET_CATEGORY_MDSLAccess().getNUMBER_WIDGETEnumLiteralDeclaration_5()); 
                        

                    }


                    }
                    break;
                case 7 :
                    // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:4845:6: (enumLiteral_6= 'SINGLE_SELECT_WIDGET' )
                    {
                    // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:4845:6: (enumLiteral_6= 'SINGLE_SELECT_WIDGET' )
                    // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:4845:8: enumLiteral_6= 'SINGLE_SELECT_WIDGET'
                    {
                    enumLiteral_6=(Token)match(input,120,FOLLOW_120_in_ruleWIDGET_CATEGORY_MDSL10587); 

                            current = grammarAccess.getWIDGET_CATEGORY_MDSLAccess().getSINGLE_SELECT_WIDGETEnumLiteralDeclaration_6().getEnumLiteral().getInstance();
                            newLeafNode(enumLiteral_6, grammarAccess.getWIDGET_CATEGORY_MDSLAccess().getSINGLE_SELECT_WIDGETEnumLiteralDeclaration_6()); 
                        

                    }


                    }
                    break;
                case 8 :
                    // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:4851:6: (enumLiteral_7= 'MULTI_SELECT_WIDGET' )
                    {
                    // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:4851:6: (enumLiteral_7= 'MULTI_SELECT_WIDGET' )
                    // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:4851:8: enumLiteral_7= 'MULTI_SELECT_WIDGET'
                    {
                    enumLiteral_7=(Token)match(input,121,FOLLOW_121_in_ruleWIDGET_CATEGORY_MDSL10604); 

                            current = grammarAccess.getWIDGET_CATEGORY_MDSLAccess().getMULTI_SELECT_WIDGETEnumLiteralDeclaration_7().getEnumLiteral().getInstance();
                            newLeafNode(enumLiteral_7, grammarAccess.getWIDGET_CATEGORY_MDSLAccess().getMULTI_SELECT_WIDGETEnumLiteralDeclaration_7()); 
                        

                    }


                    }
                    break;
                case 9 :
                    // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:4857:6: (enumLiteral_8= 'XTEXT_EDITOR' )
                    {
                    // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:4857:6: (enumLiteral_8= 'XTEXT_EDITOR' )
                    // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:4857:8: enumLiteral_8= 'XTEXT_EDITOR'
                    {
                    enumLiteral_8=(Token)match(input,122,FOLLOW_122_in_ruleWIDGET_CATEGORY_MDSL10621); 

                            current = grammarAccess.getWIDGET_CATEGORY_MDSLAccess().getXTEXT_EDITOREnumLiteralDeclaration_8().getEnumLiteral().getInstance();
                            newLeafNode(enumLiteral_8, grammarAccess.getWIDGET_CATEGORY_MDSLAccess().getXTEXT_EDITOREnumLiteralDeclaration_8()); 
                        

                    }


                    }
                    break;
                case 10 :
                    // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:4863:6: (enumLiteral_9= 'XTEXT_TEXT_EDITOR' )
                    {
                    // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:4863:6: (enumLiteral_9= 'XTEXT_TEXT_EDITOR' )
                    // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:4863:8: enumLiteral_9= 'XTEXT_TEXT_EDITOR'
                    {
                    enumLiteral_9=(Token)match(input,123,FOLLOW_123_in_ruleWIDGET_CATEGORY_MDSL10638); 

                            current = grammarAccess.getWIDGET_CATEGORY_MDSLAccess().getXTEXT_TEXT_EDITOREnumLiteralDeclaration_9().getEnumLiteral().getInstance();
                            newLeafNode(enumLiteral_9, grammarAccess.getWIDGET_CATEGORY_MDSLAccess().getXTEXT_TEXT_EDITOREnumLiteralDeclaration_9()); 
                        

                    }


                    }
                    break;
                case 11 :
                    // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:4869:6: (enumLiteral_10= 'FLEXIBLE_WIDGET' )
                    {
                    // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:4869:6: (enumLiteral_10= 'FLEXIBLE_WIDGET' )
                    // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:4869:8: enumLiteral_10= 'FLEXIBLE_WIDGET'
                    {
                    enumLiteral_10=(Token)match(input,124,FOLLOW_124_in_ruleWIDGET_CATEGORY_MDSL10655); 

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
    // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:4879:1: ruleCOMMAND_CATEGORY_MDSL returns [Enumerator current=null] : ( (enumLiteral_0= 'UPDATE_COMMAND' ) | (enumLiteral_1= 'GLOBAL_COMMAND' ) | (enumLiteral_2= 'ITEM_COMMAND' ) ) ;
    public final Enumerator ruleCOMMAND_CATEGORY_MDSL() throws RecognitionException {
        Enumerator current = null;

        Token enumLiteral_0=null;
        Token enumLiteral_1=null;
        Token enumLiteral_2=null;

         enterRule(); 
        try {
            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:4881:28: ( ( (enumLiteral_0= 'UPDATE_COMMAND' ) | (enumLiteral_1= 'GLOBAL_COMMAND' ) | (enumLiteral_2= 'ITEM_COMMAND' ) ) )
            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:4882:1: ( (enumLiteral_0= 'UPDATE_COMMAND' ) | (enumLiteral_1= 'GLOBAL_COMMAND' ) | (enumLiteral_2= 'ITEM_COMMAND' ) )
            {
            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:4882:1: ( (enumLiteral_0= 'UPDATE_COMMAND' ) | (enumLiteral_1= 'GLOBAL_COMMAND' ) | (enumLiteral_2= 'ITEM_COMMAND' ) )
            int alt104=3;
            switch ( input.LA(1) ) {
            case 125:
                {
                alt104=1;
                }
                break;
            case 126:
                {
                alt104=2;
                }
                break;
            case 127:
                {
                alt104=3;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 104, 0, input);

                throw nvae;
            }

            switch (alt104) {
                case 1 :
                    // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:4882:2: (enumLiteral_0= 'UPDATE_COMMAND' )
                    {
                    // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:4882:2: (enumLiteral_0= 'UPDATE_COMMAND' )
                    // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:4882:4: enumLiteral_0= 'UPDATE_COMMAND'
                    {
                    enumLiteral_0=(Token)match(input,125,FOLLOW_125_in_ruleCOMMAND_CATEGORY_MDSL10700); 

                            current = grammarAccess.getCOMMAND_CATEGORY_MDSLAccess().getUPDATE_COMMANDEnumLiteralDeclaration_0().getEnumLiteral().getInstance();
                            newLeafNode(enumLiteral_0, grammarAccess.getCOMMAND_CATEGORY_MDSLAccess().getUPDATE_COMMANDEnumLiteralDeclaration_0()); 
                        

                    }


                    }
                    break;
                case 2 :
                    // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:4888:6: (enumLiteral_1= 'GLOBAL_COMMAND' )
                    {
                    // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:4888:6: (enumLiteral_1= 'GLOBAL_COMMAND' )
                    // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:4888:8: enumLiteral_1= 'GLOBAL_COMMAND'
                    {
                    enumLiteral_1=(Token)match(input,126,FOLLOW_126_in_ruleCOMMAND_CATEGORY_MDSL10717); 

                            current = grammarAccess.getCOMMAND_CATEGORY_MDSLAccess().getGLOBAL_COMMANDEnumLiteralDeclaration_1().getEnumLiteral().getInstance();
                            newLeafNode(enumLiteral_1, grammarAccess.getCOMMAND_CATEGORY_MDSLAccess().getGLOBAL_COMMANDEnumLiteralDeclaration_1()); 
                        

                    }


                    }
                    break;
                case 3 :
                    // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:4894:6: (enumLiteral_2= 'ITEM_COMMAND' )
                    {
                    // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:4894:6: (enumLiteral_2= 'ITEM_COMMAND' )
                    // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:4894:8: enumLiteral_2= 'ITEM_COMMAND'
                    {
                    enumLiteral_2=(Token)match(input,127,FOLLOW_127_in_ruleCOMMAND_CATEGORY_MDSL10734); 

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
    // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:4904:1: ruleQUERY_OPTIMISATION_LEVEL returns [Enumerator current=null] : ( (enumLiteral_0= 'NONE' ) | (enumLiteral_1= 'VIEW' ) | (enumLiteral_2= 'CONTEXT' ) ) ;
    public final Enumerator ruleQUERY_OPTIMISATION_LEVEL() throws RecognitionException {
        Enumerator current = null;

        Token enumLiteral_0=null;
        Token enumLiteral_1=null;
        Token enumLiteral_2=null;

         enterRule(); 
        try {
            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:4906:28: ( ( (enumLiteral_0= 'NONE' ) | (enumLiteral_1= 'VIEW' ) | (enumLiteral_2= 'CONTEXT' ) ) )
            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:4907:1: ( (enumLiteral_0= 'NONE' ) | (enumLiteral_1= 'VIEW' ) | (enumLiteral_2= 'CONTEXT' ) )
            {
            // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:4907:1: ( (enumLiteral_0= 'NONE' ) | (enumLiteral_1= 'VIEW' ) | (enumLiteral_2= 'CONTEXT' ) )
            int alt105=3;
            switch ( input.LA(1) ) {
            case 128:
                {
                alt105=1;
                }
                break;
            case 129:
                {
                alt105=2;
                }
                break;
            case 130:
                {
                alt105=3;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 105, 0, input);

                throw nvae;
            }

            switch (alt105) {
                case 1 :
                    // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:4907:2: (enumLiteral_0= 'NONE' )
                    {
                    // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:4907:2: (enumLiteral_0= 'NONE' )
                    // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:4907:4: enumLiteral_0= 'NONE'
                    {
                    enumLiteral_0=(Token)match(input,128,FOLLOW_128_in_ruleQUERY_OPTIMISATION_LEVEL10779); 

                            current = grammarAccess.getQUERY_OPTIMISATION_LEVELAccess().getNONEEnumLiteralDeclaration_0().getEnumLiteral().getInstance();
                            newLeafNode(enumLiteral_0, grammarAccess.getQUERY_OPTIMISATION_LEVELAccess().getNONEEnumLiteralDeclaration_0()); 
                        

                    }


                    }
                    break;
                case 2 :
                    // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:4913:6: (enumLiteral_1= 'VIEW' )
                    {
                    // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:4913:6: (enumLiteral_1= 'VIEW' )
                    // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:4913:8: enumLiteral_1= 'VIEW'
                    {
                    enumLiteral_1=(Token)match(input,129,FOLLOW_129_in_ruleQUERY_OPTIMISATION_LEVEL10796); 

                            current = grammarAccess.getQUERY_OPTIMISATION_LEVELAccess().getVIEWEnumLiteralDeclaration_1().getEnumLiteral().getInstance();
                            newLeafNode(enumLiteral_1, grammarAccess.getQUERY_OPTIMISATION_LEVELAccess().getVIEWEnumLiteralDeclaration_1()); 
                        

                    }


                    }
                    break;
                case 3 :
                    // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:4919:6: (enumLiteral_2= 'CONTEXT' )
                    {
                    // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:4919:6: (enumLiteral_2= 'CONTEXT' )
                    // ../com.sysord.mad.configDsl/src-gen/com/sysord/mad/configuration/parser/antlr/internal/InternalMadConfigDsl.g:4919:8: enumLiteral_2= 'CONTEXT'
                    {
                    enumLiteral_2=(Token)match(input,130,FOLLOW_130_in_ruleQUERY_OPTIMISATION_LEVEL10813); 

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
    public static final BitSet FOLLOW_ruleImport_in_ruleMADConfiguration131 = new BitSet(new long[]{0x19110A1000310802L,0x0000040200400000L});
    public static final BitSet FOLLOW_ruleMADConfigElement_in_ruleMADConfiguration153 = new BitSet(new long[]{0x19110A1000310002L,0x0000040200400000L});
    public static final BitSet FOLLOW_ruleMADConfigElement_in_entryRuleMADConfigElement190 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleMADConfigElement200 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleLayerMdsl_in_ruleMADConfigElement247 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleForeignModelMdsl_in_ruleMADConfigElement274 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleXtextLanguageDescriptorMdsl_in_ruleMADConfigElement301 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleQueryEvaluatorMdsl_in_ruleMADConfigElement328 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleOCLCustomLibraryMdsl_in_ruleMADConfigElement355 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleQueryDeclaration_in_ruleMADConfigElement382 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleWidgetType_in_ruleMADConfigElement409 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleUITabMdsl_in_ruleMADConfigElement436 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleCommandDeclaration_in_ruleMADConfigElement463 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleTypeConfigurationMdsl_in_ruleMADConfigElement490 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleTextMacro_in_ruleMADConfigElement517 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleI18NBundleMdsl_in_ruleMADConfigElement544 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleIconDescriptorMdsl_in_ruleMADConfigElement571 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleImport_in_entryRuleImport606 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleImport616 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_11_in_ruleImport653 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_STRING_in_ruleImport670 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleClassDescriptorMdsl_in_entryRuleClassDescriptorMdsl711 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleClassDescriptorMdsl721 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleClassDescriptorMdsl763 = new BitSet(new long[]{0x0000000000001002L});
    public static final BitSet FOLLOW_12_in_ruleClassDescriptorMdsl781 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleClassDescriptorMdsl798 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rulePropertyTypeMdsl_in_entryRulePropertyTypeMdsl841 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRulePropertyTypeMdsl851 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_rulePropertyTypeMdsl893 = new BitSet(new long[]{0x0000000000002000L});
    public static final BitSet FOLLOW_13_in_rulePropertyTypeMdsl910 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_STRING_in_rulePropertyTypeMdsl927 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rulePropertyMdsl_in_entryRulePropertyMdsl968 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRulePropertyMdsl978 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_rulePropertyMdsl1023 = new BitSet(new long[]{0x0000000000004000L});
    public static final BitSet FOLLOW_14_in_rulePropertyMdsl1035 = new BitSet(new long[]{0x0000000000000010L,0x0000080000000000L});
    public static final BitSet FOLLOW_rulePropertyValueMdsl_in_rulePropertyMdsl1056 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rulePropertyValueMdsl_in_entryRulePropertyValueMdsl1092 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRulePropertyValueMdsl1102 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rulePropValueExprFragment_in_rulePropertyValueMdsl1148 = new BitSet(new long[]{0x0000000000008002L});
    public static final BitSet FOLLOW_15_in_rulePropertyValueMdsl1161 = new BitSet(new long[]{0x0000000000000010L,0x0000080000000000L});
    public static final BitSet FOLLOW_rulePropValueExprFragment_in_rulePropertyValueMdsl1182 = new BitSet(new long[]{0x0000000000008002L});
    public static final BitSet FOLLOW_rulePropValueExprFragment_in_entryRulePropValueExprFragment1220 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRulePropValueExprFragment1230 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleLiteraPropValueExprFragment_in_rulePropValueExprFragment1277 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleTextMacroRef_in_rulePropValueExprFragment1304 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleLiteraPropValueExprFragment_in_entryRuleLiteraPropValueExprFragment1339 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleLiteraPropValueExprFragment1349 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_STRING_in_ruleLiteraPropValueExprFragment1390 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleIconDescriptorMdsl_in_entryRuleIconDescriptorMdsl1430 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleIconDescriptorMdsl1440 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_16_in_ruleIconDescriptorMdsl1477 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleIconDescriptorMdsl1494 = new BitSet(new long[]{0x00000000000E0000L});
    public static final BitSet FOLLOW_17_in_ruleIconDescriptorMdsl1512 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_STRING_in_ruleIconDescriptorMdsl1529 = new BitSet(new long[]{0x00000000000C0000L});
    public static final BitSet FOLLOW_18_in_ruleIconDescriptorMdsl1550 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_ruleClassDescriptorMdsl_in_ruleIconDescriptorMdsl1571 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_19_in_ruleIconDescriptorMdsl1591 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_STRING_in_ruleIconDescriptorMdsl1608 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleI18NBundleMdsl_in_entryRuleI18NBundleMdsl1651 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleI18NBundleMdsl1661 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_20_in_ruleI18NBundleMdsl1698 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleI18NBundleMdsl1715 = new BitSet(new long[]{0x00000000000E0000L});
    public static final BitSet FOLLOW_17_in_ruleI18NBundleMdsl1733 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_STRING_in_ruleI18NBundleMdsl1750 = new BitSet(new long[]{0x00000000000C0000L});
    public static final BitSet FOLLOW_18_in_ruleI18NBundleMdsl1771 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_ruleClassDescriptorMdsl_in_ruleI18NBundleMdsl1792 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_19_in_ruleI18NBundleMdsl1812 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_STRING_in_ruleI18NBundleMdsl1829 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleForeignModelMdsl_in_entryRuleForeignModelMdsl1872 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleForeignModelMdsl1882 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_21_in_ruleForeignModelMdsl1919 = new BitSet(new long[]{0x0000000000400000L});
    public static final BitSet FOLLOW_22_in_ruleForeignModelMdsl1931 = new BitSet(new long[]{0x0000000000800000L});
    public static final BitSet FOLLOW_23_in_ruleForeignModelMdsl1943 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleForeignModelMdsl1960 = new BitSet(new long[]{0x0000000000002000L});
    public static final BitSet FOLLOW_13_in_ruleForeignModelMdsl1977 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_STRING_in_ruleForeignModelMdsl1994 = new BitSet(new long[]{0x0000000380020000L});
    public static final BitSet FOLLOW_17_in_ruleForeignModelMdsl2012 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_STRING_in_ruleForeignModelMdsl2029 = new BitSet(new long[]{0x0000000380020000L});
    public static final BitSet FOLLOW_ruleModelProviderMdsl_in_ruleForeignModelMdsl2057 = new BitSet(new long[]{0x0000010075000000L});
    public static final BitSet FOLLOW_24_in_ruleForeignModelMdsl2070 = new BitSet(new long[]{0x0000010076000000L});
    public static final BitSet FOLLOW_25_in_ruleForeignModelMdsl2088 = new BitSet(new long[]{0x0000010074000000L});
    public static final BitSet FOLLOW_26_in_ruleForeignModelMdsl2117 = new BitSet(new long[]{0x0000000008000000L});
    public static final BitSet FOLLOW_27_in_ruleForeignModelMdsl2129 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_ruleClassDescriptorMdsl_in_ruleForeignModelMdsl2150 = new BitSet(new long[]{0x0000010070000000L});
    public static final BitSet FOLLOW_28_in_ruleForeignModelMdsl2165 = new BitSet(new long[]{0x0000000008000000L});
    public static final BitSet FOLLOW_27_in_ruleForeignModelMdsl2177 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_ruleClassDescriptorMdsl_in_ruleForeignModelMdsl2198 = new BitSet(new long[]{0x0000010060000000L});
    public static final BitSet FOLLOW_ruleXtextLanguageReference_in_ruleForeignModelMdsl2221 = new BitSet(new long[]{0x0000000060000000L});
    public static final BitSet FOLLOW_29_in_ruleForeignModelMdsl2235 = new BitSet(new long[]{0x0000000000000030L,0x0000089C00000000L});
    public static final BitSet FOLLOW_ruleQuery_in_ruleForeignModelMdsl2256 = new BitSet(new long[]{0x0000000040000000L});
    public static final BitSet FOLLOW_30_in_ruleForeignModelMdsl2270 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleModelProviderMdsl_in_entryRuleModelProviderMdsl2306 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleModelProviderMdsl2316 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleURIModelProviderMdsl_in_ruleModelProviderMdsl2363 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleURIExtensionModelProviderMdsl_in_ruleModelProviderMdsl2390 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleCustomModelProviderMdsl_in_ruleModelProviderMdsl2417 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleURIExtensionModelProviderMdsl_in_entryRuleURIExtensionModelProviderMdsl2452 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleURIExtensionModelProviderMdsl2462 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_31_in_ruleURIExtensionModelProviderMdsl2499 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_STRING_in_ruleURIExtensionModelProviderMdsl2516 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleURIModelProviderMdsl_in_entryRuleURIModelProviderMdsl2557 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleURIModelProviderMdsl2567 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_32_in_ruleURIModelProviderMdsl2604 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_STRING_in_ruleURIModelProviderMdsl2621 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleCustomModelProviderMdsl_in_entryRuleCustomModelProviderMdsl2662 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleCustomModelProviderMdsl2672 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_33_in_ruleCustomModelProviderMdsl2709 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_ruleClassDescriptorMdsl_in_ruleCustomModelProviderMdsl2730 = new BitSet(new long[]{0x0000000400000002L});
    public static final BitSet FOLLOW_34_in_ruleCustomModelProviderMdsl2743 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_STRING_in_ruleCustomModelProviderMdsl2760 = new BitSet(new long[]{0x0000000800000002L});
    public static final BitSet FOLLOW_35_in_ruleCustomModelProviderMdsl2778 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_STRING_in_ruleCustomModelProviderMdsl2795 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleXtextLanguageDescriptorMdsl_in_entryRuleXtextLanguageDescriptorMdsl2840 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleXtextLanguageDescriptorMdsl2850 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_36_in_ruleXtextLanguageDescriptorMdsl2887 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleXtextLanguageDescriptorMdsl2904 = new BitSet(new long[]{0x0000002000000000L});
    public static final BitSet FOLLOW_37_in_ruleXtextLanguageDescriptorMdsl2921 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleXtextLanguageDescriptorMdsl2938 = new BitSet(new long[]{0x0000004000000000L});
    public static final BitSet FOLLOW_38_in_ruleXtextLanguageDescriptorMdsl2955 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleXtextLanguageDescriptorMdsl2972 = new BitSet(new long[]{0x0000008000000000L});
    public static final BitSet FOLLOW_39_in_ruleXtextLanguageDescriptorMdsl2989 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleXtextLanguageDescriptorMdsl3006 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleXtextLanguageReference_in_entryRuleXtextLanguageReference3047 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleXtextLanguageReference3057 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_40_in_ruleXtextLanguageReference3094 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleXtextLanguageReference3114 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleOCLCustomLibraryMdsl_in_entryRuleOCLCustomLibraryMdsl3150 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleOCLCustomLibraryMdsl3160 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_41_in_ruleOCLCustomLibraryMdsl3197 = new BitSet(new long[]{0x0000000000400000L});
    public static final BitSet FOLLOW_22_in_ruleOCLCustomLibraryMdsl3209 = new BitSet(new long[]{0x0000000000002000L});
    public static final BitSet FOLLOW_13_in_ruleOCLCustomLibraryMdsl3221 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_STRING_in_ruleOCLCustomLibraryMdsl3238 = new BitSet(new long[]{0x0000040000000000L});
    public static final BitSet FOLLOW_42_in_ruleOCLCustomLibraryMdsl3255 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_ruleClassDescriptorMdsl_in_ruleOCLCustomLibraryMdsl3276 = new BitSet(new long[]{0x0000000040020000L});
    public static final BitSet FOLLOW_17_in_ruleOCLCustomLibraryMdsl3289 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_STRING_in_ruleOCLCustomLibraryMdsl3306 = new BitSet(new long[]{0x0000000040000000L});
    public static final BitSet FOLLOW_30_in_ruleOCLCustomLibraryMdsl3325 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleQueryEvaluatorMdsl_in_entryRuleQueryEvaluatorMdsl3361 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleQueryEvaluatorMdsl3371 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_43_in_ruleQueryEvaluatorMdsl3408 = new BitSet(new long[]{0x0000000000400000L});
    public static final BitSet FOLLOW_22_in_ruleQueryEvaluatorMdsl3420 = new BitSet(new long[]{0x0000100000000000L});
    public static final BitSet FOLLOW_44_in_ruleQueryEvaluatorMdsl3432 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleQueryEvaluatorMdsl3449 = new BitSet(new long[]{0x0000000000002000L});
    public static final BitSet FOLLOW_13_in_ruleQueryEvaluatorMdsl3466 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_STRING_in_ruleQueryEvaluatorMdsl3483 = new BitSet(new long[]{0x0000200000000000L});
    public static final BitSet FOLLOW_45_in_ruleQueryEvaluatorMdsl3500 = new BitSet(new long[]{0x0000040000000000L});
    public static final BitSet FOLLOW_42_in_ruleQueryEvaluatorMdsl3512 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_ruleClassDescriptorMdsl_in_ruleQueryEvaluatorMdsl3533 = new BitSet(new long[]{0x0000C00040020000L});
    public static final BitSet FOLLOW_46_in_ruleQueryEvaluatorMdsl3546 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_rulePropertyTypeMdsl_in_ruleQueryEvaluatorMdsl3567 = new BitSet(new long[]{0x0000800840020000L});
    public static final BitSet FOLLOW_35_in_ruleQueryEvaluatorMdsl3580 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_rulePropertyTypeMdsl_in_ruleQueryEvaluatorMdsl3601 = new BitSet(new long[]{0x0000800840020000L});
    public static final BitSet FOLLOW_47_in_ruleQueryEvaluatorMdsl3618 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_ruleClassDescriptorMdsl_in_ruleQueryEvaluatorMdsl3639 = new BitSet(new long[]{0x0000000040020000L});
    public static final BitSet FOLLOW_17_in_ruleQueryEvaluatorMdsl3654 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_STRING_in_ruleQueryEvaluatorMdsl3671 = new BitSet(new long[]{0x0000000040000000L});
    public static final BitSet FOLLOW_30_in_ruleQueryEvaluatorMdsl3690 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleWidgetType_in_entryRuleWidgetType3726 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleWidgetType3736 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_48_in_ruleWidgetType3773 = new BitSet(new long[]{0x0000000000400000L});
    public static final BitSet FOLLOW_22_in_ruleWidgetType3785 = new BitSet(new long[]{0x0002000000000000L});
    public static final BitSet FOLLOW_49_in_ruleWidgetType3797 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleWidgetType3814 = new BitSet(new long[]{0x0004000000000000L});
    public static final BitSet FOLLOW_50_in_ruleWidgetType3831 = new BitSet(new long[]{0x0000000000000000L,0x1FFC000000000000L});
    public static final BitSet FOLLOW_ruleWIDGET_CATEGORY_MDSL_in_ruleWidgetType3852 = new BitSet(new long[]{0x0000000000002000L});
    public static final BitSet FOLLOW_13_in_ruleWidgetType3864 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_STRING_in_ruleWidgetType3881 = new BitSet(new long[]{0x0008000000000000L});
    public static final BitSet FOLLOW_51_in_ruleWidgetType3898 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_ruleClassDescriptorMdsl_in_ruleWidgetType3919 = new BitSet(new long[]{0x0000000040020000L});
    public static final BitSet FOLLOW_17_in_ruleWidgetType3932 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_STRING_in_ruleWidgetType3949 = new BitSet(new long[]{0x0000000040000000L});
    public static final BitSet FOLLOW_30_in_ruleWidgetType3968 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleUITabMdsl_in_entryRuleUITabMdsl4004 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleUITabMdsl4014 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_52_in_ruleUITabMdsl4051 = new BitSet(new long[]{0x0020000000000000L});
    public static final BitSet FOLLOW_53_in_ruleUITabMdsl4063 = new BitSet(new long[]{0x0000000000400000L});
    public static final BitSet FOLLOW_22_in_ruleUITabMdsl4075 = new BitSet(new long[]{0x0040000000000000L});
    public static final BitSet FOLLOW_54_in_ruleUITabMdsl4087 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleUITabMdsl4104 = new BitSet(new long[]{0x0080000000002000L});
    public static final BitSet FOLLOW_55_in_ruleUITabMdsl4127 = new BitSet(new long[]{0x0000000000002000L});
    public static final BitSet FOLLOW_13_in_ruleUITabMdsl4153 = new BitSet(new long[]{0x0000000000000010L,0x0000080000000000L});
    public static final BitSet FOLLOW_ruleFormatExpr_in_ruleUITabMdsl4174 = new BitSet(new long[]{0x0000000040020000L});
    public static final BitSet FOLLOW_17_in_ruleUITabMdsl4187 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_STRING_in_ruleUITabMdsl4204 = new BitSet(new long[]{0x0000000040000000L});
    public static final BitSet FOLLOW_30_in_ruleUITabMdsl4223 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleLayerMdsl_in_entryRuleLayerMdsl4259 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleLayerMdsl4269 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_56_in_ruleLayerMdsl4306 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleLayerMdsl4323 = new BitSet(new long[]{0x0000000000400000L});
    public static final BitSet FOLLOW_22_in_ruleLayerMdsl4340 = new BitSet(new long[]{0x0080000000002000L});
    public static final BitSet FOLLOW_55_in_ruleLayerMdsl4358 = new BitSet(new long[]{0x0000000000002000L});
    public static final BitSet FOLLOW_13_in_ruleLayerMdsl4384 = new BitSet(new long[]{0x0000000000000010L,0x0000080000000000L});
    public static final BitSet FOLLOW_ruleFormatExpr_in_ruleLayerMdsl4405 = new BitSet(new long[]{0x0200000040020000L});
    public static final BitSet FOLLOW_17_in_ruleLayerMdsl4418 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_STRING_in_ruleLayerMdsl4435 = new BitSet(new long[]{0x0200000040000000L});
    public static final BitSet FOLLOW_57_in_ruleLayerMdsl4455 = new BitSet(new long[]{0x0400000000000000L});
    public static final BitSet FOLLOW_58_in_ruleLayerMdsl4467 = new BitSet(new long[]{0x0000000000400000L});
    public static final BitSet FOLLOW_22_in_ruleLayerMdsl4479 = new BitSet(new long[]{0x0100000040000000L});
    public static final BitSet FOLLOW_ruleLayerMdsl_in_ruleLayerMdsl4500 = new BitSet(new long[]{0x0100000040000000L});
    public static final BitSet FOLLOW_30_in_ruleLayerMdsl4513 = new BitSet(new long[]{0x0000000040000000L});
    public static final BitSet FOLLOW_30_in_ruleLayerMdsl4527 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleTypeConfigurationMdsl_in_entryRuleTypeConfigurationMdsl4563 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleTypeConfigurationMdsl4573 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_59_in_ruleTypeConfigurationMdsl4616 = new BitSet(new long[]{0x1000000000000000L});
    public static final BitSet FOLLOW_60_in_ruleTypeConfigurationMdsl4642 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleTypeConfigurationMdsl4659 = new BitSet(new long[]{0x2000000000400000L});
    public static final BitSet FOLLOW_61_in_ruleTypeConfigurationMdsl4677 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleTypeConfigurationMdsl4697 = new BitSet(new long[]{0x0000000000400000L});
    public static final BitSet FOLLOW_22_in_ruleTypeConfigurationMdsl4711 = new BitSet(new long[]{0xC080000000000000L,0x0000000000000001L});
    public static final BitSet FOLLOW_55_in_ruleTypeConfigurationMdsl4730 = new BitSet(new long[]{0x4000000000000000L});
    public static final BitSet FOLLOW_62_in_ruleTypeConfigurationMdsl4756 = new BitSet(new long[]{0x0000000000000010L,0x0000080000000000L});
    public static final BitSet FOLLOW_ruleFormatExpr_in_ruleTypeConfigurationMdsl4777 = new BitSet(new long[]{0x8000000000000000L,0x0000000000000001L});
    public static final BitSet FOLLOW_63_in_ruleTypeConfigurationMdsl4798 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleTypeConfigurationMdsl4831 = new BitSet(new long[]{0x0000000800000000L,0x0000000000000001L});
    public static final BitSet FOLLOW_35_in_ruleTypeConfigurationMdsl4844 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleTypeConfigurationMdsl4864 = new BitSet(new long[]{0x0000000800000000L,0x0000000000000001L});
    public static final BitSet FOLLOW_64_in_ruleTypeConfigurationMdsl4880 = new BitSet(new long[]{0x0000000040000000L,0x0000000000000046L});
    public static final BitSet FOLLOW_ruleTypeConfigurationTemplateElement_in_ruleTypeConfigurationMdsl4901 = new BitSet(new long[]{0x0000000040000000L,0x0000000000000046L});
    public static final BitSet FOLLOW_65_in_ruleTypeConfigurationMdsl4921 = new BitSet(new long[]{0x0000000040000020L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleTypeConfigurationMdsl4954 = new BitSet(new long[]{0x0000000040000020L});
    public static final BitSet FOLLOW_30_in_ruleTypeConfigurationMdsl4969 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleTypeConfigurationTemplateElement_in_entryRuleTypeConfigurationTemplateElement5005 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleTypeConfigurationTemplateElement5015 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleWidgetConfigurationMdsl_in_ruleTypeConfigurationTemplateElement5062 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleIncludeTemplateElementMdsl_in_ruleTypeConfigurationTemplateElement5089 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleIncludeTemplateElementMdsl_in_entryRuleIncludeTemplateElementMdsl5124 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleIncludeTemplateElementMdsl5134 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_66_in_ruleIncludeTemplateElementMdsl5171 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleIncludeTemplateElementMdsl5188 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000008L});
    public static final BitSet FOLLOW_67_in_ruleIncludeTemplateElementMdsl5205 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleIncludeTemplateElementMdsl5225 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000010L});
    public static final BitSet FOLLOW_68_in_ruleIncludeTemplateElementMdsl5237 = new BitSet(new long[]{0x0000000000000030L,0x00000A9C00000000L});
    public static final BitSet FOLLOW_ruleQueryUsage_in_ruleIncludeTemplateElementMdsl5258 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleValueConverter_in_entryRuleValueConverter5294 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleValueConverter5304 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleBasicTypeValueConverter_in_ruleValueConverter5351 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleQueryBasedValueConverter_in_ruleValueConverter5378 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleQueryBasedValueConverter_in_entryRuleQueryBasedValueConverter5413 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleQueryBasedValueConverter5423 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_69_in_ruleQueryBasedValueConverter5460 = new BitSet(new long[]{0x0000000000000030L,0x00000A9C00000000L});
    public static final BitSet FOLLOW_ruleQueryUsage_in_ruleQueryBasedValueConverter5481 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleBasicTypeValueConverter_in_entryRuleBasicTypeValueConverter5517 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleBasicTypeValueConverter5527 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleVALUE_CONVERTER_CATEGORY_MDSL_in_ruleBasicTypeValueConverter5573 = new BitSet(new long[]{0x0000000008000002L});
    public static final BitSet FOLLOW_27_in_ruleBasicTypeValueConverter5586 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_STRING_in_ruleBasicTypeValueConverter5603 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleWidgetConfigurationMdsl_in_entryRuleWidgetConfigurationMdsl5646 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleWidgetConfigurationMdsl5656 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_70_in_ruleWidgetConfigurationMdsl5693 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleWidgetConfigurationMdsl5710 = new BitSet(new long[]{0x0080000000022000L,0x0000000000000180L});
    public static final BitSet FOLLOW_17_in_ruleWidgetConfigurationMdsl5728 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_STRING_in_ruleWidgetConfigurationMdsl5745 = new BitSet(new long[]{0x0080000000002000L,0x0000000000000180L});
    public static final BitSet FOLLOW_71_in_ruleWidgetConfigurationMdsl5765 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleWidgetConfigurationMdsl5785 = new BitSet(new long[]{0x0080000000002000L,0x0000000000000100L});
    public static final BitSet FOLLOW_72_in_ruleWidgetConfigurationMdsl5800 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleWidgetConfigurationMdsl5820 = new BitSet(new long[]{0x0080000800002000L});
    public static final BitSet FOLLOW_35_in_ruleWidgetConfigurationMdsl5833 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleWidgetConfigurationMdsl5853 = new BitSet(new long[]{0x0080000800002000L});
    public static final BitSet FOLLOW_55_in_ruleWidgetConfigurationMdsl5875 = new BitSet(new long[]{0x0000000000002000L});
    public static final BitSet FOLLOW_13_in_ruleWidgetConfigurationMdsl5901 = new BitSet(new long[]{0x0000000000000010L,0x0000080000000000L});
    public static final BitSet FOLLOW_ruleFormatExpr_in_ruleWidgetConfigurationMdsl5922 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000200L});
    public static final BitSet FOLLOW_73_in_ruleWidgetConfigurationMdsl5934 = new BitSet(new long[]{0x0000000000000000L,0x1FFC000000000000L});
    public static final BitSet FOLLOW_ruleWIDGET_CATEGORY_MDSL_in_ruleWidgetConfigurationMdsl5955 = new BitSet(new long[]{0x0080010008000002L,0x00000000000FFC10L});
    public static final BitSet FOLLOW_27_in_ruleWidgetConfigurationMdsl5968 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleWidgetConfigurationMdsl5988 = new BitSet(new long[]{0x0080010000000002L,0x00000000000FFC10L});
    public static final BitSet FOLLOW_ruleXtextLanguageReference_in_ruleWidgetConfigurationMdsl6011 = new BitSet(new long[]{0x0080000000000002L,0x00000000000FFC10L});
    public static final BitSet FOLLOW_74_in_ruleWidgetConfigurationMdsl6026 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_75_in_ruleWidgetConfigurationMdsl6044 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleWidgetConfigurationMdsl6065 = new BitSet(new long[]{0x0080000000000002L,0x00000000000FF010L});
    public static final BitSet FOLLOW_76_in_ruleWidgetConfigurationMdsl6125 = new BitSet(new long[]{0x0000000000000030L,0x0000089C00000000L});
    public static final BitSet FOLLOW_ruleQuery_in_ruleWidgetConfigurationMdsl6146 = new BitSet(new long[]{0x0080000000000002L,0x00000000000FF010L});
    public static final BitSet FOLLOW_77_in_ruleWidgetConfigurationMdsl6214 = new BitSet(new long[]{0x0000000000000030L,0x0000089C00000000L});
    public static final BitSet FOLLOW_ruleQuery_in_ruleWidgetConfigurationMdsl6235 = new BitSet(new long[]{0x0080000000000002L,0x00000000000FF010L});
    public static final BitSet FOLLOW_68_in_ruleWidgetConfigurationMdsl6289 = new BitSet(new long[]{0x0000000000000030L,0x00000A9C00000000L});
    public static final BitSet FOLLOW_ruleQueryUsage_in_ruleWidgetConfigurationMdsl6310 = new BitSet(new long[]{0x0080000000000002L,0x00000000000FC000L});
    public static final BitSet FOLLOW_78_in_ruleWidgetConfigurationMdsl6325 = new BitSet(new long[]{0x0000000000000000L,0x0003F00000000020L});
    public static final BitSet FOLLOW_ruleValueConverter_in_ruleWidgetConfigurationMdsl6346 = new BitSet(new long[]{0x0080000000000002L,0x00000000000F8000L});
    public static final BitSet FOLLOW_79_in_ruleWidgetConfigurationMdsl6361 = new BitSet(new long[]{0x0080000000000002L,0x00000000001F0000L});
    public static final BitSet FOLLOW_ruleValidatorMdsl_in_ruleWidgetConfigurationMdsl6382 = new BitSet(new long[]{0x0080000000000002L,0x00000000001F0000L});
    public static final BitSet FOLLOW_55_in_ruleWidgetConfigurationMdsl6404 = new BitSet(new long[]{0x0000000000000000L,0x0000000000010000L});
    public static final BitSet FOLLOW_80_in_ruleWidgetConfigurationMdsl6430 = new BitSet(new long[]{0x0000000000000010L,0x0000080000000000L});
    public static final BitSet FOLLOW_ruleFormatExpr_in_ruleWidgetConfigurationMdsl6451 = new BitSet(new long[]{0x0080000000000002L,0x00000000000E0000L});
    public static final BitSet FOLLOW_81_in_ruleWidgetConfigurationMdsl6466 = new BitSet(new long[]{0x0000000000000030L,0x00000A9C00000000L});
    public static final BitSet FOLLOW_ruleQueryUsage_in_ruleWidgetConfigurationMdsl6487 = new BitSet(new long[]{0x0080000000000002L,0x00000000000C0000L});
    public static final BitSet FOLLOW_55_in_ruleWidgetConfigurationMdsl6508 = new BitSet(new long[]{0x0000000000000000L,0x0000000000040000L});
    public static final BitSet FOLLOW_82_in_ruleWidgetConfigurationMdsl6534 = new BitSet(new long[]{0x0000000000000010L,0x0000080000000000L});
    public static final BitSet FOLLOW_ruleFormatExpr_in_ruleWidgetConfigurationMdsl6555 = new BitSet(new long[]{0x0000000000000002L,0x0000000000080000L});
    public static final BitSet FOLLOW_83_in_ruleWidgetConfigurationMdsl6570 = new BitSet(new long[]{0x0000000000000020L,0xE000000000000000L});
    public static final BitSet FOLLOW_ruleCommand_in_ruleWidgetConfigurationMdsl6591 = new BitSet(new long[]{0x0000000800000002L});
    public static final BitSet FOLLOW_35_in_ruleWidgetConfigurationMdsl6604 = new BitSet(new long[]{0x0000000000000020L,0xE000000000000000L});
    public static final BitSet FOLLOW_ruleCommand_in_ruleWidgetConfigurationMdsl6625 = new BitSet(new long[]{0x0000000800000002L});
    public static final BitSet FOLLOW_ruleValidatorMdsl_in_entryRuleValidatorMdsl6665 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleValidatorMdsl6675 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_84_in_ruleValidatorMdsl6712 = new BitSet(new long[]{0x0000000000000030L,0x00000A9C00000000L});
    public static final BitSet FOLLOW_ruleQueryUsage_in_ruleValidatorMdsl6733 = new BitSet(new long[]{0x0080000000000000L,0x0000000000200000L});
    public static final BitSet FOLLOW_55_in_ruleValidatorMdsl6751 = new BitSet(new long[]{0x0000000000000000L,0x0000000000200000L});
    public static final BitSet FOLLOW_85_in_ruleValidatorMdsl6777 = new BitSet(new long[]{0x0000000000000010L,0x0000080000000000L});
    public static final BitSet FOLLOW_ruleFormatExpr_in_ruleValidatorMdsl6798 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleCommand_in_entryRuleCommand6834 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleCommand6844 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleCommandDefinitionMdsl_in_ruleCommand6891 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleCommandRefMdsl_in_ruleCommand6918 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleCommandDeclaration_in_entryRuleCommandDeclaration6953 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleCommandDeclaration6963 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_86_in_ruleCommandDeclaration7000 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleCommandDeclaration7017 = new BitSet(new long[]{0x0000000000400000L});
    public static final BitSet FOLLOW_22_in_ruleCommandDeclaration7034 = new BitSet(new long[]{0x0000000000022000L,0xE000000000000000L});
    public static final BitSet FOLLOW_13_in_ruleCommandDeclaration7047 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_STRING_in_ruleCommandDeclaration7064 = new BitSet(new long[]{0x0000000000020000L,0xE000000000000000L});
    public static final BitSet FOLLOW_17_in_ruleCommandDeclaration7084 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_STRING_in_ruleCommandDeclaration7101 = new BitSet(new long[]{0x0000000000000000L,0xE000000000000000L});
    public static final BitSet FOLLOW_ruleCommandDefinitionMdsl_in_ruleCommandDeclaration7129 = new BitSet(new long[]{0x0000000040000000L});
    public static final BitSet FOLLOW_30_in_ruleCommandDeclaration7141 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleCommandDefinitionMdsl_in_entryRuleCommandDefinitionMdsl7177 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleCommandDefinitionMdsl7187 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleCOMMAND_CATEGORY_MDSL_in_ruleCommandDefinitionMdsl7233 = new BitSet(new long[]{0x0080000000000010L,0x0000080001800000L});
    public static final BitSet FOLLOW_55_in_ruleCommandDefinitionMdsl7252 = new BitSet(new long[]{0x0000000000000010L,0x0000080000000000L});
    public static final BitSet FOLLOW_ruleFormatExpr_in_ruleCommandDefinitionMdsl7287 = new BitSet(new long[]{0x0000000000000000L,0x0000000001800000L});
    public static final BitSet FOLLOW_87_in_ruleCommandDefinitionMdsl7302 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleCommandDefinitionMdsl7322 = new BitSet(new long[]{0x0000000000000000L,0x0000000001000000L});
    public static final BitSet FOLLOW_88_in_ruleCommandDefinitionMdsl7336 = new BitSet(new long[]{0x0000000000000030L,0x0000089C00000000L});
    public static final BitSet FOLLOW_ruleQuery_in_ruleCommandDefinitionMdsl7357 = new BitSet(new long[]{0x0000000000000002L,0x0000000006000000L});
    public static final BitSet FOLLOW_89_in_ruleCommandDefinitionMdsl7370 = new BitSet(new long[]{0x0000000000000002L,0x0000000064000000L});
    public static final BitSet FOLLOW_ruleUICommandMdsl_in_ruleCommandDefinitionMdsl7391 = new BitSet(new long[]{0x0000000000000002L,0x0000000064000000L});
    public static final BitSet FOLLOW_90_in_ruleCommandDefinitionMdsl7407 = new BitSet(new long[]{0x0000000000000002L,0x0000000060000000L});
    public static final BitSet FOLLOW_ruleUICommandMdsl_in_ruleCommandDefinitionMdsl7428 = new BitSet(new long[]{0x0000000000000002L,0x0000000060000000L});
    public static final BitSet FOLLOW_ruleCommandRefMdsl_in_entryRuleCommandRefMdsl7467 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleCommandRefMdsl7477 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleCommandRefMdsl7522 = new BitSet(new long[]{0x0000000000000002L,0x0000000008000000L});
    public static final BitSet FOLLOW_91_in_ruleCommandRefMdsl7535 = new BitSet(new long[]{0x0080000000000010L,0x0000080000000000L});
    public static final BitSet FOLLOW_55_in_ruleCommandRefMdsl7553 = new BitSet(new long[]{0x0000000000000010L,0x0000080000000000L});
    public static final BitSet FOLLOW_ruleFormatExpr_in_ruleCommandRefMdsl7588 = new BitSet(new long[]{0x0000000000000000L,0x0000000010000000L});
    public static final BitSet FOLLOW_92_in_ruleCommandRefMdsl7600 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleUICommandMdsl_in_entryRuleUICommandMdsl7638 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleUICommandMdsl7648 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleReloadWidgetsUICommand_in_ruleUICommandMdsl7695 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleReloadViewUICommand_in_ruleUICommandMdsl7722 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleDisplayViewUICommand_in_ruleUICommandMdsl7749 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleDisplayViewUICommand_in_entryRuleDisplayViewUICommand7784 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleDisplayViewUICommand7794 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_93_in_ruleDisplayViewUICommand7831 = new BitSet(new long[]{0x2000000000000002L});
    public static final BitSet FOLLOW_61_in_ruleDisplayViewUICommand7844 = new BitSet(new long[]{0x0000000000000030L,0x00000A9C00000000L});
    public static final BitSet FOLLOW_ruleQueryUsage_in_ruleDisplayViewUICommand7865 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleReloadViewUICommand_in_entryRuleReloadViewUICommand7903 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleReloadViewUICommand7913 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_94_in_ruleReloadViewUICommand7959 = new BitSet(new long[]{0x0000000000000000L,0x0000000080000000L});
    public static final BitSet FOLLOW_95_in_ruleReloadViewUICommand7971 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleReloadWidgetsUICommand_in_entryRuleReloadWidgetsUICommand8007 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleReloadWidgetsUICommand8017 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_94_in_ruleReloadWidgetsUICommand8054 = new BitSet(new long[]{0x0000000000000000L,0x0000000100000000L});
    public static final BitSet FOLLOW_96_in_ruleReloadWidgetsUICommand8066 = new BitSet(new long[]{0x0000000000000022L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleReloadWidgetsUICommand8086 = new BitSet(new long[]{0x0000000000000022L});
    public static final BitSet FOLLOW_ruleQueryUsage_in_entryRuleQueryUsage8123 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleQueryUsage8133 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleQuery_in_ruleQueryUsage8180 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleQueryChain_in_ruleQueryUsage8207 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleQuery_in_entryRuleQuery8242 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleQuery8252 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleQueryDefinitionMdsl_in_ruleQuery8299 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleQueryRefMdsl_in_ruleQuery8326 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleQueryDeclaration_in_entryRuleQueryDeclaration8361 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleQueryDeclaration8371 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_97_in_ruleQueryDeclaration8408 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleQueryDeclaration8425 = new BitSet(new long[]{0x0000000000400000L});
    public static final BitSet FOLLOW_22_in_ruleQueryDeclaration8442 = new BitSet(new long[]{0x0000000000022010L,0x0000089C00000000L});
    public static final BitSet FOLLOW_13_in_ruleQueryDeclaration8455 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_STRING_in_ruleQueryDeclaration8472 = new BitSet(new long[]{0x0000000000020010L,0x0000089C00000000L});
    public static final BitSet FOLLOW_17_in_ruleQueryDeclaration8492 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_STRING_in_ruleQueryDeclaration8509 = new BitSet(new long[]{0x0000000000000010L,0x0000089C00000000L});
    public static final BitSet FOLLOW_ruleQueryDefinitionMdsl_in_ruleQueryDeclaration8537 = new BitSet(new long[]{0x0000000040000000L});
    public static final BitSet FOLLOW_30_in_ruleQueryDeclaration8549 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleQueryDefinitionMdsl_in_entryRuleQueryDefinitionMdsl8585 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleQueryDefinitionMdsl8595 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_98_in_ruleQueryDefinitionMdsl8633 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleQueryDefinitionMdsl8653 = new BitSet(new long[]{0x0000000000000010L,0x0000089C00000000L});
    public static final BitSet FOLLOW_99_in_ruleQueryDefinitionMdsl8668 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleQueryDefinitionMdsl8688 = new BitSet(new long[]{0x0000000000000010L,0x0000089C00000000L});
    public static final BitSet FOLLOW_100_in_ruleQueryDefinitionMdsl8703 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_STRING_in_ruleQueryDefinitionMdsl8720 = new BitSet(new long[]{0x0000000000000010L,0x0000089C00000000L});
    public static final BitSet FOLLOW_ruleQueryBody_in_ruleQueryDefinitionMdsl8749 = new BitSet(new long[]{0x0000000008000002L,0x0000006000000000L});
    public static final BitSet FOLLOW_ruleExternalQueryCallMdsl_in_ruleQueryDefinitionMdsl8776 = new BitSet(new long[]{0x0000000008000002L,0x0000006000000000L});
    public static final BitSet FOLLOW_27_in_ruleQueryDefinitionMdsl8790 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleQueryDefinitionMdsl8810 = new BitSet(new long[]{0x0000000000000002L,0x0000006000000000L});
    public static final BitSet FOLLOW_101_in_ruleQueryDefinitionMdsl8825 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_rulePropertyMdsl_in_ruleQueryDefinitionMdsl8846 = new BitSet(new long[]{0x0000000800000002L,0x0000004000000000L});
    public static final BitSet FOLLOW_35_in_ruleQueryDefinitionMdsl8859 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_rulePropertyMdsl_in_ruleQueryDefinitionMdsl8880 = new BitSet(new long[]{0x0000000800000002L,0x0000004000000000L});
    public static final BitSet FOLLOW_102_in_ruleQueryDefinitionMdsl8897 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000000000007L});
    public static final BitSet FOLLOW_ruleQUERY_OPTIMISATION_LEVEL_in_ruleQueryDefinitionMdsl8918 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleQueryFragment_in_entryRuleQueryFragment8956 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleQueryFragment8966 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleLiteralQueryFragment_in_ruleQueryFragment9013 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleTextMacroRef_in_ruleQueryFragment9040 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleLiteralQueryFragment_in_entryRuleLiteralQueryFragment9075 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleLiteralQueryFragment9085 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_STRING_in_ruleLiteralQueryFragment9126 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleQueryBody_in_entryRuleQueryBody9166 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleQueryBody9176 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleQueryFragment_in_ruleQueryBody9222 = new BitSet(new long[]{0x0000000000008002L});
    public static final BitSet FOLLOW_15_in_ruleQueryBody9235 = new BitSet(new long[]{0x0000000000000010L,0x0000080000000000L});
    public static final BitSet FOLLOW_ruleQueryFragment_in_ruleQueryBody9256 = new BitSet(new long[]{0x0000000000008002L});
    public static final BitSet FOLLOW_ruleQueryRefMdsl_in_entryRuleQueryRefMdsl9294 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleQueryRefMdsl9304 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleQueryRefMdsl9348 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleExternalQueryCallMdsl_in_entryRuleExternalQueryCallMdsl9383 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleExternalQueryCallMdsl9393 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_103_in_ruleExternalQueryCallMdsl9430 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleExternalQueryCallMdsl9450 = new BitSet(new long[]{0x0000000000000000L,0x0000010000000000L});
    public static final BitSet FOLLOW_104_in_ruleExternalQueryCallMdsl9462 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleQueryChain_in_entryRuleQueryChain9498 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleQueryChain9508 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_105_in_ruleQueryChain9545 = new BitSet(new long[]{0x0000000000400000L});
    public static final BitSet FOLLOW_22_in_ruleQueryChain9557 = new BitSet(new long[]{0x0000000000000030L,0x0000089C00000000L});
    public static final BitSet FOLLOW_ruleQuery_in_ruleQueryChain9578 = new BitSet(new long[]{0x0000000840000030L,0x0000089C00000000L});
    public static final BitSet FOLLOW_35_in_ruleQueryChain9592 = new BitSet(new long[]{0x0000000000000030L,0x0000089C00000000L});
    public static final BitSet FOLLOW_ruleQuery_in_ruleQueryChain9613 = new BitSet(new long[]{0x0000000840000000L});
    public static final BitSet FOLLOW_30_in_ruleQueryChain9627 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleFormatExpr_in_entryRuleFormatExpr9663 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleFormatExpr9673 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleFormatExprFragment_in_ruleFormatExpr9719 = new BitSet(new long[]{0x0000000000008002L});
    public static final BitSet FOLLOW_15_in_ruleFormatExpr9732 = new BitSet(new long[]{0x0000000000000010L,0x0000080000000000L});
    public static final BitSet FOLLOW_ruleFormatExprFragment_in_ruleFormatExpr9753 = new BitSet(new long[]{0x0000000000008002L});
    public static final BitSet FOLLOW_ruleFormatExprFragment_in_entryRuleFormatExprFragment9791 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleFormatExprFragment9801 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleLiteralFormatExprFragment_in_ruleFormatExprFragment9848 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleTextMacroRef_in_ruleFormatExprFragment9875 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleLiteralFormatExprFragment_in_entryRuleLiteralFormatExprFragment9910 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleLiteralFormatExprFragment9920 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_STRING_in_ruleLiteralFormatExprFragment9961 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleTextMacro_in_entryRuleTextMacro10001 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleTextMacro10011 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_106_in_ruleTextMacro10048 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleTextMacro10065 = new BitSet(new long[]{0x0000000000400000L});
    public static final BitSet FOLLOW_22_in_ruleTextMacro10082 = new BitSet(new long[]{0x0000000000022000L,0x0000000000000010L});
    public static final BitSet FOLLOW_13_in_ruleTextMacro10095 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_STRING_in_ruleTextMacro10112 = new BitSet(new long[]{0x0000000000020000L,0x0000000000000010L});
    public static final BitSet FOLLOW_17_in_ruleTextMacro10132 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_STRING_in_ruleTextMacro10149 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000010L});
    public static final BitSet FOLLOW_68_in_ruleTextMacro10168 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_STRING_in_ruleTextMacro10185 = new BitSet(new long[]{0x0000000040000000L});
    public static final BitSet FOLLOW_30_in_ruleTextMacro10202 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleTextMacroRef_in_entryRuleTextMacroRef10238 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleTextMacroRef10248 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_107_in_ruleTextMacroRef10285 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleTextMacroRef10305 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_108_in_ruleVALUE_CONVERTER_CATEGORY_MDSL10355 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_109_in_ruleVALUE_CONVERTER_CATEGORY_MDSL10372 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_110_in_ruleVALUE_CONVERTER_CATEGORY_MDSL10389 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_111_in_ruleVALUE_CONVERTER_CATEGORY_MDSL10406 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_112_in_ruleVALUE_CONVERTER_CATEGORY_MDSL10423 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_113_in_ruleVALUE_CONVERTER_CATEGORY_MDSL10440 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_114_in_ruleWIDGET_CATEGORY_MDSL10485 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_115_in_ruleWIDGET_CATEGORY_MDSL10502 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_116_in_ruleWIDGET_CATEGORY_MDSL10519 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_117_in_ruleWIDGET_CATEGORY_MDSL10536 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_118_in_ruleWIDGET_CATEGORY_MDSL10553 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_119_in_ruleWIDGET_CATEGORY_MDSL10570 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_120_in_ruleWIDGET_CATEGORY_MDSL10587 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_121_in_ruleWIDGET_CATEGORY_MDSL10604 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_122_in_ruleWIDGET_CATEGORY_MDSL10621 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_123_in_ruleWIDGET_CATEGORY_MDSL10638 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_124_in_ruleWIDGET_CATEGORY_MDSL10655 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_125_in_ruleCOMMAND_CATEGORY_MDSL10700 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_126_in_ruleCOMMAND_CATEGORY_MDSL10717 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_127_in_ruleCOMMAND_CATEGORY_MDSL10734 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_128_in_ruleQUERY_OPTIMISATION_LEVEL10779 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_129_in_ruleQUERY_OPTIMISATION_LEVEL10796 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_130_in_ruleQUERY_OPTIMISATION_LEVEL10813 = new BitSet(new long[]{0x0000000000000002L});

}
