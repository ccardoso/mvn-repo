package healthy.rim;

import healthy.rim.type.BooleanAdapter;
import healthy.rim.type.CD;
import healthy.rim.type.PQ;
import java.util.Objects;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

/**
 * ActRelationship is a directed association between a source Act and a target
 * Act. An ActRelationship on the same source Act are called the "outbound" act
 * relationships of that Act. ActRelationships on the same target Act are called
 * the "inbound" relationships of that Act. The meaning and purpose of an
 * ActRelationship is specified in the ActRelationship.typeCode attribute.
 * <p/>
 * Examples: 1) An electrolyte observation panel may have sodium, potassium, pH,
 * and bicarbonate observations as components. The composite electrolyte panel
 * would then have 4 outbound ActRelationships of type "has component".
 * <p/>
 * 2) The electrolyte panel event has been performed in fulfilment of an
 * observation order. The electrolyte panel event has an outbound
 * ActRelationship of type "fulfils" with the order as target.
 * <p/>
 * 3) A Procedure "cholecystectomy" may be performed for the reason of an
 * Observation of "cholelithiasis". The procedure has an outbound
 * ActRelationship of type "has reason" to the cholelithiasis observation.
 * <p/>
 * Discussion: Consider every ActRelationship instance an arrow with a point
 * (headed to the target) and a butt (coming from the source). The functions
 * (sometimes called "roles") that source and target Acts play in that
 * association are defined for each ActRelationship type differently. For
 * instance in a composition relationship, the source is the composite and the
 * target is the component. In a reason-relationship the source is any Act and
 * the target is the reason or indication for the source-Act.
 * <p/>
 * The relationships associated with an Act are considered properties of the
 * source act object. This means that the author of an Act-instance is also
 * considered the author of all of the act relationships that have this Act as
 * their source. There are no exceptions to this rule.
 * <p/>
 * See ActRelationship.typeCode for more overview of the different kinds of
 * ActRelationships.
 * <p/>
 * The ActRelationship class is used to construct action plans and to represent
 * clinical reasoning or judgements about action relationships. Prior actions
 * can be linked as the reasons for more recent actions. Supporting evidence can
 * be linked with current clinical hypotheses. Problem lists and other networks
 * of related judgements about clinical events are represented by the
 * ActRelationship link.
 * <p/>
 * One of the most commonly used ActRelationship types is "has component" to
 * describe the composition and de-composition of Acts. The relationship type
 * allows specifying detail of Acts to varying degrees.
 * <p/>
 * The composition relationship can group actions into "batteries," e.g., LYTES,
 * CHEM12, or CBC, where multiple routine laboratory tests are ordered as a
 * group. Some groupings, such as CHEM12, appear more arbitrary; others, such as
 * blood pressure, seem to naturally consist of systolic and diastolic pressure.
 * <p/>
 * The composition relationships can be arranged in a sequence to form temporal
 * and conditional (non-temporal) action plans (e.g., care plan, critical path,
 * clinical trials protocol, drug treatment protocols). There is a group of
 * attributes in both Act and ActRelationship that we refer to as the "work-flow
 * Control suite of attributes", and which allow the detailed specification of
 * executable action plans. These attributes are:
 * <p/>
 * ActRelationship.sequenceNumber arranges the components of an Act as a
 * sequence or as concurrent collections of components, expressing logical
 * branches as well as parallel tasks (tasks carried out at the same time). The
 * ActRelationship attributes splitCode and joinCode control how branches are
 * selected or executable in parallel.
 * <p/>
 * Act.activityTime and ActRelationship.pauseQty allow one to explicitly time an
 * action plan. Act.repeatNumber allows specifying act to repeat (loop).
 * <p/>
 * The ActRelationship type has-precondition allows plan steps to be conditional
 * on the status or outcome of previous actions. The
 * ActRelationhsip.checkpointCode specifies when pre-conditions of acts are
 * tested during the flow of control.
 * <p/>
 * The composition ActRelationship allows these constructs to be organised in
 * multiple layers of nesting to fully support work-flow management. This
 * nesting and the work-flow control attributes are designed in analogy to a
 * block-structured programming language with support for concurrency (fork,
 * join, interrupts), and without "goto" statements. It is important to note
 * that ALL plans are established through sequencing components (steps) in a
 * composite act (block) as can be depicted in "Nassi-Schneiderman" diagrams
 * (also known as "Chap Charts" or "Structograms"), not by chain-linking acts as
 * in a flowchart diagram.
 * <p/>
 * With the composition relationship, the detail of Acts can be revealed to
 * different levels for different purposes, without the structure of the Act
 * hierarchy needing to be rearranged. This allows supporting multiple
 * viewpoints on the same business processes. For instance, a billing-viewpoint
 * of a laboratory test battery may be as a single billable act. A clinicians
 * view of the same laboratory test battery is as a set of individual
 * observations, where the ordering among the observations is irrelevant. The
 * laboratory's view of this act will be more detailed, including action plan
 * steps that are never reported to the clinician (e.g., centrifugation,
 * decantation, aliquoting, running certain machines etc.). The laboratory's
 * viewpoint warrants a thorough specification of action plans (that can be
 * automated). During this specification, more and more nested sub-activities
 * will be defined. Still the Act is the same, with varying degrees of detail
 * uncovered in the de-composition relationship.
 * <p/>
 * We described the nature of varying detail saying that Acts are "fractal",
 * ever more decomposable, just as the movements of a robotic arm can be
 * decomposed in many fine control steps.
 *
 * @author Yosvany Llerena Rodríguez <yosvanyllr@gmail.com>
 * @since 14-Oct-2013
 */
@XmlRootElement(name = "ActRelationship")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ActRelationship")
public class ActRelationship implements java.io.Serializable {

    private static final long serialVersionUID = 7022013009924L;
    @XmlElement
    private long internalId;
    /**
     * association 'target' to an Act
     */
    @XmlElement
    private long actTargetInternalId;
    /**
     * A code specifying the meaning and purpose of every ActRelationship
     * instance. Each of its values implies specific constraints to what kinds
     * of Act objects can be related and in which way.
     * <p/>
     * Discussion: The types of act relationships fall under one of 5
     * categories:
     * <p/>
     * 1.) (De)-composition, with composite (source) and component (target).
     * <p/>
     * 2.) Sequel which includes follow-up, fulfilment, instantiation,
     * replacement, transformation, etc. that all have in common that source and
     * target are Acts of essentially the same kind but with variances in mood
     * and other attributes, and where the target exists before the source and
     * the source refers to the target that it links back to.
     * <p/>
     * 3.) Pre-condition, trigger, reason, contraindication, with the
     * conditioned Act at the source and the condition or reason at the target.
     * <p/>
     * 4.) Post-condition, outcome, goal and risk, with the Act at the source
     * having the outcome or goal at the target.
     * <p/>
     * 5.) A host of functional relationships including support, cause,
     * derivation, etc. generalised under the notion of "pertinence".
     */
    @XmlElement
    private String typeCode = "";
    /**
     * An indicator specifying that the ActRelationship.typeCode should be
     * interpreted as if the roles of the source and target Acts were reversed.
     * The inversion indicator is used when the meaning of
     * ActRelationship.typeCode must be reversed.
     */
    @XmlElement(name = "inversionInd", defaultValue = "false")
    @XmlJavaTypeAdapter(BooleanAdapter.class)
    private Boolean inversionInd = false;
    @XmlElement
    private String blockedContextActRelationshipType = "";
    @XmlElement
    private String blockedContextParticipationType = "";
    @XmlElement(name = "actAttributeContextBlockedInd", defaultValue = "false")
    @XmlJavaTypeAdapter(BooleanAdapter.class)
    private Boolean actAttributeContextBlockedInd = false;
    /**
     * A code that specifies how this ActRelationship contributes to the context
     * of the current Act, and whether it may be propagated to descendent Acts
     * whose association allows such propagation (see
     * ActRelationship.contextConductionInd).
     * <p/>
     * Rationale: In the interest of reducing duplication, humans tend to rely
     * on context when interpreting information. For example, when reading a
     * report taken from a folder containing a patient's medical record, the
     * reader will infer that the report deals with the patient, even if there
     * is no direct reference to the patient on the form. However, other pieces
     * of information such as the author of the folder (the hospital that
     * maintains it) may sometimes apply to the contents of the folder (e.g. a
     * report generated by a doctor at the hospital) and other times not (e.g. a
     * copy of a report from another institution). Humans are quite good at
     * making the necessary inferences about what context should be propagated
     * from an item to something within that item. However, incorrect inferences
     * can occur (perhaps the report in the patient's record deals with a
     * relative). Furthermore, computers have substantially more difficulty
     * making such inferences, even though they can be essential for
     * decision-support systems.
     * <p/>
     * Discussion: This attribute allows the clear specification of whether an
     * association adds to the context associated with a particular item (e.g.
     * adding an additional author) or whether it replaces (overrides) part of
     * the context associated with a particular item (e.g. identifying a sole
     * author, independent of the containing item). It also indicates whether
     * the association applies to only this act (non-propagating), or whether it
     * may apply to derived acts as well (propagating).
     * <p/>
     * This attribute is closely linked with
     * ActRelationship.contextConductionInd which determines whether
     * associations that have been marked as propagating will actually be
     * conducted to a child Act. For example, an author participation might be
     * marked as propagating, but still not conducted to a hyperlink to an
     * external document.
     * <p/>
     * If no value or default is specified for this attribute (i.e. it is null),
     * no inference can be made about context. Systems must make their own
     * assumptions on the basis of what data is being represented. (For this
     * reason, HL7 committees are encouraged to specify a default or fixed value
     * for this attribute as part of their designs to ensure consistency of
     * interpretation.)
     * <p/>
     * Examples: An observation event has a patient participation marked
     * "additive, propagating" (AP) and has component observation events linked
     * through act relationships that are marked propagating. This means that
     * the patient participation behaves as a patient participation of those
     * component observation events in addition to the parent observation event.
     * <p/>
     * A composite order is created containing a pharmacy order as well as
     * requests for several lab tests. The composite order has participations
     * for patient and author, and an act relationship to a diagnosis, all
     * marked as "additive, propagating". The "component" association between
     * the composite order and the pharmacy order is marked as conductive
     * (contextConductionInd is TRUE). The pharmacy order has an author
     * participation marked as "additive, non-propagating" (AN), and a reason
     * relationship to a diagnosis, marked as "overriding, propagating" (OP).
     * The order further has a relationship to a dispense event, marked as
     * conductive, and an association to a drug protocol marked as
     * non-conductive (contextConductionInd is FALSE). The meaning would be as
     * follows:
     * <p/>
     * The pharmacy order is interpreted as having the patient from the
     * composite order, and having two authors (the one from the composite
     * order, and the one on the pharmacy order itself). The diagnosis for the
     * pharmacy order would only be the diagnosis specified on the pharmacy
     * order, not the one specified on the composite order. The dispense event
     * would carry the patient from the composite order and the diagnosis from
     * the pharmacy order, but no author. The drug protocol would not be
     * associated with a patient, diagnosis or author.
     */
    @XmlElement
    private String contextControlCode = "";
    /**
     * If true, associations in the parent act are conducted across the
     * ActRelationship to the child act.
     * <p/>
     * Discussion: Only associations that have been added to the context of an
     * Act and are marked "propagating" will be conducted. (See
     * contextControlCode on ActRelationship and Participation)
     * <p/>
     * The identification of an Act as a parent or child (and therefore the
     * direction context will be conducted) is determined by how the association
     * is traversed when it is serialized. The first act to be encountered is
     * considered to be the parent. Context conducts across the ActRelationship
     * to the second (child) Act.
     * <p/>
     * Refer to ActRelationship.contextControlCode for rationale and examples.
     */
    @XmlElement(name = "contextConductionInd", defaultValue = "false")
    @XmlJavaTypeAdapter(BooleanAdapter.class)
    private Boolean contextConductionInd = false;
    /**
     * An integer specifying the relative ordering of this relationship among
     * other like-types relationships having the same source Act.
     * <p/>
     * Discussion: This attribute is part of the workflow control suite of
     * attributes. An action plan is a composite Act with component Acts. In a
     * sequential plan, each component has a sequenceNumber that specifies the
     * ordering of the plan steps. Multiple components with the same
     * sequenceNumber make a branch. Branches can be exclusive (case-switch) or
     * can indicate parallel processes indicated by the splitCode.
     */
    @XmlElement
    private int sequenceNumber;
    /**
     * An integer specifying the relative preference for considering this
     * relationship before other like-typed relationships having the same source
     * Act. Relationships with lower priorityNumber values are considered before
     * and above those with higher values.
     * <p/>
     * Examples: For multiple criteria specifies which criteria are considered
     * before others. For components with the same sequence number, specifies
     * which ones are considered before others. Among alternatives or options
     * that are being chosen by humans, the priorityNumber specifies preference.
     * <p/>
     * Discussion: The ordering may be a total ordering in which all priority
     * numbers are unique or a partial ordering, which assigns the same priority
     * to more than one relationship.
     */
    @XmlElement
    private double priorityNumber;
    /**
     * A quantity of time that should elapse between when an Act is ready for
     * execution and the actual beginning of the execution.
     * <p/>
     * Discussion: This attribute is part of the workflow control suite of
     * attributes. An action plan is a composite Act with component Acts. In a
     * sequential plan, each component has a sequenceNumber that specifies the
     * ordering of the plan steps. Before each step is executed and has
     * preconditions these conditions are tested and if the test is positive,
     * the Act has clearance for execution. At that time the pauseQuantity timer
     * is started and the Act is executed after the pauseQuantity has elapsed.
     */
    @XmlElement(name = "pauseQuantity", type = healthy.rim.type.PQ.class)
    private PQ pauseQuantity = new PQ();
    /**
     * A code specifying when in the course of an Act a precondition for the Act
     * is evaluated (e.g., before the Act starts for the first time, before
     * every repetition, after each repetition but not before the first, or
     * throughout the entire time of the Act).
     * <p/>
     * Discussion: This attribute is part of the workflow control suite of
     * attributes. An action plan is a composite Act with component Acts. In a
     * sequential plan, each component has a sequenceNumber that specifies the
     * ordering of the plan steps. Before each step is executed, those with
     * preconditions have their conditions tested; where the test is positive,
     * the Act has clearance for execution. The repeatNumber may indicate that
     * an Act may be repeatedly executed. The checkpointCode is specifies when
     * the precondition is checked and is analogous to the various conditional
     * statements and loop constructs in programming languages "while-do" vs.
     * "do-while" or "repeat-until" vs. "loop-exit".
     * <p/>
     * For all checkpointCodes, except "end", preconditions are being checked at
     * the time when the preceding step of the plan has terminated and this step
     * would be next in the sequence established by the sequenceNumber
     * attribute.
     * <p>
     * When the checkpointCode for a criterion of a repeatable Act is "end", the
     * criterion is tested only at the end of each repetition of that Act. When
     * the condition holds true, the next repetition is ready for execution.
     * <p/>
     * When the checkpointCode is "entry" the criterion is checked at the
     * beginning of each repetition (if any) whereas "beginning" means the
     * criterion is checked only once before the repetition "loop" starts.
     * <p/>
     * The checkpointCode "through" is special in that it requires the condition
     * to hold throughout the execution of the Act, even throughout a single
     * execution. As soon as the condition turns false, the Act should receive
     * an interrupt event (see Act.interruptibleInd) and will eventually
     * terminate.
     * <p/>
     * The checkpointCode "exit" is only used on a special plan step that
     * represents a loop exit step. This allows an action plan to exit due to a
     * condition tested inside the execution of this plan. Such exit criteria
     * are sequenced with the other plan components using the ActRelationship ->
     * sequenceNumber.
     */
    @XmlElement
    private String checkPointCode = "";
    /**
     * A code specifying how branches in an action plan are selected among other
     * branches.
     * <p/>
     * Discussion: This attribute is part of the workflow control suite of
     * attributes. An action plan is a composite Act with component Acts. In a
     * sequential plan, each component has a sequenceNumber that specifies the
     * ordering of the plan steps. Branches exist when multiple components have
     * the same sequenceNumber. The splitCode specifies whether a branch is
     * executed exclusively (case-switch) or inclusively, i.e., in parallel with
     * other branches.
     * <p/>
     * In addition to exclusive and inclusive split the splitCode specifies how
     * the pre-condition (also known as "guard conditions" on the branch) are
     * evaluated. A guard condition may be evaluated once when the branching
     * step is entered and if the conditions do not hold at that time, the
     * branch is abandoned. Conversely execution of a branch may wait until the
     * guard condition turns true.
     * <p/>
     * In exclusive wait branches, the first branch whose guard conditions turn
     * true will be executed and all other branches abandoned. In inclusive wait
     * branches some branches may already be executed while other branches still
     * wait for their guard conditions to turn true.
     */
    @XmlElement
    private String splitCode = "";
    /**
     * A code specifying how concurrent Acts are resynchronized in a parallel
     * branch construct.
     * <p/>
     * Discussion: This attribute is part of the workflow control suite of
     * attributes. An action plan is a composite Act with component Acts. In a
     * sequential plan, each component has a sequenceNumber that specifies the
     * ordering of the plan steps. Branches exist when multiple components have
     * the same sequenceNumber. Branches are parallel if the splitCode specifies
     * that more than one branch can be executed at the same time. The joinCode
     * then specifies if and how the branches are resynchronized.
     * <p/>
     * The principal re-synchronization actions are (1) the control flow waits
     * for a branch to terminate (wait-branch), (2) the branch that is not yet
     * terminated is aborted (kill-branch), (3) the branch is not
     * re-synchronized at all and continues in parallel (detached branch).
     * <p/>
     * A kill-branch is only executed if there is at least one active wait (or
     * exclusive wait) branch. If there is no other wait branch active, a
     * kill-branch is not started at all (rather than being aborted shortly
     * after it is started). Since a detached branch is unrelated to all other
     * branches, active detached branches do not protect a kill-branch from
     * being aborted.
     */
    @XmlElement
    private String joinCode = "";
    /**
     * An indicator that asserts that the meaning of the link is negated.
     * <p/>
     * Examples: If the relationship without negation specifies that Act A has
     * Act B as a component, then the negation indicator specifies that Act A
     * does not have Act B as a component. If B is a reason for A, then negation
     * means that B is not a reason for A. If B is a pre-condition for A, then
     * negation means that B is not a precondition for A.
     * <p/>
     * Discussion: As the examples show, the use of this attribute is quite
     * limited, notably contrast this with the Act.negationInd that actually
     * requires that the described Act not exist, not be done, etc. whereas the
     * ActRelationship.negationInd merely negates this relationship between
     * source and target act, but does not change the meaning of each Act. This
     * is mostly used for clarifying statements.
     * <p/>
     * Note also the difference between negation and the contrary. A
     * contraindication is the contrary of an indication (reason) but not the
     * negation of the reason. The fact that lower back pain is not a reason to
     * prescribe antibiotics doesn't mean that antibiotics are contraindicated
     * with lower back pain.
     */
    @XmlElement(name = "negationInd", defaultValue = "false")
    @XmlJavaTypeAdapter(BooleanAdapter.class)
    private Boolean negationInd = false;
    /**
     * A code specifying the logical conjunction of the criteria among all the
     * condition-links of Acts (e.g., and, or, exclusive-or).
     * <p/>
     * Constraints: All AND criteria must be true. If OR and AND criteria occur
     * together, one criterion out of the OR-group must be true and all AND
     * criteria must be true also. If XOR criteria occur together with OR and
     * AND criteria, exactly one of the XOR criteria must be true, and at least
     * one of the OR criteria and all AND criteria must be true. In other words,
     * the sets of AND, OR, and XOR criteria are in turn combined by a logical
     * AND operator (all AND criteria and at least one OR criterion and exactly
     * one XOR criterion). To overcome this ordering, Act criteria can be nested
     * in any way necessary.
     */
    @XmlElement
    private String conjunctionCode = "";
    /**
     * A character string name for the input parameter from which the source Act
     * of this ActRelationship derives some of its attributes. The local
     * variable name is bound in the scope of the Act.derivationExpr with its
     * value being an Act selected based on the input parameter specification.
     */
    @XmlElement
    private String localVariableName = "";
    /**
     * This attribute indicates whether or not the source Act is intended to be
     * interpreted independently of the target Act. The indicator cannot prevent
     * an individual or application from separating the Acts, but indicates the
     * author's desire and willingness to attest to the content of the source
     * Act if separated from the target Act. Note that the default for this
     * attribute will typically be "TRUE". Also note that this attribute is
     * orthogonal and unrelated to the RIM's context/inheritance mechanism. If
     * the context of an Act is propagated to nested Acts, it is assumed that
     * those nested Acts are not intended to be interpreted without the
     * propagated context.
     */
    @XmlElement(name = "separatableInd", defaultValue = "false")
    @XmlJavaTypeAdapter(BooleanAdapter.class)
    private Boolean separatableInd = false;
    @XmlElement
    private String subsetCode = "";
    @XmlElement(name = "uncertaintyCode", type = healthy.rim.type.CD.class)
    private CD uncertaintyCode = new CD();

    public ActRelationship() {
    }

    public ActRelationship(long actTargetInternalId) {
        this.actTargetInternalId = actTargetInternalId;
    }

    public ActRelationship(long actTargetInternalId,
            String typeCode, Boolean inversionInd, String blockedContextActRelationshipType,
            String blockedContextParticipationType, Boolean actAttributeContextBlockedInd,
            String contextControlCode, Boolean contextConductionInd, int sequenceNumber,
            double priorityNumber, PQ pauseQuantity, String checkPointCode, String splitCode,
            String joinCode, Boolean negationInd, String conjunctionCode, String localVariableName,
            Boolean separatableInd, String subsetCode, CD uncertaintyCode) {
        this.actTargetInternalId = actTargetInternalId;
        this.typeCode = typeCode;
        this.inversionInd = inversionInd;
        this.blockedContextActRelationshipType = blockedContextActRelationshipType;
        this.blockedContextParticipationType = blockedContextParticipationType;
        this.actAttributeContextBlockedInd = actAttributeContextBlockedInd;
        this.contextControlCode = contextControlCode;
        this.contextConductionInd = contextConductionInd;
        this.sequenceNumber = sequenceNumber;
        this.priorityNumber = priorityNumber;
        this.pauseQuantity = pauseQuantity;
        this.checkPointCode = checkPointCode;
        this.splitCode = splitCode;
        this.joinCode = joinCode;
        this.negationInd = negationInd;
        this.conjunctionCode = conjunctionCode;
        this.localVariableName = localVariableName;
        this.separatableInd = separatableInd;
        this.subsetCode = subsetCode;
        this.uncertaintyCode = uncertaintyCode;
    }

    public long getInternalId() {
        return internalId;
    }

    public void setInternalId(long internalId) {
        this.internalId = internalId;
    }

    /**
     * see {@link ActRelationship#actTargetInternalId}
     *
     * @return actTargetInternalId logn
     */
    public long getActTargetInternalId() {
        return this.actTargetInternalId;
    }

    /**
     * see {@link ActRelationship#actTargetInternalId}
     *
     * @param actTargetInternalId
     */
    public void setActTargetInternalId(long actTargetInternalId) {
        this.actTargetInternalId = actTargetInternalId;
    }

    /**
     * see {@link ActRelationship#typeCode}
     *
     * @return String
     */
    public String getTypeCode() {
        return this.typeCode;
    }

    /**
     * see {@link ActRelationship#typeCode}
     *
     * @param typeCode
     */
    public void setTypeCode(String typeCode) {
        this.typeCode = typeCode;
    }

    /**
     * see {@link ActRelationship#inversionInd}
     *
     * @return Boolean
     */
    public Boolean getInversionInd() {
        return this.inversionInd;
    }

    /**
     * see {@link ActRelationship#inversionInd}
     *
     * @param inversionInd
     */
    public void setInversionInd(Boolean inversionInd) {
        this.inversionInd = inversionInd;
    }

    /**
     * see {@link ActRelationship#blockedContextActRelationshipType}
     *
     * @return String
     */
    public String getBlockedContextActRelationshipType() {
        return this.blockedContextActRelationshipType;
    }

    /**
     * see {@link ActRelationship#blockedContextActRelationshipType}
     *
     * @param blockedContextActRelationshipType
     */
    public void setBlockedContextActRelationshipType(String blockedContextActRelationshipType) {
        this.blockedContextActRelationshipType = blockedContextActRelationshipType;
    }

    /**
     * see {@link ActRelationship#blockedContextParticipationType}
     *
     * @return String
     */
    public String getBlockedContextParticipationType() {
        return this.blockedContextParticipationType;
    }

    /**
     * see {@link ActRelationship#blockedContextParticipationType}
     *
     * @param blockedContextParticipationType
     */
    public void setBlockedContextParticipationType(String blockedContextParticipationType) {
        this.blockedContextParticipationType = blockedContextParticipationType;
    }

    /**
     * see {@link ActRelationship#actAttributeContextBlockedInd}
     *
     * @return boolean
     */
    public Boolean getActAttributeContextBlockedInd() {
        return this.actAttributeContextBlockedInd;
    }

    /**
     * see {@link ActRelationship#actAttributeContextBlockedInd}
     *
     * @param actAttributeContextBlockedInd
     */
    public void setActAttributeContextBlockedInd(Boolean actAttributeContextBlockedInd) {
        this.actAttributeContextBlockedInd = actAttributeContextBlockedInd;
    }

    /**
     * see {@link ActRelationship#contextControlCode}
     *
     * @return String
     */
    public String getContextControlCode() {
        return this.contextControlCode;
    }

    /**
     * see {@link ActRelationship#contextControlCode}
     *
     * @param contextControlCode
     */
    public void setContextControlCode(String contextControlCode) {
        this.contextControlCode = contextControlCode;
    }

    /**
     * see {@link ActRelationship#contextConductionInd}
     *
     * @return boolean
     */
    public Boolean getContextConductionInd() {
        return this.contextConductionInd;
    }

    public void setContextConductionInd(Boolean contextConductionInd) {
        this.contextConductionInd = contextConductionInd;
    }

    /**
     * see {@link ActRelationship#sequenceNumber}
     *
     * @return integer
     */
    public int getSequenceNumber() {
        return this.sequenceNumber;
    }

    /**
     * see {@link ActRelationship#sequenceNumber}
     *
     * @param sequenceNumber
     */
    public void setSequenceNumber(int sequenceNumber) {
        this.sequenceNumber = sequenceNumber;
    }

    /**
     * see {@link ActRelationship#priorityNumber}
     *
     * @return double
     */
    public double getPriorityNumber() {
        return this.priorityNumber;
    }

    /**
     * see {@link ActRelationship#priorityNumber}
     *
     * @param priorityNumber
     */
    public void setPriorityNumber(double priorityNumber) {
        this.priorityNumber = priorityNumber;
    }

    /**
     * see {@link ActRelationship#pauseQuantity}
     *
     * @return PQ
     */
    public PQ getPauseQuantity() {
        return this.pauseQuantity;
    }

    /**
     * see {@link ActRelationship#pauseQuantity}
     *
     * @param pauseQuantity
     */
    public void setPauseQuantity(PQ pauseQuantity) {
        this.pauseQuantity = pauseQuantity;
    }

    /**
     * see {@link ActRelationship#checkPointCode}
     *
     * @return String
     */
    public String getCheckPointCode() {
        return this.checkPointCode;
    }

    /**
     * see {@link ActRelationship#checkPointCode}
     *
     * @param checkPointCode
     */
    public void setCheckPointCode(String checkPointCode) {
        this.checkPointCode = checkPointCode;
    }

    /**
     * see {@link ActRelationship#splitCode}
     *
     * @return String
     */
    public String getSplitCode() {
        return this.splitCode;
    }

    /**
     * see {@link ActRelationship#splitCode}
     *
     * @param splitCode
     */
    public void setSplitCode(String splitCode) {
        this.splitCode = splitCode;
    }

    /**
     * see {@link ActRelationship#joinCode}
     *
     * @return String
     */
    public String getJoinCode() {
        return this.joinCode;
    }

    /**
     * see {@link ActRelationship#joinCode}
     *
     * @param joinCode
     */
    public void setJoinCode(String joinCode) {
        this.joinCode = joinCode;
    }

    /**
     * see {@link ActRelationship#negationInd}
     *
     * @return boolean
     */
    public Boolean getNegationInd() {
        return this.negationInd;
    }

    /**
     * see {@link ActRelationship#negationInd}
     *
     * @param negationInd boolean
     */
    public void setNegationInd(Boolean negationInd) {
        this.negationInd = negationInd;
    }

    /**
     * see {@link ActRelationship#conjunctionCode}
     *
     * @return String
     */
    public String getConjunctionCode() {
        return this.conjunctionCode;
    }

    /**
     * see {@link ActRelationship#conjunctionCode}
     *
     * @param conjunctionCode
     */
    public void setConjunctionCode(String conjunctionCode) {
        this.conjunctionCode = conjunctionCode;
    }

    /**
     * see {@link ActRelationship#localVariableName}
     *
     * @return String
     */
    public String getLocalVariableName() {
        return this.localVariableName;
    }

    /**
     * see {@link ActRelationship#localVariableName}
     *
     * @param localVariableName
     */
    public void setLocalVariableName(String localVariableName) {
        this.localVariableName = localVariableName;
    }

    /**
     * see {@link ActRelationship#separatableInd}
     *
     * @return boolean
     */
    public Boolean getSeparatableInd() {
        return this.separatableInd;
    }

    /**
     * see {@link ActRelationship#separatableInd}
     *
     * @param separatableInd
     */
    public void setSeparatableInd(Boolean separatableInd) {
        this.separatableInd = separatableInd;
    }

    /**
     * see {@link ActRelationship#subsetCode}
     *
     * @return String
     */
    public String getSubsetCode() {
        return this.subsetCode;
    }

    /**
     * see {@link ActRelationship#subsetCode}
     *
     * @param subsetCode
     */
    public void setSubsetCode(String subsetCode) {
        this.subsetCode = subsetCode;
    }

    /**
     * see {@link ActRelationship#uncertaintyCode}
     *
     * @return CD
     */
    public CD getUncertaintyCode() {
        return this.uncertaintyCode;
    }

    /**
     * see {@link ActRelationship#uncertaintyCode}
     *
     * @param uncertaintyCode
     */
    public void setUncertaintyCode(CD uncertaintyCode) {
        this.uncertaintyCode = uncertaintyCode;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 29 * hash + Objects.hashCode(this.internalId);
        hash = 29 * hash + Objects.hashCode(this.actTargetInternalId);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final ActRelationship other = (ActRelationship) obj;
        if (!Objects.equals(this.internalId, other.internalId)) {
            return false;
        }
        if (!Objects.equals(this.actTargetInternalId, other.actTargetInternalId)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "LongRelationship{" + "internalId=" + internalId + ", actTargetInternalId=" + Long.toString(actTargetInternalId) + '}';
    }
}
